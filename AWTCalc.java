import java.awt.*;
import java.awt.event.*;

public class AWTCalc extends Frame implements ActionListener {
    TextField t1, t2, result;
    Button add, sub, mul, div;

    AWTCalc() {
        setLayout(new GridLayout(4, 2, 5, 5));
        t1     = new TextField(); t2 = new TextField();
        result = new TextField(); result.setEditable(false);
        add = new Button("+"); sub = new Button("-");
        mul = new Button("*"); div = new Button("/");

        add(new Label("Num 1:")); add(t1);
        add(new Label("Num 2:")); add(t2);
        add(new Label("Result:")); add(result);
        add(add); add(sub); add(mul); add(div);

        add.addActionListener(this); sub.addActionListener(this);
        mul.addActionListener(this); div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        setTitle("AWT Calculator");
        setSize(300, 200); setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        String cmd = e.getActionCommand();
        double ans = cmd.equals("+") ? a+b : cmd.equals("-") ? a-b :
                cmd.equals("*") ? a*b : a/b;
        result.setText(String.valueOf(ans));
    }

    public static void main(String[] args) { new AWTCalc(); }
}