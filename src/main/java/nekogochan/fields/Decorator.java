package nekogochan.fields;

import java.util.function.UnaryOperator;

public class Decorator<Type> {
    private UnaryOperator<Type> current = UnaryOperator.identity(); // do nothing without adding new decorators

    public Decorator<Type> set(UnaryOperator<Type> decorator) {
        current = decorator;
        return this;
    }

    public Decorator<Type> add(UnaryOperator<Type> decorator) {
        UnaryOperator<Type> previous = current;
        current = (value) -> {
            value = previous.apply(value);
            return decorator.apply(value);
        };
        return this;
    }

    public UnaryOperator<Type> get() {
        return current;
    }

    public void copyTo(Decorator<Type> decorator) {
        decorator.set(current);
    }

}
