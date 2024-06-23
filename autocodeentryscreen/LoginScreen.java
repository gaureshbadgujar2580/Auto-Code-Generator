package AutoCodeentryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import ProjectSetting.*;
import HtmlSetting.*;




public class LoginScreen extends JPanel
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
	JPanel pnlData;

	JPanel pnlLogin;
	JPanel pnlNewProject;

	JButton btnNewProject;
	JButton btnLogin;


	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;






	public LoginScreen()
	{


		Color borderColor=Color.black;
		Border borderLineBorder = BorderFactory.createLineBorder(borderColor);
		Border Border1 = BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#483D8B"));



		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width,screenSize.height);
		setLocation(0,0);
		setLayout(null);

		CreatePanel CP = new CreatePanel(screenSize.width,screenSize.height);
		CP.setGap(5,5);


		setBackground(ApplyColor.clrBackColor);

		CP.setXToLeftOf(this);
		CP.setYToTopOf(this);
		CP.setWidthPercentage(17);
		CP.setHeightPercentage(15);
		pnlLogo = CP.createPanel();

		pnlLogo.setBackground(ApplyColor.clrLogoPanel);
		pnlLogo.setLayout(new GridLayout(1,1));
		add(pnlLogo);


		CP.setXToLeftOf(this);
		CP.setPanelToBottom(11);
		CP.setWidthTillEnd(this);

		pnlBottom = CP.createPanel();

		pnlBottom.setBackground(ApplyColor.clrBottomPanel);
		pnlBottom.setLayout(null);
		add(pnlBottom);

		CP.setXToRightOf(pnlLogo);
		CP.setYToTopOf(this);
		CP.setWidthTillEndFrom(pnlLogo);
		CP.setHeightPercentage(5);
		pnlProjectHeading = CP.createPanel();

		pnlProjectHeading.setBackground(ApplyColor.clrProjectHeadingPanel);
		pnlProjectHeading.setLayout(new GridLayout(1,1));
		add(pnlProjectHeading);




		CP.setPanelToRight(26);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setHeightBetween(pnlProjectHeading,pnlBottom);//setHeightPercentage(80);
		pnlImage = CP.createPanel();

		//pnlImage.setBackground(clrpnlImage);
		pnlImage.setLayout(new GridLayout(2,1,5,5));
		add(pnlImage);


		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightPercentage(5);
		pnlProgramHeading = CP.createPanel();

		pnlProgramHeading.setBackground(ApplyColor.clrProgramHeadingPanel);
		pnlProgramHeading.setLayout(new GridLayout(1,1));
		add(pnlProgramHeading);



		CP.setXToLeftOf(this);;
		CP.setYBelowOf(pnlLogo);
		CP.setWidthPercentage(17);
		CP.setHeightBetween(pnlLogo,pnlBottom);//setHeightPercentage(70);
		pnlSelect = CP.createPanel();

		pnlSelect.setBackground(ApplyColor.clrMenuSelectPanel);
		pnlSelect.setLayout(null);
		add(pnlSelect);


		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProgramHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightBetween(pnlProgramHeading,pnlBottom);//setHeightPercentage(74);
		pnlEntry = CP.createPanel();

		pnlEntry.setBackground(ApplyColor.clrEntryPanel);
		pnlEntry.setLayout(null);
		add(pnlEntry);


		CP.addPanelAtTop(pnlImage,49);
		pnlImageSubPanel1=CP.addPanel();
		pnlImage.add(pnlImageSubPanel1);
		pnlImageSubPanel1.setLayout(new GridLayout(1,1));
		pnlImageSubPanel1.setBackground(ApplyColor.clrImageSubPanel1);

		CP.addPanelAtBottom(pnlImage,49);
		pnlImageSubPanel2=CP.addPanel();
		pnlImage.add(pnlImageSubPanel2);
		pnlImageSubPanel2.setLayout(new GridLayout(1,1));
		pnlImageSubPanel2.setBackground(ApplyColor.clrImageSubPanel2);


		CP.addPanelAtLeft(pnlBottom,20);
		pnlBottomLeft=CP.addPanel();
		pnlBottom.add(pnlBottomLeft);
		pnlBottomLeft.setLayout(new GridLayout(1,1));
		pnlBottomLeft.setBackground(ApplyColor.clrBottomLeftPanel);

		CP.addPanelAtRight(pnlBottom,18);
		pnlBottomRight=CP.addPanel();
		pnlBottom.add(pnlBottomRight);
		pnlBottomRight.setLayout(new GridLayout(1,1));
		pnlBottomRight.setBackground(ApplyColor.clrBottomRightPanel);

		CP.addPanelBetween(pnlBottom,pnlBottomLeft,pnlBottomRight);
		pnlButton=CP.addPanel();
		pnlBottom.add(pnlButton);
		pnlButton.setLayout(null);
		pnlButton.setBackground(ApplyColor.clrButtonPanel);
		Dimension size = pnlBottom.getSize();




		CP.addPanelAtLeft(pnlButton,7,6,10);
		pnlLogin=CP.addPanel();
		pnlButton.add(pnlLogin);
		pnlLogin.setLayout(new GridLayout(1,1));
		pnlLogin.setBackground(ApplyColor.clrMenuHeadButton);

		CP.addPanelAfterFromLeft(pnlButton,pnlLogin,7,6,10);
		pnlNewProject=CP.addPanel();
		pnlButton.add(pnlNewProject);
		pnlNewProject.setLayout(new GridLayout(1,1));
		pnlNewProject.setBackground(Color.blue);



		CP.addPanelAtLeft(pnlEntry,30);
		pnlData=CP.addPanel();
		pnlEntry.add(pnlData);
		pnlData.setLayout(null);
		pnlData.setBackground(ApplyColor.clrDataPanel);






		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
	   lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);


		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);


		lblSetImage1 = new JLabel();
		lblSetImage1.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgTop1.jpg"));
		pnlImageSubPanel1.add(lblSetImage1);

		lblSetImage2 = new JLabel();
		lblSetImage2.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgTop2.jpg"));
		pnlImageSubPanel2.add(lblSetImage2);

		lblLogo = new JLabel("",JLabel.CENTER);
		lblLogo.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgLogo.jpg"));
		pnlLogo.add(lblLogo);

		lblBottomLeftImage = new JLabel("",JLabel.CENTER);
		lblBottomLeftImage.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgButtonLeft.jpg"));
		pnlBottomLeft.add(lblBottomLeftImage);

		lblBottomRightImage = new JLabel("",JLabel.RIGHT);
		lblBottomRightImage.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgButtonRight.jpg"));
		pnlBottomRight.add(lblBottomRightImage);

		btnLogin = new JButton("Login");
		pnlLogin.add(btnLogin);

		btnNewProject =  new JButton("New Project");
		pnlNewProject.add(btnNewProject);





       setDefaultOperation();


	}
	public void setDefaultOperation()
	{
		PanelState.disabledComponents(pnlSelect);
		PanelState.disabledComponents(pnlData);

		//PanelState.disabledComponents(pnlButton);

	}
	public void UIAreaSetting(int rw,int rh)
	{
		Dimension ds=pnlData.getParent().getSize();
		int pw = ds.width;
		int ph = ds.height;
		int x = (pw-rw)/2;
		int y = ((ph-rh)/2);

		pnlData.setBounds(x,y,rw,rh);

	}


	public JPanel getEntryPanel()
	{
		return (pnlEntry);
	}
	public JPanel getDataPanel()
	{
		return (pnlData);
	}
	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}
	public JPanel getNewPanel()
	{
		return (pnlLogin);
	}
	public JButton getNewButton()
	{
		return (btnLogin);
	}
	public JPanel getSavePanel()
	{
		return (pnlNewProject);
	}

   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }





}
