import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {

  public static void main(String[] args) {
    ArgumentContainer argsInput = new ArgumentContainer(args);
    if (argsInput.isVoid()) {
      printUsage();
    } else {
      System.out.println(Arrays.asList(argsInput.getArgs()));
    }
  }

  private static void printUsage() {
    try {
      Path usagePath = Paths.get("usage.txt");
      List<String> usageLines = Files.readAllLines(usagePath);
      for (String line : usageLines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Could not read usage.txt file.");
      e.printStackTrace();
    }
  }

}
