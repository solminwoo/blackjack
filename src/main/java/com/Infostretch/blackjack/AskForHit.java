package com.Infostretch.blackjack;

import java.util.Scanner;

public class AskForHit implements IAskForHit{

	@Override
	public boolean getResponse() {
		boolean result;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you want another card? Y/N");
		String str = scanner.nextLine();
		if(str.equals("Y") || str.equals("y")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
