#!/bin/bash
#SBATCH --output=insert_py.txt
#SBATCH --mem=8g

cp sort.py $PFSDIR/.
cp plot_png.py $PFSDIR/.

cd $PFSDIR

module load intel
module load python

python sort.py 1000 insert

python plot_png.py sortPythonInsert.csv

cp -u *.csv $SLURM_SUBMIT_DIR/.
cp -u *.png $SLURM_SUBMIT_DIR/.