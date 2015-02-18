package main

import (
	"fmt"
	"strconv"
)

type Tree interface {
	IsNil() bool
	IsLeaf() bool
}

type NilTree struct{}

func (n *NilTree) IsLeaf() bool {
	return true
}

func (n *NilTree) IsNil() bool {
	return true
}

type Leaf struct{}

func (l *Leaf) IsLeaf() bool {
	return true
}

func (l *Leaf) IsNil() bool {
	return false
}

type Branch struct {
	Tree
	Left  Tree
	Right Tree
}

func (b *Branch) IsLeaf() bool {
	return false
}

func (b *Branch) IsNil() bool {
	return false
}

// Int Nodes
type IntValue struct {
	Value int
}

type IntNode struct {
	Branch
	IntValue
}

type IntLeaf struct {
	Leaf
	IntValue
}

func splitInts(vals []int, x int) ([]int, []int) {
	right := make([]int, len(vals), len(vals))
	rightlen := 0
	leftlen := 0

	for i := 0; i < len(vals); i++ {
		val := vals[i]
		if val < x {
			vals[leftlen] = val
			leftlen++
		} else {
			right[rightlen] = val
			rightlen++
		}
	}

	copy(vals[leftlen:], right[0:rightlen])

	return vals[0:leftlen], vals[leftlen:]
}

func treeFromList(vals []int) Tree {
	switch len(vals) {
	case 0:
		return &NilTree{}
	case 1:
		retval := IntLeaf{}
		retval.Value = vals[0]
		return &retval
	default:
		retval := IntNode{}
		retval.Value = vals[0]
		l, r := splitInts(vals[1:], retval.Value)
		retval.Left = treeFromList(l)
		retval.Right = treeFromList(r)
		return &retval
	}
}

func showTree(t Tree) string {
	switch tr := t.(type) {
	case *NilTree:
		return "-"
	case *IntLeaf:
		return strconv.Itoa(tr.Value)
	case *IntNode:
		return strconv.Itoa(tr.Value) + "<" + showTree(tr.Left) + "|" + showTree(tr.Right) + ">"
	}
	return ""
}

func main() {
	vals := []int{7, 2, 4, 8}

	tree := treeFromList(vals)

	fmt.Println(showTree(tree))
}
