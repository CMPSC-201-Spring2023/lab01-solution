import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/** This class has a method that performs text data analysis.
 *
 * <p>Bugs: This program has no known bugs, but is missing source code
 *
 * @author Janyl Jumadinova
 */

public class AnalyzeText {

  // the first number of lines that display book preamble information, such as
  // the author, the title, etc.
  static final int preambleLines = 5;
  // the name and path to the input file (book)
  static final String fileName = "../input/Ulysses.txt";

  /** The main entry point for AnalyzeText.
   *  The method counts the number of words in a book.
   *  It also allows the user to search for specific keywords.
   *
   * @param args The command-line arguments
   **/
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Janyl Jumadinova " + new Date());
    // declare the starting file and scanner
    File inputFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      inputFile = new File(fileName);
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Display information about the book (title, author, etc.)
    // 1.1. Open the input file and check where this information is located
    // 1.2. Modify the value assigned to the preamble_lines variable
    // 1.3. Use a while loop to start at index=0 and end at preamble_lines value
    // 1.4. Inside the body of the loop, use Scanner's nextLine() method to print
    // information about the book (author, title, etc.)
    int index = 0;
    while (index < preambleLines) {
      System.out.println(scanner.nextLine());
      index++;
    }

    // Step Two: count the words in a file
    int count = 0;
    while (scanner.hasNext()) {
      scanner.next();
      count++;
    }
    System.out.println("There are " + count + " number of words in this book");

    // Step three: get user's search keywords
    // Note: you need to create a new Scanner object to read from the terminal
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter two single keywords ");
    String keyword1 = userInput.next();
    String keyword2 = userInput.next();

    count = 0;
    // reinitialize scanner to read from the beginning of the file
    // reconnect the scanner to the input file
    try {
      inputFile = new File(fileName);
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.contains(keyword1) || line.contains(keyword2)) {
        System.out.println("Occurrence # " + count + ": " + line);
        count++;
      }
    }
    System.out.println("Keywords \"" + keyword1 + "\" and \"" + keyword2
                       + "\" appeared " + count + " number of times.");

    // Step Six: Display a final thank you message
    System.out.println("\nThank you for using the AnalyzeText program. \n Have a wonderful day.");

  }

}
