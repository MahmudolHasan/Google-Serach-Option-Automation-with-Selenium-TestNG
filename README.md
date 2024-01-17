# Google Suggestion Extractor

## Project Overview

This Java project extracts the longest and shortest search suggestions from Google for a given set of keywords, and stores them in a specified Excel file.

## Key Features

1. Reads keywords from multiple Excel sheets, named after each day.
2. Inputs each keyword into the Google search box.
3. Extracts the longest and shortest suggestions from the Google search results.
4. Stores the extracted suggestions in corresponding cells within the original Excel file.
## Prerequisites
These tools need to be installed on the local machine.


1. Java Development Kit (JDK) 8 or later </br>
2. Intellij or Eclipse or any Other java Editor </br>
3. Allure 
## Installation

Clone this repository:
```Bash
git clone https://github.com/your-username/google-suggestion-extractor.git
```
## Usage


## ToRun the project

  1. Open the java editor
  2. Open the cloned folder of this repository from the editor
  3. Update Maven project from the Editor
       * Use GUI to update Maven Project
       * Use command terminal
         ``` Bash
         mvn clean install -U
         ```
  4. Now run the file as TestNG suite 

## Output
### Allure Report

### Excel 
The extracted suggestions will be stored in the specified cells within the original Excel file.

## Additional Notes

Consider rate limiting or using a proxy to avoid excessive requests to Google.
Adjust the code to handle potential errors or exceptions.
Explore additional features like filtering suggestions based on criteria.
## Contributing

Pull requests are welcome!

## License

This project is licensed under the MIT License.
