package model;

public class Recruiter extends User{

    private final int recruiterId;
    private String companyName;

    public Recruiter(int recruiterId, String name, String email, String companyName){
        super(name, email);

        this.recruiterId=recruiterId;
        this.companyName=companyName;
    }

    public void displayRecruiterDetails(){
        System.out.println("Recruiter Id: "+recruiterId);
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Company: "+companyName);
    }

    public void createJob(Job job){
        System.out.println("Job created successfully: "+job.getRole());
    }
}

