#!/bin/ksh
cd ..
export TEST_HOME=`pwd`
export SCRIPT_DIR=${TEST_HOME}/script
cd $SCRIPT_DIR
INSTANCE=es4
APP_NAME=ES10_1
NAME=ODS
ST_VIEW=service_maven
export REGRESSION_INFO_FILE="$TEST_HOME/regression_info"

# this is the major/minor version id of the service
export VERSION_ID=$(grep VERSION_ID $REGRESSION_INFO_FILE | cut -d= -f2)
export ES_APP_NAME=ES$VERSION_ID
export SCENARIO_LIST=$(grep ^SCENARIO_LIST $REGRESSION_INFO_FILE | cut -d= -f2)


MAILTO="ES-OS-FULL-TEAM@groups.int.hpe.com"
#MAILTO="mingh@hp.com"

export TESTWARE_DIR=${TEST_HOME}/testware_env

ORACLE_SID="ODSD"
ORACLE_USER="REGRESS1010"


start_date=`date`
printf "Regression started $start_date for ${ST_VIEW} ${INSTANCE}" | mail -s"SERVICE MAVEN regression started ${ST_VIEW} ${INSTANCE}" ${MAILTO}

for scenario in $SCENARIO_LIST
do

	echo
	echo $(date) "- Executing regression for scenario: $scenario"
	echo
	
	tmp_output=/tmp/$(basename ${0}).temp.$$
	rm -f $tmp_output
	./function_test.sh $scenario >>${tmp_output} 2>&1
	sleep 180
	subject="$(basename ${0}): $INSTANCE $VERSION_ID $scenario"
	if [[ -n `cat $tmp_output | grep "Test suite was successfull"` ]]
	then
			subject="SERVICE MAVEN: $subject successful"
	else
			subject="SERVICE MAVEN: ALERT: $subject FAILED"
	fi

	cat $tmp_output
	cat $tmp_output | mail -s"$subject $build_subject" ${MAILTO}
	
done


##
echo $(date) "- send regression stats to same email distrib list "
## send regression stats to same email distrib list
##
export $INSTANCE
RESULT="`$SCRIPT_DIR/reportCountsV3.sh $TESTWARE_DIR/report 2>&1`"

HOST=$((uname -a) | awk '{print $2}')
for email_addr in ${MAILTO}
do

echo "MIME-Version: 1.0
From: entitlem@$HOST
To: <$email_addr>
Subject: SERVICE MAVEN: $(basename ${0}): $INSTANCE $VERSION_ID: regress report stats $build_subject
Content-Type: text/html; charset=\"us-ascii\"
$RESULT " | /usr/lib/sendmail -t

done 

# new dir name
export REVIEW_DIR="$TEST_HOME/testreview/t$(date +%Y%m%d_%H%M)_svc_$NAME"

if [[ -d $REVIEW_DIR ]]
then
   echo "Directory already exists: $REVIEW_DIR"
   exit 1
else
   mkdir -p $REVIEW_DIR
fi

##############################################################
############### Copy testware report to review dir ###########

echo "+++ Copying testware reports..."
cp -r $TESTWARE_DIR/report/* $REVIEW_DIR

##############################################################

##############################################################
############### Checking for 9999 errors in actual ###########

cat <<EOF >$REVIEW_DIR/README.txt
================================================================================
$(date)

The data in this directory is based on:

================================================================================
ORACLE_SID:        $ORACLE_SID
ORACLE_USER:       $ORACLE_USER

NAME:              $NAME
TEST_HOME:      $TEST_HOME

BEA INSTANCE:      $INSTANCE
================================================================================
CHECK FOR 9999 string in "actual" dirs:

EOF

echo "+++ Checking for 9999 errors in replies"
echo
cd $REVIEW_DIR
find actual* -type f -exec grep ">9999<" {} /dev/null \; | tee -a $REVIEW_DIR/README.txt

echo 
echo "+++ DIRECTORY CREATED: $REVIEW_DIR"
echo

echo "+++ Zipping..."
echo
cd $REVIEW_DIR/..
find $(basename $REVIEW_DIR) -type f | zip -@ -q $(basename $REVIEW_DIR).zip

chmod -R 766 $(basename $REVIEW_DIR).zip
echo
echo "+++ Removing DIRECTORY: $REVIEW_DIR"
echo

DETAILS="$(cat $REVIEW_DIR/README.txt)"
rm -rf $REVIEW_DIR
#####################################################################################
# Send email notification
#####################################################################################

cat <<EOF |mail -s "Service_maven New regression data available" "${MAILTO}"
The results of the last regression test are available as

${REVIEW_DIR}.zip

$DETAILS

EOF

echo
echo "Email notification sent to"
echo "${MAILTO}"
echo
echo  DONE