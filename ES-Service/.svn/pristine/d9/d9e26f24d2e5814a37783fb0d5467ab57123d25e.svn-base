#!/bin/ksh

if [ $# -ne 2 ] ;then
	echo 
	echo "usage:   $(basename $0) instance<XX> <trunk|5_0C2|3_1|etc>"
	echo 
	echo "example: $(basename $0) instance05 trunk"
	echo "example: $(basename $0) instance07 5_0C2"
	echo 
	exit -1
fi

instance=$1
branch=$2
regress_name="$(date +%Y%m%d_%H%M)_${instance}_${branch}"
snapshot_dir=/opt/entitlem/regress_snapshots/${regress_name}
server_logs_dest=$snapshot_dir/server_logs
testware_report_dest=$snapshot_dir/testware_report

scm_dir=/opt/entitlem/scm/entitlement_dev

if [ -d $snapshot_dir ] ;then
	echo 
	echo "ERROR: directory already exists:"
	echo "   $snapshot_dir"
	exit -1
fi

echo
echo "Setting up regress snapshot: "
echo "   $snapshot_dir"

mkdir $snapshot_dir
mkdir $server_logs_dest
mkdir $testware_report_dest

## get server logs

server_logs_src=/opt/ent/entbea/bea_config/${instance}/log
if [ ! -d ${server_logs_src} ] ;then
	echo "ERROR: nonexistent dir: ${server_logs_src}"
	echo "       maybe from providing a bad instance parameter"
	echo "exiting script."
	exit -2
fi
cp -pR ${server_logs_src}/* $server_logs_dest

## report interesting things from app log

logstats=${scm_dir}/devscript/logstats.ksh
if [ -x $logstats ] ;then
	$logstats ${server_logs_dest}/ES50.log* >${server_logs_dest}/LOGSTATS
else
	echo "Skipping logstats; file missing or no exec: $logstats"
fi

## get testware logs and results

if [ "${branch}" != "trunk" ] ;then
	scm_dir=${scm_dir}${branch}
fi
if [ ! -d ${scm_dir} ] ;then
	echo "ERROR: nonexistent dir: ${scm_dir}"
	echo "       probably from providing a bad trunk/branch parameter"
	echo "exiting script."
	exit -2
fi
testware_report_src=${scm_dir}/deploy/es_testware_workspace/report
if [ ! -d ${testware_report_src} ] ;then
	echo "ERROR: nonexistent dir: ${testware_report_src}"
	echo "exiting script."
	exit -2
fi
cp -pR ${testware_report_src}/* $testware_report_dest

cd $testware_report_dest

## make a vi-viewable copy of the app log
#fold -w200 HPSE30.log.* >HPSE30.log

## make all files read-only (this is a snapshot)
find $snapshot_dir -type f -exec chmod 444 {} \;  

## jar the expect/actual/eia_raw xml files
regress_jar=/tmp/regress_${regress_name}.jar
jar cf ${regress_jar} actual*/* expect*/* eia_raw*/*

echo
echo "Regress expect/actual jar is: ${regress_jar}"
echo "Finished."
exit
