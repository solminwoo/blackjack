package com.Infostretch.blackjack;

import java.util.List;

import org.springframework.context.annotation.Bean;

public class AppConfig {

	@Bean(name = "IPlayer")
	public IPlayer createPlayer() {
		return new Player();
	}

	@Bean(name = "IGenerator")
	public IGenerator createGenerator() {
		return new Generator();
	}

	@Bean(name = "ICalculate")
	public ICalculate createCalculate() {
		return new Calculate();
	}

	@Bean(name = "IConvertor")
	public IConvertor createConvertor() {
		return new Convertor();
	}

	@Bean(name = "IHashMapVal")
	public IHashMapVal createHashMapVal() {
		return new HashMapVal();
	}
	@Bean(name = "IAskForHit")
	public IAskForHit createAskForHit() {
		return new AskForHit();
	}
	@Bean(name = "IDrawHandCardFlow")
	public IDrawHandCardFlow createDrawHandCardFlow() {
		return new DrawHandCardFlow();
	}
	
	@Bean(name = "IHandleHit")
	public IHandleHit createHandleHit() {
		return new HandleHit(createAskForHit(),createCalculate(), createDrawHandCardFlow());
	}
	
	@Bean(name = "IHandleDealer")
	public IHandleDealer createHandleDealer() {
		return new HandleDealer(createCalculate(),createDrawHandCardFlow());
	}
	@Bean(name = "ICompare")
	public ICompare createCompare() {
		return new Compare();
	}

	@Bean(name = "IBlackJackFlow")
	public IBlackJackFlow createBlackJackFlow() {
		return new BlackJackFlow(createPlayer(), createPlayer(), createGenerator(), createCalculate(),
				createConvertor(), createHashMapVal(), createDrawHandCardFlow(),createHandleHit(),createHandleDealer(),createCompare());
	}
}
