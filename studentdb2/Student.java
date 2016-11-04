/*
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 */

public class Student implements Serializable{
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushname;
    Course favesubj;

    public Student(){
        super();
    }

    public Student(Student student,Course cos) {
        super();
        this.studentNumber = student.studentNumber;
        this.firstName = student.firstName;
        this.middleInitial = student.middleInitial;
        this.lastName = student.lastName;
        this.course = student.course; // BSCS
        this.yearLevel = student.yearLevel;
        this.crushname = student.crushname;
        this.favesubj = cos;
    }


    public String getCrushname() { return crushname; }

    public void setCrushname(String crushname) { this.crushname = crushname; }

    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public char getMiddleInitial() {
        return middleInitial;
    }
    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getYearLevel() {
        return yearLevel;
    }
    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String toString(){
        return "\n\nStudent Number: "+getStudentNumber()+
                "\nName: "+getLastName()+", " + getFirstName() + " "+ getMiddleInitial()+"."
                +"\nProgram: "+getCourse()
                +"\nYear Level: " +getYearLevel()
                +"\nCrush's name: "+ getCrushname()
                +"\nCourse Code: " + favesubj.getCourseCode()
                +"\nCourse Desciption: " + favesubj.getCourseDesc();
    }

    public String toString(boolean a){
        return studentNumber + '\n' + firstName + '\n' + middleInitial + '\n' + lastName + '\n' + course + '\n' + yearLevel
                + '\n' + crushname + '\n' + favesubj.getCourseCode() + '\n' + favesubj.getCourseDesc();
    }
}
