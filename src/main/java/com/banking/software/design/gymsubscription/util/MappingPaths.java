package com.banking.software.design.gymsubscription.util;

public class MappingPaths {

    public static final String CUSTOMER_PATH = "/customer";

    // 1
    public static final String CUSTOMER_SIGNUP = "/signup";
    // 2
    public static final String CUSTOMER_LOGIN = "/login";
    // 8
    public static final String CUSTOMER_LOGOUT = "/logout";

    public static final String CLASSES_PATH = "/classes";

    // 3
    public static final String CLASSES_NAMES = "/getall";
    // 33
    public static final String CLASSES_TIMETABLE = "/getclassesfordate";
    // 4
    public static final String CLASSES_DATE = "/getdatesforclass";
    // 5
    public static final String CLASSES_BOOK = "/book";
    // 6
    public static final String CLASSES_DETAILS = "/getclass";
    // 7
    public static final String CLASSES_BOOKINGS = "/viewbookings";

//    public static final String TIMETABLE_PATH = "/timetable";
//    public static final String TIMETABLE_CLASSES_ON_DATE = "/timetable/classes";
}
