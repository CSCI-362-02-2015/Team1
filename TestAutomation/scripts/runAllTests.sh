#!/bin/bash
. runAllTests

cd ../reports
rm results.txt
rm results.html

cd ../testCases
#javac CohortUnionDriver
#java CohortUnionDriver "testCase1.txt"
num=1
str=../testCases/testCase
ext=.txt
numTest=$(ls | wc -l)

cd ../reports
echo "<html>" >> results.txt

cd ../project/openmrs-core
#mvn compile

cd ../../testCaseExecutables
javac -classpath "openmrs-core/api/target/classes" CohortUnionDriver.java
while [ $num -le $numTest ]; do
	var=$str$num$ext
	while read p; do
	    if [[ ${p:0:1} == D* ]];
			then java ${p:8};
			echo $num
			#then ls;
		fi
	done <$var
	num=$((num+1))
done
cd ../reports
echo "</html>" >> results.txt
rename 's/\.txt$/\.html/' *.txt
xdg-open results.html