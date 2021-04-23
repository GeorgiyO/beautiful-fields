package nekogochan;

import nekogochan.fields.Field;

class Cat {
    public Field<String> name = new Field<>();
    public Field<Integer> age = new Field<>();
}

public class Main {

    public static void main(String[] args) {

        var cat = new Cat();
        cat.name.setter.decorator.add(String::trim).add(String::toUpperCase);
        cat.name.set("Томас");
        System.out.println(cat.name.get());

    }

}
