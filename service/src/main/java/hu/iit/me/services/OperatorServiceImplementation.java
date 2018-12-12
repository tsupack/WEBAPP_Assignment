package hu.iit.me.services;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.exception.JobNotFoundException;
import hu.iit.me.service.OperatorServiceInterface;
import hu.iit.me.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OperatorServiceImplementation implements OperatorServiceInterface {
    private DaoInterface data;

    public OperatorServiceImplementation(DaoInterface data){
        this.data = data;
    }

    @Override
    public void addJob(int id, String name, String location, String company, String description) throws InvalidIDException, EmptyFieldException {
        data.addJob(id,name,location,company,description);
    }

    @Override
    public void deleteJob(int id) throws JobNotFoundException {
        data.deleteJob(id);
    }

    @Override
    public ArrayList<Job> listJobs() {
        return data.getJobs();
    }

    @Override
    public ArrayList<Application> listApplications() {
        return data.getApplications();
    }
}
