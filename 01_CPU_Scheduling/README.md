# CPU Scheduling Algorithms Simulation (FIFO, Round Robin, EDF Concept)

## 🌟 Project Overview

This Java project implements and simulates three core CPU scheduling algorithms: **First-In, First-Out (FIFO)**, **Round Robin (RR)**, and includes the foundational data structures and logic for **Earliest Deadline First (EDF)**. This simulation is a comprehensive exercise in understanding how an Operating System's kernel manages and dispatches processes to the CPU to optimize throughput, response time, and meet deadlines.

The code processes user-defined inputs for the number of processes, arrival times, and burst times, and then outputs the execution order and time intervals for each algorithm.

## 🛠️ Technology Used

  * **Language:** Java
  * **Concepts:** Object-Oriented Programming (OOP), Data Structures (ArrayList), Process Management, Time Slicing.

## ⚙️ Algorithms Implemented

### 1\. First-In, First-Out (FIFO)

  * **Mechanism:** Processes are executed in the order they arrive. Once a process starts, it runs to completion.
  * **Implementation:** The code identifies the process with the earliest arrival time and executes it fully before moving to the next.

### 2\. Round Robin (RR)

  * **Mechanism:** A preemptive algorithm designed for time-sharing systems. Each process is allocated a small unit of CPU time, called a **time quantum**. If the process does not complete within this quantum, it is preempted and added to the end of the ready queue.
  * **Implementation:** Requires user input for the **time quantum** (`timeQuantum`). The scheduler iterates through the ready queue, decrementing the remaining burst time in cycles equal to the quantum.

### 3\. Earliest Deadline First (EDF) - Conceptual Structure

  * **Mechanism:** A dynamic-priority scheduling algorithm primarily used in real-time operating systems. The process with the nearest deadline is chosen for execution.
  * **Implementation Status:** The code includes the dedicated `ProcessEDF` class, which correctly models processes with a `periodTime` and an `ArrayList<Integer> deadline`. The core logic for identifying the process with the globally minimum deadline and handling preemption is in place.

## 💻 How to Run the Simulation

1.  **Save the file:** Save the code as `Main.java`.
2.  **Compile:**
    ```bash
    javac Main.java
    ```
3.  **Run:**
    ```bash
    java Main
    ```
4.  **Input:** The program will prompt the user to:
      * Choose the algorithm (`FIFO`, `RoundRobin`, or `EDF`).
      * Enter the number of processes.
      * For each process, enter the name, arrival time, and burst time (and time quantum for RR, or period/deadline for EDF).

## 📄 Code Structure Highlights

## | Class / Variable | Purpose | | :--- | :--- | | `ProcessFIFORoundRobin` | Represents a process for FIFO and RR, storing `name`, `arrivalTime`, and `burstTime`. | | `ProcessEDF` | Represents a process for EDF, including `periodTime` and a list of `deadline` values. | | `main(String[] args)` | Handles user input and directs execution to the appropriate algorithm logic block. | | `timeQuantum` | The time slice used in the Round Robin simulation. | | **Logic Blocks** | Distinct `if` blocks for `FIFO`, `Round Robin`, and `EDF` contain the unique scheduling rules. |
