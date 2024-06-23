package AutoCodeentryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;


public class MenuScreen extends JPanel
{

	JPanel pnlLogo;
	JPanel pnlProjectHeading;
	JPanel pnlProgramHeading;
	JPanel pnlImage;
	JPanel pnlSelect;
	JPanel pnlEntry;
	JPanel pnlBottom;
	JPanel pnlImageSubPanel1;
	JPanel pnlImageSubPanel2;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlButton;
	JPanel pnlMenuOption1;








	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;




	JPanel pnlMenu1;
	JButton btnMenu1;
	JPanel pnlMenu2;
	JButton btnMenu2;
	JPanel pnlMenu3;
	JButton btnMenu3;
	JPanel pnlMenu4;
	JButton btnMenu4;
	JPanel pnlMenu5;
	JButton btnMenu5;
	JPanel pnlMenu6;
	JButton btnMenu6;
	JPanel pnlMenu7;
	JButton btnMenu7;
	JPanel pnlMenu8;
	JButton btnMenu8;

	JPanel pnlSubMenu1;
	JButton btnSubMenu1;
	JPanel pnlSubMenu2;
	JButton btnSubMenu2;
	JPanel pnlSubMenu3;
	JButton btnSubMenu3;
	JPanel pnlSubMenu4;
	JButton btnSubMenu4;
	JPanel pnlSubMenu5;
	JButton btnSubMenu5;
	JPanel pnlSubMenu6;
	JButton btnSubMenu6;
	JPanel pnlSubMenu7;
	JButton btnSubMenu7;
	JPanel pnlSubMenu8;
	JButton btnSubMenu8;
	JPanel pnlSubMenu9;
	JButton btnSubMenu9;
	JPanel pnlSubMenu10;
	JButton btnSubMenu10;
	JPanel pnlSubMenu11;
	JButton btnSubMenu11;








