package study.designpattern.auth;

public class DbAuthenticator extends Authenticator {

  @Override
  protected boolean doAuthenticate(String id, String password) {
    try {
      int key = Integer.parseInt(id);
      return key <= 99999;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  @Override
  protected Auth createAuth(String id) {
    return new Auth(id, AuthType.DB);
  }
}
