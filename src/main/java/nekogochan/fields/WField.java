package nekogochan.fields;

import java.util.function.Consumer;

public class WField<Type> implements Setter<Type> {

    public final Decorator<Type> decorator = new Decorator<>();
    private final Consumer<Type> setter;

    public WField(Consumer<Type> setter) {
        this.setter = setter;
    }

    public WField(Ref<Type> ref) {
        this.setter = ref;
    }

    @Override
    public void accept(Type value) {
        setter.accept(decorator.get().apply(value));
    }
}
