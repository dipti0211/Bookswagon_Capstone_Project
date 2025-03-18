Feature: User Registration Functionality

  @RegistrationTest
  Scenario: Successful User Registration with Manual OTP and CAPTCHA
    Given User is on the signup page
    When User enters name "Shiny Rout" and mobile number "7328878592"
    And User completes the CAPTCHA manually
    And Clicks on the continue button
    And User manually enters OTP and submits
    Then User should be registered successfully
