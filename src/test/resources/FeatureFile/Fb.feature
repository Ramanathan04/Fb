@UAT1
Feature: To Validate The Facebook Login Page

  Background: 
    Given openChromebrowser and launch url
  @Reg
  Scenario: validate the login page valid username and valid password
    When User have to enter valid username and valid password
      | USERNAME | PASSWORD |
      | Ram      | Ram@123  |
      | Logi     | Logi@123 |
    Then click login button
	@Sanity
  Scenario: validate the login page invalid username and invalid password
    When User have to enter invalid username and invalid password
      | USERNAME | PASSWORD  |
      | Don      | Don@123   |
      | Logi     | Logie@123 |
    Then click login button
