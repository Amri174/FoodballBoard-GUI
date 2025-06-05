# Football Player Management System (Java Swing GUI)

Java Swing-based application for managing football team player data, featuring OOP design, robust event handling, and a user-friendly interface for both field players and goalkeepers.

<br>

## Features

| Module                | Key Components                                | 
|-----------------------|-----------------------------------------------|
| Player Management     | Add/search Field Players and Goalkeepers      | 
| Best Player Finder    | Identify top Field Player & Goalkeeper        |
| Navigation            | First/Previous/Next/Last record controls      |
| Error Handling        | Custom exceptions for input validation        |
| UI/UX                 | Manual layout, JTextArea, JRadioButton, etc. |

<br>

## Technical Highlights

- **Object-Oriented Design**  
  (Class hierarchy: `Human` ← `FieldPlayer` / `Goalkeeper`)
- **Event-Driven Architecture**  
  (Implements `ActionListener` for all button actions)
- **Custom Exception Handling**  
  (`EmptyyException`, `Empty1Exception` for user input validation)
- **GUI Development**  
  (Swing components: `JFrame`, `JLabel`, `JTextField`, `JTextArea`, `JButton`, `JRadioButton`)

<br>

## Getting Started

* **Clone this repository:**
    ```
    git clone [<your-repo-url>](https://github.com/Amri174/FoodballBoard-GUI.git)
    ```
* **Prerequisites:**
    - Java 8+ (or any version with Swing support)

* **Compile and Run:**
    ```
    javac FDB.java
    java FDB
    ```

<br>

## Usage

- **Add Player:**  
  Select player type (Field Player or Goalie), enter details, and click "Insert".
- **Search:**  
  Enter player ID and click "Search" to view details.
- **Best Player:**  
  Click "BestPlayer" to view the top field player and goalkeeper.
- **Navigate:**  
  Use `<<`, `<`, `>`, `>>` to browse player records.

<br>




