TITLE  hw4[hw4.asm]
INCLUDE Irvine32.inc

main EQU start@0

CountMatches PROTO, 
	arr1:PTR SDWORD,
	arr2:PTR SDWORD,
	count:DWORD 
	
.data
	array1 SDWORD 10,5,4,-6,2,11,12
	array2 SDWORD 10,5,3,1,4,2,-6
		
.code
CountMatches PROC,
	arr1: PTR SDWORD, arr2: PTR SDWORD, count: DWORD
	mov esi, arr1
	mov edi, arr2
	mov eax, 0
	mov ecx, count
L1:
	mov ebx,[esi]
	mov edx,[edi]
	cmp ebx,edx
	jne L2
	inc eax
L2:
	add esi, 4
	add edi, 4
	LOOP L1
	
	ret
CountMatches ENDP

main PROC
	INVOKE CountMatches, ADDR array1, ADDR array2, LENGTHOF array1
main ENDP
END main