from simplesauce.options import SauceOptions


class TestSafariOptions(object):

    def test_defaults(self):
        sauce = SauceOptions('Safari')

        assert sauce.browserName == 'safari'
        assert sauce.browserVersion == 'latest'
        assert sauce.platformName == 'macos 10.14'
