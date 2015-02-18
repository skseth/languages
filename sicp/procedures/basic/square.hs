
sqrtx x = sqrt_iter 1 x
	where
		sqrt_iter::(Floating a, Ord a) => a -> a -> a
		sqrt_iter guess x =
			if (good_enough) then 
				guess
			else
				sqrt_iter improve x
			where
				good_enough  	= (abs ((square guess) - x)) < 0.001
				improve  		= average guess (x / guess)
				square x 		= x * x
				average x y 	= (x + y) / 2

main = do
		print $ sqrtx (fromIntegral 10)