	public MenuScreen()
	{


		Color borderColor=Color.black;
		Border borderLineBorder = BorderFactory.createLineBorder(borderColor);
		Border Border1 = BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#483D8B"));

		Color clrpnlLogo = Color.decode("#FF6347");
		Color clrpnlProjectHeading = Color.decode("#99CCFF");
		Color clrpnlProgramtHeading = Color.decode("#FFD700");
		Color clrpnlImage = Color.blue;///Color.decode("#800000");
		Color clrpnlSelect = Color.decode("#F4A460");
		Color clrpnlEntry = Color.decode("#CD5C5C");
		Color clrpnlButton = Color.pink;//Color.decode("#FFA07A");
		Color clrpnlCombo1 = Color.white;//Color.decode("#D2691E");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width,screenSize.height);
		setLocation(0,0);
		setLayout(null);

		CreatePanel CP = new CreatePanel(screenSize.width,screenSize.height);
		CP.setGap(5,5);


		setBackground(Color.decode("#800000"));

		CP.setXToLeftOf(this);
		CP.setYToTopOf(this);
		CP.setWidthPercentage(17);
		CP.setHeightPercentage(15);
		pnlLogo = CP.createPanel();

		pnlLogo.setBackground(clrpnlLogo);
		pnlLogo.setLayout(new GridLayout(1,1));
		add(pnlLogo);


		CP.setXToLeftOf(this);
		CP.setPanelToBottom(11);
		CP.setWidthTillEnd(this);

		pnlBottom = CP.createPanel();

		pnlBottom.setBackground(clrpnlButton);
		pnlBottom.setLayout(null);
		add(pnlBottom);

		CP.setXToRightOf(pnlLogo);
		CP.setYToTopOf(this);
		CP.setWidthTillEndFrom(pnlLogo);
		CP.setHeightPercentage(5);
		pnlProjectHeading = CP.createPanel();

		pnlProjectHeading.setBackground(clrpnlProjectHeading);
		pnlProjectHeading.setLayout(new GridLayout(1,1));
		add(pnlProjectHeading);


		CP.setPanelToRight(26);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setHeightBetween(pnlProjectHeading,pnlBottom);//setHeightPercentage(80);
		pnlImage = CP.createPanel();

		pnlImage.setBackground(clrpnlImage);
		pnlImage.setLayout(new GridLayout(2,1));
		add(pnlImage);


		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightPercentage(5);
		pnlProgramHeading = CP.createPanel();

		pnlProgramHeading.setBackground(clrpnlProgramtHeading);
		pnlProgramHeading.setLayout(new GridLayout(1,1));
		add(pnlProgramHeading);



		CP.setXToLeftOf(this);;
		CP.setYBelowOf(pnlLogo);
		CP.setWidthPercentage(17);
		CP.setHeightBetween(pnlLogo,pnlBottom);//setHeightPercentage(70);
		pnlSelect = CP.createPanel();

		pnlSelect.setBackground(clrpnlSelect);
		pnlSelect.setLayout(null);
		add(pnlSelect);


		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProgramHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightBetween(pnlProgramHeading,pnlBottom);//setHeightPercentage(74);
		pnlEntry = CP.createPanel();

		pnlEntry.setBackground(clrpnlEntry);
		pnlEntry.setLayout(null);
		add(pnlEntry);

		CP.addPanelAtTop(pnlSelect,8);
		pnlMenu1=CP.addPanel();
		pnlSelect.add(pnlMenu1);
		pnlMenu1.setLayout(new GridLayout(1,1));
		pnlMenu1.setBackground(clrpnlCombo1);

		btnMenu1 = new JButton(" MenuCaptionNo1 ");
		pnlMenu1.add(btnMenu1);


		CP.addPanelAfterFromTop(pnlSelect,pnlMenu1,8);
		pnlMenu2=CP.addPanel();
		pnlSelect.add(pnlMenu2);
		pnlMenu2.setLayout(new GridLayout(1,1));
		pnlMenu2.setBackground(clrpnlCombo1);

		btnMenu2 = new JButton(" MenuCaptionNo2 ");
		pnlMenu2.add(btnMenu2);


		CP.addPanelAfterFromTop(pnlSelect,pnlMenu2,8);
		pnlMenu3=CP.addPanel();
		pnlSelect.add(pnlMenu3);
		pnlMenu3.setLayout(new GridLayout(1,1));
		pnlMenu3.setBackground(clrpnlCombo1);

		btnMenu3 = new JButton(" MenuCaptionNo3 ");
		pnlMenu3.add(btnMenu3);

		CP.addPanelAfterFromTop(pnlSelect,pnlMenu3,8);
		pnlMenu4=CP.addPanel();
		pnlSelect.add(pnlMenu4);
		pnlMenu4.setLayout(new GridLayout(1,1));
		pnlMenu4.setBackground(clrpnlCombo1);

		btnMenu4 = new JButton(" MenuCaptionNo4 ");
		pnlMenu4.add(btnMenu4);

		CP.addPanelAfterFromTop(pnlSelect,pnlMenu4,8);
		pnlMenu5=CP.addPanel();
		pnlSelect.add(pnlMenu5);
		pnlMenu5.setLayout(new GridLayout(1,1));
		pnlMenu5.setBackground(clrpnlCombo1);

		btnMenu5 = new JButton(" MenuCaptionNo5 ");
		pnlMenu5.add(btnMenu5);

		CP.addPanelAfterFromTop(pnlSelect,pnlMenu5,8);
		pnlMenu6=CP.addPanel();
		pnlSelect.add(pnlMenu6);
		pnlMenu6.setLayout(new GridLayout(1,1));
		pnlMenu6.setBackground(clrpnlCombo1);

		btnMenu6 = new JButton(" MenuCaptionNo6 ");
		pnlMenu6.add(btnMenu6);

		CP.addPanelAfterFromTop(pnlSelect,pnlMenu6,8);
		pnlMenu7=CP.addPanel();
		pnlSelect.add(pnlMenu7);
		pnlMenu7.setLayout(new GridLayout(1,1));
		pnlMenu7.setBackground(clrpnlCombo1);

		btnMenu7 = new JButton(" MenuCaptionNo7 ");
		pnlMenu7.add(btnMenu7);

		CP.addPanelAfterFromTop(pnlSelect,pnlMenu7,8);
		pnlMenu8=CP.addPanel();
		pnlSelect.add(pnlMenu8);
		pnlMenu8.setLayout(new GridLayout(1,1));
		pnlMenu8.setBackground(clrpnlCombo1);

		btnMenu8 = new JButton(" MenuCaptionNo8 ");
		pnlMenu8.add(btnMenu8);





		/*CP.addPanelAtBottom(pnlSelect,6);
		pnlApply=CP.addPanel();
		pnlSelect.add(pnlApply);
		pnlApply.setLayout(new GridLayout(1,1));
		pnlApply.setBackground(clrpnlCombo1);*/

		CP.addPanelAtTop(pnlImage,49);
		pnlImageSubPanel1=CP.addPanel();
		pnlImage.add(pnlImageSubPanel1);
		pnlImageSubPanel1.setLayout(new GridLayout(1,1));
		pnlImageSubPanel1.setBackground(Color.BLACK);

		CP.addPanelAtBottom(pnlImage,49);
		pnlImageSubPanel2=CP.addPanel();
		pnlImage.add(pnlImageSubPanel2);
		pnlImageSubPanel2.setLayout(new GridLayout(1,1));
		pnlImageSubPanel2.setBackground(Color.YELLOW);


		CP.addPanelAtLeft(pnlBottom,20);
		pnlBottomLeft=CP.addPanel();
		pnlBottom.add(pnlBottomLeft);
		pnlBottomLeft.setLayout(new GridLayout(1,1));
		pnlBottomLeft.setBackground(Color.yellow);

		CP.addPanelAtRight(pnlBottom,18);
		pnlBottomRight=CP.addPanel();
		pnlBottom.add(pnlBottomRight);
		pnlBottomRight.setLayout(new GridLayout(1,1));
		pnlBottomRight.setBackground(Color.yellow);

		CP.addPanelBetween(pnlBottom,pnlBottomLeft,pnlBottomRight);
		pnlButton=CP.addPanel();
		pnlBottom.add(pnlButton);
		pnlButton.setLayout(null);
		pnlButton.setBackground(Color.green);
		Dimension size = pnlBottom.getSize();



		CP.addPanelAtLeft(pnlEntry,20);
		pnlMenuOption1=CP.addPanel();
		pnlEntry.add(pnlMenuOption1);
		pnlMenuOption1.setLayout(null);
		pnlMenuOption1.setBackground(Color.CYAN);

		CP.addPanelAtTop(pnlMenuOption1,6);
		pnlSubMenu1=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu1);
		pnlSubMenu1.setLayout(new GridLayout(1,1,2,2));
		pnlSubMenu1.setBackground(Color.black);

