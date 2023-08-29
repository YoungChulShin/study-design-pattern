package study.designpattern.auth;

public class LdapAuthenticator extends Authenticator {

  @Override
  protected boolean doAuthenticate(String id, String password) {
    return true;
  }

  @Override
  protected Auth createAuth(String id) {
    return new Auth(id, AuthType.LDAP);
  }
}
