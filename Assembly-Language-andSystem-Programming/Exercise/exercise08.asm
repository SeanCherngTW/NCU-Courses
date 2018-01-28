TITLE exercise8[exercise8.asm]
INCLUDE Irvine32.inc

.data

    myID DWORD 102403020d  ;任一人的學號(十進位)

    size_ID = 9       ;size_ID表示myID的長度

    space byte 1,0,2,4,0,3,0,2,0

    myID_result byte "_________", 0 ;任一人的學號(字串)

.code

convert MACRO IDbefore,IDsize,IDafter

    IFB <IDbefore>
        EXITM
    ENDIF
    IFB <IDsize>	
        EXITM
    ENDIF

    mov ecx,IDsize
    mov esi,OFFSET IDbefore
    mov edi,OFFSET IDafter
L1:
    mov dx,0
    mov ax,[esi]
    mov bx,2
    div bx
    and dx,1
    
    jz L2
    mov al,"A"     ;odd
    mov [edi],al
    jnz L3
L2:
    mov al,"B"     ;even
    mov [edi],al
L3:
    inc esi
    inc edi
LOOP L1
    

ENDM

start@0 PROC

    mov eax, myID

    call WriteDec

    call Crlf

    convert space, size_ID, myID_result

    mov edx, OFFSET myID_result

    call WriteString

    call Crlf

    call WaitMsg

    exit

start@0 ENDP

END start@0