package model;

public abstract class Application{
    protected Student student;
    protected Job job;
    protected String status;

    public Application(Student student, Job job){
        this.student=student;
        this.job=job;
        this.status="SUBMITTED";
    }

    public abstract void processApplication();

    public void displayApplication(){
        System.out.println("Student: "+student.getName());
        System.out.println("Job: "+ job.getRole());
        System.out.println("Status: "+status);
    }

    public Student getStudent(){
        return student;
    }

    public Job getJob(){
        return job;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public String getApplicationSummary(){
        StringBuilder summary = new StringBuilder();

        summary.append("Student: ");
        summary.append(student.getName());
        summary.append(" | Job: ");
        summary.append(job.getRole());
        summary.append(" | Status: ");
        summary.append(status);

        return summary.toString();
    }
}
