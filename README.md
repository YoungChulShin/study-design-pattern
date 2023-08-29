# 설명
디자인패턴을 정리합니다. 

참고한 책
- 개발자가 반드시 정복해야 할 객체지향과 디자인 패턴

# 전략(Strategy) 패턴
![strategy-pattern](/images/strategy-pattern.svg)

개념
- 콘텍스트에서 알고리즘을 별도로 분리하는 설계 방법이 전략 패턴이다. 

장점
- 새로운 알고리즘 추가될 때, 콘텍스트에는 코드 변경이 없다. 
- 확장에는 열려있고, 변경에는 닫혀있는 코드를 만들 수 있다. 

용어
- 콘텍스트(Context): Calculator
- 전략(Strategy): DiscountStrategy
- 전략 콘크리트 클래스(Strategy concrete class): FirstGuestDiscountStrategy, NonFreshItemDiscountStrategy

샘플 코드
- [link](./sample-code/strategy/src/test/java/study/designpattern/CalculatorTest.java)

# 템플릿 메서드(Template Method) 패턴
![template-method-pattern](/images/template-method.svg)

개념
- 실행 과정은 같은데 각 단계 중 일부의 구현이 다른 경우에 사용할 수 있다.

등장 인물
- 실행 과정을 구현한 상위 클래스
- 실행 과정의 일부를 구현한 하위 클래스

샘플 코드
- [link](./sample-code/TemplateMethod/src/test/java/study/designpattern/auth/AuthenticatorTest.java)

# 상태(State) 패턴
VendingMachine 예시
- `동전을 넣는다`, `제품을 선택한다` 라는 동작이 있을 때, 이 동작들은 조건에 따라서 실행 내용과 결과가 달라지게 된다. 
   - 예: 동전을 넣었을 때 동전이 없었다면 
      1. 금액을 증가하고
      2. 상태를 '제품 선택 가능'으로 변경한다
- 이러한 코드는 패턴을 적용하지 않을때는 if/else를 이용해서 구현될 수 있다.

![state-pattern](/images/state.svg)

개념
- 기능이 상태에 따라 다르게 동작해야 할 때 사용할 수 있는 패턴.
- 상태를 별도 타입으로 분리하고, 상태별로 알맞은 하위 타입을 구현한다. 

용어
- 콘텍스트: VendingMachine
- 상태: State
- 상태 콘크리트 클래스: NoCoinState, SelectableCointState, SoldoutState

장점
- 새로운 상태가 추가되더라도 콘텍스트 코드가 받는 영향은 최소화된다.
- 상태에 따른 동작을 구현한 코드가 상태별로 가지기 때문에 상태별 동작을 수정하기가 쉽다.

샘플 코드
- [link](./sample-code/state/src/main/java/study/designpattern/VendingMachine.java)

## 상태 변경 주체?
콘크리트 클래스에서 동작이 일어났을 때, 상태가 변경될 수 있다. 이러한 상태 변경은 콘텍스트, 콘크리트 클래스에 책임을 줄 수 있다. 

콘텍스트에 책임
- 상태가 작을 때는 효과적이다. 
- 상태가 많아지면 콘텍스트 클래스의 코드가 복잡해지기 때문에 상태 변경의 유연함이 떨어지게 된다. 

콘크리트 클래스에 책임
- 위에 그림처럼 콘텍스트 객체를 상태에 넘겨줘야한다. 
- 콘크리트 클래스에서는 전달 받은 콘텍스트 객체를 이용해서 상태 변경을 한다. 
- 콘텍스트에 영향을 주지 않으면서 상태를 변경할 수 있다. 
- 상태 변경 로직이 분산되기 때문에 상태가 많아지면 규칙을 파악하는게 어려워진다. 
   ![state-pattern](/images/stete2.svg)

# 데코레이터(Decorator) 패턴
상황
- 파일을 출력하는 기능을 구현한다. 
- 요구사항에 대한 옵션이 많아서 압축, 암호화, 버퍼출력 등 기능이 추가될 때마다 기존에 상속으로 개발된 코드는 연관 클래스의 수가 늘어난다. 

![decorator-pattern](/images/decorator.svg)

개념
- 상속이 아닌 위임으로 기능을 확장해나간다. 
- 확장되는 기능의 구현이 별도의 클래스로 분리되기 때문에, 원래 기능에 영향없이 변경할 수 있다. 
- 데코레이터를 조합하는 방식으로 기능을 확장할 수 있다. 

