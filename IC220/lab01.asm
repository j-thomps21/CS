.data
strPromptLoop: .asciiz  "How many times would you like to repeat?\n"
strWelcome:    .asciiz  "Welcome to MIDN Thompson's lab #1\n"   #This is the welcome string
strPrompt:     .asciiz  "Please enter the x:"        #prompts user for the variable value
strFive:       .asciiz  "x + 5 is "
strX:          .asciiz  "x + x is "
strMultiply:   .asciiz  "8 * x is "
strGoodbye:    .asciiz  "Thank you for using MIND Thompson's lab #1"
strReturn:     .asciiz  "\n"


.text
    .globl main
main:
    # STEP : Print the welcome string
    li $v0, 4
    la $a0, strWelcome
    syscall

    # STEP : Prompt the user to input the amount of times they want to repeat the loop
    li $v0, 4
    la $a0, strPromptLoop
    syscall


    # STEP : Get the value from the user
    li $v0, 5
    syscall
    move $s1, $v0


    # STEP : If $s1 is equal to zero then exit the loop
loop: beq $s1, $zero, exit



    # STEP : Prompt for value
    li $v0, 4
    la $a0, strPrompt
    syscall

    # STEP : Read in the value
    li $v0, 5
    syscall
    move $s0, $v0

    # STEP : Calculate Value +5 and Print
    addi $t1, $s0, 5
    li $v0, 4
    la $a0, strFive
    syscall
    li $v0, 1
    move $a0, $t1
    syscall
    li $v0, 4
    la $a0, strReturn
    syscall


    # STEP : Calculate value x + x and Print
    add $t1, $s0, $s0
    li $v0, 4
    la $a0, strX
    syscall
    li $v0, 1
    move $a0, $t1
    syscall
    li $v0, 4
    la $a0, strReturn
    syscall

    # STEP : Multiply value by 8 and print
    add $t1, $s0, $s0
    add $t1, $t1, $t1
    add $t1, $t1, $t1
    li $v0, 4
    la $a0, strMultiply
    syscall
    li $v0, 1
    move $a0, $t1
    syscall
    li $v0, 4
    la $a0, strReturn
    syscall

    # STEP : Increment $s1 then jump back to the loop
    addi $s1, $s1, -1
    j loop

    # STEP : Print Goodbye message
exit: li $v0, 4
    la $a0, strGoodbye
    syscall

    # STEP 8: Exit
    li $v0, 10
    syscall
