import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

  private static final String USAGE_HELP_MSG = "usage.txt";
  private static final String TODO_STORAGE_FILE = "todo.txt";

  private static ToDoList runtimeToDoList;

  public static void main(String[] args) {
    ArgumentContainer arguments = new ArgumentContainer(args);

    if (arguments.isVoid()) {
      printUsage();
    } else if (arguments.hasDashArg("l")) {
      loadToDoList();
      runtimeToDoList.printLines();
    } else if (arguments.hasDashArg("a")) {
      String newToDoItem = arguments.getStringOfDashArg("a");
      loadToDoList();
      runtimeToDoList.add(newToDoItem);
      runtimeToDoList.printLines();
      saveToDoList();
    } else if (arguments.hasDashArg("r")) {
      int itemIndexToRemove = arguments.getIntOfDashArg("r");
      System.out.println("User wants to remove item number " + (itemIndexToRemove + 1));
    } else {
      System.out.println(Arrays.asList(arguments.getArgs()));
    }
  }

  private static void loadToDoList() {
    List<String> loadedToDoFile = readFile(TODO_STORAGE_FILE);
    runtimeToDoList = new ToDoList(loadedToDoFile);
  }

  private static void saveToDoList() {
    writeFile(TODO_STORAGE_FILE, runtimeToDoList.toListOfStrings());
  }

  private static void printUsage() {
    List<String> loadedFileLines = readFile(USAGE_HELP_MSG);
    printListLines(loadedFileLines);
  }

  private static void printListLines(List<String> readFileLines) {
    for (String line : readFileLines) {
      System.out.println(line);
    }
  }

  private static List<String> readFile(String filePath) {
    try {
      Path file = Paths.get(filePath);
      List<String> lines = Files.readAllLines(file);
      return lines;
    } catch (IOException e) {
      System.out.println("Could not read '" + filePath + "' file.");
      List<String> empty = new ArrayList<>();
      return empty;
    }
  }

  private static void writeFile(String filePath, List<String> lines) {
    try {
      Path file = Paths.get(filePath);
      Files.write(file, lines);
    } catch (IOException e) {
      System.out.println("Could not write '" + filePath + "' file.");
    }
  }

}
