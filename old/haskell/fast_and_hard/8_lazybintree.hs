
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


treemap::(a -> b) -> BinTree a -> BinTree b
treemap f Empty = Empty
treemap f (Node x l r) = Node (f x) (treemap f l) (treemap f r)



inttree:: BinTree Int
inttree = Node 0 (treemap (\x -> x + 1) inttree)
				 (treemap (\x -> x - 1) inttree)

treeTakeDepth _ Empty = Empty
treeTakeDepth 0 _	  = Empty
treeTakeDepth n (Node x l r) = Node x (treeTakeDepth (n-1) l) (treeTakeDepth (n-1) r)


main = print $ treeTakeDepth 4 inttree
