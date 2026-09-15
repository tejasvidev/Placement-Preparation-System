package model;

import interfaces.Interviewable;

public class Interview implements Interviewable{
    private final int interviewId;
    private static int nextInterviewId=1001;
    private Application application;
    private String interviewType;
    private String date;
    private String status;

    public Interview( Application application, String interviewType, String date){
        this.interviewId=nextInterviewId++;
        this.application= application;
        this.interviewType=interviewType;
        this.date=date;
        this.status="Scheduled";

    }

    @Override 
    public void scheduleInterview(){
        System.out.println("Interview scheduled successfully.");

        status="Scheduled";
    }

    @Override 
    public void conductInterview(){
        status="Conducted";
        System.out.println("Interview conducted successfully.");
    }

    public void displayInterviewDetails(){
        System.out.println("Interview Id: "+interviewId);
        System.out.println("Type: "+interviewType);
        System.out.println("Date: "+date);
        System.out.println("Status: "+status);
    }
}