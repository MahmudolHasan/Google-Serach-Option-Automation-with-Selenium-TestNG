# Google Suggestion Extractor

## Project Overview

This Java project extracts the longest and shortest search suggestions from Google for a given set of keywords, and stores them in a specified Excel file.

## Key Features

1. Reads keywords from multiple Excel sheets, named after each day.
2. Input each keyword into the Google search box.
3. Extract the longest and shortest suggestions from the Google search results.
4. Stores the extracted suggestions in corresponding cells within the original Excel file.

## Prerequisites
These tools need to be installed on the local machine.


1. Java Development Kit (JDK) 8 or later </br>
2. Intellij or Eclipse or any other Java IDE </br>
3. Allure 
## Installation

Clone this repository:
```Bash
git clone https://github.com/MahmudolHasan/Google-Serach-Option-Extractor-With-Selenium-And-TestNG.git
```
## Usage


## To Run the project

  1. Open the java editor
  2. Open the cloned folder of this repository from the editor
  3. Update the Maven project from the Editor
       * Use GUI to update Maven Project
       * Use command terminal
         ``` Bash
         mvn clean install -U
         ```
  4. Open the java file from  `/src/test/main/QuPs.java`  </br>
  5. Now run the file:  </br>
    * Can run the script as testNG suite or </br>
    * run the file using the run option beside the ` _test_`  function.(For Eclipse [TestNG for Eclipse](https://marketplace.eclipse.org/content/testng-eclipse) should be installed in Eclipse) [see this](https://www.guru99.com/install-testng-in-eclipse.html) for more information.

## Output
### Allure Report
Allure Report Can be found under `/allure-report/index.html`.

### Excel 
The extracted suggestions will be stored in the specified cells within the original Excel file.</br>
Before Extracting :- </br>
![Before Extraction](/Resources/before.png)
After Extracting :- </br>
![AfterExtraction](/Resources/after.png)



## License

This project is licensed under the MIT License.
