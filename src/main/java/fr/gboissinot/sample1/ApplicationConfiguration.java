package fr.gboissinot.sample1;

import fr.gboissinot.kernel.cqs.command.CommandBus;
import fr.gboissinot.kernel.cqs.command.CommandBusFactory;
import fr.gboissinot.kernel.cqs.command.metrics.LoggingExecutionTimeMetricsCommandProcessor;
import fr.gboissinot.kernel.cqs.engine.ActionMessageHandlersRegistry;
import fr.gboissinot.kernel.cqs.engine.metrics.LoggingExecutionTimeMetricsProcessor;
import fr.gboissinot.kernel.cqs.engine.spring.SpringActionHandlerApplicationListener;
import fr.gboissinot.kernel.cqs.engine.spring.SpringActionMessageHandlerResolver;
import fr.gboissinot.kernel.cqs.query.QueryBus;
import fr.gboissinot.kernel.cqs.query.QueryBusFactory;
import fr.gboissinot.kernel.event.DefaultEventBus;
import fr.gboissinot.kernel.event.EventBus;
import fr.gboissinot.kernel.event.handler.LoggingEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@org.springframework.context.annotation.Configuration
public class ApplicationConfiguration {

    private final ConfigurableListableBeanFactory beanFactory;

    @Autowired
    public ApplicationConfiguration(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Bean
    public SpringActionHandlerApplicationListener springActionHandlerApplicationListener() {
        return new SpringActionHandlerApplicationListener(
                beanFactory,
                ActionMessageHandlersRegistry.valueOf(
                        new SpringActionMessageHandlerResolver(beanFactory)));
    }

    @Bean
    public CommandBus commandBus() {
        return CommandBusFactory.createSimpleBus(new SpringActionMessageHandlerResolver(beanFactory),
                Collections.singletonList(
                        new LoggingExecutionTimeMetricsCommandProcessor(new LoggingExecutionTimeMetricsProcessor())));
    }

    @Bean
    public QueryBus queryBus() {
        return QueryBusFactory.createSimpleBus(new SpringActionMessageHandlerResolver(beanFactory),
                Collections.singletonList(
                        new LoggingExecutionTimeMetricsCommandProcessor(new LoggingExecutionTimeMetricsProcessor())));
    }

    @Bean
    public EventBus eventBus() {
        DefaultEventBus eventBus = new DefaultEventBus();
        eventBus.registerHandler(new LoggingEventHandler());
        return eventBus;
    }


}
