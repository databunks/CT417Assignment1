package org.CT417Assignment1;

import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student
{
    private String name;
    private int age;
    private DateTime dob;
    private static long id = 0;
    private String username;
    private ArrayList<Course> courses;
    private ArrayList<Module> modules;

    /**
     * Constructor for the student
     * @param name of the student
     * @param age of the student
     * @param dob (Date of Birth) of the student
     * @param courses assigned to the student
     * @param modules assigned to the student
     */
    public Student(String name, int age, DateTime dob, ArrayList<Course> courses, ArrayList<Module> modules)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id++;
        this.courses = courses;
        this.modules = modules;

        // if the list of modules is null then initialize it
        if (this.modules == null)
        {
            this.modules = new ArrayList<Module>();
        }

        // if the list of courses is null then initialize it
        if (this.courses == null)
        {
            this.courses = new ArrayList<Course>();
        }

        // give the student a username
        String nameWithoutSpaces = this.name.replaceAll("\\s+","");
        this.username = nameWithoutSpaces + this.age;
    }

    /**
     * @return the name of the student
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * @return the age of the student
     */
    public int GetAge()
    {
        return this.age;
    }

    /**
     * @return the username of the student
     */
    public String GetUsername()
    {
        return this.username;
    }

    /**
     * @return the date of birth of the student
     */
    public DateTime GetDateOfBirth()
    {
        return this.dob;
    }

    /**
     * @return the id of the student
     */
    public long GetId()
    {
        return this.id;
    }

    /**
     * @return the courses assigned to the student
     */
    public ArrayList<Course> GetCourses()
    {
        return this.courses;
    }

    /**
     * @return the modules assigned to the student
     */
    public ArrayList<Module> GetModules()
    {
        return this.modules;
    }

    /**
     * Set the name of the student
     * @param name of the student
     */
    public void SetName(String name)
    {
        this.name = name;
    }

    /**
     * Set the age of the student
     * @param age of the student
     */
    public void SetAge(int age)
    {
        this.age = age;
    }

    /**
     * Set the username of the student
     * @param username of the student
     */
    public void SetUsername(String username)
    {
        this.username = username;
    }

    /**
     * Set the date of birth of the student
     * @param dob of the student
     */
    public void SetDateOfBirth(DateTime dob)
    {
        this.dob = dob;
    }

    /**
     * Set the id of the student
     * @param id of the student
     */
    public void SetId(long id)
    {
        this.id = id;
    }

    /**
     * Set the courses assigned to the courses
     * @param courses assigned to the courses
     */
    public void SetCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }

    /**
     * Set the modules assigned to the Student
     * @param modules of the student
     */
    public void SetModules(ArrayList<Module> modules)
    {
        this.modules = modules;
    }

    /**
     * Assign a module to the student
     * @param module assigned to the student
     */
    public void AddModule(Module module)
    {
        this.modules.add(module);
    }

    /**
     * Assign a course to the
     * @param course assigned to the Student
     */
    public void AddCourse(Course course)
    {
        this.courses.add(course);
    }

    /**
     * Custom toString override for the student class
     * @return the formatted string
     */
    @Override
    public String toString()
    {
        String format = "";

        format += "Student Name: " + GetName()  + "\n";
        format += "Student Age: " + GetAge()  + "\n";
        format += "Student DOB: " + GetDateOfBirth() + "\n";
        format += "Student Id: " + GetId() + "\n";
        format += "Student Username: " + GetUsername() + "\n";

        format += "Assigned Courses: \n\n";

        // Check if the courses are not null
        if (GetCourses() != null)
        {
            // iterate through the list of courses and add the name to the string
            for (Course course : GetCourses())
            {
                format += "Name: " + course.GetName() + "\n";
            }
        }

        format += "Assigned Modules: \n\n";

        // Check if the list of modules are not null
        if (GetModules() != null)
        {
            // iterate through the list of modules and add the name to the string
            for (Module module : GetModules())
            {
                format += "Name: " + module.GetName() + "\n";
            }
        }


        return format;
    }
}
