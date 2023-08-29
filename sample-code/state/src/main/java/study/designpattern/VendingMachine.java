package study.designpattern;

import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {

  public static enum State { NOCOIN, SELECTABLE, SOLDOUT }
  private int coin;

  private State state = State.NOCOIN;

  public void insertCoin(int coin) {
    switch (state) {
      case NOCOIN -> {
        increaseCoin(coin);
        state = State.SELECTABLE;
      }
      case SELECTABLE -> increaseCoin(coin);
      case SOLDOUT -> returnCoin(coin);
    }
  }

  public void selectProduct(String productName, int coin) {
    switch (state) {
      case NOCOIN -> { }
      case SELECTABLE -> {
        provideProduct(productName);
        decreaseCoin(coin);
        if (hasNoCoin()) {
          state = State.NOCOIN;
        }
      }
      case SOLDOUT -> { }
    }
  }

  private void increaseCoin(int addCoin) {
    this.coin += addCoin;
    System.out.println("코인 " + addCoin + "원을 증가합니다.");
  }

  private void decreaseCoin(int decreaseCoin) {
    this.coin -= decreaseCoin;
    System.out.println("코인 " + decreaseCoin + "원을 차감합니다.");
  }

  private void returnCoin(int addCoin) {
    System.out.println("코인 " + addCoin + "원을 반환합니다.");
  }

  private void provideProduct(String productName) {
    System.out.println(productName + "을 판매합니다.");
  }

  private boolean hasNoCoin() {
    return this.coin <= 0;
  }



}
