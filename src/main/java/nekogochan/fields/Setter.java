package nekogochan.fields;

import java.util.function.Consumer;

public interface Setter<Type> extends Consumer<Type> {
    default void set(Type value) {
        accept(value);
    }
}
