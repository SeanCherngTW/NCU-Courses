TITLE  exercise5[exercise5.asm]
INCLUDE Irvine32.inc

.data

myID byte "102403020"         ;�ժ����Ǹ�

size_ID = LENGTHOF myID            ;size_ID���myID������

myID2 byte "102403016"        ;�խ����Ǹ�

size_ID2 = LENGTHOF myID2          ;size_ID2���myID2������

.code

Convert PROC USES eax ebx edx   ;Convert�|����myID�����e0-A  1-B  �H������

    L1:

       mov al, [esi]
       
       add al,11h

       mov [esi], al

       inc esi

       loop L1

    ret

Convert ENDP

Convert2 PROC       ;Convert2�\��MConvert�@��

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

  mov eax, 9999h         ;eax���Ȥ���Q����

  mov ebx, 9999h         ;ebx���Ȥ���Q����

  mov edx, 9999h         ;edx���Ȥ���Q����

    mov esi, OFFSET myID

    mov ecx, size_ID	;loop 9 times

    call Convert

    mov esi, OFFSET myID2

    mov ecx, size_ID2

    call Convert2

    exit

start@0 ENDP

END start@0
