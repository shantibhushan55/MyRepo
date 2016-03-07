#!/bin/sh
. ./common.sh

echo ------------ Launching Test program -------------
echo The program needs HpseServiceTester.properties
echo ------------ Classpath -------------
echo $CLASSPATH
echo ------------ Launch Test -------------
java -cp $CLASSPATH -DTEST_HOME=$TEST_HOME -DES_HOME=$TEST_HOME com.hp.es.test.ServiceTesterLauncher
java_exit=$?
echo --------------------------------------------------

## test suite success/failure => script success/failure
exit $java_exit
