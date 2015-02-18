
data Name = Name String
data Quest = Quest String
data Color = Color String

-- product type
data Knight = Knight { name :: Name
                     , quest :: Quest
                     , favoriteColor :: Color }

showNameQuestion :: Name -> String
showNameQuestion (Name someName) = "What is your name? My name is " ++ someName

showQuestQuestion :: Quest -> String
showQuestQuestion (Quest someQuest) = "What is your quest? " ++ someQuest

showColorQuestion :: Color -> String
showColorQuestion (Color someColor) = "What is your favorite color? " ++ someColor
    
showCharacter :: Knight -> String
{-
-- This version doesn't compile, try to uncomment to verify
showCharacter knight = showNameQuestion (favoriteColor knight) ++ "\n"
                       ++ showQuestQuestion (name knight ) ++ "\n"
                       ++ showColorQuestion (quest knight)
-}

showCharacter knight = showNameQuestion (name knight) ++ "\n"
                       ++ showQuestQuestion (quest knight ) ++ "\n"
                       ++ showColorQuestion (favoriteColor knight)

galaad = Knight { name = Name "Galaad, the pure"
                , quest = Quest "To seek the Holy Grail"
                , favoriteColor = Color "The blue... No the red! AAAAAAHHHHHHH!!!!" }

main = do
  putStrLn $ showCharacter galaad