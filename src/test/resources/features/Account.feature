Feature: Login

  Scenario: Check login with valid credentials
    Given User logs into public website using "user@phptravels.com" and "demouser"
    Then The page should contain "Hi, Demo User"
    When User clicks on logout
    Then User has logged out successfully

  Scenario Outline: Access user profile and update contact information
    Given User logs into public website using "user@phptravels.com" and "demouser"
    When User clicks on My Profile link
    Then My Profile is opened
    When User updates address as "<address>"
    And User updates city as "<city>"
    And User updates postal code as "<zip>"
#    And User updates country as "Netherlands"
    And User updates phone number as "<phone>"
    And User clicks on submit button
    Then The profile gets updated successfully with "<address>", "<city>", "<zip>" and "<phone>"
    And User clicks on logout


    Examples:
      | address  | city    | zip    | phone  |
      | Hysophof | Utrecht | 1234NM | 987456 |


