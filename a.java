package Mini;
import javax.swing.*;
import java.awt.List.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
//import java.util.stream.Collectors;
 
class oneword {
	private int charterr;//0是用户输入，1是设定的单词，定好了后续不会改
	private int wordnumber;//被猜单词是表中的第几个，从1开始，用户输入的单词默认为0，需要SET GET
	private int timess;//第几次输入，从1开始，是设定的单词默认为9，需要SET GET
	private int bgcolor;//背景色，0灰1黄2绿，是设定的单词默认为9，需要SET GET
	private int seatt;//位置，从1开始，需要SET GET
	private char contentt;//内容，需要GET
 
	public oneword(int charterr, int wordnumber,int timess,int bgcolor,int seatt, char contentt) {
		this.charterr = charterr;
		this.wordnumber = wordnumber;
		this.timess = timess;
		this.bgcolor = bgcolor;
		this.seatt = seatt;
		this.contentt = contentt;
	}
	
	public void setWordnumber(int wordnumber) {
		this.wordnumber=wordnumber;
	}
	public int getWordnumber() {
		return wordnumber;
	}
	
	public void setTimess(int timess) {
		this.timess=timess;
	}
	public int getTimess() {
		return timess;
	}
 
	public void setBgcolor(int bgcolor) {
		this.bgcolor=bgcolor;
	}
	public int getBgcolor() {
		return bgcolor;
	}
	
	public void setSeatt(int seatt) {
		this.seatt=seatt;
	}
	public int getSeatt() {
		return seatt;
	}
	
	public char getContentt() {
		return contentt;
	}
	
	public String toString() {
		return charterr+" "+wordnumber+" "+timess+" "+bgcolor+" "+seatt+" "+contentt;//测试返回值
	}
}
 
 
public class Test {
 
	static int wordnumber=0;//暂时没用
	static int tss=0;//第几次输入
	static ArrayList<oneword> list = new ArrayList<oneword>();
	static ArrayList<oneword> putin = new ArrayList<oneword>();
	
	public static void main(String[] args) {
//      index0();
		index1();//测试一下假如设定好了GAMER
		addwords();
		putin.add(new oneword(0,0,1,1,1,'A'));//由于putin最开始是空的，难以测试
 
		
  }
	
	public static void addwords() {
		list.add(new oneword(1,1,9,9,1,'G'));
        list.add(new oneword(1,1,9,9,2,'A'));
        list.add(new oneword(1,1,9,9,3,'M'));
        list.add(new oneword(1,1,9,9,4,'E'));
        list.add(new oneword(1,1,9,9,5,'R'));
 
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));//测试返回值       	
        	char cc=list.get(i).getContentt();
        	 
//        	System.out.println(cc);//修改进度
        }
	}
	
	
    
    public static void index0() {
 
        JFrame f = new JFrame("Wordle Game"); 
//        f.setLayout(new BorderLayout());//另一种排法，还没解决界面布局
        f.setLayout(new FlowLayout( FlowLayout.CENTER));
    	f.setSize(400,250);
		f.setLocation(400,300);			
    		
		JButton sb = new JButton("Start");
		JButton rb = new JButton("Setting");           
    	f.add(sb, BorderLayout.CENTER);
    	f.add(rb, BorderLayout.WEST);//上面那个想解决，这是尝试1
    	JButton button1 = new JButton("A");   	
    	f.add (button1);    	
    	
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == sb) {//当被猜单词还没设置好就选择开始时
                    System.out.println("You clicked the StartButton");
                    
                    JDialog nochoose = new JDialog(f,"Hint");
                    nochoose.setBounds(450,350,400,100);
                    nochoose.setLayout(new FlowLayout( FlowLayout.CENTER));
                    
                    Box vBox0 = Box.createVerticalBox();
                    vBox0.add(new Label("Have not chosen the word to guess yet."));
                    nochoose.add(vBox0);
                    
                    nochoose.setVisible(true);
                    nochoose.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                } else {//设置好单词后直接跳转到一个和初始界面一样的界面，但这个界面可以点击开始并且有定好的被猜单词
                    System.out.println("Please choosing the word.");
                    JDialog cw = new JDialog(f,"chooseword");
                    cw.setLayout(new FlowLayout( FlowLayout.LEFT));
            		cw.setBounds(450,350,400,200);
            		
                    
            		JButton button1 = new JButton("GAMER");
            		button1.addActionListener(new AbstractAction() {
            			public void actionPerformed(ActionEvent e) {
            				wordnumber=1;//先设一个数字，万一有用
            				System.out.println(wordnumber);
              				index1();
            			}
            		});
            		JButton button2 = new JButton("MUSIC");
            		button2.addActionListener(new AbstractAction() {
            			public void actionPerformed(ActionEvent e) {
            				wordnumber=2;
            				System.out.println(wordnumber);
            			}
            		});     		
            		JButton button3 = new JButton("GLOBE");
            		button3.addActionListener(new AbstractAction() {
            			public void actionPerformed(ActionEvent e) {
            				wordnumber=3;
            				System.out.println(wordnumber);
            			}
            		});
            		cw.add(button1);
            		cw.add(button2);
            		cw.add(button3);
                    
            		
            		cw.setVisible(true);
            		cw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                }
            }
        };
        sb.addActionListener(a);
        rb.addActionListener(a);
        f.getContentPane().add(sb);
        f.getContentPane().add(rb);
