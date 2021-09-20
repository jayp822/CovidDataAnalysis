import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CovidAnalysis {

    private String delimiter = ",";
    private String[] date;
    private String[] counties;
    private String[] states;
    private int[] cases;
    private int[] deaths;
    private final String ENDDATE = "9/14/2021";

    public CovidAnalysis(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner covidStats = new Scanner(file);
        int size = 0;

        while (covidStats.hasNext()) {
            String line = covidStats.nextLine();
            size++;
        }

        covidStats.close();

        date = new String[size];
        counties = new String[size];
        states = new String[size];
        cases = new int[size];
        deaths = new int[size];

        // read the data file again,and populate all arrays. Please be aware that some
        // record may miss the last two columns.
        covidStats = new Scanner(file);
        int index = 0;
        while (covidStats.hasNext()) {
            String line = covidStats.nextLine();
            size++;
            String[] tokens = line.split(","); // 6 tokens
            date[index] = tokens[0].trim();
            counties[index] = tokens[1].trim();
            states[index] = tokens[2].trim();
            if (tokens.length >= 5) {
                cases[index] = Integer.parseInt(tokens[4].trim());
            }
            if (tokens.length >= 6) {

                deaths[index] = Integer.parseInt(tokens[5].trim());
            }
            index++;
        }

    }

    // b) covidDeathByState()
    public int covidDeathByState(String state) {
        int totalDeaths = 0;

        for (int i = 0; i < states.length; i++) {
            if ((states[i].indexOf(state) != -1) && (date[i].equals(ENDDATE))) {
                totalDeaths += deaths[i];
            }

        }
        return totalDeaths;
    }

    // c) covidDeathByCounty()
    public int covidDeathByCounty(String state, String county) {
        int totalDeaths = 0;

        for (int i = 0; i < counties.length; i++) {
            if ((counties[i].indexOf(county) != -1) && (date[i].equals(ENDDATE)) && states[i].indexOf(state) != -1) {

                totalDeaths += deaths[i];

            }
        }
        return totalDeaths;
    }

    // d) covidCasesByState():
    public int covidCasesByState(String state) {
        int totalCases = 0;

        for (int i = 0; i < counties.length; i++) {
            if ((date[i].equals(ENDDATE)) && states[i].indexOf(state) != -1) {

                totalCases += cases[i];

            }
        }
        return totalCases;

    }

    // e) covidHighestCasesByState():

    public String covidHighestCasesByState() {
        List<Integer> covidCases = new ArrayList<Integer>();

        int i = 0;
        while (i < states.length) {

            if (date[i].equals(ENDDATE)) {

                covidCases.add(covidCasesByState(states[i]));
            }

            i++;
        }

        String endSentence = "";
        for (int j = 0; j < states.length; j++) {
            if (covidCasesByState(states[j]) == Collections.max(covidCases)) {
                endSentence = (states[j]);
                break;
            }
        }

        double num = Collections.max(covidCases);

        String num2 = String.format("%,.0f", num);
        return endSentence + " is the state with the most covid cases and the number of cases are " + num2 + ".";

    }

    // f) covidHighestDeathRateByCountyState():
    public String covidHighestDeathRateByCountyState() {
        List<Double> ratio = new ArrayList<Double>();

        for (int i = 0; i < states.length; i++) {
            if (date[i].equals(ENDDATE) && cases[i] > 0) {

                // System.out.println(counties[] + ", " + states[i] + ", " + cases[i] + ", " +
                // deaths[i]);
                double deathRate = ((double) deaths[i] / (double) cases[i]);
                ratio.add(deathRate);

            }
        }
        double max = 0;

        for (int j = 0; j < ratio.size(); j++) {
            if (ratio.get(j) > max) {
                max = ratio.get(j);
            }
        }

        return "The State with the highest death rate is " + states[ratio.indexOf(max)]
                + " and the county with the highest death rate is " + counties[ratio.indexOf(max)]
                + ". The death rate is " + max;

    }
}
