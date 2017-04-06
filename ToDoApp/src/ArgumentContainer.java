public class ArgumentContainer {

  String[] args;

  public ArgumentContainer(String[] args) {
    this.args = args;
  }

  public boolean isVoid() {
    return args.length == 0;
  }

  public String[] getArgs() {
    return args;
  }

  public boolean hasDashArg(String dashArg) {
    if (args.length > 0) {
      for (String arg : args) {
        if (arg.startsWith("-") && arg.contains(dashArg)) {
          return true;
        }
      }
    }
    return false;
  }
}
