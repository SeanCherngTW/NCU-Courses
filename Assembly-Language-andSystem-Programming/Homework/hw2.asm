TITLE  hw2[hw2.asm]
INCLUDE Irvine32.inc

main EQU start@0
.data
    ChStrs BYTE "########"
           BYTE "#       "
           BYTE "#       "
           BYTE "########"
           BYTE "       #"
           BYTE "       #"
           BYTE "       #"  ;" " = 20h, "#" = 23h
           BYTE "########"  ;the last digit of my ID is 10240301"5"
		   
    BitStrs BYTE 8 dup(?)
	
.code
change PROC uses ecx
    mov ecx, 8
    mov bx, 0
 
L2:
    mov al, [esi]			; al = " " or "#"
    shl bl, 1
    cmp al, 20h				; ZF = 1 when " ", ZF = 0 when "#"
    jz L3					; al = " "
    jnz L4					; al = "#"
L3:
    mov al, 30h				; switch " " to 0
    add bl, 0
    jmp L5
L4:    
    mov al, 31h				; switch "#" to 1
    add bl, 1
    jmp L5
L5:
    call WriteChar			; print al
    inc esi					; point to the next value of ChStrs
    Loop L2
    mov [edi], bl
    inc edi
    CALL Crlf
    RET
change ENDP

main PROC
    mov ecx, 8				; loop 8 times
    mov esi, OFFSET ChStrs
    mov edi, OFFSET BitStrs
	
L1:
    CALL change				;loop change for 8 times
    LOOP L1
    CALL WaitMsg
	
main ENDP
END main