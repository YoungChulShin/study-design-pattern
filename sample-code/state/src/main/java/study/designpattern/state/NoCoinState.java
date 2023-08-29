package study.designpattern.state;

import study.designpattern.VendingMachine;

public class NoCoinState implements State {

  @Override
  public void insertCoin(int coin, VendingMachine vendingMachine) {
    vendingMachine.increaseCoin(coin);
    vendingMachine.changeState(new SelectableState());
  }

  @Override
  public void selectProduct(String productName, int coin, VendingMachine vendingMachine) {

  }
}
