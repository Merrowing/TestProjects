package com.tasks7.rpn;

import java.util.Deque;
import java.util.LinkedList;

public class Application {

	public static double parse(String rpnString) {
		LinkedList<Double> stack = new LinkedList<Double>();
		try{
		for(String token:rpnString.split("\\s")){
			double secondOperand = 0.0;
            double firstOperand = 0.0;
			switch (token) {
            case "+":
                secondOperand = stack.pop();
                firstOperand = stack.pop();

                stack.push(firstOperand + secondOperand);
                break;
            case "-":
                secondOperand = stack.pop();
                firstOperand = stack.pop();

                stack.push(firstOperand - secondOperand);
                break;
            case "*":
                secondOperand = stack.pop();
                firstOperand = stack.pop();

                stack.push(firstOperand * secondOperand);
                break;
            case "/":
                secondOperand = stack.pop();
                firstOperand = stack.pop();  

                stack.push(firstOperand / secondOperand);
                break;
            default:
                stack.push(Double.parseDouble(token));
                break;
        }
		}
		if (stack.size() > 1)
            throw new RPNParserException();
		Double result = stack.pop();
		if(Double.isInfinite(result)||Double.isNaN(result))throw new ArithmeticException();
		return result;
		}catch (ArithmeticException e){
            throw e;
        }
		catch (Exception e){
            throw new RPNParserException();
        }
		
		
		
	
	}

	public static void main(String[] args) {
		String s = "10 20 + 30 40 + *";
		System.out.println(parse(s));
	}

}
      
      