package nekogochan.fields;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Field<Type> implements IField<Type> {

    public final RField<Type> getter;
    public final WField<Type> setter;

    public Field(Supplier<Type> getter, Consumer<Type> setter) {
        this.getter = new RField<>(getter);
        this.setter = new WField<>(setter);
    }

    public Field(Field<Type> field) {
        getter = field.getter;
        setter = field.setter;
    }

    public Field(Ref<Type> ref) {
        this(ref, ref);
    }

    public Field(Type value) {
        this(new Ref<>(value));
    }

    public Field() {
        this(new Ref<>());
    }

    @Override
    public void accept(Type value) {
        setter.accept(value);
    }

    @Override
    public Type get() {
        return getter.get();
    }
}
