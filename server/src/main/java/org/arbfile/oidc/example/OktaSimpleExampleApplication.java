package org.arbfile.oidc.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OktaSimpleExampleApplication
{
    private static final Logger logger = LoggerFactory.getLogger(OktaSimpleExampleApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(OktaSimpleExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner generateData()
    {
        return (args) -> {
            logger.info("---------------------START FIDDLER-------------------------");
        };
    }

}
