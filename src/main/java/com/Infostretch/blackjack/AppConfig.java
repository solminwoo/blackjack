package com.Infostretch.blackjack;

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

	@Bean(name = "IBlackJackFlow")
	public IBlackJackFlow createBlackJackFlow() {
		return new BlackJackFlow(createPlayer(), createPlayer(), createGenerator(), createCalculate(),
				createConvertor(), createHashMapVal());
	}
}
