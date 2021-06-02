package AlgoExc03;

public class Student {
    private String prename;
    private String surname;
    private int courseNumber;
    private int matriculationNumber;

    public Student(String prename, String surname, int courseNumber, int matriculationNumber) {
        super();
        this.prename = prename;
        this.surname = surname;
        this.courseNumber = courseNumber;
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student [prename=" + prename + ", surname=" + surname + ", course=" + courseNumber + ", matriculationNumber="
                + matriculationNumber + "]";
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }


    }
