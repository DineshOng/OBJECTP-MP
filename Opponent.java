/**
 *  This is the Opponent/enemy class
 */
public abstract class Opponent{
  protected int hp;
  protected int atk;
  protected int def;
  protected int spd;
  protected boolean charge;
  
  public Opponent(int hp, int atk, int def, int spd){
    this.hp=hp;
    this.atk=atk;
    this.def=def;
    this.spd=spd;
    charge=false;
  }
  public void sethp(int i){
    hp=i;
  }
  public int gethp(){
    return hp;
  }
  public void setatk(int i){
    atk=i;
  }
  public int getatk(){
    return atk;
  }
  public void setdef(int i){
    def=i;
  }
  public int getdef(){
    return def;
  }
  public void setspd(int i){
    spd=i;
  }
  public int getspd(){
    return spd;
  }
  public void setcharge(boolean charge){
    this.charge=charge;
  }
  public boolean getcharge(){
    return charge;
  }
  public abstract int think();
}