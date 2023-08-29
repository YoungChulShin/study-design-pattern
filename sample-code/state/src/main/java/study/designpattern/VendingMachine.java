package study.designpattern;

import study.designpattern.state.State;

public class VendingMachine {

  private State state;
  private int coin;


  public void changeState(State state) {
    this.state = state;
  }

  public void insertCoin(int coin) {
    state.insertCoin(coin, this);
  }

  public void selectProduct(String productName, int coin) {
    state.selectProduct(productName, coin, this);
  }

  public void increaseCoin(int addCoin) {
    this.coin += addCoin;
    System.out.println("코인 " + addCoin + "원을 증가합니다.");
  }

  public void decreaseCoin(int decreaseCoin) {
    this.coin -= decreaseCoin;
    System.out.println("코인 " + decreaseCoin + "원을 차감합니다.");
  }

  public void returnCoin(int addCoin) {
    System.out.println("코인 " + addCoin + "원을 반환합니다.");
  }

  public void provideProduct(String productName) {
    System.out.println(productName + "을 판매합니다.");
  }

  public boolean hasNoCoin() {
    return this.coin <= 0;
  }



}
