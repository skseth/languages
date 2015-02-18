

fn tree_from_list(items:Vec<isize>) -> Option<&isize> {
	let i = items.len();

	return items[0];
}

fn main() {
	let treelist = vec![7,2,2,8];

	let retval = tree_from_list(treelist);

	match retval {
		None => println!("found nothing"),
		Some(&x) => println!("Test {0}", *x)
	}
	
}