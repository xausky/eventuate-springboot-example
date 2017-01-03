package io.github.xausky.eventuate;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.github.xausky.eventuate.handler.NoteHandler;
import io.github.xausky.eventuate.service.NoteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Created by xausky on 12/28/16.
 */
@EnableEventHandlers
@SpringBootApplication
@Import(EventuateDriverConfiguration.class)
public class QueryApplication {

    @Bean
    public NoteHandler noteHandler(NoteRepository repository){
        return new NoteHandler(repository);
    }

    public static void main(String[] args){
        SpringApplication.run(QueryApplication.class,args);
    }
}
