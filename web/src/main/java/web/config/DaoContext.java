package web.config;

import hu.iit.me.dao.DaoInterface;
import hu.iit.me.dao.DaoImplementation;
import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.exception.NegativeValueException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DaoContext {
    @Bean
    public DaoInterface dao()throws InvalidIDException, EmptyFieldException, NegativeValueException {
        return new DaoImplementation();
    }
}