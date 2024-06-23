package autocodeentryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import ProjectSetting.*;
import HtmlSetting.*;

public class AutoCodeMenuScreen extends JPanel
{

	JPanel pnlLogo;
	JPanel pnlProjectHeading;
	JPanel pnlProgramHeading;
	JPanel pnlImage;
	JPanel pnlMenuSelect;
	JPanel pnlEntry;
	JPanel pnlBottom;
	JPanel pnlImageSubPanel1;
	JPanel pnlImageSubPanel2;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlButton;
	JPanel pnlSubMenuFirst;

	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblButtonPanel;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;

	CreatePanel CP;


	//int MenuHeadCounts=0;
	JPanel pnlMenuTitle;
	JLabel lblMenuTitle;
	JPanel pnlMenuHeads[];
	JButton btnMenuHeads[];

	//int MenuItemCounts=0;
	JPanel pnlSubMenuTitle;
	JLabel lblSubMenuTitle;
	JPanel pnlSubMenuItems[];
	JButton btnSubMenuItems[];



	public AutoCodeMenuScreen()
	{


		Color borderColor=Color.black;
		Border borderLineBorder = BorderFactory.createLineBorder(borderColor);
		Border Border1 = BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#483D8B"));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width,screenSize.height);
		setLocation(0,0);
		setLayout(null);

		CP = new CreatePanel(screenSize.width,screenSize.height);
		CP.setGap(5,5);


		setBackground(ApplyColor.clrBackColor);

		MyScreen();





		///.............addMenuHeads



		lblSetImage1 = new JLabel();
		lblSetImage1.setIcon(new ImageIcon("Images\\ImgTop1.jpg"));
		pnlImageSubPanel1.add(lblSetImage1);

		lblSetImage2 = new JLabel();
		lblSetImage2.setIcon(new ImageIcon("Images\\ImgTop2.jpg"));
		pnlImageSubPanel2.add(lblSetImage2);

		lblLogo = new JLabel("",JLabel.CENTER);
		lblLogo.setIcon(new ImageIcon("Images\\ImgLogo.jpg"));
		pnlLogo.add(lblLogo);


		lblBottomLeftImage = new JLabel("",JLabel.CENTER);
		lblBottomLeftImage.setIcon(new ImageIcon("Images\\ImgButtonLeft.jpg"));
		pnlBottomLeft.add(lblBottomLeftImage);

		lblBottomRightImage = new JLabel("",JLabel.RIGHT);
		lblBottomRightImage.setIcon(new ImageIcon("Images\\ImgButtonRight.jpg"));
		pnlBottomRight.add(lblBottomRightImage);



       setDefaultOperation();


	}

	public void addMenuHeads(String RequiredMenuHeads[])
	{
		int MenuHeadCounts=RequiredMenuHeads.length;

		CP.addPanelAtTop(pnlMenuSelect,5);
		pnlMenuTitle=CP.addPanel();
		pnlMenuSelect.add(pnlMenuTitle);
		pnlMenuTitle.setLayout(null);
		pnlMenuTitle.setBackground(ApplyColor.clrMenuTitlePanel);

		lblMenuTitle = new JLabel("Menu Title",JLabel.CENTER);
		CP.placeComponent(pnlMenuTitle,lblMenuTitle);
		pnlMenuTitle.add(lblMenuTitle);


		pnlMenuHeads = new JPanel[MenuHeadCounts];
		btnMenuHeads = new JButton[MenuHeadCounts];
		JPanel Parent = pnlMenuTitle;

		for(int i =0 ; i<MenuHeadCounts;i++)
		{
			CP.addPanelAfterFromTop(pnlMenuSelect,Parent,7);
			pnlMenuHeads[i]=CP.addPanel();
			pnlMenuSelect.add(pnlMenuHeads[i]);
			pnlMenuHeads[i].setLayout(null);
			pnlMenuHeads[i].setBackground(ApplyColor.clrMenuTitlePanel);
			btnMenuHeads[i] = new JButton(RequiredMenuHeads[i]);
			CP.placeComponent(pnlMenuHeads[i],btnMenuHeads[i]);
			pnlMenuHeads[i].add(btnMenuHeads[i]);
			btnMenuHeads[i].setBackground(ApplyColor.clrMenuHeadButton);
			Parent = pnlMenuHeads[i];
		}
	}

