package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String format = value + " (" + key + ")";
        return format;
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        int numTrips = myTrips.length;
        for (int i = 0; i < numTrips; i++) {
            trips[i] = new Trip(myTrips[i]);
        }
    }

    public int numInstances() {
        int counter = 0;
        int i = 0;
        while (trips[i] != null) {
            counter++;
            i++;
        }
        return counter;
    }

    // Getter
    public Trip[] getTrips() {
        return this.trips;
    }

    public String formatByArrival() {
        String format = "";
        int[][] array = organizedArray();
        int num = numInstances();

        for (int i = 0; i < 3; i++){
            int yearCounter = 0;
            for (int j = 0; j < 12; j++){
                int monthCounter = 0;
                for (int k = 0; k < num; k++){

                    if (array[k][0] == i && array[k][1] == j) {
                        if(yearCounter == 0){
                            String year = Integer.toString(array[k][0] + 2021);
                            String yearHeader = year + " (Year)\n";
                            format = format.concat(yearHeader);
                            yearCounter ++;
                        }
                        if (monthCounter == 0){
                            String month = Integer.toString(array[k][1] + 1);
                            String monthHeader = "--" + month + " (Month)\n";
                            format = format.concat(monthHeader);
                            monthCounter ++;
                        }
                        String location = "----" + trips[k].getCity() + " (City), " + trips[k].getCountry() + " (Country) (Place)\n";
                        format = format.concat(location);
                    }

                }
            }
        }
        return (format.trim());
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        int[][] array = organizedArray();
        int num = numInstances();
        String nested[][][] = new String[3][12][num];

        //System.out.printf("%d", num);
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 12; j++) {

                int counter = 0;
                for (int k = 0;k != num; k++) {

                    if (array[k][0] == i && array[k][1] == j) {
                        //System.out.printf("%d, %d\n", array[k][0], array[k][1]);
                        nested[i][j][counter] = trips[k].getCity() + " (City), " + trips[k].getCountry() + " (Country)";
                        counter ++;
                    } else {
                        nested[i][j][k] = "null";
                    }
                }

            }
        }
        return nested;

    }

    // array[n][0] = arrival year
    // array[n][1] = arrival month
    int [][] organizedArray() {
        int num = numInstances();
        int array[][] = new int[num][2];

        for (int i = 0; i < num; i++) {

            String arrival = trips[i].getArrival();

            int month = Trip.getMonth(arrival) - 1;
            int year = Trip.getYear(arrival) - 2021;


            array[i][0] = year;
            array[i][1] = month;


        }


        return array;
    }

}
