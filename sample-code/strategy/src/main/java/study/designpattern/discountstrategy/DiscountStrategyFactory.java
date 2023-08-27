package study.designpattern.discountstrategy;

public final class DiscountStrategyFactory {

  private DiscountStrategyFactory() {
  }

  public static DiscountStrategy getStrategy(int hour) {
    if (hour < 10) {
      return new FirstGuestDiscountStrategy();
    } else if (hour >= 20) {
      return new NonFreshItemDiscountStrategy();
    } else {
      return new NoDiscountStrategy();
    }
  }
}
