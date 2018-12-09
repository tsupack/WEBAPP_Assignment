package web.config;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.service.OperatorServiceInterface;
import hu.iit.me.services.OperatorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
public class OperatorServiceMethodContext {
    private DaoInterface dao;

    @Autowired
    public OperatorServiceMethodContext(DaoInterface dao){
        this.dao = dao;
    }

    @Bean
    public OperatorServiceInterface operatorService(){
        return new OperatorServiceImplementation(dao);
    }
}