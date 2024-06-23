package autoCodeentryscreen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import myUtility.*;
public class CodePanel extends JPanel
{
		//Top Level Panels
		JPanel BottomPanel,UIPanel,TopPanel,TopPanel3,RightPanel,TopPanel2,SloganPanel,CenterPanel,ButtonPanel,LeftPanel,pnlProgramHeading,UIPanelParent;
		//Program Heading Panel components
		JLabel lblProgramHeading,lblLeft,lblRight,lblCenter,lblSlogan;


		//Button Panel Elements
		JPanel pnlFirst,pnlSecond,pnlThird,pnlFourth,pnlFifth,pnlSixth,pnlSeventh;
		JButton btnFirst,btnSecond,btnFourth,btnThird,btnFifth,btnSixth,btnSeventh;

		//Report Panel Elements
		JPanel ReportUI,ReportUIHeading,ReportUIBottom,ReportUIData;
		JLabel lblReportHead;
		JButton btnCloseReport;

		//Top Panel Elements
		JLabel lblHeading,lblTop3;

		//Coomon Border Object
		Border bd;

		int Lw,Lh;
		public CodePanel()
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension s=kit.getScreenSize();

			Lw=s.width-8;
			Lh=s.height;

			bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			setLayout(null);
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

			lblTop3=new JLabel(new ImageIcon("backUI\\back.png"));
			//lblTop3.setBackground(Color.RED);
			//lblTop3.setOpaque(true);
			lblTop3.setBounds(1,1,(Lw/2)-2,43);
			TopPanel3.add(lblTop3);

			add(TopPanel3);

			ButtonPanel=new JPanel();
			ButtonPanel.setLayout(null);
			ButtonPanel.setBackground(new Color(157,249,202));
			ButtonPanel.setBounds(0,225,180,388);



			pnlFirst=new JPanel();
			pnlFirst.setLayout(null);
			pnlFirst.setBounds(4,7,162,36);
			pnlFirst.setBackground(Color.GREEN);
			btnFirst=new JButton(".........");
			btnFirst.setBounds(2,2,158,32);
			pnlFirst.add(btnFirst);
			ButtonPanel.add(pnlFirst);

			pnlSecond=new JPanel();
			pnlSecond.setLayout(null);
			pnlSecond.setBounds(4,48,162,36);
			pnlSecond.setBackground(Color.GREEN);
			btnSecond=new JButton(".........");
			btnSecond.setBounds(2,2,158,32);
			pnlSecond.add(btnSecond);
			ButtonPanel.add(pnlSecond);

			pnlThird=new JPanel();
			pnlThird.setLayout(null);
			pnlThird.setBounds(4,89,162,36);
			pnlThird.setBackground(Color.GREEN);
			btnThird=new JButton(".........");
			btnThird.setBounds(2,2,158,32);
			pnlThird.add(btnThird);
			ButtonPanel.add(pnlThird);

			pnlFourth=new JPanel();
			pnlFourth.setLayout(null);
			pnlFourth.setBounds(4,130,162,36);
			pnlFourth.setBackground(Color.GREEN);
			btnFourth=new JButton(".........");
			btnFourth.setBounds(2,2,158,32);
			pnlFourth.add(btnFourth);
			ButtonPanel.add(pnlFourth);

			pnlFifth=new JPanel();
			pnlFifth.setLayout(null);
			pnlFifth.setBounds(4,171,162,36);
			pnlFifth.setBackground(Color.GREEN);
			btnFifth=new JButton(".........");
			btnFifth.setBounds(2,2,158,32);
			pnlFifth.add(btnFifth);
			ButtonPanel.add(pnlFifth);

			pnlSixth=new JPanel();
			pnlSixth.setLayout(null);
			pnlSixth.setBounds(4,212,162,36);
			pnlSixth.setBackground(Color.GREEN);
			btnSixth=new JButton(".........");
			btnSixth.setBounds(2,2,158,32);
			pnlSixth.add(btnSixth);
			ButtonPanel.add(pnlSixth);

			pnlSeventh=new JPanel();
			pnlSeventh.setLayout(null);
			pnlSeventh.setBounds(4,252,162,36);
			pnlSeventh.setBackground(Color.GREEN);
			btnSeventh=new JButton(".........");
			btnSeventh.setBounds(2,2,158,32);
			pnlSeventh.add(btnSeventh);
			ButtonPanel.add(pnlSeventh);

			add(ButtonPanel);

			LeftPanel=new JPanel();
			LeftPanel.setLayout(null);
			//LeftPanel.setBackground(Color.BLACK);
			LeftPanel.setBounds(0,61,90,110);

			lblLeft=new JLabel(new ImageIcon("backUI\\Logo.png"));
			lblLeft.setBounds(2,2,86,106);
			LeftPanel.add(lblLeft);

			add(LeftPanel);

			RightPanel=new JPanel();
			RightPanel.setLayout(null);
			//RightPanel.setBackground(Color.BLACK);
			RightPanel.setBounds(Lw-92,61,90,110);

			lblRight=new JLabel(new ImageIcon("backUI\\Logo.png"));
			lblRight.setBounds(2,2,86,106);
			RightPanel.add(lblRight);

			add(RightPanel);

			CenterPanel=new JPanel();
			CenterPanel.setLayout(null);
			//CenterPanel.setBackground(Color.BLACK);
			CenterPanel.setBounds(92,61,Lw-186,110);

			lblCenter=new JLabel(new ImageIcon("backUI\\back1.jpg"));
			lblCenter.setBounds(2,2,Lw-190,106);
			CenterPanel.add(lblCenter);

