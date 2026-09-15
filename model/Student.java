package model;

import interfaces.Eligible; 


public class Student extends User implements Eligible{
    private final int studentId;
    private static int totalStudents=0;
    private double cgpa;
    private String branch;

    public Student(int studentId, String name, String email, double cgpa, String branch){
        super(name, email);
        totalStudents++;

        this.studentId=studentId;
        this.cgpa=cgpa;
        this.branch=branch;
    }

    public int getStudentId(){
        return studentId;
    }

    public void displayStudentDetails(){
        System.out.println("Student Id: "+studentId);
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("CGPA: "+cgpa);
        System.out.println("Branch: "+branch);
    }

    @Override 
    public boolean checkEligibility(Job job){
        return this.cgpa>= job.getMinimumCgpa() && this.branch.equalsIgnoreCase(job.getEligibleBranch());
    }

    public static int getTotalStudents(){
        return totalStudents;
    }

    public void displayFormattedProfile(){
        String studentName= name.trim();
        System.out.println("Student name: "+ studentName.toUpperCase());
        System.out.println("Name length: "+ studentName.length());
        System.out.println("First Character: "+ studentName.charAt(0));
        System.out.println("Email Domain: "+ email.substring(email.indexOf("@")+1));
    }

    public boolean isValidEmail(){
        return email.contains("@") && email.contains(".") && email.indexOf("@")<email.lastIndexOf(".");
    }
}



