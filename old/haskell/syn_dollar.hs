
plus::Int -> Int -> Int
plus x y = x + y

main = do
	putStrLn (show (1 + 1))
	putStrLn $ show (1 + 1)
	putStrLn $ show $ 1 + 1
	(putStrLn . show) (1 + 1)
	putStrLn . show $ 1 + 1
	putStrLn . show . (+1) $ 1
	putStrLn . show $ plus 1 1
	putStrLn . show . plus 1 $ 1
	-- wont work -- putStrLn . show . plus $ 1  1 

