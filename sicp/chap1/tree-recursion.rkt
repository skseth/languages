#lang racket 
; fibonacci - tree recursion
; very inefficient 
; running time complexity = Fib(n) which is exponential 

(define (fib n)
    (cond   ((= n 0) 0)
            ((= n 1) 1)
            ((> n 1) (+ (fib (- n 1)) (fib (- n 2))))))

; iterative - exactly n steps
(define (fibi n)
    (define (iter a b count)
        (if (= count 0)
           b
           (iter (+ a b) a (- count 1))))
    (iter 1 0 n))



; counting change ex 3.27 implements memoization
; without memoization this is exponential

(define (count-change amount coinidx)
    (define (valof idx)
        (cond   ((= idx 1) 1)
                ((= idx 2) 5)
                ((= idx 3) 10)
                ((= idx 4) 25)
                ((= idx 5) 50)))
    (cond   ((= amount 0) 1)
            ((< amount 0) 0)
            ((= coinidx 0) 0)
            (else (+ (count-change amount (- coinidx 1))
                     (count-change (- amount (valof coinidx)) coinidx)))))




