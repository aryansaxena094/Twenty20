// Assignment 2
// Question: Part 2
// Written by: Aryan Saxena 40233170
// -----------------------------------------------------

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * TeamList Class
 * @author Aryan Saxena 40233170
 *
 */
public class TeamList {
    //Head of the Node
    /**
     * Head of the TeamNode
     */
    private TeamNode head;

    //Size of the Node
    /**
     * Size of the TeamNode
     */
    private int size;
    
    //Get Size
    /**
     * Getter
     * @return returns the size
     */
    public int getSize(){
        return this.size;
    }
    
    //Default Constructor, creates an empty list
    /**
     * Default Constructor; Initialises the values, creates an Empty list
     */
    TeamList() {
        this.head = null;
        this.size = 0;
    }
    
    //Copy Constructor, takes a TeamList and creates a Deep copy of it
    /**
     * Copy Constructor
     * @param temp Creates a deep copy of the temp TeamList
     */
    TeamList(TeamList temp)
    {
        this.head = new TeamNode(temp.head);

        TeamNode pointer = this.head;

        TeamNode pointer2 = temp.head;

        this.size = 1;
        for(int i=0; i<temp.size-1; i++){
            pointer.next = new TeamNode(pointer2.next);

            pointer = pointer.next;
            pointer2 = pointer2.next;
            this.size++;
        }
    }

    //Inserts the Node at the Start of the TeamList
    /**
     * Inserts Node at the Start
     * @param t Inserts the Team t at the beginning of the TeamList
     */
    public void addtoStart(Team t){
        TeamNode tn = new TeamNode(t, null);
        tn.next = this.head;
        this.head = tn;
        this.size++;
    }
    
    //Inserts the Node at the End of the TeamList
    /**
     * Insert Node at the end
     * @param t Inserts Team t at the end of the TeamList
     */
    public void insertAtEnd(Team t){
        TeamNode tn = new TeamNode(t, null);
        if(this.head == null){
            this.head = tn;
            this.size++;
        }
        else
        {
            TeamNode pointer = this.head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = tn;
            this.size++;
        }
    }
    
    //Inserts the Node at the index given
    /**
     * Insert Node at given index
     * @param t Inserts Team T into a given index
     * @param index Where team is to be inserted
     */
    public void insertAtIndex(Team t, int index){
        TeamNode pointer = new TeamNode(this.head);
        if(index >= this.size){
            throw new NoSuchElementException("Index Out Of Bounds");
        } else {
            for(int i = 0; i < (index-1); i++){
                pointer = pointer.next;
            }
            TeamNode newteam = new TeamNode(t, pointer.next);
            newteam.next = pointer.next;
            pointer.next = newteam;
            this.size++;
        }
        
    }
    
    //Deletes the Node from an Index
    /**
     * Deletes Node with index
     * @param index Index at which Node is to be deleted
     */
    public void deleteFromIndex(int index){
        TeamNode pointer = new TeamNode(this.head);
        
        if(index >= this.size){
            throw new NoSuchElementException("Index Out Of Bounds");
        } else {
            for(int i = 0; i < (index-1); i++){
                pointer = pointer.next;
            }
            TeamNode temp = new TeamNode(pointer.next.next);
            pointer.next = temp;
            this.size--;
        }
    }
    
    //Delete from the beginning of the TeamList
    /**
     * Deletes Node from the beginning of the TeamList
     */
    public void deleteFromStart(){
        this.head = this.head.next;
        this.size--;
    }
    
    //Replaces the Node at the given Index
    /**
     * ReplaceatIndexMethod
     * @param t Replace node with node of Team T at given Index
     * @param index Index where to Replace
     */
    public void replaceAtIndex(Team t, int index){
        TeamNode pointer = new TeamNode(head);
        if(index >= this.size){
            throw new NoSuchElementException("Index Out Of Bounds");
        } else {
            for(int i = 0; i < (index-1); i++){
                pointer = pointer.next;
            }
            TeamNode newteam = new TeamNode(t, pointer.next);
            newteam.next = pointer.next.next;
            pointer.next = newteam;
        }
    }
    
