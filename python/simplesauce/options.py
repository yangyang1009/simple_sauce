from selenium.webdriver.chrome.options import Options as ChromeOptions
from selenium.webdriver.firefox.options import Options as FirefoxOptions
from selenium.webdriver import DesiredCapabilities


SUPPORTED_BROWSERS = ['chrome', 'firefox', 'internet explorer', 'safari', 'edge']
WINDOWS_PLATFORMS = ['windows 7', 'windows 8.1', 'windows 10']

class SauceOptions():

    def _set_defaults(self):
        self.browserName = 'chrome'
        self.browserVersion = 'latest'
        self.platformName = 'windows 10'

    def _setMacVersions(self, version, platform):
        # TODO: logic to associate correct browser versions with OS versions
        self.browserName = 'safari'
        self.browserVersion = '12'
        self.platformName = 'macos 10.14'

    def __init__(self, browserName=None, browserVersion=None, platformName=None, options={}):
        self._set_defaults()

        if browserName:
            browserName = browserName.lower()
            if browserName in SUPPORTED_BROWSERS:
                self.browserName = browserName
            else: 
                raise KeyError("Invalid browser name, please use on of the following: {}".format(SUPPORTED_BROWSERS))
            
        if browserVersion:
            self.browserVersion = browserVersion

        if platformName:
            if browserName == 'safari':
                self._setMacVersions(browserVersion, platformName)
            else:
                self.platformName = platformName

        if options:
            self.parseOptions(options)

    def parseOptions(self, options):

        if type(options) == ChromeOptions:
            self._set_defaults()
        elif type(options) == FirefoxOptions:
            self._set_defaults('firefox')
        elif 'version' in options:
            self.browserName = options['browserName'] if options['browserName'] else 'chrome'
            self.browserVersion = options['version'] if options['version'] else 'latest'
            self.platformName = 'windows 10' if not options['version'] else options['version']
        elif 'sauce:options' in options:
            w3cSauceOptions = options['sauce:options']
            self.browserName = w3cSauceOptions.get('browserName')
            self.browserVersion = w3cSauceOptions.get('browserVersion')
            self.platformName = w3cSauceOptions.get('platformName')
            self.name = w3cSauceOptions.get('name')
            self.build = w3cSauceOptions.get('build')
        else:
            self.browserName = options.get('browserName')
            self.browserVersion = options.get('browserVersion')
            self.platformName = options.get('platformName')
            self.name = options.get('name')
            self.build = options.get('build')
