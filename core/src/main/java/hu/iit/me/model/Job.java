package hu.iit.me.model;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;

public class Job {
    private int jobID;
    private String jobName;
    private String jobLocation;
    private String company;
    private String jobDescription;

    public Job(int jobID, String jobName, String jobLocation, String company, String jobDescription) throws InvalidIDException, EmptyFieldException{
        this.setJobID(jobID);
        this.setJobName(jobName);
        this.setJobLocation(jobLocation);
        this.setCompany(company);
        this.setJobDescription(jobDescription);
    }

    public int getJobID(){
        return jobID;
    }

    public void setJobID(int jobID) throws InvalidIDException {
        if(jobID<1){
            throw new InvalidIDException();
        }
        this.jobID = jobID;
    }

    public String getJobName(){
        return jobName;
    }

    public void setJobName(String jobName) throws EmptyFieldException {
        if (jobName.equals("")){
            throw new EmptyFieldException();
        }
        this.jobName = jobName;
    }

    public String getJobLocation(){
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) throws EmptyFieldException{
        if (jobLocation.equals("")){
            throw new EmptyFieldException();
        }
        this.jobLocation = jobLocation;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company) throws EmptyFieldException{
        if (company.equals("")){
            throw new EmptyFieldException();
        }
        this.company = company;
    }

    public String getJobDescription(){
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) throws EmptyFieldException{
        if (jobDescription.equals("")){
            throw new EmptyFieldException();
        }
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobID=" + jobID +
                ", jobName='" + jobName + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", company='" + company + '\'' +
                ", jobDescription=" + jobDescription +
                '}';
    }
}
