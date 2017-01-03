package io.github.xausky.eventuate;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.github.xausky.eventuate.command.NoteCommand;
import io.github.xausky.eventuate.service.NoteService;
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
public class CommandApplication {
    public static void main(String[] args){
        SpringApplication.run(CommandApplication.class,args);
    }

    @Bean
    public NoteService noteService(AggregateRepository<NoteAggregate,NoteCommand> repository){
        return new NoteService(repository);
    }

    @Bean
    public AggregateRepository<NoteAggregate,NoteCommand> accountRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<NoteAggregate,NoteCommand>(NoteAggregate.class, eventStore);
    }
}
