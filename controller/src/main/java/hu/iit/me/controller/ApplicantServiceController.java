package hu.iit.me.controller;

import hu.iit.me.dto.ApplicantType;
import hu.iit.me.dto.ApplicationType;
import hu.iit.me.dto.JobType;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.service.ApplicantServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("applicant")
public class ApplicantServiceController {
    private ApplicantServiceInterface applicantService;

    public ApplicantServiceController(ApplicantServiceInterface applicantService) {
        this.applicantService = applicantService;
    }

    @RequestMapping(value = "/listAllJobs", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<JobType> listAllJob() {
        return DTOConverter.marshalJobList(applicantService.getAllJobs());
    }

    @RequestMapping(value = "/listMyApplicationByName", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> listMyApplicationByName(@RequestBody ApplicantType applicantType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplicationsByName(applicantType.getApplicantName()));
    }

    @RequestMapping(value = "/listMyApplicationByJobName", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> listMyApplicationByJobName(@RequestBody JobType jobType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplicationsByJobName(jobType.getJobName()));
    }

    @RequestMapping(value = "/listMyApplicationByJobLocation", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> listMyApplicationByJobLocation(@RequestBody JobType jobType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplicationsByJobLocation(jobType.getJobLocation()));
    }

    @RequestMapping(value = "/listMyApplicationByCompany", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> listMyApplicationByCompany(@RequestBody JobType jobType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplicationsByCompany(jobType.getJobCompany()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {EmptyFieldException.class})
    public void exceptionHandler() {
    }
}