set projectLocation=C:\Automation
cd %projectLocation%
set classpath=ATTools\bin
set classpath=ATTools\lib\*
java -cp C:\ATTools\testngrunner\lib\*; org.testng.TestNG testNg.xml
