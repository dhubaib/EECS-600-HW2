#!/bin/bash
#SBATCH --output=insert_jv.txt
#SBATCH --mem=8g

cp plot_png.py $PFSDIR/.
cp sortTime.java $PFSDIR/.
cp QuickSort.java $PFSDIR/.
cp InsertionSort.java $PFSDIR/.

cd $PFSDIR

module load intel
module load python

javac InsertionSort.java
javac QuickSort.java
javac sortTime.java

java sortTime 1000 insert

python plot_png.py sortJavaInsert.csv

cp -u *.csv $SLURM_SUBMIT_DIR/.
cp -u *.png $SLURM_SUBMIT_DIR/.