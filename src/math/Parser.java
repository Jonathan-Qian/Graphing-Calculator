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

    public Expression parse(String s) {
        // split into elements
        ArrayList<String> elements = split(s);

        // build expression tree
        return build(elements);
    }

    private ArrayList<String> split(String s) {
        char c;
        int start, end;
        ArrayList<String> elements = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == '(') {
                start = i;
                end = -1;
                int depth = 0;

                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        depth++;
                    }
                    else if (s.charAt(j) == ')') {
                        depth--;

                        if (depth < 0) {
                            end = j;
                            break;
                        }
                    }
                }

                if (end > -1) {
                    elements.add(s.substring(start, end));
                }
                else {
                    System.err.println("Parsing error: opening parenthesis with no closing parenthesis");
                    return null;
                }

                i = end - 1;
            }
            else if (c == ')') {
                System.err.println("Parsing warning: closing parenthesis with no opening parenthesis");
            }
            else if (Character.isDigit(c)) {
                start = i;
                end = i + 1;

                for (int j = i + 1; j < s.length(); j++) {
                    if (!Character.isDigit(s.charAt(j)) && s.charAt(j) != '.') {
                        end = j;
                        break;
                    }
                }

                elements.add(s.substring(start, end));

                i = end - 1;
            }
            else {

            }
        }

        return elements;
    }

    private Expression build(ArrayList<String> elements) {
        return null;
    }

    //format
    //split into elements
    //split into sub expressions by priority
}
