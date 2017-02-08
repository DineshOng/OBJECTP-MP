import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame{
  private JFrame frame;
  private JPanel mainmenu;
  private JButton btnewgame, btexit, btok;
  private JPanel equipArmor, equipWeapon, chooseEnemy, chooseEnvi, battle;
  private JLabel title1, title2, title3;
  private JLabel ArmorT, WeaponT, EnemyT, EnviT; //Choose titles
  private JLabel name1, name2, name3;
  private JButton btLA, btMA, btHA;
  private JButton btDW, btSW, btAW;
  private JButton btE1, btE2, btE3;
  private JButton btAE, btSE, btCE;
  private JButton btA, btD, btC;
  private JProgressBar brW, brE;
  private JLabel lbW, lbE; //Warrior and Enemy name
  private JLabel lbRW, lbRE; //Health ratio of warrior and enemy
  private JLabel pAL, pDL, pSL; //left atk, def, spd icon
  private JLabel pAR, pDR, pSR; //right atk, def, spd icon
  private JLabel wAtk, wDef, wSpd; //Warrior's atk, def, spd
  private JLabel eAtk, eDef, eSpd; //Enemy's atk, def, spd
  private JLabel bg1, bg2, bg3;

  public MainFrame(){
    this.frame=new JFrame();
    
    this.frame.setTitle("Fighting Game Simulator v.3.10");
    this.frame.setBounds(55, 10, 1280, 700);
    this.frame.setResizable(false);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    iniFonts();
    MainMenu();
    EquipArmor();
    EquipWeapon();
    ChooseEnemy();
    ChooseEnvi();
    Battle();
    
    this.frame.add(this.mainmenu);
    this.frame.revalidate();
    this.frame.repaint();
    this.frame.setVisible(true);
  }
  
  
  public JFrame getFrame(){
    return frame;
  }
   public JPanel getBattle(){ //returns battle panel
    return battle;
  }
  public JLabel getEnviBG(){ //returns environment background
    return this.bg3;
  }
  public JProgressBar getBRw(){ //returns progress bar of warrior
    return this.brW;
  }
  public JProgressBar getBRe(){ //returns progress bar of enemy
    return this.brE;
  }
  public JLabel getLBE(){ //returns enemy name
    return this.lbE;
  }
  public JLabel getT3(){ //returns win or lose
    return this.title3;
  }
  public JLabel getT2(){ 
    return this.title2;
  }
  public JLabel getT1(){ 
    return this.title1;
  }
  public JLabel getLBwAtk(){ //returns warrior attack
    return this.wAtk;
  }
  public JLabel getLBwDef(){ //returns warrior defense
    return this.wDef;
  }
  public JLabel getLBwSpd(){ //returns warrior Spd
    return this.wSpd;
  }
  public JLabel getLBrW(){ //returns warrior health ratio
    return this.lbRW;
  }
  public JLabel getLBrE(){ //returns enemy health ratio
    return this.lbRE;
  }
  public JLabel getLBeAtk(){ //returns enemy attack
    return this.eAtk;
  }
  public JLabel getLBeDef(){ //returns enemy defense
    return this.eDef;
  }
  public JLabel getLBeSpd(){ //returns enemy speed
    return this.eSpd;
  }
  public JButton getBTA(){ //returns attack button
    return this.btA;
  }
  public JButton getBTD(){ //returns defense button
    return this.btD;
  }
  public JButton getBTC(){  //returns charge button
    return this.btC;
  }
  public JButton getBTnewgame(){ //returns new game button
    return this.btnewgame;
  }
  public JButton getBTexit(){ //returns exit button
    return this.btexit;
  }
  public JButton getBTok(){
    return this.btok;
  }
  public JButton getBTLA(){ //light armor button
    return this.btLA;
  }
  public JButton getBTMA(){ //medium armor button
    return this.btMA;
  }
  public JButton getBTHA(){ //heavy armor button
    return this.btHA;
  }
  public JButton getBTDW(){ //dagger weapon button
    return this.btDW;
  }
  public JButton getBTSW(){ //sword weapon button
    return this.btSW;
  }
  public JButton getBTAW(){ //axe weapon button
    return this.btAW;
  }
  public JButton getBTE1(){ //enemy 1 (thief) button
    return this.btE1;
  }
  public JButton getBTE2(){ //enemy 2 (viking) button
    return this.btE2;
  }
  public JButton getBTE3(){ //enemy 3 (minotaur) button
    return this.btE3;
  }
  public JButton getBTAE(){ //envi 1 (arena) button
    return this.btAE;
  }
  public JButton getBTSE(){ //envi 2 (swamp) button
    return this.btSE;
  }
  public JButton getBTCE(){ //envi 3 (colosseum) button
    return this.btCE;
  }
  
  
  public void toEquipArmor(){
    this.frame.remove(this.mainmenu);
    this.frame.add(this.equipArmor);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toEquipWeapon(){
    this.frame.remove(this.equipArmor);
    this.frame.add(this.equipWeapon);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toChooseEnemy(){
    this.frame.remove(this.equipWeapon);
    this.frame.add(this.chooseEnemy);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toChooseEnvi(){
    this.frame.remove(this.chooseEnemy);
    this.frame.add(this.chooseEnvi);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toBattle(){
    this.frame.remove(this.chooseEnvi);
    this.frame.add(this.battle);
    this.btA.setVisible(true);
    this.btD.setVisible(true);
    this.btC.setVisible(true);
    this.title3.setVisible(false);
    this.btok.setVisible(false);
    this.frame.revalidate();
    this.frame.repaint();
  }
  public void toMainMenu(){
    this.frame.remove(this.battle);
    this.frame.add(this.mainmenu);
    this.frame.revalidate();
    this.frame.repaint();
  }
  
  
  private void Battle(){
    this.battle=new JPanel();
    this.battle.setLayout(null);
    
    this.bg3 = new JLabel();
    this.bg3.setBounds(0, 0, 1280, 700);
    
    this.btA = new JButton("Attack");
    this.btA.setBounds(23+325, 588, 186, 63);
    this.battle.add(this.btA);
  
    this.btD = new JButton("Defend");
    this.btD.setBounds(211+325, 588, 186, 63);
    this.battle.add(this.btD);
  
    this.btC = new JButton("Charge");
    this.btC.setBounds(399+325, 588, 186, 63);
    this.battle.add(this.btC);
    
    this.title3 = new JLabel();
    this.title3.setForeground(Color.WHITE);
    this.title3.setFont(new Font("Tarrget", Font.BOLD | Font.PLAIN, 99));
    this.title3.setHorizontalAlignment(SwingConstants.CENTER);
    this.title3.setBounds(0, 0, 1280, 700);
    this.battle.add(this.title3);
    
    this.btok = new JButton("OK");
    this.btok.setBounds(583, 390, 89, 23);
    this.btok.setVisible(false);
    this.battle.add(this.btok);
    
    this.lbRW = new JLabel();
    this.lbRW.setForeground(new Color(255, 20, 147));
    this.lbRW.setHorizontalAlignment(SwingConstants.CENTER);
    this.lbRW.setBounds(10, 11, 605, 44);

    this.lbRE = new JLabel();
    this.lbRE.setForeground(new Color(255, 20, 147));
    this.lbRE.setHorizontalAlignment(SwingConstants.CENTER);
    this.lbRE.setBounds(656, 11, 605, 44);
    
    this.brW = new JProgressBar();
    this.brW.setMinimum(0);
    this.brW.setMaximum(100);
    this.brW.setValue(100);
    this.brW.setForeground(new Color(0, 206, 209));
    this.brW.setFont(new Font("Tarrget", Font.PLAIN, 23));
    this.brW.setBackground(Color.DARK_GRAY);
    this.brW.setBounds(10, 11, 605, 44);
    
    this.brE = new JProgressBar();
    this.brE.setForeground(Color.DARK_GRAY);
    this.brE.setFont(new Font("Tarrget", Font.PLAIN, 23));
    this.brE.setBackground(new Color(0, 206, 209));
    this.brE.setBounds(656, 11, 605, 44);
    
    this.lbW = new JLabel("Warrior");
    this.lbW.setBackground(Color.WHITE);
    this.lbW.setForeground(Color.WHITE);
    this.lbW.setHorizontalAlignment(SwingConstants.LEFT);
    this.lbW.setFont(new Font("Tarrget", Font.ITALIC, 25));
    this.lbW.setBounds(8, 45, 400, 44);
    
    this.lbE = new JLabel();
    this.lbE.setForeground(Color.WHITE);
    this.lbE.setHorizontalAlignment(SwingConstants.RIGHT);
    this.lbE.setFont(new Font("Tarrget", Font.ITALIC, 25));
    this.lbE.setBounds(861, 45, 400, 44);
    
    this.pAL= new JLabel();
    this.pAL.setIcon(new ImageIcon("Graphics/a.png"));
    this.pAL.setHorizontalAlignment(SwingConstants.CENTER);
    this.pAL.setBounds(10, 84, 25, 25);
    
    this.pDL= new JLabel();
    this.pDL.setIcon(new ImageIcon("Graphics/d.png"));
    this.pDL.setHorizontalAlignment(SwingConstants.CENTER);
    this.pDL.setBounds(10, 114, 25, 25);
    
    this.pSL= new JLabel();
    this.pSL.setIcon(new ImageIcon("Graphics/s.png"));
    this.pSL.setHorizontalAlignment(SwingConstants.CENTER);
    this.pSL.setBounds(10, 143, 25, 25);
    
    this.pAR= new JLabel();
    this.pAR.setIcon(new ImageIcon("Graphics/a.png"));
    this.pAR.setHorizontalAlignment(SwingConstants.CENTER);
    this.pAR.setBounds(1236, 84, 25, 25);
    
    this.pDR= new JLabel();
    this.pDR.setIcon(new ImageIcon("Graphics/d.png"));
    this.pDR.setHorizontalAlignment(SwingConstants.CENTER);
    this.pDR.setBounds(1236, 114, 25, 25);
    
    this.pSR= new JLabel();
    this.pSR.setIcon(new ImageIcon("Graphics/s1.png"));
    this.pSR.setHorizontalAlignment(SwingConstants.CENTER);
    this.pSR.setBounds(1236, 143, 25, 25);
    
    this.wAtk = new JLabel();
    this.wAtk.setHorizontalAlignment(SwingConstants.LEFT);
    this.wAtk.setForeground(Color.WHITE);
    this.wAtk.setFont(new Font("Tarrget", Font.ITALIC, 20));
    this.wAtk.setBackground(Color.WHITE);
    this.wAtk.setBounds(36, 75, 72, 44);

    this.wDef = new JLabel();
    this.wDef.setHorizontalAlignment(SwingConstants.LEFT);
    this.wDef.setForeground(Color.WHITE);
    this.wDef.setFont(new Font("Tarrget", Font.ITALIC, 20));
    this.wDef.setBackground(Color.WHITE);
    this.wDef.setBounds(36, 103, 72, 44);

    this.wSpd = new JLabel();
    this.wSpd.setHorizontalAlignment(SwingConstants.LEFT);
    this.wSpd.setForeground(Color.WHITE);
    this.wSpd.setFont(new Font("Tarrget", Font.ITALIC, 20));
    this.wSpd.setBackground(Color.WHITE);
    this.wSpd.setBounds(36, 132, 72, 44);
    
    this.eAtk = new JLabel();
    this.eAtk.setHorizontalAlignment(SwingConstants.RIGHT);
    this.eAtk.setForeground(Color.WHITE);
    this.eAtk.setFont(new Font("Tarrget", Font.ITALIC, 18));
    this.eAtk.setBackground(Color.WHITE);
    this.eAtk.setBounds(1164, 75, 72, 44);
  
    this.eDef = new JLabel();
    this.eDef.setHorizontalAlignment(SwingConstants.RIGHT);
    this.eDef.setForeground(Color.WHITE);
    this.eDef.setFont(new Font("Tarrget", Font.ITALIC, 18));
    this.eDef.setBackground(Color.WHITE);
    this.eDef.setBounds(1164, 103, 72, 44);
    
    this.eSpd = new JLabel();
    this.eSpd.setHorizontalAlignment(SwingConstants.RIGHT);
    this.eSpd.setForeground(Color.WHITE);
    this.eSpd.setFont(new Font("Tarrget", Font.ITALIC, 18));
    this.eSpd.setBackground(Color.WHITE);
    this.eSpd.setBounds(1162, 132, 72, 44);
    
    this.title1 = new JLabel();
    this.title1.setIcon(new ImageIcon("Graphics/Heman.png"));
    this.title1.setHorizontalAlignment(SwingConstants.CENTER);
    this.title1.setBounds(203, 155, 306, 373);
    this.battle.add(this.title1);
    
    this.title2 = new JLabel();
    this.title2.setHorizontalAlignment(SwingConstants.CENTER);
    this.title2.setBounds(724, 143, 306, 373);
    this.battle.add(this.title2);

    this.battle.add(this.lbW);
    this.battle.add(this.lbE);
    this.battle.add(this.pAL);
    this.battle.add(this.pDL);
    this.battle.add(this.pSL);
    this.battle.add(this.pAR);
    this.battle.add(this.pDR);
    this.battle.add(this.pSR);
    this.battle.add(this.wAtk);
    this.battle.add(this.wDef);
    this.battle.add(this.wSpd);
    this.battle.add(this.eAtk);
    this.battle.add(this.eDef);
    this.battle.add(this.eSpd);
    this.battle.add(this.lbRW);
    this.battle.add(this.lbRE);
    this.battle.add(this.brW);
    this.battle.add(this.brE);
    this.battle.add(this.bg3);
  }
  
  private void ChooseEnvi(){
    this.chooseEnvi=new JPanel();
    this.chooseEnvi.setLayout(null);
    
    this.bg2 = new JLabel();
    this.bg2.setBounds(0, 0, 1280, 700);
    this.bg2.setIcon(new ImageIcon("Graphics/bg2.jpg"));
    
    this.EnviT = new JLabel("CHOOSE ENVIRONMENT");
    this.EnviT.setHorizontalAlignment(SwingConstants.CENTER);
    this.EnviT.setForeground(Color.WHITE);
    this.EnviT.setFont(new Font("Tarrget", Font.ITALIC, 50));
    this.EnviT.setBounds(0, 0, 1264, 179);
    
    this.btAE = new JButton();
    this.btAE.setIcon(new ImageIcon("Graphics/Arena0.jpg"));
    this.btAE.setBounds(62, 231, 320, 175);
    
    this.name1 = new JLabel("Envi 1");
    this.name1.setForeground(Color.WHITE);
    this.name1.setHorizontalAlignment(SwingConstants.CENTER);
    this.name1.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name1.setBounds(62, 394, 320, 50);
    this.chooseEnvi.add(this.name1);
    
    this.btSE = new JButton();
    this.btSE.setIcon(new ImageIcon("Graphics/Swamp0.jpg"));
    this.btSE.setBounds(471, 231, 320, 175);
    
    this.name2 = new JLabel("Envi 2");
    this.name2.setForeground(Color.WHITE);
    this.name2.setHorizontalAlignment(SwingConstants.CENTER);
    this.name2.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name2.setBounds(471, 394, 320, 50);
    this.chooseEnvi.add(this.name2);
    
    this.btCE = new JButton();
    this.btCE.setIcon(new ImageIcon("Graphics/Colosseum0.jpg"));
    this.btCE.setBounds(881, 231, 320, 175);
    
    this.name3 = new JLabel("Envi 3");
    this.name3.setForeground(Color.WHITE);
    this.name3.setHorizontalAlignment(SwingConstants.CENTER);
    this.name3.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name3.setBounds(881, 394, 320, 50);
    this.chooseEnvi.add(this.name3);
    
    this.chooseEnvi.add(this.EnviT);
    this.chooseEnvi.add(this.btAE);
    this.chooseEnvi.add(this.btSE);
    this.chooseEnvi.add(this.btCE);
    this.chooseEnvi.add(this.bg2);
  }
  
  private void ChooseEnemy(){
    this.chooseEnemy=new JPanel();
    this.chooseEnemy.setLayout(null);
    
    this.bg2 = new JLabel();
    this.bg2.setBounds(0, 0, 1280, 700);
    this.bg2.setIcon(new ImageIcon("Graphics/bg2.jpg"));
    
    this.EnemyT = new JLabel("CHOOSE ENEMY");
    this.EnemyT.setHorizontalAlignment(SwingConstants.CENTER);
    this.EnemyT.setForeground(Color.WHITE);
    this.EnemyT.setFont(new Font("Tarrget", Font.ITALIC, 50));
    this.EnemyT.setBounds(0, 0, 1264, 179);
    
    this.btE1 = new JButton();
    this.btE1.setIcon(new ImageIcon("Graphics/E1.png"));
    this.btE1.setBounds(70, 149, 306, 373);
    noborderButton(this.btE1, null, 0, 0);
    
    this.name1 = new JLabel("Enemy 1");
    this.name1.setForeground(Color.WHITE);
    this.name1.setHorizontalAlignment(SwingConstants.CENTER);
    this.name1.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name1.setBounds(70, 521, 306, 50);
    this.chooseEnemy.add(this.name1);
    
    this.btE2 = new JButton();
    this.btE2.setIcon(new ImageIcon("Graphics/E2.png"));
    this.btE2.setBounds(479, 149, 306, 373);
    noborderButton(this.btE2, null, 0, 0);
    
    this.name2 = new JLabel("Enemy 2");
    this.name2.setForeground(Color.WHITE);
    this.name2.setHorizontalAlignment(SwingConstants.CENTER);
    this.name2.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name2.setBounds(479, 521, 306, 50);
    this.chooseEnemy.add(this.name2);
    
    this.btE3 = new JButton();
    this.btE3.setIcon(new ImageIcon("Graphics/E3.png"));
    this.btE3.setBounds(884, 149, 306, 373);
    noborderButton(this.btE3, null, 0, 0);
    
    this.name3 = new JLabel("Enemy 3");
    this.name3.setForeground(Color.WHITE);
    this.name3.setHorizontalAlignment(SwingConstants.CENTER);
    this.name3.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name3.setBounds(884, 521, 306, 50);
    this.chooseEnemy.add(this.name3);
    
    this.chooseEnemy.add(this.EnemyT);
    this.chooseEnemy.add(this.btE1);
    this.chooseEnemy.add(this.btE2);
    this.chooseEnemy.add(this.btE3);
    this.chooseEnemy.add(this.bg2);
  }
  
  private void EquipWeapon(){
    this.equipWeapon=new JPanel();
    this.equipWeapon.setLayout(null);
    
    this.bg2 = new JLabel();
    this.bg2.setBounds(0, 0, 1280, 700);
    this.bg2.setIcon(new ImageIcon("Graphics/bg2.jpg"));
    
    this.WeaponT = new JLabel("CHOOSE WEAPON");
    this.WeaponT.setHorizontalAlignment(SwingConstants.CENTER);
    this.WeaponT.setForeground(Color.WHITE);
    this.WeaponT.setFont(new Font("Tarrget", Font.ITALIC, 50));
    this.WeaponT.setBounds(0, 0, 1264, 179);
    
    this.btDW = new JButton();
    this.btDW.setIcon(new ImageIcon("Graphics/W1.png"));
    this.btDW.setBounds(144, 180, 250, 250);
    noborderButton(this.btDW, null, 0, 0);
    
    this.name1 = new JLabel("Dagger");
    this.name1.setForeground(Color.WHITE);
    this.name1.setHorizontalAlignment(SwingConstants.CENTER);
    this.name1.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name1.setBounds(144, 429, 250, 50);
    this.equipWeapon.add(this.name1);
    
    this.btSW = new JButton();
    this.btSW.setIcon(new ImageIcon("Graphics/W2.png"));
    this.btSW.setBounds(511, 180, 250, 250);
    noborderButton(this.btSW, null, 0, 0);
    
    this.name2 = new JLabel("Sword");
    this.name2.setForeground(Color.WHITE);
    this.name2.setHorizontalAlignment(SwingConstants.CENTER);
    this.name2.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name2.setBounds(511, 429, 250, 50);
    this.equipWeapon.add(this.name2);
    
    this.btAW = new JButton();
    this.btAW.setIcon(new ImageIcon("Graphics/W3.png"));
    this.btAW.setBounds(881, 180, 250, 250);
    noborderButton(this.btAW, null, 0, 0);
    
    this.name3 = new JLabel("Axe");
    this.name3.setForeground(Color.WHITE);
    this.name3.setHorizontalAlignment(SwingConstants.CENTER);
    this.name3.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name3.setBounds(881, 429, 250, 50);
    this.equipWeapon.add(this.name3);
    
    this.equipWeapon.add(this.WeaponT);
    this.equipWeapon.add(this.btDW);
    this.equipWeapon.add(this.btSW);
    this.equipWeapon.add(this.btAW);
    this.equipWeapon.add(this.bg2);
  }
  
  private void EquipArmor(){
    this.equipArmor=new JPanel();
    this.equipArmor.setLayout(null);
    
    this.bg2 = new JLabel();
    this.bg2.setBounds(0, 0, 1280, 700);
    this.bg2.setIcon(new ImageIcon("Graphics/bg2.jpg"));
    
    this.ArmorT = new JLabel("CHOOSE ARMOR");
    this.ArmorT.setHorizontalAlignment(SwingConstants.CENTER);
    this.ArmorT.setForeground(Color.WHITE);
    this.ArmorT.setFont(new Font("Tarrget", Font.ITALIC, 50));
    this.ArmorT.setBounds(0, 0, 1264, 179);
    
    this.name1 = new JLabel("Light");
    this.name1.setForeground(Color.WHITE);
    this.name1.setHorizontalAlignment(SwingConstants.CENTER);
    this.name1.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name1.setBounds(155+20, 444, 129, 52);
    this.equipArmor.add(this.name1);
    
    this.btLA = new JButton();//+9+5+5+5+5+5
    this.btLA.setIcon(new ImageIcon("Graphics/A1.png"));
    this.btLA.setBounds(155+20, 217, 129, 235);
    noborderButton(this.btLA, null, 0, 0);
    
    this.name2 = new JLabel("Medium");
    this.name2.setHorizontalAlignment(SwingConstants.CENTER);
    this.name2.setForeground(Color.WHITE);
    this.name2.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name2.setBounds(542+20, 444, 129, 52);
    this.equipArmor.add(this.name2);
    
    this.btMA = new JButton();
    this.btMA.setIcon(new ImageIcon("Graphics/A2.png"));
    this.btMA.setBounds(542+20, 217, 129, 235);
    noborderButton(this.btMA, null, 0, 0);
    
    this.name3 = new JLabel("Heavy");
    this.name3.setHorizontalAlignment(SwingConstants.CENTER);
    this.name3.setForeground(Color.WHITE);
    this.name3.setFont(new Font("Tarrget", Font.PLAIN, 25));
    this.name3.setBounds(910+20, 444, 129, 52);
    this.equipArmor.add(this.name3);
    
    this.btHA = new JButton();
    this.btHA.setIcon(new ImageIcon("Graphics/A3.png"));
    this.btHA.setBounds(910+20, 217, 129, 235);
    noborderButton(this.btHA, null, 0, 0);
    
    this.equipArmor.add(this.ArmorT);
    this.equipArmor.add(this.btLA);
    this.equipArmor.add(this.btMA);
    this.equipArmor.add(this.btHA);
    this.equipArmor.add(this.bg2);
  }
  
  private void MainMenu(){
    this.mainmenu=new JPanel();
    this.mainmenu.setLayout(null);
    
    this.bg1 = new JLabel();
    this.bg1.setBounds(0, 0, 1280, 700);
    this.bg1.setIcon(new ImageIcon("Graphics/bg1.jpg"));
    
    String Tarrget="Tarrget";
    String TarrgetA="Tarrget Academy";
    
    this.title1 = new JLabel("CHEEKEN");
    this.title1.setFont(new Font(TarrgetA, Font.PLAIN, 99));
    this.title1.setHorizontalAlignment(SwingConstants.CENTER);
    this.title1.setForeground(new Color(0, 206, 209));
    this.title1.setBounds(0, -68, 1264, 662);
    
    this.title2 = new JLabel("3.14");
    this.title2.setFont(new Font(TarrgetA, Font.PLAIN, 99));
    this.title2.setHorizontalAlignment(SwingConstants.CENTER);
    this.title2.setForeground(new Color(0, 206, 209));
    this.title2.setBounds(0, 0, 1264, 662);
    
    this.btnewgame = new JButton("NEW GAME");
    //this.btnewgame.setHorizontalAlignment(SwingConstants.CENTER);
    this.btnewgame.setForeground(new Color(255, 51, 102));
    this.btnewgame.setBounds(455, 517, 354, 32);
    noborderButton(this.btnewgame, Tarrget, 0, 40);
    
    this.btexit = new JButton("EXIT");
    //this.btexit.setHorizontalAlignment(SwingConstants.CENTER);
    this.btexit.setForeground(new Color(255, 51, 102));
    this.btexit.setBounds(455, 562, 354, 32);
    noborderButton(this.btexit, Tarrget, 0, 40);
    
    this.mainmenu.add(this.title1);
    this.mainmenu.add(this.title2);
    this.mainmenu.add(this.btnewgame);
    this.mainmenu.add(this.btexit);
    this.mainmenu.add(this.bg1);            
  }
  private void noborderButton(JButton JButt, String paramFont, int fType, int fSize)
  {
    JButt.setFont(new Font(paramFont, fType, fSize));
    JButt.setBorderPainted(false);
    JButt.setFocusPainted(false);
    JButt.setContentAreaFilled(false);
  }
  private void iniFonts(){
    try{
      Font localFont1 = Font.createFont(0, new File("tarrget.ttf"));
      Font localFont2 = Font.createFont(0, new File("tarrgetacad.ttf"));
      Font localFont3 = Font.createFont(0, new File("tarrgetacadital.ttf"));
      
      GraphicsEnvironment LGE = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
      LGE.registerFont(localFont1);
      LGE.registerFont(localFont2);
      LGE.registerFont(localFont3);
    }
    catch (IOException|FontFormatException localIOException){
      System.out.println("font failed to load.");
    }
  }
}