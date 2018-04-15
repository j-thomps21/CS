#!/usr/bin/env bash
a=$1
b=$2
tr '\n' ' ' <$a > output_file
tr '\n' ' ' <$b > test_output_file
rm -f $a            
diff -sbq output_file test_output_file         
rm -f output_file
rm -f test_output_file
