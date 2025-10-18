# Virtual Memory: Page Replacement Algorithms Simulation

## 🌟 Project Overview

This Java project simulates three fundamental **Page Replacement Algorithms**—**FIFO (First-In, First-Out)**, **LRU (Least Recently Used)**, and **Second Chance (SC)**—which are essential for managing a process's working set in physical memory (frames). The goal is to accurately model how each algorithm handles a stream of page references (`reference string`) and determine the resulting **Page Fault** rate for a given number of available memory **frames**.

The simulation allows for continuous input of page references until a sentinel value (`-1`) is entered.

## 🛠️ Technology Used

  * **Language:** Java
  * **Concepts:** Virtual Memory Management, Paging, Page Fault Handling, Data Structures (ArrayList).

## ⚙️ Algorithms Implemented

The simulation tracks the number of page faults (`count`) for each algorithm and outputs the content of the memory frames after each page reference.

### 1\. First-In, First-Out (FIFO)

  * **Function:** `FIFO(int number, ...)`
  * **Mechanism:** The page that has been in memory for the **longest time** is replaced. This is the simplest strategy but can suffer from the **Belady's Anomaly**.
  * **Implementation:** An `ArrayList<Integer>` is used to simulate the frame queue, where `fifo.remove(0)` naturally removes the oldest page.

### 2\. Least Recently Used (LRU)

  * **Function:** `LRU(int number, ...)`
  * **Mechanism:** The page that has **not been used for the longest period of time** is replaced. This is often the most effective algorithm but is computationally expensive to implement.
  * **Implementation:**
      * The `LRUOSC` class tracks the page `value` and its last access `time` (using `System.currentTimeMillis()`).
      * On a page hit, the page's timestamp is updated. On a miss, the page with the minimum timestamp is replaced.

### 3\. Second Chance (SC) / Clock

  * **Function:** `SCFunction(int number, ...)`
  * **Mechanism:** A modification of FIFO that gives pages a "second chance" to remain in memory. It uses a **reference bit** (`bit`). On replacement, it checks the bit: if `1`, the bit is reset to `0` and the page gets a second chance; if `0`, the page is replaced.
  * **Implementation:**
      * The `SC` class tracks the page `value`, last access `time`, and the `bit` (reference bit).
      * The algorithm uses a circular approach to find the first page with a `bit` value of `0` for replacement.

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
4.  **Input:** The program will first ask for:
      * `frame`: The number of available memory frames.
      * Then, it will continuously prompt for a page reference number (`amount`) until `-1` is entered.

## 📄 Code Structure Highlights

| Class / Function | Purpose |
| :--- | :--- |
| `LRUOSC` | Data structure for LRU (tracks page value and access timestamp). |
| `SC` | Data structure for Second Chance (tracks page value, timestamp, and reference bit). |
| `FIFO` | Implements the FIFO replacement policy. |
| `LRU` | Implements the LRU replacement policy, using time tracking for recency. |
| `SCFunction` | Implements the Second Chance replacement policy, using the reference bit logic. |
| `main` | Handles input loop, calls all three simulation functions, and reports the final page fault counts. |
