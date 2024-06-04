package org.example.Service;

import static org.example.Dao.TicketDao.cancleTickets;
import static org.example.Dao.TicketDao.viewTickets;

public class TicketService {

    public static void viewTripDetails(){
        viewTickets();
    }

    public static void cancelBooking(){
        cancleTickets();
    }

}
