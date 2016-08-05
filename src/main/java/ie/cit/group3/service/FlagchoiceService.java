package ie.cit.group3.service;

/**
 * @author John Murphy
 * Student Id: R00131347
 * 
 * This interface defines the contract/methods that a Flagchoice can use at the Service Layer.
 * Activities are:
 *  findAll		list all the objects/records in the repository
 * 
 */


import ie.cit.group3.entity.Flagchoice;

import java.util.List;



public interface FlagchoiceService {
		
	public List<Flagchoice> findAll();

	}
