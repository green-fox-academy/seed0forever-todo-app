import java.util.ArrayList;
import java.util.List;

public class ToDoList {

  private String outMessageEmpty;
  private List<ToDo> toDoListItems;

  public ToDoList() {
    this(new ArrayList<>());
  }

  public ToDoList(List<String> toDoLines) {
    outMessageEmpty = "No todos for today! :)";
    toDoListItems = new ArrayList<>();

    for (String line : toDoLines) {
      ToDo toDoItem = new ToDo(line);
      toDoListItems.add(toDoItem);
    }
  }

  public List<ToDo> getToDoListItems() {
    return toDoListItems;
  }

  public void printLines() {
    if (isEmpty()) {
      System.out.println(outMessageEmpty);
      return;
    }
    for (int i = 0; i < toDoListItems.size(); i++) {
      System.out.println(i + 1 + " - " + toDoListItems.get(i).toString());
    }
  }

  public boolean isEmpty() {
    return toDoListItems.size() == 0;
  }

  public void add(String item) {
    ToDo toDoItem = new ToDo(item);
    toDoListItems.add(toDoItem);
  }
}
