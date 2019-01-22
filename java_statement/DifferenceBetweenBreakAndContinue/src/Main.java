public class Main {

  public static void main(String[] args) {
    String string = "peter piper picked a peck of pickled peppers";

    BreakStatement breakStatement = new BreakStatement();
    ContinueStatement continueStatement = new ContinueStatement();

    System.out.println("The number of letter p is: " + breakStatement.countLetterP(string));
    System.out.println("The number of letter p is: " + continueStatement.countLetterP(string));
  }
}
