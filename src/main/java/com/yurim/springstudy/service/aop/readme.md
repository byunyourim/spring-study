### Spring Proxy

Spring Aop uses JDK Dynamic Proxy or CGLIB.  


- JDK Dynamic Proxy : target Object가 단 하나라고 인터페이스를 구현하고 있는 경우, 그 인터페이스를 기반으로 프록시를 생성한다.

- CGLIB : target Object 인터페이스를 구현하지 않는 경우, CGLIB클래스를 상속받아 프록시 생성  



Spring AOP는 "프록시 기반"으로 동작하고, 프록시 객체를 통해 AOP 기능을 추가한다.    



#### Spring AOP는 프록시 기반이라, 자기 자신을 호출(this.method())하면 AOP가 적용되지 않는다.

1. 자기 자신 호출을 없애자.
2. @Autowired를 활용하여 프록시 객체를 주입하자.
3. AopContext.currentProxy()는 비추 (최후의 수단).
