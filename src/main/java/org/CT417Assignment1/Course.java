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

    public Course(String name, ArrayList<Module> modules, ArrayList<Student> students, DateTime startDate, DateTime endDate)
    {
        this.name = name;
        this.modules = modules;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;

        if (this.modules == null)
        {
            this.modules = new ArrayList<Module>();
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
                student.AddCourse(this);
                students.set(i,student);
            }
        }

    }

    public String GetName()
    {
        return this.name;
    }

    public ArrayList<Module> GetModules()
    {
        return this.modules;
    }

    public ArrayList<Student> GetStudents()
    {
        return this.students;
    }

    public DateTime GetStartDate()
    {
        return startDate;
    }

    public DateTime GetEndDate()
    {
        return endDate;
    }

    public void SetName(String name)
    {
        this.name = name;
    }

    public void SetModules(ArrayList<Module> modules)
    {
        this.modules = modules;
    }

    public void SetStudents(ArrayList<Student> students)
    {
        this.students = students;
    }

    public void SetStartDate(DateTime startDate)
    {
        this.startDate = startDate;
    }

    public void SetEndDate(DateTime endDate)
    {
        this.endDate = endDate;
    }

    @Override
    public String toString()
    {
        String format = "";

        format += GetName() + "\n";
        format +=  GetStartDate() + "\n";
        format += GetEndDate() + "\n";

        format += "Assigned Modules: \n\n";

        if (GetModules() != null)
        {
            for (Module module : GetModules())
            {
                format += "Name: " + module.GetName() + "\n";
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
