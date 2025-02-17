# claim-validator
For Tambola Game claims
The project take test cases from a txt file as well currently which is present in the binary directory with the name testCases.txt . The format of test cases is "ticket numbers# announched numbers # game type" where ticket numbers , announced numbers are CSV string . For example ticket number 4,16,_,_,48,_,63,76,_,7,_,23,38,_,52,_,_,80,9,_,25,_,_,56,64,_,83 represent a Tambola ticket 
```
4,16,_,_,48,_,63,76,_
7,_,23,38,_,52,_,_,80
9,_,25,_,_,56,64,_,83
```
and announced nunbers example is 90,4,46,63,89,16,76,48 . Game Type valid values are following 
```
top_line,middle_line,bottom_line,full_house and early_five
``` 
Hence the full line with a sample test case is like :
4,16,_,_,48,_,63,76,_,7,_,23,38,_,52,_,_,80,9,_,25,_,_,56,64,_,83#90,4,46,63,89,16,76,48#top_line .

## Rules
### 1. Numbers will be from 1 to 90 
### 2. Each row will have numbers in increasing order from left to right
### 3. Last called number needs to be present in the ticket 
### 4. Each row will 5 numbers and 4 blanks
### 5. There will be no repeated numbers either in ticket or announced numbers
### 6. Each ticket will have 3 rows



# Future work
Test Cases File name and path can be made configurable using application properties. 
