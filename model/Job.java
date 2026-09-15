package model;

public class Job{
    private final String jobId;
    private String role;
    private double minimumCgpa;
    private String eligibleBranch;

    public Job(String jobId, String role, double minimumCgpa, String eligibleBranch ){
        this.jobId=jobId;
        this.role=role;
        this.minimumCgpa=minimumCgpa;
        this.eligibleBranch=eligibleBranch;
        
    }

    public String getJobId(){
        return jobId;
    }

    public String getRole(){
        return role;
    }

    public double getMinimumCgpa(){
        return minimumCgpa;
    }

    public String getEligibleBranch(){
        return eligibleBranch;
    }
}