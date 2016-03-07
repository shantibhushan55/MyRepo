@echo off
call common.bat
rem ------------ Launching Test program -------------
@echo on
echo %CLASSPATH%
java -cp %CLASSPATH% -DTEST_HOME=%TEST_HOME% -DSIF_HOME=%TEST_HOME% com.hp.es.test.ServiceTesterLauncher 
REM java -Djava.ext.dirs=%TEST_HOME%/lib:%JAVA_HOME%/jre/lib/ext -Djava.library.path=%TEST_HOME%/lib:%JAVA_HOME%/jre/lib/ext -DTEST_HOME=%TEST_HOME% -DSIF_HOME=%TEST_HOME% com.hp.es.test.ServiceTesterLauncher 


