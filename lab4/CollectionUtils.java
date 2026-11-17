import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static double maxBox(Collection<? extends Box<? extends Number>> boxes) {
        Objects.requireNonNull(boxes, "Набор коробок не должен быть null");
        if (boxes.isEmpty()) {
            throw new NoSuchElementException("Набор коробок пуст");
        }

        double max = Double.NEGATIVE_INFINITY;
        for (Box<? extends Number> box : boxes) {
            Objects.requireNonNull(box, "Коробка не должна быть null");
            Number value = box.get();
            if (value == null) {
                throw new NoSuchElementException("Одна из коробок пуста");
            }
            max = Math.max(max, value.doubleValue());
        }
        return max;
    }

    public static <T, P> List<P> map(List<? extends T> source,
                                     Mapper<? super T, ? extends P> mapper) {
        Objects.requireNonNull(source, "Исходный список не должен быть null");
        Objects.requireNonNull(mapper, "Преобразователь не должен быть null");

        List<P> result = new ArrayList<>(source.size());
        for (T item : source) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static <T> List<T> filter(List<? extends T> source,
                                     Validator<? super T> validator) {
        Objects.requireNonNull(source, "Исходный список не должен быть null");
        Objects.requireNonNull(validator, "Проверка не должна быть null");

        List<T> result = new ArrayList<>();
        for (T item : source) {
            if (validator.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> T reduce(List<? extends T> source, Reducer<T> reducer, T emptyValue) {
        Objects.requireNonNull(source, "Исходный список не должен быть null");
        Objects.requireNonNull(reducer, "Способ свёртки не должен быть null");

        if (source.isEmpty()) {
            return emptyValue;
        }

        T result = source.get(0);
        for (int index = 1; index < source.size(); index++) {
            result = reducer.apply(result, source.get(index));
        }
        return result;
    }

    public static <T, P> P collect(List<? extends T> source,
                                   Creator<? extends P> creator,
                                   Putter<? super P, ? super T> putter) {
        Objects.requireNonNull(source, "Исходный список не должен быть null");
        Objects.requireNonNull(creator, "Создатель коллекции не должен быть null");
        Objects.requireNonNull(putter, "Способ добавления не должен быть null");

        P result = Objects.requireNonNull(creator.create(), "Создатель вернул null");
        for (T item : source) {
            putter.put(result, item);
        }
        return result;
    }

    @FunctionalInterface
    public interface Mapper<T, P> {
        P apply(T value);
    }

    @FunctionalInterface
    public interface Validator<T> {
        boolean test(T value);
    }

    @FunctionalInterface
    public interface Reducer<T> {
        T apply(T first, T second);
    }

    @FunctionalInterface
    public interface Creator<P> {
        P create();
    }

    @FunctionalInterface
    public interface Putter<P, T> {
        void put(P collection, T value);
    }
}
