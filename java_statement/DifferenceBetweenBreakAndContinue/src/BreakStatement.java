public class BreakStatement {
  public int countLetterP(String string) {
    int count = 0;
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == 'p') {
        count++;
      }
    }
    return count;
  }

}
