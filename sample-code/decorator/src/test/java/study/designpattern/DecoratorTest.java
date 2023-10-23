package study.designpattern;

import java.io.FileWriter;
import org.junit.jupiter.api.Test;
import study.designpattern.decorator.PrefixOrderMemoDecorator;
import study.designpattern.decorator.SuffixOrderMemoDecorator;
import study.designpattern.decorator.TimeLineOrderMemoDecorator;

public class DecoratorTest {

  @Test
  void prefix_decorator_should_write_memo_start_with_prefix() {
    // given
    String memo = "천천히 와주세요.";
    String prefix = "오더 메모: ";
    OrderMemoWriter orderMemoWriter = new PrefixOrderMemoDecorator(
        new OrderMemoWriterImpl(),
        prefix);

    // when
    orderMemoWriter.writeMemo(memo);
  }

  @Test
  void suffix_decorator_should_write_memo_end_with_suffix() {
    // given
    String memo = "천천히 와주세요.";
    String suffix = " 현관 비밀번호: 1234 ";
    OrderMemoWriter orderMemoWriter = new SuffixOrderMemoDecorator(
        new OrderMemoWriterImpl(),
        suffix);

    // when
    orderMemoWriter.writeMemo(memo);
  }

  @Test
  void timeline_decorator_should_write_memo_start_with_timeline() {
    // given
    String memo = "천천히 와주세요.";
    OrderMemoWriter orderMemoWriter = new TimeLineOrderMemoDecorator(new OrderMemoWriterImpl());

    // when
    orderMemoWriter.writeMemo(memo);
  }

  @Test
  void all_decorator_write_memo_test() {
    // given
    String memo = "천천히 와주세요.";
    String prefix = "오더 메모: ";
    String suffix = " 현관 비밀번호: 1234 ";

    // when
    OrderMemoWriter orderMemoWriter =
        new TimeLineOrderMemoDecorator(
            new PrefixOrderMemoDecorator(
                new SuffixOrderMemoDecorator(new OrderMemoWriterImpl(), suffix)
                , prefix));

    orderMemoWriter.writeMemo(memo);
  }

}
