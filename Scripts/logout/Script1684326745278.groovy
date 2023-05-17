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
	
//check logout option
condition_loginOptionPresent = Mobile.waitForElementPresent(option_logout, 10, FailureHandling.OPTIONAL)
if(condition_loginOptionPresent) {
	KeywordUtil.logInfo('Logout option is present.')
	Mobile.tap(option_logout, 10)
}
else
	KeywordUtil.markFailedAndStop('Logout option is missing from side menu.')
	
//check logout confirmation title
condition_titleConfirmationPresent = Mobile.waitForElementPresent(title_confirmation, 10, FailureHandling.OPTIONAL)
if(condition_titleConfirmationPresent) {
	KeywordUtil.logInfo('Logout  confirmation title is present.')
	condition_titleConfirmationText = Mobile.verifyElementText(title_confirmation, expected_titleConfirmation, FailureHandling.OPTIONAL)
	if(condition_titleConfirmationText) {
		KeywordUtil.logInfo('Logout  confirmation title is correct.')
	}
	else
		KeywordUtil.markError('Login confirmation title is incorrect.')
}
else
	KeywordUtil.markError('Login confirmation title is incorrect.')
	
//check logout confirmation text
condition_ConfirmationText = Mobile.verifyElementText(text_confirmation, expected_textConfirmation, FailureHandling.OPTIONAL)
if(condition_ConfirmationText) {
	KeywordUtil.logInfo('Logout  confirmation text is correct.')
	System.out.println("Logout  confirmation text is: {$expected_textConfirmation}") //This will show in console
}
else
	KeywordUtil.markError('Logout confirmation text is incorrect.')

////check logout success
//condition_titleAfterLogin = Mobile.waitForElementPresent(title_products, 10, FailureHandling.OPTIONAL)
//if(condition_titleAfterLogin) {
//	KeywordUtil.logInfo('Login is successfull.')
//}
//else
//	KeywordUtil.markFailedAndStop('Login is not working.')
//	

////check title text after login
//def title = Mobile.getText(title_products, 10)
//condition_verifyTitleProducts = Mobile.verifyEqual(title, 'Products')
//if(condition_verifyTitleProducts) {
//	KeywordUtil.markPassed('Title after login is correct.')
//}
//else
//	KeywordUtil.markErrorAndStop('Title after login is incorrect.')





//Mobile.closeApplication()


