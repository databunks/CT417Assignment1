package org.CT417Assignment1;

import java.util.ArrayList;

public class Module
{
    private String name;
    private String id;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private Lecturer lecturer;

    /**
     * Constructor for the Module course
     * @param name of the module
     * @param id of the module
     * @param students assigned to the module
     * @param courses assigned to the module
     * @param lecturer assigned to the module
     */
    public Module(String name, String id, ArrayList<Student> students, ArrayList<Course> courses, Lecturer lecturer)
    {
        this.name = name;
        this.id = id;
        this.students = students;
        this.courses = courses;
        this.lecturer = lecturer;

        // if the courses are null then initialize the list
        if (this.courses == null)
        {
            this.courses = new ArrayList<Course>();
        }

        // if the lecturer is not empty assign the module to the lecturer
        if (this.lecturer != null)
        {
            this.lecturer.AddModule(this);
        }

        // if the list of students are null then initialize the list
        if (this.students == null)
        {
            this.students = new ArrayList<Student>();
        }
        else
        {
            // iterate through the list of students then assign the module to the student
            for (int i = 0; i < students.size(); i++)
            {
                Student student = students.get(i);
                student.AddModule(this);
                students.set(i,student);
            }
        }

    }

    /**
     * @return the name of the student
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * @return the id of the student
     */
    public String GetId()
    {
        return this.id;
    }

    /**
     * @return the list of students assigned to the module
     */
    public ArrayList<Student> GetStudents()
    {
        return this.students;
    }

    /**
     * @return the courses assigned to the module
     */
    public ArrayList<Course> GetCourses()
    {
        return this.courses;
    }

    /**
     * @return the lecturer assigned to the module
     */
    public Lecturer GetLecturer()
    {
        return this.lecturer;
    }

    /**
     * @param name of the module
     */
    public void SetName(String name)
    {
        this.name = name;
    }

    /**
     * @param id of the module
     */
    public void SetId(String id)
    {
        this.id = id;
    }

    /**
     * Set the students assigned to the module
     * @param students assigned to the module
     */
    public void SetStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    /**
     * Set the courses assigned to the module
     * @param courses assigned to the module
     */
    public void SetCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }

    /**
     * Set the lecturer assigned to the module
     * @param lecturer assigned to the module
     */
    public void SetLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    /**
     * Assign the module to the course
     * @param course to add to the module
     */
    public void AddCourse(Course course)
    {
        this.courses.add(course);
    }

    /**
     * Custom toString override for the module class
     * @return the formatted string
     */
    @Override
    public String toString()
    {
        String format = "";

        format += "Module Name: " + GetName() + "\n";
        format += "Module Id: " + GetId() + "\n";
        format += "Assigned Lecturer: " + GetLecturer() + "\n";

        format += "Assigned Courses: \n\n";

        // check if the list of courses are not null
        if (GetCourses() != null)
        {
            // iterate through the list of courses and add the name to the string
            for (Course course : GetCourses())
            {
                format += "Name: " + course.GetName() + "\n";
            }
        }

        format += "\nAssigned Students: \n\n";

        // if the list of students is not null
        if (GetStudents() != null)
        {
            // iterate through the list of students and add the username to the string
            for (Student student : GetStudents())
            {
                format += "Username: " + student.GetUsername() + "\n";
            }
        }

        return format;
    }
}