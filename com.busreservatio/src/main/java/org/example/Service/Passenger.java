package org.example.Service;

import java.sql.SQLException;

import static org.example.Dao.PassengerDao.operations.bookSeat;

public class Passenger {

  public static void addPassenger(){
      try {
          bookSeat();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }

  }
}
