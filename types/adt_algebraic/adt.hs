

-- 

data Tree a = Empty | Leaf a | Branch a (Tree a) (Tree a) 

-- The above declares two types - branch and leaf, which generate trees.
-- Branch                  :: Tree a -> Tree a -> Tree a
-- Leaf                    :: a -> Tree a

showTree                :: (Show a) => Tree a -> String
showTree (Empty)       =  "-"
showTree (Leaf x)       =  show x
showTree (Branch x l r)   =  show x ++ "<" ++ showTree l ++ "|" ++ showTree r ++ ">"


-- faster version
-- uses shows                   :: (Show a) => a -> String -> String

-- showsTreeF               :: (Show a) => Tree a -> String -> String
-- showsTreeF (Leaf x) s    =  shows x s
-- showsTreeF (Branch l r) s=  '<' : showsTree l ('|' : showsTree r ('>' : s))

-- cleaner version of faster version
-- uses ShowS -- see https://www.haskell.org/haskellwiki/Difference_list

-- type ShowS              =  String -> String
-- 
-- showsTree               :: (Show a) => Tree a -> ShowS
-- showsTree (Leaf x)      =  shows x
-- showsTree (Branch l r)  =  ('<':) . showsTree l . ('|':) . showsTree r . ('>':)

-- type ReadS a            =  String -> [(a,String)]
-- reads                   :: (Read a) => ReadS a

treeFromList :: (Ord a) => [a] -> Tree a
treeFromList [] = Empty
treeFromList [x] = Leaf x
treeFromList (x:xs) = Branch x (treeFromList (filter (<x) xs))
                             (treeFromList (filter (>x) xs))

main = print $ showsTree (treeFromList [7,2,4,8])


