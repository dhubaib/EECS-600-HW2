#!/bin/bash
#SBATCH --output=timing_py.txt
#SBATCH --mem=4g

cp Timing2.py $PFSDIR/.
cd $PFSDIR

module load intel
module load python

python Timing2.py 10000000
python Timing2.py 100000000
python Timing2.py 1000000000