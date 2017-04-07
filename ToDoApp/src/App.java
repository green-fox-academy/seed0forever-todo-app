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
    ArgumentContainer argsInput = new ArgumentContainer(args);

    if (argsInput.isVoid()) {
      printUsage();
    } else if (argsInput.hasDashArg("l")) {
      loadToDoList();
      runtimeToDoList.printLines();
    } else if (argsInput.hasDashArg("a")) {
      String newToDoItem = argsInput.getStringOfDashArg("a");
      loadToDoList();
      runtimeToDoList.add(newToDoItem);
      runtimeToDoList.printLines();
    } else {
      System.out.println(Arrays.asList(argsInput.getArgs()));
    }
  }

  private static void loadToDoList() {
    List<String> loadedToDoFile = readFile(TODO_STORAGE_FILE);
    runtimeToDoList = new ToDoList(loadedToDoFile);
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

}