주의점
- 정의되어 있는 메서드가 증가하면 구현이 복잡해진다. 
- 특정 데코레이터가 비정상적으로 동작할 때, 어덯게 처리할 것인지 확인이 필요하다. 
   - 예를 들어서 DB에 커밋되었는데, 메시지 전송이 실패했다면 어떻게 처리할지를 확인해야한다. 


# 프록시(Proxy) 패턴
상황
- UI에서 이미지를 스크롤 하면서 보여주는 기능이 있다. 
- 이미지의 수가 너무 많을 경우 한번에 이미지를 불러오기보다는 스크롤하다가 특정 위치에 왔을 때, 해당 위치의 이미지를 동적으로 읽어서 보여주고 싶다. 

![proxy-pattern](/images/proxy.svg)

개념
- 실제로 Real 객체가 사용되기 전까지 초기에 값을 가지지 않는 Proxy 객체가 Real 객체를 대신한다. 
- Proxy 객체는 Real 객체의 변수를 가지고 있는데, 초기값은 null이고 필요한 시점에 객체를 생성한다. 

장점
- 불필요하게 데이터를 로딩하거나 메모리를 사용하는 상황을 방지할 수 있다. 
- 이미지를 로딩하는 정책이 변경되더라도 ListUI에 영향을 주지 않는다.

Proxy 종류
- virtual proxy(가상 프록시): 필요한 시점에 객체를 생성해 주는 프록시
- protection proxy(보호 프록시): 실제 객체에 접근을 제어하는 프록시. 권한이 있을 경우에만 실제 객체의 메서드를 실행한다. 
- remote proxy(원격 프록시): 자바의 RMI 처럼 다른 프로세스에 존재하는 객체를 접근할 때 사용되는 프록시.

보호 프록시의 경우는 위임을 이용해서 구현도 가능하고, 상속을 통해서도 구현 가능하다. 
- 위임을 한다면 proxy 생성 시점에 real 객체를 같이 전달해야한다. 
- 상속을 사용한다면 상위클래스에 기준이 되는 메서드가 있고, proxy 클래스에서 해당 메서드를 override해서 접근 제어 기능을 추가할 수 있다. 

# 어댑터(Adapter) 패턴
상황
- 검색 서비스에서 기존에는 DB만을 이용하고 있다.
- 성능이 나오지 않아서 다른 외부 서비스를 이용해야하는데, 외부 서비스는 현재 검색 서비스가 제공하는 interface 양식에 맞지 않다. 

![adapter-pattern](/images/adapter.jpg)

개념
- 어댑터 패턴을 이용하면 2개 서비스 사이에 인터페이스가 맞지 않는 문제를 해결할 수 있다. 
- 어댑터 클래스는 ExternalService의 결과를 SearchService의 인터페이스에 맞게 맞춰 주는 책임을 가진다. 

상속을 이용한 구현
- 첨부된 그림에서는 `SearchServiceToExternalServiceAdapter`가 `ExternalService` 를 직접 가지고 있는 것으로 구현되었다. 
- 이 경우 SearchServiceToExternalServiceAdapter는 ExternalService를 상속하게 된다. 
- 그리고 ExternalService의 필요한 기능은 `super.xxx`를 통해서 호출한다. 

# 옵저버(Observer) 패턴
![observer-pattern](/images/observer.jpg)

개념
- 상태가 변경될 때, 여러 객체들에게 변경 사실을 알려준다. 

객체 상태 전달
- 옵저버 객체에서 내부 로직을 처리할 때, 주제 객체의 정보가 필요할 수 있다. 
1. 상태 정보만 넘겨줄 수도 있고
2. 주제 객체를 넘겨줄 수도 있다.

고려사항 
1. 옵저버를 호출하는 주체가 누가 될 것인가?
   - 주제 객체에서 호출할 수도 있고
   - 여러 주제객체의 연동 적인 상태 변경 이후에 옵저버에서 통지를 해야한다면, 주제 객체의 상태를 변경하는 코드에서 통지 기능을 실행하도록 할 수 있다.
2. 옵저버의 인터페이스 수
   - 상태 변경 내역의 종류가 다양한 경우 종류별로 옵저버 인터페이스를 분리해준다.
