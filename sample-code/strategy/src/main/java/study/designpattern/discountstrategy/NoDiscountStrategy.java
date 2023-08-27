package study.designpattern.discountstrategy;

import study.designpattern.Item;

public class NoDiscountStrategy implements DiscountStrategy {

  @Override
  public int getDiscountPrice(Item item) {
    return item.price();
  }
}
