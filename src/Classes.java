import java.util.Random;

class VotesHandler
{
    private Coalition[] coalitions_db;
    private Party[] parties_db;
    private int pIndex, cIndex;
    private int cAmount;
    private int pAmount;
    
    public VotesHandler(int cAmount, int pAmount)
    {
        this.cAmount = cAmount;
        this.pAmount = pAmount;
        
        coalitions_db = new Coalition[cAmount];
        parties_db = new Party[pAmount];
        
        pIndex = cIndex = 0; 
    }
    
    public int regCoalition(Coalition c)
    {
        if (cIndex >= coalitions_db.length)
            return -1;
        
        coalitions_db[cIndex] = c;
        cIndex++;
        
        return cIndex;
    }
    
    public int regParty(Party p)
    {
        if (pIndex >= parties_db.length)
            return -1;
        
        parties_db[pIndex] = p;
        pIndex++;
        
        return pIndex;
    }
    
    public float getPercentage(Coalition c)
    {
        float tot = 0;
        float percentage;
        
        for (int i = 0; i < cIndex; i++)
            tot += coalitions_db[i].getVotes();
        
        percentage = c.getVotes() * 100 / tot;
        
        return percentage;
    }
    
    public float getPercentage(Party p)
    {
        float tot = 0;
        float percentage;
        
        for (int i = 0; i < pIndex; i++)
            tot += parties_db[i].getVotes();
        
        percentage = p.getVotes() * 100 / tot;
        
        return percentage;
    }
    
    public void reset()
    {
        coalitions_db = new Coalition[cAmount];
        parties_db = new Party[pAmount];
        pIndex = cIndex = 0;
    }
}

class Party
{
    private int id, coalition, votes;
    private String name;
    private String logo;
    private VotesHandler handler;
    
    public Party(VotesHandler handler, Coalition coalition, String name, String logo, int votes)
    {
        this.handler = handler;
        this.id = handler.regParty(this);
        this.coalition = coalition.getId();
        this.name = name;
        this.logo = logo;
        this.votes = votes;
    }
    
    public int getId()              { return id; }
    public int getCoalition()       { return coalition; }
    public int getVotes()           { return votes; }
    public String getName()         { return name; }
    public String getLogo()         { return logo; }
    public float getPercentage()    { return handler.getPercentage(this); }
}

class Coalition
{
    private int id, votes, partiesAddedCount;
    private Party[] parties;
    private String name;
    private String logo;
    private VotesHandler handler;
    
    public Coalition(VotesHandler handler, String name, String logo, int parties)
    {
        this.handler = handler;
        this.id = handler.regCoalition(this);
        this.name = name; // President's name
        this.logo = logo;
        
        votes = 0;
        
        this.parties = new Party[parties]; // parties number must be <= 4
        partiesAddedCount = 0; // must be <= 4
    }
    
    public int getId()          { return id; }
    public int getVotes()           { return votes; }
    public String getName()         { return name; }
    public String getLogo()         { return logo; }
    public float getPercentage()    { return handler.getPercentage(this); }
    
    public void addParty(Party p)
    {
        if (partiesAddedCount >= 4)
            return;
        
        parties[partiesAddedCount] = p;
        partiesAddedCount++;
        votes += p.getVotes();
    }
    
    // Used for debugging only
    public void updateVotes()
    {
        votes = 0;
        for (int i = 0; i < partiesAddedCount; i++)
        {
            votes += parties[i].getVotes();
        }
    }
    
    // Used for debugging only
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