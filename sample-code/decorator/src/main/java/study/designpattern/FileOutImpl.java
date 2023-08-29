package study.designpattern;

public class FileOutImpl implements FileOut {

  @Override
  public void write(byte[] data) {
    System.out.println("data를 출력합니다");
  }
}
