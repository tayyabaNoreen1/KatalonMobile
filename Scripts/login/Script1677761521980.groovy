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

condition_appLaunch = Mobile.waitForElementPresent(findTestObject('Object Repository/Top Bar/title_home'), 10, , FailureHandling.OPTIONAL)

if(condition_appLaunch)
	KeywordUtil.logInfo('App launched successfully.')
else
	KeywordUtil.markFailedAndStop('App is not launched.')

Mobile.tap(findTestObject('Object Repository/Top Bar/button_menu'), 10)

Mobile.tap(findTestObject('Object Repository/Side Menu/option_login'), 10)

Mobile.setText(findTestObject('Object Repository/Login/textField_username'), "bob@example.com", 10)

Mobile.setText(findTestObject('Object Repository/Login/textField_password'), "10203040", 10)

Mobile.tap(findTestObject('Object Repository/Login/button_login'), 10)


def title = Mobile.getText(findTestObject('Object Repository/Login/title_products'), 10)


Mobile.verifyEqual(title, 'Products')

Mobile.closeApplication()


