package com.demo.utility;// com.demo.utility.JiraCreateIssue.java
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
@Retention(RetentionPolicy.RUNTIME)
public @interface JiraCreateIssue {
    boolean isCreateIssue();
}