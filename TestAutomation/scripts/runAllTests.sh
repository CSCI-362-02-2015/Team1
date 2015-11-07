#!/bin/bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'

#remove old reports
cd ../reports
rm results.txt
rm results.html


cd ../testCases
num=1						#the test case number
str=../testCases/testCase 	#the path to the file
ext=.txt					#the extension for the filename (concatenated, these will result in the directory and filename and extension of the test cases)
numTest=$(ls | wc -l)		#count the number of files in the directory

#begin the new report
cd ../reports
echo "<html>" >> results.txt
echo "<h1>Test Results</h1>" >> results.txt	

cd ../project/openmrs-core/api/src/main/java/org/openmrs
javac -d ../../../../../target/classes/org/openmrs Cohort.java

cd ../../../../../../../../testCaseExecutables
javac -cp ../project/openmrs-core/api/target/classes/org/openmrs *.java

#loop through the test cases
while [ $num -le $numTest ]; do
	var=$str$num$ext
	while read p; do
	    if [[ ${p:0:1} == D* ]];
			then result=$(java -cp ../testCaseExecutables/:../project/openmrs-core/api/target/classes/org/openmrs ${p:8} "$input" "$output"); 	#store any System.out from the driver as result and put in the report
			#echo "Test: "$result >> ../reports/results.txt
			if [[ $result == Passed ]];
				then echo '<font color="green">Test: '$result' </font><br>' >> ../reports/results.txt;
				echo -e Test $num ${GREEN}$result${NC}
			fi 
			
			if [[ $result == Failed ]];
				then echo '<font color="red">Test: '$result' </font><br>' >> ../reports/results.txt;
				echo -e $num ${RED}$result${NC}
			fi 

		fi

		if [[ ${p:0:1} == T* ]];
			then echo $p'<br>' >> ../reports/results.txt;		#put the various test case information into the report
		fi

		if [[ ${p:0:1} == R* ]];
			then echo $p'<br>' >> ../reports/results.txt;
		fi

		if [[ ${p:0:1} == I* ]];
			then echo $p'<br>' >> ../reports/results.txt;
			input=$p
		fi

		if [[ ${p:0:1} == E* ]];
			then echo $p'<br>' >> ../reports/results.txt;
			output=$p
		fi
	done <$var
	num=$((num+1))
	echo "<br>" >> ../reports/results.txt
done
cd ../reports
echo "</html>" >> results.txt

rename 's/\.txt$/\.html/' *.txt
xdg-open results.html