#lang racket
(define (square x) (* x x))

(define (sos x y)
  (+ (square x) (square y)))

(define ex12
    (/
        (+ 5 4 (- 2 (- 3
                       (+ 6 (/ 4 5)))))
        (* 3 (- 6 2) (- 2 7))
    ))

(define (ex13 x y z)
            (if (and (< x y) (< x z))
                (sos y z)
                (if (< y z)
                    (sos x z)
                    (sos x y))))

; operators may be expressions too
  (define (a-plus-abs-b a b)
    ((if (> b 0) + -) a b))

; test of evaluation order - applicative order loops
(define (ex15)
  (define (p) (p))

  (define (test x y)
    (if (= x 0)
      0
      y))
  
  (test 0 (p)))
 
; define ex16 - why if cannot be defined in terms of cond
; new-if fails in applicative order because both clauses are evaluated
(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause)
        (else else-clause)))


(define (ex17-old-sqrt x)
    (define (abs x)
      (cond   ((< x 0) (- x))
              ((= x 0) 0)
              ((> x 0) x)))

    (define (sqrt-iter guess)
        (if (good-enough? guess)
            guess
            (sqrt-iter (improve guess))))

    (define (improve guess)
        (average guess (/ x guess)))

    (define (average x y)
        (/ (+ x y) 2))

    (define (good-enough? guess)
      (< (abs (- (square guess) x)) 0.001))
  
    (sqrt-iter 1 ))

(define (test-small)
  (ex17-old-sqrt .000001))

(define (test-large)
  (ex17-old-sqrt 100000000))

(define (ex17-new-sqrt x)

    (define (abs x)
      (cond   ((< x 0) (- x))
              ((= x 0) 0)
              ((> x 0) x)))

    (define (sqrt-iter guess old-guess)
        (if (good-enough? guess old-guess)
            guess
            (sqrt-iter (improve guess) guess)))

    (define (improve guess)
        (average guess (/ x guess)))

    (define (average x y)
        (/ (+ x y) 2))

    (define (good-enough? guess old-guess)
      (< (/ (abs (- guess old-guess)) old-guess) 0.01))
  
    (sqrt-iter 1 x))

(define (ex18-crt x)
    (define (iter guess old-guess)
        (if (good-enough? guess old-guess)
            guess
            (iter (improve guess) guess)))

    (define (good-enough? guess old-guess)
      (< (/ (abs (- guess old-guess)) old-guess) 0.01))

    (define (improve y)
        (/ (+ (/ x (* y y)) (* 2 y)) 3))
  
    (define (abs x)
      (cond   ((< x 0) (- x))
              ((= x 0) 0)
              ((> x 0) x)))
  
    (iter 1 x))