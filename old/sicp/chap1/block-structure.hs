
-- sqrt implementation without block structure
square x = x * x

absL x 
    |x < 0 		= -x
    |otherwise 	= x

sqrtiter guess x 
    |goodenough guess x   = guess
    |otherwise            = sqrtiter (improve guess x) x

improve guess x = average guess (x / guess) 

average x y = (x + y) / 2

goodenough guess x = (absL ((square guess) - x)) < 0.001

sqrtL x = sqrtiter 1 x

-- sqrt implementation with local definitions, demonstrating block structure

sqrtb x = sqrtiterb 1 
    where
        sqrtiterb guess  
            |goodenough guess     = guess
            |otherwise            = sqrtiter (improve guess ) x

        improve guess  = average guess (x / guess) 

        goodenough guess  = (abs ((square guess) - x)) < 0.001

        abs y 
            |y < 0      = -y
            |otherwise  = y

        average z y = (z + y) / 2

        square y = y * y


