# Real-Time Operating Systems: Rate Monotonic Scheduling (RMS) Simulation

## 🌟 Project Overview

This Java simulation implements the **Rate Monotonic Scheduling (RMS)** algorithm, a fundamental static-priority scheduling technique used in **Real-Time Operating Systems (RTOS)**. The primary goal is to simulate the execution of a set of periodic tasks and assess whether the system is **schedulable**—that is, whether all tasks can meet their deadlines.

RMS assigns static (fixed) priorities to tasks based on their **periods**: the task with the shortest period receives the highest priority (highest rate). The simulation models how the scheduler preempts lower-priority tasks to ensure high-priority (short-period) tasks meet their deadlines.

## 🛠️ Technology Used

  * **Language:** Java
  * **Concepts:** Real-Time Scheduling, Rate Monotonic Algorithm, Static Priority, Schedulability Analysis, Preemption, Task Periodicity.

## ⚙️ Algorithm Details (Rate Monotonic Scheduling)

1.  **Priority Assignment:** Priority is assigned inversely proportional to the task's period.
      * **Shortest Period $\implies$ Highest Priority $\implies$ Highest Rate.**
2.  **Scheduling Logic:** The scheduler always executes the highest-priority task (shortest period) that is ready. Preemption occurs if a higher-priority task arrives while a lower-priority task is running.
3.  **Task Modeling:** Each task is defined by:
      * **Name:** Process identifier.
      * **Burst Time:** The required CPU time for one instance of the task.
      * **Period:** The interval at which the task is repeatedly released.
4.  **Simulation Loop:** The core loop simulates time (`time` variable) and checks for the task with the current shortest period (highest priority) to run. The period is conceptually managed as the next arrival time.

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
4.  **Input:** The program requires input for:
      * The total number of processes (`n`).
      * For each process, its `burst time` (execution time) and its `period` (release interval).

## 📄 Code Structure Highlights

| Function / Logic | Purpose |
| :--- | :--- |
| `main(String[] args)` | Handles user input for task parameters (Name, Burst Time, Period). |
| **Main Loop** (`while (processCount > 0)`) | The time-stepped simulation loop that models the scheduler's behavior. |
| `shortestPeriodIndex` | Variable used to dynamically track the index of the highest-priority task (minimum `processPeriod` value) that still has work to do (`burstTime > 0`). |
| **Preemption Logic** | The implementation inherently handles preemption by constantly checking the `shortestPeriodIndex` at every time step and ensuring only one task runs per cycle. |
| **Output** | Prints the completion time of each process, and conceptually calculates the turnaround and waiting times (though the logic for these metrics appears tailored for non-periodic tasks and may need re-validation for strict RMS analysis). |
