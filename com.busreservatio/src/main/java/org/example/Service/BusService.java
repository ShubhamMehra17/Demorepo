package org.example.Service;

import static org.example.Dao.BusDao.*;

public class BusService {

    public static void addBusByAdmin(){
        addBus();
    }

    public static void viewBusesByAdmin(){
        viewBuses();
    }

    public static void deleteBusByAdmin(){
        deleteBus();
    }

}
