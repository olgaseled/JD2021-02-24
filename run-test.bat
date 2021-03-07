SET SRC_PATH=c:\java-lab\JD2021-02-24\src
SET OUTPUT_PATH=c:\java-lab\JD2021-02-24\classes
SET USER_PATH=by\it\dudko
SET USER_PACKAGE=by.it.dudko
SET JUNIT_PACKAGE=org.junit.runner.JUnitCore
SET LAB_NUM=jd01_05
SET CLASS_NAME=TaskA
SET TEST_NAME=Test_jd01_05

javac -d %OUTPUT_PATH% %SRC_PATH%\%USER_PATH%\%LAB_NUM%\%CLASS_NAME%.java
javac -d %OUTPUT_PATH% -cp .;lib.jar %SRC_PATH%\%USER_PATH%\%LAB_NUM%\%TEST_NAME%.java
java -ea -cp lib.jar;%OUTPUT_PATH% %JUNIT_PACKAGE% %USER_PACKAGE%.%LAB_NUM%.%TEST_NAME%

pause