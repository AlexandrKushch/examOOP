package ua.khpi.oop.exam;

public class Regular {
    private static String REGEX_NAME = "\\b[A-Z][a-z]+\\b";
    private static String REGEX_SURNAME = "\\b[A-Z][a-z]+\\b";
    private static String REGEX_PHONE = "\\+?3?8?0((39)|(67)|(68)|(96)|(97)|(98))(\\d{7})$";

    public static boolean matchName(String name) {
        return name.matches(REGEX_NAME);
    }

    public static boolean matchSurname(String surname) {
        return surname.matches(REGEX_SURNAME);
    }

    public static boolean matchPhone(String phone) {
        return phone.matches(REGEX_PHONE);
    }
}
