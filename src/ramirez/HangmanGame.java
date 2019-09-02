/*
 *   Name:              Jose Ramirez
 * 
 *   Program:           Hangman Game - Project 3       
 * 
 *   Description:       The user has to guess the letters on a randomly selected
 *                      word. If the user guesses all the letters from the word
 *                      the game will display a congratulations message and will
 *                      ask to play again. If the user fails to identify the 
 *                      correct letter, the Hangman will build until is complete
 *                      and the user will lose and a GAME OVER message will be 
 *                      displayed.
 *
 *   Date Started:      5/3/18 
 *   Last Modified:     5/6/18
 */

package ramirez;

import java.util.Scanner;
import java.util.Random;
public class HangmanGame 
{
    public static void main(String[] args) 
    {
        // keyboard input
        Scanner sc  = new Scanner(System.in);
        // random number generator
        Random  rnd = new Random();
        // Array of valid words
        String words [] = {"Mac", "Windows", "DOS", "Linux", "Solaris"};
        
        // decides if the user wants to keep playing
        boolean keepPlaying = true;
        
        // message to welcome the user to the game
        welcomeMessage();
        
        // game loop that keeps the user playing if desired
        while(keepPlaying)  
        {
            // holds the random number
            byte compNumber = (byte)(rnd.nextFloat() * 5 - 1);
            // holds the word to be guessed, retrieves from the array
            String guessWord = words[compNumber].toLowerCase();
            // tells if the user is still playing
            boolean areWePlaying = true;
            // holds the times the user fails
            int    deadMan   = 1;
            // holds the times the user guesses correctly
            int    goodGuess = 1;
            // holds the whole word to make the hangMan method work
            String wholeWord = words[compNumber];

            // game loop that keeps the user playing while guesses are correct
            while(areWePlaying)
            {
                System.out.print("Please pick a letter: ");
                // keyboard input for the user
                String userInput = sc.next().toLowerCase();
                
                // game logic, allows the user to exit with 0 
                if (userInput.equals("0"))
                {
                    System.out.println("\nThanks for playing, GOOD BYE!");
                    System.exit(0);
                }
                else if (guessWord.indexOf(userInput)== - 1)
                {
                    hangMan(deadMan, wholeWord);
                    ++deadMan;

                    if (deadMan == 7)
                    {
                        areWePlaying = false;
                    }
                }
                else
                {
                    int removeLetter = guessWord.indexOf(userInput);

                    String firstPart = guessWord.substring(0, removeLetter);
                    String lastPart  = guessWord.substring(removeLetter + 1);

                    guessWord = firstPart+lastPart;

                    System.out.println("\nGreat job! You have guessed " + goodGuess + " correct letter(s).\n");

                    ++goodGuess;
                }
                
                // checks if the user did won the game
                if (goodGuess == words[compNumber].length() + 1)
                {
                    System.out.println("Congratulations, you have guessed the word!!!\n");
                    areWePlaying = false;
                }
            } // while
        
            System.out.print("Would you like to play again?!");
            
            // keyboard input for the user, if user wants to keep playing 
            String userChoiceToPlay = sc.next().toLowerCase();

            // checks if the user wants to keep playing
            if (userChoiceToPlay.equals("y"))
            {
                keepPlaying = true;
            }
            else
            {
                System.out.println("\nThanks for playing, GOOD BYE!");
                keepPlaying = false;
            }
        } // while
        
    } // main
    
    // welcome message for the user
    public static void welcomeMessage()
    {
        System.out.println("Welcome to the Hangman Game.");
        System.out.println("Your choice words are Mac, Windows, DOS, Linux, and Solaris.\n");
        System.out.println("Enter \"0\" if you would like exit the game.");
    }
    
    // Hangman drawing method for the game logic
    public static void hangMan (int deadMan, String rightWord)
    {
        switch(deadMan)
        {
            case 1: System.out.println("Sorry, you guessed the wrong letter, try again.");
                    System.out.println("   _____________");
                    System.out.println("   |           |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                    break;
                    
            case 2: System.out.println("Sorry, you guessed the wrong letter, try again.");
                    System.out.println("   _____________"   );
                    System.out.println("   |           |"   );
                    System.out.println("   |          ***"  );
                    System.out.println("   |        o|.|.|o");
                    System.out.println("   |         | - | ");
                    System.out.println("   |          ---  ");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                    break;
            
            case 3: System.out.println("Sorry, you guessed the wrong letter, try again.");
                    System.out.println("   _____________    ");
                    System.out.println("   |           |    ");
                    System.out.println("   |          ***   ");
                    System.out.println("   |        o|.|.|o ");
                    System.out.println("   |         | - |  ");
                    System.out.println("   |          ---   ");
                    System.out.println("   |           |    ");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                    break;
                    
            case 4: System.out.println("Sorry, you guessed the wrong letter, try again.");
                    System.out.println("   _____________"    );
                    System.out.println("   |           |"    );
                    System.out.println("   |          ***"   );
                    System.out.println("   |        o|.|.|o ");
                    System.out.println("   |         | ~ |  ");
                    System.out.println("   |          ---   ");
                    System.out.println("   |           |    ");
                    System.out.println("   |         -----  ");
                    System.out.println("   |          |||   ");
                    System.out.println("   |          |||   ");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                    break;
                    
            case 5: System.out.println("Sorry, you guessed the wrong letter, try again.");
                    System.out.println("   _____________"    );
                    System.out.println("   |           |"    );
                    System.out.println("   |          ***"   );
                    System.out.println("   |        o|.|.|o ");
                    System.out.println("   |         | ~ |  ");
                    System.out.println("   |          ---   ");
                    System.out.println("   |           |    ");
                    System.out.println("   |         -----  ");
                    System.out.println("   |        / |||\\  ");
                    System.out.println("   |       /  ||| \\ ");
                    System.out.println("   |      m   ---   m");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("___|___");
                    break;
                    
            case 6: System.out.println("Sorry, GAME OVER");
                    System.out.println("   _____________"    );
                    System.out.println("   |           |"    );
                    System.out.println("   |          ***"   );
                    System.out.println("   |        o|*|*|o ");
                    System.out.println("   |         | Q |  ");
                    System.out.println("   |          ---   ");
                    System.out.println("   |           |    ");
                    System.out.println("   |         -----  ");
                    System.out.println("   |        / |||\\  ");
                    System.out.println("   |       /  ||| \\ ");
                    System.out.println("   |      m   ---   m");
                    System.out.println("   |         |---|"   );
                    System.out.println("   |         |   |"   );
                    System.out.println("   |         |   |"   );
                    System.out.println("   |         8   8"   );
                    System.out.println("___|___           "   );
                    System.out.println("The word was: " + rightWord + ".");
                    break;
        }
    }
} // class
