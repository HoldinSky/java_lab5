package task_10;

import java.util.Objects;

// Створити клас типу Прямокутник. Поля — висота і ширина.
// Функції-члени обчислюють площу, периметр, встановлюють іповертають значення полів.

public class Rectangle implements IQuadrangle {

    /**
     * Висота прямокутника. Одиниці вимірювання - см
     * */
    public final double height;

    /**
     * Ширина прямокутника. Одиниці вимірювання - см
     * */
    public final double base;

    public Rectangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double area() {
        return height * base;
    }

    @Override
    public double perimeter() {
        return 2 * height + 2 * base;
    }

    @Override
    public double getA() {
        return this.height;
    }

    @Override
    public double getB() {
        return this.base;
    }

    @Override
    public double getC() {
        return this.height;
    }

    @Override
    public double getD() {
        return this.base;
    }

    /**
     * Згенеровано за допомогою IDE IntelliJ IDEA
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(height, rectangle.height) == 0 && Double.compare(base, rectangle.base) == 0;
    }

    /**
     * Згенеровано за допомогою IDE IntelliJ IDEA
     * */
    @Override
    public int hashCode() {
        return Objects.hash(height, base);
    }

    @Override
    public String toString() {
        return String.format("Rectangle: { base = %fl; height = %fl }", this.base, this.height);
    }
}
