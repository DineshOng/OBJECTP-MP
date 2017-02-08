public class Minotaur extends Opponent{
  private int x;
  
  public Minotaur(){
    super(350, 40, 35, 20);
    x=3;
  }
  public int think(){
    if(x==1){
      x=3;
    }
    else if(x==3){
      x=1;
    }
    return x;
  }
}