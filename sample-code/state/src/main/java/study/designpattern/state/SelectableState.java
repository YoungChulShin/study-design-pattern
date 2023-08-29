package study.designpattern.state;

import study.designpattern.VendingMachine;

public class SelectableState implements State {

  @Override
  public void insertCoin(int coin, VendingMachine vendingMachine) {
    vendingMachine.increaseCoin(coin);
  }

  @Override
  public void selectProduct(String productName, int coin, VendingMachine vendingMachine) {
    vendingMachine.provideProduct(productName);
    vendingMachine.decreaseCoin(coin);
    if (vendingMachine.hasNoCoin()) {
      vendingMachine.changeState(new NoCoinState());
    }
  }
}
