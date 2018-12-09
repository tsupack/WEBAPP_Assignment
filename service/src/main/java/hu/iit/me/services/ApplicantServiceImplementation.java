package hu.iit.me.services;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.service.ApplicantServiceInterface;
import hu.iit.me.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplicantServiceImplementation implements ApplicantServiceInterface {
    private DaoInterface data;

    public ApplicantServiceImplementation(DaoInterface data){
        this.data = data;
    }

    @Override
    public ArrayList<Job> getAllJobs(){
        return data.getJobs();
    }

    @Override
    public ArrayList<Application> getMyApplicationsByName(String applicantName) {
        ArrayList<Application> myApplications = new ArrayList<>();
        for (Application application: data.getApplications()) {
            if(application.getApplicant().getName().equals(applicantName)){
                myApplications.add(application);
            }
        }
        return myApplications;
    }

    @Override
    public ArrayList<Application> getMyApplicationsByJobName(String jobName) {
        ArrayList<Application> myApplications = new ArrayList<>();
        for (Application application: data.getApplications()) {
            if(application.getJob().getJobName().equals(jobName)){
                myApplications.add(application);
            }
        }
        return myApplications;
    }

    @Override
    public ArrayList<Application> getMyApplicationsByJobLocation(String jobLocation) {
        ArrayList<Application> myApplications = new ArrayList<>();
        for (Application application: data.getApplications()) {
            if(application.getJob().getJobLocation().equals(jobLocation)){
                myApplications.add(application);
            }
        }
        return myApplications;
    }

    @Override
    public ArrayList<Application> getMyApplicationsByCompany(String company) {
        ArrayList<Application> myApplications = new ArrayList<>();
        for (Application application: data.getApplications()) {
            if(application.getJob().getCompany().equals(company)){
                myApplications.add(application);
            }
        }
        return myApplications;
    }
}
