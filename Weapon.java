/**
 *  This is the Weapon class
 */
public class Weapon{
  private int atk;
  private int spd;
  
  public Weapon(String type){
    if(type.equals("Dagger"))
      Dagger();
    else if(type.equals("Sword"))
      Sword();
    else if(type.equals("Axe"))
      Axe();
  }
  public void Dagger(){
    atk=20;
  }
  public void Sword(){
    atk=30;
    spd=-10;
  }
  public void Axe(){
    atk=40;
    spd=-20;
  }
  public int getatk(){
    return atk;
  }
  public int getspd(){
    return spd;
  }
}