package core;

import logger.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.AllureReportManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        //Logger.debug(result.getTestClass().getTestName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.error(result.getThrowable().getMessage());
        AllureReportManager.takeAndAttachScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.error(result.getThrowable().getMessage());
    }
}
