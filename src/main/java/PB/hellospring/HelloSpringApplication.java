package PB.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 어노테이션 --> 스프링 애플리케이션 실행에 필요한 정보 제공
public class HelloSpringApplication {

	public static void main(String[] args) {
		// SpringApplication.run을 해서 스프링 애플리케이션을 실행함.
		// 이때 HelloSpringApplication 클래스를 이용한다.
		// 스프링 애플리케이션에는 Tomcat이라는 웹서버가 내장되어 있다.
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
