package spring_inter;

import java.util.*;

public class ChangeTo {
    static Stack<String> stack = new Stack<>();
    static List<String> exit = new LinkedList<>();
    static List<String> results = new ArrayList<>();
    static Map<String, Integer> operations = new HashMap<String, Integer>();
    static final String LB  = "(";
    static final String RB  = ")";


    static void changeToRpn(List<String> expression) {
        stack.clear();
        exit.clear();
        operations.put("^", 3);
        operations.put("%", 3);
        operations.put("√", 3);
        operations.put("*", 2);
        operations.put("/", 2);
        operations.put("+", 1);
        operations.put("-", 1);
        operations.put("sin", 3);
        operations.put("cos", 3);
        operations.put("tg", 3);

        for (String s : expression) {
            if (operations.keySet().contains(s)){
                operate(s);
            } else if (s.equals(LB)) {
                leftBracet();
            } else if (s.equals(RB)) {
                rightBracet();
            } else {
                exit.add(s);
            }
        }
        operateEnd();

    Calculate calculate = new Calculate(exit);
    results.add(calculate.calculations());
    }

    static void leftBracet (){
        stack.push(LB);
    }

    static void rightBracet () {
        while (!stack.peek().equals(LB)) {
            exit.add(stack.pop());
            if (stack.empty()) {
                throw new IllegalArgumentException("Bracket not found");
            }
        }
        stack.pop();
    }

    static void operate (String token) {
            while (!stack.empty() && !stack.peek().equals(LB)&&
                    (operations.get(token) <= operations.get(stack.peek()))) {
                exit.add(stack.pop());
            }
            stack.push(token);
    }

    static void operateEnd() {
        try {
            while (!stack.empty()) {
                exit.add(stack.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List getResults(){
        return results;
    }
}
