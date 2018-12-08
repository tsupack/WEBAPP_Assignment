package hu.iit.me;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.service.OperatorServiceInterface;
import hu.iit.me.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OperatorServiceImplementation implements OperatorServiceInterface {
    private DaoImplementation data;

    public OperatorServiceImplementation(DaoImplementation data){
        this.data = data;
    }

    @Override
    public void addJob(int id, String name, String location, String company, String description) throws InvalidIDException, EmptyFieldException {
        data.addJob(id,name,location,company,description);
    }

    @Override
    public void deleteJob(int id) {
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
