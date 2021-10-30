Feature: login5
@Login5
Scenario: Test login5

				
				And user launches "chrome"
				And user navigate to url "https://www.w3schools.com"
				When user clicks on "(//*[@title='Courses'])[2]"
				When user clicks on "(//*[@title='Get Your Own Website With W3shools Spaces'])[1]"
				When user clicks on "//a[@href='https://www.facebook.com/w3schoolscom/']"
				
				
				And user switch to window "Courses"
				#When user clicks on "//*[@id="user-nav"]//a"
				
				And user switch to window "Free"
				#When user clicks on "/html/body/div[1]/a[3]//button"
				
				And user switch to window "Facebook"
				#When user clicks on "(//*[@id='loginbutton'])[1]"
				
				And user switch to window "Online"
				#When user clicks on "//*[@title='Tutorials']"
				
				And user switch to window "Courses"