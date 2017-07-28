// http://debasishg.blogspot.in/2010/02/scala-self-type-annotations-for.html

case class Trade(refNo: String, account: String, 
                 instrument: String, quantity: Int,
                 unitPrice: Int) {
  def principal = quantity * unitPrice
}

trait Taxable {
	// self type annotation ensures trait is only mixed with Trade types
	this:Trade =>
	def calculateTax = principal * 0.2
}

trait Commission {
	this:Trade =>
	def calculateCommission = principal * 0.1
}

val t = new Trade("20", "acc", "eq", 20, 1000) with Taxable with Commission

println(t.calculateTax)
println(t.calculateCommission)