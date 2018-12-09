package web.config;

import hu.iit.me.controller.ApplicantServiceController;
import hu.iit.me.service.ApplicantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
public class ApplicantServiceContext {
    private ApplicantServiceInterface applicantService;

    @Autowired
    public ApplicantServiceContext(ApplicantServiceInterface applicantService){
        this.applicantService = applicantService;
    }

    @Bean
    public ApplicantServiceController applicantServiceController(){
        return new ApplicantServiceController(applicantService);
    }
}