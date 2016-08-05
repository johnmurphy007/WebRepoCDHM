package ie.cit.group3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;


/**
 * @author John Murphy
 * 
 * This application follows a MVC approach to provide a web-front for Smithsonian Cooper Hewitt Design Museum objects.
 * 
 * This class initiates the program.  It implements CommandLineRunner which enables the command prompt to be used to interact with this application.
 * The Domain objects that that this program uses are:
 * 		- ChObject
 * 		- Image
 * 		- Participation
 * 		- Participant
 * 		- Role
 * 		- User
 * 		- Authorities
 * 
 * The Entity objects that this program uses are:
 * 		- Comment
 * 		- CommentFlag
 * 		- CommentThumb
 * 		- Crowdsourcing
 * 		- CrowdsourcingFlag
 * 		- Flagchoice
 * 		- GameType
 * 		- Gamification
 * 		- TagName
 * 		- Users
 * 
 * Please refer to the POJO for each of the above objects for more details.
 * 
 * The project is layered.  This class interacts with the Service layer only, which interacts with the repository
 * layer to perform the repo related activities.  Please refer to the Service layers for the access capabilities of
 * each object/class.
 * 
 */

@SpringBootApplication				//Annotation tells JDK that Spring Framework that this is a Spring project
@ActiveProfiles("default")			//Refer to application.yml for available profiles
public class CooperHewittG3WebApplication implements CommandLineRunner 
{
		

    /**
     * @param args.  Static Main method looks for the CooperHewittG3WebApplication.class java bytecode to start the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(CooperHewittG3WebApplication.class, args);
    }


	@Override
	public void run(String... arg0) throws Exception {
		// TODO Starts the application (taking arg0 as a parameter & throws an Exception.
		
	}
}