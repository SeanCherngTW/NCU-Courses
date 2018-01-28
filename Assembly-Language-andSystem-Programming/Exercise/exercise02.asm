TITLE  exercise2[exercise2.asm]
INCLUDE Irvine32.inc

main EQU start@0

.data
	Val1 SBYTE 03h
	Val2 SBYTE 02h
	Val3 SBYTE 8fh
	Rval SDWORD ?
.code
main PROC
	movsx ax,Val1
	movsx bx,Val2

	;Rval = -(Val3 - 14 * (Val1 + Val2))

	add ax,bx	; ax=Val1+Val2
	shl ax,1	; ax=2*(Val1+Val2)
	mov bx,ax	; bx=2*(Val1+Val2)
	shl bx,1	; bx=4*(Val1+Val2)
	add ax,bx	; ax=6*(Val1+Val2)
	shl bx,1	; bx=8*(Val1+Val2)
	add ax,bx	; ax=14*(Val1+Val2)
	movsx cx,Val3	; cx=Val3
	sub cx,ax	; cx=Val3-14*(Val1+Val2)
	neg cx		; cx=-(Val3 - 14 * (Val1 + Val2))
	movsx eax,cx
	mov Rval,eax
main ENDP
END main