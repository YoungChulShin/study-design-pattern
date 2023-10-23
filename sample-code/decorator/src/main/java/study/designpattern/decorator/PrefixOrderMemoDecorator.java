package study.designpattern.decorator;

import study.designpattern.OrderMemoWriter;

public class PrefixOrderMemoDecorator extends OrderMemoDecorator {

  private final String prefix;

  public PrefixOrderMemoDecorator(OrderMemoWriter delegator, String prefix) {
    super(delegator);
    this.prefix = prefix;
  }

  @Override
  public void writeMemo(String memo) {
    super.doDelegate(prefix + memo);
  }
}
