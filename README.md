# CMPE343 OOP School Simulation

A console-based, menu-driven Java application developed for the CMPE343 Object-Oriented Programming course. The program simulates different levels of an educational journey — from Primary School to University — each offering interactive tasks and mini-games implemented entirely in Java.

## Team — Group 10

| Name | Role |
|---|---|
| Gökdeniz Demircioğlu | Primary School module |
| Taha Söğüt | High School module |
| Kerem İrfanoğlu | University module |
| Ayşenur Gülfem Kömürcü | Secondary School module |

## Features Overview

The application presents a main menu with four school-level sections plus an exit option:

```
[A] Primary School
[B] Secondary School
[C] High School
[D] University
[E] Terminate
```

### A — Primary School

| Option | Description |
|---|---|
| Age & Zodiac Detection | Enter a birth date and a current date. The program calculates the exact age in years, months, and days, and determines the Western zodiac sign. Full date validation (including leap years) is performed. |
| Reverse Words | Enter a sentence and choose how to reverse it: reverse only the letters within each word while keeping punctuation in place, or fully reverse each word character by character. |

### B — Secondary School

| Option | Description |
|---|---|
| Prime Numbers | Enter an integer N (≥ 12). The program finds all primes up to N using three classic algorithms — **Sieve of Eratosthenes**, **Sieve of Sundaram**, and **Sieve of Atkin** — and displays the first three primes, the last two primes, and the execution time of each algorithm in nanoseconds. |
| Step-by-step Evaluation | Enter a mathematical expression using `+`, `-`, `*`, `/`, and parentheses. The program tokenizes the expression and evaluates it step by step, printing each intermediate result. Supports alternative operator symbols (`x`, `×`, `:`, `−`). Division by zero is caught and reported. |

### C — High School

| Option | Description |
|---|---|
| Statistical Information about an Array | Enter an array of up to 20 decimal numbers (range −1,000,000 to +1,000,000). The program computes and displays the **sorted array**, **median**, **arithmetic mean**, **geometric mean**, and **harmonic mean** (the latter two using recursion). |
| Distance Between Two Arrays | Enter two arrays of the same length (1–20, values 0–9). The program calculates the **Manhattan distance**, **Euclidean distance**, and **cosine similarity** between the two arrays. |

### D — University — Connect Four

A fully playable Connect Four game with:

- **Configurable board sizes**: 5×4, 6×5, or 7×6.
- **Singleplayer** — play against a computer that picks columns randomly.
- **Multiplayer** — two human players take turns at the same terminal.
- **Animated disc drop** — discs visually fall to the bottom of the column.
- Win detection for horizontal, vertical, and diagonal alignments.
- Post-game menu: restart, return to University menu, or return to the main menu.

## Project Structure

```
src/
└── Group10.java   # Single-file application containing all logic
```

All code resides in the single public class `Group10`. ANSI escape codes are used throughout for coloured console output.

## Requirements

- **Java 17** or later (uses switch expressions introduced in Java 14+).
- A terminal that supports **ANSI colour codes** (Linux, macOS, Windows Terminal, or IntelliJ IDEA's integrated console).

## How to Compile and Run

```bash
# From the repository root
javac src/Group10.java -d out
java -cp out Group10
```

Or with a single command:

```bash
cd src && javac Group10.java && java Group10
```

On startup, an animated ASCII-art intro sequence plays before the main menu appears. Press **Enter** to skip to the menu after the intro.

## Input Validation

All user inputs are validated throughout the application:

- Non-integer inputs where integers are expected trigger an error message and re-prompt.
- Out-of-range values are rejected with a descriptive error.
- Empty inputs are explicitly handled.
- Integer overflow is caught using `BigInteger` where applicable.
- Mathematical edge cases (e.g. division by zero, negative values in geometric/harmonic mean) are reported clearly.
