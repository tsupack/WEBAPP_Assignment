package web.config;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.dao.DaoImplementation;
import hu.iit.me.exception.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DaoContext {
    @Bean
    public DaoInterface dao()throws InvalidIDException, EmptyFieldException, InvalidInputFormatException, NegativeValueException {
        return new DaoImplementation();
    }
}