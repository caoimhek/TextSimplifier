package ie.gmit.dip;

import java.io.IOException;
import java.util.List;

/**
 * Runner of the application.
 * The runner decides which implementation will be used and 
 * does the dependency injection.
 *
 * @author caoimhekilbride
 */

public class Runner {
	
	IMapper mapper = new Mapper();
	IParser parser = new Parser();
	ISwapper swapper = new Swapper(parser, mapper);
	
	IConsoleInput consoleInput =new ConsoleInput();
	IConsoleOutput consoleoutput = new ConsoleOutput();
	IGui gui = new Gui (consoleInput, consoleoutput);
	
	/**
	 * 
	 * Loads the MobyThesaurus.txt and google-1000.txt into memory
	 * via the TextFile class and initializes the Swapper with these files.
	 * 
	 * @throws IOException		When the MobyThesaurus.txt or google-1000.txt files cannot be accessed.
	 */
	
	public Runner() throws IOException {
		
		
		String synonymsPath = "./MobyThesaurus.txt";
		String commonsPath = "./google-1000.txt";
		
		ITextFile synonyms = new TextFile(synonymsPath);
		ITextFile commons = new TextFile(commonsPath);
		
		swapper.initialize(synonyms, commons);
	}
	
	/**
	 * Creates an instance of runner and runs it.
	 * @param args		The command line arguments
	 */
	
	public static void main(String[] args) {
		
		Runner runner;
		
		try {
			runner = new Runner();
			runner.run();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Uses the Gui class to query the user for input, 
	 * simplifies that input with the Swapper class 
	 * and prints the result back to the user via the Gui class.
	 * 
	 * The above steps are repeated infinitely.
	 * 
	 */
	
	public void run() {
		
		gui.setOutputColor(EConsoleColour.BLUE_BRIGHT);
		gui.writeOutput("***************************************************\n");
		gui.writeOutput("* GMIT - Dept. Computer Science & Applied Physics *\n");
		gui.writeOutput("*                                                 *\n");
		gui.writeOutput("*             Text Simplifier V0.1                *\n");
		gui.writeOutput("*       (AKA Orwellian Language Compliance)       *\n");
		gui.writeOutput("*                                                 *\n");
		gui.writeOutput("***************************************************\n");
		
		gui.setOutputColor(EConsoleColour.RESET);

		System.out.print("Enter Text>");
		System.out.print(EConsoleColour.BLACK_BOLD_BRIGHT);
		
		gui.setOutputColor(EConsoleColour.RESET);
		
		while (true) {
			
			String guiInput = gui.readInput();
			
			String output = swapper.replace(guiInput);
			
			printDifferences(guiInput, output);
		}
	}
	
	
	/**
	 * Prints the output string by changing the style color 
	 * if the output word is different to the input word.
	 * @param input		The input string.
	 * @param output		The output string.
	 */
	private void printDifferences(String input, String output) {
		List<String> inputTokens = parser.tokenize(input, " ");
		List<String> outputTokens = parser.tokenize(output, " ");
		
		for(int i = 0; i < inputTokens.size(); i++) {
			String inputToken = inputTokens.get(i);
			String outputToken = outputTokens.get(i);
			if (inputToken.equals(outputToken)) {
				gui.setOutputColor(EConsoleColour.BLACK);
				gui.writeOutput(outputToken+ " ");
			}
			else {
				gui.setOutputColor(EConsoleColour.RED);
				gui.writeOutput(outputToken+ " ");
			}
		}
		
		gui.endLine();
		gui.setOutputColor(EConsoleColour.RESET);
	}
}
