import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil

import internal.GlobalVariable


def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.AppPath, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, false)

Mobile.tap(findTestObject('Object Repository/Top Bar/button_menu'), 10)

Mobile.tap(findTestObject('Object Repository/Side Menu/option_login'), 10)

Mobile.setText(findTestObject('Object Repository/Login/textField_username'), "bob@example.com", 10)

Mobile.setText(findTestObject('Object Repository/Login/textField_password'), "10203040", 10)

Mobile.tap(findTestObject('Object Repository/Login/button_login'), 10)


def title = Mobile.getText(findTestObject('Object Repository/Login/title_products'), 10)


Mobile.verifyEqual(title, 'Products')

Mobile.closeApplication()


