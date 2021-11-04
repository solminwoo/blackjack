package com.Infostretch.blackjack;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BlackJackFlow BJF = context.getBean("IBlackJackFlow", BlackJackFlow.class);
		
		System.out.println(BJF.play());
	}

}
