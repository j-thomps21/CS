.data

Prompt:    .asciiz "Welcome to MIDN Thompson's Password Generator!\n"
Seed:      .asciiz "Enter seed value (in range 0..10): "
PIN:       .asciiz "Enter PIN value (in range 0..10): "
pwd:       .asciiz "Your password: "
coutPIN:   .asciiz "\n\nPIN is: "
coutResult: .asciiz "\n Result is: "



.text
.globl main

  main:

      li $v0, 4              #
      la $a0, Prompt         # Prints out the first prompt to the user
      syscall                #


      li $v0, 4              #
      la $a0, Seed           # Prompts user for seed value
      syscall                #


      li $v0, 5              #
      syscall                # Saves seed value in $s0
      move $s0, $v0          #


      li $v0, 4              #
      la $a0, PIN            # Prompts user for PIN value
      syscall                #


      li $v0, 5              #
      syscall                # Saves PIN value in $s1
      move $s1, $v0          #

      li $t0, 10             # Loads 10 into the temp register
      bgt $s0, $t0, else1    # Checks whether the seed is greater than 10
      bgt $s1, $t0, else1    # Checks whether the PIN is greater than 10


      move $a0, $s0          # Moves Seed to $a0
      move $a1, $s1          # Moves PIN to $a1
      jal flamingo           # Goes into the flamingo function
      move $s2, $v0          # Takes output of flamingo and moves to $s2
      li $v0, 4              #
      la $a0, pwd            # Prints out the password string
      syscall                #
      li $v0, 1              #
      move $a0, $s2          # Prints out the password integer
      syscall                #
      j Exit                 # Goes to exit

  else1:

      li $v0, 4              #
      la $a0, Error          # Prints out an error if Seed or PIN greater than 10
      syscall                #
      j Exit                 # Goes to exit

  Exit:

      li $v0, 10             # Exits the program
      syscall                #



  flamingo:

      addi $sp, $sp, -12     # Adds 3 words to the stack
      sw $ra, 8($sp)         # Store return address
      sw $a0, 4($sp)         # Store first parameter
      sw $a1, 0($sp)         # Store second parameter

      li $t0, 6              # load 6 into the temp register
      ble $a0, $t0, felse1   # if $a0 is less than or equal to 6 jump to felse1
      addi $a0, $a0, -2      # subtract 2 from $a0
      addi $a1, $a1, 3       # add 3 to $a1
      jal flamingo           # jump to flamingo for recursive call
      addi $v0, $v0, 7       # add 7 to return value
      lw $ra, 8($sp)         # load up the return address
      addi $sp, $sp, 12      # pop the stack
      jr $ra                 # return


  felse1:                    #First if else function in flamingo

      li $t0, 4              # load 4 into temp register
      ble $a0, $t0, felse2   # if $a0 is less than or equal to 4 then jump to felse2
      addi $a0, $a0, -2      # Otherwise, subtract 2 from $a0
      jal flamingo           # jump to flamingo for first recursive call
      move $t2, $v0          # move the output into temp register
      addi $sp, $sp, -4      # add a word to the stack
      sw $t2, 0($sp)         # save the temp register for later use
      lw $a0, 8($sp)         # load $a0 up again for next call
      lw $a1, 4($sp)         # load $a1 up again for next call
      addi $a0, $a0, -1      #
      addi $a1, $a1, -2      #
      jal flamingo           # jump to flamingo for next recursive call
      lw $a0, 8($sp)         # load up $a0 again for final return value
      lw $t2, 0($sp)         # load up the temp register with the previous return value
      add $v0, $v0, $t2      # add the values up
      add $v0, $v0, $a0      #
      lw $ra, 12($sp)        # load up the return address
      addi $sp, $sp, 16      # pop the stack
      jr $ra                 # return


  felse2:

      move $a0, $a1          # move $a1 to $a0 for function call
      jal gnu                # call gnu
      add $v0, $v0, $v0      # double the return value
      addi $v0, $v0, 8       # add 8
      lw $ra 8($sp)          # load up return address
      addi $sp, $sp, 12      # pop the stack
      jr $ra                 # return


  gnu:

      addi $sp, $sp, -8      # Add 2 words to the stack
      sw $ra, 4($sp)         # Save return address
      sw $a0, 0($sp)         # Save first parameter

      li $t0, 6              # Load 6 into temp register
      bgt $a0, $t0, gnuElse  # if $a0 is greater than 6 then go to gnuElse
      li $t0, 2              # If not greater, then load 2 into temp register
      add $v0, $a0, $a0      # Do various operations
      addi $v0, $v0, 4       #
      addi $sp, $sp, 8       # Pop the stack (no need to lw $ra)
      jr $ra                 # return

  gnuElse:

      addi $a0, $a0, -1      # Subtract one from $a0
      jal gnu                # go into recursive function
      li $t0, 3              # load 3 into temp register
      lw $a0, 0($sp)
      mul $t0, $t0, $a0      # do various required operations
      add $v0, $v0, $t0      #
      lw $ra, 4($sp)         # Load up return address
      addi $sp, $sp, 8       # Pop stack
      jr $ra                 # return
