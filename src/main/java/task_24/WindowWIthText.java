package task_24;


import java.util.Objects;

/**
 * Розширений клас з функціоналом додавання тексту до вікна.
 */
public class WindowWIthText extends Window {

    private final String text;
    private final String textColour;

    /**
     * Усі поля вікна є константами, тому створення екземпляру - єдина можливість їх задавати.
     *
     * @param left   координата по Х лівого краю вікна
     * @param top    координата по У верхнього краю вікна
     * @param right  координата по Х правого краю вікна
     * @param bottom коодината по У нижнього краю вікна
     * @param colour значення кольору фону вікна
     * @param text повідомлення, що буде відображено на вікні
     * @param textColour колір повідомлення
     */
    public WindowWIthText(double left, double top, double right, double bottom, String colour, String text,
                          String textColour) {
        super(left, top, right, bottom, colour);

        this.text = text;
        this.textColour = textColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WindowWIthText that = (WindowWIthText) o;
        return Objects.equals(text, that.text) && Objects.equals(textColour, that.textColour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text, textColour);
    }

    @Override
    public String toString() {
        return "WindowWIthText{" +
                "text='" + text +
                "', textColour='" + textColour +
                "', left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", colour='" + colour +
                "'}";
    }

    public String getText() {
        return text;
    }

    public String getTextColour() {
        return textColour;
    }
}
