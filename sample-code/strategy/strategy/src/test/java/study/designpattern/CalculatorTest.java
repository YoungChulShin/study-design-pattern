package study.designpattern;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.designpattern.discountstrategy.DiscountStrategyFactory;

class CalculatorTest {

  @Test
  @DisplayName("10시 이전에 손님은 할인을 받는다")
  void calculate_first_guest_discount() {
    // given
    Calculator sut = new Calculator(DiscountStrategyFactory.getStrategy(9));
    Item item1 = new Item("과자", 2000);
    Item item2 = new Item("음료", 1000);

    // when
    int result = sut.calcuate(List.of(item1, item2));

    // then
    Assertions.assertEquals(2400, result);
  }

  @Test
  @DisplayName("20시부터 들어오는 손님은 할인을 받는다")
  void calculate_non_fresh_item_discount() {
    // given
    Calculator sut = new Calculator(DiscountStrategyFactory.getStrategy(20));
    Item item1 = new Item("과자", 2000);
    Item item2 = new Item("음료", 1000);

    // when
    int result = sut.calcuate(List.of(item1, item2));

    // then
    Assertions.assertEquals(1500, result);
  }

  @Test
  @DisplayName("10시부터 20시 이전에 들어오는 손님은 할인이 적용되지 않는다")
  void calculate_non_discount() {
    // given
    Calculator sut = new Calculator(DiscountStrategyFactory.getStrategy(19));
    Item item1 = new Item("과자", 2000);
    Item item2 = new Item("음료", 1000);

    // when
    int result = sut.calcuate(List.of(item1, item2));

    // then
    Assertions.assertEquals(3000, result);
  }

}