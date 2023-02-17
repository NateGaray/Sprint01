package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

/**
 * This class is the brains of the game
 * This class makes everything work together
 * This is where the game is actually played
 */
public class PlayGame
{

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<People> worldLivingPopulation = new ArrayList<>();
     Random generator;

    /**
     * The PlayGame constructor creates a variable of type date
     * The date then gets a randomly generated time
     */
    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * First this method clears the ArrayList called worldLivingPopulation
     * Then the method uses a for loop to loop through an ArrayList of type Nation
     * each iteration of the loop the population of the nation is added
     * @param nations
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }

    /**
     * This method uses the getWorldLivingPopulation
     * Then it clears the ArrayList called allLivingNations
     * Next the method goes through a for loop, looping through the nations ArrayList
     * If the nation is alive it is added to the allLivingNations ArrayList
     * @param nations
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }

    /**
     * This method checks if the two nations are the same
     * If the two nations are not the same, the players encountered each other
     * When this happens, each player takes a random amount of damage
     * The damage for each player is passes into the reduceLifePoints method ( this is created randomly)
     * Finally there is a print statement that tells the players how much damage they take
     * @param p1
     * @param p2
     */
    public void encounter(People p1, People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }


    /**
     * This method gets all the living nations
     * A while loop is used to determine if the size of the allLivingNations ArrayList
     * is greater than 1 and the index of the worldLivingPopulation ArrayList is less than the size of the ArrayList
     * A do while loop is nested inside the outer while loop. The do gets the living population of player 2.
     * The while checks if the index of player 1 is the same as the index of player 2. If they are the same
     * there is an encounter.
     * The method gets all the living nations
     * If the size of the allLivingNations ArrayList is less than 2 the while loop breaks. Otherwise, the index is
     * increased by 1.
     * Finally, the method returns a boolean if the size of the allLivingNations ArrayList is less than 2
     * @param nations
     * @return
     */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }

    /**
     * If the size of the allLivingNations ArrayList is 0, there is no winner and "No Winner!" is returned as a string
     * Otherwise, the name of the winning nation is returned as a string
     * @return
     */
    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
