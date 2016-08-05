package ie.cit.group3.service;

/**
 * @author John Murphy
 * Student Id: R00131347
 * 
 * This interface defines the contract/methods that a ChObject can use at the Service Layer.
 * Activities are:
 * 	get			Retrieve record(s) that match a given id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 * 	Page<ChObject> findAll(int pageNo, int pageSize)	Returns a page of ChObjects
 * 	int CountAll()	 									Returns counts of all ChObjects
 *  int CountAllMedium()								Returns count of all 'Medium' attribute ChObjects
 */

import ie.cit.group3.domain.ChObject;
import ie.cit.group3.utility.Page;

import java.util.List;

public interface ChObjectService {
	
	public ChObject get (String id);
	
	public void save(ChObject chobject);
	
	public void remove(ChObject chobject);
	
	public List<ChObject> findAll();

	public Page<ChObject> findAll(int pageNo, int pageSize);
	
	public int CountAll();
	
	public int CountAllMedium();


}
