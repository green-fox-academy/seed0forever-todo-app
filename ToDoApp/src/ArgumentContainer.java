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

  public String getStringOfDashArg(String dashArg) {
    String stringOfDashArg = "";
    if (!hasDashArg(dashArg)) {
      return "";
    }
    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("-")
              && args[i].contains(dashArg)
              && args.length > i + 1
              && !args[i + 1].startsWith("-")) {
        return args[i + 1];
      }
    }
    return stringOfDashArg;
  }
}
