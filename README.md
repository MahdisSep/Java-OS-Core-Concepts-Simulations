# Java Operating Systems Core Concepts Simulations

This repository contains key simulations and implementations covering foundational topics in Operating Systems, developed for an undergraduate CS course. The projects are designed to demonstrate a practical understanding of resource management, scheduling, and virtual memory.

## 📁 Project Structure

| Directory | Content | Key Concepts Demonstrated |
| :--- | :--- | :--- |
| `01_CPU_Scheduling` | **FIFO, Round Robin, EDF** simulation code. | Process Management, Time Slicing, Preemption, Context Switching. |
| `02_Page_Replacement` | **FIFO, LRU, Second Chance** simulation code. | Virtual Memory, Paging, Page Fault Minimization, Frame Management. |
| `03_RealTime_Scheduling` | **Rate Monotonic Scheduling (RMS)** implementation. | Real-Time Systems, Static Priority, Task Periodicity, Schedulability. |

## 1\. CPU Scheduling Algorithms

**Implementation:** `01_CPU_Scheduling/Main.java`

Simulates non-preemptive (FIFO) and preemptive (Round Robin) CPU dispatching, along with conceptual classes for a real-time scheduler (EDF).

  * **Algorithms:** FIFO, Round Robin (RR), Earliest Deadline First (EDF) Concept.
  * **Focus:** Calculating execution order, and modeling time slice behavior.

## 2\. Virtual Memory: Page Replacement Algorithms

**Implementation:** `02_Page_Replacement/Main.java`

Compares the performance of three classic page replacement policies by measuring the number of **Page Faults** for a given reference string and a fixed number of memory frames.

  * **Algorithms:** First-In, First-Out (FIFO), Least Recently Used (LRU), Second Chance (SC).
  * **Focus:** Minimizing Page Faults, understanding the cost/benefit trade-offs of replacement strategies.

## 3\. Real-Time Scheduling: Rate Monotonic

**Implementation:** `03_RealTime_Scheduling/Main.java`

Simulates a static-priority scheduling environment where task priorities are determined by their rate (inverse of their period).

  * **Algorithm:** Rate Monotonic Scheduling (RMS).
  * **Focus:** Ensuring critical tasks meet their deadlines, modeling preemption based on priority derived from task period.

## 🚀 How to Run

Each folder contains a `Main.java` file which can be compiled and run independently:

```bash
# Example for CPU Scheduling
cd 01_CPU_Scheduling
javac Main.java
java Main
```

The program will prompt for input parameters required for the simulation.