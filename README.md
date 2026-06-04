# FIRE Resort Management System

A Java simulation of an island resort management system, built as coursework for module **7COM1015**. The system models a network of islands connected by ferry routes, where pass holders travel between islands based on their luxury rating and credit balance.

## Overview

The resort consists of multiple islands, each with a luxury rating and a maximum capacity. Pass holders start on the base island and can travel to other islands by ferry — provided they meet the destination's luxury rating requirement and have enough credits.

## How to Run

### Option 1: VS Code
1. Install the **Extension Pack for Java** (by Microsoft) from the VS Code extensions tab
2. Open this folder in VS Code: **File > Open Folder**
3. Open `ResortUI.java` and click the **Run** button above the `main` method for the interactive menu
4. Or open `DemoH.java` and click **Run** for a demo output

### Option 2: Command Line
Make sure you have the [JDK](https://adoptium.net) installed, then:

```bash
javac *.java
java ResortUI
```

> Run `java DemoH` instead for a pre-scripted demo without the interactive menu.

## Project Structure

| Class | Description |
|---|---|
| `FIRE` | Interface defining the core resort operations |
| `Resort` | Main class implementing `FIRE` - manages islands, ferries, and passes |
| `Island` | Represents an island with a name, luxury rating, and capacity |
| `Ferry` | Handles one-way journeys between two islands |
| `Pass` | Base class for a pass holder (ID, name, credits, luxury rating, points) |
| `VisitorPass` | Subclass of `Pass` - includes country of origin |
| `BusinessPass` | Subclass of `Pass` - for business travellers |
| `EmployeePass` | Subclass of `Pass` - for resort staff with a staff ID and role |
| `Bronze` | Subclass of `Pass` - budget pass with a discount rate |
| `ResortUI` | Text-based user interface for interacting with the resort |
| `DemoH` | Demo class with pre-written scenarios |
| `DemoHPassTest` | JUnit test class |

## Key Rules

- A ferry journey costs **3 credits** and earns **1 journey point**
- A pass can only travel if its luxury rating is **>=** the destination island's rating
- **5 journey points** can be converted into **1 credit**
- Islands have a maximum capacity and travel is blocked if the destination is full

## Islands

| Island | Luxury Rating | Capacity |
|---|---|---|
| Base | 0 | 100 |
| Yorke | 1 | 100 |
| Crunchie | 2 | 20 |
| Bounty | 3 | 10 |
| Aero | 1 | 1 |
| Twirl | 5 | 2 |

## Author

Oyenike Alade - 7COM1015 Coursework 1, November 2025