//        f.pack();//调整到只放得下按钮的大小
        f.setVisible(true);        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
 
    public static void exec(String str) {//该函数用于把string转成一个字符串数组，并判断是否符合
    	int length=str.length();
    	int judge=1;//判定为1才能输入
    	System.out.print(length);//输入字符的长度
    	System.out.println();
    	if(length!=5) {
    		judge=0;
    	}
    	for (char c : str.toCharArray()) {
    		if(c<'A'||c>'Z') {
    			judge=0;
    		}
//    		System.out.print("'" + c + "',");
    	}
    	if(judge==0) {  		
    		JFrame ff1 = new JFrame(" "); 
      		JDialog nochoose = new JDialog(ff1,"Hint");//没能输入正确的五个大写字母，弹出提示
      		nochoose.setBounds(500,400,400,100);
      		nochoose.setLayout(new FlowLayout( FlowLayout.CENTER));
            Box vBox0 = Box.createVerticalBox();
            vBox0.add(new Label("Failure to enter the correct five capital letters."));
            nochoose.add(vBox0);   
            nochoose.setVisible(true);
            nochoose.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   	
    	
    	}else if(judge==1) {  	
    		tss=tss+1;//输入的次数
    		matching(str,tss);//判断输入内容并给予输入的次数   		
    	}	
    	System.out.println();
    }
    
    public static void matching(String str,int tss) {//后续改成返回int的函数?
    	int ct=0;//ct是输入字母的位置
    
    	
    	for (char c : str.toCharArray()) {//每个字母都matching一遍
    		ct=ct+1;//字母位置从1开始
    		int[] hh= {0,0,0,0,0};//带着位置和内容的c分别与gamer对比，只内容一样就是黄1，内容和位置一样就是绿2，取最大值
    		int ccolor=0;
    		
    		for(int i=0;i<list.size();i++) {//输入的字母与list里的每行的content匹配，但有个问题，list里只有gamer，
  			
            	
            	char cc=list.get(i).getContentt();
            	int cs=list.get(i).getSeatt();
 
        		if(c==cc) {
        			hh[i]=1;
        			if(ct==cs) {
        				hh[i]=2;
        			}    			
        		}       		
        		
            }
    		Arrays.sort(hh);
    		ccolor=hh[4];//color取最大值
    		putin.add(new oneword(0,0,tss,ccolor,ct,c));
    		System.out.print(tss+","+ccolor+","+ct+","+c);//颜色是对的了
    		System.out.println();//先搁置
    		
//    		System.out.print("'" + c + "',");
    	}
    	
 
    }
 
    public static char record(int i) {//后续用来写历史记录的
//    	int a=putin.get(0).getBgcolor();
    	char cs='t';
    	for(int r=0;r<putin.size();r++) {//输入的字母与list里的每行的content匹配，但有个问题，list里只有gamer，
  			
        	
        	
        	cs=putin.get(r).getContentt();
        	System.out.print(cs);
        	System.out.print(" zzy ");
    	}
    	return cs;
 
//    	System.out.print("DQY ");
    }
    
    public static void index1() {//选了GAMER
        JFrame f = new JFrame("Wordle Game"); 
        f.setLayout(new FlowLayout( FlowLayout.CENTER));
        f.setSize(400,250);
		f.setLocation(400,300);			
  		
		JButton sb = new JButton("Start");
		JButton rb = new JButton("Setting");           
		JButton button1 = new JButton("A");   	
		f.add (button1);    	
		
     ActionListener a = new ActionListener() {
    	 
    	 public void actionPerformed(ActionEvent ae) {
    		 
              if (ae.getSource() == sb) {//选了GAMER，开始
            	  
       	  
            	  JDialog play1 = new JDialog(f,"writedown");
            	  play1.setLayout(new FlowLayout( FlowLayout.LEFT));
            	  play1.setBounds(450,350,400,400);
            	  
            	  Box vBox0 = Box.createVerticalBox();
                  vBox0.add(new Label("Write down the 5-letter English word as you guess."));
                  play1.add(vBox0);
                  
            	  	JTextArea area1 = new JTextArea(5,20);   			
          			area1.setLineWrap(true);
          			play1.add(area1);//添加区域
          			JButton button = new JButton("CHECK");
          			play1.add(button);
          			button.addActionListener(new AbstractAction() {
          				public void actionPerformed(ActionEvent e) {
//          				area.append("NNN");
          				System.out.println(wordnumber);
              			String a=area1.getText();
              			System.out.println(a);
              			exec(a);
          				}
          			});
          			
          			
          			
          			
//          			JTextArea area2 = new JTextArea(5,20);  
          			area2.setLayout(new FlowLayout( FlowLayout.CENTER));//这么写没用啊，有什么办法能改变框框的位置吗
//          			area2.setLineWrap(true);
//          			play1.add(area2);//添加区域
          			
          			Box vBox1 = Box.createVerticalBox();
          			for(int i=0;i<5;i++) {
          				
          				if(i==0) {
          					char y=record(i);
          					vBox1.add(new Label("The content of your first attempt is "+y));
          					
          				}else if(i==1) {
          					vBox1.add(new Label("The content of your second attempt is "));
          				}else if(i==2) {
          					vBox1.add(new Label("The content of your third attempt is "));
          				}else if(i==3) {
          					vBox1.add(new Label("The content of your forth attempt is "));
          				}else if(i==4) {
          					vBox1.add(new Label("The content of your fifth attempt is "));
          				}else if(i==5) {
          					vBox1.add(new Label("The content of your final attempt is "));
          				}
          				
 
          				
          				
//          				int a=putin.get(i).getBgcolor();
//          				String ch1=String.valueOf(a);
//          				vBox1.add(new Label(ch1));//进度
//            			System.out.print(putin.get(i).getBgcolor());
          				
          				play1.add(vBox1);
            		}
                    
                    
//                    JTextField textField = new JTextField(15);
//                    play1.add(textField);
//            
          			
                    
                    
                    
          			
//          			for(int i=0;i<5;i++) {
//            			System.out.print(putin.get(i).getBgcolor());
//            		}
 
          			
 
       		
          			play1.setVisible(true);
          			play1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
              } else {//重新设置的话……
                  System.out.println("Please choosing the word.");
                  JDialog cw = new JDialog(f,"chooseword");
                  cw.setLayout(new FlowLayout( FlowLayout.LEFT));
                  cw.setBounds(450,350,400,200);
          		
                  
          		JButton button1 = new JButton("GAMER");
          		button1.addActionListener(new AbstractAction() {
          			public void actionPerformed(ActionEvent e) {
          				index1();
          				wordnumber=1;
          				System.out.println(wordnumber);
          			}
          		});
          		JButton button2 = new JButton("MUSIC");
          		button2.addActionListener(new AbstractAction() {
          			public void actionPerformed(ActionEvent e) {
          				wordnumber=2;
          				System.out.println(wordnumber);
          			}
          		});     		
          		JButton button3 = new JButton("GLOBE");
          		button3.addActionListener(new AbstractAction() {
          			public void actionPerformed(ActionEvent e) {
          				wordnumber=3;
          				System.out.println(wordnumber);
          			}
          		});
          		cw.add(button1);
          		cw.add(button2);
          		cw.add(button3);
                  
          		
          		cw.setVisible(true);
          		cw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
              }
          }
      };
      sb.addActionListener(a);
      rb.addActionListener(a);
      f.getContentPane().add(sb);
      f.getContentPane().add(rb);
//      f.pack();//调整到只放得下按钮的大小
      f.setVisible(true);        
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
}
