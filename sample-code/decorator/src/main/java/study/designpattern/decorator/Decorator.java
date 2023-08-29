package study.designpattern.decorator;

import study.designpattern.FileOut;

public abstract class Decorator implements FileOut {

  private final FileOut delegate;

  public Decorator(FileOut delegate) {
    this.delegate = delegate;
  }

  protected void doDelegate(byte[] data) {
    delegate.write(data);
  }
}
