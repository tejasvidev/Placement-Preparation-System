package model;

public class NonTechnicalApplication extends Application{
    public NonTechnicalApplication(Student student , Job job){
        super(student, job);
    }

    @Override 
    public void processApplication(){
        System.out.println("Processing non-technical application...");

        status="UNDER-REVIEW";
    }
    
}


