public class Thief extends Opponent{
  
  public Thief(){
    super(150, 20, 15, 40);
  }
  public int think(){
    return 1;
  }
}