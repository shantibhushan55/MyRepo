#!/bin/sh
echo ------------ exporting SOME ENV VARIABLES--------
export JAVA_HOME="/opt/webhost/entitlem/casbuilserver/build-1.0.0-SNAPSHOT/software/oracle-java-1.5.0_22"
export TEST_HOME="$(dirname $0)/.."

echo JAVA_HOME = $JAVA_HOME
echo TEST_HOME =$TEST_HOME

echo -------------------------------------------------

echo ------------ exporting PATH ---------------------
export PATH=$JAVA_HOME/bin:$PATH:$TEST_HOME/script
echo -------------------------------------------------

echo ------------ ready HpseServiceTester.properties---------------------
cp $TEST_HOME/HpseServiceTester.properties $TEST_HOME/HpseServiceTester.properties.bak
cp $TEST_HOME/HpseServiceTester.properties.regress $TEST_HOME/HpseServiceTester.properties
cp $TEST_HOME/testware.jar $TEST_HOME/lib/
cp $TEST_HOME/ES10_1/config/es.log4j.properties.regress $TEST_HOME/ES10_1/config/es.log4j.properties
cp $TEST_HOME/conf/es.log4j.properties.regress $TEST_HOME/conf/es.log4j.properties

echo ------------ exporting CLASSPATH ----------------
export CLASSPATH=.
. ./common_cp.sh
echo -------------------------------------------------
