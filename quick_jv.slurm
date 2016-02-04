#!/bin/bash
#SBATCH --output=quick_jv.txt
#SBATCH --mem=8g

cp sortTime.java $PFSDIR/.
cp QuickSort.java $PFSDIR/.
cp InsertionSort.java $PFSDIR/.
cp plot_png.py $PFSDIR/.

cd $PFSDIR

module load intel
module load python

javac QuickSort.java
javac sortTime.java

java sortTime 10000000

python plot_png.py sortJavaQuick.csv

cp -u *.png $SLURM_SUBMIT_DIR/.
cp -u *.csv $SLURM_SUBMIT_DIR/.