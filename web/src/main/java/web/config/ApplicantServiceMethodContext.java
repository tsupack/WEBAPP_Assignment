package web.config;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.service.ApplicantServiceInterface;
import hu.iit.me.services.ApplicantServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicantServiceMethodContext {
    private DaoInterface dao;

    @Autowired
    public ApplicantServiceMethodContext(DaoInterface dao){
        this.dao = dao;
    }

    @Bean
    public ApplicantServiceInterface applicantService(){
        return new ApplicantServiceImplementation(dao);
    }
}