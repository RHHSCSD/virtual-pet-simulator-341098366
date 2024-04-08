/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // variables
        
        boolean petReal = false;
        boolean startGame = false;
        
        char consonant;
        
        int attempts = 3;
        int randomNumber = 0;
        int guess = 0;
        
        String pet = "";
        String username = "";
        String password = "";
        String name = "";
        String vowel = "";
        
        final int startingPoints = 20;
        final int guesses = 15;
        final String correctUsername = "snoopy";
        final String correctPassword = "toto";
        
        Scanner kb = new Scanner(System.in);
        Random rn = new Random();
        
        //Welcome screen
        System.out.println(" ,_     _\n" +" |\\\\_,-~/\n" +" / _  _ |    ,--.\n" +"(  @  @ )   / ,-'\n" +" \\  _T_/-._( (\n" +" /         `. \\\n" +"|         _  \\ |\n" +" \\ \\ ,  /      |\n" +"  || |-_\\__   /\n" +" ((_/`(____,-'");
        System.out.println("Ultra Silent Pet Simulator Infinity Rebirth V2 Redux");
        //login screen
//        while(attempts !=0){
//            System.out.print("Please enter your username: ");
//            username = kb.nextLine();
//            System.out.print("Please enter your password: ");
//            password = kb.nextLine();
//            //Successful login
//            if (username.equals(correctUsername) && password.equals(correctPassword)){
//                System.out.println("Successful Login");
//                attempts = 0;
//            }
//            //bad login and end program
//            else {
//                System.out.println("Wrong username or password");
//                attempts--;
//                if (attempts == 0){
//                    System.out.println("Too many incorrect logins. Self destruct sequence initiated");
//                    System.exit(0);
//                }
//            }
//        }

        //Main menu screen
        while (startGame == false){
            //if pet has not been generated yet
            if (petReal == false){
                System.out.println("Main Menu:\nStart: 1\nInstructions: 2\nExit: 3");
                String menuChoice = kb.nextLine();
                menuChoice = menuChoice.toLowerCase();
                switch (menuChoice) {
                    //go to pet selection
                    case "1":
                    case "start":
                        //pet selection menu
                        System.out.println("Choose a Pet: \nImposter: 1\nFBI Agent: 2");
                        int petPick = kb.nextInt();
                        //assign pet based on input
                        switch (petPick) {
                            case 1:
                                pet = "Imposter";
                                break;
                            case 2:
                                pet = "FBI Agent";
                                break;
                            default:
                                pet = "Nuke";
                                break;
                        }
                        //output their pet choice
                        System.out.println("You have picked " + pet);

                        //naming menu
                        System.out.println("How do you want to name your pet?\nManual: 1\nRandom Name: 2");
                        int namingChoice = kb.nextInt();
                        //flush
                        kb.nextLine();
                        //manually name pet
                        if (namingChoice == 1) {
                            System.out.print("Enter pet name: ");
                            name = kb.nextLine();
                        }
                        //generate random name
                        else if (namingChoice == 2) {
                            //generate random vowel
                            int randomVowel = rn.nextInt(5);
                            switch (randomVowel) {
                                case 0:
                                    vowel = "a";
                                    break;
                                case 1:
                                    vowel = "e";
                                    break;
                                case 2:
                                    vowel = "i";
                                    break;
                                case 3:
                                    vowel = "o";
                                    break;
                                case 4:
                                    vowel = "u";
                                    break;
                            }
                            //decide if there should be double vowels
                            boolean doubleVowel = rn.nextBoolean();
                            if (doubleVowel == true) {
                                vowel = vowel + vowel;
                            }
                            //generate random consonant
                            int randomConsonant = rn.nextInt(26) + 97;
                            //change number if it corresponds to a vowel in ASCII
                            switch (randomConsonant) {
                                case 97:
                                case 101:
                                case 105:
                                case 111:
                                case 117:
                                    randomConsonant++;
                                    break;
                            }
                            //cast number into a character
                            consonant = (char) randomConsonant;
                            //generate name
                            name = consonant + vowel + consonant + vowel;
                        }
                        //output name
                        System.out.println("Your pet, named " + name + ", has been born!");

                        //generate stats
                        int maxHealth = rn.nextInt(startingPoints - 2) + 1;
                        int maxFood = rn.nextInt(startingPoints - maxHealth - 1) + 1;
                        int maxEnergy = startingPoints - maxHealth - maxFood;
                        System.out.println("Your pets max stats are:\nMax Health: " + maxHealth + "\nMax Food: " + maxFood + "\nMax Energy: " + maxEnergy);
                        petReal = true;
                        break;
                    //go to instructions
                    case "2":
                    case "instructions":
                        //instructions screen
                        System.out.println("Why you not no rules?");
                        break;
                    //exit game
                    case "3":
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("YoU hiGHly INtellighntn kidD, tryA ga");
                        break;
                }
            }
            
            //if pet is already generated
            else if (petReal == true){
                System.out.println("Main Menu:\nPlay: 1\nInstructions: 2\nExit: 3");
                String menuChoice = kb.nextLine();
                menuChoice = menuChoice.toLowerCase();
                switch (menuChoice) {
                    //start the game
                    case "1":
                    case "start":
                        startGame = true;
                        break;
                    //go to instructions
                    case "2":
                    case "instructions":
                        //instructions screen
                        System.out.println("Why you not no rules?");
                        break;
                    //exit game
                    case "3":
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("YoU hiGHly INtellighntn kidD, tryA ga");
                        break;
                }
            }
        }
        
        //minigames
        while (startGame == true){
            System.out.println("Select a minigame to play:\nNumber Guessing Game: 1\nMatching Game: 2\nSuper Secret Not Illegal Casino: 3");
            int minigameChoice = kb.nextInt();
            switch (minigameChoice){
                case 1:
                    randomNumber = rn.nextInt(100)+1;
                    for (int i=0; i<=guesses; i++){
                        if (i == guesses){
                            System.out.println("You have 0 guesses remaining. You Lose!\nThe number was "+randomNumber);
                            System.out.println("Score: 0");
                        }
                        else if (i < guesses){
                            System.out.print("Guess a number between 1 and 100. You have " + (guesses - i) + " guesses remaining: ");
                            guess = kb.nextInt();
                            if (guess == randomNumber) {
                                System.out.println("You guessed correctly! The number was "+randomNumber+". You Win!");
                                System.out.println("Score: "+ (100*(guesses-i)));
                                break;
                            }
                            else {
                                if (guess > randomNumber) {
                                    System.out.println("The number is lower than " + guess);
                                }
                                else if (guess < randomNumber) {
                                    System.out.println("The number is higher than " + guess);
                                }

                            }
                        }                        
                    }
                case 2:
                    //
                default:
                    break;
            }
            
        }
        
        
       
        
    
        // TODO code application logic here
    }
    
}
