package com.tenniscourts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main applicatition class. Contains only one method to start the whole application.
 * @author Samir Scheide
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class TennisCourtApplication {

  /**
   * Starts the application.
   * @param args the arguments this application may need to start or run properly
   */
  public static void main(String[] args) {
    SpringApplication.run(TennisCourtApplication.class, args);
  }

}