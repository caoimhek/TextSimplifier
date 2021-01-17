package ie.gmit.dip;

/**
 * Interface for writing to a console.
 * @author caoimhekilbride
 *
 */

public interface IConsoleOutput {

	public void output(String str);
	public void endline();
	public void setColor(EConsoleColour color);
}
