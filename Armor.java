/**
 *  This is the Armor class
 */
public class Armor{
  private int def;
  private int spd;
  
  public Armor(String type){
    if(type.equals("Light"))
      Light();
    else if(type.equals("Medium"))
      Medium();
    else if(type.equals("Heavy"))
      Heavy();
  }
  public void Light(){
    def=15;
    spd=-5;
  }
  public void Medium(){
    def=25;
    spd=-15;
  }
  public void Heavy(){
    def=35;
    spd=-25;
  }
  public int getdef(){
    return def;
  }
  public int getspd(){
    return spd;
  }
}