TITLE exercise11_1.asm[exercise11_1.asm]
INCLUDE Irvine32.inc

.386

.model flat,stdcall
	
.stack 4096

ExitProcess proto,dwExitCode:DWORD  ;�ŧi proto type

DifferentInputs proto, v1:DWORD, v2:DWORD, v3:DWORD ;�ŧi proto type

.data

.code

start@0 proc

   

    invoke DifferentInputs,2,2,3

    invoke DifferentInputs,2,3,2

    invoke DifferentInputs,3,5,5

    invoke DifferentInputs,2,2,2

    invoke DifferentInputs,104522064,102403015,102403016 ; ��W�խ��Ǹ�

   

    call WaitMsg

    invoke ExitProcess,0

start@0 endp

 

DifferentInputs PROC, v1:DWORD, v2:DWORD, v3:DWORD

 

    mov eax,v1      ; ���X v1

    cmp v2,eax      ; �Pv2���      

    je  Label_Equal ; �Y�۵��h����Label_Equal,�^��0

    cmp v3,eax         ; �Pv3�����

    je   Label_Equal ; �Y�۵��h����Label_Equal,�^��0

    mov eax,v2      ; ���X v2

    cmp v3,eax        ; �Pv3�����

    je   Label_Equal ; �Y�۵��h����Label_Equal,�^��0

    mov   eax,1         ; �^��1

    jmp   exit_label  ; return true

 

Label_Equal:

    mov  eax,0      ; return false

   

exit_label:

    call DumpRegs

    ret

DifferentInputs endp

 

end start@0