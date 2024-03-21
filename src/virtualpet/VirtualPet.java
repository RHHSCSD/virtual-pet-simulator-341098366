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
        
        // varialbes
        boolean choosePet = false;
        boolean instructions = false;
        
        Scanner kb = new Scanner(System.in);
        System.out.println(" ,_     _\n" +" |\\\\_,-~/\n" +" / _  _ |    ,--.\n" +"(  @  @ )   / ,-'\n" +" \\  _T_/-._( (\n" +" /         `. \\\n" +"|         _  \\ |\n" +" \\ \\ ,  /      |\n" +"  || |-_\\__   /\n" +" ((_/`(____,-'");
        System.out.println("Ultra Silent Pet Simulator Infinity Rebirth V2 Redux");
        System.out.println("Start: 1\nInstruction: 2\nExit: 3");
        int menu = kb.nextInt();
        switch (menu){
            case 1:
                choosePet = true;
                break;
            case 2:
                instructions = true;
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
        
        if (choosePet ==true){
            System.out.println("Choose a Pet: \nAmong Us Imposter: 1\nFBI Agent: 2");
            int petPick = kb.nextInt();
            System.out.println("You have picked "+petPick);
        }
        else if (instructions == true){
            System.out.println("Why you not no rules?");
        }
    
        // TODO code application logic here
    }
    
}
