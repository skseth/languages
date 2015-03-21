#lang racket

;terminology
;S-expression = atom | list
;list = (atom atom atom ... )



(define atom?
    (lambda (x)
        (and (not (pair? x)) (not (null? x)))))


(atom? 'atom)
(atom? 'turkey)
(atom? 1492)
(atom? 'u)
(atom? '*abc$)
(list? '(atom))
(list? '(atom turkey or))
(list? '((atom turkey) or))
(list? '())
(atom? '())
(list? '(() () ()))
(car '(a b c))
(car '((a b c) x y z))
(car (cdr 
       '((b) (x y) ((c)))))
(cons 'peanut '(butter and jelly))
(cons '(banana and) '(peanut butter and jelly))