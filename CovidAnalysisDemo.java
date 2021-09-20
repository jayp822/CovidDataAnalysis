/*
Author: Dennis Parkman

Dr. Phelps/Liu has allowed students to discuss the algorithm and/or general concepts about the assignment 
with other students and to receive limited help on specific topics. However, I assume full responsibility 
for the content and integrity of this assignment. I have developed my own solution to this assigned project. 
I have not used or copied (by any means) another�s work (or portions of it) in order to represent it as my 
own including material from the internet. If I used a common computer, I have remembered to delete the files 
and empty the recycle bin. I have destroyed all extra printouts of my code. I have not shared my code with 
anyone. I am sole author of the assignment; however,

I received outside help from the following people: None

These are the websites that I used as reference: None
*/

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