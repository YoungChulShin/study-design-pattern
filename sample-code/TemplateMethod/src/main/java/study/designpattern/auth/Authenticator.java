package study.designpattern.auth;

public abstract class Authenticator {

  public Auth authentcate(String id, String password) {
    if (!doAuthenticate(id, password)) {
      throw new AuthException();
    }

    return createAuth(id);
  }

  protected abstract boolean doAuthenticate(String id, String password);

  protected abstract Auth createAuth(String id);

}
