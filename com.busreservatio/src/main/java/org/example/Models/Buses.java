package org.example.Models;

import java.time.LocalTime;

public class Buses {

    private int busId;

    private String busNo;

    private String busRoute;

    private String busSource;

    private String busDestination;

    private int busCapacity;


    private LocalTime busStartTime;


    public Buses() {
    }


    public Buses(int busId, String busNo, String busRoute, String busSource, String busDestination, int busCapacity, LocalTime busStartTime) {
        this.busId = busId;
        this.busNo = busNo;
        this.busRoute = busRoute;
        this.busSource = busSource;
        this.busDestination = busDestination;
        this.busCapacity = busCapacity;
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

    public LocalTime getBusStartTime() {
        return busStartTime;
    }

    public void setBusStartTime(LocalTime busStartTime) {
        this.busStartTime = busStartTime;
    }


    @Override
    public String toString() {
        return "Buses{" +
                "busId=" + busId +
                ", busNo='" + busNo + '\'' +
                ", busRoute='" + busRoute + '\'' +
                ", busSource='" + busSource + '\'' +
                ", busDestination='" + busDestination + '\'' +
                ", busCapacity=" + busCapacity +
                ", busStartTime=" + busStartTime +
                '}';
    }
}
