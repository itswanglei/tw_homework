public class Main {

  public static void main(String[] args) {
    Printer printer = new Printer();
    ColorPrinter colorPrinter = new ColorPrinter();
    MonoChrome monoChrome = new MonoChrome();
    printer.feature();
    colorPrinter.feature();
    monoChrome.feature();
  }
}
