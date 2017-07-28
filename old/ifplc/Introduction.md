#Names and Values
##Imperative
A sequence of commands

command;
command;
...

A variable is a changing association between name & value
Each command may result in an assignment, changing a variable's value

##Functional
A series of function calls (composition or nesting of calls)

Names are only formal parameters of functions, and given value by function calls with actual parameters. A name only has one value.

func(func(func 3 ...)...)

#Execution Order
Order is usually crucial for imperative

Functional - no necessary execution order

#Loops / Repetitions

Imperative : new values associated with same name by command repetition

Functional : new values associated with new names by recursive function call nesting

#Data Structures

Functional languages provide explicit representation for data structures

Absence of global structures since all sub-structures are never modified = only entire structure needs changing

#Functions as Values

Functional languages allow passing of functions as values



