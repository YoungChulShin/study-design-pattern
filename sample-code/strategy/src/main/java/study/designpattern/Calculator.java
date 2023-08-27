package study.designpattern;

import java.util.List;
import study.designpattern.discountstrategy.DiscountStrategy;

public class Calculator {

  private final DiscountStrategy discountStrategy;

  public Calculator(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public int calcuate(List<Item> items) {
    return items.stream()
        .mapToInt(discountStrategy::getDiscountPrice)
        .sum();
  }
}
