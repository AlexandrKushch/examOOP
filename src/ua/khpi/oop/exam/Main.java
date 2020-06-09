package ua.khpi.oop.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Main {
    private static Comparator<Customer> NAME_COMPARATOR = Comparator.comparing(Customer::getName);
    private Comparator<Customer> SURNAME_COMPARATOR = Comparator.comparing(Customer::getSurname);
    private Comparator<Customer> PHONE_COMPARATOR = Comparator.comparing(Customer::getNumberPhone);
    private Comparator<Customer> REGISTRATION_COMPARATOR = Comparator.comparing(Customer::getRegistration);

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

    public static void main(String[] args) throws ParseException {
        Customer[] customers = {
                new Customer("John", "Bush", "0683191521", format.parse("2001.06.15")),
                new Customer("Anne", "Smith", "0973514631", format.parse("2000.12.20")),
                new Customer("Rick", "Johnson", "0982245671", format.parse("1999.09.13")),
                new Customer("Morty", "Williams", "0962312365", format.parse("2002.03.03"))
        };

        CustomerProcessor processor = new CustomerProcessor();

        for (Customer c : customers) {
            processor.add(c);
        }
        processor.showAll();

        processor.deleteByName("John");
        processor.deleteBySurname("Johnson");
        processor.showAll();

        processor.sort(NAME_COMPARATOR);
        processor.showAll();

        Customer surnameSearch = processor.searchBySurname("Williams");
        System.out.println(surnameSearch);

        Date date = format.parse("2000.12.20");
        Customer dateSearch = processor.searchByRegistration(date);
        System.out.println(dateSearch);

        try {
            processor.save();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Customer[] newCustomers;
        try {
            newCustomers = processor.upload();
            System.out.println("------newHumans------");
            for (Customer c : newCustomers) {
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