		btnSubMenu1 = new JButton("SubMenu1");
		pnlSubMenu1.add(btnSubMenu1);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu1,6);
		pnlSubMenu2=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu2);
		pnlSubMenu2.setLayout(new GridLayout(1,1));
		pnlSubMenu2.setBackground(Color.black);

		btnSubMenu2 = new JButton(" SubMenu2 ");
		pnlSubMenu2.add(btnSubMenu2);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu2,6);
		pnlSubMenu3=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu3);
		pnlSubMenu3.setLayout(new GridLayout(1,1));
		pnlSubMenu3.setBackground(Color.black);

		btnSubMenu3 = new JButton(" SubMenu3 ");
		pnlSubMenu3.add(btnSubMenu3);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu3,6);
		pnlSubMenu4=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu4);
		pnlSubMenu4.setLayout(new GridLayout(1,1));
		pnlSubMenu4.setBackground(Color.black);

		btnSubMenu4 = new JButton(" SubMenu4 ");
		pnlSubMenu4.add(btnSubMenu4);


		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu4,6);
		pnlSubMenu5=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu5);
		pnlSubMenu5.setLayout(new GridLayout(1,1));
		pnlSubMenu5.setBackground(Color.black);

		btnSubMenu5 = new JButton(" SubMenu5 ");
		pnlSubMenu5.add(btnSubMenu5);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu5,6);
		pnlSubMenu6=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu6);
		pnlSubMenu6.setLayout(new GridLayout(1,1));
		pnlSubMenu6.setBackground(Color.black);

		btnSubMenu6 = new JButton(" SubMenu6 ");
		pnlSubMenu6.add(btnSubMenu6);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu6,6);
		pnlSubMenu7=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu7);
		pnlSubMenu7.setLayout(new GridLayout(1,1));
		pnlSubMenu7.setBackground(Color.black);

		btnSubMenu7 = new JButton(" SubMenu7 ");
		pnlSubMenu7.add(btnSubMenu7);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu7,6);
		pnlSubMenu8=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu8);
		pnlSubMenu8.setLayout(new GridLayout(1,1));
		pnlSubMenu8.setBackground(Color.black);

		btnSubMenu8 = new JButton(" SubMenu8 ");
		pnlSubMenu8.add(btnSubMenu8);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu8,6);
		pnlSubMenu9=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu9);
		pnlSubMenu9.setLayout(new GridLayout(1,1));
		pnlSubMenu9.setBackground(Color.black);

		btnSubMenu9 = new JButton(" SubMenu9 ");
		pnlSubMenu9.add(btnSubMenu9);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu9,6);
		pnlSubMenu10=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu10);
		pnlSubMenu10.setLayout(new GridLayout(1,1));
		pnlSubMenu10.setBackground(Color.black);

		btnSubMenu10 = new JButton(" SubMenu10 ");
		pnlSubMenu10.add(btnSubMenu10);

		CP.addPanelAfterFromTop(pnlMenuOption1,pnlSubMenu10,6);
		pnlSubMenu11=CP.addPanel();
		pnlMenuOption1.add(pnlSubMenu11);
		pnlSubMenu11.setLayout(new GridLayout(1,1));
		pnlSubMenu11.setBackground(Color.black);

		btnSubMenu11 = new JButton(" SubMenu11 ");
		pnlSubMenu11.add(btnSubMenu11);



















		lblProjectHeading = new JLabel("Galaxy ..... Project Information",JLabel.CENTER);
		pnlProjectHeading.add(lblProjectHeading);

		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		pnlProgramHeading.add(lblProgrammeHeading);





		lblSetImage1 = new JLabel();
		lblSetImage1.setIcon(new ImageIcon("img1.jpg"));
		pnlImageSubPanel1.add(lblSetImage1);

		lblSetImage2 = new JLabel();
		lblSetImage2.setIcon(new ImageIcon("img2.jpg"));
		pnlImageSubPanel2.add(lblSetImage2);

		lblLogo = new JLabel("",JLabel.CENTER);
		lblLogo.setIcon(new ImageIcon("img10.jpg"));
		pnlLogo.add(lblLogo);

		lblBottomLeftImage = new JLabel("",JLabel.CENTER);
		lblBottomLeftImage.setIcon(new ImageIcon("ButtonLeftImg.JPG"));
		pnlBottomLeft.add(lblBottomLeftImage);

		lblBottomRightImage = new JLabel("",JLabel.RIGHT);
		lblBottomRightImage.setIcon(new ImageIcon("4.JFIF"));
		pnlBottomRight.add(lblBottomRightImage);



       setDefaultOperation();


	}
	public void setDefaultOperation()
	{
		PanelState.disabledComponents(pnlSelect);
		PanelState.disabledComponents(pnlMenuOption1);
		PanelState.disabledComponents(pnlButton);

	}
	public void UIAreaSetting(int rw,int rh)
	{
		Dimension ds=pnlMenuOption1.getParent().getSize();
		int pw = ds.width;
		int ph = ds.height;
		int x = (pw-rw)/2;
		int y = ((ph-rh)/2);

		pnlMenuOption1.setBounds(x,y,rw,rh);

	}

	public JPanel getDataPanel()
	{
		return (pnlMenuOption1);
	}
	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}
	public JPanel getMenu1Panel()
	{
		return (pnlMenu1);
	}

	public JButton getbtnMenu1()
	{
		return (btnMenu1);
	}
	public JPanel getMenu2Panel()
	{
		return (pnlMenu2);
	}

	public JButton getbtnMenu2()
	{
		return (btnMenu2);
	}
	public JPanel getMenu3Panel()
	{
	return (pnlMenu3);
	}

	public JButton getbtnMenu3()
	{
	return (btnMenu3);
	}
	public JPanel getMenu4Panel()
	{
	return (pnlMenu4);
	}

	public JButton getbtnMenu4()
	{
	return (btnMenu4);
	}
	public JPanel getMenu5Panel()
	{
		return (pnlMenu5);
	}

	public JButton getbtnMenu5()
	{
		return (btnMenu5);
	}
	public JPanel getMenu6Panel()
	{
		return (pnlMenu6);
	}

	public JButton getbtnMenu6()
	{
		return (btnMenu6);
	}
	public JPanel getMenu7Panel()
	{
		return (pnlMenu7);
	}

	public JButton getbtnMenu7()
	{
		return (btnMenu7);
	}
	public JPanel getMenu8Panel()
	{
		return (pnlMenu8);
	}
	public JButton getbtnMenu8()
	{
		return (btnMenu8);
	}
	public JPanel getsubMenu1()
	{
		return (pnlSubMenu1);
	}
	public JButton getbtnSubMenu1()
	{
		return (btnSubMenu1);
	}
	public JPanel getsubMenu2()
	{
		return (pnlSubMenu2);
	}
	public JButton getbtnSubMenu2()
	{
		return (btnSubMenu2);
	}
	public JPanel getsubMenu3()
	{
		return (pnlSubMenu3);
	}
	public JButton getbtnSubMenu3()
	{
		return (btnSubMenu3);
	}
	public JPanel getsubMenu4()
	{
		return (pnlSubMenu4);
	}
	public JButton getbtnSubMenu4()
	{
		return (btnSubMenu4);
	}
	public JPanel getsubMenu5()
	{
		return (pnlSubMenu5);
	}
	public JButton getbtnSubMenu5()
	{
		return (btnSubMenu5);
	}
	public JPanel getsubMenu6()
	{
		return (pnlSubMenu6);
	}
	public JButton getbtnSubMenu6()
	{
		return (btnSubMenu6);
	}
	public JPanel getsubMenu7()
	{
		return (pnlSubMenu7);
	}
	public JButton getbtnSubMenu7()
	{
		return (btnSubMenu7);
	}
	public JPanel getsubMenu8()
	{
		return (pnlSubMenu8);
	}
	public JButton getbtnSubMenu8()
	{
		return (btnSubMenu8);
	}
	public JPanel getsubMenu9()
	{
		return (pnlSubMenu9);
	}
	public JButton getbtnSubMenu9()
	{
		return (btnSubMenu9);
	}
	public JPanel getsubMenu10()
	{
		return (pnlSubMenu10);
	}
	public JButton getbtnSubMenu10()
	{
		return (btnSubMenu10);
	}
	public JPanel getsubMenu11()
	{
		return (pnlSubMenu11);
	}
	public JButton getbtnSubMenu11()
	{
		return (btnSubMenu11);
	}




	public JLabel getProjectHeading()
	{
		return (lblProjectHeading);

	}
   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }

}
