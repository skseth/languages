; if expression
; else is necessary

> abs::Int -> Int
> abs x = 
> 	if x < 0
>     	then -x
>     	else if x == 0 
>              then 0
>              else x

; the following is equivalent

> absg::Int -> Int
> absg x
> 	| x < 0      = -x
> 	| x == 0     = 0
> 	| otherwise  = x
	
; if can be embedded in an expression

> g x y = (if x == 0 then 1 else sin x / x) * y


