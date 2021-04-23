package nekogochan.fields;

import java.util.function.Supplier;

public interface IField<Type> extends Supplier<Type>, Setter<Type> {
    default void set(Type value) {
        accept(value);
    }
}
