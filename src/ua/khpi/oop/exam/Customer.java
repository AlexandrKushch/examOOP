package ua.khpi.oop.exam;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private String name;
    private String surname;
    private String numberPhone;
    private Date registration;

    public Customer() {
    }

    public Customer(String name, String surname, String numberPhone, Date registration) {
        if (Regular.matchName(name)){
            this.name = name;
        }
        if(Regular.matchSurname(surname)) {
            this.surname = surname;
        }
        if (Regular.matchPhone(numberPhone)) {
            this.numberPhone = numberPhone;
        }
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", registration=" + registration +
                '}';
    }
}
