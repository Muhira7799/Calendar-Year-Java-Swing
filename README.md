# Calendar Year – Java Swing

A Java desktop application built with Swing. The user types a year, and the program shows a text calendar for all twelve months of that year.

## Features

- Input field for the year and a **Show Calendar** button
- Calendar for all 12 months in a scrollable text area
- Weeks start on Sunday (`Su Mo Tu We Th Fr Sa`)
- Correct weekday alignment and month lengths, including leap years, using `java.time`
- Validation: only years from 1 to 9999 are accepted
- A monospaced font keeps the columns aligned

## Sample Output

For the year `2026`, the text area starts like this:

```
      January 2026
Su Mo Tu We Th Fr Sa
             1  2  3
 4  5  6  7  8  9 10
11 12 13 14 15 16 17
...
```

## Messages

| Input | Message shown |
|-------|---------------|
| `2026` | The 12-month calendar |
| `0` or `10000` | Enter a year from 1 to 9999. |
| `abc` or empty | Please enter a valid year. |

## How It Works

1. The year is read with `Integer.parseInt()`.
2. For each month, `YearMonth` gives the month name and number of days.
3. The weekday of the 1st decides how many blank spaces to add before day 1.
4. Days are added with `String.format("%2d ", day)`, and a new line starts after every Saturday.
5. The whole text is built with a `StringBuilder` and shown in the text area.

## Requirements

- Java Development Kit (JDK) 8 or higher (Swing and `java.time` are included in the JDK)

## Getting Started

```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
javac CalendarYear.java
java CalendarYear
```

## Project Structure

```
.
├── CalendarYear.java
└── README.md
```

## Possible Improvements

- Show the current year when the window opens
- Press Enter in the year field to show the calendar
- Highlight today's date
- Add buttons for the previous and next year
