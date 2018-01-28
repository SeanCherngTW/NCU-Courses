TITLE  exercise6[exercise6.asm]
INCLUDE Irvine32.inc

main EQU start@0
.data
    ChStrs BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­"
           BYTE "¡­¡°
    BitStrs BYTE 8 dup(?)
.code
change PROC
//ÑeÃæ×÷ChStrµÄÞD“Q
RET
change ENDP
main PROC
MOV CX,8
L1:
CALL change
LOOP L1
main ENDP
END main