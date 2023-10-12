import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //There is an initial roll of 2 dice resulting in a sum of 2 – 12

        //If the sum is 2, 3 or 12 it is called "craps" or "crapping out" and the game is over with a loss
        //If the sum is 7 or 11 it is called a ‘natural’ and the game is over with a win
        //For all other values, the sum becomes ‘the point’

        //The user makes subsequent rolls until they either throw a 7 in which case they lose or they make the point sum in which case they win
        //After a win or loss the next player rolls the die for a new game
        //In our simulation, the program will simply ask the user if they want to continue to play

        //For each roll show the value for each die and the sum.
        //For case i or ii above, indicate that the user either crapped out or won with a natural and then prompt to play again.
        //For case iii indicate that the sum is now the point.  For each subsequent roll indicate the status of the result:
        // Trying for point
        // Made point and won.  (Prompt user to play again.)
        // Got a seven and lost   (Prompt user to play again.)

        Random random = new Random();
        Scanner in = new Scanner(System.in);

        boolean playAgain = false;
        boolean validInput;

        int die1;
        int die2;
        int dieTotal;
        int point;

        do
        {
            //initial roll
            die1 = random.nextInt(6) + 1;
            die2 = random.nextInt(6) + 1;
            dieTotal = die1 + die2;

            //fancy print
            System.out.println("|  FirstRoll  |");
            System.out.printf("| %2d ", die1);
            System.out.printf(" %2d |", die2);
            System.out.printf(" %2d |%n", dieTotal);

            //first round
            if (dieTotal == 2 || dieTotal == 3 || dieTotal == 12)
            {
                //you lose
                System.out.println("|    Loser    |");
                System.out.println("Your total equals " + dieTotal + ", better luck next time!");
            }
            else if (dieTotal == 7 || dieTotal == 11)
            {
                //you win
                System.out.println("|   Winner!   |");
                System.out.println("Your total equals " + dieTotal + ", you win!");
            }
            else
            {
                //set at 'the point'
                point = dieTotal;
                System.out.println("| TryingPoint |");

                //reroll
                die1 = random.nextInt(6) + 1;
                die2 = random.nextInt(6) + 1;
                dieTotal = die1 + die2;

                //fancy print
                System.out.printf("| %2d ", die1);
                System.out.printf(" %2d |", die2);
                System.out.printf(" %2d |%n", dieTotal);

                while (dieTotal != point && dieTotal != 7)
                {
                    //reroll
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    dieTotal = die1 + die2;

                    //fancy print
                    System.out.printf("| %2d ", die1);
                    System.out.printf(" %2d |", die2);
                    System.out.printf(" %2d |%n", dieTotal);
                }

                if (dieTotal == 7)
                {
                    //you lose
                    System.out.println("|    Loser    |");
                    System.out.println("Your total equals " + dieTotal + ", better luck next time!");
                }
                else
                {
                    //you win
                    System.out.println("|   Winner!   |");
                    System.out.println("Your total equals " + dieTotal + ", you win!");
                }
            }

            do
            {
                System.out.print("Want you play again [Y N]: ");
                String test = in.nextLine();
                if (test.equalsIgnoreCase("Y"))
                {
                    playAgain = true;
                    validInput = true;
                }
                else if (test.equalsIgnoreCase("N"))
                {
                    validInput = true;
                    playAgain = false;
                }
                else
                {
                    System.out.println("You incorrectly said " + test);
                    validInput = false;
                }
            } while(!validInput);
        } while(playAgain);
    }
}