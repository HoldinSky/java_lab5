package task_10;


/**
 * Для забезпечення доступу до полів через функції необхідний цей інтерфейс,
 * що містить геттери для 4х сторін чотирикутника.
 */
public interface IQuadrangle extends IFigure {
    double getA();

    double getB();

    double getC();

    double getD();
}