package hu.iit.me.dao;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.model.Applicant;
import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public interface DaoInterface {
    void initialize();
    ArrayList<Job> getJobs();
    void addJob(int id, String name, String location, String company, String description) throws InvalidIDException, EmptyFieldException;
    void deleteJob(int id);
    ArrayList<Application> getApplications();
    ArrayList<Applicant> getApplicants();
}
