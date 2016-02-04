#!/bin/bash
#SBATCH --output=timing_jv.txt

cp Timing2.java $PFSDIR/.
cd $PFSDIR

javac Timing2.java

java Timing2 100000000
java Timing2 1000000000
java Timing2 10000000000