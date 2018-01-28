TITLE jumpTestBackup[jumpTestBackup.asm]
INCLUDE Irvine32.inc
main EQU start@0

BoxWidth = 45
border = 44
sleepTime = 15

.data
consoleHandle    DWORD ?
xyInit COORD <0,19> ; 起始座標
xyBound COORD <BoxWidth,25> ; 一個頁面最大的邊界
xyPos COORD <?,?> ; 現在的游標位置

floor BYTE BoxWidth DUP(0C4h)
outputHandle DWORD 0
bytesWritten DWORD 0
count DWORD 0
floor_xyPosition COORD <0,20>
cellsWritten DWORD ?
attributes0 WORD BoxWidth DUP(0Bh)
wall BYTE 0DAh
xyPosWall COORD <20,20>
attributeWall WORD 0Bh
heightWall WORD ?
gameStartMsg BYTE "Welcome ! Press [w] to get start", 0
gameOverMsg1 BYTE "You died ! Your score is ", 0
gameOverMsg2 BYTE "press [w] to restart , press [s] to end", 0
isOver BYTE 0
score DWORD 0

.code
createWall PROC uses eax ecx

    call Randomize
    mov eax,20
    call RandomRange
	add eax,25
    mov xyPosWall.x,ax
    mov eax,4
    call RandomRange
    add eax, 1
	mov heightWall, ax
    mov xyPosWall.y,20
	sub xyPosWall.y,1
    mov ecx,eax
	
L1: 
	push ecx
    push eax    
    INVOKE WriteConsoleOutputAttribute,
           consoleHandle,
           ADDR attributeWall,
           SIZEOF wall,
           xyPosWall,
           ADDR count

    INVOKE WriteConsoleOutputCharacter,
			consoleHandle,
			ADDR wall,
			SIZEOF wall, 
			xyPosWall,
			ADDR count

    dec xyPosWall.Y
    pop eax
    pop ecx
    loop L1
    ret
createWall ENDP

createLine PROC uses eax ecx
        
    INVOKE WriteConsoleOutputAttribute,
      consoleHandle,
      ADDR attributes0,
      SIZEOF floor,
      floor_xyPosition,
      ADDR count

    INVOKE WriteConsoleOutputCharacter,
       consoleHandle,   	; console output handles
       ADDR floor,   		; pointer to the top box line
       SIZEOF floor,   		; size of box line
       floor_xyPosition,   	; coordinates of first char
       ADDR count 			; output count

    ret   	   
createLine ENDP

JumpUp PROC 
	
	sub xyPos.y,1 ;jump 
		add xyPos.x,1 
		mov ax, xyPos.x
		mov bx, xyPos.y
		mov dx, xyPosWall.y
		inc dx

		.IF ax == xyPosWall.x		;判斷撞牆
			push ecx
			movzx ecx, heightWall
			isCollidedJump:
				.IF bx == dx
					pop ecx
					je END_FUNC2
				.ENDIF
				inc dx
				LOOP isCollidedJump
			pop ecx
		.ENDIF						;判斷撞牆
		
		.IF xyPos.x == border		;跑完一圈
			sub xyPos.x, border
			call ClrScr
			call getScore
			call createLine
			call createWall			;跑完一圈
		.ENDIF

		push ecx
		INVOKE Sleep, sleepTime
		INVOKE SetConsoleCursorPosition, consoleHandle, xyPos
		pop ecx
		ret
		
		END_FUNC2:							;撞到牆壁的處理
			push eax
			and eax , 00000000
			inc eax
			mov isOver , al
			pop eax
			ret

JumpUp ENDP
	
FallDown PROC
	add xyPos.y,1 ;fallDown
		add xyPos.x,1
		mov ax, xyPos.x
		mov bx, xyPos.y
		mov dx, xyPosWall.y
		inc dx

		.IF ax == xyPosWall.x		;判斷撞牆
			push ecx
			movzx ecx, heightWall
			isCollidedFallDown:
				.IF bx == dx
					pop ecx
					je END_FUNC3
				.ENDIF
				inc dx
				LOOP isCollidedFallDown
			pop ecx
		.ENDIF						;判斷撞牆

		.IF xyPos.x == border		;跑完一圈
			sub xyPos.x, border			
			call ClrScr
			call getScore
			call createLine
			call createWall
		.ENDIF						;跑完一圈

		push ecx
		INVOKE Sleep, sleepTime
		INVOKE SetConsoleCursorPosition, consoleHandle, xyPos
		pop ecx
		ret
		
		END_FUNC3:							;撞到牆壁的處理
			push eax
			and eax , 00000000
			inc eax
			mov isOver , al
			pop eax
			ret
		

FallDown ENDP

playerJump PROC uses ecx eax ebx
	mov ecx, 6
	jump: 								;繼續往上跳
		call JumpUp
		mov al , isOver
		.IF al == 1
			jmp RET_FUNC
		.ENDIF
		LOOP jump						;繼續往上跳
		
	mov ecx, 6
	fall:								;繼續下墜
		call FallDown
		mov al , isOver
		.IF al == 1
			jmp RET_FUNC
		.ENDIF
		LOOP fall						;繼續下墜
	RET_FUNC:
	ret
		
playerJump ENDP

getScore PROC uses eax
	mov eax, score
	call WriteDec
	inc eax
	mov score, eax
	ret
getScore ENDP

main PROC

; Get the Console standard output handle:
    INVOKE GetStdHandle, STD_OUTPUT_HANDLE
    mov consoleHandle,eax
	
; 設定回到起始位置
GameActivated:
	mov edx , OFFSET gameStartMsg
	call ClrScr
	call WriteString
	call ReadChar
	.IF ax == 1177h
		jmp INITIAL
	.ENDIF

INITIAL:
	mov isOver , 0
	mov score , 0
    mov ax,xyInit.x
    mov xyPos.x,ax
    mov ax,xyInit.y
    mov xyPos.y,ax
	call ClrScr
	call getScore
	call createLine
	call createWall
	
START:
	;push eax
    INVOKE SetConsoleCursorPosition, consoleHandle, xyPos
	
    call ReadKey
	
    .IF ax == 1177h ;UP (w)
		call playerJump
		
		push eax
		and eax,00000000
		mov al,isOver
		cmp al,1
		je END_FUNC
		pop eax
		
    .ENDIF

    .IF ax == 011Bh ;ESC
       jmp END_FUNC
    .ENDIF
	
	add xyPos.x,1
	INVOKE Sleep, sleepTime

    ; 檢查作完上下左右後有沒有超過限制邊界

    mov ax,xyPosWall.x ; 註：比較不能用雙定址，故將其中一個轉成 register
	
	.IF xyPos.x == ax
		jmp END_FUNC
	.ENDIF
	
	mov ax,xyBound.x ; 註：比較不能用雙定址，故將其中一個轉成 register
	
    .IF xyPos.x == border						;跑完一圈
		sub xyPos.x, border
		call ClrScr
		call getScore
		call createLine
		call createWall
    .ENDIF										;跑完一圈

    jmp START

END_FUNC:
	call ClrScr
	mov edx , OFFSET gameOverMsg1
	call WriteString
	mov eax , score
	dec eax
	call WriteDec
	call Crlf
	mov edx , OFFSET gameOverMsg2
	call WriteString
	INVOKE GetStdHandle, STD_OUTPUT_HANDLE
	mov consoleHandle,eax
	call ReadChar
	.IF ax == 1177h
		jmp INITIAL
	.ENDIF
	.IF ax == 1F73h
		exit
	.ENDIF
		
main ENDP
END main