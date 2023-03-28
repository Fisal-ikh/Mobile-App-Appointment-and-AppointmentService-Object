# Mobile-App-Appointment-and-AppointmentService-Object
Mobile Appointment Application

This project is a mobile application that allows users to manage their appointments. The application provides appointment services for adding, updating, and deleting appointment objects within the application. This project is developed using Java and JUnit for testing.

Appointment Class

The appointment object contains the following fields:

id: a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
appointmentDate: a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
description: a required description String field that cannot be longer than 50 characters. The description field shall not be null.
Appointment Service

The appointment service uses in-memory data structures to support storing appointments, and it has the following features:

Adding appointments with a unique appointment ID.
Deleting appointments per appointment ID.
Testing

This project uses JUnit tests to verify the appointment service's functionality. The tests cover the appointment object and appointment service requirements.

How to Use

To use this application, please follow these steps:

Clone the repository to your local machine.
Open the project in your preferred IDE.
Run the JUnit tests to verify the appointment service's functionality.
Use the appointment service in your application as needed.****
