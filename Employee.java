package org.example;

public class Employee {
    String eName;

    int eId;

    String ePosition;

    public Employee(String eName, int eId, String ePosition) {
        this.eName = eName;
        this.eId = eId;
        this.ePosition = ePosition;
    }

    public Employee() {
    }


    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getePosition() {
        return ePosition;
    }

    public void setePosition(String ePosition) {
        this.ePosition = ePosition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eName='" + eName + '\'' +
                ", eId=" + eId +
                ", ePosition='" + ePosition + '\'' +
                '}';
    }
}
