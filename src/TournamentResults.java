// Assignment 2
// Question: Part 2
// Written by: Aryan Saxena 40233170
// -----------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

/**
* Tournaments Results Class
* @author Aryan Saxena 40233170
*
*/
public class TournamentResults
{
    static int teamID1 = 0;
    
    /**
    * Greeting Message
    */
    public static void greeting(){
        System.out.println("**********************************************");
        System.out.println("********** WELCOME TO TWENTY-TWENTY **********");
        System.out.println("**********************************************");
    }
    
    /**
    * Main Menu
    */
    public static void menu(){
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at Index");
        System.out.println("3. Delete from Start");
        System.out.println("4. Delete from Index");
        System.out.println("5. Replace at Index");
        System.out.println("6. Find Team Using TeamID");
        System.out.println("7. Find whether team exists in Group");
        System.out.println("8. Print All Teams in a Group");
        System.out.println("9. Find Tournament Result");
        System.out.println("10. Make Clone of a team with different TeamID (Displaying Team Clone Functionality)");
        System.out.println("11. Check if a Team is in Group (isInTheGroup)");
        System.out.println("12. Creating copy of teamlist, and checking if teamlists are equal");
        System.out.println("13. Exit");
    }
    
    
    /**
    * Ending Regards
    */
    public static void regard(){
        System.out.println("**********************************************");
        System.out.println("********* THANK YOU FOR USING 20-20 **********");
        System.out.println("**********************************************");
    }
    
    
    /**
    * CreateTeam Method
    * @param line Takes a String with Team Attributes, and creates a Team using it
    * @return Team Object
    */
    public static Team createteam (String line){
        String t[] = line.split(" ");
        teamID1++;
        String teamName1 = t[0];
        int gamesPlayed1 = Integer.parseInt(t[1]);
        int gamesWon1 = Integer.parseInt(t[2]);
        int gamesLost1 = Integer.parseInt(t[3]);
        double netRunRate1 = Double.parseDouble(t[4]);
        int points1 = Integer.parseInt(t[5]);
        
        Team createteam = new Team(Integer.toString(teamID1), teamName1, gamesPlayed1, gamesWon1, gamesLost1, netRunRate1, points1);
        return createteam;
    }
    
    
    /**
    * Main Method
    * @param args
    */
    public static void main(String[] args) {
        
        //GroupA
        TeamList group1 = new TeamList();
        
        //GroupB
        TeamList group2 = new TeamList();
        
        
        Scanner sc = new Scanner(System.in);
        
        //Flag to be used for the Main Menu
        int exitflag = 0;
        
        greeting();
        
        for(int j = 0; j < 2; j++)
        {
            if(j == 0){
                //Entering 6 Values in Group A
                System.out.println("Group A");
            }
            else if(j == 1){
                //Entering 6 Values in Group B
                System.out.println("Group B");
            }
            System.out.println("Please Enter the teams: ");
            
            for(int i = 0; i < 6; i++)
            {
                
                String line = sc.nextLine();
                Team newteam = createteam(line);
                
                //Checking if the Team already Exists, if true then Re-Enter
                if(group1.isInTheGroup(newteam) == true || group2.isInTheGroup(newteam)==true) 
                { 
                    System.out.println("Team Already Exists, Please Re-Enter");
                    i--;
                    teamID1--;
                }
                //Else Append in the respective Groups
                else
                {
                    if(j == 0){
                        //First Group A
                        group1.insertAtEnd(newteam);
                    }
                    else if(j==1){
                        //Second Group B
                        group2.insertAtEnd(newteam);
                    }
                }
                
            }
        }
        
        while(exitflag == 0){
            
            //Displaying Main Menu
            menu();
            
            //Getting Menu Selection from User
            int cases = Integer.parseInt(sc.nextLine());
            
            switch(cases)
            {
                case 1:
                {
                    //Inserting Team at the Beginning
                    System.out.println("Enter team to enter at the beginning: ");
                    int exitflag1 = 0;
                    
                    while(exitflag1==0)
                    {
                        String line = sc.nextLine();
                        Team newteam = createteam(line);
                        
                        //If Team Exists then Don't Enter
                        if(group1.isInTheGroup(newteam) == true || group2.isInTheGroup(newteam)==true) 
                        { 
                            System.out.println("Team Already Exists, Please Re-Enter");
                            teamID1--;
                        }
                        else
                        //Append Values, in Groups entered
                        {
                            exitflag1=1;
                            System.out.println("Enter the Group you wish to Enter it in: (A or B)");
                            char groupin = sc.nextLine().charAt(0);
                            if(groupin == 'A' || groupin == 'a')
                            {
                                group1.addtoStart(newteam);
                                break;
                            }
                            else if(groupin == 'B' || groupin == 'b')
                            {
                                group2.addtoStart(newteam);
                                break;
                            }
                            System.out.println("Incorrect Group (Please only enter A or B)");
                        }
                    }
                    
                    break;
                }
                
                case 2:
                {
                    //Inserting at Index
                    System.out.println("Enter the team you wish to Enter at index: ");
                    int exitflag2 = 0;
                    
                    while(exitflag2==0)
                    {
                        String line = sc.nextLine();
                        Team newteam = createteam(line);
                        
                        if(group1.isInTheGroup(newteam) == true || group2.isInTheGroup(newteam)==true) 
                        { 
                            System.out.println("Team Already Exists, Please Re-Enter");
                            teamID1--;
                        }
                        else
                        {
                            exitflag2=1;
                            System.out.println("Enter the Group you wish to Enter it in: (A or B)");
                            char groupin = sc.nextLine().charAt(0);
                            System.out.println("Enter the index you wish to update it in: ");
                            int index = Integer.parseInt(sc.nextLine());
                            if((groupin == 'A' || groupin == 'a') && index < group1.getSize())
                            {
                                group1.insertAtIndex(newteam, index);
                                break;
                            }
                            else if((groupin == 'B' || groupin == 'b') && index < group2.getSize())
                            {
                                group2.insertAtIndex(newteam, index);
                                break;
                            }
                            System.out.println("Incorrect Group (Please only enter A or B), and index < (group1 "+group1.getSize()+") (group2 "+group2.getSize()+")");
                        }
                    }
                    
                    break;
                }
                
                case 3:
                {
                    while(true){
                        System.out.println("Enter the Group you wish to delete from Start: (A or B)");
                        char groupin = sc.nextLine().charAt(0);
                        
                        if(groupin == 'A' || groupin == 'a')
                        {
                            group1.deleteFromStart();
                            break;
                        }
                        else if(groupin == 'B' || groupin == 'b')
                        {
                            group2.deleteFromStart();
                            break;
                        }
                        System.out.println("Incorrect Group");
                    }
                    
                    break;
                }
                
                case 4: 
                {
                    while(true){
                        System.out.println("Enter the Group you wish to delete from Index: (A or B)");
                        char groupin = sc.nextLine().charAt(0);
                        
                        System.out.println("Enter the Index where you wish to delete: ");
                        int index = Integer.parseInt(sc.nextLine());
                        
                        if((groupin == 'A' || groupin == 'a') && index < group1.getSize())
                        {
                            group1.deleteFromIndex(index);
                            break;
                        }
                        else if((groupin == 'B' || groupin == 'b') && index < group2.getSize())
                        {
                            group2.deleteFromIndex(index);
                            break;
                        }
                        
                        System.out.println("Incorrect Group (Please only enter A or B), and index < (group1 "+group1.getSize()+") (group2 "+group2.getSize()+")");
                        
                    }
                    break;
                }
                
                
                case 5:
                {
                    System.out.println("Enter the team you wish to Enter at Index: ");
                    String line = sc.nextLine();
                    Team newteam = createteam(line);
                    
                    while(true)
                    {
                        System.out.println("Enter the Group you wish to REPLACE it in: (A or B)");
                        char groupin = sc.nextLine().charAt(0);
                        System.out.println("Enter the index you wish to REPLACE it in: ");
                        int index = Integer.parseInt(sc.nextLine());
                        if((groupin == 'A' || groupin == 'a') && index < group1.getSize())
                        {
                            group1.replaceAtIndex(newteam, index);
                            break;
                        }
                        else if((groupin == 'B' || groupin == 'b') && index < group2.getSize())
                        {
                            group2.replaceAtIndex(newteam, index);
                            break;
                        }
                        System.out.println("Incorrect Group (Please only enter A or B), and index < (group1 "+group1.getSize()+") (group2 "+group2.getSize()+")");
                    }
                    break;
                }
                
                case 6:
                {
                    System.out.println("Enter the TeamID of the team you wish to find");
                    String teamID = sc.nextLine();
                    TeamList.TeamNode tn= group1.find(teamID);
                    if(tn == null)
                    {
                        tn = group2.find(teamID);
                    }
                    if(tn == null){
                        System.out.println("Team with T_ID Not Present");
                    }
                    else {
                        System.out.println(tn.team.toString());
                    }
                    break;
                }
                
                case 7:
                {
                    System.out.println("Enter the teamID you wish to find: ");
                    String line = sc.nextLine();
                    System.out.println("Team exists in Group A: " + group1.contains(line));
                    System.out.println("Team exists in Group B: " + group2.contains(line));
                    break;
                }
                
                case 8:
                {
                    while(true){
                        System.out.println("Enter the Group you wish to print from Start: (A or B)");
                        char groupin = sc.nextLine().charAt(0);
                        if(groupin == 'A' || groupin == 'a')
                        {
                            group1.printTeamList();
                            break;
                        }
                        else if(groupin == 'B' || groupin == 'b')
                        {
                            group2.printTeamList();
                            break;
                        }
                    }
                    break;
                }
                
                case 9:
                {
                    System.out.println("Enter the Number of Teams you wish to find the result for: ");
                    int n = Integer.parseInt(sc.nextLine());
                    
                    ArrayList<String> tournamentteams = new ArrayList<String>();
                    System.out.println("Enter Team Name(s): ");
                    for(int i = 0; i < n; i++){
                        String line = sc.nextLine();
                        tournamentteams.add(line);
                    }
                    
                    for(int i = 0; i < tournamentteams.size(); i++)
                    {
                        if(group1.hasTeam(tournamentteams.get(i).trim()))
                        {
                            group1.top2(tournamentteams.get(i));
                        }
                        else if(group2.hasTeam(tournamentteams.get(i).trim()))
                        {
                            group2.top2(tournamentteams.get(i));
                        }
                        else
                        {
                            System.out.println("Teams Not Present");
                        }
                    }
                    break;
                }
                case 10:
                {
                    System.out.println("Enter the Team ID with which you wish to create a clone: ");
                    String v = sc.nextLine();
                    System.out.println("Enter the Team you wish to create: ");
                    String line = sc.nextLine();
                    System.out.println("Current Team: ");
                    Team newteam = createteam(line);
                    System.out.println(newteam.toString());
                    System.out.println("Creating Clone: ");
                    newteam = newteam.clone(v);
                    System.out.println(newteam.toString());
                    teamID1--;
                    break;
                }
                
                case 11:
                {
                    System.out.println("Enter Team: ");
                    String line = sc.nextLine();
                    Team t = createteam(line);
                    if(group1.isInTheGroup(t) == true){
                        System.out.println("Team is in Group A");
                    }
                    else if(group2.isInTheGroup(t) == true){
                        System.out.println("Team is in Group B");
                    }
                    else{
                        System.out.println("Team is in Neither Groups");
                    }
                    break;
                }
                
                case 12:
                {
                    //Empty Lists for Copy Constructor
                    //GroupC
                    TeamList group3 = new TeamList(group1);
                    
                    //GroupD
                    TeamList group4 = new TeamList(group2);
                    
                    System.out.println("Groups 3 is deep copy of Group 1, Group 4 is deep copy of Group 2");
                    
                    boolean grpeql1 = group1.equals(group3);
                    System.out.println("Group 1 is Equal to Group 3: " + grpeql1);
                    
                    grpeql1 = group1.equals(group4);
                    System.out.println("Group 1 is Equal to Group 4: "+ grpeql1);
                    
                    grpeql1 = group2.equals(group3);
                    System.out.println("Group 2 is Equal to Group 3: "+ grpeql1);
                    
                    grpeql1 = group2.equals(group4);
                    System.out.println("Group 2 is Equal to Group 4: "+ grpeql1);
                    
                    break;
                }
                
                case 13:
                {
                    exitflag=1;
                    break;
                }
            }
        }
        regard();
        sc.close();
    }
}