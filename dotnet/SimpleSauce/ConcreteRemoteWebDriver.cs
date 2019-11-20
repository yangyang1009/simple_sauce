﻿using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Remote;
using System;

namespace SimpleSauce
{
    class ConcreteRemoteWebDriver : IRemoteDriver
    {
        public IWebDriver CreateRemoteWebDriver(DriverOptions browserOptions)
        {
            return new RemoteWebDriver(new Uri("https://ondemand.saucelabs.com/wd/hub"),
                browserOptions.ToCapabilities(), TimeSpan.FromSeconds(600));
        }
    }
}