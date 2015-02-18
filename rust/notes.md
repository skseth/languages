language philosophy
	expression based


statements:
	let x = 5;
	let y: i32 := if x == 5 { 10 } else { 15 };
	expression statement (achieved by putting ; after expression)
	everything else is an expression, technically

expressions:
	x = 5 (returns () )
	if x < 5 { 4_us } else { return 5_us } // returns usize
	if x < 5 { x; } // returns () because semicolon converts this to a statement

functions:
	fn foo(x: i32) -> i32 {
	    if x < 5 { return x; }

	    return x + 1;
	}

comments:
	// Line comments are anything after '//' and extend to the end of the line.

	/// Doc comments : `hello` is a function that prints a greeting that is personalized based on
	/// the name given.

Flow of Control
---------------
for:
	// example - 0..10 is an iterator
	for x in 0..10 {
	    println!("{}", x); // x: i32
	}

iterators:
	http://doc.rust-lang.org/std/iter/
	// uses iterator
	for x in range(0is, 10is) {
    	println!("{}", x);
	}

	// this does bounds check on nums[i]
	let nums = vec![1i, 2i, 3i];
	for i in range(0u, nums.len()) {
	    println!("{}", nums[i]);
	}

	// iter is faster - no bounds check per access
	let nums = vec![1i, 2i, 3i];
	for num in nums.iter() {
	    println!("{}", *num); // iter returns a reference
	}

	// collect (consumer)
	let one_to_one_hundred = range(1i, 101i).collect::<Vec<int>>();

	// find
	let greater_than_forty_two = range(0i, 100i).find(|x| *x > 42);
	match greater_than_forty_two {
	    Some(_) => println!("We got some numbers!"),
	    None    => println!("No numbers found :("),
	}

	// fold 
	let sum = range(1i, 4i).fold(0i, |sum, x| sum + x);

	// count - infinite iterator -- lazy like all iterators
	std::iter::count(1i, 5i);

iterator adapters:
	// map - adapter produces a new iterator - still lazy
	range(1i, 100i).map(|x| x + 1i) 

	// filter - takes closure
	for i in range(1i, 100i).filter(|&x| x % 2 == 0) {
	    println!("{}", i);
	}

	// chain adapters
	range(1i, 1000i)
	    .filter(|&x| x % 2 == 0)
	    .filter(|&x| x % 3 == 0)
	    .take(5)
	    .collect::<Vec<int>>();

while:
	// example
	while !done {
	    x += x - 3;
	    println!("{}", x);
	    if x % 5 == 0 { done = true; }
	}

loop = while true 

break/continue

match:
	let x = 1i;
	match x {
	    1 | 2 		=> println!("one or two"), // multiple patterns
	    3 			=> println!("three"), // one value
	    4 ... 6 	=> println!("four through six {}", e), // range
	    e @ 7 ... 9 => println!("seven through nine {}", e), // range bound to name
	    f @ 10 | 11 => println!("11 or 12 {}", f), // multiple patterns bound to name
	    _ 			=> println!("anything"), // default
	}

match with enums:
	enum OptionalInt {Value(int),Missing,}
	let x = OptionalInt::Value(5i);
	// match verifies all values are tested
	match x {
        OptionalInt::Value(n) => println!("x is {}", n), // destructuring match
        OptionalInt::Missing  => println!("x is missing!"),
    }
	match x {
	    OptionalInt::Value(..) => println!("Got an int!"), // ... ignores values
	    OptionalInt::Missing   => println!("No such luck."),
	}
	match x {
	    OptionalInt::Value(i) if i > 5 => println!("Got an int bigger than five!"), // match with guards
	    OptionalInt::Value(..) => println!("Got an int!"),
	    OptionalInt::Missing   => println!("No such luck."),
	}

match with pointers:
	let x = &5i;
	match x {
	    &val => println!("Got a value: {}", val), // destructure the pointer
	}

	let x = 5i;
	match x {
	    ref r => println!("Got a reference to {}", r), // get ref to pointer
	}

	let mut x = 5i;
	match x {
	    ref mut mr => println!("Got a mutable reference to {}", mr), // mutable reference
	}

match with structs:
	struct Point {x: int,y: int,}
	let origin = Point { x: 0i, y: 0i };
	match origin {
	    Point { x: x, y: y } => println!("({},{})", x, y), // destructure struct
	}
	match origin {
	    Point { x: x, .. } => println!("({},{})", x, y), // destructure struct selectively
	}

match slice or arrays:
    let v = vec!["match_this", "1"];
    match v.as_slice() {
        ["match_this", second] => println!("The second element is {}", second),
        _ => {},
    }	

match and mix:
	match x {
	    Foo { x: Some(ref name), y: None } => ...
	}



Variables
---------

immutable: by default

mutable: let mut x = 5;
		 let (mut x, y) = (10, 12);




Types
-----
unit: ()
		can only be assigned to variables of type ()

Tuples: 
	let x: (i32, &str) = (1, "hello");

	// destructuring let
	let (x,y) = (1, "hello"); 

	// Assignment
	let x = (10, 12); 	// x: (i32, i32)
	let y = (2,3);		// y: (i32, i32)
	x = y

	// Equality - arity, values must match
	x == y

Structs:
	// record type, like tuple, but with named fields
	struct Point {
	    x: i32,
	    y: i32,
	}

	// let initialization
	let origin = Point { x: 0, y: 0 };

	// mutable
	let mut origin = Point { x: 0, y: 0 };
	point.x = 5

Tuple Structs:
	// named tuples
	struct Color(i32, i32, i32)

	// assignment
	let black  = Color(0, 0, 0);

	// type synonyms
	struct Inches(i32);
	let length = Inches(10);

	// destructuring tuple structs
	let length = Inches(10);
	let Inches(x) = length // x = 10

