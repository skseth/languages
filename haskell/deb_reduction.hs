main = let xs :: [Int]
           xs = [4*2,5 `div` 0,5+6]
       in  print (head xs,last' xs)

last' (x:xs) = last' xs
last' [x] = x
