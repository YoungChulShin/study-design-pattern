package study.designpattern.discountstrategy;

import study.designpattern.Item;

public interface DiscountStrategy {

  int getDiscountPrice(Item item);

}
