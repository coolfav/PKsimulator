public class pokemon {
    String name;
    String[] types;
    int lvl;
    int hp;
    int atk;
    int def;
    int spatk;
    int spdef;
    int spd;
    move move1;
    move move2;
    move move3;
    move move4;

    public pokemon(String thename, String[] thetypes, int thelvl, int thehp, int theatk, int thedef, int thespatk, int thespdef, int thespd, move the1move, move the2move, move the3move, move the4move) {
        name = thename;
        types = thetypes;
        lvl = thelvl;
        hp = thehp;
        atk = theatk;
        def = thedef;
        spatk = thespatk;
        spdef = thespdef;
        spd = thespd;
        move1 = the1move;
        move2 = the2move;
        move3 = the3move;
        move4 = the4move;
    }


    public String getName() {
        return name;
    }

    public String[] getTypes() {
        return types;
    }


    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpatk() {
        return spatk;
    }

    public int getSpdef() {
        return spdef;
    }

    public int getSpd() {
        return spd;
    }

    public move getMove1() {
        return move1;
    }

    public move getMove2() {
        return move2;
    }

    public move getMove3() {
        return move3;
    }

    public move getMove4() {
        return move4;
    }

    public void decreaseHP(int thehp) {
        hp -= thehp;
    }

}
