Feature: To Validate the login functionality of Skytrans Application

Scenario: To validate the Booking with invalid credentials
Given The user should be in Booking page
When The user should enter the Arrival and Departure Details
And The user should select the flight
Then The user is in invalid page
