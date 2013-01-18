public class Coalition
{
    private int id, votes, partiesAddedCount;
    private Party[] parties;
    private String name;
    private String logo;
    private VotingScheme handler;
    
    public Coalition(VotingScheme handler, String name, String logo, int parties)
    {
        this.handler = handler;
        this.id = handler.regCoalition(this);
        this.name = name; // President's name
        this.logo = logo;
        
        votes = 0;
        
        this.parties = new Party[parties]; // parties number must be <= 4
        partiesAddedCount = 0; // must be <= 4
    }
    
    public int getId()              { return id; }
    public int getVotes()           { return votes; }
    public String getName()         { return name; }
    public String getLogo()         { return logo; }
    public float getPercentage()    { return handler.getPercentage(this); }
    public Party[] getParties()     { return parties; }
    
    public void setVotes(int votes)  { this.votes = votes; }
    
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
    
    public Coalition makeClone() throws CloneNotSupportedException
    {
        return (Coalition)(this.clone());
    }
}