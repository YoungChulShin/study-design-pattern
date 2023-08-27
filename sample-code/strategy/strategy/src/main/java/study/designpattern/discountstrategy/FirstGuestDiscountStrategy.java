package study.designpattern.discountstrategy;

import study.designpattern.Item;

public class FirstGuestDiscountStrategy implements DiscountStrategy {

  @Override
  public int getDiscountPrice(Item item) {
    return (int)(item.price() * 0.8);
  }
}
