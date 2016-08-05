package ie.cit.group3.service;

import ie.cit.group3.domain.ChObject;
import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Participation;
import ie.cit.group3.repository.ParticipationRepository;
import ie.cit.group3.utility.Page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John Murphy
 * Student Id: R00131347
 * 
 * This class implements the interface for ParticipationService.  
 * 
 * This class passes directly through to the Repository layer.
 * 
 * Activities it must implement are:
 * 	get			Retrieve record(s) that match a given CH object id, participant id, role id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 *  List<Participation> get(ChObject chObject);
 */


//Identify this class as Service (Spring will detect it during @ComponentScan & create a bean of this type).
@Service
public class ParticipationServiceImpl implements ParticipationService {

	//instance variable that is updated via constructor DI
	private ParticipationRepository participationRepository;
	
	//Autowire this object, using constructor DI.
	@Autowired
	public ParticipationServiceImpl (ParticipationRepository participationRepository)
	{
		this.participationRepository = participationRepository;
	}
	
	@Override
	public Participation get(String chObject_id, String participation_id, String role_id) 
	{
		return participationRepository.get(chObject_id, participation_id, role_id);
	}

	@Override
	public void save(Participation participation, String chObject_id) 
	{
		participationRepository.save(participation, chObject_id);
	}

	@Override
	public void remove(Participation participation, String chObject_id) 
	{
		participationRepository.remove(participation, chObject_id);
	}

	@Override
	public List<Participation> findAll() 
	{
		return participationRepository.findAll();
	}

	@Override
	public List<Participation> get(ChObject chObject) {
		
		return participationRepository.get(chObject);
	}

	

}