3. 통지 시점에 주제 객체의 상태에 결함이 없어야한다. 
4. 옵저버 실행에 제한을 둔다
   - 예: 실행 시간

# 파사드(Facade) 패턴
상황
- 특정 화면에서 UI를 표시하기 위해서 3개 서비스에 접근해서 데이터를 가져오고 있다. 
- 동일한 데이터를 XML, Excel로 출력이 필요해져서 이를 위한 2개의 클래스(XMLExporter, ExcelExporter)가 추가되었다. 
- 2개의 클래스는 동일하게 각각 하위 3개 서비스에 접근해서 데이터를 가져온다. 
- 상위 3개의 클래스는 하위 3개 클래스에 접근하기 위한 코드가 중복된다. 

![facade-pattern](/images/facade.jpg)

개념
- 하위 시스템을 감춰주는 상위수준의 인터페이스를 제공한다. 
- 클라이언트 입장에서는 인터페이스만 바라보면 되기 때문에 코드 중복과 직접 의존을 줄일 수 있다. 

용어
- 클라이언트: GUIViewer, Exporter
- 파사드: EmpReportFacade
- 서비 시스템: 하위 시스템들

장점
- 클라이언트와 서비스 시스템 간에 직접적인 의존을 제거했다. 이를 통해 서브 시스템의 변경이 클라이언트까지 전파되지 않는다. 

# 추상 팩토리(Abstract Factory) 패턴
상황
- 클라이언트가 각 조건에 따라서 사용하는 구현체 클래스를 생성하고 있다. 
- 조건이 복잡해지거나 구현체 클래스에 변경이 생기면 클라이언트 코드에 변경이 발생한다. 
- 클라이언트 수정 없이 변경에 대응하고 싶다. 

![abstract-factory](/images/abstract-factory.jpg)

개념
- Client 클래스로부터 객체 생성 책임을 분리함으로써, 변경이 발생했을 때 Factory의 변경으로 Client 수정 없이 대응할 수 있다. 

용어
- 팩토리: EnemyFactory
- 제품: Boss, SmallFlightg, Obstacle

## 팩토리 클래스를 interface로 변경
팩토리 클래스는 팩토리 클래스를 생성하는 책임(=getFactory())을 가지고 있기 때문에 추상 클래스로 구현된다. 
```java
public abstract class EnemyFactory {
   public static EnemyFactory getFactory(int level) {
      if (level == 1) {
         retun EasyStateEnemyFactory();
      } else {
         return HardEnemyFactory();
      }
   }
}
```

여기서 팩토리 클래스를 생성하는 책임을 별도로 분리할 수 있다면, EnemyFactory는 interface로 변경될 수 있다. 

# 컴포지트(composte) 패턴
상황
- 빌딩 장비들의 전원을 관리하는 개발을 하고 있다. 
- 개별 장비들에 turnOn, turnOff 기능을 추가했지만, 전체적으로 한번에 관리할 수 있는 기능을 추가하고 싶어서 DeviceGroup을 추가했다. 
- DeviceGroup은 Device를 List로 가지고 있고, turnAllOn, turnAllOff를 가진다. 
- Device에 새로운 기능이 추가되면 DeviceGroup도 함께 메서드가 추가되어야하는 문제점이 있다. 

![composite](/images/composite.jpg)

개념
- DeviceGroup을 추가하는데, 다른 장비와 같이 Device의 구현체로 생성한다. 

구성
- 컴포넌트: Device
- 단말: Aircon, Light, Elevator
- 컴포지트: DeviceGroup

장점
- 컴포지트 자체도 컴포넌트이기 때문에 컴포지트에 다른 컴포지트를 추가할 수 있다. 

단점
- DeviceGroup을 사용하기 위해서 직접 DeviceGroup에 접근해야한다. 
   ```java
   DeviceGroup group = new DeviceGroup();
   ```

## 컴포넌트에 Device를 관리하는 기능 추가
![composite2](/images/composite2.jpg) 

설명
- Device가 Device를 관리하는 addDevice, removeDevice를 가진다. 
   - 기본적으로 호출이 되면 안되기 때문에 addDevice는 예외, removeDevice는 아무 동작을 하지 않는다. 
- Device에 Device를 추가할 수 있는지를 체크하기 위해서 canContain 함수를 추가한다. 
- 컴포지트는 addDevice, removeDevice, canContain 기능을 오버라이드해서 Device를 관리하는 기능을 구현한다. 
