A general-purpose graphing calculator with a built-in math parser and renderer. New functions can be added by creating a java file in the functions package (use BasicFunctions.java as a template to write your own) and adding a line that includes the package and file name to the math.FunctionProvider file in META-INF/services. For now, the parser will only accept strings that are formatted, for example, like this:
"\*(0.1,^(x,2))"
which is equivalent to:
"0.1\*x^2".
The unimplemented formatter should solve this problem. The expression model (expression tree) and function interface and plug-in system is complete. The current implementation of the parser and renderer is rudimentary and improvements will be made.

<img width="1920" height="1140" alt="Screenshot 2026-01-03 154013" src="https://github.com/user-attachments/assets/f934be4a-c981-421b-b414-b2f5ebcdf1df" />
