package com.Infostretch.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Convertor implements IConvertor{

	@Override
	public List<Integer> convertTo10(List<Integer> arrList) {
		List<Integer> result = new ArrayList();
		for(int i :arrList) {
			if(i>10 && i<14) {
				result.add(10);
			} else if(i ==14){
				result.add(11);
			}else {				
				result.add(i);
			}
		}
		return result;
	}

	@Override
	public List<Integer> convert11To1(List<Integer> arrList) {
		List<Integer> result = new ArrayList();
		int count = 0;
		for(int i : arrList) {
			if(i == 11 && count==0 ) {
				result.add(1);
				count++;
			}else {
				result.add(i);
			}
		}
		return result;
	}

}
