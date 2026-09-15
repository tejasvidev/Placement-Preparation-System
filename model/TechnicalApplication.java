package model;

public class TechnicalApplication extends Application{
    public TechnicalApplication(Student student , Job job){
        super(student, job);
    }

    @Override 
    public void processApplication(){
        System.out.println("Processing technical application...");
        status="UNDER-REVIEW";
    }
}