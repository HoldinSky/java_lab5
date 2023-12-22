package task_34;

import java.util.Objects;

/**
 * Базовий клас для усіх типів телефонів, що містить основну інформацію.
 */
public class MobilePhone {

    /**
     * Повна назва телефона
     */
    protected final String title;

    /**
     * Вага телефону (грам)
     */
    protected final int weight;

    /**
     * Діагональ екрану (дюйми)
     */
    protected final double diagonal;

    /**
     * Інформація про наявність камери
     */
    protected final boolean hasCamera;

    public MobilePhone(String title, int weight, double diagonal, boolean hasCamera) {
        this.title = title;
        this.weight = weight;
        this.diagonal = diagonal;
        this.hasCamera = hasCamera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        return weight == that.weight &&
                Double.compare(diagonal, that.diagonal) == 0 &&
                hasCamera == that.hasCamera &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, diagonal, hasCamera);
    }

    @Override
    public String toString() {
        return "MobilePhone {" +
                " title='" + title +
                "', weight=" + weight +
                ", diagonal=" + diagonal +
                ", hasCamera=" + hasCamera +
                '}';
    }
}
