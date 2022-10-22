package org.CT417Assignment1;

import org.joda.time.DateTime;

import java.util.ArrayList;



public class Lecturer
{
    private String name;
    private int age;
    private DateTime dob;
    private static long id = 0;
    private String username;
    private ArrayList<Module> modules;

    public Lecturer(String name, int age, DateTime dob, ArrayList<Module> modules)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id++;
        this.modules = modules;
        String nameWithoutSpaces = this.name.replaceAll("\\s+","");
        this.username = nameWithoutSpaces + this.age;
    }

    public String GetName()
    {
        return this.name;
    }

    public int GetAge()
    {
      return this.age;
    }

    public String GetUsername()
    {
        String nameWithoutSpaces = this.name.replaceAll("\\s+","");
        this.username = nameWithoutSpaces + this.age;

        return this.username;
    }

    public DateTime GetDateOfBirth()
    {
        return dob;
    }
    public long GetId()
    {
        return  this.id;
    }

    public ArrayList<Module> GetModules()
    {
        return this.modules;
    }

    public void SetName(String name)
    {
        this.name = name;
    }

    public void SetAge(int age)
    {
        this.age = age;
    }

    public void SetUsername(String username)
    {
        this.username = username;
    }

    public void SetDateOfBirth(DateTime dob)
    {
        this.dob = dob;
    }

    public void SetId(long id)
    {
        this.id = id;
    }

    public void SetModules(ArrayList<Module> modules)
    {
        this.modules = modules;
    }

    @Override
    public String toString()
    {
        String format = "";

        format += "Lecturer Name: " + GetName() + "\n";
        format += "Lecturer Age" +  GetAge() + "\n";
        format += "Lecturer Id: " + GetId() + "\n";
        format += "Lecturer Date Of Birth: " + GetDateOfBirth() + "\n";
        format += "Lecturer Username: " + GetUsername() + "\n";

        format += "Assigned Modules: \n\n";

        if (GetModules() != null)
        {
            for (Module module : GetModules())
            {
                format += "Name: " + module.GetName() + "\n";
            }
        }


        return format;
    }
}
