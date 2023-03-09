// Assignment 2
// Question: Part 2
// Written by: Aryan Saxena 40233170
// -----------------------------------------------------

/**
 * Team Class
 * @author Aryan Saxena 40233170
 *
 */
public class Team implements Groupable{

    /**
     * Attributes of the TeamClass
     */
    String teamID;
    String teamName;
    int gamesPlayed;
    int gamesWon;
    int gamesLost;
    double netRunRate;
    int points;

    //Getters

    /**
     * Getter
     * @return referenced values of TeamID
     */
    public String getTeamID()
    {
        return teamID;
    }

    /**
     * Getter
     * @return referenced values of TeamName
     */
    public String getTeamName()
    {
        return teamName;
    }

    /**
     * Getter
     * @return referenced values of GamesPlayed
     */
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    /**
     * Getter
     * @return referenced values of GamesWon
     */
    public int getGamesWon()
    {
        return gamesWon;
    }

    /**
     * Getter
     * @return referenced values of GamesLost
     */
    public int getGamesLost()
    {
        return gamesLost;
    }

    /**
     * Getter
     * @return referenced values of RunRate
     */
    public double getNetRunRate()
    {
        return netRunRate;
    }

    /**
     * Getter
     * @return referenced values of Points
     */
    public int getPoints()
    {
        return points;
    }


    //Setters

    /**
     * Sets referenced team Id with given
     * @param teamID Takes String TeamID
     */
    public void setTeamID(String teamID)
    {
        this.teamID = teamID;
    }

    /**
     * Sets referenced teamName with given
     * @param teamName Takes String teamName
     */
    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    /**
     * Sets referenced gamesPlayed with given
     * @param gamesPlayed Takes integer gamesPlayed
     */
    public void setGamesPlayed(int gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * Sets referenced gamesWon with given
     * @param gamesWon Takes integer gamesWon
     */
    public void setGamesWon(int gamesWon)
    {
        this.gamesWon = gamesWon;
    }

    /**
     * Sets referenced gamesLost with given
     * @param gamesLost Takes integer gamesLost
     */
    public void setGamesLost(int gamesLost)
    {
        this.gamesLost =  gamesLost;
    }

    /**
     * Sets referenced netRunRate with given
     * @param netRunRate Takes Double netRunRate
     */
    public void setNetRunRate(double netRunRate)
    {
        this.netRunRate =  netRunRate;
    }

    /**
     * Sets referenced points with given
     * @param points Takes Integer points
     */
    public void setPoints(int points)
    {
        this.points = points;
    }
    
    //Parameterised Constructor

    /**
     * Create a team Object with the given Parameters: 
     * @param teamID Team ID (Unique ID Assigned by default)
     * @param teamName Team Name
     * @param gamesPlayed games Played
     * @param gamesWon games Won
     * @param gamesLost games Lost
     * @param netRunRate netRun Rate
     * @param points points
     */
    Team(String teamID, String teamName, int gamesPlayed, int gamesWon, int gamesLost, double netRunRate, int points)
    {
        this.teamID = teamID;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost =  gamesLost;
        this.netRunRate =  netRunRate;
        this.points = points;
    }
    
    //Copy Constructor
    /**
     * Copy Constructor
     * @param t Creates the copy in referenced with the given team t
     * @param v takes String v from user for given index 
     */
    Team(Team t, String v)
    {
        this.teamID = v;
        this.teamName = t.getTeamName();
        this.gamesPlayed = t.getGamesPlayed();;
        this.gamesWon = t.getGamesWon();
        this.gamesLost =  t.getGamesLost();
        this.netRunRate =  t.getNetRunRate();
        this.points = t.getPoints();
    }
    
    //Clone Method, Returns the cloned Team
    /**
     * Clones Method 
     * @param v take String v for TeamID
     * @return Returns Cloned Team
     */
    public Team clone(String v)
    {
        Team newteam = new Team(v, this.teamName, this.gamesPlayed, this.gamesWon, this.gamesLost, this.netRunRate, this.points);
        return newteam;
    }
    
    //Returns true if two teams are equals, else returns false
    /**
     * Equals Method
     * @param t checks if referenced team is equal to the given team t
     * @return if equal then return true, else false
     */
    public boolean equals(Team t)
    {
        if(t.getTeamName().equals(this.getTeamName()) && t.getGamesPlayed() == this.getGamesPlayed() && t.getGamesWon() == this.getGamesWon() && t.getGamesLost()== this.getGamesLost() && t.getNetRunRate() == this.getNetRunRate() && t.getPoints() == this.getPoints())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Returns the String value of all the attributes in a Team
    /**
     * Prints all the attributes of the team
     */
    public String toString(){
        String s_team;
        s_team = "Team ID: " + this.getTeamID() + "\r\n" + "Team Name: " + this.getTeamName() + "\r\n" + "Games Played: " + this.getGamesPlayed() + "\r\n" + "Games Won: " + this.getGamesWon() + "\r\n" + "Games Lost: " + this.getGamesLost() + "\r\n" + "Net Run Rate: " + this.getNetRunRate() + "\r\n" + "Points: " + this.getPoints() + "\r\n";
        return s_team;
    }

    //isInThisGroup Method from Groupable Interface
    /**
     * isInThisGroup Method
     */
    public boolean isInTheGroup(Team t)
    {
        return false;
    }   
}
