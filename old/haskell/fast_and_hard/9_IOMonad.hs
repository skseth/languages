import Data.Maybe

toList :: String -> [Integer]
toList input = read ("[" ++ input ++ "]")


maybeRead :: Read a => String -> Maybe a
maybeRead s = case reads s of
				[(x, "")] -> Just x
				_		  -> Nothing

getListFromString :: String -> Maybe [Integer]
getListFromString s = maybeRead $ "[" ++ s ++ "]"

-- no-do syntax
askUser_3 :: IO [Integer]
askUser_3 = putStrLn "Enter a list of numbers (separated by comma):" >>
	getLine >>= \input -> let maybelist = getListFromString input in
								case maybelist of
	  								Just l -> return l
	  								Nothing -> askUser_3

main = askUser_3 >>=
	\list -> print $ sum list


askUser_2 :: IO [Integer]
askUser_2 = do
  putStrLn "Enter a list of numbers (separated by comma):"
  input <- getLine
  let maybelist = getListFromString input in
  		case maybelist of
  			Just l -> return l -- see the return l
  			Nothing -> askUser_2


-- type : IO ()
main_2 = do
	list <- askUser_2
	print $ sum list


-- type : IO ()
main_1 = do
  -- Sting -> IO ()
  putStrLn "Enter a list of numbers (separated by comma):"
  -- IO String
  input <- getLine
  -- IO ()
  let maybelist = getListFromString input in
  		case maybelist of
  			Just l -> print (sum l)
  			Nothing -> error "Bad Format"

