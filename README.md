A general-purpose graphing calculator with a built-in math parser. New functions can be added by creating a java file in the functions package (use BasicFunctions.java as a template to write your own) and adding a line that includes the package and file name in the math.FunctionProvider file in META-INF/services. For now, the parser will only accept strings that are formatted, for example, like this:
\*(0.1,^(x,2))
which is equivalent to:
0.1\*x^2
The unimplemented formatter should solve this problem. Improvements will also be made to the parser.
