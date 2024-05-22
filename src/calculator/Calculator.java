package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    InputSpace inputSpace = new InputSpace();
    Keyboard keyboard = new Keyboard();
    ChangePanel changePanel = new ChangePanel();
    static JLabel label;
    static JLabel info;
    double num = 0;
    double result = 0;
    String expression = "";

    public Calculator() {
        setTitle("계산기");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_  ON_CLOSE);

        Container c = getContentPane();

        // Frame에 패널 추가
        c.add(inputSpace, BorderLayout.NORTH);
        c.add(keyboard, BorderLayout.CENTER);
        c.add(changePanel, BorderLayout.SOUTH);
        setSize(400, 700);
        setVisible(true);
    }

    // main 메소드
    public static void main(String[] args) {
        new Calculator();
    }

    // 상단창 클래스
    class InputSpace extends JPanel {
        public InputSpace() {
            setLayout(new GridLayout(3, 1));
            setBackground(Color.LIGHT_GRAY);
            info = new JLabel(" ");
            label = new JLabel(" ");

            info.setFont(new Font("", 0, 40));
            info.setForeground(Color.BLACK);
            info.setHorizontalAlignment(SwingConstants.RIGHT);

            label.setFont(new Font("", Font.BOLD, 55));
            label.setForeground(Color.BLACK);
            label.setHorizontalAlignment(SwingConstants.RIGHT);

            add(info);
            add(label);
        }
    }

    // 센터 창 클래스
    class Keyboard extends JPanel {
        public Keyboard() {
            JButton[] button = new JButton[20];
            this.setLayout(new GridLayout(5, 4));
            setSize(400, 600);
            this.setBackground(Color.DARK_GRAY);

            String arr[] = {"×", "÷", "AC", "CE",
                            "7", "8", "9", "√",
                            "4", "5", "6", "-",
                            "1", "2", "3", "+",
                            "＾2", "0", ".", "="};

            for (int i = 0; i < 20; i++) {
                button[i] = new JButton(arr[i]);
                add(button[i]);
                setSize(120, 100);
                button[i].addActionListener(new BtnListener());
            }
        }
    }

    class BtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String operation = e.getActionCommand();

            if (operation.equals("AC")) {
                label.setText(" ");
                info.setText(" ");
                expression = "";
            } else if (operation.equals("CE")) {
                int n = label.getText().length();
                if (n > 0) {
                    setBackSpace(getBackSpace().substring(0, getBackSpace().length() - 1));
                    expression = expression.substring(0, expression.length() - 1);
                }
                if (label.getText().isEmpty()) {
                    label.setText(" ");
                }
            } else if (operation.equals("=")) {
                String value = String.valueOf(result);
                String str = label.getText();
                info.setText(str);
                label.setText(value);
                result = 0;
                num = 0;
                expression = label.getText(); // 현재 입력된 수식 가져오기
                String[] tokens = expression.split("\\s+"); // 수식을 공백을 기준으로 분리하여 토큰 배열 생성
                result = calculateExpression(tokens); // 수식 계산
                label.setText(String.valueOf(result)); // 계산 결과를 라벨에 표시
            } else {
                label.setText(label.getText() + operation);
                expression += operation;
            }
        }
    }

    // 수식을 계산하는 메소드
    private double calculateExpression(String[] tokens) {
        double result = 0;
        double currentNumber = 0;
        char currentOperator = '+';

        for (String token : tokens) {
            if (isNumber(token)) { // 토큰이 숫자인 경우
                currentNumber = Double.parseDouble(token);
            } else { // 토큰이 연산자인 경우
                switch (token) {
                    case "+":
                        result = performOperation(result, currentNumber, currentOperator);
                        currentOperator = '+';
                        break;
                    case "-":
                        result = performOperation(result, currentNumber, currentOperator);
                        currentOperator = '-';
                        break;
                    case "×":
                        result = performOperation(result, currentNumber, currentOperator);
                        currentOperator = '×';
                        break;
                    case "÷":
                        result = performOperation(result, currentNumber, currentOperator);
                        currentOperator = '÷';
                        break;
                    default:
                        break;
                }
            }
        }

        // 마지막 연산 처리
        result = performOperation(result, currentNumber, currentOperator);

        return result;
    }

    // 연산 수행 메소드
    private double performOperation(double result, double currentNumber, char currentOperator) {
        switch (currentOperator) {
            case '+':
                result += currentNumber;
                break;
            case '-':
                result -= currentNumber;
                break;
            case '×':
                result *= currentNumber;
                break;
            case '÷':
                if (currentNumber != 0) {
                    result /= currentNumber;
                } else {
                    // 0으로 나눌 때의 예외 처리
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                break;
        }
        return result;
    }

    // 문자열이 숫자인지 확인하는 메소드
    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void setBackSpace(String bs) {
        label.setText(bs);
    }

    private String getBackSpace() {
        return label.getText();
    }
}

class ChangePanel extends JPanel {
    private JPanel win;

    public ChangePanel() {
        this.win = win;

        setLayout(new FlowLayout());
        JButton change = new JButton();
        change.setText(">>>");

        add(change);

        change.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener {    // 버튼 키 눌리면 패널 2번 호출
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

class Calculate implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
}
