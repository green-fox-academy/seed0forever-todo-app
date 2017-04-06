public class ToDo {

  private String itemName;
  private boolean completed;

  public ToDo(String itemName) {
    completed = false;
    this.itemName = itemName;
  }

  @Override
  public String toString() {
    return itemName;
  }
}
