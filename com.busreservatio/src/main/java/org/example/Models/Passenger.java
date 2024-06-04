package org.example.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Passenger {

    private int passengerId;
    private String passengerName;
    private String passengerEmail;

    private int passengerAge;

    private String passengerContact;

    private String pSource;

    private String pDestination;

    private LocalDate dateOfBooking;

    private LocalDateTime dateBooked;


    private int busId;

    private int ticketId;


    public Passenger() {
    }

    public Passenger(int passengerId, String passengerName, String passengerEmail, int passengerAge, String passengerContact, String pSource, String pDestination, LocalDate dateOfBooking, LocalDateTime dateBooked, int busId, int ticketId) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.passengerAge = passengerAge;
        this.passengerContact = passengerContact;
        this.pSource = pSource;
        this.pDestination = pDestination;
        this.dateOfBooking = dateOfBooking;
        this.dateBooked = dateBooked;
        this.busId = busId;
        this.ticketId = ticketId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getPassengerContact() {
        return passengerContact;
    }

    public void setPassengerContact(String passengerContact) {
        this.passengerContact = passengerContact;
    }

    public String getpSource() {
        return pSource;
    }

    public void setpSource(String pSource) {
        this.pSource = pSource;
    }

    public String getpDestination() {
        return pDestination;
    }

    public void setpDestination(String pDestination) {
        this.pDestination = pDestination;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalDateTime getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDateTime dateBooked) {
        this.dateBooked = dateBooked;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                ", passengerAge=" + passengerAge +
                ", passengerContact='" + passengerContact + '\'' +
                ", pSource='" + pSource + '\'' +
                ", pDestination='" + pDestination + '\'' +
                ", dateOfBooking='" + dateOfBooking + '\'' +
                ", dateBooked='" + dateBooked + '\'' +
                ", busId=" + busId +
                ", ticketId=" + ticketId +
                '}';
    }
}
