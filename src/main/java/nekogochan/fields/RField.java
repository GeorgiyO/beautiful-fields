package nekogochan.fields;

import java.util.function.Supplier;

public class RField<Type> implements Supplier<Type> {

    public final Decorator<Type> decorator = new Decorator<>();
    private final Supplier<Type> getter;

    public RField(Supplier<Type> getter) {
        this.getter = getter;
    }

    public RField(Ref<Type> ref) {
        this.getter = ref;
    }

    @Override
    public Type get() {
        return decorator.get().apply(getter.get());
    }

}
