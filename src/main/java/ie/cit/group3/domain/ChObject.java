package ie.cit.group3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * @author John Murphy
 * Student Id: R00131347
 * 
 * This class is used to store attributes of interest from the Cultural Heritage Objects JSON files.
 * Jackson automatically extracts the data from the Json file for the attributes listed below.
 * Each object can have just one: id, title, date, medium, creditline, description, gallery_text
 * Each object may have several participations (captured in a List), and several Images (captured in a List
 * of Maps. Map<key,object>, where key is the image resolution and object is the images details).
 * 
 * Updated to annotate this class for Entity/JPA Access. 
 *
 */


@JsonIgnoreProperties(ignoreUnknown = true) //This annotation tells Jackson to ignore fields in JSON file that are not called in this class.

@Entity
@Table(name="chobject") //name of table in database
//@Component
public class ChObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //ensures that Auto Increment is compatible with underlying database AI implementation
	private String id;
	
	private String title;
	
	private String date;
	
	private String medium;
	
	private String creditline;
	
	private String description;

	private String gallery_text; 
	
	@Transient
	private List<Participation> participations;
	
	@Transient
	private List<Map<String,Image>> images;
	

	public ChObject() {
		super();
		
		this.participations = Collections.<Participation>emptyList();
		this.images = Collections.<Map<String,Image>>emptyList();
	}

	@Override
	public String toString() {
		return "ChObject [id=" + id + ", title=" + title + ", date=" + date
				+ ", medium=" + medium + ", creditline=" + creditline
				+ ", description=" + description + ", gallery_text="
				+ gallery_text + ", participations=" + participations
				+ ", images=" + images + "]";
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getMedium() {
		return medium;
	}



	public void setMedium(String medium) {
		this.medium = medium;
	}



	public String getCreditline() {
		return creditline;
	}



	public void setCreditline(String creditline) {
		this.creditline = creditline;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getGallery_text() {
		return gallery_text;
	}



	public void setGallery_text(String gallery_text) {
		this.gallery_text = gallery_text;
	}



	public List<Participation> getParticipants() {
		return participations;
	}



	public void setParticipants(List<Participation> participants) {
		this.participations = participants;
	}

//	public void setImageList(List<Image> chimages) {
//		// TODO Auto-generated method stub
//		
//	}
//	public List<Image> getImageList() {
//		// TODO Auto-generated method stub
//		return images;
//		
//	}


	public List<Map<String,Image>> getImages() {
		return images;
	}



	public void setImages(List<Map<String,Image>> images) {
		this.images = images;
	}

	
	
}
