package study.designpattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import study.designpattern.decorator.BufferedOut;
import study.designpattern.decorator.EncryptionOut;
import study.designpattern.decorator.ZipOut;

class FileOutTest {

  @Test
  void buffer_encryption_zip_write_test() {
    // given
    FileOut delegate = new FileOutImpl();
    // BufferedOut은 EncryptionOut을 Delegator로 가지고
    // EncryptionOut은 ZipOut을 Delegator로 가지고
    // ZipOut은 FileOutImpl을 Delegator로 가진다.
    FileOut fileOut = new BufferedOut(new EncryptionOut(new ZipOut(delegate)));
    // BufferedOut의 write가 수행된다
    // - 버퍼를 처리하고
    // - super.doDelegate를 호출하는데, 이는 EncryptionOut의 write를 수행하는 것이다.
    // 이렇게 순차적으로 호출이 진행되고,
    // 마지막으로 FileOutImpl이 실행되면서 파일로 출력된다.
    fileOut.write("test".getBytes());
  }
}