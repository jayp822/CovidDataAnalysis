import java.io.*;
import java.util.Scanner;

public class CovidAnalysisDemo {
   public static void main(String[] args) throws IOException {
      CovidAnalysis covid = new CovidAnalysis(
            "/Applications/School Stuff/Java programs/Visual Studio Java/Covid19_1302/src/us_covid_recent.txt");
      Scanner kb = new Scanner(System.in);

      // b) total deaths of a given state;
      System.out.println("Enter the state name:");
      String state = kb.nextLine();
      int totalDeaths = covid.covidDeathByState(state);
      System.out.println("Total deaths by state: " + totalDeaths);

      // c) total deaths of a given county in state
      System.out.println("Enter state name: ");
      String state2 = kb.nextLine();
      System.out.println("Enter the county name:");
      String county2 = kb.nextLine();
      totalDeaths = covid.covidDeathByCounty(state2, county2);
      System.out.println("Total Deaths by county: " + totalDeaths);

      // d) total cases of a given county in state

      System.out.println("Enter state name: ");
      String state3 = kb.nextLine();
      int totalCases = covid.covidCasesByState(state3);
      System.out.println("Total cases in " + state3 + ": " + totalCases);

      // e) the state which has highest covid cases

      System.out.println(covid.covidHighestCasesByState());

      // f) The county which has highest death rate by 9/14/2021

      System.out.println("\n" + covid.covidHighestDeathRateByCountyState());

      kb.close();
   }
}
