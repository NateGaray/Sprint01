package Project01;

public enum PeopleType
{
    warrior ("Soldier"),
    wizard("Tricky");

    private String description;


    PeopleType (String types)
    {
        description = types;
    }


    public String getDescription()
    {
        return description;
    }
}
