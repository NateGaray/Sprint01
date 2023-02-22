package Project01;
import java.util.ArrayList;

/**
 * This class creates a tribe that includes the tribe name,
 * nation name, its members(living or not) and the tribe lifePoints
 * dedicated to each tribe
 */
public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * This method will add a person to a specific tribe
     * using for loops ;it will then assign that person with a
     * personType and lifePoints.
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 2; i++)
            if(i % 2 == 0)
                members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / 2));
            else
                members.add(new People(nationName, tribeName, PeopleType.wizard, tribeLifePoints / 2));
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * This method return the living members of a tribe by using a for loop
     * to check to see if that person isAlive
     * First the livingMembers ArrayList is cleared
     * The tribeLifePints is set to 0
     * Alive people are added to the livingMembers ArrayList
     * Finally the tribeLifePoints is increased
     * @return livingMembers
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }

    /**
     * This method will print the individual members of the tribe to the console
     * /

    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/

    /**
     * returns number of living members in a tribe
     * @return livingMembers.size()
     */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * returns true is tribeLifePoints is greater than 0 and false otherwise
     * @return (tribeLifePoints > 0)
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    /**
     * @return tribeLifePoints
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * @return tribeName
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * @return toString name of the tribe.
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
