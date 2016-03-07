@echo on
echo ------------ SETTING SOME ENV VARIABLES--------
REM set JAVA_HOME="/opt/webhost/entitlem/casbuilserver/build-1.0.0-SNAPSHOT/software/oracle-java-1.5.0_22"
echo %JAVA_HOME%
set TEST_HOME=C:\Users\minghu\Documents\regress\es_testware_workspace\testware\testware

echo -----------------------------------------------

@echo off
echo ------------ SETTING PATH ---------------------
set PATH=%JAVA_HOME%\bin;%PATH%
set PATH=%PATH%;%TEST_HOME%
echo -----------------------------------------------

copy HpseServiceTester.properties HpseServiceTester.properties.bak /Y
copy HpseServiceTester.properties.regress HpseServiceTester.properties /Y

echo ------------ SETTING CLASSPATH ----------------
set CLASSPATH=
call common_cp.bat
echo ------------------------------------------------
