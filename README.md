#languages

##General Learning Resources

* C
  * [Development of the C Language](http://cm.bell-labs.com/who/dmr/chist.html)

* Haskell

  * [Haskell Fast and Hard](https://www.fpcomplete.com/school/starting-with-haskell/haskell-fast-hard)
  * [What I Wish I Knew When Learning Haskell](http://www.stephendiehl.com/what/#basics)
  * [Thinking Functionally with Haskell](https://pragprog.com/magazines/2012-09/thinking-functionally-with-haskell)

* Rust
  * [Rust for Functional Programmers](http://science.raphael.poss.name/rust-for-functional-programmers.html)
  * [Cyclone regions paper - inspiration for Rust](http://www.cs.umd.edu/projects/cyclone/papers/cyclone-regions.pdf)
  * [Influences on rust](https://github.com/rust-lang/rust/wiki/Note-research)


* Scala
  * [Effective Scala](http://twitter.github.io/effectivescala/)
  * [Scala School](http://twitter.github.io/scala_school/)
  * [Scala School - Advanced Types](https://twitter.github.io/scala_school/advanced-types.html) 

* Racket
  * [PLAI](http://cs.brown.edu/courses/cs173/2012/book/book.pdf)

##Types

* Subtyping and Substitutability
  * [Types, Subtypes and Substitutability](http://undergraduate.csse.uwa.edu.au/units/CITS2210/lect7-types.pdf)
  * [Subtyping, Subclassing and the Trouble with OOPS](http://okmij.org/ftp/Computation/Subtyping/)

* Generics
  * [Generics in Java by Gilad Bracha](http://docs.oracle.com/javase/tutorial/extra/generics/intro.html)

* Algebraic Data Types
  * [Stack Overflow - Typeclass vs ADT](http://stackoverflow.com/questions/19081904/scala-difference-between-a-typeclass-and-an-adt)

* Type Classes
  * [Scala Implicits as Type Classes](http://debasishg.blogspot.in/2010/06/scala-implicits-type-classes-here-i.html)
  * [Scrap Your Type Classes](http://www.haskellforall.com/2012/05/scrap-your-type-classes.html)
  * [Instances and Dictionaries](https://www.fpcomplete.com/user/jfischoff/instances-and-dictionaries)

* Class Composition
  * [Traits as Mixins](https://gleichmann.wordpress.com/2009/07/19/scala-in-practice-traits-as-mixins-motivation/)
  * [Stackoverflow - Mixins vs Composition in Scala](http://stackoverflow.com/questions/3422606/mixins-vs-composition-in-scala)
  * [Stackable Trait Pattern](http://www.artima.com/scalazine/articles/stackable_trait_pattern.html)
  * [OO and Functional in Scala](http://debasishg.blogspot.in/2011/03/pushing-envelope-on-oo-and-functional.html)

* Patterns
  * Cake pattern
  * Visitor pattern

* Basic Terminology
  * bottom / any types
  * sum types
  * [Wikipedia - Linear types](http://en.wikipedia.org/wiki/Type_system#Linear_types)
  * reified generics
  * formal type parameters
  * type bounds
  * variance 
  * self type annotations
  * access modifiers [private this](http://stackoverflow.com/questions/9698677/privatethis-vs-private)
  * type polymorphism
  * type inference
  * view bounds
  * higher kinded types
  * recursive types
  * structural types
  * quantified types [Haskell Existentially Qualified Types](http://en.wikibooks.org/wiki/Haskell/Existentially_quantified_types)


#Collections

* Scala Collections
  * [Overview of Scala Collections Library](http://docs.scala-lang.org/overviews/collections/overview.html)
  * [Complexity of Scala Collections?](http://stackoverflow.com/questions/1722726/is-the-scala-2-8-collections-library-a-case-of-the-longest-suicide-note-in-hist)
  * [Architecture of Scala Collections Library](http://docs.scala-lang.org/overviews/core/architecture-of-scala-collections.html)

* functional combinators 
  * map
  * foreach
  * filter
  * zip
  * folds


#Functions
* partial vs total functions 
  * [Avoiding Partial Functions](https://www.haskell.org/haskellwiki/Avoiding_partial_functions)
* tail recursion
  * [recursion and tailcalls in go](http://www.goinggo.net/2013/09/recursion-and-tail-calls-in-go_26.html)
* currying
* lambdas
* closures / anonymous, boxed, unboxed 
* parametrically overloaded functions
* multi-methods / dynamic dispatch

##Basics
* values
* functions
* classes
* methods
* inheritance
* exception handling
* expression-oriented programming
* enums, case classes and sum types
* objects
* packages
* apply
* update
* functions as a type
* pattern matching
* partial functions


#Concurrency
* Concurrency in Scala (Runnable, Callable, threads, Futures)

#branching & looping
* pattern matching / destructuring
  [Rust for C Programmers-Part 8](http://featherweightmusings.blogspot.in/2014/07/rust-for-c-programmers-part-8.html
guards)
* list comprehensions
* generators

strings
=======
interpolation

complexity
----------
difference lists
expression problem

internal representations
-------------------------
Golang's interfaces
v-tables
monads in haskell (see Haskell fast ...)
https://blog.golang.org/profiling-go-programs
http://stackoverflow.com/questions/10866195/stack-vs-heap-allocation-of-structs-in-go-and-how-they-relate-to-garbage-collec
http://paulkoerbitz.de/posts/Understanding-Pointers-Ownership-and-Lifetimes-in-Rust.html

dontgohere
----------
https://www.haskell.org/haskellwiki/What_a_Monad_is_not
http://stackoverflow.com/questions/17002119/haskell-pre-monadic-i-o


#Courses

* [Coursera Programming Languages](https://www.coursera.org/course/proglang)
Syntax vs. semantics vs. idioms vs. libraries vs. tools
ML basics (bindings, conditionals, records, functions)
Recursive functions and recursive types
Benefits of no mutation
Algebraic datatypes, pattern matching
Tail recursion
First-class functions and function closures
Lexical scope
Currying
Syntactic sugar
Equivalence and effects
Parametric polymorphism and container types
Type inference
Abstract types and modules
Racket basics
Dynamic vs. static typing
Laziness, streams, and memoization
Implementing languages, especially higher-order functions
Macros
Eval
Ruby basics
Object-oriented programming is dynamic dispatch
Pure object-orientation
Implementing dynamic dispatch
Multiple inheritance, interfaces, and mixins
OOP vs. functional decomposition and extensibility
Subtyping for records, functions, and objects
Subtyping
Class-based subtyping
Subtyping vs. parametric polymorphism; bounded polymorphism



