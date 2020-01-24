/**
 * Copyright (c) 2017-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

const React = require('react');

class Footer extends React.Component {
  docUrl(doc, language) {
    const baseUrl = this.props.config.baseUrl;
    const docsUrl = this.props.config.docsUrl;
    const docsPart = `${docsUrl ? `${docsUrl}/` : ''}`;
    const langPart = `${language ? `${language}/` : ''}`;
    return `${baseUrl}${docsPart}${langPart}${doc}`;
  }

  pageUrl(doc, language) {
    const baseUrl = this.props.config.baseUrl;
    return baseUrl + (language ? `${language}/` : '') + doc;
  }

  render() {
    return (
      <footer className="nav-footer" id="footer">
        <section className="sitemap">
          <div className="wrapper">
            <div>
              <h5>Docs</h5>
              <a href={this.docUrl('gettingstarted.html', this.props.language)}>
                Getting Started
              </a>
            </div>
            <div>
              <h5>Community</h5>
              <a
                href="https://stackoverflow.com/questions/tagged/simplesauce"
                target="_blank"
                rel="noreferrer noopener">
                Stack Overflow
              </a>
              <a href="https://gitter.im/simple-sauce">Project Chat</a>
              <a
                href="https://twitter.com/saucelabs"
                target="_blank"
                rel="noreferrer noopener">
                Twitter
              </a>
            </div>
            <div>
              <h5>More</h5>
              <a href="https://Saucelabs.com">Sauce Labs</a>
              <a href="https://github.com/saucelabs/simple_sauce">GitHub</a>
              <a
                className="github-button"
                href={this.props.config.repoUrl}
                data-icon="octicon-star"
                data-count-href="/facebook/docusaurus/stargazers"
                data-show-count="true"
                data-count-aria-label="# stargazers on GitHub"
                aria-label="Star this project on GitHub">
                Star
              </a>
              {this.props.config.twitterUsername && (
                <div className="social">
                  <a
                    href={`https://twitter.com/${this.props.config.twitterUsername}`}
                    className="twitter-follow-button">
                    Follow @{this.props.config.twitterUsername}
                  </a>
                </div>
              )}
              {this.props.config.facebookAppId && (
                <div className="social">
                  <div
                    className="fb-like"
                    data-href={this.props.config.url}
                    data-colorscheme="dark"
                    data-layout="standard"
                    data-share="true"
                    data-width="225"
                    data-show-faces="false"
                  />
                </div>
              )}
            </div>
          </div>
        </section>
        <section className="footer-links">
          <div className="wrapper">
            <div className="social-container">
              <p>Follow us</p>
              <a href="https://www.facebook.com/saucelabs" target="_blank" data-ta="click" data-tc="Icon" data-tl="facebook"><i className="svg svg-facebook"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-3 7h-1.924c-.615 0-1.076.252-1.076.889v1.111h3l-.238 3h-2.762v8h-3v-8h-2v-3h2v-1.923c0-2.022 1.064-3.077 3.461-3.077h2.539v3z"></path></svg></i></a>
              <a href="https://www.linkedin.com/company/891955" target="_blank" data-ta="click" data-tc="Icon" data-tl="linkedin"><i className="svg svg-linkedin"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-11 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.79 1.75 1.764-.783 1.764-1.75 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.396-2.586 7-2.777 7 2.476v6.759z"></path></svg></i></a>
              <a href="https://twitter.com/saucelabs" target="_blank" data-ta="click" data-tc="Icon" data-tl="twitter"><i className="svg svg-twitter"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-.139 9.237c.209 4.617-3.234 9.765-9.33 9.765-1.854 0-3.579-.543-5.032-1.475 1.742.205 3.48-.278 4.86-1.359-1.437-.027-2.649-.976-3.066-2.28.515.098 1.021.069 1.482-.056-1.579-.317-2.668-1.739-2.633-3.26.442.246.949.394 1.486.411-1.461-.977-1.875-2.907-1.016-4.383 1.619 1.986 4.038 3.293 6.766 3.43-.479-2.053 1.08-4.03 3.199-4.03.943 0 1.797.398 2.395 1.037.748-.147 1.451-.42 2.086-.796-.246.767-.766 1.41-1.443 1.816.664-.08 1.297-.256 1.885-.517-.439.656-.996 1.234-1.639 1.697z"></path></svg></i></a>
            </div>
            <div className="link-container">
              <a className="link" href="https://saucelabs.com/privacy-policy" target="" data-ta="click" data-tc="Text" data-tl="">Privacy Policy</a>
              <a className="link" href="https://saucelabs.com/terms-of-service" target="" data-ta="click" data-tc="Text" data-tl="">Terms of Service </a>
              <a className="link" href="https://saucelabs.com/eea" target="" data-ta="click" data-tc="Text" data-tl="">EEA</a>
              <a className="link" href="https://saucelabs.com/ccpa" target="" data-ta="click" data-tc="Text" data-tl="">CCPA</a>
            </div>
          </div>
        </section>
        <section className="footer-copyright">
          <div className="wrapper">
            <a
              href="https://opensource.facebook.com/"
              target="_blank"
              rel="noreferrer noopener"
              className="fbOpenSource">
              <img
                src={`${this.props.config.baseUrl}img/oss_logo.png`}
                alt="Facebook Open Source"
                width="170"
                height="45"
              />
            </a>
            <p className="copyright">{this.props.config.copyright}</p>
          </div>
        </section>
      </footer>      
    );
  }
}

module.exports = Footer;
