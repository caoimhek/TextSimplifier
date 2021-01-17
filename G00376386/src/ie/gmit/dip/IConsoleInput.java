package ie.gmit.dip;

import java.util.Scanner;

/**
 * Interface for reading input from a console.
 *
 * @author caoimhekilbride
 */

public interface IConsoleInput {
	public String userInput();
	public void setColor(EConsoleColour color);
}
