Feature: Add new hotel
  We just opened a hotel in Hilversum called “Monks palace” . It is an absolute dream.
  Add it to the website and make sure the correct but not all facilities are set.
  Monks are clean people so they don’t need laundry service. And book a night in the palace.
  Since monks come from across the world make sure it is also available in some other languages.


  Scenario: Add new hotel
    Given admin logs into CMS website using email "admin@phptravels.com" and password "demoadmin"
    Then the page should contain "Hi Admin!"
    When user clicks on Hotels menu and select Hotels submenu
    And clicks on the Add button
    Then the page to add hotel details is opened
    When admin enters the following details in the general tab
#      | Name         | Description             | Address                                             |
#      | Monks palace | It is an absolute dream | H-Park, Oude Amersfoortseweg 125, 1212 AA Hilversum |
#    And enters the following details in the main settings
#      | Stars | Hotel Type | Location  |
#      | 5     | Hotel      | Hilversum |
#    And clicks on the facilities tab
#    And selects the following facilities
#      | Airport Transport | Wi-Fi Internet | Bar Lunge | Cards Accepted | Disabled Facilities | Restaurant | Fitness center |
#      | true              | true           | true      | true           | true                | true       | true           |
#    And clicks on the Translate tab
#    And enters the following details in translate tab
#      | Name             | Description                 |
#      | Cung điện nhà sư | Đó là một giấc mơ tuyệt đối |
#    And clicks on the submit button
#    Then the hotels management page is loaded
#    And the added hotel is displayed there

#  Scenario: Book a night in the new hotel
#
#  Scenario: Verify some other language