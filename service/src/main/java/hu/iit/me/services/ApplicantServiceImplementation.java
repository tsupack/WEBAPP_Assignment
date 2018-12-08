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
    public ArrayList<Application> getMyApplications(String name) {
        ArrayList<Application> myApplications = new ArrayList<>();
        for (Application application: data.getApplications()) {
            if(application.getApplicant().getName().equals(name)){
                myApplications.add(application);
            }
        }
        return myApplications;
    }

    @Override
    public ArrayList<Application> getMyApplicationsBy(String name, String location, String company) {
        ArrayList<Application> FilteredApplication = new ArrayList<>();
        for (Application application: data.getApplications()){

            if((name == null) | application.getJob().getJobName().equals(name)){
                if((location == null) | application.getJob().getJobLocation().equals(location)){
                    if((company == null) | application.getJob().getCompany().equals(company)){
                        FilteredApplication.add(application);
                    }
                }
            }

        }
        return FilteredApplication;
    }
}
