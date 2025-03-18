Feature: Change Password Functionality

  @ChangePassword
  Scenario: User successfully changes their password after login
    Given User is logged in with email "shiny.dipty1@gmail.com" and password "vs0faGkMrUKqg?b"
    And User navigates to the Change Password page
    When User enters current password "vs0faGkMrUKqg", new password "Dipti@Pass123", and confirms password "Dipti@Pass123"
    Then Password change success message is displayed
    