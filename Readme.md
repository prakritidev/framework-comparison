# Framework-comparison

## Motivation

Just wanted to check if nodejs is really better than Java when dealing with I/O and CPU intensive tasks

## Definitions

1. I/O Tasks: tasks that call external things (database, external api, disk read, etc.)
2. CPU Intensive: tasks that need computation and can't be delegated to disk, network card, or other hardware. (encryption, data manipulation[sorting, finding combinations(realtime correlation between two or multiple stock etc)])

# Phase 1 

Test results concurrency of 1000 and total request 1000000, I'm not impressed, let's try doing some encryption in second phase.  

## NODEJS 
<code>
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
</code>

## Java 
<code>
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
</code>

## Phase 2 (Hashing Implementation)

I was not expecting this result. will do some some more testing on this phase. 

### Java
<code>
❯ ab -n 1000000 -c 1000 "http://localhost:8080/?input=duck"
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

Document Path:          /?input=duck
Document Length:        7 bytes

Concurrency Level:      1000
Time taken for tests:   38.361 seconds
Complete requests:      1000000
Failed requests:        0
Total transferred:      85000000 bytes
HTML transferred:       7000000 bytes
Requests per second:    26067.86 [#/sec] (mean)
Time per request:       38.361 [ms] (mean)
Time per request:       0.038 [ms] (mean, across all concurrent requests)
Transfer rate:          2163.84 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   18   2.3     18      34
Processing:     8   20   2.5     20      45
Waiting:        1   14   2.5     14      38
Total:         18   38   1.7     38      62

Percentage of the requests served within a certain time (ms)
  50%     38
  66%     38
  75%     39
  80%     39
  90%     40
  95%     41
  98%     43
  99%     45
 100%     62 (longest request)
</code>

### Nodejs
<code>
 ab -n 1000000 -c 1000 "http://localhost:3000/?input=duck"
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

Document Path:          /?input=duck
Document Length:        7 bytes

Concurrency Level:      1000
Time taken for tests:   105.177 seconds
Complete requests:      1000000
Failed requests:        0
Total transferred:      205000000 bytes
HTML transferred:       7000000 bytes
Requests per second:    9507.81 [#/sec] (mean)
Time per request:       105.177 [ms] (mean)
Time per request:       0.105 [ms] (mean, across all concurrent requests)
Transfer rate:          1903.42 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    2   4.7      0      36
Processing:    12  103  21.3     99     238
Waiting:        5  102  21.9     99     237
Total:         26  105  19.8    100     238

Percentage of the requests served within a certain time (ms)
  50%    100
  66%    103
  75%    105
  80%    107
  90%    113
  95%    139
  98%    194
  99%    209
 100%    238 (longest request)
</code>
