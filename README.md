# PHPTravels

Website details:

Frontend
URL: https://www.phptravels.net/
Username: user@phptravels.com
Password: demouser

CMS
Url: https://www.phptravels.net/admin
Username: admin@phptravels.com
Password: demoadmin

Supplier Back-End
Url: https://www.phptravels.net/supplier
Username: supplier@phptravels.com
Password: demosupplier

The setup specs are:

-	Java 8 
-	Selenium 
-	Maven 
-	IntelliJ IDEA 
-	IntelliJ IDEA Cucumber for Java plugin

The following test scenarios are automated in this project

1.	Write BDD’s with stories and scenarios and implement the tests for the following:
Customers should be able to login to the website. When they logged in they should be able to see their name. They should be able to access their profile. 
They should be able to update their profile and see the changes. 

2.	Write BDD’s with stories and scenarios and implement the tests for the following:
Customers should not be able to login to a section that they are not allowed in. Find out if they can log in.

3.	Write BDD’s with stories and scenarios and implement the tests for the following:
We run an e-commerce site. So searching for hotels and working with the filters is an absolute must to ensure customers find their deal quickly.
Find a good deal and purchase the hotel of your choice. Check in your profile to see your booking. 

Instructions to run the project
1. Based on your OS and browser versions, place the chromedriver.exe in ./drivers folder
2. To run the project, pass this variable in the intelliJ configuration: -Dwebdriver.chrome.driver=drivers/chromedriver.exe

