import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserControls{
  private MainFrame mf;
  private Warrior man;
  private Opponent enemy;
  private Environment envi;
  private int eHP;
  private Timer t;
  
  public UserControls(MainFrame mf){
    this.mf = mf;
    
    //this.man = new Warrior(100, 1, 1, 50);
    //this.enemy = new Thief();
    //this.envi = new Environment("Arena");
    
    hoverButton(this.mf.getBTnewgame());
    hoverButton(this.mf.getBTexit());
    
    hoverButtonA1(this.mf.getBTLA());
    hoverButtonA2(this.mf.getBTMA());
    hoverButtonA3(this.mf.getBTHA());
    
    hoverButtonW1(this.mf.getBTDW());
    hoverButtonW2(this.mf.getBTSW());
    hoverButtonW3(this.mf.getBTAW());
    
    hoverButtonE1(this.mf.getBTE1());
    hoverButtonE2(this.mf.getBTE2());
    hoverButtonE3(this.mf.getBTE3());
    
    actionNewGame(this.mf.getBTnewgame());
    actionExit(this.mf.getBTexit());
    actionOk(this.mf.getBTok());
             
    actionLA(this.mf.getBTLA());
    actionMA(this.mf.getBTMA());
    actionHA(this.mf.getBTHA());
    
    actionDW(this.mf.getBTDW());
    actionSW(this.mf.getBTSW());
    actionAW(this.mf.getBTAW());
    
    actionE1(this.mf.getBTE1());
    actionE2(this.mf.getBTE2());
    actionE3(this.mf.getBTE3());
    
    actionAE(this.mf.getBTAE());
    actionSE(this.mf.getBTSE());
    actionCE(this.mf.getBTCE());
    
    actionA(this.mf.getBTA());
    actionD(this.mf.getBTD());
    actionC(this.mf.getBTC());
  }
  public static void enemyTurn(Warrior man, Opponent enemy, Environment envi, int y){
     // Environment Penalty
     if(envi.getname().equals("Swamp"))
        enemy.setatk(enemy.getatk()+envi.getatk());
     else if(envi.getname().equals("Colosseum"))
        enemy.setdef(enemy.getdef()+envi.getdef());
     
     if(y==1 && enemy.getcharge()==false){
       if((enemy.getatk()-man.getdef())>=0)
         man.sethp(man.gethp()-(enemy.getatk()-man.getdef()));
     }
     else if(y==1 && enemy.getcharge()==true){
        if(((enemy.getatk()*3)-man.getdef())>=0)
          man.sethp(man.gethp()-((enemy.getatk()*3)-man.getdef()));
        enemy.setcharge(false);
     }
     else if(y==2){
        if((man.getatk()-enemy.getdef())/2>=0)
          enemy.sethp(enemy.gethp()+((man.getatk()-enemy.getdef())/2));
      }
      else if(y==3 && enemy.getcharge()==false){
        enemy.setcharge(true);
      }
   }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed (ActionEvent e){
      if(!t.isRunning()&&man.getcharge()==false){
        if(man.gethp()>0&&enemy.gethp()<eHP){
          UserControls.this.mf.getBTA().setVisible(true);
          UserControls.this.mf.getBTD().setVisible(true);
          UserControls.this.mf.getBTC().setVisible(true);
        }
        UserControls.this.mf.getBRw().setValue(man.gethp());
        UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        UserControls.this.mf.getLBwAtk().setText(Integer.toString(man.getatk()));
        UserControls.this.mf.getLBwDef().setText(Integer.toString(man.getdef()));
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
      }
      else{
        if(man.gethp()>0&&enemy.gethp()<eHP){
          UserControls.this.mf.getBTA().setVisible(true);
          UserControls.this.mf.getBTD().setVisible(true);
        }
        UserControls.this.mf.getBRw().setValue(man.gethp());
        UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        UserControls.this.mf.getLBwAtk().setText(Integer.toString(man.getatk()));
        UserControls.this.mf.getLBwDef().setText(Integer.toString(man.getdef()));
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
      }
    }
  }
  public void TimerEvent(ActionListener e){
    t=new Timer(800, e);
    t.setRepeats(false);
    t.start();
  }
  
  private void actionA(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        
        if(envi.getname().equals("Swamp"))
          man.sethp(man.gethp()+envi.getdmg());
        else if(envi.getname().equals("Colosseum"))
          man.setatk(man.getatk()+envi.getatk());
        
        if(man.getcharge()==false){
          if((man.getatk()-enemy.getdef())>=0)
            enemy.sethp(enemy.gethp()+(man.getatk()-enemy.getdef()));
        }
        else if(man.getcharge()==true){
          if(((man.getatk()*3)-enemy.getdef())>=0)
            enemy.sethp(enemy.gethp()+((man.getatk()*3)-enemy.getdef()));
          man.setcharge(false);
          UserControls.this.mf.getBTC().setVisible(true);
        }

        UserControls.this.mf.getBTA().setVisible(false);
        UserControls.this.mf.getBTD().setVisible(false);
        UserControls.this.mf.getBTC().setVisible(false);
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        TimerEvent(new TimerListener());

        enemyTurn(man, enemy, envi, enemy.think());
        
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP-enemy.gethp()));
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        
        if(man.gethp()>0&&enemy.gethp()>=eHP){
          UserControls.this.mf.getT3().setText("Victory!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
        else if(man.gethp()<=0&&enemy.gethp()<eHP){
          UserControls.this.mf.getT3().setText("Defeat!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
      }
    });
  }
  private void actionD(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        if(envi.getname().equals("Swamp"))
          man.sethp(man.gethp()+envi.getdmg());
        else if(envi.getname().equals("Colosseum"))
          man.setatk(man.getatk()+envi.getatk());
        
        if((enemy.getatk()-man.getdef())/2>=0)
          man.sethp(man.gethp()-((enemy.getatk()-man.getdef())/2));
        
        UserControls.this.mf.getBTA().setVisible(false);
        UserControls.this.mf.getBTD().setVisible(false);
        UserControls.this.mf.getBTC().setVisible(false);
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        TimerEvent(new TimerListener());
        
        enemyTurn(man, enemy, envi, enemy.think());
        
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP-enemy.gethp()));
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        
        if(man.gethp()>0&&enemy.gethp()>=eHP){
          UserControls.this.mf.getT3().setText("Victory!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
        else if(man.gethp()<=0&&enemy.gethp()<eHP){
          UserControls.this.mf.getT3().setText("Defeat!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
      }
    });
  }
  private void actionC(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        if(envi.getname().equals("Swamp"))
          man.sethp(man.gethp()+envi.getdmg());
        else if(envi.getname().equals("Colosseum"))
          man.setatk(man.getatk()+envi.getatk());
        
        UserControls.this.mf.getBTC().setVisible(false);
        if(man.getcharge()==false)
          man.setcharge(true);
        
        UserControls.this.mf.getBTA().setVisible(false);
        UserControls.this.mf.getBTD().setVisible(false);
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        TimerEvent(new TimerListener());
        
        enemyTurn(man, enemy, envi, enemy.think());
        
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP-enemy.gethp()));
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getBattle().revalidate();
        UserControls.this.mf.getBattle().repaint();
        
        if(man.gethp()>0&&enemy.gethp()>=eHP){
          UserControls.this.mf.getT3().setText("Victory!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
        else if(man.gethp()<=0&&enemy.gethp()<eHP){
          UserControls.this.mf.getT3().setText("Defeat!");
          UserControls.this.mf.getT3().setVisible(true);
          UserControls.this.mf.getBTok().setVisible(true);
          UserControls.this.mf.getBTA().setVisible(false);
          UserControls.this.mf.getBTD().setVisible(false);
          UserControls.this.mf.getBTC().setVisible(false);
          UserControls.this.mf.getBattle().revalidate();
          UserControls.this.mf.getBattle().repaint();
        }
      }
    });
  }
  private void actionAE(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new arena");
        UserControls.this.envi = new Environment("Arena");
        UserControls.this.mf.getEnviBG().setIcon(new ImageIcon("Graphics/Arena.jpg"));
        if(man.getspd()<enemy.getspd()){
          enemyTurn(man, enemy, envi, enemy.think());
          UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
          UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
          UserControls.this.mf.getBRw().setValue(man.gethp());
          UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        }
        UserControls.this.mf.toBattle();
      }
    });
  }
  private void actionSE(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new swamp");
        UserControls.this.envi = new Environment("Swamp");
        UserControls.this.mf.getEnviBG().setIcon(new ImageIcon("Graphics/Swamp.jpg"));
        if(man.getspd()<enemy.getspd()){
          enemyTurn(man, enemy, envi, enemy.think());
          UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
          UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
          UserControls.this.mf.getBRw().setValue(man.gethp());
          UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        }
        UserControls.this.mf.toBattle();
      }
    });
  }
  private void actionCE(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new colosseum");
        UserControls.this.envi = new Environment("Colosseum");
        UserControls.this.mf.getEnviBG().setIcon(new ImageIcon("Graphics/Colosseum.jpg"));
        if(man.getspd()<enemy.getspd()){
          enemyTurn(man, enemy, envi, enemy.think());
          UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
          UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
          UserControls.this.mf.getBRw().setValue(man.gethp());
          UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        }
        UserControls.this.mf.toBattle();
      }
    });
  }
  
  private void actionE1(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new enemy1");
        UserControls.this.enemy = new Thief();
        
        UserControls.this.mf.getBRw().setValue(man.gethp());
        UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        
        UserControls.this.mf.getBRe().setMinimum(0);
        UserControls.this.mf.getBRe().setMaximum(enemy.gethp());
        eHP=enemy.gethp();
        UserControls.this.enemy.sethp(0);
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP));
        UserControls.this.mf.getLBE().setText("Bae-Na");
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getLBeSpd().setText(Integer.toString(enemy.getspd())+" ");
        UserControls.this.mf.getT2().setIcon(new ImageIcon("Graphics/E1.png"));
        UserControls.this.mf.toChooseEnvi();
      }
    });
  }
  private void actionE2(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new enemy2");
        UserControls.this.enemy = new Viking();
        
        UserControls.this.mf.getBRw().setValue(man.gethp());
        UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        
        UserControls.this.mf.getBRe().setMinimum(0);
        UserControls.this.mf.getBRe().setMaximum(enemy.gethp());
        eHP=enemy.gethp();
        UserControls.this.enemy.sethp(0);
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP));
        UserControls.this.mf.getLBE().setText("Fire-Arms");
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getLBeSpd().setText(Integer.toString(enemy.getspd())+" ");
        UserControls.this.mf.getT2().setIcon(new ImageIcon("Graphics/E2.png"));
        UserControls.this.mf.toChooseEnvi();
      }
    });
  }
  private void actionE3(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new enemy3");
        UserControls.this.enemy = new Minotaur();
        
        UserControls.this.mf.getBRw().setValue(man.gethp());
        UserControls.this.mf.getLBrW().setText(Integer.toString(man.gethp()));
        
        UserControls.this.mf.getBRe().setMinimum(0);
        UserControls.this.mf.getBRe().setMaximum(enemy.gethp());
        eHP=enemy.gethp();
        UserControls.this.enemy.sethp(0);
        UserControls.this.mf.getBRe().setValue(enemy.gethp());
        UserControls.this.mf.getLBrE().setText(Integer.toString(eHP));
        UserControls.this.mf.getLBE().setText("Bluemane");
        UserControls.this.mf.getLBeAtk().setText(Integer.toString(enemy.getatk())+" ");
        UserControls.this.mf.getLBeDef().setText(Integer.toString(enemy.getdef())+" ");
        UserControls.this.mf.getLBeSpd().setText(Integer.toString(enemy.getspd())+" ");
        UserControls.this.mf.getT2().setIcon(new ImageIcon("Graphics/E3.png"));
        UserControls.this.mf.toChooseEnvi();
      }
    });
  }
  
  private void actionDW(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new dagger");
        UserControls.this.man.equipWeapon(new Weapon("Dagger"));
        UserControls.this.mf.getLBwAtk().setText(Integer.toString(man.getatk()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toChooseEnemy();
      }
    });
  }
  private void actionSW(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new sword");
        UserControls.this.man.equipWeapon(new Weapon("Sword"));
        UserControls.this.mf.getLBwAtk().setText(Integer.toString(man.getatk()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toChooseEnemy();
      }
    });
  }
  private void actionAW(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new axe");
        UserControls.this.man.equipWeapon(new Weapon("Axe"));
        UserControls.this.mf.getLBwAtk().setText(Integer.toString(man.getatk()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toChooseEnemy();
      }
    });
  }
  
  private void actionLA(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new light armor");
        UserControls.this.man.equipArmor(new Armor("Light"));
        UserControls.this.mf.getLBwDef().setText(Integer.toString(man.getdef()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toEquipWeapon();
      }
    });
  }
  private void actionMA(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new medium armor");
        UserControls.this.man.equipArmor(new Armor("Medium"));
        UserControls.this.mf.getLBwDef().setText(Integer.toString(man.getdef()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toEquipWeapon();
      }
    });
  }
  private void actionHA(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.out.println("new heavy armor");
        UserControls.this.man.equipArmor(new Armor("Heavy"));
        UserControls.this.mf.getLBwDef().setText(Integer.toString(man.getdef()));
        UserControls.this.mf.getLBwSpd().setText(Integer.toString(man.getspd()));
        UserControls.this.mf.toEquipWeapon();
      }
    });
  }
  private void actionOk(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        UserControls.this.mf.toMainMenu();
      }
    });
  }
  private void actionNewGame(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        UserControls.this.man = new Warrior(100, 1, 1, 50);
        UserControls.this.enemy = new Thief();
        UserControls.this.envi = new Environment("Arena");
        UserControls.this.mf.toEquipArmor();
      }
    });
  }
  private void actionExit(JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
        System.exit(0);
      }
    });
  }
  private void hoverButton(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setForeground(Color.YELLOW);
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setForeground(new Color(255, 51, 102));
      }
    });
  }
  private void hoverButtonA1(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A111.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A1.png"));
      }
    });
  }
  private void hoverButtonA2(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A222.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A2.png"));
      }
    });
  }
  private void hoverButtonA3(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A333.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/A3.png"));
      }
    });
  }
  private void hoverButtonW1(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W111.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W1.png"));
      }
    });
  }
  private void hoverButtonW2(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W222.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W2.png"));
      }
    });
  }
  private void hoverButtonW3(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W333.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/W3.png"));
      }
    });
  }
  private void hoverButtonE1(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E111.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E1.png"));
      }
    });
  }
  private void hoverButtonE2(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E222.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E2.png"));
      }
    });
  }
  private void hoverButtonE3(final JButton JButt){
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseEntered(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E333.png"));
      }
    });
    JButt.addMouseListener(new MouseAdapter(){
      public void mouseExited(MouseEvent me){
        JButt.setIcon(new ImageIcon("Graphics/E3.png"));
      }
    });
  }
}