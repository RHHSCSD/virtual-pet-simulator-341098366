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
        boolean choosePet = false;
        boolean instructions = false;
        boolean naming = false;
        
        char consonant;
        
        String pet = "";
        String username = "";
        String password = "";
        String name = "";
        String vowel = "";
        
        final int startingPoints = 20;
        final String correctUsername = "snoopy";
        final String correctPassword = "toto";
        
        Scanner kb = new Scanner(System.in);
        Random rn = new Random();
        
        //Welcome screen
        System.out.println(" ,_     _\n" +" |\\\\_,-~/\n" +" / _  _ |    ,--.\n" +"(  @  @ )   / ,-'\n" +" \\  _T_/-._( (\n" +" /         `. \\\n" +"|         _  \\ |\n" +" \\ \\ ,  /      |\n" +"  || |-_\\__   /\n" +" ((_/`(____,-'");
        System.out.println("Ultra Silent Pet Simulator Infinity Rebirth V2 Redux");
        //login screen
//        System.out.print("Please enter your username: ");
//        username = kb.nextLine();
//        System.out.print("Please enter your password: ");
//        password = kb.nextLine();
//        //Successful login
//        if (username.equals(correctUsername) && password.equals(correctPassword)){
//            System.out.println("Successful Login");
//        }
//        //bad login and end program
//        else {
//            System.out.println("Wrong username or password");
//            System.exit(0);
//        }

        //Main menu screen
        System.out.println("Main Menu:\nStart: 1\nInstructions: 2\nExit: 3");
        String menu = kb.nextLine();
        menu = menu.toLowerCase();
        switch (menu){
            //go to pet selection
            case "1":
            case "start":
                choosePet = true;
                break;
            //go to instructions
            case "2":
            case "instructions":
                instructions = true;
                break;
            //exit game
            case "3":
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Why you dumb?");
                System.exit(0);
                break;
        }
        
        //instructions screen
        if (instructions == true){
            System.out.println("Why you not no rules?");
            //exit instructions menu and continue to game
            instructions = false;
            choosePet = true;
        }
        
        //pet selection menu
        if (choosePet == true){
            System.out.println("Choose a Pet: \nImposter: 1\nFBI Agent: 2");
            int petPick = kb.nextInt();
            //assign pet based on input
            switch (petPick){
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
            System.out.println("You have picked "+pet);
            choosePet = false;
            naming = true;
        }
        
        //naming menu
        if (naming == true){
            System.out.println("How do you want to name your pet?\nManual: 1\nRandom Name: 2");
            int namingChoice = kb.nextInt();
            
            //flush
            kb.nextLine();
            //manually name pet
            if (namingChoice == 1){
                System.out.print("Enter pet name: ");
                name = kb.nextLine();
            }
            //generate random name
            else if (namingChoice == 2){
                //generate random vowel
                int randomVowel = rn.nextInt(5);
                switch (randomVowel){
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
                if (doubleVowel == true){
                    vowel = vowel+vowel;
                }
                //generate random consonant
                int randomConsonant = rn.nextInt(26)+97;
                //change number if it corresponds to a vowel in ASCII
                switch (randomConsonant){
                    case 97:
                    case 101:
                    case 105:
                    case 111:
                    case 117:
                        randomConsonant++;
                        break;
                }
                //cast number into a character
                consonant = (char)randomConsonant;
                //generate name
                name = consonant + vowel + consonant + vowel;
                System.out.println("Your pet, named "+name+", has been born!");
                
            }
        }
        
    
        // TODO code application logic here
    }
    
}
