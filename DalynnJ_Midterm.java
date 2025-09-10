package CSCI_211;


import java.util.Scanner;

public class DalynnJ_Midterm 
{
	// Get wind direction from user input with validation
	  public static String GetWindDirection(Scanner tKB) 
	  {
	      String windDirection;
	      do {
	        System.out.print("\nEnter the wind direction (N, S, E, W, NE, NW, SW, SE): ");
	        windDirection = tKB.nextLine().toUpperCase(); // Convert to uppercase
	        
	      // Check if input4 matches   
	      if (!windDirection.matches("N|S|E|W|NE|NW|SW|SE")) {
	                System.out.println("Invalid input. Please enter a valid direction.");
      }
	      // Repeat until valid input
	      } while (!windDirection.matches("N|S|E|W|NE|NW|SW|SE"));

	      return windDirection;
	      }
	  
	  // Get wind speed from user input with validation 
	  public static double GetWindSpeed(Scanner tKB)
	  {
		  double windSpeed;
		  do {
			  System.out.print("\nEnter the wind speed (MPH): ");
			  windSpeed = Double.parseDouble(tKB.nextLine()); // Convert to a number
		  } while (windSpeed < 0 || windSpeed > 150); // Ensure matches for validation
		  
		  return windSpeed;
			  
		  }
	  
	  //Get weather outlook from user input with validation
	    public static String GetOutlook(Scanner tKB) {
	        String outlook;
	        do {
	            System.out.print("\nEnter the weather outlook (Sunny, Rainy, Cloudy, Snowy): ");
	            outlook = tKB.nextLine();
	            
	            //Ensure user enters valid outlook
	            if (!outlook.matches("sunny|rainy|cloudy|snowy")) {
	                System.out.println("Invalid input. Please enter Sunny, Rainy, Cloudy, or Snowy.");
	            }
	        } while (!outlook.matches("sunny|rainy|cloudy|snowy"));

	        return outlook;
	    }

	    // Get temp from user input within specified scale
	    public static double GetTemperature(Scanner tKB, String scale) {
	        double temp;
	        do {
	            System.out.print("\nEnter the temperature in " + scale + ": ");
	            temp = Double.parseDouble(tKB.nextLine()); //Convert to a number
	        } while (temp < -100 || temp > 150); // Ensure user enters valid temp
	        
	        return temp;
	    }

	    //Displays program credits at the end
	    public static void PrintCredits() {
	        System.out.print("\n************************************");
	        System.out.print("\n*** Created by Dalynn Jacobs       ***");
	        System.out.print("\n*** Copyright 2025                 ***");
	        System.out.print("\n************************************\n");
	    }

	    //Get number of days user wants to report
	    public static int GetNumOfDays(Scanner tKB)
		{
			String strRepeats=""; // 
			int repeats=0; // 
			
		    System.out.print("How many days would you like to report?: ");
		    strRepeats = tKB.nextLine();
		    repeats = Integer.parseInt(strRepeats); //Converts to a number

		    return repeats;
		}
	    
	    public static void main(String[] args) {
	        Scanner myKB = new Scanner(System.in);

	        int repeats = GetNumOfDays(myKB); //Get number of days
	        
	        //Array to store weather data for multiple days
	        String[] windDirections = new String[repeats];
	        String[] outlooks = new String[repeats];
	        double[] windSpeed = new double[repeats];
	        double[] tempCelsius = new double[repeats];
	        double[] tempFahrenheit = new double[repeats];
	        double[] tempKelvin = new double[repeats];

	//Loop to collect weather data for each day
	for (int ctr = 0; ctr < repeats; ctr++)
	    {
	        
	    System.out.println("\nDay " + (ctr + 1) + " Weather Report:");
	    
	    windDirections[ctr] = GetWindDirection(myKB); //Get wind direction
	    windSpeed[ctr] = GetWindSpeed(myKB); //Get wind speed
	    outlooks[ctr] = GetOutlook(myKB); //Get outlook
	    tempCelsius[ctr] = GetTemperature(myKB, "Celsius"); //Get temp
	    tempFahrenheit[ctr] = (tempCelsius[ctr] * 9 / 5) + 32; // Convert to from C to F and K
	    tempKelvin[ctr] = tempCelsius[ctr] + 273.15;	     
	    
	    }
	
		//Display final weather report
		System.out.println("\nFinal Weather Report:");
		for (int ctr = 0; ctr < repeats; ctr++) 
		{
		    	 System.out.println("\nDay " + (ctr + 1) + ":");
		    	 System.out.println("Wind Direction: " + windDirections[ctr]);
		    	 System.out.println("Wind Speed: " + windSpeed[ctr] + "MPH ");
		    	 System.out.println("Outlook: " + outlooks[ctr]);
		    	 System.out.println("Temperature: " + tempCelsius[ctr] + "°C / " + tempFahrenheit[ctr] + "°F / " + tempKelvin[ctr] + "K");
	       
		}
	PrintCredits(); //Show program credits 
	myKB.close(); //Close the scanner
	    }
	}
