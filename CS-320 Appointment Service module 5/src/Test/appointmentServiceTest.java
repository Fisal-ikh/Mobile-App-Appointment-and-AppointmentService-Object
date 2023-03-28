/*
 * Author Fisal Ikhmayes
 * CS-320
 * 04/02/2023
 * module 5 appointment
 */


package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import CS_320_Appointment_Service.appointment;
import CS_320_Appointment_Service.appointmentService;

class appointmentServiceTest {
	
	private appointmentService appointmentServiceTest;

	//tests the hashmap
	@Test
	void testAppointmentService() {
		appointmentService appointmentServiceTest = new appointmentService();
		HashMap<String, appointment> appointments = appointmentServiceTest.getAppointments();
		assertNotNull(appointments, "HashMap should not be null");
	}
	
	@Test
	void testAddAppointment() {
		 // Create an instance of appointmentService
		appointmentService appointmentServiceTest = new appointmentService();
        
        // Create a new appointment with a unique ID
        appointment appointment1 = new appointment("12345", new Date(), "The description");
        
        // Add the appointment to the service
        appointmentServiceTest.addAppointment(appointment1);
        
        // Try to add the same appointment again, which should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
        	appointmentServiceTest.addAppointment(appointment1);
        });
        
        // Create a second appointment with a different ID
        appointment appointment2 = new appointment("54321", new Date(), "Another description");
        
        // Add the second appointment to the service, which should succeed
        appointmentServiceTest.addAppointment(appointment2);
        
        // Verify that both appointments are in the service
        assertEquals(2, appointmentServiceTest.getAppointments().size());
        assertTrue(appointmentServiceTest.getAppointments().containsValue(appointment1));
        assertTrue(appointmentServiceTest.getAppointments().containsValue(appointment2));
    }
	
	@Test
	void testDeleteAppointment() {
		 // Create an instance of appointmentService
		appointmentService appointmentServiceTest = new appointmentService();
        
        // Create a new appointment with a unique ID
        appointment appointment1 = new appointment("32323", new Date(), "The description");
        
        // Add the appointment to the service
        appointmentServiceTest.addAppointment(appointment1);
        
        //deletes an appoibtment that exists
        appointmentServiceTest.deleteAppointment("32323");
        
        //trys to delete an appointment that dosent exist
        assertThrows(IllegalArgumentException.class, () -> {
        	appointmentServiceTest.deleteAppointment("123");
        });
        
		
	}
	
	@Test
	void testGetAppointment() {
		
		// Create an instance of appointmentService
		appointmentService appointmentServiceTest = new appointmentService();
        
		// Create some appointments
        appointment appointment1 = new appointment("1", new Date(), "Description 1");
        appointment appointment2 = new appointment("2", new Date(), "Description 2");
        appointment appointment3 = new appointment("3", new Date(), "Description 3");
        
        // Add the appointments to the scheduler
        appointmentServiceTest.addAppointment(appointment1);
        appointmentServiceTest.addAppointment(appointment2);
        appointmentServiceTest.addAppointment(appointment3);
        
        // Get the appointments from the scheduler
        HashMap<String, appointment> appointments = appointmentServiceTest.getAppointments();
        
        // Verify that the appointments match the ones that were added
        assertEquals(3, appointments.size());
        assertTrue(appointments.containsValue(appointment1));
        assertTrue(appointments.containsValue(appointment2));
        assertTrue(appointments.containsValue(appointment3));
    }
	}


