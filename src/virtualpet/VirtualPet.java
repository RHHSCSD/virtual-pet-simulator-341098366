/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
import java.io.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    
    public static String choosePet(){
        //pet selection menu
        Scanner kb = new Scanner(System.in);
        String pet;
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
        return pet;
    }
    
    public static String randomName(){
        Random rn = new Random();
        String vowel = null;
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
        char consonant = (char) randomConsonant;
        //generate name
        String name = consonant + vowel + consonant + vowel;
        return name;
    }
    
    public static int numberGuessingGame(int numberGuesses, int money){
        Random rn = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("You've selected the number guessing game");
        int randomNumber = rn.nextInt(100) + 1;
        for (int i = 0; i <= numberGuesses; i++) {
            //no guesses remaining
            if (i == numberGuesses) {
                System.out.println("You have 0 guesses remaining. You Lose!\nThe number was " + randomNumber);
                System.out.println("Score: 0");
                money = money - 5;
                return money;
            } else if (i < numberGuesses) {
                System.out.print("Guess a number between 1 and 100. You have " + (numberGuesses - i) + " guesses remaining: ");
                int numberGuess = kb.nextInt();
                //if guess is correct
                if (numberGuess == randomNumber) {
                    System.out.println("You guessed correctly! The number was " + randomNumber + ". You Win!");
                    System.out.println("Score: " + (100 * (numberGuesses - i)));
                    money = money + numberGuesses - i;
                    return money;
                } //if guess is incorrect, tell user whether the number is higher or lower
                else {
                    if (numberGuess > randomNumber) {
                        System.out.println("The number is lower than " + numberGuess);
                    } else if (numberGuess < randomNumber) {
                        System.out.println("The number is higher than " + numberGuess);
                    }
                }
            }
        }
        return 0;
    }
    
    public static int matchingGame(int money){
        Random rn = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("You've selected the matching game");
        //reseting variables
        String matching = "aabbccddee";
        String matchingMixed = "";
        int matchingLength = matching.length();
        int matchingGuesses = 15;
        String matchingDisplay = "";
        for (int i = 0; i < matchingLength; i++) {
            matchingDisplay = matchingDisplay + "X";
        }
        //shuffling the string
        while (matchingMixed.length() != matchingLength) {
            int matchingIndex = rn.nextInt(matching.length());
            matchingMixed = matchingMixed + matching.charAt(matchingIndex);
            matching = matching.substring(0, matchingIndex) + matching.substring(matchingIndex + 1);
        }
        //game runs as long as all characters aren't revealed
        while (!matchingDisplay.equals(matchingMixed)) {
            //when you run out of guesses
            if (matchingGuesses == 0) {
                System.out.println("You have 0 guesses remaining. You Lose!\nScore: 0");
                money = money - 5;
                return money;
            }
            System.out.println(matchingDisplay);
            System.out.println("Guess (" + matchingGuesses + " guesses remaining): ");
            int matchingGuess1 = kb.nextInt();
            int matchingGuess2 = kb.nextInt();
            //if they input a number out of range
            if (matchingGuess1 < 0 || matchingGuess1 >= matchingLength || matchingGuess2 < 0 || matchingGuess2 >= matchingLength) {
                System.out.println("Invalid guesses. Try again");
            } //if they input a number that corresponds to an already correct guess
            else if (matchingDisplay.charAt(matchingGuess1) != 'X' || matchingDisplay.charAt(matchingGuess2) != 'X') {
                System.out.println("You guessed an already correct guess. Try again");
            } //if they input 2 of the same number
            else if (matchingGuess1 == matchingGuess2) {
                System.out.println("You guessed the same number. Why you dumb? Try again");
            } else {
                //if the guesses match
                if (matchingMixed.charAt(matchingGuess1) == matchingMixed.charAt(matchingGuess2)) {
                    //modify display to show correct guesses
                    matchingDisplay = matchingDisplay.substring(0, matchingGuess1) + matchingMixed.charAt(matchingGuess1) + matchingDisplay.substring(matchingGuess1 + 1);
                    matchingDisplay = matchingDisplay.substring(0, matchingGuess2) + matchingMixed.charAt(matchingGuess2) + matchingDisplay.substring(matchingGuess2 + 1);
                    System.out.println("You found a pair!");
                    matchingGuesses--;
                    //if all pairs are found
                    if (matchingDisplay.equals(matchingMixed)) {
                        System.out.println("You found all pairs! You Win!");
                        System.out.println("Score: " + 100 * (matchingGuesses + 1));
                        money = matchingGuesses +1;
                        return money;
                    }
                } //if the guesses don't match
                else {
                    System.out.println("No match. The characters were " + matchingMixed.charAt(matchingGuess1) + " and " + matchingMixed.charAt(matchingGuess2));
                    matchingGuesses--;
                }
            }
        }
        return 0;
    }
    
    public static int buyToy(int currentEnergy, int maxEnergy){
        if (currentEnergy<maxEnergy){
            currentEnergy++;
        }
        System.out.println("You bought your pet a nice toy\nCurrent energy increased to "+currentEnergy);
        return currentEnergy;
    }
    
    public static int buyFood(int currentFood, int maxFood){
        if (currentFood<maxFood){
            currentFood++;
        }
        System.out.println("You bought your pet a steak\nCurrent Food increased to "+currentFood);
        return currentFood;
    }
    
    public static int buySpa(int currentHealth, int maxHealth) {
        if (currentHealth<maxHealth){
            currentHealth++;
        }
        System.out.println("You bought your pet a nice toy\nCurrent Health increased to " + currentHealth);
        return currentHealth;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        
        // variables
        
        boolean petReal = false;
        boolean startGame = false;
        boolean newPlayer = false;
        
        char consonant;
        
        int attempts = 3;   
        int randomNumber = 0;
        int numberGuess = 0;
        int money = 0;
        int matchingIndex = 0;
        int matchingGuess1 = 0;
        int matchingGuess2 = 0;
        int matchingGuesses = 15;
        int maxHealth=0;
        int maxFood=0;
        int maxEnergy=0;
        int currentHealth = 1;
        int currentFood = 1;
        int currentEnergy = 1;
        
        int[] maxStats = new int[3];
        int[] currentStats = new int[3];
        Arrays.fill(currentStats, 1);
        int[] actions = new int[3];
        
        String pet = "";
        String username = "";
        String password = "";
        String name = "";
        String vowel = "";
        String matching = "aabbccddee";
        String matchingMixed = "";
        String matchingDisplay = "";
        
        final int startingPoints = 20;
        final int numberGuesses = 15;
        final String correctUsername = "snoopy";
        final String correctPassword = "toto";
        
        Scanner kb = new Scanner(System.in);
        Scanner f;
        Random rn = new Random();
        
        //Welcome screen
        System.out.println("""
                            ,_     _
                            |\\\\_,-~/
                            / _  _ |    ,--.
                           (  @  @ )   / ,-'
                            \\  _T_/-._( (
                            /         `. \\
                           |         _  \\ |
                            \\ \\ ,  /      |
                             || |-_\\__   /
                            ((_/`(____,-'""");
        System.out.println("Ultra Silent Pet Simulator Infinity Rebirth V2 Redux");
        //login screen
        
        System.out.print("Please enter your username: ");
        username = kb.nextLine();
        System.out.print("Please enter your password: ");
        password = kb.nextLine();
        File info = new File(username+".txt");
        if (info.exists()){
            f = new Scanner(info);
            if (password.equals(f.nextLine())){
                System.out.println("Welcome back "+username);
                startGame = true;
                name = f.nextLine();
                pet = f.nextLine();
                maxEnergy = f.nextInt();
                maxFood = f.nextInt();
                maxHealth = f.nextInt();
                maxStats[0]=maxEnergy;
                maxStats[1]=maxFood;
                maxStats[2]=maxHealth;
                currentEnergy = f.nextInt();
                currentFood = f.nextInt();
                currentHealth = f.nextInt();
                currentStats[0] = currentEnergy;
                currentStats[1] = currentFood;
                currentStats[2] = currentHealth;
                money = f.nextInt();
                f.close();
                
            }
            else {
                System.out.println("Stop hacking");
                System.exit(0);
            }
        }
        else if (!info.exists()){
            newPlayer = true;
            System.out.println("Welcome new Player");
        }
        
        //old login system
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
        while (startGame == false && newPlayer == true){
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
                        pet = choosePet();
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
                            name = randomName();
                        }
                        //output name
                        System.out.println("Your pet, named " + name + ", has been born!");

                        //generate stats
                        maxHealth = rn.nextInt(startingPoints - 2) + 1;
                        maxFood = rn.nextInt(startingPoints - maxHealth - 1) + 1;
                        maxEnergy = startingPoints - maxHealth - maxFood;
                        maxStats[2] = maxHealth;
                        maxStats[1] = maxFood;
                        maxStats[0] = maxEnergy;
                        
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
                        System.out.println(".__.");
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
                        System.out.println(".__.");
                        break;
                }
            }
        }
        
        //minigames
        while (startGame == true){
            System.out.println("Select a minigame to play:\nNumber Guessing Game: 1\nMatching Game: 2\nShop: 3\nQuite: 4");
            int minigameChoice = kb.nextInt();
            switch (minigameChoice){
                case 1:
                    //random number guessing game
                    money = numberGuessingGame(numberGuesses,money);
                    System.out.println("You have "+money+" money");
                    break;
                case 2:
                    //matching game
                    money = matchingGame(money);
                    System.out.println("You have " + money + " money");
                    break;
                case 3:
                    System.out.println("Select item to purchase (You have "+money+" money):\nToy(3 money): 1\nFood(3 money): 2\nExpensive spa day(10 money): 3");
                    int purchase = kb.nextInt();
                    switch (purchase){
                        case 1:
                            if (money>=3){
                                money = money -3;
                                currentEnergy = buyToy(currentEnergy,maxEnergy);
                                currentStats[0] = currentEnergy;
                                actions[0]++;
                            }
                            else{
                                System.out.println("where money?");
                            }
                            break;
                        case 2:
                            if (money>=3){
                                money = money -3;
                                currentFood = buyFood(currentFood,maxFood);
                                currentStats[1] = currentFood;
                                actions[1]++;
                            }
                            else{
                                System.out.println("where money?");
                            }
                            break;
                        case 3:
                            if (money>=10){
                                money = money -10;
                                currentHealth = buySpa(currentHealth,maxHealth);
                                currentStats[2] = currentHealth;
                                actions[2]++;
                            }
                            else{
                                System.out.println("where money?");
                            }
                            break;
                        default:
                            System.out.println("Leave my shop");
                    }
                    break;
                case 4:
                    PrintWriter pw = new PrintWriter(info);
                    pw.println(password);
                    pw.println(name);
                    pw.println(pet);
//                    pw.println(maxEnergy);
//                    pw.println(maxFood);
//                    pw.println(maxHealth);
//                    pw.println(currentEnergy);
//                    pw.println(currentFood);
//                    pw.println(currentHealth);
                    for (int i=0;i<maxStats.length;i++){
                        pw.println(maxStats[i]);
                    }
                    for (int i=0;i<currentStats.length;i++){
                        pw.println(currentStats[i]);
                    }
                    pw.println(money);
                    pw.close();
                    System.out.println("You played with your pet "+actions[0]+" times today");
                    if(actions[0]>=5){
                        System.out.println("Achievement Unlocked: Happy Pet");
                    }
                    System.out.println("You fed your pet "+actions[1]+"  times today");
                    if(actions[1]>=5){
                        System.out.println("Achievement Unlocked: Fat Pet");
                    }
                    System.out.println("You groomed your pet "+actions[2]+"times today");
                    if(actions[2]>=5){
                        System.out.println("Achievement Unlocked: Good-Looking Pet");
                    }
                    System.exit(0);
                default:
                    System.out.println("THIS IS THE POLICE! GET ON THE GROUND! YOU'RE UNDER ARREST FOR ILLEGAL GAMBLING!");
                    System.out.println("You got sent to jail for the next 20 years\n*Bad Ending*");
                    System.exit(0);
            }
        }
        // TODO code application logic here
    }
    
}
