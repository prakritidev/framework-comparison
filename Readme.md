# Framework-comparison

## Motivation

Just wanted to check if nodejs is really better than Java when dealing with I/O and CPU intensive tasks

## Definitions

1. I/O Tasks: tasks that call external things (database, external api, disk read, etc.)
2. CPU Intensive: tasks that need computation and can't be delegated to disk, network card, or other hardware. (encryption, data manipulation[sorting, finding combinations(realtime correlation between two or multiple stock etc)])

# Phase 1 Test results concurrency of 1000 and total request 1000000

I'm not impressed, let's try doing some encryption in second phase.  

## NODEJS 
❯ ab -n 1000000 -c 1000 "http://localhost:3000/"
This is ApacheBench, Version 2.3 <$Revision: 1879490 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100000 requests
Completed 200000 requests
Completed 300000 requests
Completed 400000 requests
Completed 500000 requests
Completed 600000 requests
Completed 700000 requests
Completed 800000 requests
Completed 900000 requests
Completed 1000000 requests
Finished 1000000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            3000

Document Path:          /
Document Length:        12 bytes

Concurrency Level:      1000
Time taken for tests:   46.510 seconds
Complete requests:      1000000
Failed requests:        0
Total transferred:      211000000 bytes
HTML transferred:       12000000 bytes
Requests per second:    21500.80 [#/sec] (mean)
Time per request:       46.510 [ms] (mean)
Time per request:       0.047 [ms] (mean, across all concurrent requests)
Transfer rate:          4430.34 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   11   7.4     12      38
Processing:    13   35  14.8     31      92
Waiting:        1   31  15.4     28      88
Total:         25   46  11.1     43      92

Percentage of the requests served within a certain time (ms)
  50%     43
  66%     48
  75%     54
  80%     58
  90%     64
  95%     67
  98%     72
  99%     77
 100%     92 (longest request)


## Java 

❯ ab -n 1000000 -c 1000 "http://localhost:8080/"
This is ApacheBench, Version 2.3 <$Revision: 1879490 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100000 requests
Completed 200000 requests
Completed 300000 requests
Completed 400000 requests
Completed 500000 requests
Completed 600000 requests
Completed 700000 requests
Completed 800000 requests
Completed 900000 requests
Completed 1000000 requests
Finished 1000000 requests


Server Software:        
Server Hostname:        localhost
Server Port:            8080

Document Path:          /
Document Length:        12 bytes

Concurrency Level:      1000
Time taken for tests:   25.762 seconds
Complete requests:      1000000
Failed requests:        0
Total transferred:      91000000 bytes
HTML transferred:       12000000 bytes
Requests per second:    38816.91 [#/sec] (mean)
Time per request:       25.762 [ms] (mean)
Time per request:       0.026 [ms] (mean, across all concurrent requests)
Transfer rate:          3449.55 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   12   1.1     12      22
Processing:     4   14   2.3     13      29
Waiting:        1   10   2.1     10      26
Total:         12   26   2.2     25      42

Percentage of the requests served within a certain time (ms)
  50%     25
  66%     26
  75%     27
  80%     28
  90%     29
  95%     30
  98%     31
  99%     32
 100%     42 (longest request)
