package study.designpattern.decorator;

import study.designpattern.FileOut;

public class BufferedOut extends Decorator {

  public BufferedOut(FileOut delegate) {
    super(delegate);
  }

  @Override
  public void write(byte[] data) {
    System.out.println("버퍼에 기록합니다");
    super.doDelegate(data);
  }
}
