@Project
Feature: End to End scenario 

@Url
Scenario: Url
Given Enter Application "URL"

@Signin
Scenario: Account Creation
Given Click "signIn"
And Enter text "emailCreate" "rakesh.m@trackdfect.com"
And Click "createAnAccount"

@CreateAccount
Scenario: Create new account
Given Click Radiobutton "mr"
And Enter text "firstName" "Vijay"
And Enter text "lastName" "S"
And Enter text "passWord" "abc@123"
And Click "days"
And Click "selectDays2"
And Click "months"
And Click "selectMonths1"
And Click "year"
And Click "selectYears95"
And Enter text "address" "Street"
And Enter text "city" "Chennai"
And Click "country"
And Click "selectCountry"
And Click "state"
And Click "selectState"
And Enter text "pinCode" "00000"
And Enter text "mobileNo" "9962853236"
And Click "register"
And Verfiy "loginPage"

@CreatedAccount
Scenario: User Login with Valid credentials
Given Click "signIn"
And Enter text "email" "vijayakumar.s@trackdfect.com"
And Enter text "passWord" "abc@123"
And Click "toSignIn"
And Verfiy "loginPage"


@LoginCredentials
Scenario: User enter Valid Credentials
Given Click "signIn"
And Enter text "email" <UserName>
And Enter text "passWord" <Password>
And Click "toSignIn"

|Excel|UserName|Password|
|Admin|1|1|




