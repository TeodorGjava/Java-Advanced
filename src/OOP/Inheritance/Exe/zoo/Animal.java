package OOP.Inheritance.Exe.zoo;

public class Animal implements Sound{
    private String name;
    private int age;
    private String gender;

    private void setName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
      if(age<0){
          throw new IllegalArgumentException("Invalid input!");
      }
        this.age = age;
    }

    private void setGender(String gender) {
        if(!("Female".equals(gender) || "Male".equals(gender))) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public Animal(String name,int age, String gender) {
       setName(name);
       setAge(age);
       setGender(gender);
    }

    @Override
    public String produceSound() {
        return null;
    }
}
