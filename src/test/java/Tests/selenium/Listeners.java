package Tests.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Calendar;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Testcase started:" + iTestResult.getName() + " " + Calendar.getInstance().getTime());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Testcase passed:" + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Testcase failed" + iTestResult.getName() + iTestResult.getEndMillis());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Testcase Skipped:" + iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
