package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;

    /**
     * This function sets the game up to include two nations with five tribes and two people per tribe.
     * It also sets up the life points and allocates them to the nations,tribes and people
     * This functions also plays the game until there is a winner
     */
    public class Main
    {
        public static void main(String[] args)
        {
            int gameLifePoints = 2000;
            ArrayList<Nation> nations = new ArrayList<>(); // nations create tribes create people
            PlayGame game = new PlayGame();
            nations.add(new Nation("Idiots", (gameLifePoints / 2)));
            nations.add(new Nation("Minions", (gameLifePoints) / 2));
            // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
            for (int i = 0; i < 40; i++) {
                System.out.println("Round number: " + i);
                if (game.playOneRound(nations))
                {
                    System.out.println("There is a winner!");
                    break; // game over
                }
            }

            System.out.println("The winning nation is " + game.getWinner() + ".");
        }
    }
