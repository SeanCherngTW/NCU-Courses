TITLE  exercise4[exercise4.asm]
INCLUDE Irvine32.inc

main EQU start@0

.data
ninenine BYTE 9 DUP(?)

.code
main PROC
    mov ecx, LENGTHOF ninenine
    mov esi, OFFSET ninenine
    mov al, 0					; initiate al = 0
L:
    add al, 9					; al += 9
    mov [esi], al				; [esi] = al
    inc esi						; esi points to next byte
    loop L
	
exit
main ENDP
END main
