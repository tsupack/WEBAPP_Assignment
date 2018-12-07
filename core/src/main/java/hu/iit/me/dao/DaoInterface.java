package hu.iit.me.dao;

import hu.iit.me.model.Applicant;
import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public interface DaoInterface {
    void initialize();
    ArrayList<Job> getJobs();
    void addJob(String id, String name, String location, String company, String description);
    void deleteJob(String id);
    ArrayList<Application> getApplications();
    ArrayList<Applicant> getApplicants();
}
