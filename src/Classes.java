import java.util.Random;

class Party
{
    private int id, coalition, votes, percentage;
    private String name;
    private String logo;
    
    public Party(int id, int coalition, String name, String logo)
    {
        this.id = id; // must be > 0
        this.coalition = coalition;
        this.name = name;
        this.logo = logo;
        
        votes = 0;
        percentage = 0;
    }
    
    public int getId()          { return id; }
    public int getCoalition()   { return coalition; }
    public int getVotes()       { return votes; }
    public int getPercentage()  { return percentage; }
    public String getName()     { return name; }
    public String getLogo()     { return logo; }
    
    public void setId(int i)          { id = i; }
    public void setCoalition(int i)   { coalition = i; }
    public void setVotes(int i)       { votes = i; }
    public void setPercentage(int i)  { percentage = i; }
    public void setName(String i)     { name = i; }
    public void setLogo(String i)     { logo = i; }
}

class Coalition
{
    private int id, votes, percentage, partiesAddedCount;
    private Party[] parties;
    private String name;
    private String logo;
    
    public Coalition(int id, String name, String logo, int parties)
    {
        this.id = id; // must be > 0
        this.name = name; // President's name
        this.logo = logo;
        
        votes = 0;
        percentage = 0;
        
        this.parties = new Party[parties]; // parties number must be <= 4
        partiesAddedCount = 0; // must be <= 4
    }
    
    public int getId()          { return id; }
    public int getVotes()       { return votes; }
    public int getPercentage()  { return percentage; }
    public String getName()     { return name; }
    public String getLogo()     { return logo; }
    
    public void setId(int i)          { id = i; }
    public void setVotes(int i)       { votes = i; }
    public void setPercentage(int i)  { percentage = i; }
    public void setName(String i)     { name = i; }
    public void setLogo(String i)     { logo = i; }
    
    public void addParty(Party p)
    {
        if (partiesAddedCount >= 4)
            return;
        
        parties[partiesAddedCount] = p;
        partiesAddedCount++;
    }
    
    public void resetParties()
    {
        for (int i = 0; i < partiesAddedCount; i++)
            parties[i] = null;
        
        partiesAddedCount = 0;
    }
}


class Sample
{
    int people[];
    
    Sample(int[] population, int size)
    {
        people = new int[size];
        Random rand = new Random();
        
        for (int i = 0; i < size; i ++)
            people[i] = population[rand.nextInt(population.length)];
    }
}