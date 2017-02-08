/**
 *  This is the Environment class
 */
public class Environment{
  private int atk;
  private int def;
  private int dmg;
  private String name;
  
  public Environment(String place){
    if(place.equals("Arena"))
      Arena();
    else if(place.equals("Swamp"))
      Swamp();
    else if(place.equals("Colosseum"))
      Colosseum();
  }
  public void Arena(){
    atk=0;
    def=0;
    dmg=0;
    name="Arena";
  }
  public void Swamp(){
    atk=1;
    def=0;
    dmg=-1;
    name="Swamp";
  }
  public void Colosseum(){
    atk=1;
    def=-1;
    dmg=0;
    name="Colosseum";
  }
  public int getatk(){
    return atk;
  }
  public int getdef(){
    return def;
  }
  public int getdmg(){
    return dmg;
  }
  public String getname(){
    return name;
  }
}