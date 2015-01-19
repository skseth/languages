-- type alias - just another name
type Name = String
type Color = String

showInfos :: Name -> Color -> String
showInfos name color = "Name: " ++ name
						++ ", Color: " ++ color

name :: Name
name = "Robin"

color :: Color
color = "Blue"


data NameD   = NameConstr String
data ColorD  = ColorConstr String

showInfosD :: NameD ->  ColorD -> String
showInfosD (NameConstr name) (ColorConstr color) =
      "Name: " ++ name ++ ", Color: " ++ color

nameD  = NameConstr "Robin"
colorD = ColorConstr "Blue"

-- see that types are interchangable
-- for type safety you need data
main = do
		putStrLn $ showInfos name color
		putStrLn $ showInfos color name
		putStrLn $ showInfosD nameD colorD
		--putStrLn $ showInfosD colorD nameD
		-- previous line will give error

