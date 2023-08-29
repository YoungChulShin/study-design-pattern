package study.designpattern.decorator;

import study.designpattern.FileOut;

public class ZipOut extends Decorator {

  public ZipOut(FileOut delegate) {
    super(delegate);
  }

  @Override
  public void write(byte[] data) {
    System.out.println("zip 압축을 합니다");
    super.doDelegate(data);
  }
}
