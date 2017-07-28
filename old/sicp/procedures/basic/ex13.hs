
square x = x * x

sum_of_squares x y = (square x) + (square y)

sum_of_largest_two_squares x y z 
	| x < z && y < z = sum_of_squares y z
	| y < z 		 = sum_of_squares x z
	| otherwise		 = sum_of_squares x y


main =	do
		print $ sum_of_largest_two_squares 3 5 7