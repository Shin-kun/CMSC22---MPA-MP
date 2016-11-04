import java.io.Serializable;

/**
 * Created by niervin on 11/4/2016.
 */
public class Course implements Serializable{
    private String courseCode;
    private String courseDesc;

    public Course() { super(); }

    public Course(String courseCode, String courseDesc) {
        super();
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
}
