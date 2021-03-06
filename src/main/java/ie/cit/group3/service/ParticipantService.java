package ie.cit.group3.service;


import ie.cit.group3.domain.Participant;
import ie.cit.group3.utility.Page;

import java.util.List;
/**
 * @author John Murphy
 *
 * This interface defines the contract/methods that a Participant can use at the Service Layer.
 * Activities are:
 * 	get			Retrieve record(s) that match a given id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 * 	int CountAll();
	List<Participant> findByPersonId(String searchpeople);
	Page<Participant> findAll(int pageNo, int pageSize);
	long countByParticipant(String id);
 */

public interface ParticipantService {

	public Participant get (String id);

	public void save(Participant participant);

	public void remove(Participant participant);

	public List<Participant> findAll();

	public int CountAll();

	public List<Participant> findByPersonId(String searchpeople);

	public Page<Participant> findAll(int pageNo, int pageSize);

	public long countByParticipant(String id);
}
