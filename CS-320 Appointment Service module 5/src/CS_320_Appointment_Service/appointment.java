/*
 * Author Fisal Ikhmayes
 * CS-320
 * 04/02/2023
 * module 5 appointment
 */


package CS_320_Appointment_Service;

import java.util.Date;

public class appointment {
	
	private final String ID;
	private Date appointmentDate;
	private String description;
	
	
	public appointment(String ID, Date appointmentDate, String description) {
		if (ID == null) {
			throw new IllegalArgumentException("ID cant be null");
		}
		if (ID.length() > 10) {
			throw new IllegalArgumentException("ID cant be longer than 10 charachters");
		}
		this.ID = ID;
		
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Date cant be null");
		}
		if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Date cant be in the past");
		}
        this.appointmentDate = appointmentDate;
        
        if (description == null) {
			throw new IllegalArgumentException("Description cant be null");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description cant be longer than 50 charachters");
		}
		this.description = description;
	}
	
	
	//setter methods
	//"YYYY-MM-DD"
	public void setDate(Date appointmentDate){
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Date cant be null");
		}
		if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Date cant be in the past");
		}
        this.appointmentDate = appointmentDate;
	}
	
	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Description cant be null");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("Description cant be longer than 50 charachters");
		}
		this.description = description;
	}
	
	
	
	//getter methods
	public String getID() {
		return ID;
	}
	
	
	//this returns it in normal Date format 20230327
	public Date getDate() {
		return appointmentDate;
	}

	
	public String getDescription() {
		return description;
	}
}
