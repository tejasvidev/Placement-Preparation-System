import java.util.ArrayList;
import java.util.List;

import exceptions.DuplicateApplicationException;
import exceptions.NotEligibleException;

import model.Application;
import model.Interview;
import model.Student;
import model.Job;
import model.TechnicalApplication;
import model.NonTechnicalApplication;

public class PlacementSystem {

    private static final List<Application> applications =
            new ArrayList<>();

    public static Application submitApplication(Application application)
            throws NotEligibleException, DuplicateApplicationException {

        Student student = application.getStudent();
        Job job = application.getJob();

        if (!student.checkEligibility(job)) {
            throw new NotEligibleException(
                    "Student is not eligible for the job."
            );
        }

        for (Application appi : applications) {

            if (appi.getStudent().getStudentId() == student.getStudentId() &&
                appi.getJob().getJobId() == job.getJobId()) {

                throw new DuplicateApplicationException(
                        "Student has already applied for this job."
                );
            }
        }

        applications.add(application);

        return application;
    }


    public static void processApplication(Application application) {

    try {
        Application appli = submitApplication(application);

        appli.processApplication();
        appli.displayApplication();

        String interviewType;

        if (application instanceof TechnicalApplication) {
            interviewType = "Technical";
        } else {
            interviewType = "Non-Technical";
        }

        Interview interview = new Interview(
                appli,
                interviewType,
                "15 September 2026"
        );

        interview.scheduleInterview();
        interview.conductInterview();
        interview.displayInterviewDetails();
        appli.displayApplication();
    } catch (NotEligibleException e) {

        System.out.println(
                "Application rejected: " + e.getMessage()
        );

    } catch (DuplicateApplicationException e) {

        System.out.println(
                "Application rejected: " + e.getMessage()
        );
    } finally{
        System.out.println("Application processing completed.");
    }
}


    public static void main(String[] args) {

        Student student1 = new Student(
                101,
                "Tejasvi",
                "tejasvi2324@gmail.com",
                3.5,
                "CE"
        );

        Student student2 = new Student(
                102,
                "Devansh Vashishtha",
                "devansh2809@gmail.com",
                7.9,
                "CE"
        );

        Job job = new Job(
                "CAE-JAVA",
                "Java Developer",
                7.8,
                "CE"
        );

        processApplication(
                new TechnicalApplication(student1, job)
        );

        processApplication(
                new NonTechnicalApplication(student2, job)
        );

        System.out.println("Total students: " + Student.getTotalStudents());

        student1.displayFormattedProfile();
        student2.displayFormattedProfile();

        System.out.println("Valid email: "+ student1.isValidEmail());
        System.out.println("Valid email: "+ student2.isValidEmail());
    }
}