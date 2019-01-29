public class BuyFowl {
  private void printResult(String type, int[] result) {
    System.out.println("优先买" + type + "的方案：");
    System.out.println("买" + result[0] + "只公鸡");
    System.out.println("买" + result[1] + "只母鸡");
    System.out.println("买" + result[2] + "只小鸡\n");
  }

  public void priorityToBuyCock(double money) {
    double balance = money;

    Fowl cock = new Cock();
    Fowl hen = new Hen();
    Fowl chick = new Chick();

    int quatityOfCock = cock.calculateQuatity(balance);
    balance = cock.calculateBalance(balance);

    int quatityOfHen = hen.calculateQuatity(balance);
    balance = hen.calculateBalance(balance);

    int quatityOfChick = chick.calculateQuatity(balance);

    int[] result = new int[3];
    result[0] = quatityOfCock;
    result[1] = quatityOfHen;
    result[2] = quatityOfChick;
    this.printResult("公鸡",result);
  }

  public void priorityToBuyHen(double money) {
    double balance = money;

    Fowl cock = new Cock();
    Fowl hen = new Hen();
    Fowl chick = new Chick();

    int quatityOfHen = hen.calculateQuatity(balance);
    balance = hen.calculateBalance(balance);

    int quatityOfCock = cock.calculateQuatity(balance);
    balance = cock.calculateBalance(balance);

    int quatityOfChick = chick.calculateQuatity(balance);

    int[] result = new int[3];
    result[0] = quatityOfCock;
    result[1] = quatityOfHen;
    result[2] = quatityOfChick;
    this.printResult("母鸡",result);
  }

  public void priorityToBuyChick(double money) {
    double balance = money;

    Fowl cock = new Cock();
    Fowl hen = new Hen();
    Fowl chick = new Chick();

    int quatityOfChick = chick.calculateQuatity(balance);
    balance = chick.calculateBalance(balance);

    int quatityOfCock = cock.calculateQuatity(balance);
    balance = cock.calculateBalance(balance);

    int quatityOfHen = hen.calculateQuatity(balance);

    int[] result = new int[3];
    result[0] = quatityOfCock;
    result[1] = quatityOfHen;
    result[2] = quatityOfChick;
    this.printResult("小鸡",result);
  }
}
