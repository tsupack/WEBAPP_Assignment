package hu.iit.me.controller;

import hu.iit.me.dto.ApplicantType;
import hu.iit.me.dto.ApplicationType;
import hu.iit.me.dto.JobType;
import hu.iit.me.dto.FilterType;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.services.OperatorServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/operator/")
public class OperatorServiceConroller {
    private OperatorServiceImplementation operatorService;

    public OperatorServiceConroller (OperatorServiceImplementation operatorService){
        this.operatorService = operatorService;
    }

    @RequestMapping(value = "listAllJobs", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<JobType> listAllJob(){return DTOConverter.marshalJobList(operatorService.listJobs());}


    @RequestMapping(value = "addJob", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<JobType> addJob(@RequestBody JobType jobType) throws InvalidIDException, EmptyFieldException {
        operatorService.addJob(jobType.getJobID(),jobType.getJobName(),jobType.getJobLocation(),jobType.getJobCompany(),jobType.getJobDescription());
        return DTOConverter.marshalJobList(operatorService.listJobs());
    }

    @RequestMapping(value = "deleteJob", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<JobType> deleteJob(@RequestParam(value = "id") int id){
        operatorService.deleteJob(id);
        return DTOConverter.marshalJobList(operatorService.listJobs());
    }

    @RequestMapping(value = "listAllApplications")
    @ResponseBody
    public ArrayList<ApplicationType> listAllApplication(){return DTOConverter.marshalApplicationList(operatorService.listApplications());}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {EmptyFieldException.class})
    public void exceptionHandler() {
    }
}