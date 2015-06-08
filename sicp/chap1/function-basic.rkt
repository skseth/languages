#lang racket

;a simple function    
(define (square x)
     (* x x))
    
; syntactic sugare for ..
(define (squarel x)
     (lambda (x)
            (* x x))


