package study.designpattern.state;

import study.designpattern.VendingMachine;

public class SoldOutState implements State {

  @Override
  public void insertCoin(int coin, VendingMachine vendingMachine) {
    vendingMachine.returnCoin(coin);
  }

  @Override
  public void selectProduct(String productName, int coin, VendingMachine vendingMachine) {

  }
}
