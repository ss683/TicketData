package com.company;
import java.util.*; //import mostly everything
import java.text.DecimalFormat; //to truncate average
public class TicketData {

    public static void main(String[] args) { //declaration of main method
        int[] Tickets = {54, 159, 35, 57, 52, 49, 59, 33, 48, 33, 40, 14, 58, 37, 47, 33, 29, 25, 25}; //all of the cheapest ticket prices
        System.out.println(calculations(Tickets)); //printing results of our calculations
    }

    private static String calculations(int[] cheapest) { //declaration of method used to figure out average, median, min, and max
        double average; //average cheapest ticket price
        int min; //double that will represent the lowest ticket price
        int max; //double that will represent the highest ticket price
        double med; //double that will represent the "middle" value of all the tickets
        double totalPrice = 0; //double that will represent the total value of all the tickets; declaring and initializing this to "0" because otherwise you get a "wasn't initialized" message when trying to initialize the variable later on
        int temp; //int to store one value so that two other variables can swap values

        //BUBBLE SORTING METHOD TO SORT TICKET PRICE IN ASCENDING ORDER

        for(int i = 0; i < cheapest.length - 1; i++) { //first loop ensures that it is impossible for the loop to exit without being sorted; designed for worst case scenario
            for(int k = 0; k < cheapest.length - 1 - i; k++) { //going to go through all elements in array, but no point going to elements already sorted towards the end of the array, hence the "cheapest.length - 1 - i" for the termination statement
                if(cheapest[k] > cheapest[k + 1]) { //"if a ticket on the left is more than a ticket on the right"
                    temp = cheapest[k];
                    cheapest[k] = cheapest[k + 1]; //"then swap their positions so that the array can be in ascending order"
                    cheapest[k + 1] = temp;
                }
            }
        }

        min = (int)cheapest[0]; //since the array is now in ascending order, the lowest ticket price will be in the first index; casting as int because all ticket prices are integers
        max = (int)cheapest[cheapest.length - 1]; //since the array is now in ascending order, the greatest ticket price will be in the last index casting as int because all ticket prices are integers
        if(cheapest.length % 2 == 1) //"if there is an odd amount of tickets"
            med = cheapest[(cheapest.length - 1) / 2]; //"then the median value is directly in the middle, AKA the total amount of tickets minus 1, then divided by 2"
        else
            med = (cheapest[(cheapest.length - 1) / 2] + cheapest[((cheapest.length - 1) / 2) + 1]) / 2; //"otherwise the median value is the average of the two middle values, AKA the two middle values added together, then divided by 2"

        for(int i = 0; i < cheapest.length; i++) { //goes through every single ticket price within the array that is now in ascending order
            totalPrice += cheapest[i]; //adding together all the ticket prices
        }
        average = totalPrice / cheapest.length; //the mean always equals all of the numbers added up divided by the total number of items
        return "Average cheapest ticket price: $" + new DecimalFormat("#.##").format(average) /*this truncates average to two decimal places */ + "\nThe lowest cheap ticket price: $" + min + "\nThe highest cheap ticket price: $" + max + "\nThe median cheap ticket price: $" + med; //returns a string of all the important information we need
    }
}

/*ANSWERING THE QUESTION: The way you can ensure that you keep the tour name associated with the ticket data is by creating a "Ticket" object. Essentially you would create 19 different Ticket
objects, allowing them to have a "Tour" String variable, "Cheapest Price" int variable, and an "Avg Price" double variable. You would then create an array of these ticket objects, and you could
 still sort them based off of their "Cheapest Price" int variable, however, the "Avg Price" and "Tour" variables would travel with the object when it changes positions in the array.*/