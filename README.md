# Round-Robin-Scheduling
CSC227 Project:
Objective
In this project, you will simulate CPU scheduling component of operating system. you will gain knowledge of how short term scheduling works.<br>
Project Description:<br>
In this project you will simulate Round Robin scheduling algorithm. For the sake of simulation, consider a simple system with a single CPU, single I/O device. The CPU has a ready queue and an I/O queue. The system will select a process from the ready queue based on RR algorithm (quantum time will be given to you) and send it to CPU. Information about a process is maintained in process control block (PCB) during the lifetime of the process i.e. from start until termination. Each process PCB contains all required information to identify the process such as its id, its state, and required statistics which include turnaround time for each process, and waiting time for each process. You can add other fields to PCB to help you in programming. Your program should provide average turnaround time, average waiting time, and CPU utilization for a given input file.<br>
Specifications<br>
1.	CPU burst is between 2ms and 10ms.<br>
Project Evaluation<br>
Project submission and evaluation will be done in phases.<br>
There will be a standard data file format (sent separately) to be used for this project.<br>
Phase1: You will write Java program to read the file (of standard data format) and produce some statistics. This phase is to make sure that everyone uses the same data file format.<br>
Statistics required in this phase are:<br>
•	Total number of process.<br>
•	Maximum burst time<br>
•	Minimum burst time<br>
•	How many process have more that maximum burst time?<br>
•	How many processes have less than maximum burst time?<br>
Phase2: PA new data file (of standard format) will be provided to every student i.e. every member of group which he will use to simulate his project and then submit the result.<br> Statistics required in this phase are:<br>
•	Time the first process arrives.<br>
•	PID of the second process executed.<br>
•	Time the last process executed.<br>
•	PID of the last process executed.<br>
•	Finish time of every process.<br>
•	Total time for execution of all processes.<br>
•	Average turnaround time.<br>
•	Average waiting time.<br>

