package org.CT417Assignment1;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class Course
{
    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private DateTime startDate;
    private DateTime endDate;

    /**
     * Constructor for Course class
     * @param name of the course
     * @param modules the course contains
     * @param students the course has
     * @param startDate of the course
     * @param endDate of the course
     */
    public Course(String name, ArrayList<Module> modules, ArrayList<Student> students, DateTime startDate, DateTime endDate)
    {
        this.name = name;
        this.modules = modules;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;

        // Null check and initialize the list of modules if null
        if (this.modules == null)
        {
            this.modules = new ArrayList<Module>();
        }
        else
        {
            // Iterate through the list of modules and add the assigned course to them
            for (int i = 0; i < modules.size(); i++)
            {
                Module module = this.modules.get(i);
                module.AddCourse(this);
                modules.set(i,module);
            }
        }

        // Iterate through the list of students and add the assigned course to them
        if (this.students == null)
        {
            this.students = new ArrayList<Student>();
        }
        else
        {
            for (int i = 0; i < students.size(); i++)
            {
                Student student = students.get(i);
                student.AddCourse(this);
                students.set(i,student);
            }
        }

    }

    /**
     * @return the name of the course
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * @return the list of modules
     */
    public ArrayList<Module> GetModules()
    {
        return this.modules;
    }

    /**
     * @return the list of students assigned to the course
     */
    public ArrayList<Student> GetStudents()
    {
        return this.students;
    }

    /**
     * @return the start date of the course
     */
    public DateTime GetStartDate()
    {
        return startDate;
    }

    /**
     * @return The end date of the course
     */
    public DateTime GetEndDate()
    {
        return endDate;
    }

    /**
     * Sets the name assigned to the course
     * @param name of the course
     */
    public void SetName(String name)
    {
        this.name = name;
    }

    /**
     * Set the modules assigned to the course
     * @param modules of the course
     */
    public void SetModules(ArrayList<Module> modules)
    {
        this.modules = modules;
    }

    /**
     * Set the students assigned to the course
     * @param students of the course
     */
    public void SetStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    /**
     * Set the start date assigned to the course
     * @param startDate of the course
     */
    public void SetStartDate(DateTime startDate)
    {
        this.startDate = startDate;
    }

    /**
     * Set the end date of the course
     * @param endDate of the course
     */
    public void SetEndDate(DateTime endDate)
    {
        this.endDate = endDate;
    }

    /**
     * Custom toString override for the course
     * @return the format of the string
     */
    @Override
    public String toString()
    {
        String format = "";

        format += "Course Name: " + GetName() + "\n";
        format +=  "Course Start Date: " + GetStartDate() + "\n";
        format += "Course End Date: " + GetEndDate() + "\n";

        format += "\nAssigned Modules: \n\n";

        // Check if the modules are not null
        if (GetModules() != null)
        {
            // Iterate through the modules and add the names to the string
            for (Module module : GetModules())
            {
                format += "Name: " + module.GetName() + "\n";
            }
        }

        format += "\nAssigned Students: \n\n";

        // Check if the students are not null
        if (GetStudents() != null)
        {
            // Iterate through the students and add the username to the string
            for (Student student : GetStudents())
            {
                format += "Username: " + student.GetUsername() + "\n";
            }
        }

        return format;
    }
}
