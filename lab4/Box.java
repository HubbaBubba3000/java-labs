import java.util.Objects;

public class Box<T> {
    private T value;

    /** Возвращает значение, не извлекая его из коробки. */
    public T get() {
        return value;
    }

    /** Помещает объект в пустую коробку. */
    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Коробка уже заполнена");
        }
        this.value = Objects.requireNonNull(value, "Нельзя поместить null в коробку");
    }

    /** Возвращает значение и освобождает коробку. */
    public T pop() {
        T result = value;
        value = null;
        return result;
    }

    public boolean isFull() {
        return value != null;
    }
}
