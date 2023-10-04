import java.util.Objects;

public class Human
{
    private String firstname;
    private String midlename;
    private String lastname;
    private int age;
    private Gender gender;

    public Human(String firstname, String midlename, String lastname, int age, Gender people)
    {
        this.firstname = firstname;
        this.midlename = midlename;
        this.lastname = lastname;
        this.age = age;
        this.gender = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstname, human.firstname) && Objects.equals(midlename, human.midlename) && Objects.equals(lastname, human.lastname) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, midlename, lastname, age, gender);
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMidlename(String midlename) {
        this.midlename = midlename;
    }

    public String getMidlename() {
        return midlename;
    }
}
