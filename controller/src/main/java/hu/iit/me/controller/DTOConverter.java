package hu.iit.me.controller;

import hu.iit.me.dto.JobType;
import hu.iit.me.dto.ApplicantType;
import hu.iit.me.dto.ApplicationType;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.model.Applicant;
import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public class DTOConverter {
    public static JobType marshalJob(Job job) {
        JobType jobType = new JobType();
        jobType.setJobID(job.getJobID());
        jobType.setJobName(job.getJobName());
        jobType.setJobLocation(job.getJobLocation());
        jobType.setJobCompany(job.getCompany());
        jobType.setJobDescription(job.getJobDescription());
        return jobType;
    }

    public static ArrayList<JobType> marshalJobList(ArrayList<Job> jobs){
        ArrayList<JobType> jobTypeArrayList = new ArrayList<>();
        for(Job job : jobs){
            jobTypeArrayList.add(DTOConverter.marshalJob(job));
        }
        return jobTypeArrayList;
    }

    public static Job unmarshalJob(JobType jobType) throws EmptyFieldException {
        if(jobType.getJobID().isEmpty() | jobType.getJobName().isEmpty() | jobType.getJobLocation().isEmpty() | jobType.getJobCompany().isEmpty() | jobType.getJobDescription().isEmpty()){
            throw new EmptyFieldException();
        }
        return new Job(jobType.getJobID(), jobType.getJobName(), jobType.getJobLocation(),jobType.getJobCompany(),jobType.getJobDescription());
    }

    public static ArrayList<Job> unmarshalJobList(ArrayList<JobType> jobTypeArrayList) throws EmptyFieldException{
        ArrayList<Job> jobs = new ArrayList<>();
        for(JobType job : jobTypeArrayList){
            jobs.add(DTOConverter.unmarshalJob(job));
        }
        return jobs;
    }

    public static Applicant unmarshalApplicant(ApplicantType applicantType) throws EmptyFieldException{
        if(applicantType.getApplicantID().isEmpty() | applicantType.getApplicantName().isEmpty() | applicantType.getApplicantEmail().isEmpty() | applicantType.getApplicantPhone().isEmpty() | applicantType.getApplicantAge().isEmpty()){
            throw new EmptyFieldException();
        }
        return new Applicant(applicantType.getApplicantID(), applicantType.getApplicantName(), applicantType.getApplicantEmail(), applicantType.getApplicantPhone(), applicantType.getApplicantAge());
    }

    public static ArrayList<Applicant> unmasrhalApplicantList(ArrayList<ApplicantType> applicantTypes) throws EmptyFieldException {
        ArrayList<Applicant> applicants = new ArrayList<>();
        for (ApplicantType applicant: applicantTypes){
            applicants.add(DTOConverter.unmarshalApplicant(applicant));
        }
        return applicants;
    }

    public static ApplicantType marshalApplicant(Applicant applicant){
        ApplicantType applicantType = new ApplicantType();
        applicantType.setApplicantID(applicant.getApplicantID());
        applicantType.setApplicantName(applicant.getName());
        applicantType.setApplicantEmail(applicant.getEmail());
        applicantType.setApplicantPhoneNumber(applicant.getPhoneNumbe());
        applicantType.setApplicantAge(applicant.getAge());
        return applicantType;
    }

    public static ArrayList<ApplicantType> marshalApplicantList(ArrayList<Applicant> applicants) {
        ArrayList<ApplicantType> applicantTypes = new ArrayList<>();
        for(Applicant applicant : applicants){
            applicantTypes.add(DTOConverter.marshalApplicant(applicant));
        }
        return applicantTypes;
    }

    public static Application unmarshalApplication(ApplicationType ApplicationType)  throws EmptyFieldException{
        if(applicationType.getApplicationID().isEmpty()){
            throw new EmptyFieldException();
        }
        return new Application(applicationType.getApplicationID(), DTOConverter.unmarshalApplicant(ApplicationType.getApplicant()), DTOConverter.unmarshalJob(jobApplicationType.getJob()));
    }

    public static ArrayList<Application> unmasrhalApplicationList(ArrayList<ApplicationType> ApplicationTypes)  throws EmptyFieldException{
        ArrayList<Application> applications = new ArrayList<>();
        for(ApplicationType applicationType : ApplicationTypes){
            applications.add(DTOConverter.unmarshalApplication(applicationType));
        }
        return applications;
    }

    public static ApplicationType marshalApplication(Application application){
        ApplicationType applicationType = new ApplicationType();
        applicationType.setApllicationID(application.getApplicationID());
        applicationType.setApplicant(DTOConverter.marshalApplicant(application.getApplicant()));
        applicationType.setJob(DTOConverter.marshalJob(application.getJob()));
        return applicationType;
    }

    public static ArrayList<ApplicationType> marshalApplicationList(ArrayList<Application> applications){
        ArrayList<ApplicationType> ApplicationTypes = new ArrayList<>();
        for (Application application: applications) {
            ApplicationTypes.add(DTOConverter.marshalApplication(application));
        }
        return ApplicationTypes;
    }
}
