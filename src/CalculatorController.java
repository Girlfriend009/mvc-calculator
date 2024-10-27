// Импортируем класс ActionEvent из пакета java.awt.event для обработки событий действий
// ActionEvent представляет событие, которое возникает при взаимодействии пользователя с элементами интерфейса,
// например, при нажатии кнопки или выборе элемента меню.
import java.awt.event.ActionEvent;

// Импортируем интерфейс ActionListener из пакета java.awt.event для регистрации и обработки событий
// ActionListener слушает события действий (ActionEvent) и реализует метод actionPerformed,
// который вызывается, когда пользователь взаимодействует с элементом интерфейса, например, нажимает кнопку.
import java.awt.event.ActionListener;


// Класс CalculatorController управляет взаимодействием между Model и View
public class CalculatorController {

    private final CalculatorModel model;  // Ссылка на модель для выполнения вычислений
    private final CalculatorView view;    // Ссылка на представление для отображения данных

    // Конструктор, связывающий модель и представление
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;  // Инициализируем модель
        this.view = view;    // Инициализируем представление

        // Регистрация слушателя нажатий кнопок
        this.view.addOperationListener(new OperationListener());
    }

    // Внутренний класс, который обрабатывает события от кнопок
    class OperationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Получаем введенные пользователем числа
                double firstNumber = view.getFirstNumber();
                double secondNumber = view.getSecondNumber();
                double result = 0; // Переменная для хранения результата операции

                // Проверяем, какая кнопка была нажата
                if (e.getSource() == view.getAddButton()) {
                    // Выполняем операцию сложения
                    result = model.add(firstNumber, secondNumber);
                } else if (e.getSource() == view.getSubtractButton()) {
                    // Выполняем операцию вычитания
                    result = model.subtract(firstNumber, secondNumber);
                } else if (e.getSource() == view.getMultiplyButton()) {
                    // Выполняем операцию умножения
                    result = model.multiply(firstNumber, secondNumber);
                } else if (e.getSource() == view.getDivideButton()) {
                    // Выполняем операцию деления
                    result = model.divide(firstNumber, secondNumber);
                }

                // Отображаем результат в представлении
                view.setResult(String.valueOf(result));

            } catch (ArithmeticException ex) {
                // Обрабатываем деление на ноль и другие арифметические ошибки
                view.showError(ex.getMessage());
            } catch (NumberFormatException ex) {
                // Обрабатываем ошибки ввода (если введены нечисловые данные)
                view.showError("Ошибка: введены некорректные данные.");
            }
        }
    }
}