Enums: 
	// Sum type
	enum Ordering {
    	Less,
    	Equal,
    	Greater,
	}

	// usage
	use std::cmp::Ordering;

	fn cmp(a: i32, b: i32) -> Ordering {
	    if a < b { Ordering::Less }
	    else if a > b { Ordering::Greater }
	    else { Ordering::Equal }
	}

	// enum with variants having multiple values
	enum StringResult {
	    StringOK(String),
	    ErrorReason(String),
	}

	// usage of value enums
    if greeting == "Hello" {
        StringOK("Good morning!".to_string())
    } else {
        ErrorReason("I didn't understand you!".to_string())
    }


Arrays, Vectors, and Slices
---------------------------

	// array type is [T; N] - i.e. length is part of type
	// slice type is &[T]
	// arrays are bound-checked on access
	// immutable array
	let a = [1, 2, 3];     // a: [i32; 3]

	// mutable arrays
	let mut m = [1, 2, 3]; // mut m: [i32; 3]

	// a.len(), a.iter(), a[i]
	for i in a.iter() {...}

	// vector is growable array - type Vec<T>
	let v = vec![1, 2, 3]; // v: Vec<i32>

	let mut nums = vec![1, 2, 3]; // mut nums: Vec<i32>

	// slice - view into array
	let a = [0, 1, 2, 3, 4];
	let middle = a.slice(1, 4);     // A slice of a: just the elements [1,2,3]

	// slice iteration
	for e in middle.iter() {
    	println!("{}", e);          // Prints 1, 2, 3
	}

	// vector from slice
    let my_list: &mut [u8] = &mut [0,1,2,3,4,5];
    let mut vec1 = Vec::from_slice(my_list.slice(0, 3));
    let mut vec2 = Vec::from_slice(my_list.slice(3, 6));

    println!("{}", vec1.as_slice());
    println!("{}", vec2.as_slice());

    // slices of &str


Strings
-------

Pointers
--------

http://doc.rust-lang.org/book/pointers.html#cheat-sheet
http://doc.rust-lang.org/book/ownership.html
https://github.com/rust-lang/rfcs/blob/master/text/0141-lifetime-elision.md

Problems : uninitialised pointers, dangling pointers, aliasing

Reference (Immutable): one or more references
	&T 

	ref in patterns
	fn possibly_print(x: &Option<String>) {
	    match *x {
	        // BAD: cannot move out of a `&`
	        Some(s) => println!("{}", s)

	        // GOOD: instead take a reference into the memory of the `Option`
	        Some(ref s) => println!("{}", *s),
	        None => {}
	    }
	}

Mutable Reference: single ref to r/w
	&mut T

Box: heap allocated, single owner
	Like malloc/free but
		type decides allocation
		free decision is definite, based on scope
		use-after-free not possible
		no aliases are possible to same memory - unless moved
	Usage: Recursive data structures, and occasionally, when returning data

	Box<T>
	let box_x = Box::New(5is)
	let mut mbox_x = Box::New(5is)
	let ref_x = &*box_x // immutable borrow
	let m_ref_x = &mut *mbox_x // mutable borrow
	let mut moved_box_x = box_x // box_x has been moved - and x is now mutable

	Recursive Data Structures (or generally, types of unknown size)
	#[derive(Show)]
	enum List<T> {
	    Cons(T, Box<List<T>>),
	    Nil,
	}

	preferred pattern for return - here rust will efficiently return large value
	Not clear how ... TODO
	foo(...) -> LargeStruct
	usage :Box::new(foo(..))

Rc - RefCounted: heap allocated - many readers
	TODO
	Rc<T>

Arc - like Rc, but thread-safe
	TODO
	Arc<T>

Raw - unsafe read access
	TODO
	*const T

Mutable Raw - unsafe write access
	TODO
	*mut T

Custom Pointers
	TODO

Ownership

Elided Lifetimes

Methods
-------

	struct Circle {x: f64,y: f64,radius: f64,}
	impl Circle {
		fn new(x: f64, y: f64, radius: f64) -> Circle {
			Circle {x: x,y: y,radius: radius,}
		}
	    fn area(&self) -> f64 {
	        std::f64::consts::PI * (self.radius * self.radius)
	    }
	}
	fn main() {
	    let c = Circle::new(0.0, 0.0, 2.0);
	    println!("{}", c.area());
	}

Closures
--------
	TODO : Not clear
	https://github.com/rust-lang/rfcs/blob/master/text/0114-closures.md

	// closure with one param
	let add_one = |&: x| { 1 + x };
	println!("The sum of 5 plus 1 is {}.", add_one(5));

	// closure with no param, but closing over local var
    let x: i32 = 5;
    let printer = |&:| { println!("x is: {}", x); };
    printer(); // prints "x is: 5"

    // passing closures as arguments
    fn twice<F: Fn(i32) -> i32>(x: i32, f: F) -> i32 {
	    f(x) + f(x)
	}
	fn main() {
	    let square = |&: x: i32| { x * x };

	    twice(5, square); // evaluates to 50
	}


    // moving closure - TODO
    // boxed - unboxed closures

Generics
--------


Traits
------
http://doc.rust-lang.org/book/traits.html - TODO
	monomorphization, statically dispatched


Modules
-------


Macros
------
	println!(...)
	vec![...]


IO
--
use std::io;

fn main() {
    println!("Type something!");

                                                  // here, we'll show the types at each step

    let input = io::stdin()                       // std::io::stdio::StdinReader
                  .read_line()                    // IoResult<String>
                  .ok()                           // Option<String>
                  .expect("Failed to read line"); // String

    println!("{}", input);
}




