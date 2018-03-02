package spring_inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class Calculate extends ChangeTo{
    List <String> expression;
    String result;
    public Calculate(List expression){
        this.expression = expression;
    }
    public String calculations (){
        Stack<BigDecimal> stack = new Stack<>();
        for (String s : expression){
            if (!operations.keySet().contains(s)){
                stack.push(new BigDecimal(s));
            } else if (!stack.empty()){
                BigDecimal second = stack.pop();
                    switch (s){
                        case ("+"): {
                            BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                            stack.push(first.add(second));
                        }
                            break;
                        case ("-"): {
                            BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                            stack.push(first.subtract(second));
                        }
                            break;
                        case ("*"): {
                            BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                            stack.push(first.multiply(second));
                        }
                            break;
                        case ("/"): {
                            if (second.equals(BigDecimal.ZERO)){
                                return result = "Division by zero";
                            }else {
                                BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                                stack.push(first.divide(second));
                            }
                        }
                            break;
                        case ("^"): {
                            BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                            stack.push(first.pow(Integer.valueOf(String.valueOf(second))));
                        }
                            break;
                        case ("√"): stack.push(BigDecimal.valueOf(Math.sqrt(Double.valueOf(String.valueOf(second)))));
                            break;
                        case ("%"): {
                            if (second.equals(BigDecimal.ZERO)){
                                return result = "Division by zero";
                            }else {
                                BigDecimal first = stack.empty() ? BigDecimal.ZERO : stack.pop();
                                stack.push(first.divide(second));
                            }
                        }
                            break;
                        case ("sin"): stack.push(BigDecimal.valueOf(Math.sin(Double.valueOf(String.valueOf(second)))));
                            break;
                        case ("cos"): stack.push(BigDecimal.valueOf(Math.cos(Double.valueOf(String.valueOf(second)))));
                            break;
                        case ("tg"): stack.push(BigDecimal.valueOf(Math.tan(Double.valueOf(String.valueOf(second)))));
                            break;
                    }
                //System.out.println(stack.peek());
            }

        }
        return result = String.valueOf(stack.peek().setScale(5, 1));
    }
}
