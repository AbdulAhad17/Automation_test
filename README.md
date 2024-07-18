# selenium_BDD_framework

Behavioural driven development automation framework using selenium, cucumber-java, testng, maven


## Tools and technologies used:

1. Language: Java 19
2. Testing framework: Testng
3. BDD framework: Cucumber jvm
4. Automation tool: Selenium webdriver
5. Build tool: maven
6. Reporting: [cucumber reporting](https://github.com/damianszczepanik/cucumber-reporting)


## Features of the framework
1. BDD framework using Cucumber-jvm. Feature files can be written easily using Given,When, Then etc.
2. Browser(chrome) can be configured at run time  from command line (or Continuous integration tool, if configured).
3. Html report gets generated after each test run and can be found /target/cucumber-reports.html
4. Page Object Model also applied in this framework

**package: features** : It contains all different features (tests) files.
![Screenshot 2023-03-29 at 10.27.13 PM.png](images%2FScreenshot%202023-03-29%20at%2010.27.13%20PM.png)


**package: framework** : It includes the Step definitions classes(Testcase methods) Page (Page object model and methods) which are required by each test to perform actions. Below are classes in this package:

![Screenshot 2023-03-29 at 10.35.56 PM.png](images%2FScreenshot%202023-03-29%20at%2010.35.56%20PM.png)


## Test report ##

Once test execution is completed, go to target/cucumber-reports.html and open it

![Screenshot 2023-03-29 at 10.42.14 PM.png](images%2FScreenshot%202023-03-29%20at%2010.42.14%20PM.png)


You can see the test results at different level
![Screenshot 2023-03-29 at 10.45.39 PM.png](images%2FScreenshot%202023-03-29%20at%2010.45.39%20PM.png)


# Setting up the project

Install the java and maven and clone the build then:

**$ cd Selenium-java-bdd-framework**

**$ mvn clean install**



## Execution of tests
There are 2 scenarios named as @ValidCredentials,FilterProduct and @AddToCart Ran the tests on browser

To run scenarios (@ValidCredentials,@AddToCart,@FilterProduct)

**$ mvn test**

To run specific scenario:

**$ mvn test -Dcucumber.options="--tags @AddToCart"**

To run multiple mentioned scenarios:

**$ mvn test -Dcucumber.options="--tags @ValidCredentials,@AddToCart"**
