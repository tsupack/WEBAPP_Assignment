package hu.iit.me.service;

import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public interface OperatorServiceInterface {
    void addJob(String id, String name, String location, String company, String description);
    void deleteJob(String id);
    ArrayList<Job> listJobs();
    ArrayList<Application> listApplications();
}