	public void addMenuItems(String RequiredMenuItems[])
	{
		int MenuItemCounts=RequiredMenuItems.length;

		CP.addPanelAtTop(pnlSubMenuFirst,5);
		pnlSubMenuTitle=CP.addPanel();
		pnlSubMenuFirst.add(pnlSubMenuTitle);
		pnlSubMenuTitle.setLayout(null);
		pnlSubMenuTitle.setBackground(ApplyColor.clrSubMenuTitlePanel);

		lblSubMenuTitle = new JLabel("Sub Menu Tittle",JLabel.CENTER);
		CP.placeComponent(pnlSubMenuTitle,lblSubMenuTitle);
		pnlSubMenuTitle.add(lblSubMenuTitle);
		HtmlStyle.applyH2(lblSubMenuTitle);



		pnlSubMenuItems = new JPanel[MenuItemCounts];
		btnSubMenuItems = new JButton[MenuItemCounts];
		JPanel Parent = pnlSubMenuTitle;

		for(int i =0 ; i<MenuItemCounts;i++)
		{
			CP.addPanelAfterFromTop(pnlSubMenuFirst,Parent,6);
			pnlSubMenuItems[i]=CP.addPanel();
			pnlSubMenuFirst.add(pnlSubMenuItems[i]);
			pnlSubMenuItems[i].setLayout(null);//new GridLayout(1,1,2,2));
			pnlSubMenuItems[i].setBackground(ApplyColor.clrSubMenuItemsPanel);
			btnSubMenuItems[i] = new JButton(RequiredMenuItems[i]);
			CP.placeComponent(pnlSubMenuItems[i],btnSubMenuItems[i]);
			pnlSubMenuItems[i].add(btnSubMenuItems[i]);
			btnSubMenuItems[i].setBackground(ApplyColor.clrSubMenuItemButton);
			Parent = pnlSubMenuItems[i];
		}
	}

	void MyScreen()
	{
		CP.setXToLeftOf(this);
		CP.setYToTopOf(this);
		CP.setWidthPercentage(17);
		CP.setHeightPercentage(15);
		pnlLogo = CP.createPanel();

		pnlLogo.setBackground(ApplyColor.clrLogoPanel);
		pnlLogo.setLayout(new GridLayout(1,1));
		add(pnlLogo);


		CP.setXToLeftOf(this);
		CP.setPanelToBottom(8);
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

		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
		lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);



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

		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);


		CP.setXToLeftOf(this);;
		CP.setYBelowOf(pnlLogo);
		CP.setWidthPercentage(17);
		CP.setHeightBetween(pnlLogo,pnlBottom);//setHeightPercentage(70);
		pnlMenuSelect = CP.createPanel();

		pnlMenuSelect.setBackground(ApplyColor.clrMenuSelectPanel);
		pnlMenuSelect.setLayout(null);
		add(pnlMenuSelect);


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
		pnlButton.setLayout(new GridLayout(1,1));
		pnlButton.setBackground(ApplyColor.clrButtonPanel);
		Dimension size = pnlBottom.getSize();


		lblButtonPanel = new JLabel("",JLabel.CENTER);
		lblButtonPanel.setIcon(new ImageIcon("D:\\Project_Development\\Images\\ImgButtonPanelFinal.jpg"));
		pnlButton.add(lblButtonPanel);

		CP.addPanelAtLeft(pnlEntry,20);
		pnlSubMenuFirst=CP.addPanel();
		pnlEntry.add(pnlSubMenuFirst);
		pnlSubMenuFirst.setLayout(null);
		pnlSubMenuFirst.setBackground(ApplyColor.clrSubMenuFirstPanel);

	}



	public void setDefaultOperation()
	{
		PanelState.disabledComponents(pnlMenuSelect);
		PanelState.disabledComponents(pnlSubMenuFirst);
		PanelState.disabledComponents(pnlButton);

	}
	public void UIAreaSetting(int rw,int rh)
	{
		Dimension ds=pnlSubMenuFirst.getParent().getSize();
		int pw = ds.width;
		int ph = ds.height;
		int x = (pw-rw)/2;
		int y = ((ph-rh)/2);

		pnlSubMenuFirst.setBounds(x,y,rw,rh);

	}

	public JPanel getDataPanel()
	{
		return (pnlSubMenuFirst);
	}
	public JPanel getSelectPanel()
	{
		return (pnlMenuSelect);
	}
	public JPanel getMenuTitlePanel()
	{
		return (pnlMenuTitle);
	}
	public JLabel getMenuTitleLabel()
	{
		return (lblMenuTitle);
	}

	public JPanel[] getMenuHeadsPanel()
	{
		return (pnlMenuHeads);
	}
	public JButton[] getMenuHeadsButton()
	{
		return (btnMenuHeads);
	}
	public JPanel[] getSubMenuItemsPanel()
	{
		return (pnlSubMenuItems);
	}
	public JButton[] getSubMenuItemsButton()
	{
		return (btnSubMenuItems);
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
