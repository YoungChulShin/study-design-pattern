package study.designpattern.decorator;

import java.time.LocalDateTime;
import study.designpattern.OrderMemoWriter;

public class TimeLineOrderMemoDecorator extends OrderMemoDecorator {

  public TimeLineOrderMemoDecorator(OrderMemoWriter delegator) {
    super(delegator);
  }

  @Override
  public void writeMemo(String memo) {
    String timeline = "[" + LocalDateTime.now().toString() + "] ";
    super.doDelegate(timeline + memo);
  }
}
