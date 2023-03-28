/*
 * Author Fisal Ikhmayes
 * CS-320
 * 04/02/2023
 * module 5 appointment
 */



package CS_320_Appointment_Service;


import java.util.HashMap;



public class appointmentService {
	
	// maps ID to appointment object
	private HashMap<String, appointment> appointments; 
	
	
	public appointmentService() {
		this.appointments = new HashMap<>();
	}
	
	
	// adds new appointments and checks if one exists
	public void addAppointment(appointment appointment1) {
		if (appointments.containsKey(appointment1.getID())) {
			throw new IllegalArgumentException("ID already exists.");
		}
		appointments.put(appointment1.getID(), appointment1);
	}
	//deletes appointment and checks if one exists
	public void deleteAppointment(String ID) {
		if(!appointments.containsKey(ID)) {
			throw new IllegalArgumentException("Id does not exist");
		}
		appointments.remove(ID);
	}
	
	//returns appointments
	public HashMap<String, appointment> getAppointments() {
        return this.appointments;
	}	
	
	
}

