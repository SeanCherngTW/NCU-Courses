
        .data
star:   .asciiz "*"
space:  .asciiz " "
nl:     .asciiz "\n"
input:  .asciiz "input: "


        .text
        .globl  main
main:
        la      $a0, input
        li      $v0, 4
        syscall

        li      $v0, 5                  # Read int, into $v0
        syscall                         # call read_int

        move    $s0, $v0                # $s0 = n
        beq     $s0, $zero, exit

init:
        li      $s1, 0                  # $s1 = i = 0
        li      $s2, 1                  # $s2 = j = 1
        add     $s3, $s0, $s0
        add     $s3, $s3, -1            # $s3 = 2n-1

### Draw Arrow ###

arrow:
        add     $s1, 1
        li      $s2, 1
        bge     $s0, $s1, arrowline
        li      $s1, 0
        j       body

arrowline:
        move    $t0, $s0                # $t0 = n
        beq     $s2, $t0, arrowstar     # if(j==n) print('*')

        move    $t1, $s0
        sub     $t1, $t1, $s1
        add     $t1, $t1, 1             # $t1 = n-i+1
        beq     $s2, $t1, arrowstar     # if(j==n-i+1) print('*')

        move    $t2, $s0
        add     $t2, $t2, $s1
        sub     $t2, $t2, 1             # $t2 = n+i-1
        beq     $s2, $t2, arrowstar     # if(j==n+i-1) print('*')

        j       arrowspace              # else print(' ')

arrowcheck:
        add     $s2, 1
        bge     $s3, $s2, arrowline
        li      $v0, 4
        la      $a0, nl
        syscall
        j       arrow

arrowstar:
        li      $v0, 4
        la      $a0, star
        syscall
        j       arrowcheck

arrowspace:
        li      $v0, 4
        la      $a0, space
        syscall
        j       arrowcheck

### Draw Arrow ###


### Draw Body ###

body:
        add     $s1, 1
        li      $s2, 1
        bge     $s0, $s1, bodyline
        li      $s1, 0
        j       box

bodyline:
        move    $t0, $s0                # $t0 = n
        beq     $s2, $t0, bodystar      # if(j==n) print('*')
        j       bodyspace               # else print(' ')

bodycheck:
        add     $s2, 1
        bge     $s3, $s2, bodyline
        li      $v0, 4
        la      $a0, nl
        syscall
        j       body

bodystar:
        li      $v0, 4
        la      $a0, star
        syscall
        j       bodycheck

bodyspace:
        li      $v0, 4
        la      $a0, space
        syscall
        j       bodycheck


### Draw Body ###


### Draw Box ###

box:
        add     $s1, 1
        li      $s2, 1
        li      $t3, 1                  # for boxstarline loop
        bge     $s3, $s1, boxline       # loop i from 1 to 2n-1
        j       main

boxline:
        li      $t0, 1
        beq     $s1, $t0, boxstarline   # if(i==1)

        move    $t0, $s0
        add     $t0, $t0, $s0
        sub     $t0, 1
        beq     $s1, $t0, boxstarline   # if(i==2n-1)

        j       boxstarothers

boxstarothers:
        li      $t0, 1
        beq     $s2, $t0, boxstar       # if(j==1)

        move    $t0, $s0
        add     $t0, $t0, $s0
        sub     $t0, 1
        beq     $s2, $t0, boxstar       # if(j==2n-1)

        move    $t0, $s1
        beq     $s2, $t0, boxstar       # if(j==i)

        move    $t0, $s0
        add     $t0, $t0, $s0
        sub     $t0, $t0, $s1
        beq     $s2, $t0, boxstar       # if(j==2n-i)

        j       boxspace

boxcheck:
        add     $s2, 1
        bge     $s3, $s2, boxstarothers
        li      $v0, 4
        la      $a0, nl
        syscall
        j       box

boxstar:
        li      $v0, 4
        la      $a0, star
        syscall
        j       boxcheck

boxstarline:
        li      $v0, 4
        la      $a0, star
        syscall
        add     $t3, 1
        bge     $s3, $t3, boxstarline
        li      $t3, 1
        li      $v0, 4
        la      $a0, nl
        syscall
        j       box

boxspace:
        li      $v0, 4
        la      $a0, space
        syscall
        j       boxcheck

### Draw Box ###

exit:
li      $v0, 10
        syscall
