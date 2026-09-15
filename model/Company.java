package model;

public class Company{
    private final String companyId;
    private String companyName;
    private String location;

    public Company(String companyId, String companyName, String location){
        this.companyId=companyId;
        this.companyName=companyName;
        this.location=location;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getLocation(){
        return location;
    }
    
}