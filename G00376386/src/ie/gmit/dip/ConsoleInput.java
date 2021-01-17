package ie.gmit.dip;

import java.util.Scanner;
import java.io.*;

/**
 * 
 *Reads user input from the System in stream.
 *
 * @author caoimhekilbride
 *
 */

public class ConsoleInput implements IConsoleInput {
	Scanner input = new Scanner(System.in);
	/**
	 * Reads input from the user using the Scanner class.
	 * 
	 * @return		The user input as a String.
	 */
	public String userInput() {
		String str = input.nextLine();
		return str;
	}
	
	/**
	 * Sets the console color for the user input.
	 * 
	 * @param color		The styling color for the console.
	 */
	@Override
	public void setColor(EConsoleColour color) {
		System.out.print(color);
	}

}
