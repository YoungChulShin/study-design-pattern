package study.designpattern;

public class OrderMemoWriterImpl implements OrderMemoWriter {

  @Override
  public void writeMemo(String memo) {
    System.out.println(memo);
  }
}
