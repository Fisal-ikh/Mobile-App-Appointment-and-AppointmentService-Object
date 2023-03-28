/*
 * Author Fisal Ikhmayes
 * CS-320
 * 04/02/2023
 * module 5 appointment
 */


package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CS_320_Appointment_Service.appointment;

class appointmentTest {
	
	private appointment appointmentTest;

	@BeforeEach
	void setUp() {
        appointmentTest = new appointment("1234", new Date(), "The description");
	}

	
	
	@Test
	void testAppointment() {
		//this sets a future date and valid inputs
		String validID = "12345";
		
		Calendar calendar1 = Calendar.getInstance();
	    calendar1.add(Calendar.DAY_OF_MONTH, 1);
	    Date futureDate = calendar1.getTime();
		Assertions.assertDoesNotThrow(() -> {
		appointmentTest.setDate(futureDate);
	    });	    
		
		String validDescription = "Task description";
	    //sets null inputs
	    String invalidIDNull = null;
	    Date invalidDateNull = null;
	    String invalidDescriptionNull = null;
	    //invalid lengths
	    String invalidIDLength = "12345678901";
	    //sets past date to test
	    Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date invalidDatePast = calendar.getTime();
        //invalid description
	    String invalidDescriptionLength = "This is a very long task description that exceeds the limit of 50 characters";

	    
	    appointment appointment1 = new appointment(validID, futureDate, validDescription);
	    
	    assertEquals(validID, appointment1.getID());
	    assertEquals(futureDate, appointment1.getDate());
	    assertEquals(validDescription, appointment1.getDescription());
	

	    //this tests everything with the data we set above
	    assertThrows(IllegalArgumentException.class, () -> new appointment(invalidIDNull, futureDate, validDescription));
	    assertThrows(IllegalArgumentException.class, () -> new appointment(invalidIDLength, futureDate, validDescription));
	    assertThrows(IllegalArgumentException.class, () -> new appointment(validID, invalidDateNull, validDescription));
	    assertThrows(IllegalArgumentException.class, () -> new appointment(validID, invalidDatePast, validDescription));
	    assertThrows(IllegalArgumentException.class, () -> new appointment(validID, futureDate, invalidDescriptionNull));
	    assertThrows(IllegalArgumentException.class, () -> new appointment(validID, futureDate, invalidDescriptionLength));
	}
	
	//tests date
	@Test
	void testSetDate() {
		//tests a past date
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = calendar.getTime();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentTest.setDate(pastDate);
	    });
		//tests a future date
		Calendar calendar1 = Calendar.getInstance();
	    calendar1.add(Calendar.DAY_OF_MONTH, 1);
	    Date futureDate = calendar1.getTime();
		Assertions.assertDoesNotThrow(() -> {
			appointmentTest.setDate(futureDate);
	    });
		//test null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentTest.setDate(null);
	    });
	}
	
	//tests descriptions
	@Test
	void testSetDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentTest.setDescription("Long Description Long Description Long Description Long Description Long Description ");
	    });
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentTest.setDescription(null);
	    });
		Assertions.assertDoesNotThrow(() -> {
			appointmentTest.setDescription("Normal description");
	    });
	}
	
	
	//tests if getters are being assigned
	@Test
	void testGetID() {
		assertNotNull(appointmentTest.getID());
	}
	
	@Test
	void testGetDate() {
		assertNotNull(appointmentTest.getDate());	
		}
	
	@Test
	void testGetDescription() {
		assertNotNull(appointmentTest.getDescription());
	}
	
	

}
