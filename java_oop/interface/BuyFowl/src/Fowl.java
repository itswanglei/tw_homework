public abstract class Fowl implements Buy{
  private final double price;
  private int quatity;

  public Fowl(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public int getQuatity() {
    return quatity;
  }

  public void setQuatity(int quatity) {
    this.quatity = quatity;
  }

  @Override
  public int calculateQuatity(double money) {
    this.quatity = (int) Math.floor(money / this.price);
    return this.quatity;
  }

  @Override
  public double calculateBalance(double money) {
    return money - this.quatity * this.price;
  }
}
