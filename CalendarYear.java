import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarYear extends JFrame implements ActionListener {

    JTextField yearField;
    JButton showButton;
    JTextArea calendar;

    CalendarYear() {
        setTitle("Calendar Year");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Enter Year:"));

        yearField = new JTextField(8);
        topPanel.add(yearField);

        showButton = new JButton("Show Calendar");
        topPanel.add(showButton);

        add(topPanel, BorderLayout.NORTH);

        calendar = new JTextArea();
        calendar.setEditable(false);
        calendar.setFont(new Font("Monospaced", Font.PLAIN, 12));

        add(new JScrollPane(calendar), BorderLayout.CENTER);

        showButton.addActionListener(this);

        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int year = Integer.parseInt(yearField.getText());

            if (year < 1 || year > 9999) {
                calendar.setText("Enter a year from 1 to 9999.");
                return;
            }

            StringBuilder output = new StringBuilder();

            for (int month = 1; month <= 12; month++) {
                YearMonth ym = YearMonth.of(year, month);

                String monthName = ym.getMonth().getDisplayName(
                    TextStyle.FULL,
                    Locale.ENGLISH
                );

                output.append("\n      ")
                      .append(monthName)
                      .append(" ")
                      .append(year)
                      .append("\n");

                output.append("Su Mo Tu We Th Fr Sa\n");

                int firstDay = LocalDate.of(year, month, 1)
                    .getDayOfWeek()
                    .getValue() % 7;

                for (int i = 0; i < firstDay; i++) {
                    output.append("   ");
                }

                for (int day = 1; day <= ym.lengthOfMonth(); day++) {
                    output.append(String.format("%2d ", day));

                    if ((firstDay + day) % 7 == 0) {
                        output.append("\n");
                    }
                }

                output.append("\n");
            }

            calendar.setText(output.toString());
            calendar.setCaretPosition(0);

        } catch (NumberFormatException ex) {
            calendar.setText("Please enter a valid year.");
        }
    }

    public static void main(String[] args) {
        new CalendarYear();
    }
}