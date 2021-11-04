package com.Infostretch.blackjack;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TestScoreCalculate {
	
	@Mock
	IConvertor mockConvertor = mock(Convertor.class);
	@Mock
	ICalculate mockCalculate = mock(Calculate.class);

	@Test
	void faceValueTo10() {
		//given:11,12
		//when: calculating score
		//return: 20
		List<Integer> sample = List.of(11,12,13);
		given(mockConvertor.convertTo10(sample)).willReturn(List.of(10,10));
		given(mockCalculate.sumArrayList(List.of(10,10))).willReturn(20);
		ICalculate SC = new ScoreCalculate(mockConvertor,mockCalculate);
		int result = SC.sumArrayList(sample);
		verify(mockConvertor, times(1)).convertTo10(sample);
		verify(mockCalculate,times(1)).sumArrayList(List.of(10,10));
		assertEquals(20,result);
	}
	
	@Test
	void AceTo11() {
		//given:11,14
		//when: calculating score
		//return: 21
		List<Integer> sample = List.of(11,14);
		given(mockConvertor.convertTo10(sample)).willReturn(List.of(10,11));
		given(mockCalculate.sumArrayList(List.of(10,11))).willReturn(21);
		ICalculate SC = new ScoreCalculate(mockConvertor,mockCalculate);
		int result = SC.sumArrayList(sample);
		verify(mockConvertor, times(1)).convertTo10(sample);
		verify(mockCalculate,times(1)).sumArrayList(List.of(10,11));
		assertEquals(21,result);
	}
	@Test
	void twoAceTo11() {
		//given:14,14
		//when: calculating score
		//return: 12
		List<Integer> sample = List.of(14,14);
		given(mockConvertor.convertTo10(sample)).willReturn(List.of(11,11));
		given(mockCalculate.sumArrayList(List.of(11,11))).willReturn(22);
		given(mockConvertor.convert11To1(List.of(11,11))).willReturn(List.of(1,11));
		given(mockCalculate.sumArrayList(List.of(1,11))).willReturn(12);
		ICalculate SC = new ScoreCalculate(mockConvertor,mockCalculate);
		int result = SC.sumArrayList(sample);
		verify(mockConvertor, times(1)).convertTo10(sample);
		verify(mockCalculate,times(1)).sumArrayList(List.of(11,11));
		verify(mockConvertor, times(1)).convert11To1(List.of(11,11));
		verify(mockCalculate,times(1)).sumArrayList(List.of(1,11));
		assertEquals(12,result);
	}
	
	@Test
	void threeAceTo11() {
		//given:14,14,14
		//when: calculating score
		//return: 13
		List<Integer> sample = List.of(14,14,15);
		given(mockConvertor.convertTo10(sample)).willReturn(List.of(11,11,11));
		given(mockCalculate.sumArrayList(List.of(11,11,11))).willReturn(33);
		given(mockConvertor.convert11To1(List.of(11,11,11))).willReturn(List.of(1,11,11));
		given(mockCalculate.sumArrayList(List.of(1,11,11))).willReturn(23);
		given(mockConvertor.convert11To1(List.of(1,11,11))).willReturn(List.of(1,1,11));
		given(mockCalculate.sumArrayList(List.of(1,1,11))).willReturn(13);
		ICalculate SC = new ScoreCalculate(mockConvertor,mockCalculate);
		int result = SC.sumArrayList(sample);
		verify(mockConvertor, times(1)).convertTo10(sample);
		verify(mockCalculate,times(1)).sumArrayList(List.of(11,11,11));
		verify(mockConvertor, times(1)).convert11To1(List.of(11,11,11));
		verify(mockCalculate,times(1)).sumArrayList(List.of(1,11,11));
		verify(mockConvertor, times(1)).convert11To1(List.of(1,11,11));
		verify(mockCalculate,times(1)).sumArrayList(List.of(1,1,11));
		assertEquals(13,result);
	}

}