package hu.iit.me.service;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.exception.JobNotFoundException;
import hu.iit.me.model.Application;
import hu.iit.me.model.Job;

import java.util.ArrayList;

public interface OperatorServiceInterface {
    void addJob(int id, String name, String location, String company, String description)  throws InvalidIDException, EmptyFieldException;
    void deleteJob(int id) throws JobNotFoundException;
    ArrayList<Job> listJobs();
    ArrayList<Application> listApplications();
}
