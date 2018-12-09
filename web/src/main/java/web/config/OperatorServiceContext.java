package web.config;

import hu.iit.me.controller.OperatorServiceController;
import hu.iit.me.service.OperatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
public class OperatorServiceContext {
    private OperatorServiceInterface operatorService;

    @Autowired
    public OperatorServiceContext(OperatorServiceInterface operatorService){
        this.operatorService = operatorService;
    }

    @Bean
    public OperatorServiceController operatorServiceController(){
        return new OperatorServiceController(operatorService);
    }
}