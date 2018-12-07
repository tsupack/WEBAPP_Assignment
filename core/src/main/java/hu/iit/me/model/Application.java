package hu.iit.me.model;

import hu.iit.me.exception.InvalidIDException;

public class Application {
    private int applicationID;
    private Applicant applicant;
    private Job job;

    public Application(int applicationID, Applicant applicant, Job job) throws InvalidIDException{
        this.setApplicationID(applicationID);
        this.setApplicant(applicant);
        this.setJob(job);
    }

    public int getApplicationID(){
        return applicationID;
    }

    public void setApplicationID(int applicationID) throws InvalidIDException {
        if(applicationID<1){
            throw new InvalidIDException();
        }
        this.applicationID = applicationID;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationID=" + applicationID + '\'' +
                ", applicant=" + applicant + '\'' +
                ", job=" + job +
                '}';
    }
}
