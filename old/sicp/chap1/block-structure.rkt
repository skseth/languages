#lang racket
; sqrt implementation without block structure

(define (square x)
     (* x x))

(define (abs x)
  (cond   ((< x 0) (- x))
          ((= x 0) 0)
          ((> x 0) x)))

(define (sqrt-iter guess x)
    (if (good-enough? guess x)
        guess
        (sqrt-iter (improve guess x) x)))

(define (improve guess x)
    (average guess (/ x guess)))

(define (average x y)
    (/ (+ x y) 2))

(define (good-enough? guess x)
    (< (abs (- (square guess) x)) 0.001))

(define (sqrt x )
    (sqrt-iter 1 x))


; sqrt with block structure
; all definitions are local

(define (sqrtb x)
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

