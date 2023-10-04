import java.util.Objects;

public class Student extends Human
{
    private String university;
    private String department;
    private String special;
    public Student(String firstname, String midlename, String lastname, String university, String department,
                   String special, int age, Gender people) {
        super(firstname, midlename, lastname, age, people);
        this.university = university;
        this.department = department;
        this.special = special;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpecial() {
        return special;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) && Objects.equals(department, student.department) && Objects.equals(special, student.special);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, department, special);
    }
}
