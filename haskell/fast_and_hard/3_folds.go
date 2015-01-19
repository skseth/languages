package main

import (
	"fmt"
)

type intfunc func() int
type intbinfunc func(intfunc, intfunc) intfunc

func foldr(acc intfunc, fn intbinfunc, list []int) intfunc {
	if len(list) == 0 {
		return acc
	} else {
		return fn(lazyint(list[0]), foldr(acc, fn, list[1:]))
	}
}

func foldl(acc intfunc, fn func(intfunc, intfunc) intfunc, list []int) intfunc {
	if len(list) == 0 {
		return acc
	} else {
		return foldl(fn(acc, lazyint(list[0])), fn, list[1:])
	}
}

func foldls(acc intfunc, fn func(intfunc, intfunc) intfunc, list []int) intfunc {
	if len(list) == 0 {
		return acc
	} else {
		accfn := fn(acc, lazyint(list[0]))
		accfn() // force evaluation of closure early
		return foldls(accfn, fn, list[1:])
	}
}

var nestlevel = 0

func print(i interface{}) {
	fmt.Print(i)
}

func lazyint(x int) intfunc {
	iscalculated := false
	return func() int {
		if !iscalculated {
			print(x)
			if nestlevel == 0 {
				print("\n")
			}
			iscalculated = true
		}

		return x
	}
}

func lazysum(x intfunc, y intfunc) intfunc {
	iscalculated := false
	retval := 0
	//xval := x()
	//yval := y()
	return func() int {
		if !iscalculated {
			nestlevel++
			print("(")
			xval := x()
			//			print("_")
			//			print(xval)
			print(",")
			yval := y()
			//			print("_")
			//			print(yval)
			print(")")
			retval = xval + yval
			print("=")
			print(retval)
			nestlevel--
			if nestlevel == 0 {
				print("\n")
			}
			iscalculated = true
		} else {
			print(retval)
			if nestlevel == 0 {
				print("\n")
			}
		}

		return retval
	}
}

func main() {
	vals := []int{1, 2, 3, 4}

	foldr(lazyint(0), lazysum, vals)()
	foldl(lazyint(0), lazysum, vals)()
	foldls(lazyint(0), lazysum, vals)()
	//fmt.Println(foldr(lazyint(0), lazysum, vals)())
	//fmt.Println(foldls(lazyint(0), lazysum, vals)())
}
