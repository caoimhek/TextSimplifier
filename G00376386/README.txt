Running the Application


To run the Text Simplifier API, it can be launched using the following syntax : Java -Xmx1G –cp ./simplifier.jar ie.gmit.dip.Runner. The user will be prompted to enter text that will be simplified. Any words that have been swapped for the simple version will be the colour red. This will be repeated forever until the user presses ctrl + c to stop the process. 


Testability
Each class has a test class with unit tests. As there are no couplings between the classes it’s possible for each class to have its own set of unit tests. This is a side effect of following the dependency inversion principle. Some dependencies are mocked for instance, ITextFile has a mocking implementation TextFileMock. 


Features


The text simplifier consists of the following: 
classes 
Runner, Mapper, Parser, Swapper, ConsoleInput, ConsoleOuput, Gui, TextFile, TextFileMock.
Interfaces
IMapper, IParser,IConsoleInput, IConsoleOutput, IGui, ITextFile, ISwapper.
Enum
EConsoleColour.


Mapper
The Mapper implements IMapper. The Mapper uses a hashmap to map synonyms to common words. Each of the synonyms has their own entry and the common word maps to itself. The Mapper is case insensitive. The function “add” associates a list of synonyms with the common word. The function “getCommon”  returns the common word that is synonym to the input. If a synonym does not exist, it returns null.


Parser
The Parser class implements IParser. The parser breaks each String input into tokens by using a delimiter. The splitting is done using split from the String class. 
         
         
Swapper
Swapper implements ISwapper. The Swapper uses an IParser and IMapper to swap input strings and produce outputs. It uses an initialization step where it reads common words and synonyms from ITextFile instances. The function “initialize”  initializes the Swapper by using a text file for synonyms and another for common words. The implementation uses an IMapper to map common words with synonyms and a parser to break text file lines into words.
ConsoleInput 
ConsoleInput implements IConsoleInput. Reads user input from the System In stream. The function “setColor” sets the console colour for the user input.
ConsoleOutput
ConsoleOutput implements IConsoleOutput. ConsoleOutput writes back to a user via the standard console. A str is printed to the System Out stream. The styling of the console colour is also set. 
TextFile
Public class TextFile implements ITextFile.  TextFile is a representation of a  text file where the contents of the file come from an existing file in the file system.  The path of that file is provided in the constructor. TextFile employs the use of a hashmap and Initializes the TextFile with the contents of a file in the file system. 
TextFileMock
TextFileMock implements ITextFile. TextFileMock is a virtual text file where the contents are injected as a list of lines. A mock implementation for unit testing classes that depend on ITextFile. TextFileMock employs the use of a List of Strings where the contents of the virtual text file are initialised. 
Gui
Gui implements IGui. The Gui is a user interface that uses IConsoleInput and IConsoleOutput to communicate with the user. 
Runner
The Runner class is the runner of the application where the main method is found. The runner decides which implementation will be used and does the dependency injection. The Runner uses the Gui class to query the user for input, simplifies that input with the Swapper class and prints the result back to the user via the Gui class. The Runner assumes that the files i.e. synonyms and Mobythesaurus are always using the same file path.