Feature: LoginFacebook3

  @Test_id_Anand3
  Scenario: Test Login3
    Given user loads fixture "./src/test/resources/fixtures/login3.xlsx"
    And user launches "chrome"
    And user navigate to url "https://www.facebook.com"
    And user enters "#uid" into "//*[@id='email']"
    And user enters "#pwd" into "//*[@id='pass']"
    And user clicks on "English (UK)"
    And user captures "//*[@class='_8eso']" into "#NewData"
