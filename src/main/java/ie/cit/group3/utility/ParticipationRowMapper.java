package ie.cit.group3.utility;

import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Participation;
import ie.cit.group3.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;






import org.springframework.jdbc.core.RowMapper;
/**
 * @author John Murphy
 * Student ID: R00131347
 * Date: 	31 March 2015
 * 
 * This class provides the mapping from a SQL resultset to an object. It returns the populated object when complete. 
 * The SQL table attributes are extracted using the rs.getString(<table attribute name here>)
 * 
 * In this case the object is a Participation
 */
public class ParticipationRowMapper implements RowMapper<Participation> {

	@Override
	public Participation mapRow(ResultSet rs, int index) throws SQLException {
		
		Participation participation = new Participation();
		
		//Adding the following 4 lines as a result of Junit testing! These 4 lines create and add the objects that Participation references.
		Participant participant = new Participant();
		Role role = new Role();
		participation.setParticipant(participant);
		participation.setRole(role);
		
		
		participation.getParticipant().setPerson_id(rs.getString("participant_id"));
		participation.getRole().setRole_id(rs.getString("role_id"));
		
		return participation;
	}
}
