package org.example.Dao;

import java.sql.*;

public class BusDataDao {


    public static void updatingInBusRecord(Date d, int busroute, Connection connection) {
        try {
            Date date = d;
            int busRoute = busroute;

            PreparedStatement preparedStatement = connection.prepareStatement("select * from buses where BUSROUTE=?");
            preparedStatement.setInt(1, busRoute);
            ResultSet rst = preparedStatement.executeQuery();
            int busCapacity = 0;

            Time busTime = null;
            while(rst.next()){
                busCapacity =rst.getInt("BUS_CAPACITY");
                busTime = rst.getTime("BUS_TIME");
            }

            int busreducedCapacity = busCapacity-1;
            PreparedStatement preparedStatement2 = connection.prepareStatement("Select * FROM BUSESDATA WHERE DEPARTURE_DATE=? AND BUS_ROUTE=?");
            preparedStatement2.setDate(1,date);
            preparedStatement2.setInt(2,busRoute);
            ResultSet rst1=preparedStatement2.executeQuery();
            if (!rst1.next()){
                PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO BUSESDATA (BUS_ROUTE,BUS_CAPACITY,BUS_AVAILABLECAPACITY,BUS_TIME,DEPARTURE_DATE) VALUES" +
                        "(?,?,?,?,?)");
                preparedStatement1.setInt(1,busRoute);
                preparedStatement1.setInt(2,busCapacity);
                preparedStatement1.setInt(3,busreducedCapacity);
                preparedStatement1.setTime(4,busTime);
                preparedStatement1.setDate(5,date);

                int dataAdded= preparedStatement1.executeUpdate();
            }else{
                int availablbbusCapacity = 0;
                PreparedStatement preparedStatement3 = connection.prepareStatement("Select * FROM BUSESDATA WHERE DEPARTURE_DATE=? AND BUS_ROUTE=?");
                preparedStatement3.setDate(1,date);
                preparedStatement3.setInt(2,busRoute);
                ResultSet rst2=preparedStatement2.executeQuery();
                while (rst2.next()){
                    availablbbusCapacity=rst2.getInt("BUS_AVAILABLECAPACITY");
                }

                if (availablbbusCapacity>0)
                {
                    int forUpdatingBusCapacity = availablbbusCapacity - 1;
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE BUSESDATA SET BUS_AVAILABLECAPACITY=?");
                    preparedStatement1.setInt(1, forUpdatingBusCapacity);
                    int dataUpdated = preparedStatement1.executeUpdate();
                }else {
                    System.out.println("Bus Is Full No Seats Available...");
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
