; condition
; special form - only one expression is evaluated
(define (abs x)
  (cond   ((< x 0) (- x))
          ((= x 0) 0)
          ((> x 0) x)))


; if - may be syntactic sugar for condition or vice versa
; if <predicate> <consequent> <alternative>
(define (abs2 x)
  (if (< x 0)
      (- x)
      (x)))

