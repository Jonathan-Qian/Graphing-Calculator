package math;

import java.util.ArrayList;

public class Parser {
    public static Parser instance;

    private Parser() {}

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();

        return instance;
    }

    // doesn't work for functions with no arguments yet
    // this parser is very basic for now
    public Expression parse(String s) {
        int index = s.indexOf('(');
        FunctionBehaviour f = Function.getFunctionBehaviour(s.substring(0, index));
        String argumentString;
        ArrayList<String> split;

        if (s.charAt(s.length() - 1) != ')') {
            System.err.println("Parsing warning: missing closing parenthesis");
            argumentString = s.substring(index + 1);
        }
        else {
            argumentString = s.substring(index + 1, s.length() - 1);
        }

        split = split(argumentString);

        Element[] arguments = new Element[split.size()];

        String str;

        for (int i = 0; i < split.size(); i++) {
            str = split.get(i);

            if (Character.isDigit(str.charAt(0)) || str.charAt(0) == '.') {
                arguments[i] = new Number(Double.parseDouble(str));
            }
            else {
                if (str.indexOf('(') < 0 && (Function.getFunctionBehaviour(str) == null || Function.getFunctionBehaviour(str).canHaveNoArguments())) {
                    Double value = Constant.getConstantValue(str);

                    if (value != null) {
                        arguments[i] = new Number(Constant.getConstantValue(str));
                    }
                    else {
                        if (str.length() == 1) {
                            arguments[i] = Variable.getVariable(str.charAt(0));
                        }
                        else {
                            System.err.println("Parsing error: unidentified constant \"" + str + "\"");
                            return null;
                        }
                    }
                }
                else {
                    arguments[i] = parse(str);
                }
            }
        }

        if (f == null) {
            System.err.println("Parsing error: function does not exist");
            return null;
        }

        return new Expression(arguments, f);
    }

    public ArrayList<String> split(String str) {
        ArrayList<String> list = new ArrayList<>();
        int start = 0, end;
        int depth = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',' && depth == 0) {
                end = i;
                list.add(str.substring(start, end));
                start = end + 1;
            }
            else if (str.charAt(i) == '(') {
                depth++;
            }
            else if (str.charAt(i) == ')') {
                depth--;
            }
        }

        list.add(str.substring(start));

        if (depth != 0) {
            // invalid parentheses
            System.err.println("Invalid parentheses");
        }

        return list;
    }
}
