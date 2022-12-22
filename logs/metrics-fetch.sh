#This is my script to fetch the necessary metrics from my log file
#This greps the status codes
httpCodes=$(grep Response rollingFile.log | cut -f 2 -d \[ | cut -f 1 -d \  ) 
#this greps the floating point numbers in milliseconds
httpLatency=$(grep took rollingFile.log | cut -f 6 -d \  | cut -f 1 -d \  )

#These are variables to keep track of the code metrics
httpRequestTotal=0
httpFailures=0
#These are variables to keep track of the latency metrics
httpLatencies=0
httpLatencyTotal=0

# This for loop keeps track of the code metrics
for code in $httpCodes
do
	((httpRequestTotal++))
	if [ $code -gt 499 ] #could also use [ $code -eq 500 ] || [ $code -gt 500 ]
	then
		((httpFailures++))
	fi
done

# This for loop sums the latency metrics and creates the proper total latencies value to get our average from
for latency in $httpLatency
do
	#creating the total number of latency values obtained 
	((httpLatencies++))
	#summing our latencies
	httpLatencyTotal=$(awk "BEGIN {print $httpLatencyTotal + $latency; exit}") 

	
done

#These echo the code metrics to the terminal
echo "httpRequestTotal: " + $httpRequestTotal
echo "httpFailures: " + $httpFailures
#These echo the latency metrics to the terminal
echo "httpLatencyTotal: " + $httpLatencyTotal
echo "httpLatencies: " + $httpLatencies

httpCodeSuccess=$(($httpRequestTotal - $httpFailures))

httpCodeResult=$(awk "BEGIN {print $httpCodeSuccess / $httpRequestTotal * 100; exit}") 
httpLatencyResult=$(awk "BEGIN {print $httpLatencyTotal / $httpLatencies; exit}") 

echo "HTTP code success rate: $httpCodeResult%"
echo "HTTP latency average: $httpLatencyResult ms"


#===========================================================================
#Below is a failed attempt at combining my two for loops
# j=0

# for i in $httpLatency
# do
# 	((j++))
# 	httpLatency[$j]="{$i}"
# done

# for i in $httpCodes
# do
# 	((httpRequestTotal++))
# 	((httpLatencyTotal++))
# 	#echo $httpLatency
# 	#echo ${httpLatency[$httpRequestTotal]}
# 	j=${httpLatency[$httpLatencyTotal]}
# 	echo $((j))
# 	if [ $i -gt 499 ]
# 	then
# 		((httpFailures++))
# 	fi
# 	# if [ j -gt 199 ]
# 	# then
# 	# 	((httpLatencyFail++))
# 	# fi

# done
# echo ${httpLatency[1]}
# echo ${httpLatency[2]}
# echo ${httpLatency[3]}
# echo ${httpLatency[4]}

# if [ $latency -gt 199 ] #could also use [ $latency -gt 200 ] || [ $latency -eq 200 ]
	# then
	# 	((httpLatencyFail++))
	# fi

	#echo $httpCodeSuccess
#echo $httpLatencies

#result=$(echo "scale=2; $httpSuccess / $httpRequestTotal")
#Below is code that will be used

#echo $httpLatencyTotal
#Next 6 lines of code are used for debugging
#These are echo statements to check if we got the appropriate metrics
#echo $httpCodes
#echo $httpLatency