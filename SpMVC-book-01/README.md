# Spring REST(RESTful) API 서버
- Spring 프로젝트의 `Controller` 클래스에 `@RestController`를 부착하여 각 method 에서 데이터를 return 하도록 하거나, `@Controller` 를 부착하고 각 method 에 `@ResponseBody` 를 부착하면 method는 `Resolver`를 경유하지 않고, 데이터를 즉시 client로 return 한다.
- 보통 `API` 서비스를 수행하기 위한 조치이다.
- 하지만 spring 에서 REST 데이터를 retrun 하는 것은 기본적으로 String type 만 가능하다. 
- 초기 SpringFramework 에서는 모든 데이터 type 을 return 할 수있었으나, 지금은 분리된 프로젝트로 구현되었다.

## Spring 에서 모든 데이터 type 을 `JSON`, `xml` type 으로 return 하기 
- dependency 설정하기
```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.1</version>
</dependency>
```