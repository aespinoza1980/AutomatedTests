# AutomatedTests
Test automation for the examples at http://the-internet.herokuapp.com/
Each example is meant to target the subpages.

Basic Configuration and how to run the tests.

1)The test project uses Selenium2 web driver, the TestNG framework and Maven. Instructions on how to install and configure maven: https://maven.apache.org/

2)Once maven is installed and configured, open the project with Eclipse, IntelliJ or any IDE of preference.

3) Open up a command line prompt and go to the root folder of the project and from the root folder execute the following 

mvn -Dtest=DragNDropTest test

mvn -Dtest=HoverTest test  

mvn -Dtest=HorizontalSliderTest test  

mvn -Dtest=TinyMceTest test  

mvn -Dtest=InfiniteScrollingTest test    (optional parameters -DscrollIterations=< int >    (default =10))
Optional parameters

-Dbrowser=chrome


Configure an account in browserstack and modify the settings accordingly in the BaseTest class(USERNAME,AUTOMATE_KEY)
BrowserStack parameters


-Dbrowser=firefox

-Dbrowser_version=<version> 

-Dos=<os> 

-Dos_version=<version>


For mobile

-DmobileBrowserName=<browserName> 

-DmobilePlatform=<platform>

-DmobileDevice=<device>

Check mobile  OS and browser  configuration parameters here https://www.browserstack.com/automate/java


