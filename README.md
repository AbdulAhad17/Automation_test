**Automation for Git Lab Signup Page**

Behavioural driven development automation framework (BDD) using selenium, cucumber-java, testng, maven


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
![Screenshot 2024-07-20 at 2.20.40 PM.png](..%2F..%2F..%2Fvar%2Ffolders%2Fkt%2Fg39jtxm50bs2bntsv_tc6njr0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_8eEb3y%2FScreenshot%202024-07-20%20at%202.20.40%E2%80%AFPM.png)

**package: framework** : It includes the Step definitions classes(Testcase methods) Page (Page object model and methods) which are required by each test to perform actions. Below are classes in this package:

![Screenshot 2023-03-29 at 10.35.56 PM.png](images%2FScreenshot%202023-03-29%20at%2010.35.56%20PM.png)


## Test report ##

Once test execution is completed, go to target/cucumber-reports.html and open it

![Screenshot 2023-03-29 at 10.42.14 PM.png](images%2FScreenshot%202023-03-29%20at%2010.42.14%20PM.png)


You can see the test results at different level
<img width="1424" alt="Screenshot 2024-07-22 at 2 02 13 AM" src="https://github.com/user-attachments/assets/8f8178ef-a161-431b-8fa9-d3bba433899f">


# Setting up the project

Install the java and maven and clone the build then:

**$ cd Automation_test_signUp_flows**

**$ mvn clean install**



## Execution of tests
**$ mvn test**
