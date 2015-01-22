
// string interpolators s, f and raw

val name = "Sam"
val add = "BLR"
val height = 180;

// s does interpolation + escapes special characters with \
println(s"$name lives in $add and height is ${height / 30} ft.\n\n")
println(f"$name lives in $add and height is ${height / 30}%2.2f ft")

// type safe interpolation - following gives error
//println(f"$name%2.2f")
// raw does interpolation but does not escapes special characters
println(raw"$name lives in $add and height is ${height / 30} ft.\n\n")



