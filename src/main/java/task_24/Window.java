package task_24;

import java.util.Objects;


// Створити клас Вікно, що включає координати (left, top, right, bottom) і колір вікна та клас
// Вікно з текстом, що включає поля текст та колір тексту у вікні.


/**
 * Базовий клас вікна з основними властивостями
 */
public class Window {

    protected final double left;
    protected final double top;
    protected final double right;
    protected final double bottom;
    protected final String colour;

    /**
     * Усі поля вікна є константами, тому створення екземпляру - єдина можливість їх задавати.
     *
     * @param left координата по Х лівого краю вікна
     * @param top координата по У верхнього краю вікна
     * @param right координата по Х правого краю вікна
     * @param bottom коодината по У нижнього краю вікна
     * @param colour значення кольору фону вікна
     */
    public Window(double left, double top, double right, double bottom, String colour) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return Double.compare(left, window.left) == 0 && Double.compare(top, window.top) == 0 && Double.compare(right
                , window.right) == 0 && Double.compare(bottom, window.bottom) == 0 && Objects.equals(colour,
                window.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, top, right, bottom, colour);
    }

    @Override
    public String toString() {
        return "Window{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", colour='" + colour +
                "'}";
    }

    public double getLeft() {
        return left;
    }

    public double getTop() {
        return top;
    }

    public double getRight() {
        return right;
    }

    public double getBottom() {
        return bottom;
    }

    public String getColour() {
        return colour;
    }
}
