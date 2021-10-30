Feature: LoginFacebook1

  @smoke @Test_id_Sanchit
  Scenario: Test Login1 -- SC2
  Given user loads fixture "./src/test/resources/fixtures/login1.xlsx"
    And user launches "chrome"
    And user navigate to url "https://www.facebook.com"
    #And user enters "Test@test.com" into "//*[@id='email']"
    #And user enters "PWD12345" into "//*[@id='pass']"
    And user enters "#uid" into "//*[@id='email']"
    And user enters "#pwd" into "//*[@id='pass']"
    And user clicks on "English (UK)"
    And user captures "//*[@class='_8eso']" into "#NewData"