package ie.cit.group3.repository;

import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Role;
import ie.cit.group3.utility.ImageRowMapper;
import ie.cit.group3.utility.Page;
import ie.cit.group3.utility.PaginationHelper;
import ie.cit.group3.utility.ParticipantRowMapper;
import ie.cit.group3.utility.RolesRowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author John Murphy
 * Student Id: R00131347
 * 
 * This class implements the interface for ParticipantRepository
 * Activities it must implement are:
 * 	get			Retrieve record(s) that match a given id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 *  int CountAll()
 *  List<Participant> findByPersonId(String person_id) 
 *  Page<Participant> findAll(int pageNo, int pageSize) 
 *  long countByParticipant(String id)
 * 
 */



//Identify this class as Repository (Spring will detect it during @ComponentScan).
@Repository
public class JdbcParticipantRepository implements ParticipantRepository 
{
	
	//Using JdbcTemplate to provide repository access using SQL statements
	private JdbcTemplate jdbcTemplate;
	
	//Using Constructor DI, auto-inject the DataBase dependency connection into this object.
	@Autowired
	public JdbcParticipantRepository(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Participant get(String id) 
	{
		/* This method retrieves a Participant based on a supplied String based 'id'.
		 * 
		 * Need to check that the record exists in the database first before returning it.
		 * Otherwise if the record does not exist, you will get an exception that the application
		 * cannot handle.
		 * Using a SQL COUNT statement to return the number of records.  This will return an integer
		 * 'count'.  If this is 0, then no match exists and the return type of the object is set to 
		 * null. If 'count' is >0, then run the SQL query to return the number of records that match
		 * the supplied String 'id'.
		 * 
		 * */
		
		String sql = "SELECT COUNT(*) FROM participant WHERE person_id = ?";
		
		@SuppressWarnings("deprecation")
		int count = jdbcTemplate.queryForInt(sql, new Object [] {id});
		
		if (count > 0)
		{
			sql = "SELECT * FROM participant WHERE person_id = ?";

			Participant participant = jdbcTemplate.queryForObject(sql, new Object [] {id}, new ParticipantRowMapper());
			
			return participant;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void save(Participant participant) 
	{
		//Implementing only the 'add()' part of 'save()' at present.
		
//		if (participant.getPerson_id() != null)
//		{
//			update(participant);
//		}
//		else
//		{
			add(participant);
//		}
	}

	private void add(Participant participant)
	{
		//Method to add a record to the repository
		String sql = "INSERT INTO participant (person_id,person_name,person_date,person_url) VALUES (?,?,?,?);";
			jdbcTemplate.update(sql, new Object[] {participant.getPerson_id(), participant.getPerson_name(),
												participant.getPerson_date(), participant.getPerson_url()});	
	}
				

	
	private void update(Participant participant)
	{
		//NOT IMPLEMENTED/TESTED
		//Method to update a record in the repository
		String sql = "UPDATE participant SET person_name =?, person_date=?, person_url =? WHERE person_id = ?";
		jdbcTemplate.update(sql, new Object[] {participant.getPerson_name(),participant.getPerson_date(),
				participant.getPerson_url(),participant.getPerson_id()});
	}
	
	@Override
	public void remove(Participant participant) 
	{
		//Method to delete a record from the repository
		String sql = "DELETE FROM participant WHERE person_id = ?";
		jdbcTemplate.update(sql, new Object[] {participant.getPerson_id()});
	}

	@Override
	public List<Participant> findAll() 
	{
		//Return a List of all Participants
		String sql = "SELECT * FROM participant";
		return jdbcTemplate.query(sql,  new ParticipantRowMapper());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int CountAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM participant";
		return jdbcTemplate.queryForInt(sql);
	}
	
	@Override
	public List<Participant> findByPersonId(String person_id) 
	{
		// TODO Return a List of all Participants by person_id
		String sql = "SELECT * FROM participant WHERE person_id = ?";
		return jdbcTemplate.query(sql,  new Object[] {person_id}, new ParticipantRowMapper());
	}
	@Override
	public Page<Participant> findAll(int pageNo, int pageSize) 
	{
		PaginationHelper<Participant> ph = new PaginationHelper<Participant>();
		
		return ph.fetchpageParticipant(jdbcTemplate, 
				"SELECT COUNT(*) FROM participant", 
				"SELECT * FROM participant", 
				pageNo, pageSize, new ParticipantRowMapper());
	}

	@Override
	public long countByParticipant(String id) {
		// TODO returns count of participants by person_id
		String sql = "SELECT COUNT(*) FROM participant WHERE person_id = ?";
		return jdbcTemplate.queryForLong(sql,  new Object[] {id});
	}


}
