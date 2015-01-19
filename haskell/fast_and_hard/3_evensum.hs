import Data.List (foldl')
-- step 1 - imperative
evenSum1 :: [Integer] -> Integer

evenSum1 l = accumSum1 0 l

accumSum1 n l = if l == []
                  then n
                  else let x = head l 
                           xs = tail l 
                       in if even x
                              then accumSum1 (n+x) xs
                              else accumSum1 n xs


-- step 2 -- make accumsum a subfunction

evenSum2 :: [Integer] -> Integer

evenSum2 l = accumSum 0 l
		where accumSum n l = 
				if l == []
	                then n
	                else let 	x = head l 
                           		xs = tail l 
							in if even x
							then accumSum (n+x) xs
							else accumSum n xs

-- explicit braces and semicolons. Otherwise indentation is necesary
evenSum2a :: [Integer] -> Integer

evenSum2a l = accumSum 0 l
		where accumSum n l = 
				if l == []
	                then n
	                else let { 
	                	x = head l;
                        xs = tail l; 
                    } in if even x
							then accumSum (n+x) xs
							else accumSum n xs

-- pattern matching
evenSum3 :: [Integer] -> Integer
evenSum3 l = accumSum 0 l
		where 
			accumSum n [] = n
			accumSum n (x:xs) = 
				if 	even x 
					then accumSum (n+x) xs
					else accumSum n xs


-- eta-reduction
evenSum4 :: [Integer] -> Integer
evenSum4  = accumSum 0 
		where 
			accumSum n [] = n
			accumSum n (x:xs) = 
				if 	even x 
					then accumSum (n+x) xs
					else accumSum n xs


-- use higher order functions
-- filter :: (a -> Bool) -> [a] -> [a]
-- map :: (a -> b) -> [a] -> [b]
-- foldl :: (a -> b -> a) -> a -> [b] -> a
-- foldl' is strict version of foldl
evenSum5 :: [Integer] -> Integer
evenSum5 l = foldl' mysum 0 (filter even l)
		where mysum acc value = acc + value

-- use lambda
evenSum6 :: [Integer] -> Integer
evenSum6 l = foldl' (\x y -> x + y) 0 (filter even l)

-- use eta reduction
evenSum7 :: [Integer] -> Integer
evenSum7 l = foldl' (+) 0 (filter even l)

-- no braces
evenSum8 :: [Integer] -> Integer
evenSum8 l = foldl' (+) 0 (filter even l)

-- composition operator
evenSum9 :: [Integer] -> Integer
evenSum9  = (foldl' (+) 0) . (filter even)

-- composition operator

sum' :: (Num a) => [a] -> a
sum' = foldl' (+) 0

evenSum10 :: [Integer] -> Integer
evenSum10  = sum' . (filter even)

-- square even sum -- easy to extend even sum by functional composition

squareEvenSum = evenSum10 . (map (^2))

-- lazy version - will not generate any output unless used

sumx :: (Num a) => [a] -> a
sumx = foldl (+) 0

evenSum11 :: [Integer] -> Integer
evenSum11  = sumx . (filter even)





