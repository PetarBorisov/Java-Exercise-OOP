package BirthdayCelebrations;


public class Citizen implements Person, Identifiable, Birthable {
        private String name;
        private int age;
        private String id;
        private String birthData;


    public Citizen(String name, int age, String id, String birthData) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthData = birthData;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getBirthData() {
        return birthData;
    }

    @Override
        public String getName() {
            return name;
        }

        @Override
        public int getAge() {
            return age;
        }

    @Override
    public String getBirthDate() {
        return birthData;
    }
}


