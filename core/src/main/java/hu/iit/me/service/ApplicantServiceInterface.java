package hu.iit.me.service;

import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public interface ApplicantServiceInterface {
    ArrayList<Job> getAllJobs();
    ArrayList<Application> getMyApplicationsByName(String applicantName);
    ArrayList<Application> getMyApplicationsByJobName(String jobName);
    ArrayList<Application> getMyApplicationsByJobLocation(String jobLocation);
    ArrayList<Application> getMyApplicationsByCompany(String company);
}
