package org.qamation.testng.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.reporters.DotTestListener;


public class TestTestNGListener extends DotTestListener {
    private static final Logger log = LoggerFactory.getLogger(TestTestNGListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info(" ..... onTestStart ..... ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(" ..... onTestSuccess ..... ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(" ..... onTestSkipped ..... ");
    }
}
