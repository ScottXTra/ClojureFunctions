

; Counts the number of words in a sentnece
(require '[clojure.string :as str])
(defn countWordsInSentence [sentence]
    (count (str/split sentence #"\s+")))

; returns a new list that is the input sequence with 1 added to every element
(defn tripleEveryElement [sequence]
     (map inc sequence))

; returns a list of n random numbers between a and b
(defn getNRandomNumbersBetween [a b n]
    (take n (repeatedly #(int (+ a (rand (- b a))))))
)

(defn commaDelimit [seqOfStrings]
    (interpose "," seqOfStrings))

; borrowed from the internet but now I understand it after 30 minuites of reading 
(def english-alphabet
  (seq "abcdefghijklmnopqrstuvwxyz"))
  
(defn rot13 [alphabet text]
  (let [cipher (->> (cycle alphabet)(drop 13)(take 26)(zipmap alphabet))]
    (apply str (replace cipher text))))



; apperently some interveiwers use this as a challange to check if you can code

(defn fizzbuzz []
(doseq [x (range 1 101)] 
      (def word (str (when (zero? (mod x 3)) "fizz") (when (zero? (mod x 5)) "buzz")))
      (println (if (empty? word) x word ))
))

; this leet code problem https://leetcode.com/problems/find-the-duplicate-number/

; I also coded it in asembler to assert dominance
; https://leetcode.com/problems/find-the-duplicate-number/discuss/1058222/x64asm-the-way-god-intended-(cycle-method)

;int findDuplicate(int* nums, int numsSize){
;   __asm("movl    (%rdi), %ecx\n"
;       " movl    %ecx, %eax\n"
;        "movl    %ecx, %edx");
;    __asm("LBB0_1:");    
;    
;    __asm("movslq  %eax, %rax\n"
;        "movl    (%rdi,%rax,4), %eax\n"
;        "movslq  %edx, %rdx\n"
;        "movslq  (%rdi,%rdx,4), %rdx\n"
;        "movl    (%rdi,%rdx,4), %edx\n"
;        "cmpl    %edx, %eax\n"
;        "jne     LBB0_1\n"
;        "cmpl    %eax, %ecx\n"
;        "jne     LBB0_2\n"
;        "movl    %ecx, %eax\n"
;        "jp END");
;    __asm("LBB0_2:");  
;    __asm("movslq  %ecx, %rcx\n"
;        "movl    (%rdi,%rcx,4), %ecx\n"
;        "movslq  %eax, %rax\n"
;        "movl    (%rdi,%rax,4), %eax\n"
;        "cmpl    %eax, %ecx\n"
;        "jne     LBB0_2\n"
;        "jp END");
;     __asm("END:"); 
;    return ;
    
; even works with multiple duplicates which is more than the problem posed
(defn findDuplicate [numbers] (map key (remove (comp #{1} val) (frequencies numbers))))
  