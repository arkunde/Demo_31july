  @StoresPage
Feature: Validating the Store page for asian paint application

  @home
  Scenario: Check the functionality of stores on homepage
    Given user is on the home page 
    When user goes to Stores option
    And click on the paint stores
    #And user goes to paint stores
    Then navigated to the store page sucessfully

  @enterpin
  Scenario Outline: Check the funtionality of pincode
    Given user is on paint stores page
    When enter the <pincode>
    And click on icon
    Then user enter sucessfully

    Examples: 
      | pincode |
      |  480334 |

  @entermail
  Scenario: Check the functinality of subscription
    Given user is on paint stores page asian
    When scrolled down and enter the email
    And click on the subscribe
    Then subscription sucessfull

  @map
  Scenario: Check the functinality of directions on map
    Given user is on paint stores page of asian
    When click on direction icon
    And redirect to map page
    Then redirect back to previous page

  @sms
  Scenario: Check the functionality of share option
    Given user is on paint store page
    When user goes to share option
    And click on the sms
    And enter the mobile nomber
    |8319023097|
    And click on submit button
    Then message displayed.
  