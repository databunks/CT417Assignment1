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

    /**
     * Constructor for the Lecturer
     * @param name of the lecturer
     * @param age of the lecturer
     * @param dob (Date of Birth) of the lecturer
     * @param modules assigned to the lecturer
     */
    public Lecturer(String name, int age, DateTime dob, ArrayList<Module> modules)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;

        // static id is iterated each time a lecturer is added / created
        this.id++;
        this.modules = modules;

        // removes any spaces added to the name
        String nameWithoutSpaces = this.name.replaceAll("\\s+","");

        // username is a combination of the name without spaces and the age
        this.username = nameWithoutSpaces + this.age;

        // if the list of modules is null then initialize them
        if (this.modules == null)
        {
            this.modules = new ArrayList<Module>();
        }

    }

    // Getters

    /**
     * @return the name of the lecturer
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * @return the age of the lecturer
     */
    public int GetAge()
    {
      return this.age;
    }

    /**
     * @return the username of the lecturer
     */
    public String GetUsername()
    {
        String nameWithoutSpaces = this.name.replaceAll("\\s+","");
        return nameWithoutSpaces + this.age;
    }

    /**
     * @return the Date of Birth of the lecturer
     */
    public DateTime GetDateOfBirth()
    {
        return dob;
    }

    /**
     * @return the id of the lecturer
     */
    public long GetId()
    {
        return  this.id;
    }

    /**
     * @return the modules assigned to the modules
     */
    public ArrayList<Module> GetModules()
    {
        return this.modules;
    }

    /**
     * Set the name of the lecturer
     * @param name of the lecturer
     */
    public void SetName(String name)
    {
        this.name = name;
    }

    /**
     * Set the age of the Lecturer
     * @param age of the lecturer
     */
    public void SetAge(int age)
    {
        this.age = age;
    }

    /**
     * Set the username of the lecturer
     * @param username of the lecturer
     */
    public void SetUsername(String username)
    {
        this.username = username;
    }

    /**
     * Set the date of birth of the lecturer
     * @param dob of the lecturer
     */
    public void SetDateOfBirth(DateTime dob)
    {
        this.dob = dob;
    }

    /**
     * Set the id of the lecturer
     * @param id of the lecturer
     */
    public void SetId(long id)
    {
        this.id = id;
    }

    /**
     * Set the modules assigned of the lecturer
     * @param modules of the lecturer
     */
    public void SetModules(ArrayList<Module> modules)
    {
        this.modules = modules;
    }

    /**
     * Assign a module to the lecturer
     * @param module to assign to the lecturer
     */
    public void AddModule(Module module)
    {
        this.modules.add(module);
    }

    /**
     * Custom toString override of the lecturer
     * @return the formatted string
     */
    @Override
    public String toString()
    {
        String format = "";

        format += "Lecturer Name: " + GetName() + "\n";
        format += "Lecturer Age: " +  GetAge() + "\n";
        format += "Lecturer Id: " + GetId() + "\n";
        format += "Lecturer Date Of Birth: " + GetDateOfBirth() + "\n";
        format += "Lecturer Username: " + GetUsername() + "\n";

        format += "Assigned Modules: \n\n";

        // check if the number of modules are not null
        if (GetModules() != null)
        {
            // iterate through the modules and add the name of the lecturer to the string
            for (Module module : GetModules())
            {
                format += "Name: " + module.GetName() + "\n";
            }
        }


        return format;
    }
}
