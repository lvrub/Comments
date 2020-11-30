set projectLocation=C:\Automation
cd %projectLocation%
set classpath=%projectLocation%\bin
set classpath=%projectLocation%\lib\*
java -cp C:\ATTools\testngrunner\lib\*; %projectLocation% org.testng.TestNG testNg.xml
