#!/bin/ksh

scm_dir=/opt/entitlem/scm/entitlement_dev
cd ${scm_dir}
fupdate build_unittest.xml 
fupdate devscript/setenv_service.sh

. devscript/setenv_service.sh

rm -f ${scm_dir}/report/html/*

ant -buildfile build_unittest.xml testServices \
	-Dservice_tests=com/hp/es/service/**/*Test.class \
	-Denv.eia_home=${scm_dir} \
	-Dservices_propsdir=${scm_dir}\deploy\es_testware_workspace\conf \
	-Deia_sf_propsdir=${scm_dir}\deploy\es_testware_workspace\conf

jarfilename=unittest_services_$(date +%Y%m%d_%H%M).jar
jarfile=${scm_dir}/report/${jarfilename}
jar cf ${jarfile} ${scm_dir}/report/html/*
#fci -auto -u ${jarfile}

echo
echo "Services unit test regression report available:"
echo "    $jarfile"
echo

