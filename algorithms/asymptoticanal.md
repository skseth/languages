#O-Notation

* Suppress lower-order terms and constant factors
* Merge-Sort : O(n log n), n = input array size
* Find an item in array = O(n)
* Find a duplicate item in an arry = O(n^2)

#Formal Definitions

there exists c, N > 0 s.t. T(n) <= c.f(n) for all n > N, then

T(n) = O(f(n))

c, N are independent of n.

#T(n) = P(n^k), T(n) = O(n^k)

Choose N = 1, c = |a_i| for i = 0..k

T(n) <= |a_k| n^k + |a_k-1| n^(k-1) ... + |a_0|
     <= |a_k| n^k + |a_k-1| n^k ... + |a_0|n^k (since n > 1)
     <= c.n^k
     = O(n^k)

#Omega or Theta

Omega:T(n) >= c.f(n)

Theta:T(n) = c_1.f(n) and c_2.f(n)

#Little-O notation
T(n) < c.f(n)

#max(f(x),g(x)) = theta(f(x) + g(x))
max(f(x),g(x)) <= f(x) + g(x)
2.max(f(x),g(x)) >=  f(x) + g(x)







