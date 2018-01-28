TITLE exercise15[exercise15.asm]
INCLUDE Irvine32.inc

main EQU start@0

.data

consoleHandle    DWORD ?

xyInit COORD <20,15> ; 起始座標

xyBound COORD <80,25> ; 一個頁面最大的邊界

xyPos COORD <?,?> ; 現在的游標位置

 

.code

main PROC

 

; Get the Console standard output handle:

    INVOKE GetStdHandle, STD_OUTPUT_HANDLE

    mov consoleHandle,eax

   

; 設定回到起始位置

INITIAL:

    mov ax,xyInit.x

    mov xyPos.x,ax

    mov ax,xyInit.y

    mov xyPos.y,ax

START:

    call ClrScr

    INVOKE SetConsoleCursorPosition, consoleHandle, xyPos

    call ReadChar

    .IF ax == 1177h ;UP (w)

       sub xyPos.y,1

    .ENDIF

    .IF ax == 1F73h ;DOWN (s)

       add xyPos.y,1

    .ENDIF

    .IF ax == 1E61h ;LEFT (a)

       sub xyPos.x,1

    .ENDIF

    .IF ax == 2064h ;RIGHT (d)

       add xyPos.x,1

    .ENDIF

    .IF ax == 011Bh ;ESC

       jmp END_FUNC

    .ENDIF

   

    ; 檢查作完上下左右後有沒有超過限制邊界

    .IF xyPos.x == 0h ;x lowerbound

       add xyPos.x,1

    .ENDIF

    mov ax,xyBound.x ; 註：比較不能用雙定址，故將其中一個轉成 register

    .IF xyPos.x == ax ;x upperbound

       sub xyPos.x,1

    .ENDIF

   

    .IF xyPos.y == 0h ;y lowerbound

       add xyPos.y,1

    .ENDIF

    mov ax,xyBound.y

    .IF xyPos.y == ax ;y upperbound

       sub xyPos.y,1

    .ENDIF

   

    jmp START

END_FUNC:

    exit

main ENDP

 

END main