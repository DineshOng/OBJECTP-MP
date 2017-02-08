/**
 *  This is the Warrior class
 */
public class Warrior{
  private int hp;
  private int atk;
  private int def;
  private int spd;
  private boolean charge;
  private Weapon currWeap;
  private Armor currArm;
  
  public Warrior(int hp, int atk, int def, int spd){
    this.hp=hp;
    this.atk=atk;
    this.def=def;
    this.spd=spd;
    charge=false;
  }
  public void equipWeapon(Weapon w){
    currWeap=w;
    atk+=currWeap.getatk();
    spd+=currWeap.getspd();
  }
  public void equipArmor(Armor a){
    currArm=a;
    def+=currArm.getdef();
    spd+=currArm.getspd();
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
}