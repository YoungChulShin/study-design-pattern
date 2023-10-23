package study.designpattern.decorator;

import study.designpattern.OrderMemoWriter;

public abstract class OrderMemoDecorator implements OrderMemoWriter {

  private final OrderMemoWriter delegator;

  public OrderMemoDecorator(OrderMemoWriter delegator) {
    this.delegator = delegator;
  }

  protected void doDelegate(String memo) {
    delegator.writeMemo(memo);
  }

}
