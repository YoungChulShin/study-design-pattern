package study.designpattern.decorator;

import study.designpattern.OrderMemoWriter;

public class SuffixOrderMemoDecorator extends OrderMemoDecorator {

  private final String suffix;

  public SuffixOrderMemoDecorator(OrderMemoWriter delegator, String suffix) {
    super(delegator);
    this.suffix = suffix;
  }

  @Override
  public void writeMemo(String memo) {
    super.doDelegate(memo + suffix);
  }
}
