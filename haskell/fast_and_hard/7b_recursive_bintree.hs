
data BinTree a = Empty
					| Node a (BinTree a) (BinTree a)
						deriving (Eq, Ord)

treeFromList :: (Ord a) => [a] -> BinTree a
treeFromList [] 	= Empty
treeFromList (x:xs) = Node x (treeFromList (filter (<x) xs))
                             (treeFromList (filter (>x) xs))



instance (Show a) => Show (BinTree a) where
	show t = (treeshow "" t)
	  where
	    treeshow p Empty 		= emptyShow p
	    treeshow p (Node x l r)	= nodeShow p x l r
	    emptyShow p = printNode p "_"
	    nodeShow p x l r = 
	    	(printNode p (show x)) ++ (treeshow (incdepth p) l) ++ (treeshow (incdepth p) r)
 	    incdepth p = p ++ "--"
	    printNode p d = p ++ d ++ "\n"


main = do
	print $ treeFromList [7,2,4,8]
	print $ treeFromList
           (map treeFromList ["baz","zara","bar"])
	print $ (treeFromList . map (treeFromList . map treeFromList))
	     [ ["YO","DAWG"]
	     , ["I","HEARD"]
	     , ["I","HEARD"]
	     , ["YOU","LIKE","TREES"] ]

