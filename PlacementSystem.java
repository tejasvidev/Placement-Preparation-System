import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exceptions.DuplicateApplicationException;
import exceptions.NotEligibleException;
import java.util.InputMismatchException;

import model.Application;
import model.Interview;
import model.Student;
import model.Job;
import model.TechnicalApplication;
import model.NonTechnicalApplication;

public class PlacementSystem {

    private static final List<Application> applications = new ArrayList<>();
    
    private static final List<Job> jobs = new ArrayList<>();
    
    private static final List<Student> students = new ArrayList<>();

    private static final List<Interview> interviews = new ArrayList<>();

    public static void showMainMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n========================================");
            System.out.println("   SMART CAMPUS PLACEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Student");
            System.out.println("2. Employer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        studentMenu(scanner);
                        break;
                    case 2:
                        employerMenu(scanner);
                        break;
                    case 3:
                        System.out.println("Thank you for using the system.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }

    public static void studentMenu(Scanner scanner){
        while (true){
            System.out.println("\n========================================");
            System.out.println("   STUDENT PORTAL");
            System.out.println("========================================");
            System.out.println("1. View available jobs");
            System.out.println("2. Submit Application");
            System.out.println("3. View Interview Schedule");
            System.out.println("4. Check application status");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewAvailableJobs();
                        break;
                    case 2:
                    submitStudentApplication(scanner);
                    break;
                case 3:
                    viewInterviewSchedule(scanner);
                    break;
                case 4:
                    checkApplicationStatus(scanner);
                    break;
                case 5:
                    System.out.println("Logging out from Student portal.");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public static void employerMenu(Scanner scanner){
        while (true){
            System.out.println("\n========================================");
            System.out.println("   EMPLOYER PORTAL");
            System.out.println("========================================");
            System.out.println("1. Post a job");
            System.out.println("2. View applications");
            System.out.println("3. Schedule Interview");
            System.out.println("4. Update Application Status");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        postJob(scanner);
                        break;
                    case 2:
                        viewApplications();
                        break;
                    case 3:
                        scheduleInterview(scanner);
                        break;
                case 4:
                    updateApplicationStatus(scanner);
                    break;
                case 5:
                    System.out.println("Logging out from Employer portal.");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public static void viewAvailableJobs() {
        if (jobs.isEmpty()) {
            System.out.println("\nNo jobs available at the moment.");
            return;
        } else {
            System.out.println("Available Jobs:");
            for (Job job : jobs) {
                System.out.println("Job ID       : " + job.getJobId());
                System.out.println("Role         : " + job.getRole());
                System.out.println("Minimum CGPA : " + job.getMinimumCgpa());
                System.out.println("Branch       : " + job.getEligibleBranch());
                System.out.println("----------------------------------------");
            }
        }
    } 

    public static void initializeStudents() {

        students.add(new Student(
                101,
                "Alice Johnson",
                "alice.johnson@example.com",
                8.2,
                "CSE"
        ));

        students.add(new Student(
                102,
                "Bob Smith",
                "bob.smith@example.com",
                7.5,
                "CE"
        ));

        students.add(new Student(
                103,
                "Charlie Brown",
                "charlie.brown@example.com",
                4.0,
                "CSE"
        ));
    }


    public static void initializeJobs() {

        jobs.add(new Job(
                "CAE-JAVA",
                "Java Developer",
                7.8,
                "CE"
        ));

        jobs.add(new Job(
                "CAE-PY",
                "Python Developer",
                8.0,
                "CSE"
        ));

        jobs.add(new Job(
                "CAE-WEB",
                "Web Developer",
                7.5,
                "CE"
        ));
    }

    public static void postJob(Scanner scanner) {
        System.out.print("\nEnter Job ID: ");
        String jobId = scanner.nextLine();

        System.out.print("Enter Job Role: ");
        String role = scanner.nextLine();

        System.out.print("Enter Minimum CGPA: ");
        double minCgpa = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Eligible Branch: ");
        String eligibleBranch = scanner.nextLine();

        Job job = new Job(jobId, role, minCgpa, eligibleBranch);
        jobs.add(job);

        System.out.println("\nJob posted successfully.");
    }

    public static void viewApplications() {

        if (applications.isEmpty()) {
            System.out.println("\nNo applications available.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("          APPLICATIONS");
        System.out.println("========================================");

        for (Application application : applications) {

            System.out.println(
                    "Student : " + application.getStudent().getName()
            );

            System.out.println(
                    "Student ID : " +
                    application.getStudent().getStudentId()
            );

            System.out.println(
                    "Job : " + application.getJob().getRole()
            );

            System.out.println(
                    "Status : " + application.getStatus()
            );

            System.out.println("----------------------------------------");
        }
    }

    public static void scheduleInterview(Scanner scanner) {

        if (applications.isEmpty()) {
            System.out.println("\nNo applications available.");
            return;
        }

        System.out.print("\nEnter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Job ID: ");
        String jobId = scanner.next();

        Application selectedApplication = null;

        for (Application application : applications) {

            if (application.getStudent().getStudentId() == studentId
                    && application.getJob().getJobId().equals(jobId)) {

                selectedApplication = application;
                break;
            }
        }

        if (selectedApplication == null) {
            System.out.println("Application not found.");
            return;
        }

        System.out.println("\nSelect Interview Type:");
        System.out.println("1. Technical");
        System.out.println("2. Non-Technical");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        String interviewType;

        if (choice == 1) {
            interviewType = "Technical";
        } else if (choice == 2) {
            interviewType = "Non-Technical";
        } else {
            System.out.println("Invalid interview type.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter Interview Date: ");
        String date = scanner.nextLine();

        Interview interview = new Interview(
                selectedApplication,
                interviewType,
                date
        );

        interview.scheduleInterview();

        interviews.add(interview);

        System.out.println("Interview added to schedule.");
    }

    public static void updateApplicationStatus(Scanner scanner) {

        if (applications.isEmpty()) {
            System.out.println("\nNo applications available.");
            return;
        }

        System.out.print("\nEnter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Job ID: ");
        String jobId = scanner.next();

        Application selectedApplication = null;

        for (Application application : applications) {

            if (application.getStudent().getStudentId() == studentId
                    && application.getJob().getJobId().equals(jobId)) {

                selectedApplication = application;
                break;
            }
        }

        if (selectedApplication == null) {
            System.out.println("Application not found.");
            return;
        }

        System.out.println("\nSelect Status:");
        System.out.println("1. Accepted");
        System.out.println("2. Rejected");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            selectedApplication.setStatus("ACCEPTED");

        } else if (choice == 2) {

            selectedApplication.setStatus("REJECTED");

        } else {

            System.out.println("Invalid status.");
            return;
        }

        System.out.println("\nApplication status updated successfully.");
    }

    public static void submitStudentApplication(Scanner scanner){
        System.out.println("\nEnter Student ID: ");
        int studentId = scanner.nextInt();
        Student student= findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        viewAvailableJobs();

        System.out.println("\nEnter Job ID to apply for: ");
        String jobId = scanner.next();

        Job job = findJobById(jobId);

        if (job == null) {
            System.out.println("Job not found.");
            return;
        }

        System.out.println("\nSelect Application Type:");
        System.out.println("1. Technical Application");     
        System.out.println("2. Non-Technical Application");
        int type = scanner.nextInt();

        Application application;

        if (type == 1) {
            application = new TechnicalApplication(student, job);
        } else if (type == 2) {
            application = new NonTechnicalApplication(student, job);
        } else {
            System.out.println("Invalid application type selected.");
            return;
        }

        processApplication(application);
    }


    public static void viewInterviewSchedule(Scanner scanner) {

        System.out.print("\nEnter Student ID: ");
        int studentId = scanner.nextInt();

        boolean found = false;

        System.out.println("\n========================================");
        System.out.println("        INTERVIEW SCHEDULE");
        System.out.println("========================================");

        for (Interview interview : interviews) {

            if (interview.getApplication()
                    .getStudent()
                    .getStudentId() == studentId) {

                interview.displayInterviewDetails();
                System.out.println("----------------------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No interview scheduled for this student.");
        }
    }


    public static void checkApplicationStatus(Scanner scanner) {

        System.out.print("\nEnter Student ID: ");
        int studentId = scanner.nextInt();

        boolean found = false;

        System.out.println("\n========================================");
        System.out.println("       APPLICATION STATUS");
        System.out.println("========================================");

        for (Application application : applications) {

            if (application.getStudent().getStudentId() == studentId) {

                application.displayApplication();
                System.out.println("----------------------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No applications found for this student.");
        }
    }


    public static Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public static Job findJobById(String jobId) {
        for (Job job : jobs) {
            if (job.getJobId().equals(jobId)) {
                return job;
            }
        }
        return null;
    }

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
                appi.getJob().getJobId().equals(job.getJobId())) {

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

            System.out.println(appli.getApplicationSummary());

        } catch (NotEligibleException e) {

            System.out.println(
                    "Application rejected: " + e.getMessage()
            );

        } catch (DuplicateApplicationException e) {

            System.out.println(
                    "Application rejected: " + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Application processing completed."
            );
        }
    }


    public static void main(String[] args) {

        initializeStudents();
        initializeJobs();
        showMainMenu();
    }
}