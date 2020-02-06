# Sauce Labs Python Bindings

Hello, welcome to the Sauce Python bindings! Let's make using Sauce Labs Simple!

## Example Usage

The goal of the Sauce bindings is to provide a straightforward approach to connecting your automated scripts to Sauce. Here's an example. The Sauce Python bindings can be used like this:

```
from saucebindings.session import SauceSession

session = SauceSession()

driver = session.driver
driver.get("www.saucedemo.com")

session.stop("passed")
```
## Requirements

Set your Sauce username and Sauce access key as [environment variables](https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Environment+Variables+for+Authentication+Credentials)

## Installation

Clone this project to build from source
```
git clone https://github.com/saucelabs/sauce_bindings
python setup.py install
```
or install from [pip](https://pip.pypa.io/en/stable/):
```
pip install saucebindings
```

## Development

This project will be developed initially in Python 3.x so please create a [virtual environment](https://packaging.python.org/guides/installing-using-pip-and-virtual-environments/):

```
python3 -m venv venv
source venv/bin/activate
```

To install dependencies, do the following:
```
pip install -r requirements.txt
```

## Testing

To run all tests, run the following:
```
pytest
```
