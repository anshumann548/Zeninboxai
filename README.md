Project structure and how to use
================================

# Installations & Dependenceies
- maven(optional, mvn wrapper added)
- java-11
- apache-jmeter 5.6.3
- Selenium
- TestNg
- RestAssured


## Directory Hierarchy

└── zeninbox
    ├── jmeter-scripts
    │   └── zeninf.jmx
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── README.md
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com
    │   │   │       └── zeninbox
    │   │   │           ├── config.java
    │   │   │           ├── Duplicatemail.java
    │   │   │           ├── locators.java
    │   │   │           ├── Specialchars.java
    │   │   │           └── SQLinjectionverifier.java
    │   │   └── resources
    │   │       └── config.properties
    │   └── test
    │       └── java
    │           └── com
    │               └── zeninbox
    │                   └── SessionTest.java
    └── target
        ├── classes
        │   ├── com
        │   │   └── zeninbox
        │   │       ├── config.class
        │   │       ├── Duplicatemail.class
        │   │       ├── locators.class
        │   │       ├── Specialchars.class
        │   │       └── SQLinjectionverifier.class
        │   └── config.properties
        ├── generated-sources
        │   └── annotations
        ├── generated-test-sources
        │   └── test-annotations
        ├── maven-status
        │   └── maven-compiler-plugin
        │       ├── compile
        │       │   └── default-compile
        │       │       ├── createdFiles.lst
        │       │       └── inputFiles.lst
        │       └── testCompile
        │           └── default-testCompile
        │               ├── createdFiles.lst
        │               └── inputFiles.lst
        ├── surefire-reports
        │   ├── bullet_point.png
        │   ├── collapseall.gif
        │   ├── com.zeninbox.SessionTest.txt
        │   ├── emailable-report.html
        │   ├── failed.png
        │   ├── index.html
        │   ├── jquery.min.js
        │   ├── junitreports
        │   │   └── TEST-com.zeninbox.SessionTest.xml
        │   ├── navigator-bullet.png
        │   ├── old
        │   │   ├── index.html
        │   │   └── Surefire suite
        │   │       ├── classes.html
        │   │       ├── groups.html
        │   │       ├── index.html
        │   │       ├── main.html
        │   │       ├── methods-alphabetical.html
        │   │       ├── methods.html
        │   │       ├── methods-not-run.html
        │   │       ├── reporter-output.html
        │   │       ├── Surefire test.properties
        │   │       ├── testng.xml.html
        │   │       └── toc.html
        │   ├── passed.png
        │   ├── skipped.png
        │   ├── Surefire suite
        │   │   ├── Surefire test.html
        │   │   ├── Surefire test.xml
        │   │   └── testng-failed.xml
        │   ├── TEST-com.zeninbox.SessionTest.xml
        │   ├── testng.css
        │   ├── testng-failed.xml
        │   ├── testng-reports1.css
        │   ├── testng-reports2.js
        │   ├── testng-reports.css
        │   ├── testng-reports.js
        │   └── testng-results.xml
        └── test-classes
            └── com
                └── zeninbox
                    └── SessionTest.class
### How to use 

**clone the repository :** 
git clone https://github.com/anshumann548/Zeninboxai.git**

**Run project using maven wrapper :**

./mvnw clean install for (linux/MacOS)
 mvnw.cmd clean install for (windows)

// (There are total 5 test cases , 3 in selenium+TestNg and 1 in RestAssured+TestNg , 1 is jmeter script )
// upon running these  command ./mvnw clean install for (linux/MacOS) or  mvnw.cmd clean install (windows)
// it will run 4 test cases
// All Selenium+TestNg tests will pass and RestAssured+TestNg will fail due to bot detection that could be resolved by removing bot detection on controlled staging environment

**To run Jmeter script :**
Install the apache-jmeter from https://jmeter.apache.org/download_jmeter.cgi
Download the jmx file from https://github.com/anshumann548/Zeninboxai/blob/main/jmeter-scripts/zeninf.jmx 
Open Jmeter then go to File -> Open -> zeninf.jmx(from your system downloads)
Run the test from green leaf sign in Jmeter and observe the results in Result tree 

**NOTE** : Provide the fresh jwt and organisation in header manager and body of request respectively

Access the test case file from the following link : https://docs.google.com/spreadsheets/d/1f1KtcJjDyVExE--L9TLdNxlLRSz9JSQEyLbnI-_Rb2Q/edit?gid=0#gid=0 

 

