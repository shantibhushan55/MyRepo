################################################################################
#   $Header: /ENTITLEMENT/script/service/perf_statistic.awk 1.4 2004-05-08 03:56:23+02 entitlem Exp $
# $Revision: 1.4 $
#   $Author: entitlem $
################################################################################
#
# This awk script parses the regression performance statistics and add all
# parameters set for each request.
#
# Example:
#   cd /opt/entitlem/scm/entitlement_dev/deploy/es_testware_workspace/report/
#   awk -f perf_statistic.awk perf_Test_31102003_141153.csv >perf_report.csv
#
################################################################################

BEGIN{
    FS = ";" ;
    tsetCaseCount = 0;
    requestDir = "../xml/request/";
#    requestDir = "./";
#    testCase[1] = "getContractEntitlement_001B.xml";
    paraPosition["FunctionalLocation"] = 1;
    paraPosition["SvcAgreementID"] = 2;
    paraPosition["RedContractID"] = 3;
    paraPosition["RedGroupSerialNo"] = 4;
    paraPosition["HPCarePackSerialNumber"] = 5;
    paraPosition["SGID"] = 6;
    paraPosition["AMPID"] = 7;
    parameterCount = 7;
}
//{
      testCaseCount += 1;
      testCase[testCaseCount] = $1;
      time[testCaseCount] = $2;
      success[testCaseCount] = $3;
}
END{
    for (i=1;i<=testCaseCount;i++ ){
        filename = requestDir testCase[i] ;
        parameter[i] = extractParameters(filename);
    }
    for (name in paraPosition){
        paraName[paraPosition[name]]=name
    }
    paraHeader = ""
    for (i=1;i<=parameterCount;i++){
	paraHeader = paraHeader ","  paraName[i];
    }

    print "TestCase,ElapsedTime,Success" paraHeader

    for (i=1;i<=testCaseCount;i++ ){
        print testCase[i] "," time[i] ","  success[i] ","  parameter[i];
    }

}

function findRequestStart(filename){
    esRequestFound = 0;
    requestStartFound = 0;

    do {
      readSuccess = getline < filename;

      if ( readSuccess == 1 && esRequestFound && $0 ~ /Request/ ){
          split($0,tags,"[<>]");
          requestTag = tags[2];
	  requestStartFound = 1;
      }

      if ( readSuccess == 1 && $0 ~ /EsRequest/ ){
	  esRequestFound = 1;
      }

    } while ( readSuccess==1 && !requestStartFound );

    return readSuccess;
}

function getNextInputLine(filename){
    readSuccess = getline < filename;

    if (readSuccess == 1 && index($0,requestTag) > 0 ) {
	readSuccess = 0;
    }

    return readSuccess;
}

function cleanParameters(){
    parameters = ""
    for (j=1;j<=parameterCount;j++){
	parameters = parameters " ,";
    }
}

function getParameterPosition(name){
    pos = 0;
    pos = paraPosition[name];
    if ( pos < 1 || pos > parameterCount) {
	parameterCount++;
        pos = parameterCount;
        paraPosition[name] = pos;
    }
    parameters = parameters " ,";
    return pos;
}

function setParameter(name,value){
  #print "Parameter " name  " ist " value
  pos=getParameterPosition(name);

  start="";
  end = substr(parameters,pos*2);

  if (pos > 1){
      start = substr(parameters,1,pos*2-2);
  }

  #print name "=>" pos
  parameters = start value end ;


  return parameters;
}

function extractParameters(filename){
    cleanParameters();
    findRequestStart(filename);
    if (getNextInputLine(filename) == 1){
	do {
	    split($0,tags,"[<>]");

            #print tags[2] "=" tags[3]

            if (tags[2] ~ /^\/.*/ ){
		continue;
	    }
            if (tags[2] ~ /.*\/$/ ){
		continue;
	    }
            if (tags[2] == "" ){
		continue;
	    }
            if (tags[2] ~ /Include[ACODMU]/ ){
		continue;
	    }
            else if (tags[3] == "true"){
		setParameter(tags[2],"X");
	    }
            else if (tags[3] == "false" || tags[3] == "" ) {
		setParameter(tags[2]," ");
	    }
            else if (tags[2] ~ /IdentifierType/ ) {
		setParameter(tags[3],"X");
	    }

	} while (getNextInputLine(filename) == 1);
    }

    return parameters;
}



