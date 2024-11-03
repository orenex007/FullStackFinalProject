## **Full Stack Automation Final Project**
[Short Video - Demonstration](https://youtu.be/EIGc7sbgfd8)
### **_This project created to demonstrate my knowledge and skills in Automation Testing._**
***
### _About_
The project demonstrates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods.
There are main/common/helpers/actions/page_object modules.
In this way, the tests can be created in very simple way with a minimum lines of code.
Also the infrastructure allows to work with different kinds of applications.
**Big advantage of the infrastructure is that it can be easy maintained!**


### _Project Overview_

The project is an example of infrastructure for automation testing of different kinds of applications:
* Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

### **_Infrastructure project includes using of:_**
* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Failure Mechanism
* Common Functionality
* External Files Support
* Reporting System (including screenshots and screen recordings)
* Visual Testing
* DB support
* CI support  

***

### _List of applications were used in this project:_
* [Swag Labs](https://www.saucedemo.com/) - Web based e-commerce site
* Metric Conversions - Mobile application
* [students.jar](http://localhost:9000/student/list/) - Test API(need download for it)
* Electron application - Todolist App application
* Desktop application - Windows calculator 

### _Tools & Frameworks used in the project:_
* JUnit - Unit testing in Java applications
* TestNG - Testing Framework
* Listeners - interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - used for login to Swag Labs web page and fill information in the Checkout page 
* [Jenkins](https://www.jenkins.io/)- for tests execution
* REST Assured - for API testing
* [Allure Reports](http://allure.qatools.ru/)- as the main reporting system

### Tests Execution:
> Each of the applications has a few tests for demonstration purpose.
These tests can be developed in a very simple way, due to a lot of work with the infrastructure.
[[Sanity Tests]](https://github.com/orenex007/FullStackFinalProject/tree/main/src/test/java/sanity)

### _Known Issues:_
Sometimes can be conflicts with some dependencies the applications are using and leading to slower performance.
Therefore, the project is for DEMO purpose only. In production, it should be divided into several projects.
Nevertheless the file : pom.xml is attached for using the same extensions or versions of any tool
for using your own system for the entire tests.