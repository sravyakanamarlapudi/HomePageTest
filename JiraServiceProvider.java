package com.demo.utility;
import net.rcarz.jiraclient.*;
public class JiraServiceProvider {
    private JiraClient Jira;
    private String project;
    private String JiraUrl;
    public JiraServiceProvider(String JiraUrl, String username, String password, String project) {
        this.JiraUrl=JiraUrl;
        // create basic authentication object
        BasicCredentials creds = new BasicCredentials("ksaranya1411@gmail.com", "ATATT3xFfGF0-j86jMJPfFH9uwmOkw88QmeeavKwzHMgn7NEyQ0eDbDW5RJSKTsTZH9pyc8j4Vo1QM5iK50yE0BEeCygAhHyozwz7qDbr5MbL7CI1H9zXhJaHkFyCknPNELijsZMbPjzpqSMI4qH9mPIZWVq1aFCs2t4WGpeDGua66GbOX98c5g=19CC9E5F");
        // initialize the Jira client with the url and the credentials
        Jira = new JiraClient(JiraUrl, creds);
        this.project = project;
    }
    public void createJiraIssue(String issueType, String summary, String description, String reporterName) {
        try {
            //Avoid Creating Duplicate Issue
            Issue.SearchResult sr = Jira.searchIssues("summary~ \""+summary+"\"");
            if(sr.total!=0) {
                System.out.println("Same Issue Already Exists on Jira");
                return;
            }
            //Create issue if not existso
            Issue.FluentCreate fleuntCreate = Jira.createIssue(project, issueType);
            fleuntCreate.field(Field.SUMMARY, summary);
            fleuntCreate.field(Field.DESCRIPTION, description);
            Issue newIssue = fleuntCreate.execute();
            System.out.println("********************************************");
            System.out.println("New issue created in Jira with ID: " + newIssue);
            System.out.println("New issue URL is :"+JiraUrl+"/browse/"+newIssue);
            System.out.println("*******************************************");
        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}