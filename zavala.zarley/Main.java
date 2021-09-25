import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import animal.carnivore.*;
import animal.herbivore.*;
import animal.*;

public class Main {
	public static void main(String[] args) {
		int numOfLions;
		int numOfGiraffes;
		String ani;
	    
		System.out.println("How many Giraffes?");
	    
		Scanner input = new Scanner(System.in);
		numOfGiraffes = input.nextInt();
		
		System.out.println("How many Lions?");
		numOfLions = input.nextInt();
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();

		try(BufferedReader bookworm = new BufferedReader(new FileReader("C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\names.txt"))) {
			for(int i = 0; i < numOfGiraffes; i++) {
				ani = bookworm.readLine();
				animalList.add(new Giraffe(ani));
			}			
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}			
		
		try(BufferedReader bookworm = new BufferedReader(new FileReader("C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\names.txt"))) {
			for(int i = 0; i < numOfLions; i++) {
				ani = bookworm.readLine();
				animalList.add(new Lion(ani));
			}			
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
		animalList.trimToSize();

		try(FileWriter journalist = new FileWriter("C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\output.txt")) {
			for(Animal thisAnimal : animalList) {
    				journalist.write(thisAnimal.getName() + " is a " + thisAnimal.getType() + "\n");
			}
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}
}