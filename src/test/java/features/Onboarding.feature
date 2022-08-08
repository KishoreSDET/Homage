Feature: Homage CarePro Onboarding

#Background:
#Given User launches Chrome browser
#And User loads the application with 'https://apply.homage.sg/'

Scenario Outline: Verify that the new user is able to submit an Homage CarePro application successfully
And user selects country as <country>
And User enters first name as <firstName> 
And User enters last name as <lastName>
And User enters email as <email> 
And User enters phone number as <phone>
And User enters date of birth as <dob>
And User enters nationality as <nationality>
When User selects experience as <isExperienced>
Then years of experience and role sections should be displayed
And User selects years of experience as <expLevel>
And User selects role as <role>
And User selects job Opportunities as <jobOpp> 
And User selects engagement type as <engType>
And User selects background check information as <bgChk>
And user enters referral code as <refCode>
And User selects source of information as <source>
And User checks the declaration 
When User clicks on submit button
Then User sees the success message

Examples:
|country|firstName|lastName|email|phone|dob|nationality|isExperienced|expLevel|role|jobOpp|engType|bgChk|refCode|source|
|'Singapore'|'Test111'|'User111'|'test2001.user@gmail.com'|'97564589'|'01011999'|'Singapore Citizen'|'Yes'|'Less than 1'|'Doctor'|'Home Care'|'Full-Time'|'No'|'test'|'Job boards (LinkedIn, Indeed, etc)'|


Scenario: Verify that the existing user is not able to submit an Homage CarePro application due to duplication error
And user selects country as 'Singapore'
And User enters first name as 'Test111' 
And User enters last name as 'User111'
And User enters email as 'test1119.user@gmail.com' 
And User enters phone number as '97564589'
And User enters date of birth as '01011999'
And User enters nationality as 'Singapore Citizen'
When User selects experience as 'Yes'
Then years of experience and role sections should be displayed
And User selects years of experience as 'Less than 1'
And User selects role as 'Doctor'
And User selects job Opportunities as 'Home Care' 
And User selects engagement type as 'Full-Time'
And User selects background check information as 'No'
And user enters referral code as 'test'
And User selects source of information as 'Job boards (LinkedIn, Indeed, etc)'
And User checks the declaration 
When User clicks on submit button
But Error message should be displayed