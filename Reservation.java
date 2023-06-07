import java.util.Arrays;
import java.util.Scanner;

public class Reservation {
    // Initialize 2D String array 
    private String[][] array;

    // Reservation constructor take 2D String array
    public Reservation(String[][] array) {
        // the instance variable array is initialized with the value passed to the constructor
        this.array = array;
    }

    // print out array
    public void print() {
        System.out.println(Arrays.deepToString(array));
    }

    // greeting method 
    public void greeting() {
        // set boolean isTrue
        boolean isTrue = true;
        // scanner captures user input
        Scanner scanner = new Scanner(System.in);
        // print out welcome message
        System.out.println("Welcome to the ticket reservation system!");
        // print method shows user available seating
        print();
        // while isTrue
        while (isTrue) {
            // asks user to select row
            System.out.print("Please select the row: ");
            // set row equal to user input
            int row = scanner.nextInt();
            // Consume the newline character
            scanner.nextLine(); 
            // asks user for seat
            System.out.print("Please select the seat: ");
            // set seat to user input
            int seat = scanner.nextInt();
            // Consume the newline character
            scanner.nextLine();
            // print message confirming what user has selected 
            System.out.println("You have selected Row: " + row + " Seat: " + seat);
            // asks user to make choice on wheter to confirm or make another choice
            System.out.println("Type Y to confirm reservation, N to go back or X to exit: ");
            // set choice variable to user input and set input to uppercase
            String choice = scanner.nextLine().toUpperCase();
            // if choice equalls Y
            if (choice.equals("Y")) {
                // set selected seat to X to reserve seat
                array[row - 1][seat - 1] = "X";
                // print method to display array after reserving choice
                print();
                // set isTrue to false to exit loop
                isTrue = false;
            } 
            // if choice is X
            else if (choice.equals("X")) {
                // print goodbye message
                System.out.println("Goodbye");
                // set isTrue to false to end loop
                isTrue = false;
            } 
            // if coice is N
            else if (choice.equals("N")) {
                // continue to keep loop going
                continue;
            } 
            // else user has entered invalid character
            else {
                // let user know chouce is invlaid
                System.out.println("Invalid character, please try again");
            }
        }
        // close scanner
        scanner.close();
    }

    public static void main(String[] args) {
        // intialize myArray
        String[][] myArray = new String[3][3];

        // set each element in myArray to O to start
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                myArray[i][j] = "O";
            }
        }

        // new instance of Reservation
        Reservation myReservation = new Reservation(myArray);
        // call greeting on myReservation
        myReservation.greeting();
    }
}
