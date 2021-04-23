package nekogochan.fields;

public class Ref<Type> implements IField<Type> {
    public Type val;

    public Ref() {
    }

    public Ref(Type val) {
        this.val = val;
    }

    @Override
    public void accept(Type val) {
        this.val = val;
    }

    @Override
    public Type get() {
        return val;
    }
}
