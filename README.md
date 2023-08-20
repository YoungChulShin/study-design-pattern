# 설명
디자인패턴을 정리합니다. 

# 전략 패턴
![strategy-pattern](/images/strategy-pattern.svg)

개념
- 콘텍스트에서 알고리즘을 별도로 분리하는 설계 방법이 전략 패턴이다. 

장점
- 새로운 알고리즘 추가될 때, 콘텍스트에는 코드 변경이 없다. 
- 확장에는 열려있고, 변경에는 닫혀있는 코드를 만들 수 있다. 

등장인물
- 콘텍스트(Context): Calculator
- 전략(Strategy): DiscountStrategy
- 전략 콘크리트 클래스(Strategy concrete class): FirstGuestDiscountStrategy, NonFreshItemDiscountStrategy



