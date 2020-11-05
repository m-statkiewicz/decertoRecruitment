# decertoRecruitment
Decerto recruitment task.

Steps to check application:
1. clone repository
2. build using maven
3. run
4. request GET on http://localhost:8080/join. Request can be parametrized based on following list of available source values:
- h2 - gets random number from H2 in memory DB
- java - gets random number from Math library
- randomorg - gets random number from Random.org API 

http://localhost:8080/join?firstSource=h2&secondSource=java