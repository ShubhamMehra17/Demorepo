package org.example.Models;

public class Ticket {

    private int ticketId;

    private String busNo;

    private String busRoute;

    private int ticketPrice;

    private String source;

    private String destination;



    public Ticket() {
    }


    public Ticket(int ticketId, String busNo, String busRoute, int ticketPrice, String source, String destination) {
        this.ticketId = ticketId;
        this.busNo = busNo;
        this.busRoute = busRoute;
        this.ticketPrice = ticketPrice;
        this.source = source;
        this.destination = destination;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", busNo='" + busNo + '\'' +
                ", busRoute='" + busRoute + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
