//Latest Updated On 6 March 2018
package entryscreen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class ProjectPanelOne extends JPanel
{
		//Top Level Panels
		JPanel BottomPanel,UIPanel,SubUIPanel1,TopPanel,TopPanel3,RightPanel,TopPanel2,
		CenterPanel,LeftPanel,pnlProgramHeading,UIPanelParent;
		//Program Heading Panel components
		JLabel lblProgramHeading,lblLeft,lblRight,lblCenter,lblSlogan;


		//Top Panel Elements
		JLabel lblHeading,lblTop3;

		//Coomon Border Object
		Border bd;

		JPanel SidePanel;
		JLabel lblSideLabel;

		int Lw,Lh;
		public ProjectPanelOne()
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension s=kit.getScreenSize();

			Lw=s.width-8;
			Lh=s.height;

			bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			setLayout(null);


			SidePanel =new JPanel();
			SidePanel.setLayout(null);
			SidePanel.setBackground(new Color(160,154,146));
			SidePanel.setBounds(5,173,325,512);


			lblSideLabel=new JLabel(new ImageIcon("BackUI\\Images\\back5.png"));
			lblSideLabel.setBounds(5,5,315,502);
			SidePanel.add(lblSideLabel);

			add(SidePanel);

			TopPanel=new JPanel();
			TopPanel.setLayout(new FlowLayout());
			TopPanel.setBackground(new Color(9,147,81));
			TopPanel.setBounds(0,0,Lw/2,60);

			lblHeading=new JLabel("<html><h1>Java Code Generator</h1></html>");
			lblHeading.setForeground(Color.white);
			lblHeading.setBackground(Color.yellow);
			TopPanel.add(lblHeading);

			add(TopPanel);

			TopPanel2=new JPanel();
			TopPanel2.setLayout(new FlowLayout());
			TopPanel2.setBackground(new Color(152,169,56));
			TopPanel2.setBounds(Lw/2,45,Lw/2,15);

			add(TopPanel2);

			TopPanel3=new JPanel();
			TopPanel3.setLayout(null);
			TopPanel3.setBackground(new Color(176,194,73));
			TopPanel3.setBounds(Lw/2,0,Lw/2,45);

			lblTop3=new JLabel(new ImageIcon("BackUI\\Images\\back.png"));
			//lblTop3.setBackground(Color.RED);
			//lblTop3.setOpaque(true);
			lblTop3.setBounds(1,1,(Lw/2)-2,43);
			TopPanel3.add(lblTop3);

			add(TopPanel3);


			LeftPanel=new JPanel();
			LeftPanel.setLayout(null);
			//LeftPanel.setBackground(Color.BLACK);
			LeftPanel.setBounds(0,61,90,110);

			lblLeft=new JLabel(new ImageIcon("BackUI\\Images\\Logo.png"));
			lblLeft.setBounds(2,2,86,106);
			LeftPanel.add(lblLeft);

			add(LeftPanel);

			RightPanel=new JPanel();
			RightPanel.setLayout(null);
			//RightPanel.setBackground(Color.BLACK);
			RightPanel.setBounds(Lw-92,61,90,110);

			lblRight=new JLabel(new ImageIcon("BackUI\\Images\\Logo.png"));
			lblRight.setBounds(2,2,86,106);
			RightPanel.add(lblRight);

			add(RightPanel);

			CenterPanel=new JPanel();
			CenterPanel.setLayout(null);
			//CenterPanel.setBackground(Color.BLACK);
			CenterPanel.setBounds(92,61,Lw-186,110);

			lblCenter=new JLabel(new ImageIcon("BackUI\\Images\\back2.jpg"));
			lblCenter.setBounds(2,2,Lw-190,106);
			CenterPanel.add(lblCenter);

			add(CenterPanel);




			BottomPanel=new JPanel();
			BottomPanel.setLayout(new FlowLayout());
			BottomPanel.setBackground(new Color(176,194,73));
			BottomPanel.setBounds(0,Lh-80,Lw,50);
			add(BottomPanel);



			UIPanelParent=new JPanel();
			UIPanelParent.setLayout(null);
			UIPanelParent.setBackground(new Color(227,208,119));
			UIPanelParent.setBounds(330,223,1019,462);
			//UIPanelParent.setBounds(327,173,Lw-326,514);//(Lh-82)-173));
			add(UIPanelParent);

			UIPanel=new JPanel();
			UIPanel.setLayout(null);
			UIPanel.setBackground(Color.CYAN);//new Color(239,228,176));
			UIPanel.setBounds(0,0,687,50);//(Lh-82)-173));
			//UIPanelParent.add(UIPanel);

			SubUIPanel1=new JPanel();
			SubUIPanel1.setLayout(null);
			SubUIPanel1.setBackground(Color.GREEN);//new Color(239,228,176));
			SubUIPanel1.setBounds(0,52,1000,400);//(Lh-82)-173));
			UIPanelParent.add(SubUIPanel1);

/*			SubUIPanel2=new JPanel();
			SubUIPanel2.setLayout(null);
			SubUIPanel2.setBackground(Color.GREEN);//new Color(239,228,176));
			SubUIPanel2.setBounds(0,52,687,50);//(Lh-82)-173));
			UIPanelParent.add(SubUIPanel2);
*/
			pnlProgramHeading=new JPanel();
			pnlProgramHeading.setLayout(new FlowLayout());
			pnlProgramHeading.setBackground(new Color(213,173,38));
			pnlProgramHeading.setBounds(330,173,1019,50);
			add(pnlProgramHeading);

			lblProgramHeading=new JLabel("Program Heading");
			pnlProgramHeading.add(lblProgramHeading);






			setSize(Lw,Lh);

			setVisible(true);


			TopPanel.setBorder(bd);

			BottomPanel.setBorder(bd);
			UIPanel.setBorder(bd);
			SubUIPanel1.setBorder(bd);
//			SubUIPanel2.setBorder(bd);
			pnlProgramHeading.setBorder(bd);


			defaultSetting();
		}
		void defaultSetting()
		{

			//PanelState.disableComponents(getSubUIPanel1());
//			PanelState.disableComponents(getSubUIPanel2());
		}


		public void UIAreaSetting(int rw,int rh)
		{
				int px=329;
				int py=173;
				int pw=687;

				int ph=512;
				if(rw>pw)
				rw=pw;
				if(rh>ph)
				rh=ph;
				int x=((pw-rw)/2);
				int y=((ph-rh)/2);

				UIPanel.setBounds(x,y,rw,rh);
		}

		public JPanel getProgramHeadingPanel()
		{
			return(pnlProgramHeading);
		}
		public JLabel getProgramHeadingLabel()

		{
			return(lblProgramHeading);
		}
		//Get Combo UI Panels
		public JPanel getUIPanel()
		{
			return(UIPanel);
		}
		public JPanel getSubUIPanel1()
		{
			return(SubUIPanel1);
		}

/*		public JPanel getSubUIPanel2()
		{
			return(SubUIPanel2);
		}
*/
		public JPanel getUIPanelParent()
		{
			return(UIPanelParent);
		}
}
class PanelState
{
	static void showComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(true);
		}
	}
	static void hideComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(false);
		}
	}
	static void visibleComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
  		  c.setVisible(true);
		}
		temp.setVisible(true);
	}
	static void disableComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
    		 c.setVisible(false);
		}
		temp.setVisible(false);
	}
}
