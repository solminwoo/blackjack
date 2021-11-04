package com.Infostretch.blackjack;

import java.util.List;

public class ScoreCalculate implements ICalculate{
	private IConvertor _convertor;
	private ICalculate _calculate;
	
	

	
	public ScoreCalculate(IConvertor _convertor, ICalculate _calculate) {
		this._convertor = _convertor;
		this._calculate = _calculate;
	}


	@Override
	public int sumArrayList(List<Integer> arrList) {
		List<Integer> converted = _convertor.convertTo10(arrList);
		int currentScore = _calculate.sumArrayList(converted);
		while(currentScore>21 && converted.contains(11)) {
			converted = _convertor.convert11To1(converted);
			currentScore = _calculate.sumArrayList(converted);
		}
		return currentScore;
	}

}
