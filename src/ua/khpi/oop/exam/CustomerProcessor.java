package ua.khpi.oop.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class CustomerProcessor {
    private Customer[] customers = new Customer[0];

    public void add(Customer customer) {
        if (customer != null) {
            Customer[] newCustomer = new Customer[customers.length + 1];
            System.arraycopy(customers, 0, newCustomer, 0, customers.length);
            newCustomer[newCustomer.length - 1] = customer;
            customers = newCustomer;
        }
    }

    public void deleteByName(String name) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName().equals(name)) {
                Customer[] newCustomer = new Customer[customers.length - 1];
                if (i == 0) {
                    System.arraycopy(customers, 1, newCustomer, 0, newCustomer.length);
                } else if (i == customers.length - 1) {
                    System.arraycopy(customers, 0, newCustomer, 0, i);
                } else {
                    System.arraycopy(customers, 0, newCustomer, 0, i);
                    System.arraycopy(customers, i + 1, newCustomer, i, newCustomer.length - i);
                }
                customers = newCustomer;
            }
        }
    }

    public void deleteBySurname(String surname) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getSurname().equals(surname)) {
                Customer[] newCustomer = new Customer[customers.length - 1];
                if (i == 0) {
                    System.arraycopy(customers, 1, newCustomer, 0, newCustomer.length);
                } else if (i == customers.length - 1) {
                    System.arraycopy(customers, 0, newCustomer, 0, i);
                } else {
                    System.arraycopy(customers, 0, newCustomer, 0, i);
                    System.arraycopy(customers, i + 1, newCustomer, i, newCustomer.length - i);
                }
                customers = newCustomer;
            }
        }
    }

    public void showAll() {
        for (int i = 0; i < customers.length; i++) {
            System.out.printf("%2d: %s%s", i + 1, customers[i], System.lineSeparator());
        }
        System.out.println();
    }

    public void sort(Comparator<Customer> comparator) {
        Arrays.sort(customers, comparator);
    }

    public Customer searchByName(String name) {
        Customer result = null;
        if (customers != null) {
            for (Customer c : customers) {
                if (c.getName().equals(name)) {
                    result = c;
                    return result;
                }
            }
        }
        return result;
    }
    public Customer searchBySurname(String surname) {
        Customer result = null;
        if (customers != null) {
            for (Customer c : customers) {
                if (c.getSurname().equals(surname)) {
                    result = c;
                    return result;
                }
            }
        }
        return result;
    }
    public Customer searchByPhone(String phone) {
        Customer result = null;
        if (customers != null) {
            for (Customer c : customers) {
                if (c.getNumberPhone().equals(phone)) {
                    result = c;
                    return result;
                }
            }
        }
        return result;
    }
    public Customer searchByRegistration(Date registration) {
        Customer result = null;
        if (customers != null) {
            for (Customer c : customers) {
                if (c.getRegistration().equals(registration)) {
                    result = c;
                    return result;
                }
            }
        }
        return result;
    }
    public void save() throws Exception {
        FileOutputStream fOut = new FileOutputStream("serialization");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(customers);
        oOut.close();
    }
}
