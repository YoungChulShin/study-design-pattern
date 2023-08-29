package study.designpattern.state;

import study.designpattern.VendingMachine;

public interface State {

  void insertCoin(int coin, VendingMachine vendingMachine);

  void selectProduct(String productName, int coin, VendingMachine vendingMachine);
}
