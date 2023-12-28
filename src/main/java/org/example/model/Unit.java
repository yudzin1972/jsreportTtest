package org.example.model;

public class Unit {
    private String dolg;
    private String name;
    private String phone;
    private String room;
    public Unit() {
    }

    public Unit(String dolg, String name, String phone, String room) {
        this.dolg = dolg;
        this.name = name;
        this.phone = phone;
        this.room = room;
    }

    public String getDolg() {
        return dolg;
    }

    public void setDolg(String dolg) {
        this.dolg = dolg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
