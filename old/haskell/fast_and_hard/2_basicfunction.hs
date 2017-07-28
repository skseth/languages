
-- f :: Num a => a -> a -> a
-- Num is a typeclass
-- a is a typevariable
-- Let a be a type belonging to Num typeclass. 
-- f is a function which takes a and converts it to another function of type (a -> a)

f :: Int -> Int -> Int

f x y = x * y

g :: Float -> Float -> Float
g x y = x * y

-- currying
h = g 3

-- lambda function
l = \y -> 3*3 + y*y

main = do
	print $ f 2 3
	--wont work main = print $ f 2.2 3.3
	print $ g 2.2 3.3
	-- wont work print $ g "a" "b"
	print $ g 2 3 -- works auto conversion from integer to float 
	print $ h 10
	print $ l 10


