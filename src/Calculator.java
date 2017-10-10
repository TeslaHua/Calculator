/**
功能描述：java制作简易计算器，可区分运算符优先级，进行四则运算
日期：2016/1/22
*/
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

import java.util.*;
import java.lang.Exception.*;
import java.lang.StringBuilder;
 
class Calculator extends JFrame
{
	private JPanel panel = new JPanel(new GridLayout(6,4,2,1));
	private JButton jbt0 = new JButton("0");
	private JButton jbt1 = new JButton("1");
	private JButton jbt2 = new JButton("2");
	private JButton jbt3 = new JButton("3");
	private JButton jbt4 = new JButton("4");
	private JButton jbt5 = new JButton("5");
	private JButton jbt6 = new JButton("6");
	private JButton jbt7 = new JButton("7");
	private JButton jbt8 = new JButton("8");
	private JButton jbt9 = new JButton("9");
	private JButton jbtequ = new JButton("=");
	private JButton jbtadd = new JButton("+");
	private JButton jbtsub = new JButton("-");
	private JButton jbtmul = new JButton("*");
	private JButton jbtdiv = new JButton("/");
	private JButton jbtdec = new JButton(".");
	private JButton jbtlbra = new JButton("(");
	private JButton jbtrbra = new JButton(")");
	private JButton jbtsin = new JButton("sin");
	private JButton jbtcos = new JButton("cos");
	private JButton jbttan = new JButton("tan");
	private JButton jbtsqrt = new JButton("sqrt");
	private JButton jbtclear = new JButton("CE");
	private JButton jbtback = new JButton("←");
	private JTextArea input = new JTextArea(2,21);
	private JTextArea show = new JTextArea("结果:\n",2,21);
	private ArrayList<Integer> array1 = new ArrayList<Integer>();
	private int numberOfLbracked =0;
	private int numberOfRbracked =0;
	private int numberOfoperator=0;

	private String result="";

	private ArrayList<Integer> arrayinput = new ArrayList<Integer>(); 

	public Calculator()
	{
		jbt0.setBackground(new Color(100,100,200));
		jbt0.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt1.setBackground(new Color(100,100,200));
		jbt1.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt2.setBackground(new Color(100,100,200));
		jbt2.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt3.setBackground(new Color(100,100,200));
		jbt3.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt4.setBackground(new Color(100,100,200));
		jbt4.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt5.setBackground(new Color(100,100,200));
		jbt5.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt6.setBackground(new Color(100,100,200));
		jbt6.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt7.setBackground(new Color(100,100,200));
		jbt7.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt8.setBackground(new Color(100,100,200));
		jbt8.setFont(new Font("SanSerif",Font.BOLD,16));

		jbt9.setBackground(new Color(100,100,200));
		jbt9.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtequ.setBackground(new Color(100,100,200));
		jbtequ.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtadd.setBackground(new Color(100,100,200));
		jbtadd.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtsub.setBackground(new Color(100,100,200));
		jbtsub.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtmul.setBackground(new Color(100,100,200));
		jbtmul.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtdiv.setBackground(new Color(100,100,200));
		jbtdiv.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtdec.setBackground(new Color(100,100,200));
		jbtdec.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtlbra.setBackground(new Color(100,100,200));
		jbtlbra.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtrbra.setBackground(new Color(100,100,200));
		jbtrbra.setFont(new Font("SanSerif",Font.BOLD,16));

		jbtsin.setBackground(new Color(100,100,100));
		jbtsin.setFont(new Font("Serif",Font.BOLD,16));

		jbtcos.setBackground(new Color(100,100,100));
		jbtcos.setFont(new Font("Serif",Font.BOLD,16));

		jbttan.setBackground(new Color(100,100,100));
		jbttan.setFont(new Font("Serif",Font.BOLD,16));

		jbtsqrt.setBackground(new Color(100,100,100));
		jbtsqrt.setFont(new Font("Serif",Font.BOLD,16));

		jbtclear.setBackground(new Color(200,100,100));
		jbtclear.setFont(new Font("Serif",Font.BOLD,16));
		jbtclear.setToolTipText("Clear input box");

		jbtback.setBackground(new Color(200,100,100));
		jbtback.setFont(new Font("Serif",Font.BOLD,16));
		jbtback.setToolTipText("Take a step back");

		input.setBackground(new Color(200,200,200));
		input.setFont(new Font("Serif",Font.BOLD,20));
		input.setBorder(new LineBorder(Color.GREEN,2));
		input.setBorder(new TitledBorder("Input Box"));

		show.setBackground(new Color(200,200,200));
		show.setFont(new Font("Serif",Font.	BOLD,20));
		show.setBorder(new LineBorder(Color.GREEN,2));
		show.setBorder(new TitledBorder("Show Box"));


		panel.add(jbt0);panel.add(jbt1);panel.add(jbt2);
		panel.add(jbt3);panel.add(jbt4);panel.add(jbt5);
		panel.add(jbt6);panel.add(jbt7);panel.add(jbt8);
		panel.add(jbt9);panel.add(jbtadd);panel.add(jbtsub);
		panel.add(jbtmul);panel.add(jbtdiv);panel.add(jbtdec);
		panel.add(jbtequ);panel.add(jbtsin);panel.add(jbtcos);
		panel.add(jbttan);panel.add(jbtlbra);panel.add(jbtrbra);
		panel.add(jbtsqrt);panel.add(jbtclear);panel.add(jbtback);
		panel.setBorder(new TitledBorder("Some Button"));

		setLayout(new BorderLayout(1,1));
		add(panel,BorderLayout.SOUTH);
		add(input,BorderLayout.NORTH);
		add(show,BorderLayout.CENTER);
	}

