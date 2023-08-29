package study.designpattern.decorator;

import study.designpattern.FileOut;

public class EncryptionOut extends Decorator {

  public EncryptionOut(FileOut delegate) {
    super(delegate);
  }

  @Override
  public void write(byte[] data) {
    System.out.println("암호화를 합니다");
    super.doDelegate(data);
  }
}
