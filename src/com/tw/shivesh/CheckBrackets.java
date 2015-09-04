package com.tw.shivesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CheckBrackets {

	public static void main(String[] args) {
		System.out.println(checkBrackets("a*(([x + 2])[(y)])+2"));
		System.out.println(checkBrackets("b/((][x)"));
		System.out.println(checkBrackets("(5 + 2))("));
		System.out.println(checkBrackets("([x +2]))y(z)-5"));
		System.out.println(checkBrackets("([x+2)"));
	}

	private static boolean checkBrackets(String string) {

		Map<Character, Character> bracketPair = new HashMap<Character, Character>();
		bracketPair.put(')', '(');
		bracketPair.put(']', '[');
		
		List<Character> permittedBrackets = getPermittedBrackets();
		List<Character> onlyBrackets = getOnlyBrackets(string,permittedBrackets);
		
		if (onlyBrackets.size() % 2 == 0 && checkBracketLogic(onlyBrackets, bracketPair)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean checkBracketLogic(List<Character> onlyBrackets,Map<Character, Character> bracketPair) {
		Stack<Character> bracketStack = new Stack<Character>();
		for (Character eachBracket : onlyBrackets) {
			if (eachBracket == '(' || eachBracket == '[') {
				bracketStack.push(eachBracket);
			} else if(!bracketStack.empty()) {
				bracketPair.get(eachBracket).equals(bracketStack.peek());
				bracketStack.pop();
			}else{
				return false;
			}
		}
		if (bracketStack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	private static List<Character> getPermittedBrackets() {
		List<Character> permittedBrackets = new ArrayList<Character>();
		permittedBrackets.add('(');
		permittedBrackets.add(')');
		permittedBrackets.add('[');
		permittedBrackets.add(']');
		return permittedBrackets;
	}

	private static List<Character> getOnlyBrackets(String string,List<Character> permittedBrackets) {
		List<Character> onlyBrackets = new ArrayList<Character>();
		char[] userInput = string.toCharArray();
		for (char c : userInput) {
			if (permittedBrackets.contains(c)) {
				onlyBrackets.add(c);
			}
		}
		return onlyBrackets;
	}

}