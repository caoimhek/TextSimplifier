package ie.gmit.dip;


/**
 * 
 *Writes back to a user via the standard console.
 *
 * @author caoimhekilbride
 *
 */

public class ConsoleOutput implements IConsoleOutput {
	
	/**
	 * Prints the str to the System out stream.
	 * @param str		The string to be printed
	 */
	public void output(String str) {
		System.out.print(str);
	}
	
	/**
	 * Creates a new line to the System out stream.
	 */
	public void endline() {
		System.out.println();
	}

	/**
	 * Sets the styling of the console.
	 * @param color		The styling color parameter.
	 */
	@Override
	public void setColor(EConsoleColour color) {
		System.out.print(color);
	}	
}
