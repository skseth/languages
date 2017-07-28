import System.Environment

main :: IO ()
main = getArgs >>= print . hello . head
hello s = "Hello " ++ s