			add(CenterPanel);






			BottomPanel=new JPanel();
			BottomPanel.setLayout(new FlowLayout());
			BottomPanel.setBackground(new Color(176,194,73));
			BottomPanel.setBounds(0,Lh-80,Lw,50);
			add(BottomPanel);

			SloganPanel=new JPanel();
			SloganPanel.setLayout(new FlowLayout());
			SloganPanel.setBackground(new Color(157,249,202));
			SloganPanel.setBounds(0,615,326,71);

			lblSlogan=new JLabel(new ImageIcon("backUI\\slogan.jpg"));
			lblSlogan.setBounds(1,1,324,68);
			SloganPanel.add(lblSlogan);

			add(SloganPanel);

			UIPanelParent=new JPanel();
			UIPanelParent.setLayout(null);
			UIPanelParent.setBackground(new Color(227,208,119));
			UIPanelParent.setBounds(329,173,687,512);
			//UIPanelParent.setBounds(327,173,Lw-326,514);//(Lh-82)-173));
			add(UIPanelParent);

			UIPanel=new JPanel();
			UIPanel.setLayout(null);
			UIPanel.setBackground(Color.CYAN);//new Color(239,228,176));
			UIPanel.setBounds(5,5,677,502);//(Lh-82)-173));
			UIPanelParent.add(UIPanel);

			pnlProgramHeading=new JPanel();
			pnlProgramHeading.setLayout(new FlowLayout());
			pnlProgramHeading.setBackground(new Color(213,173,38));
			pnlProgramHeading.setBounds(0,173,328,50);
			add(pnlProgramHeading);

			lblProgramHeading=new JLabel("Program Heading");
			pnlProgramHeading.add(lblProgramHeading);


			ReportUI=new JPanel();
			ReportUI.setLayout(null);
			ReportUI.setBackground(new Color(116,10,105));
			ReportUI.setBounds(329,173,687,512);//(0,0,Lw-326,514);
			add(ReportUI);

			ReportUIHeading=new JPanel();
			ReportUIHeading.setLayout(null);
			ReportUIHeading.setBackground(new Color(251,198,87));
			ReportUIHeading.setBounds(5,5,680,30);

			ReportUI.add(ReportUIHeading);
			lblReportHead=new JLabel("Report Heading",JLabel.CENTER);
			lblReportHead.setBounds(200,5,300,20);
			ReportUIHeading.add(lblReportHead);

			ReportUIBottom=new JPanel();
			ReportUIBottom.setLayout(null);
			ReportUIBottom.setBackground(new Color(251,198,87));
			ReportUIBottom.setBounds(5,479,680,30);
			ReportUI.add(ReportUIBottom);

			btnCloseReport=new JButton("Close Report");
			btnCloseReport.setBounds(190,5,300,20);
			ReportUIBottom.add(btnCloseReport);

			ReportUIData=new JPanel();
			ReportUIData.setLayout(null);
			ReportUIData.setBackground(new Color(255,255,196));
			ReportUIData.setBounds(30,35,630,444);
			ReportUI.add(ReportUIData);

			setSize(Lw,Lh);

			setVisible(true);

			ReportUI.setBorder(bd);
			ReportUIHeading.setBorder(bd);
			ReportUIBottom.setBorder(bd);
			ReportUIData.setBorder(bd);
			TopPanel.setBorder(bd);
			ButtonPanel.setBorder(bd);
			pnlFirst.setBorder(bd);
			pnlSecond.setBorder(bd);
			pnlThird.setBorder(bd);
			pnlFourth.setBorder(bd);
			pnlFifth.setBorder(bd);
			pnlSixth.setBorder(bd);
			pnlSeventh.setBorder(bd);
			BottomPanel.setBorder(bd);
			UIPanel.setBorder(bd);
			pnlProgramHeading.setBorder(bd);

			defaultSetting();
		}
		void defaultSetting()
		{

			PanelState.hideComponents(getReportUI());
			PanelState.hideComponents(getUIPanel());
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
		//UI Buttons Components
		public JButton getFirstButton()
		{
			return(btnFirst);
		}
		public JButton getSecondButton()
		{
			return(btnSecond);
		}
		public JButton getThirdButton()
		{
			return(btnFifth);
		}
		public JButton getFourthButton()
		{
			return(btnThird);
		}
		public JButton getFifthButton()
		{
			return(btnFourth);
		}
		public JButton getSixthButton()
		{
			return(btnSixth);
		}
		public JButton getSeventhButton()
		{
			return(btnSeventh);
		}


		public JPanel getReportUIData()
		{
			return(ReportUIData);
		}
		//UI Buttons Panels
		public JPanel getFirstPanel()
		{
			return(pnlFirst);
		}
		public JPanel getViewPanel()
		{
			return(pnlSecond);
		}
		public JPanel getEditPanel()
		{
			return(pnlThird);
		}
		public JPanel getSavePanel()
		{
			return(pnlFifth);
		}
		public JPanel getDeletePanel()
		{
			return(pnlFourth);
		}
		public JPanel getReportPanel()
		{
			return(pnlSixth);
		}
		public JPanel getReportButtonPanel()
		{
			return(pnlSixth);
		}
		public JPanel getCancelPanel()
		{
			return(pnlSeventh);
		}


		//Get Display UI Panels
		public JPanel getReportUI()
		{
			return(ReportUI);
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

		public JPanel getUIPanelParent()
		{
			return(UIPanelParent);
		}
}
