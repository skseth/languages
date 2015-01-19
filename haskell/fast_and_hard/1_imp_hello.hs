-- from https://www.fpcomplete.com/school/starting-with-haskell/haskell-fast-hard/haskell-fast-hard-part-3

-- function we want
-- evenSum :: [Integer] -> Integer
-- 
-- evenSum l = accumsum 0 l
-- 
-- accumsum n l = if l == []
					-- then n
					-- else 	let x = head l
							 	-- xs = tail l
							-- in if even x
								-- then accumsum (n + x) xs
								-- else accumsum n xs
-- 
-- main = print $ evenSum [1..10]

main = do
    print "What is your name?"
    name <- getLine
    print ("Hello " ++ name ++ "!")


