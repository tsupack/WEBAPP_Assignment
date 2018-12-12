package hu.iit.me.controller;

import hu.iit.me.dto.ApplicationType;
import hu.iit.me.dto.JobType;
import hu.iit.me.exception.*;
import hu.iit.me.service.OperatorServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/operator/")
public class OperatorServiceController {
    private OperatorServiceInterface operatorService;

    public OperatorServiceController(OperatorServiceInterface operatorService){
        this.operatorService = operatorService;
    }

    @RequestMapping(value = "listAllJobs", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<JobType> listAllJob(){
        return DTOConverter.marshalJobList(operatorService.listJobs());
    }


    @RequestMapping(value = "addJob", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<JobType> addJob(@RequestBody JobType jobType) throws InvalidIDException, EmptyFieldException {
        operatorService.addJob(jobType.getJobID(), jobType.getJobName(), jobType.getJobLocation(), jobType.getJobCompany(), jobType.getJobDescription());
        return DTOConverter.marshalJobList(operatorService.listJobs());
    }

    @RequestMapping(value = "deleteJob", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<JobType> deleteJob(@RequestBody JobType jobType) throws JobNotFoundException {
        operatorService.deleteJob(jobType.getJobID());
        return DTOConverter.marshalJobList(operatorService.listJobs());
    }

    @RequestMapping(value = "listAllApplications", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<ApplicationType> listAllApplication(){
        return DTOConverter.marshalApplicationList(operatorService.listApplications());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {EmptyFieldException.class, InvalidIDException.class, InvalidInputFormatException.class, NegativeValueException.class})
    public void badRequestHandler() {
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {JobNotFoundException.class})
    public void notFoundHandler() {
    }
}