    //Finds the Node using Team ID
    /**
     * Find TeamNode
     * @param t_id Takes String TeamID to find
     * @return Returns the team Node
     */
    public TeamNode find(String t_id){
        TeamNode pointer = this.head;
        
        for(int i = 0; i < this.size; i++)
        {
            if(pointer.team.getTeamID().equals(t_id)){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
    
    //Takes Parameter of TeamID, Returns true if Team exists in Group
    /**
     * Contains Method
     * @param t_id Takes in TeamID
     * @return returns true if team exists in group, otherwise false
     */
    public boolean contains(String t_id){
        TeamNode pointer = this.head;
        for(int i = 0; i < this.size; i++){
            if(pointer.team.getTeamID().equals(t_id)){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
    
    //Takes Parameter of TeamName, Returns true if Team exists in Group
    /**
     * HasTeam Method
     * @param teamName Takes TeamName and finds if the Team is in the group
     * @return true if team is in the group, else false
     */
    public boolean hasTeam(String teamName){
        TeamNode pointer = this.head;
        for(int i = 0; i < this.size; i++){
            if(pointer.team.getTeamName().equals(teamName)){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    //Returns true if two TeamLists are equal
    /**
     * Equals Method for teamList
     * @param tl checks whether teamlist tl is equal to the teamlist referenced
     * @return true if equal, else false
     */
    public boolean equals(TeamList tl)
    {
        TeamNode pointer1 = head.next;
        TeamNode pointer2 = tl.head.next;
        for(int i = 0; i < size; i++){
            if(pointer1.team.equals(pointer2.team)!=true){
                return false;
            }
        }
        return true;
    }
    
    //Prints all the Teams in Nodes of the TeamList
    /**
     * Prints the entire teamList
     */
    public void printTeamList(){
        TeamNode pointer = this.head;
        for(int i = 0; i < this.size; i++){
            System.out.println(pointer.team.toString());
            pointer = pointer.next;
        }
    }
    
    //Returns true if the given team is in the Group, else False
    /**
     * isInThisGroup Method
     * @param t Takes Team t and checks whether it is in the group
     * @return returns true if equal else false
     */
    public boolean isInTheGroup(Team t)
    {
        TeamNode pointer = this.head;
        for(int i = 0; i < this.size; i++){
            
            if(pointer.team.equals(t)){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }
    
    //Takes a TeamName, and Prints whether the given Team will Qualify or not, AND WHY NOT

    /**
     * Prints whether the given team will qualify or not
     * @param a name of the team
     */
    public void top2(String a)
    {
        ArrayList<String[]> allteams = new ArrayList<String[]>();
        TeamNode pointer = this.head;
        
        for(int i = 0; i < this.size; i++){
            String s[] = new String[4];
            s[0] = pointer.team.getTeamName();
            s[1] = Integer.toString(pointer.team.getPoints());
            s[2] = Double.toString(pointer.team.getNetRunRate());
            s[3] = Integer.toString(0);
            allteams.add(s);
            pointer = pointer.next;
        }
        
        int swapflag = 0;
        while(swapflag == 0)
        {
            swapflag = 1;
            for(int i = 0; i < allteams.size()-1; i++)
            {
                if(Integer.parseInt(allteams.get(i)[1]) < Integer.parseInt(allteams.get(i+1)[1]))
                {
                    String temp[] = allteams.get(i);
                    allteams.set(i, allteams.get(i+1));
                    allteams.set(i+1, temp);
                    swapflag = 0;
                }
                else if(Integer.parseInt(allteams.get(i)[1]) == Integer.parseInt(allteams.get(i+1)[1]))
                {
                    if(Double.parseDouble(allteams.get(i)[2]) < Double.parseDouble(allteams.get(i+1)[2]))
                    {
                        String temp[] = allteams.get(i);
                        allteams.set(i, allteams.get(i+1));
                        allteams.set(i+1, temp);
                        swapflag = 0;
                    }
                }
            }
        }
        
        int maxpoints = 0;

        for(int i = 0; i < allteams.size()-1; i++)
        { 
            maxpoints = Math.max(maxpoints, Integer.parseInt(allteams.get(i)[1]));

            if(Integer.parseInt(allteams.get(i)[1]) == Integer.parseInt(allteams.get(i+1)[1]))
            {
                allteams.get(i)[3] = "1";
                allteams.get(i+1)[3] = "2";
            }
        }
        
        for(int i = 0; i < allteams.size(); i++){
            if(allteams.get(i)[0].equals(a)){
                if(i < 2){
                    if(allteams.get(i)[3].equals("0")){
                        System.out.println(a + " qualifies for the second round as it has more points than " + (allteams.size() - (i + 1)) + " other teams");
                    }
                    else if(allteams.get(i)[3].equals("1")){
                        System.out.println(a + " qualifies for the second round as it has higher runrate");
                    }
                }
                else
                {
                    if(allteams.get(i)[3].equals("0")){
                        System.out.println(a + " can't qualify for the second round as it doesn't have enough points");
                    }
                    else if(allteams.get(i)[3].equals("2")){
                        if(Integer.parseInt(allteams.get(i)[1]) == maxpoints)
                        {
                            System.out.println(a + " can't qualify for the second round as it doesn't have high enough run rate");
                        }
                        else
                        {
                            System.out.println(a + " can't qualify for the second round as it doesn't have enough points");
                        }
                    }
                }
            }
        }
    }
    
    //NODE Class of TeamList
    /**
     * Node Class of TeamList
     */
    public class TeamNode extends TeamList
    {
        //Team Object
        /**
         * TeamObject
         */
        Team team;

        //Pointer to the TeamNode
        
        /**
         * Pointer to next TeamNode
         */
        private TeamNode next;
        
        //Default Constructor, Assigns Null
        /**
         * Default Constructor
         */
        TeamNode()
        {
            team = null;
            next = null;
        }
        
        //Parameterised Constructor
        
        /**
         * 
         * @param team takes the teamObject and initialises it
         * @param teamNode takes teamNode and initialises it
         */
        TeamNode(Team team, TeamNode teamNode)
        {   
            this.team = team;
            this.next = teamNode;
        }
        
        //Copy Constructor
        
        /**
         * Copy Constructor
         * @param tn Takes a teamNode tn and copies it
         */
        TeamNode(TeamNode tn){
            this.team = tn.team;
            this.next = tn.next;
        }
        
        //Accessors
        
        /**
         * Getter
         * @return Team
         */
        public Team getTeam() {
            return team;
        }
        
        //Mutators
        
        /**
         * Mutators
         * @param team returns team of referenced
         */
        public void setTeam(Team team) {
            this.team = team;
        }
        
        //Accessors
        
        /**
         * Getter
         * @return teamNode
         */
        public TeamNode getTeamNode() {
            return next;
        }
        
        //Mutators
        
        /**
         * Mutators
         * @param teamNode returns teamNode of referenced
         */
        public void setTeamNode(TeamNode teamNode) {
            this.next = teamNode;
        }
        
        //Clone Method
        
        /**
         * Clones the teamNode
         */
        public TeamNode clone(){
            TeamNode tn = new TeamNode(this);
            return tn;
        }
        
    }
    
}