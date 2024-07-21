Feature: Sign up for GitLab Free Trial
  Background:
    Given User is on gitLab page

  Scenario: User signs up for GitLab Free Trial
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User creates a new account
    Then Account creation is successful

  Scenario Outline: Signup with empty <field>
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User enters <field> as empty
    And User click on continue button
    Then Error message is displayed for <field>

    Examples:
      | field      |
      | First Name |
      | Last Name  |
      | User Name  |
      | Email      |
      | Password   |

  Scenario: Signup with Invalid Email Format
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User enters an invalid email format
    Then Error message "Please provide a valid email address." is displayed


  Scenario: Signup with weak <password>
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User enters weak Password
    Then Error message for weak password "Minimum length is 8 characters." is displayed



  Scenario: Signup with duplicate email
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User enters existing email
    And User click on continue button
    Then Error message for existing email "Complete verification to sign up." is displayed

  Scenario: Signup with Existing User name
    When User click on Get free Trial button to navigates the GitLab Free Trial Signup Page
    When User enters existing user name
    Then Error message for existing user name "Username is already taken." is displayed



