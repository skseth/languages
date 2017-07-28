-- named after haskell curry
-- refer https://www.haskell.org/haskellwiki/Currying

-- all functions take one parameter!

-- f x y = bar === f x = \y -> bar === f = \x -> \y -> bar

mul x y = x * y

-- mul taking one param gives a function
-- mul 3 is a partial application of mul
mul3 = mul 3


-- in prelude you can type mul_uncurried = uncurry mul
mul_uncurried (x,y) = mul x y

mul_curried x y = mul_uncurried (x,y)

main = do
		-- print mul3
	    print . mul3 $ 5
	    print $ mul_uncurried (3,5)
	    print $ mul_curried 3 5

