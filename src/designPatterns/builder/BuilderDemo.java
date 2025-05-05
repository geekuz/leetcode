package designPatterns.builder;

public class BuilderDemo {
    User user = new User.Builder()
        .firstName("Otabek")
        .lastName("Karimov")
        .age(24)
        .city("Tashkent")
        .country("Uzbekistan")
        .build();

}
