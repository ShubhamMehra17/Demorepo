package org.example.Models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BusData {
    private int busId;

    private String busNo;

    private String busRoute;

    private String busSource;

    private String busDestination;

    private int busCapacity;

    private int availableCapacity;

    private List<Passenger> passengerList = new ArrayList<>();

    private LocalTime busStartTime;

    public BusData() {
    }

    public BusData(int busId, String busNo, String busRoute, String busSource, String busDestination, int busCapacity, int availableCapacity, List<Passenger> passengerList, LocalTime busStartTime) {
        this.busId = busId;
        this.busNo = busNo;
        this.busRoute = busRoute;
        this.busSource = busSource;
        this.busDestination = busDestination;
        this.busCapacity = busCapacity;
        this.availableCapacity = availableCapacity;
        this.passengerList = passengerList;
        this.busStartTime = busStartTime;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
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

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public LocalTime getBusStartTime() {
        return busStartTime;
    }

    public void setBusStartTime(LocalTime busStartTime) {
        this.busStartTime = busStartTime;
    }


    @Override
    public String toString() {
        return "BusData{" +
                "busId=" + busId +
                ", busNo='" + busNo + '\'' +
                ", busRoute='" + busRoute + '\'' +
                ", busSource='" + busSource + '\'' +
                ", busDestination='" + busDestination + '\'' +
                ", busCapacity=" + busCapacity +
                ", availableCapacity=" + availableCapacity +
                ", passengerList=" + passengerList +
                ", busStartTime=" + busStartTime +
                '}';
    }
}
