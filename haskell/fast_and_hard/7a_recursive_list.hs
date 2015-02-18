
-- 5 is priority
infixr 5 :::

data List a = Nil | a ::: (List a)
			  deriving (Show, Read, Eq, Ord)

convertList [] 		= Nil
convertList (x:xs)	= x ::: convertList xs


main = do
	print (0 ::: 1 ::: Nil)
	(print . convertList) [0,1]
