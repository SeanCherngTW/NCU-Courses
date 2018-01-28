TITLE  exercise5[exercise5.asm]
INCLUDE Irvine32.inc

.data

myID byte "102403020"         ;組長的學號

size_ID = LENGTHOF myID            ;size_ID表示myID的長度

myID2 byte "102403016"        ;組員的學號

size_ID2 = LENGTHOF myID2          ;size_ID2表示myID2的長度

.code

Convert PROC USES eax ebx edx   ;Convert會改變myID的內容0-A  1-B  以此類推

    L1:

       mov al, [esi]
       
       add al,11h

       mov [esi], al

       inc esi

       loop L1

    ret

Convert ENDP

Convert2 PROC       ;Convert2功能和Convert一樣

push eax
push ebx
push edx

L1:

       mov al, [esi]

       add al, 11h

       mov [esi], al

       inc esi

       loop L1
pop edx
pop ebx
pop eax

    ret

Convert2 ENDP

start@0 PROC

  mov eax, 9999h         ;eax的值不能被改變

  mov ebx, 9999h         ;ebx的值不能被改變

  mov edx, 9999h         ;edx的值不能被改變

    mov esi, OFFSET myID

    mov ecx, size_ID	;loop 9 times

    call Convert

    mov esi, OFFSET myID2

    mov ecx, size_ID2

    call Convert2

    exit

start@0 ENDP

END start@0
