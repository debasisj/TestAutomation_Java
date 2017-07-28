package com.dbschenker.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtil {
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;
    private static ExtentReports extent;
    public static void initReport(){
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\djagadeb\\Source\\Repos\\TestAutomation_Java\\src\\Reports\\RT.html");
        //create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        }

    public static ExtentHtmlReporter getHtmlReporter() {
        return htmlReporter;
    }

    public static void initializeTest(String testName){
        test = extent.createTest("Login Test");

    }

    public static void  passTest(String comment){
        test.pass(comment);
    }

    public static void  failTest(String comment){
        failTest(comment);
    }

    public static void createReport(){
        extent.flush();
    }

}
