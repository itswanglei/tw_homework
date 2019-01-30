public class Main {

  public static void main(String[] args) {
    double money = 100;
    int total = 100;

    Fowl cock = new Cock();
    Fowl hen = new Hen();
    Fowl chick = new Chick();

    final int maxCock = cock.setMaxQuantity(money);
    final int mxHen = hen.setMaxQuantity(money);

    for (int cockQuantity = 1; cockQuantity < maxCock; cockQuantity++) {
      for (int henQuantity = 1; henQuantity < mxHen; henQuantity++) {
        int chickQuantity = total - cockQuantity - henQuantity;
        if (chickQuantity % 3 == 0 && cockQuantity * cock.getPrice() + henQuantity * hen.getPrice() + chickQuantity / 3 == money) {
          System.out.println("买公鸡" + cockQuantity + "只，买母鸡" + henQuantity + "只，买小鸡" + chickQuantity + "只");
        }
      }
    }
  }

}
