package designPatterns.builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String city;
    private final String country;

    // ✅ Private constructor — only Builder can access
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.city = builder.city;
        this.country = builder.country;
    }

    // ✅ Static nested Builder class
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String city;
        private String country;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}






