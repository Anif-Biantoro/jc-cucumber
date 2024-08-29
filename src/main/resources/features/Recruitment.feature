Feature: Recruitment Candidate Management

  #TCC.HRM.004
  Scenario: Adding a new candidate with valid information
    Given I am logged into OrangeHRM as an HR manager
    And I navigate to the Recruitment page
    When I click on the Add button in the Candidates section
    And I fill in all required candidate information with valid data
    And I click the "Save" button
    Then I should see the new candidate listed in the Candidates section

    #TCC.HRM.005
  Scenario: Adding a new candidate with invalid format email information
    Given I am logged into OrangeHRM as an HR manager
    And I navigate to the Recruitment page
    When I click on the Add button in the Candidates section
    And I enter invalid format email
    And I click the Save button
    Then I should see an error message indicating that required fields are missing