public class ArgumentContainer {
  String[] args;

  public ArgumentContainer(String[] args) {
    this.args = args;
  }

  public boolean isVoid() {
    return (args.length == 0) ? true :  false;
  }

  public String[] getArgs() {
    return args;
  }
}
