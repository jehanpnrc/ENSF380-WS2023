package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String format = value + " (" + key + ")";
        return format;
    }

    // Constructor
    public Trip(String[] array) {
        setArrival(array[0]);
        setDeparture(array[1]);
        setCity(array[2]);
        setCountry(array[3]);
    }

    // Given a date string, return just the year
    public static int getYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        return year;
    }

    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {
        int month = Integer.parseInt(date.substring(5,7));
        return month;
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip() {
        String format = this.getArrival() + " (Arrival), " + this.getDeparture() + " (Departure), " + this.getCity() + " (City), " + this.getCountry() + " (Country)";
        return format;
    }

    // Getter
    public String getArrival() {
        return this.arrival;
    }

    // Getter
    public String getDeparture() {
        return this.departure;
    }

    // Getter
    public String getCity() {
        return this.city;
    }

    // Getter
    public String getCountry() {
        return this.country;
    }

    // Setter
    public void setArrival(String date) {
        this.arrival = date;
    }

    // Setter
    public void setDeparture(String date) {
        this.departure = date;
    }

    // Setter 
    public void setCity(String city) {
        this.city = city;
    }

    // Setter 
    public void setCountry(String country) {
        this.country = country;
    }

}

