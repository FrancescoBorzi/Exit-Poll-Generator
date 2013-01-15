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
    private int id, votes, percentage;
    private int[] parties;
    private String name;
    private String logo;
    
    public Coalition(int id, String name, String logo)
    {
        this.id = id; // must be > 0
        this.name = name; // President's name
        this.logo = logo;
        
        votes = 0;
        percentage = 0;
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
}