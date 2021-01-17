package ie.gmit.dip;

/**
 * 
 *User interface that uses console input and output
 *to communicate with the user.
 *
 * @author caoimhekilbride
 *
 */

public class Gui implements IGui {

	private IConsoleInput consoleInput;
	private IConsoleOutput consoleoutput;

	
	/**
	 * 
	 * @param input 		console input that reads the user input.
	 * @param output		console output that writes back to the user.
	 */
	public Gui (IConsoleInput input, IConsoleOutput output) {
		consoleInput = input;
		consoleoutput = output;
	}
   
	
	/**
	 * Returns the user input from the console.
	 * 
	 * @return		The user input as a String.
	 */
	public String readInput() {
		return consoleInput.userInput();
	}

	
	/**
	 * Writes a string to the output console.
	 * 
	 * @param str		The string to be written to the output console.
	 */
	public void writeOutput(String str) {
		consoleoutput.output(str);		
	}
	
	
	/**
	 * Writes a new line to the output console.
	 */
	public void endLine() {
		consoleoutput.endline();
	}

	
	/**
	 * Sets a styling color on the input console.
	 * 
	 * @param color		The styling color.
	 */
	public void setInputColor(EConsoleColour color) {
		consoleInput.setColor(color);
	}
	
	
	/**
	 * Sets a styling color on the output console.
	 * 
	 * @param color		The styling color.
	 */
	public void setOutputColor(EConsoleColour color) {
		consoleoutput.setColor(color);
	}
}

	
