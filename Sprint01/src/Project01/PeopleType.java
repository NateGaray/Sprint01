package Project01;

/**
 * This enum determines what type of play a person is
 * There are two types of people a warrior and wizard
 */

public enum PeopleType
{
    warrior ("Soldier"),
    wizard ("Tricky");

    private String description;


    PeopleType(String types)
    {
        description = types;
    }

    /**
     * @return description of the people type
     */
    public String getDescription()
    {
        return description;
    }
}
