TITLE exercise14.asm[exercise14.asm]
INCLUDE Irvine32.inc

BoxWidth = 7
BoxHeight = 7

main EQU start@0 

.data
boxTop    BYTE 0DAh, (BoxWidth - 2) DUP(0C4h), 0BFh
boxBody   BYTE 0B3h, (BoxWidth - 2) DUP(' '), 0B3h
boxBottom BYTE 0C0h, (BoxWidth - 2) DUP(0C4h), 0D9h
outputHandle DWORD 0
bytesWritten DWORD 0
count DWORD 0
xyPosition COORD <10,5>
cellsWritten DWORD ?
attributes0 WORD BoxWidth DUP(0Bh)
attributes1 WORD (BoxWidth-1) DUP(0Ah),0Eh
attributes2 WORD BoxWidth DUP(0Ch)

.code
main PROC
    INVOKE GetStdHandle, STD_OUTPUT_HANDLE 	; Get the console ouput handle
    mov outputHandle, eax 		   	; save console handle
    call Clrscr
    ; 畫出box的第一行

    INVOKE WriteConsoleOutputAttribute,
      outputHandle,
      ADDR attributes0,
      SIZEOF boxTop,
      xyPosition,
      ADDR count

    INVOKE WriteConsoleOutputCharacter,
       outputHandle,   	; console output handle
       ADDR boxTop,   	; pointer to the top box line
       SIZEOF boxTop,   ; size of box line
       xyPosition,   	; coordinates of first char
       ADDR count 	; output count

    inc xyPosition.Y   	    ; 座標換到下一行位置
    mov ecx, (BoxHeight)    ; number of lines in body
   
L1: push ecx  ; save counter 避免invoke 有使用到這個暫存器
    INVOKE WriteConsoleOutputAttribute,
      outputHandle,
      ADDR attributes1,
      SIZEOF boxBody,
      xyPosition,
      ADDR count
 
    INVOKE WriteConsoleOutputCharacter,
       outputHandle,
       ADDR boxBody,   ; pointer to the box body
       SIZEOF boxBody,
       xyPosition,
       ADDR count ;

    inc xyPosition.Y    ; next line
    pop ecx   		; restore counter
    loop L1

    INVOKE WriteConsoleOutputAttribute,
      outputHandle,
      ADDR attributes2,
      SIZEOF boxBottom,
      xyPosition,
      ADDR count

    ; draw bottom of the box
    INVOKE WriteConsoleOutputCharacter,
       outputHandle,
       ADDR boxBottom,   ; pointer to the bottom of the box
       SIZEOF boxBottom,
       xyPosition,
       ADDR count ;

    call WaitMsg
    call Clrscr
    exit
main ENDP
END main