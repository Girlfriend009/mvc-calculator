// Импортируем библиотеку javax.swing для создания элементов графического интерфейса
// Эта библиотека включает такие компоненты, как окна, кнопки, текстовые поля и панели.
import javax.swing.*;

// Импортируем библиотеку java.awt для работы с макетами и управления расположением элементов в окне
// GridLayout, BorderLayout и другие классы для управления компоновкой интерфейса входят в этот пакет.
import java.awt.*;

// Импортируем ActionListener из библиотеки java.awt.event для обработки событий
// ActionListener используется для обработки событий, связанных с действиями пользователя, например, нажатиями кнопок.
import java.awt.event.ActionListener;


// Класс CalculatorView отвечает за отображение пользовательского интерфейса калькулятора
public class CalculatorView extends JFrame {

    // Поля для ввода чисел. Используем JTextField для ввода данных
    private final JTextField firstNumber = new JTextField(10);  // Поле для первого числа
    private final JTextField secondNumber = new JTextField(10); // Поле для второго числа

    // Поле для отображения результата
    private final JTextField result = new JTextField(10);

    // Кнопки для арифметических операций
    private final JButton addButton = new JButton("+");        // Кнопка сложения
    private final JButton subtractButton = new JButton("-");   // Кнопка вычитания
    private final JButton multiplyButton = new JButton("*");   // Кнопка умножения
    private final JButton divideButton = new JButton("/");     // Кнопка деления

    // Конструктор для инициализации интерфейса
    public CalculatorView() {
        // Устанавливаем заголовок окна
        setTitle("Калькулятор MVC");
        // Завершаем работу программы при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Задаем размеры окна калькулятора
        setSize(400, 200);

        // Создаем панель для размещения компонентов интерфейса
        JPanel panel = new JPanel();
        // Используем GridLayout для упрощенного расположения элементов на панели
        panel.setLayout(new GridLayout(3, 2));

        // Добавляем метки и текстовые поля на панель
        panel.add(new JLabel("Первое число:"));   // Метка для первого числа
        panel.add(firstNumber);                   // Поле для первого числа
        panel.add(new JLabel("Второе число:"));   // Метка для второго числа
        panel.add(secondNumber);                  // Поле для второго числа
        panel.add(new JLabel("Результат:"));      // Метка для результата
        panel.add(result);                        // Поле для результата

        // Создаем отдельную панель для кнопок
        JPanel buttonPanel = new JPanel();
        // Размещаем кнопки в ряд с помощью GridLayout
        buttonPanel.setLayout(new GridLayout(1, 4));
        // Добавляем кнопки на панель
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Добавляем обе панели в окно (одну для полей ввода, другую для кнопок)
        this.add(panel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Метод для получения первого числа от пользователя
    public double getFirstNumber() {
        // Преобразуем текст из текстового поля в число типа double
        return Double.parseDouble(firstNumber.getText());
    }

    // Метод для получения второго числа от пользователя
    public double getSecondNumber() {
        // Преобразуем текст из текстового поля в число типа double
        return Double.parseDouble(secondNumber.getText());
    }

    // Метод для отображения результата на экране
    public void setResult(String resultText) {
        // Устанавливаем текстовое значение в поле результата
        result.setText(resultText);
    }

    // Геттеры для кнопок, чтобы контроллер мог обращаться к ним
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    // Метод для регистрации обработчиков событий для всех кнопок
    public void addOperationListener(ActionListener listener) {
        // Подключаем одного слушателя ко всем кнопкам
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }

    // Метод для отображения сообщения об ошибке
    public void showError(String errorMessage) {
        // Отображаем всплывающее окно с текстом ошибки
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
