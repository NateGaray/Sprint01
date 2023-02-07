package Project01;

import Project01.PeopleType;

public class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;

    /**
     * This constructor is just creating an instance of the class and
     * initializing the data members.
     * @param nation
     * @param tribe
     * @param person
     * @param lifePoints
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * This method is just getting the type of person
     * from the PeopleType class
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * This method is getting the tribe
     * @return myTribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * This method is getting the nation
     * @return myNation
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * This method is seeing if the person is alive by
     * @return myLifePoints. It returns true if myLifePoints is greater than 0,
     * and then it returns false if myLifePoints is 0.
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * This method is getting myLifePoints
     * @return MyLifePoints
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * This method is seeing if myNation is equal to the other
     * @param otherPerson and if it is they will go to war and
     * if they aren't then it moves down to the else statement
     * and this is where nothing will happen. There will be piece.
     */
    public void encounterStrategy(People otherPerson)
    {
        if(myNation == otherPerson.getNation())
        {
            // There will be an ugly confrontation
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }

    /**
     * This method just reduces the amount of
     * @param points that myLifePoints has if a players
     * end up going to war.
     */
    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }


    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

