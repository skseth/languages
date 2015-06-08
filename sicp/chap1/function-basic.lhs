Here's a function of one variable in haskell

> square::Int -> Int
> square x = x * x

Note that square is defined with types - square takes a parameter of type int and returns another of type int as well

One can also express this in lambda form - this is the desugared version

> squarel::Int -> Int
> squarel = \x -> x * x

