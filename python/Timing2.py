import time
import sys

def timing(maxiter = 10000000, ntrial = 5):
    times = [] # To keep track of times
    
    for i in xrange(0,ntrial):
    	x = 0
        start = time.time() # Start timer

        for j in xrange(0,maxiter):
        	x = x + 1

        stop = time.time() # Stop timer
        
        times.append((stop-start)*1000)
    
    for i in range(0,len(times)):
    	print (int)(times[i]), '\t',

    print 'Average: ', (int)(sum(times)/ntrial)

arg = [int(i) for i in sys.argv[1:]]
if(len(arg) > 0):
	timing(arg[0])
else:
	timing()