package com.demo.listener;
//TestListener.java
import com.demo.utility.JiraCreateIssue;
import com.demo.utility.JiraServiceProvider;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();
        if (islogIssue) {
            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://sravya2001.atlassian.net/",

                    "ksaranya1411@gmail.com", "ATATT3xFfGF0-j86jMJPfFH9uwmOkw88QmeeavKwzHMgn7NEyQ0eDbDW5RJSKTsTZH9pyc8j4Vo1QM5iK50yE0BEeCygAhHyozwz7qDbr5MbL7CI1H9zXhJaHkFyCknPNELijsZMbPjzpqSMI4qH9mPIZWVq1aFCs2t4WGpeDGua66GbOX98c5g=19CC9E5F",
                    "JTD");

            String issueDescription = "Failure Reason-1 from Automation Testing\n\n" + result.getThrowable().getMessage()

                    + "\n";
            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

            String issueSummary = "New Issue -1 Summary"+result.getMethod().getConstructorOrMethod().getMethod().getName()

                    + " Failed in Automation Testing";

            JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

// TODO Auto-generated method stub

    }

    @Override

    public void onStart(ITestContext context) {

// TODO Auto-generated method stub
    }

    @Override

    public void onFinish(ITestContext context) {

// TODO Auto-generated method stub
    }

    @Override

    public void onTestStart(ITestResult result) {

// TODO Auto-generated method stub

    }

    @Override

    public void onTestSuccess(ITestResult result) {

// TODO Auto-generated method stub

    }

}