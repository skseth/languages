-- type inference
import Data.Complex

-- haskell is statically typed, but haskell infers most general type possible

-- Square is of type square :: Num a => a -> a, works correctly with different types
square x = x * x

main = do
		 print $ square 2 
		 print $ square 2.5 
		 print $ square (2 :+ 1)