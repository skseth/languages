{-# LANGUAGE ExistentialQuantification #-}
data Foo = forall a. Foo a
ignorefoo f = 1 where Foo a = f