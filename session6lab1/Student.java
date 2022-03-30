package session6lab1;

import java.time.LocalDate;

public class Student {
    String id,name,address;
    LocalDate bday;
    double gpa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student(String id, String name, LocalDate bday, String address, double gpa){
        setId(id);
        setName(name);
        setBday(bday);
        setAddress(address);
        setGpa(gpa);
    }
}
