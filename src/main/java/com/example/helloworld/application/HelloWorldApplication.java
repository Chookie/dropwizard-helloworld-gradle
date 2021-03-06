package com.example.helloworld.application;

import com.example.helloworld.configuration.HelloWorldConfiguration;
import com.example.helloworld.health.TemplateHealthCheck;
import com.example.helloworld.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Created by Alison on 24/01/15
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    //final static Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName()));
        environment.healthChecks().register("template", new TemplateHealthCheck(configuration.getTemplate()));
    }
}
