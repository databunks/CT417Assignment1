package org.CT417Assignment1;

import java.util.ArrayList;

public class Module
{
    private String name;
    private String id;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private Lecturer lecturer;

    public Module(String name, String id, ArrayList<Student> students, ArrayList<Course> courses, Lecturer lecturer)
    {
        this.name = name;
        this.id = id;
        this.students = students;
        this.courses = courses;
        this.lecturer = lecturer;

        if (this.courses == null)
        {
            this.courses = new ArrayList<Course>();
        }

        if (this.lecturer != null)
        {
            this.lecturer.AddModule(this);
        }


        if (this.students == null)
        {
            this.students = new ArrayList<Student>();
        }
        else
        {
            for (int i = 0; i < students.size(); i++)
            {
                Student student = students.get(i);
                student.AddModule(this);
                students.set(i,student);
            }
        }



    }

    public String GetName()
    {
        return this.name;
    }

    public String GetId()
    {
        return this.id;
    }

    public ArrayList<Student> GetStudents()
    {
        return this.students;
    }

    public ArrayList<Course> GetCourses()
    {
        return this.courses;
    }

    public Lecturer GetLecturer()
    {
        return this.lecturer;
    }

    public void SetName(String name)
    {
        this.name = name;
    }

    public void SetId(String name)
    {
        this.name = name;
    }

    public void SetStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    public void SetCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }

    public void SetLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    public void AddCourse(Course course)
    {
        this.courses.add(course);
    }

    @Override
    public String toString()
    {
        String format = "";

        format += "Module Name: " + GetName() + "\n";
        format += "Module Id: " + GetId() + "\n";
        format += "Assigned Lecturer: " + GetLecturer() + "\n";

        format += "Assigned Courses: \n\n";

        if (GetCourses() != null)
        {
            for (Course course : GetCourses())
            {
                format += "Name: " + course.GetName() + "\n";
            }
        }

        format += "\nAssigned Students: \n\n";

        if (GetStudents() != null)
        {
            for (Student student : GetStudents())
            {
                format += "Username: " + student.GetUsername() + "\n";
            }
        }


        return format;
    }
}