	public void setevent()
	{
		jbt0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"0");
            }
        });
		jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"1");
            }
        });
		jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"2");
            }
        });
		jbt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"3");
            }
        });
		jbt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"4");
            }
        });
		jbt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"5");
            }
        });
		jbt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"6");
            }
        });
		jbt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"7");
            }
        });
		jbt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"8");
            }
        });
		jbt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText(input.getText()+"9");
            }
        });

		jbtdec.addActionListener(new ActionListener() {                //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
					input.setText(input.getText()+".");
            }
        });

		jbtdiv.addActionListener(new ActionListener() {                //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					arrayinput.add(input.getText().length());
					input.setText(input.getText()+"/");
					numberOfoperator++;
				}
            }
        });
		jbtadd.addActionListener(new ActionListener() {               //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					arrayinput.add(input.getText().length());
					input.setText(input.getText()+"+");
					numberOfoperator++;
				}
            }
        });
		jbtsub.addActionListener(new ActionListener() {              //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					arrayinput.add(input.getText().length());
					input.setText(input.getText()+"-");
					numberOfoperator++;
				}
            }
        });
		jbtmul.addActionListener(new ActionListener() {             //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					arrayinput.add(input.getText().length());
					input.setText(input.getText()+"*");
					numberOfoperator++;
				}
            }
        });
		jbtlbra.addActionListener(new ActionListener() {             //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				input.setText(input.getText()+"(");
				numberOfLbracked++;
            }
        });
		jbtrbra.addActionListener(new ActionListener() {             //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				input.setText(input.getText()+")");
				numberOfRbracked++;
            }
        });
		jbtsin.addActionListener(new ActionListener() {             //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					double res;
					res = Double.parseDouble(input.getText());
					result =String.valueOf(Math.sin(res));
					show.setText("结果: "+result);
					input.setText("");
				}
            }
        });
		jbtcos.addActionListener(new ActionListener() {            //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					double res;
					res = Double.parseDouble(input.getText());
					result =String.valueOf(Math.cos(res));
					show.setText("结果: "+result);
					input.setText("");                            //自动清空输入框
				}
            }
        });
		jbttan.addActionListener(new ActionListener() {           //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					double res;
					res = Double.parseDouble(input.getText());
					result =String.valueOf(Math.cos(res));
					show.setText("结果: "+result);          //得到的都是弧度单位
					input.setText("");
				}
            }
        });
		jbtsqrt.addActionListener(new ActionListener() {          //用户第一次输入的是非数字
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"你输入的字符不合法!");
				else
				{
					double res;
					res = Double.parseDouble(input.getText());
					result =String.valueOf(Math.sqrt(res));
					show.setText("结果: "+result);
					input.setText("");
				}
            }
        });
		jbtequ.addActionListener(new ActionListener() {     //当要计算结果时
            @Override
            public void actionPerformed(ActionEvent e) {
				input.setText(Transformation(arrayinput,input.getText()));
				System.out.println(input.getText());

				int index=0,i=0;
				double doublevalue1=0;   
				double doublevalue2=0;
				char ch='+';            //第一次用doublevalue1+0
				while(i<=numberOfoperator)
				{
					if(i==numberOfoperator)
					{
						doublevalue1 = Double.parseDouble(input.getText().substring(index,input.getText().length()));  //返回两个运算符之间的字符串并将其转换为double型
						doublevalue2 = operation(doublevalue1,ch,doublevalue2);                   //doublevalue2即是上一次运算的结果
						break;
					}
					else
					{
						doublevalue1 = Double.parseDouble(input.getText().substring(index,arrayinput.get(i)));
					}
					doublevalue2 = operation(doublevalue1,ch,doublevalue2);
					ch = input.getText().charAt(arrayinput.get(i));     //返回运算符
					index=arrayinput.get(i)+1;
					i++;
				}
				show.setText("结果: "+String.valueOf(doublevalue2));   //把结果拿去显示
				input.setText("");                                     //并清空输入框
				arrayinput.clear();                                    //线性表清空
				numberOfoperator=0;                                    //运算符的出现次数清零，以便重新计算
				
            }
        });

		jbtback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				if(input.getText().isEmpty())    //如果后退置文本框内没有内容
				{
					arrayinput.clear();    //清空线性表    
					return ;
				}
				input.setText(input.getText().substring(0,input.getText().length()-1));  //文本框内的内容减一
				String in = input.getText();
				if(in.endsWith("*")||in.endsWith("+")||in.endsWith("-")||in.endsWith("/"))  //如果文本框是以运算符结尾的
				{
					arrayinput.remove(arrayinput.size()-1);   //线性表的内容删除末尾元素
					numberOfoperator--;                       //运算符出现的次数减一
				}
				
            }
        });
		jbtclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				input.setText("");                 //并清空输入框
				arrayinput.clear();                //清空存储长度的线性表
				numberOfoperator=0;                //运算符的出现次数清零
            }
        });
	}

	public double operation(double value1,char ch,double value2)   //处理加减乘除运算
	{
		switch (ch)
		{
		case '+': return value1+value2;
		case '-': return value2-value1;
		case '*': return value1*value2;
		case '/': return value2/value1;
		default: return 0.000;
		}
	}

	public String Transformation(ArrayList<Integer> arrayinput, String string)   //运算符优先级的优先计算算法
	{
		StringBuilder string1 = new StringBuilder(string);   //因为StringBuilder的实例可以进行修改
		
		double temp=0;
		double doublevalue1=0;
		double doublevalue2=0;
		char ch;
		int number=0;
		array1 = (ArrayList<Integer>)arrayinput.clone();  //克隆一个存储长度的线性表
		for(int i=0;i<arrayinput.size();i++)
		{
			if((string1.charAt(arrayinput.get(i))=='*'||string1.charAt(arrayinput.get(i))=='/')&&i!=0)  //i!=0表示防止用户第一个运算符就是*、/号。
			{
				numberOfoperator--;
				if(i==arrayinput.size()-1)
				{
					doublevalue1=Double.parseDouble(string1.substring(arrayinput.get(i-1)+1,arrayinput.get(i)));
					//System.out.println(arrayinput.get(i)+1);
					//System.out.println(input.getText().length());
					//System.out.println(string1);
					doublevalue2=Double.parseDouble(string1.substring(arrayinput.get(i)+1,string1.length()));
					ch = string1.charAt(arrayinput.get(i));
					temp = operation(doublevalue2,ch,doublevalue1);  //优先计算

					string1.replace(arrayinput.get(i-1)+1,string1.length(),String.valueOf(temp));  //文本替换
					
					number =arrayinput.size();
					for(int j=i;j<number;j++)  //将原来线性表的元素清除
						arrayinput.remove(i);
				}
				else
				{
					doublevalue1=Double.parseDouble(string1.substring(arrayinput.get(i-1)+1,arrayinput.get(i)));
					doublevalue2=Double.parseDouble(string1.substring(arrayinput.get(i)+1,arrayinput.get(i+1)));
					ch = string1.charAt(arrayinput.get(i));
					temp = operation(doublevalue2,ch,doublevalue1);
					string1.replace(arrayinput.get(i-1)+1,arrayinput.get(i+1),String.valueOf(temp));

					number =arrayinput.size();

					for(int j=i;j<number;j++)       //  5+6/3+2+9/3   5+2+2+9/3   5+2+2+3
						arrayinput.remove(i);
					int tempi=i;
					for(;tempi<numberOfoperator;tempi++)  //开始填入新的长度
					{
						if(tempi==i)
							arrayinput.add(tempi,arrayinput.get(tempi-1)+1+String.valueOf(temp).length());
						else
							arrayinput.add(tempi,arrayinput.get(tempi-1)+array1.get(tempi+1)-array1.get(tempi));
					}
				}
			}
		}
		return string1.toString();

	}

	public static void main(String[] args)
	{
			Calculator calculator = new Calculator();
			calculator.setSize(330,430);
			calculator.setTitle("计算器");
			calculator.setLocationRelativeTo(null);
			calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //指定框架关闭时的操作
			calculator.setevent();               //调用处理事件的函数
			calculator.setVisible(true);
	}
}
