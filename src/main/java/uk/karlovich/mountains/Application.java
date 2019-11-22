package uk.karlovich.mountains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring application entry point
 *
 */
@SpringBootApplication
public class Application
{
	
    public static void main( String[] args )
    {
        System.out.println( "Starting Mounatins API..." );
        SpringApplication.run(Application.class, args);
    }
        
}
