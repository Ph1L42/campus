package Formula1;

public class Driver {

    private String firstName;
    private String lastName;
    private int age;
    //private int birthDate;
    private int heightInCm;
    private String nationality;
    Team team;
    private int raceNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }


    public Driver() {
    }

    public Driver(String firstName, String lastName, int age, String nationality, Team team, Integer raceNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.team = team;
        this.raceNumber = raceNumber;
    }

    public Driver(String firstName, String lastName, int age, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }


    public String toString() {

        if (team == null) {
            return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nNationality: " + nationality;
        }
        return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nTeam: " + team + "\nRacenumber : " + raceNumber + "\nNationality: " + nationality;
    }

}
