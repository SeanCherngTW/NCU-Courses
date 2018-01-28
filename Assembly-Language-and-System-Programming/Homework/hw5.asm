TITLE  hw5[hw5.asm]
INCLUDE Irvine32.inc

Str_nextWord PROTO,
	pString:PTR BYTE,	;pointer to string
	delimiter:BYTE		;delimiter to find
	
.data
	testStr BYTE "I_am_a_student",0
	
.code
Str_nextWord PROC,
	ptrString: PTR BYTE, delimiterChar: BYTE
	mov al, delimiterChar
	mov edi, ptrString
L2:
	mov dl, [edi]
	inc edi
	cmp dl, 0		;end of the string?
	je L4
	cmp dl, al		;meet the delimiter?
	jne L2
L3:
	mov BYTE PTR [edi-1], 0
	mov eax, [edi]
	jmp Exit_Proc
L4: 
	OR al, 1		;clear ZF
Exit_Proc:
	ret
Str_nextWord ENDP

start@0 PROC
	call Clrscr
	mov edx, OFFSET testStr	;display starting string
	call WriteString 
	call Crlf
;Loop through the string, replace each delimiter, and
;display the remaining string.
	mov esi, OFFSET testStr
L1:
	INVOKE Str_nextWord, esi, "_" ;look for delimiter
	jnz Exit_prog		;quit if not found
	mov esi, edi		;point to next substring
	mov edx, esi		;edx must be a pointer
	call WriteString	;display remainder of string
	call Crlf
	jmp L1
Exit_prog:
	call WaitMsg
	exit
start@0 ENDP
end start@0

