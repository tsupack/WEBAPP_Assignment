package hu.iit.me.dao;

import hu.iit.me.exception.*;
import hu.iit.me.model.*;

import java.util.ArrayList;

public class DaoImplementation implements DaoInterface {
    private ArrayList<Job> jobs;
    private Job job_0;
    private Job job_1;
    private Job job_2;
    private Job job_3;
    private Job job_4;

    private ArrayList<Applicant> applicants;
    private Applicant applicant_0;
    private Applicant applicant_1;
    private Applicant applicant_2;

    private ArrayList<Application> applications;
    private Application application_0;
    private Application application_1;
    private Application application_2;
    private Application application_3;
    private Application application_4;

    private boolean firstRun= true;
    private boolean found=false;

    public DaoImplementation () throws InvalidIDException, InvalidInputFormatException, EmptyFieldException, NegativeValueException{
        this.jobs = new ArrayList<>();
        this.job_0 = new Job(1, "IP_technician", "Budapest", "Magyar_Telekom", "IP_Technician.");
        this.job_1 = new Job(2, "Java_Senior_developer", "Miskolc", "Evosoft", "Java_Developer.");
        this.job_2 = new Job(3, "Project_manager", "Debrecen", "Magyar_Telekom", "Network_Development_Project_Manager.");
        this.job_3 = new Job(4, "Documentation_technician", "Miskolc", "Evosoft", "Documentation technician.");
        this.job_4 = new Job(5, "Sales_Assistant", "Miskolc", "Magyar_Telekom", "Sales_assistant.");

        this.applicants = new ArrayList<>();
        this.applicant_0 = new Applicant(1,"Kiss_Istvan","kiss.istvan@gmail.com","06203035678",25);
        this.applicant_1 = new Applicant(2,"Darabos_Barna","darabos.barna@gmail.com","06303035678",45);
        this.applicant_2 = new Applicant(3,"Kelletlen_Ferenc","ferike@gmail.com","06703035678",35);

        this.applications = new ArrayList<>();
        this.application_0 = new Application(1, applicant_0, job_0);
        this.application_1 = new Application(2, applicant_1, job_1);
        this.application_2 = new Application(3, applicant_2, job_2);
        this.application_3 = new Application(4, applicant_0, job_3);
        this.application_4 = new Application(5, applicant_1, job_4);
    }

    public void initialize(){
        if(firstRun){
            jobs.add(job_0);
            jobs.add(job_1);
            jobs.add(job_2);
            jobs.add(job_3);
            jobs.add(job_4);
            applicants.add(applicant_0);
            applicants.add(applicant_1);
            applicants.add(applicant_2);
            applications.add(application_0);
            applications.add(application_1);
            applications.add(application_2);
            applications.add(application_3);
            applications.add(application_4);
            firstRun = false;
        }
    }

    @Override
    public ArrayList<Job> getJobs(){
        initialize();
        return jobs;
    }

    @Override
    public ArrayList<Applicant> getApplicants() {
        initialize();
        return applicants;
    }

    @Override
    public ArrayList<Application> getApplications() {
        initialize();
        return applications;
    }

    @Override
    public void addJob(int id, String name, String location, String company, String description) throws InvalidIDException, EmptyFieldException{
        Job job = new Job(id,name,location,company,description);
        getJobs();
        jobs.add(job);
    }

    @Override
    public void deleteJob(int id) throws JobNotFoundException{
        for (Job job: jobs) {
            if(job.getJobID() == id){
                jobs.remove(job);
                found=true;
            }
        }
        if (!found){
            throw new JobNotFoundException();
        }
    }
}
