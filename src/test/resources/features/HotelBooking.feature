Feature: Hotel Booking

#  Scenario: Search for a hotel
#    Given User logs into public website using "user@phptravels.com" and "demouser"
#    When User searches using "Dubai", "02/04/2021", "06/04/2021"
#    Then Search result page is loaded with results


  Scenario Outline: Filter the search results
    Given User logs into public website using "user@phptravels.com" and "demouser"
    When User searches using "Dubai", "02/04/2021", "06/04/2021"
    Then Search result page is loaded with results
    When User filters using star grade "<starGrade>" and property type "<propertyTypes>"
    And clicks on search button
    Then Result page is updated
    When User clicks on a hotel details button
    Then Hotel details page is loaded
    When User selects a room
    And Clicks book now button
    Then Personal details screen is loaded
    When User clicks on confirm booking
    Then Confirmation screen is loaded
    When User clicks on Account link
    Then Account page is opened
    And Selected hotel is found in bookings

    Examples:
      | starGrade | propertyTypes |
      | 4         | Hotel         |
#      | 3         | Hotel         |