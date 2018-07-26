package me.j360.swagger.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"me.j360.swagger.boot"})
@Slf4j
public class BootstrapApplication {

    public static void main(String args[]) {
        SpringApplication.run(BootstrapApplication.class, args);
    }


}
