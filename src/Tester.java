// just a test

public class Tester
{
    public static void main(String args[])
    {
        DataBase popolazione = new DataBase(10, 21);
        
        /* Crocetta */
        Coalition Crocetta = new Coalition(popolazione, "Crocetta", "img", 4);
        Party CrocettaPresidente = new Party(popolazione, Crocetta, "Crocetta Presidente", "img", 257274);
        Party PD = new Party(popolazione, Crocetta, "Partito Democratico", "img", 207827);
        Party UDC = new Party(popolazione, Crocetta, "Unione Di Centro", "img", 118346);
        Party UnioneConsumatori = new Party(popolazione, Crocetta, "Unione Consumatori", "img", 100);
        Crocetta.addParty(CrocettaPresidente);
        Crocetta.addParty(PD);
        Crocetta.addParty(UDC);
        Crocetta.addParty(UnioneConsumatori);
        
        /* Musumeci */
        Coalition Musumeci = new Coalition(popolazione, "Musumeci", "img", 4);
        Party PDL = new Party(popolazione, Musumeci, "Popolo Della Liberta'", "img", 247351);
        Party CantierePopolare = new Party(popolazione, Musumeci, "Cantiere Popolare", "img", 112169);
        Party MusumeciPresidente = new Party(popolazione, Musumeci, "Musumeci Presidente", "img", 107379);
        Party AlleanzaDiCentro = new Party(popolazione, Musumeci, "Alleanza Di Centro", "img", 5017);
        Musumeci.addParty(PDL);
        Musumeci.addParty(CantierePopolare);
        Musumeci.addParty(MusumeciPresidente);
        Musumeci.addParty(AlleanzaDiCentro);
        
        /* M5S */
        Coalition MovimentoCinqueStelle = new Coalition(popolazione, "Movimento 5 Stelle", "img", 1);
        Party M5S = new Party(popolazione, MovimentoCinqueStelle, "Movimento 5 Stelle", "img", 285202);
        MovimentoCinqueStelle.addParty(M5S);
        
        /* Micciche' */
        Coalition Micciche = new Coalition(popolazione, "Micciche", "img", 4);
        Party MPA = new Party(popolazione, Micciche, "Movimento Per le Autonomie", "img", 182737);
        Party GrandeSud = new Party(popolazione, Micciche, "Grande Sud", "img", 115444);
        Party FLI = new Party(popolazione, Micciche, "Futuro e Libertà", "img", 83891);
        Party PPA = new Party(popolazione, Micciche, "Piazza Pulita", "img", 959);
        Micciche.addParty(MPA);
        Micciche.addParty(GrandeSud);
        Micciche.addParty(FLI);
        Micciche.addParty(PPA);
        
        /* Libera Sicilia */
        Coalition Marano = new Coalition(popolazione, "Marano", "img", 2);
        Party SinistraUnita = new Party(popolazione, Marano, "FdS-SEL-Verdi", "img", 67738);
        Party IdV = new Party(popolazione, Marano, "Italia Dei Valori", "img", 58753);
        Marano.addParty(SinistraUnita);
        Marano.addParty(IdV);
        
        /* Forconi */
        Coalition MarianoFerro = new Coalition(popolazione, "Popolo dei Forconi", "img", 1);
        Party Forconi = new Party(popolazione, MarianoFerro, "Popolo dei Forconi", "img", 23965);
        MarianoFerro.addParty(Forconi);
        
        /* Cateno De Luca */
        Coalition CatenoDeLuca = new Coalition(popolazione, "Cateno De Luca", "img", 1);
        Party RivoluzioneSiciliana = new Party(popolazione, CatenoDeLuca, "RivoluzioneSiciliana", "img", 22422);
        CatenoDeLuca.addParty(RivoluzioneSiciliana);
        
        /* Sturzo */
        Coalition Sturzo = new Coalition(popolazione, "Sturzo", "img", 1);
        Party SturzoPresidente = new Party(popolazione, Sturzo, "Sturzo Presidente", "img", 14929);
        Sturzo.addParty(SturzoPresidente);
        
        /* PCL */
        Coalition PartitoComunistaDeiLavoratori = new Coalition(popolazione, "Partito Comunista Dei Lavoratori", "img", 1);
        Party PCL = new Party(popolazione, PartitoComunistaDeiLavoratori, "PartitoComunistaDeiLavoratori", "img", 2031);
        PartitoComunistaDeiLavoratori.addParty(PCL);
        
        /* Pinsone */
        Coalition Pinsone = new Coalition(popolazione, "Pinsone", "img", 1);
        Party Voi = new Party(popolazione, Pinsone, "Voi", "img", 2278);
        Pinsone.addParty(Voi);
        
        System.out.println("Coalizione: "+Crocetta.getName()+" Voti: "+Crocetta.getVotes()+" -> "+Crocetta.getPercentage()+"%");
        System.out.println("Partito: "+CrocettaPresidente.getName()+" Voti: "+CrocettaPresidente.getVotes()+" -> "+CrocettaPresidente.getPercentage()+"%");
        System.out.println("Partito: "+PD.getName()+" Voti: "+PD.getVotes()+" -> "+PD.getPercentage()+"%");
        System.out.println("Partito: "+UDC.getName()+" Voti: "+UDC.getVotes()+" -> "+UDC.getPercentage()+"%");
        System.out.println("Partito: "+UnioneConsumatori.getName()+" Voti: "+UnioneConsumatori.getVotes()+" -> "+UnioneConsumatori.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+Musumeci.getName()+" Voti: "+Musumeci.getVotes()+" -> "+Musumeci.getPercentage()+"%");
        System.out.println("Partito: "+PDL.getName()+" Voti: "+PDL.getVotes()+" -> "+PDL.getPercentage()+"%");
        System.out.println("Partito: "+CantierePopolare.getName()+" Voti: "+CantierePopolare.getVotes()+" -> "+CantierePopolare.getPercentage()+"%");
        System.out.println("Partito: "+MusumeciPresidente.getName()+" Voti: "+MusumeciPresidente.getVotes()+" -> "+MusumeciPresidente.getPercentage()+"%");
        System.out.println("Partito: "+AlleanzaDiCentro.getName()+" Voti: "+AlleanzaDiCentro.getVotes()+" -> "+AlleanzaDiCentro.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+MovimentoCinqueStelle.getName()+" Voti: "+MovimentoCinqueStelle.getVotes()+" -> "+MovimentoCinqueStelle.getPercentage()+"%");
        System.out.println("Partito: "+M5S.getName()+" Voti: "+M5S.getVotes()+" -> "+M5S.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+Micciche.getName()+" Voti: "+Micciche.getVotes()+" -> "+Micciche.getPercentage()+"%");
        System.out.println("Partito: "+MPA.getName()+" Voti: "+MPA.getVotes()+" -> "+MPA.getPercentage()+"%");
        System.out.println("Partito: "+GrandeSud.getName()+" Voti: "+GrandeSud.getVotes()+" -> "+GrandeSud.getPercentage()+"%");
        System.out.println("Partito: "+FLI.getName()+" Voti: "+FLI.getVotes()+" -> "+FLI.getPercentage()+"%");
        System.out.println("Partito: "+PPA.getName()+" Voti: "+PPA.getVotes()+" -> "+PPA.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+Marano.getName()+" Voti: "+Marano.getVotes()+" -> "+Marano.getPercentage()+"%");
        System.out.println("Partito: "+SinistraUnita.getName()+" Voti: "+SinistraUnita.getVotes()+" -> "+SinistraUnita.getPercentage()+"%");
        System.out.println("Partito: "+IdV.getName()+" Voti: "+IdV.getVotes()+" -> "+IdV.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+MarianoFerro.getName()+" Voti: "+MarianoFerro.getVotes()+" -> "+MarianoFerro.getPercentage()+"%");
        System.out.println("Partito: "+Forconi.getName()+" Voti: "+Forconi.getVotes()+" -> "+Forconi.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+CatenoDeLuca.getName()+" Voti: "+CatenoDeLuca.getVotes()+" -> "+CatenoDeLuca.getPercentage()+"%");
        System.out.println("Partito: "+RivoluzioneSiciliana.getName()+" Voti: "+RivoluzioneSiciliana.getVotes()+" -> "+RivoluzioneSiciliana.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+Sturzo.getName()+" Voti: "+Sturzo.getVotes()+" -> "+Sturzo.getPercentage()+"%");
        System.out.println("Partito: "+SturzoPresidente.getName()+" Voti: "+SturzoPresidente.getVotes()+" -> "+SturzoPresidente.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+PartitoComunistaDeiLavoratori.getName()+" Voti: "+PartitoComunistaDeiLavoratori.getVotes()+" -> "+PartitoComunistaDeiLavoratori.getPercentage()+"%");
        System.out.println("Partito: "+PCL.getName()+" Voti: "+PCL.getVotes()+" -> "+PCL.getPercentage()+"%");
        System.out.println();
        
        System.out.println("Coalizione: "+Pinsone.getName()+" Voti: "+Pinsone.getVotes()+" -> "+Pinsone.getPercentage()+"%");
        System.out.println("Partito: "+Voi.getName()+" Voti: "+Voi.getVotes()+" -> "+Voi.getPercentage()+"%");
        System.out.println();
    }
}