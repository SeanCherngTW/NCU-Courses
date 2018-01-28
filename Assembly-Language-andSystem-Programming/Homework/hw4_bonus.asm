TITLE  hw4_bonus[hw4_bonus.asm]
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
	mov eax, 0
	mov ecx, count
L1:
	push ecx		;nested loop
	mov ebx,[esi]
	mov ecx, count
	mov edi, arr2	;point to the first element in arr2
L2:
	mov edx,[edi]
	cmp ebx,edx
	jne L3
	inc eax
L3:
	add edi, 4		;point to the next element in arr2
	LOOP L2
	pop ecx

	add esi, 4		;point to the next element in arr1
	LOOP L1
	ret
CountMatches ENDP

main PROC
	INVOKE CountMatches, ADDR array1, ADDR array2, LENGTHOF array1
main ENDP
END main