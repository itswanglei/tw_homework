public class Main {

  public static void main(String[] args) {
    double money = 100;
    BuyFowl buyFowl = new BuyFowl();
    buyFowl.priorityToBuyCock(money);
    buyFowl.priorityToBuyHen(money);
    buyFowl.priorityToBuyChick(money);
  }

}
