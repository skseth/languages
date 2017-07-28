#lang racket

(define (inc x) (+ x 1))
(define (dec x) (- x 1))


; shape of process
; r+ is recursive, i+ is iterative
(define (ex1_9)
    (define (r+ a b)
        (if (= a 0)
            b
            (inc (r+ (dec a) b))))

    (define (i+ a b)
        (if (= a 0)
            b
            (i+ (dec a) (inc b))))
   (list (r+ 3 4) (i+ 3 4)))




; Ackermann's function
(define (ex1_10)
    (define (A x y)
        (cond   ((= y 0) 0)
                ((= x 0) (* 2 y))
                ((= y 1) 2)
                (else (A (- x 1) (A x (- y 1))))))
    ; f n = 2n
    (define (f n) (A 0 n))
    ; g n = f(A 0 (n-1)) = .. f^n-1(A 0 1) = f^n-1(2) = 2^n
    (define (g n) (A 1 n))
    ; h n = g(A 2 n-1) = g^n-1(A 2 1) = 2^(2^(2^..n times
    (define (h n) (A 2 n))
    (list (A 1 10) (A 2 4) (A 3 3) (h 2) (g 3) (h 3) ))


(define (ex1_11)
    (define (fnr n)
        (if (< n 3)
            n
            (+ (fnr (- n 1)) (fnr (- n 2)) (fnr (- n 3)))))
    (define (fni n)
        (define (iter a b c counter)
            (if   (= counter n)
                  c
                  (iter b c (+ a b c) (+ counter 1))))
        (if (< n 3)
            n
            (iter 0 1 2 2)))
    (list (fnr 10) (fni 10)))


; choose n k = choose (n-1) k + choose (n-1) (k-1)
; why : wikipedia has nice explanation
; fix an element x in n. there are 2 ways you can choose k elements from n
;    either x is included : choose (n-1) (k-1) ways
;    or x is excluded : choose (n-1) k ways

(define (choose n k) 
  (cond ((= k 0) 1)
        ((= k n) 1)
        (else (+ (choose (- n 1) (- k 1)) (choose (- n 1) k)))))


