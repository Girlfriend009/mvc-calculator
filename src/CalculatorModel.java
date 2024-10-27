// Класс CalculatorModel содержит бизнес-логику калькулятора (арифметические операции)
public class CalculatorModel {

    // Метод для выполнения операции сложения двух чисел
    public double add(double a, double b) {
        // Возвращаем результат сложения двух чисел
        return a + b;
    }

    // Метод для выполнения операции вычитания двух чисел
    public double subtract(double a, double b) {
        // Возвращаем результат вычитания b из a
        return a - b;
    }

    // Метод для выполнения операции умножения двух чисел
    public double multiply(double a, double b) {
        // Возвращаем результат умножения двух чисел
        return a * b;
    }

    // Метод для выполнения операции деления двух чисел
    // Добавляем проверку деления на ноль для предотвращения ошибок
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            // Если второе число равно нулю, выбрасываем исключение для обработки ошибки
            throw new ArithmeticException("Ошибка: деление на ноль невозможно.");
        }
        // Возвращаем результат деления a на b
        return a / b;
    }
}
