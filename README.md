# AutomatedTests
Test automation for the examples at http://the-internet.herokuapp.com/
Each example is meant to target the subpages.

Basic Configuration and how to run the tests.

1)The test project uses Selenium2 web driver, the TestNG framework and Maven. Instructions on how to install and configure maven: https://maven.apache.org/

2)Once maven is installed and configured, open the project with Eclipse, IntelliJ or any IDE of preference.

3) Open up a command line prompt and go to the root folder of the project and from the root folder execute the following 

mvn -Dtest=DragNDropTest test

mvn -Dtest=HoverTest test  
