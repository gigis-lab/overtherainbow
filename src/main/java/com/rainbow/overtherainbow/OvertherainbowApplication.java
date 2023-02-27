package com.rainbow.overtherainbow;

import java.util.Arrays;

import com.rainbow.ComponentScanBasePackage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/* scanBasePackageClasses 해주는 이유: 루트에 메인 애플리케이션이 있기에
	@ComponentScan의 basePackage 속성을 지정할 필요는 없지만 이렇게 하면
	리팩터링이 쉬워질 뿐만 아니라 기준 패키지가 어떤 패키지인지 쉽게 알 수 있다.
 */
@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
public class OvertherainbowApplication {

	public static void main(String[] args) {
		SpringApplication.run(OvertherainbowApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}