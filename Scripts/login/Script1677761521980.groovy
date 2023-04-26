import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.AppPath, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, false)

//check app is launched
condition_appLaunch = Mobile.waitForElementPresent(title_home, 10, FailureHandling.OPTIONAL)
if(condition_appLaunch)
	KeywordUtil.logInfo('App launched successfully.')
else
	KeywordUtil.markFailedAndStop('App is not launched.')
	

//check menu button
condition_menuButtonPresent = Mobile.waitForElementPresent(button_menu, 10, FailureHandling.OPTIONAL)
if(condition_menuButtonPresent) {
	KeywordUtil.logInfo('Menu button is present.')
	Mobile.tap(button_menu, 10)
}
else
	KeywordUtil.markFailedAndStop('Menu button is not present.')
	
//check login option
condition_loginOptionPresent = Mobile.waitForElementPresent(option_login, 10, FailureHandling.OPTIONAL)
if(condition_loginOptionPresent) {
	KeywordUtil.logInfo('Login option is present.')
	Mobile.tap(option_login, 10)
}
else
	KeywordUtil.markFailedAndStop('Login option is missing from side menu.')

//check username field
condition_usernamePresent = Mobile.waitForElementPresent(textField_username, 10, FailureHandling.OPTIONAL)
if(condition_usernamePresent) {
	KeywordUtil.logInfo('Username field is present.')
	Mobile.setText(textField_username, username, 10)
}
else
	KeywordUtil.markFailedAndStop('Username field is missing.')


//check password field
condition_passwordPresent = Mobile.waitForElementPresent(textField_password, 10, FailureHandling.OPTIONAL)
if(condition_passwordPresent) {
	KeywordUtil.logInfo('Password field is present.')
	Mobile.setText(textField_password, password, 10)
}
else
	KeywordUtil.markFailedAndStop('Password field is missing.')


//check login button on login screen
condition_loginButtonPresent = Mobile.waitForElementPresent(button_login, 10, FailureHandling.OPTIONAL)
if(condition_loginButtonPresent) {
	KeywordUtil.logInfo('Login button is present.')
	Mobile.tap(button_login, 10)
}
else
	KeywordUtil.markFailedAndStop('Login button is missing.')


//check login success
condition_titleAfterLogin = Mobile.waitForElementPresent(title_products, 10, FailureHandling.OPTIONAL)
if(condition_titleAfterLogin) {
	KeywordUtil.logInfo('Login is successfull.')
}
else
	KeywordUtil.markFailedAndStop('Login is not working.')
	

//check title text after login
def title = Mobile.getText(title_products, 10)
condition_verifyTitleProducts = Mobile.verifyEqual(title, 'Products')
if(condition_verifyTitleProducts) {
	KeywordUtil.markPassed('Title after login is correct.')
}
else
	KeywordUtil.markErrorAndStop('Title after login is incorrect.')





Mobile.closeApplication()


