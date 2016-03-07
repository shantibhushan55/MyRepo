#!/bin/ksh

## looks through ES regression reports and counts failures

if [ $# -ne 1 ]  ;then
	echo
	echo "usage:  $(basename $0) <dirname>  (where <dirname> holds report files)"
	echo "sample: $(basename $0) /opt/entitlem/regress_snapshots/20030610_1136_instance05_trunk/testware_report"
	echo
	exit 1
fi

reportdir=$1
if [ ! -d $reportdir ]  ;then
	echo
	echo "The provided report dir doesn't exist; exiting"
	echo
	exit 1
fi

if [ $(ls ${reportdir}/report* 2>/dev/null |wc -l) -eq 0 ]  ;then
	echo
	echo "No report files found; exiting"
	echo
	exit 1
fi


function printCounts
{
   file=$1
   name=$2
   pattern=$3
   suppressIfNull=$4

   sum=$(egrep "^[	]*$pattern" $file |wc -l)

   if [ "$suppressIfNull" = "n" -o "$suppressIfNull" = "y" -a "$sum" != "0" ]
   then
     failed=$(grep fileUnitTest $file |grep $pattern |wc -l)
     if [ "$failed" = "0" ]
     then
        echo "<font color=green>  $name (FAIL/TOTAL): $failed/$sum</font>"
     else
        echo "<font color=red>  $name (FAIL/TOTAL): $failed/$sum</font>"
     fi
   fi
}

echo "<html><body><pre>"
cd $reportdir
for file in report*
do
	echo ________________ $file _________________

	total=$(egrep 'in an average of' $file |wc -l)
	totalfail=$(grep fileUnitTest $file |wc -l)
	echo
	echo "  All (FAIL/TOTAL): $totalfail/$total"
	echo "  ============================="
	echo

   printCounts $file "getAssociatedContracts      " "getAssociatedContracts" "y";

   printCounts $file "getContractSummary          " "getContractSummary" "y";

   printCounts $file "getContractEntitlement      " "getContractEntitlement_" "y";
   printCounts $file "    - BLUE                  " "getContractEntitlement_.*B\.xml" "y";
   printCounts $file "    - RED                   " "getContractEntitlement_.*R\.xml" "y";
   printCounts $file "    - PURPLE                " "getContractEntitlement_.*P\.xml" "y";
   printCounts $file "    - CQS                   " "getContractEntitlement_CQS_.*\.xml" "y";
   printCounts $file "    - MV                    " "getContractEntitlement_mv_*" "y";
   printCounts $file "    - PSPDOC                " "getContractEntitlement_PSPDOC_*" "y";
   printCounts $file "    - Validation of data    " "ContractTestDataCheckNTx_CCRN_x*" "y";
   printCounts $file "    - unknown               " "getContractEntitlement_.[0-9]*\.xml" "y";

   printCounts $file "getEntitlementByPN          " "getEntitlementByPN_" "y";
   printCounts $file "    - BLUE                  " "getEntitlementByPN_.*B\.xml" "y";
   printCounts $file "    - RED                   " "getEntitlementByPN_.*R\.xml" "y";
   printCounts $file "    - PURPLE                " "getEntitlementByPN_.*P\.xml" "y";
   printCounts $file "    - SERVICE_NOTE          " "getEntitlementByPN_ServiceNote_.*[0-9]\.xml" "y";
   printCounts $file "    - 3G                    " "getEntitlementByPN_fraud*" "y";
   printCounts $file "    - 3G                    " "getEntitlementByPN_3G*" "y";
   printCounts $file "    - MV			 							" "getEntitlementByPN_mv_*" "y";
   printCounts $file "    - unknown               " "getEntitlementByPN_.[0-9]*\.xml" "y";

   printCounts $file "getEntitlementBySN          " "getEntitlementBySN_" "y";
   printCounts $file "    - BLUE                  " "getEntitlementBySN_.*B\.xml" "y";
   printCounts $file "    - RED                   " "getEntitlementBySN_.*R\.xml" "y";
   printCounts $file "    - PURPLE                " "getEntitlementBySN_.*P\.xml" "y";
   printCounts $file "    - CQS                   " "getEntitlementBySN_CQS_.*\.xml" "y";
   printCounts $file "    - SERVICE_NOTE          " "getEntitlementBySN_ServiceNote_.*[0-9]\.xml" "y";
   printCounts $file "    - 3G                    " "getEntitlementBySN_3G_*" "y";
   printCounts $file "    - MV                    " "getEntitlementBySN_mv_*" "y";
   printCounts $file "    - FRAUD                 " "getEntitlementBySN_fraud*" "y";
   printCounts $file "    - FRAUD (inv SN)        " "getEntitlementBySN_invalidSN*" "y";
   printCounts $file "    - unknown               " "getEntitlementBySN_.[0-9]*\.xml" "y";

   printCounts $file "getIndependent              " "getIndependent" "y";

   printCounts $file "getInstalledBaseUnits       " "getInstalledBaseUnits" "y";
   
   printCounts $file "getInstalledBaseUnits       " "getInstalledBaseUnits" "y";
   printCounts $file "getPrintAdvantageEntitlement" "getPrintAdvantageEntitlement" "y";

   printCounts $file "getRoutingDetails           " "getRoutingDetails" "y";

   printCounts $file "getWarrantyEntitlement      " "getWarrantyEntitlement_" "y";
   printCounts $file "    - SWOP                  " "getWarrantyEntitlement_9[0-9][0-9][\._]" "y";
   printCounts $file "    - SWOP off/down         " "getWarrantyEntitlement_9[0-9][0-9]b\." "y";
   printCounts $file "    - SWOP orchestration    " "getWarrantyEntitlement_100[0-9]\." "y";
   printCounts $file "    - SWOP RubberSole       " "getWarrantyEntitlement_110[0-9]\." "y";
   printCounts $file "    - SWOP down scenarios   " "getWarrantyEntitlement_102[0-9]\." "y";
   printCounts $file "    - Development           " "getWarrantyEntitlement_9[0-9][0-9][0-9]" "y";
   printCounts $file "    - _bad_                 " "getWarrantyEntitlement_bad" "y";
   printCounts $file "    - CR101                 " "getWarrantyEntitlement_120[0-9]\." "y";
   printCounts $file "    - Authorization         " "getWarrantyEntitlement_3[0-9][0-9][\._]" "y";
   printCounts $file "    - ASTRO2                " "getWarrantyEntitlement_4[0-9][0-9][\._]" "y";
   printCounts $file "    - FRAUD                 " "getWarrantyEntitlement_fraud*" "y";
   printCounts $file "    - FRAUD (inv SN)        " "getWarrantyEntitlement_invalidSN_*" "y";
   printCounts $file "    - 3G                    " "getWarrantyEntitlement_*3G*" "y";
   
   printCounts $file "getUnitEventHistory         " "getUnitEventHistory*" "n";
   



   echo
done
echo
echo "Report created by $0"

echo "</pre></body></html>"
