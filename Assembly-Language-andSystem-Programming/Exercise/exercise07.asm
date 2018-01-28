TITLE  exercise7[exercise7.asm]
INCLUDE Irvine32.inc

main EQU start@0

.data
ninenine byte 81 DUP(?)
	
.code
start@0 PROC
	
    mov esi, OFFSET ninenine
    mov al, 0
    mov bl, 0
    mov ecx,9   ; set outer loop count
	
L1:		        ; begin the outer loop
    push ecx    ; save outer loop count
    inc al
    mov ecx, 9  ; set inner loop count
    mov bl, 0   
L2:		        ; begin the inner loop
    push ax     ; preserve the value of al 
    inc bl
    mul bl      ; ax = al*bl
    mov [esi], ax
    inc esi
    pop ax;
	
    loop L2	; repeat the inner loop

    pop ecx	; restore outer loop count
    loop L1	; repeat the outer loop

exit
start@0 ENDP
END start@0