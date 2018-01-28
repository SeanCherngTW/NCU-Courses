TITLE  hw1[hw1.asm]
INCLUDE Irvine32.inc

main EQU start@0

.data
	MyID WORD ?        ;2byte
	Digit0 BYTE 3h     ;1byte
	Digit1 BYTE 0h
	Digit2 BYTE 1h
	Digit3 BYTE 5h
	
.code
main PROC
	mov CL, 4
	movzx ax, Digit0	;ax(16 bit) = Digit0(8 bit)
	mov MyID, ax		;MyID = ax
	shl MyID, CL		;MyID *= 4 
	movzx ax, Digit1	;ax(16 bit) = Digit1(8 bit)
	add MyID, ax		;MyID += ax
	shl MyID, CL		;MyID *= 4
	movzx ax, Digit2	;ax(16 bit) = Digit2(8 bit)
	add MyID, ax		;MyID += ax
	shl MyID, CL		;MyID *= 4
	movzx ax, Digit3	;ax(16 bit) = Digit3(8 bit)
	add MyID, ax		;MyID += ax
	ret					;return
main ENDP
END main