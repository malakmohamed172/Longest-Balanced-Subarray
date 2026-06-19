# Longest Balanced Binary Subarray Finder

<p align="center">
  <img src="screenshots/screenshot-03-long-array.jpeg" alt="Longest Balanced Binary Subarray Finder main result" width="850">
</p>

## Overview

Longest Balanced Binary Subarray Finder is a Java Swing desktop application that finds the length of the longest contiguous subarray containing an equal number of `0`s and `1`s.

The app compares two implementations:

- Non-recursive prefix-sum solution
- Recursive prefix-sum solution

Both results are displayed together so the output can be checked quickly.

## Features

- Simple Java Swing graphical interface
- Space-separated binary array input
- Non-recursive and recursive algorithm comparison
- Clear validation messages for invalid input
- Clean output panel with the parsed array and result

## Algorithm Idea

The algorithm treats each `0` as `-1` and each `1` as `+1`.

When the same prefix sum appears again, the elements between the first occurrence and the current index contain an equal number of `0`s and `1`s. The maximum distance between repeated prefix sums is the longest balanced subarray length.

## Complexity

| Approach | Time Complexity | Space Complexity |
| --- | --- | --- |
| Non-recursive | `O(n)` | `O(n)` |
| Recursive | `O(n)` | `O(n)` |

## Project Structure

```text
.
├── src/
│   ├── LongestBalancedSubarray.java
│   └── LongestBalancedSubarrayGUI.java
├── screenshots/
└── README.md
```

## Run Locally

Compile the project:

```bash
javac src/*.java
```

Run the GUI:

```bash
java -cp src LongestBalancedSubarrayGUI
```

## Example Inputs

```text
0 1
0 1 0
0 0 1 0 1 1 0
0 0 0 0
```

## Screenshots

### Valid Results

<p align="center">
  <img src="screenshots/screenshot-01-balanced-two-values.jpeg" alt="Balanced input with result 2" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-02-short-array.jpeg" alt="Short binary input with result 2" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-03-long-array.jpeg" alt="Long binary input with result 6" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-04-all-zeroes.jpeg" alt="All zeroes input with result 0" width="760">
</p>

### Input Validation

<p align="center">
  <img src="screenshots/screenshot-05-spacing-error.jpeg" alt="Input spacing error dialog" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-06-format-error.jpeg" alt="Invalid format error dialog" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-07-validation-error.jpeg" alt="Only zero and one validation error dialog" width="760">
</p>

<p align="center">
  <img src="screenshots/screenshot-08-letter-format-error.jpeg" alt="Letter input format error dialog" width="760">
</p>

## Contributor

Created by `malakmohamed217`.
