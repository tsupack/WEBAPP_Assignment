package hu.iit.me.controller;

import hu.iit.me.dto.ApplicantType;
import hu.iit.me.dto.ApplicationType;
import hu.iit.me.dto.JobType;
import hu.iit.me.dto.FilterType;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.services.ApplicantServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("applicant")
public class ApplicantServiceController {
    private ApplicantServiceImplementation applicantService;

    public ApplicantServiceController(ApplicantServiceImplementation applicantService) {
        this.applicantService = applicantService;
    }

    @RequestMapping(value = "/listAllJob", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<JobType> listAllJob() {
        return DTOConverter.marshalJobList(applicantService.getAllJobs());
    }


    @RequestMapping(value = "/listMyApplications", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> listMyApplication(@RequestBody ApplicantType applicantType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplications(applicantType.getApplicantName()));
    }


    @RequestMapping(value = "filterApplicationsBy", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<ApplicationType> filterApplicationBy(@RequestBody FilterType filterType) {
        return DTOConverter.marshalApplicationList(applicantService.getMyApplicationsBy(filterType.getName(), filterType.getLocation(), filterType.getCompany()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {EmptyFieldException.class})
    public void exceptionHandler() {
    }
}