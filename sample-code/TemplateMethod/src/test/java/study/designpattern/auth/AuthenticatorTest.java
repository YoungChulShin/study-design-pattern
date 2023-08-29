package study.designpattern.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthenticatorTest {

  @Test
  @DisplayName("DB를 이용한 인증 테스트는 ID가 99999보다 크면 에러가 발생한다")
  void db_authenticate_if_id_is_greater_than_99999_then_throw_exception() {
    // given
    Authenticator authenticator = new DbAuthenticator();

    // when, then
    Assertions.assertThrows(
        AuthException.class,
        () -> authenticator.authentcate("100000", "1234"));
  }

  @Test
  @DisplayName("DB를 이용한 인증 테스트는 성공하면 DB 타입의 Auth 객체를 리턴한다")
  void db_authenticate_if_success_then_return_db_type_auth() {
    // given
    Authenticator authenticator = new DbAuthenticator();

    // when
    Auth result = authenticator.authentcate("1", "1234");

    // then
    Assertions.assertEquals(AuthType.DB, result.type());
  }

  @Test
  @DisplayName("LDAP를 이용한 인증 테스트는 성공하면 LDAP 타입의 Auth 객체를 리턴한다")
  void ldap_authenticate_if_success_then_return_ldap_type_auth() {
    // given
    Authenticator authenticator = new LdapAuthenticator();

    // when
    Auth result = authenticator.authentcate("1", "1234");

    // then
    Assertions.assertEquals(AuthType.LDAP, result.type());
  }




}