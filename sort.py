import time
import numpy
import csv
import sys

# Define insertion sort
def insertionSort(data):
    for i in xrange(0, len(data)):
        for j in xrange(i,0,-1):
            if(data[j] < data[j-1]):
                temp = data[j]
                data[j] = data[j-1]
                data[j-1] = temp 
    return data

# Defining iterative quicksort
def quickSort(data):
    stack = []
    
    stack.append(0)
    stack.append(len(data)-1)
    
    while(len(stack) > 0):
        # low is first in / last out of pair
        h = stack.pop() # High
        l = stack.pop() # Low
        
        data, i, j = partition(data, l, h)
        
        # If elements on left of pivot, push left side to stack
        if( l < j):
            stack.append(l)
            stack.append(j)
        
        # If elements on right of pivot, push right side to stack
        if( i < h):
            stack.append(i)
            stack.append(h)
    
    return data

def partition(data, lowInd, highInd):
    pivot = data[lowInd + (highInd - lowInd)/2]

    i = lowInd
    j = highInd
    
    while (i <= j):
        while (data[i] < pivot):
            i+=1

        while (data[j] > pivot):
            j-=1

        if (i <= j):
            # Swap values
            temp = data[i]
            data[i] = data[j]
            data[j] = temp

            i+=1
            j-=1
            
    return data, i, j

## Test for sort functions
def test(sortFunc, ntest = 10, baseSize = int(1e3)):
    arrSize = range(baseSize, baseSize*10 + 1, baseSize*(10/ntest))
    times = [[] for x in range(5)]
    i = 0
    
    # Create test arrays & sort
    for j in range(0,5):
        
        for size in arrSize:
            testData = range(size,0,-1) # Worst case = reverse ordered

            start = time.time() # Start timer
            sortFunc(testData) # Run test function
            stop = time.time() # Stop timer

            times[i].append(round((stop-start)*1000,0))
        
            print "Trial [", i+1, ", ",j, "]: ", times[i],"ms \n"

        i+=1;
        
    
    print " "
    return arrSize, times

# Take args here
if(len(sys.argv) > 1):
    baseSize = int(sys.argv[1])
else:
    baseSize = int(1e3)

if(len(sys.argv) > 2):
    sizes, times = test(insertionSort, baseSize = baseSize)
else:
    sizes, times = test(quickSort, baseSize = baseSize)

if(len(sys.argv) > 2):
    f = open('sortPythonInsert.csv','wb')
else:
    f = open('sortPythonQuick.csv','wb')

writer = csv.writer(f)
writer.writerow(sizes)
writer.writerows(times)

f.close()