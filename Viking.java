public class Viking extends Opponent{
  private int x;
  
  public Viking(){
    super(250, 30, 25, 30);
    x=2;
  }
  public int think(){
    if(x==1){
      x=2;
    }
    else if(x==2){
      x=1;
    }
    return x;
  }
}