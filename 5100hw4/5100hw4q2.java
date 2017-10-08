class Tool{
    protected int strength;
    protected char type;
    
    void setStrength(int x){
        strength = x;
    }
    public boolean fight(Tool t){
        if(this.strength >= t.strength)
            return true;
        else
            return false;
    }
}

class Rock extends Tool{
    public Rock(int s){
        this.strength = s;
        this.type = 'r';
    }
    @Override
    public boolean fight(Tool t){
        if(t.type == 's')   this.strength *=2;
        if(t.type == 'p')   this.strength /= 2;
        return super.fight(t);
    }
}

class Paper extends Tool{
    public Paper(int s){
        this.strength = s;
        this.type = 'p';
    }
    @Override
    public boolean fight(Tool t){
        if(t.type == 'r')   this.strength *= 2;
        if(t.type == 's')   this.strength /= 2;
        return super.fight(t);
    }
}

class Scissors extends Tool{
    public Scissors(int s){
        this.strength = s;
        this.type = 's';
    }
    @Override
    public boolean fight(Tool t){
        if(t.type == 'p')   this.strength *=2;
        if(t.type == 'r')   this.strength /= 2;
        return super.fight(t);
    }
}

class RockPaperScissorsGame{
        public static void main(String args[]){
            Scissors s = new Scissors(5);
            Paper p = new Paper(7);
            Rock r = new Rock(15);
            System.out.println(s.fight(p) + " , "+ p.fight(s) );
            System.out.println(p.fight(r) + " , "+ r.fight(p) );
            System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}