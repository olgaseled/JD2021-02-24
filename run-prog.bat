SET PROJ_PATH=c:\java-lab\JD2021-02-24
javac -d %PROJ_PATH%\classes %PROJ_PATH%\src\by\it\dudko\jd01_05\TaskA.java
javac -d %PROJ_PATH%\classes -cp .;lib.jar %PROJ_PATH%\src\by\it\dudko\jd01_05\Test_jd01_05.java
java -ea -cp .;lib.jar;%PROJ_PATH%\classes by.it.dudko.jd01_05.TaskA
pause