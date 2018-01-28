TITLE exercise12.asm[exercise12.asm]
INCLUDE Irvine32.inc

Str_copyN PROTO,
    source:PTR DWORD,   ; source string address
    target:PTR DWORD,   ; target string address
    maxChars:DWORD      ; maximum number of characters to copy

.data
	string_1 BYTE "102403016",0    ;填入組員1學號
	string_2 BYTE "102403020",0    ;填入組員2學號

.code
start@0 PROC
    INVOKE Str_copyN,       ; copy string_1 to string_2
      ADDR string_1 ,        
      ADDR string_2 + 9,     
      (SIZEOF string_2) - 1 ; save space for null byte
; Display the destination string
    mov  edx,OFFSET string_2
    call WriteString
    call Crlf
    call WaitMsg
    exit
start@0 ENDP 

Str_copyN PROC USES eax ecx esi edi,
    source:PTR DWORD,        ; source string
    target:PTR DWORD,        ; target string
    maxChars:DWORD      	 ; max chars to copy
; Copy a string from source to target, limiting the number
; of characters to copy. Value in maxChars does not include
; the null byte.

    mov ecx,maxChars		; set counter for REP
    mov esi,source			; assign source
    mov edi,target			; assign target
    cld               		; direction = forward
; (clear direction flag)
    rep movsb          		; copy the string
    mov al,0            	; set null byte
    stosb             		; append null byte
    ret
Str_copyN ENDP
END start@0