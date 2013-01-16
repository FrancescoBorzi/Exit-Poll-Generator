import java.util.Random;

class DataBase
{
    private Coalition[] coalitions_db;
    private Party[] parties_db;
    private int pIndex, cIndex;
    private int cAmount;
    private int pAmount;
    
    public DataBase(int cAmount, int pAmount)
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
        // TODO
        return 0;
    }
    
    public float getPercentage(Party p)
    {
        // TODO
        return 0;
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
    private DataBase db;
    
    public Party(DataBase db, Coalition coalition, String name, String logo, int votes)
    {
        this.db = db;
        this.id = db.regParty(this);
        this.coalition = coalition.getId();
        this.name = name;
        this.logo = logo;
        this.votes = votes;
    }
    
    public int getId()          { return id; }
    public int getCoalition()   { return coalition; }
    public int getVotes()       { return votes; }
    public String getName()     { return name; }
    public String getLogo()     { return logo; }
    
    public float getPercentage()  { return db.getPercentage(this); }
}

class Coalition
{
    private int id, votes, partiesAddedCount;
    private Party[] parties;
    private String name;
    private String logo;
    private DataBase db;
    
    public Coalition(DataBase db, String name, String logo, int parties)
    {
        this.db = db;
        this.id = db.regCoalition(this);
        this.name = name; // President's name
        this.logo = logo;
        
        votes = 0;
        
        this.parties = new Party[parties]; // parties number must be <= 4
        partiesAddedCount = 0; // must be <= 4
    }
    
    public int getId()          { return id; }
    public int getVotes()       { return votes; }
    public String getName()     { return name; }
    public String getLogo()     { return logo; }
    
    public float getPercentage()  { return db.getPercentage(this); }
    
    public void addParty(Party p)
    {
        if (partiesAddedCount >= 4)
            return;
        
        parties[partiesAddedCount] = p;
        partiesAddedCount++;
        votes += p.getVotes();
    }
    
    public void updateVotes()
    {
        votes = 0;
        for (int i = 0; i < partiesAddedCount; i++)
        {
            votes += parties[i].getVotes();
        }
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