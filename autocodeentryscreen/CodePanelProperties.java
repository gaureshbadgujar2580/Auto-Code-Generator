package autocodeentryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import myUtility.PanelState;
import ProjectSetting.*;
import HtmlSetting.*;

public class CodePanelProperties extends JPanel
{

	JPanel pnlLogo;
	JPanel pnlProjectHeading;
	JPanel pnlProgramHeading;
	JPanel pnlPropertyParentPanel;
	JPanel pnlSelect;
	JPanel pnlEntry;
	JPanel pnlBottom;
	JPanel pnlApply;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlButton;

	JPanel pnlFormDisplay;
	JPanel pnlCodeDisplay;
	JPanel pnlSelectLeft;
	JPanel pnlSelectRight;
	JPanel pnlPropertyChildPanel;
	JPanel pnlPropertyChild2Panel;
	JPanel pnlCreateComponent;



	JTextArea txtCodeDisplay;

	JButton btnCreateComponent;

	JPanel pnlAddComponent;
	JButton btnAddComponent;
	JPanel pnlViewComponent;
	JButton btnViewComponent;

	JPanel pnlSelectObject;
	JLabel lblSelectObject;
	JComboBox cmbSelectObject;

	JPanel pnlUpdateComponent;
	JButton btnUpdateComponent;

	JPanel pnlDeleteComponent;
	JButton btnDeleteComponent;

	JPanel pnlGoBack;
	JButton btnGoBack;

	JPanel pnlCloseDisplay;
	JButton btnCloseDisplay;

	JPanel pnlButtonFirst;
	JButton btnButtonFirst;
	JPanel pnlButtonSecond;
	JButton btnButtonSecond;
	JPanel pnlButtonThird;
	JButton btnButtonThird;
	JPanel pnlButtonFourth;
	JButton btnButtonFourth;
	JPanel pnlButtonFive;
	JButton btnButtonFive;
	JPanel pnlButtonSix;
	JButton btnButtonSix;
	JPanel pnlButtonSeven;
	JButton btnButtonSeven;


	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;
	JLabel lblButtonPanelImage;


	JButton btnApply;




	public CodePanelProperties()
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
		CP.setHeightPercentage(7);
		pnlProjectHeading = CP.createPanel();

		pnlProjectHeading.setBackground(ApplyColor.clrProjectHeadingPanel);
		pnlProjectHeading.setLayout(new GridLayout(1,1));
		add(pnlProjectHeading);




		CP.setPanelToRight(26);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setHeightBetween(pnlProjectHeading,pnlBottom);//setHeightPercentage(80);
		pnlPropertyParentPanel = CP.createPanel();
		pnlPropertyParentPanel.setBackground(Color.black);

		//pnlPropertyParentPanel.setBackground(clrpnlPropertyParentPanel);
		pnlPropertyParentPanel.setLayout(null);
		add(pnlPropertyParentPanel);


		CP.addPanelAtTop(pnlPropertyParentPanel,67);
		pnlPropertyChildPanel=CP.addPanel();
		pnlPropertyParentPanel.add(pnlPropertyChildPanel);
		pnlPropertyChildPanel.setLayout(null);
		pnlPropertyChildPanel.setBackground(ApplyColor.clrDataPanel);

		CP.addPanelAfterFromTop(pnlPropertyParentPanel,pnlPropertyChildPanel,10);
		pnlPropertyChild2Panel=CP.addPanel();
		pnlPropertyParentPanel.add(pnlPropertyChild2Panel);
		pnlPropertyChild2Panel.setLayout(new GridLayout(1,1));
		//pnlPropertyChild2Panel.setBackground(Color.orange);

//		CP.addPanelAtTop(pnlPropertyChild2Panel,5);
		CP.addPanelInside(pnlPropertyChild2Panel);
		pnlCreateComponent=CP.addPanel();
		pnlPropertyChild2Panel.add(pnlCreateComponent);
		pnlCreateComponent.setLayout(new GridLayout(1,1));
		//pnlCreateComponent.setBackground(Color.red);


		btnCreateComponent = new JButton("Create Component");
		pnlCreateComponent.add(btnCreateComponent);



		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setWidthBetween(pnlLogo,pnlPropertyParentPanel);
		CP.setHeightPercentage(7);
		pnlProgramHeading = CP.createPanel();

		pnlProgramHeading.setBackground(ApplyColor.clrProgramHeadingPanel);
		pnlProgramHeading.setLayout(new GridLayout(1,1));
		add(pnlProgramHeading);



		CP.setXToLeftOf(this);;
		CP.setYBelowOf(pnlLogo);
		CP.setWidthPercentage(21);
		CP.setHeightBetween(pnlLogo,pnlBottom);//setHeightPercentage(70);
		pnlSelect = CP.createPanel();

		pnlSelect.setBackground(ApplyColor.clrMenuSelectPanel);
		pnlSelect.setLayout(null);
		add(pnlSelect);


		CP.setXToRightOf(pnlSelect);
		CP.setYBelowOf(pnlProgramHeading);
		CP.setWidthBetween(pnlSelect,pnlPropertyParentPanel);
		CP.setHeightBetween(pnlProgramHeading,pnlBottom);//setHeightPercentage(74);
		pnlEntry = CP.createPanel();

		pnlEntry.setBackground(ApplyColor.clrEntryPanel);
		pnlEntry.setLayout(null);
		add(pnlEntry);

		CP.addPanelAtLeft(pnlSelect,10);
		pnlSelectLeft=CP.addPanel();
		pnlSelect.add(pnlSelectLeft);
		pnlSelectLeft.setLayout(null);
		//pnlCombo1.setBackground(clrpnlCombo1);


		CP.addPanelAfterFromLeft(pnlSelect,pnlSelectLeft,10);
		pnlSelectRight=CP.addPanel();
		pnlSelect.add(pnlSelectRight);
		pnlSelectRight.setLayout(null);



		CP.addPanelAtTop(pnlSelectLeft,5);
		pnlButtonFirst=CP.addPanel();
		pnlSelectLeft.add(pnlButtonFirst);
		pnlButtonFirst.setLayout(new GridLayout(1,1));
		//pnlButtonFirst.setBackground(Color.red);


		btnButtonFirst = new JButton("CreateUI");
		pnlButtonFirst.add(btnButtonFirst);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonFirst,5);
		pnlButtonSecond=CP.addPanel();
		pnlSelectLeft.add(pnlButtonSecond);
		pnlButtonSecond.setLayout(new GridLayout(1,1));
		pnlButtonSecond.setBackground(Color.red);


		btnButtonSecond = new JButton(".........");
		pnlButtonSecond.add(btnButtonSecond);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonSecond,5);
		pnlButtonThird=CP.addPanel();
		pnlSelectLeft.add(pnlButtonThird);
		pnlButtonThird.setLayout(new GridLayout(1,1));
		pnlButtonThird.setBackground(Color.red);

	/*	*/


		btnButtonThird = new JButton("...........");
		pnlButtonThird.add(btnButtonThird);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonThird,6);
		pnlButtonFourth=CP.addPanel();
		pnlSelectLeft.add(pnlButtonFourth);
		pnlButtonFourth.setLayout(new GridLayout(1,1));
		pnlButtonFourth.setBackground(Color.red);


		btnButtonFourth = new JButton("CloseDisplay");
		pnlButtonFourth.add(btnButtonFourth);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonFourth,6);
		pnlButtonFive=CP.addPanel();
		pnlSelectLeft.add(pnlButtonFive);
		pnlButtonFive.setLayout(new GridLayout(1,1));
		pnlButtonFive.setBackground(Color.red);


		btnButtonFive = new JButton("Display Code");
		pnlButtonFive.add(btnButtonFive);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonFive,6);
		pnlButtonSix=CP.addPanel();
		pnlSelectLeft.add(pnlButtonSix);
		pnlButtonSix.setLayout(new GridLayout(1,1));
		pnlButtonSix.setBackground(Color.red);


		btnButtonSix = new JButton("Genrate Code");
		pnlButtonSix.add(btnButtonSix);

		CP.addPanelAfterFromTop(pnlSelectLeft,pnlButtonSix,6);
		pnlButtonSeven=CP.addPanel();
		pnlSelectLeft.add(pnlButtonSeven);
		pnlButtonSeven.setLayout(new GridLayout(1,1));
		pnlButtonSeven.setBackground(Color.red);

        btnButtonSeven = new JButton("Execute App");
		pnlButtonSeven.add(btnButtonSeven);



		CP.addPanelAtTop(pnlSelectRight,5);
		pnlAddComponent=CP.addPanel();
		pnlSelectRight.add(pnlAddComponent);
		pnlAddComponent.setLayout(new GridLayout(1,1));

		btnAddComponent = new JButton("Add Component");
		pnlAddComponent.add(btnAddComponent);

		CP.addPanelAfterFromTop(pnlSelectRight,pnlAddComponent,5);
		pnlViewComponent=CP.addPanel();
		pnlSelectRight.add(pnlViewComponent);
		pnlViewComponent.setLayout(new GridLayout(1,1));

		btnViewComponent = new JButton("View Component");
		pnlViewComponent.add(btnViewComponent);

		CP.addPanelAfterFromTop(pnlSelectRight,pnlViewComponent,5);
		pnlSelectObject=CP.addPanel();
		pnlSelectRight.add(pnlSelectObject);
		pnlSelectObject.setLayout(new GridLayout(2,1));

		lblSelectObject = new JLabel(".......");
		pnlSelectObject.add(lblSelectObject);

		cmbSelectObject = new JComboBox();
		pnlSelectObject.add(cmbSelectObject);

		CP.addPanelAfterFromTop(pnlSelectRight,pnlSelectObject,6);
		pnlUpdateComponent=CP.addPanel();
		pnlSelectRight.add(pnlUpdateComponent);
		pnlUpdateComponent.setLayout(new GridLayout(1,1));

		btnUpdateComponent = new JButton("Update Component");
		pnlUpdateComponent.add(btnUpdateComponent);

		CP.addPanelAfterFromTop(pnlSelectRight,pnlUpdateComponent,6);
		pnlDeleteComponent=CP.addPanel();
		pnlSelectRight.add(pnlDeleteComponent);
		pnlDeleteComponent.setLayout(new GridLayout(1,1));

		btnDeleteComponent = new JButton("Delete Component");
		pnlDeleteComponent.add(btnDeleteComponent);

		CP.addPanelAfterFromTop(pnlSelectRight,pnlDeleteComponent,6);
		pnlGoBack=CP.addPanel();
		pnlSelectRight.add(pnlGoBack);
		pnlGoBack.setLayout(new GridLayout(1,1));


		btnGoBack = new JButton("Back");
		pnlGoBack.add(btnGoBack);

		/*CP.addPanelBetween(pnlBottom,pnlBottomLeft,pnlBottomRight);
		pnlButton=CP.addPanel();
		pnlBottom.add(pnlButton);
		pnlButtonThird.setLayout(null);
		pnlButtonThird.setBackground(Color.red);*/

	//	CP.addPanelAtBottom(pnlSelect,6);
		/*pnlApply=CP.addPanel();
		pnlSelect.add(pnlApply);
		pnlApply.setLayout(new GridLayout(1,1));
		//pnlApply.setBackground(clrpnlCombo1);
*/


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


		CP.addPanelAtLeft(pnlEntry,30);
		pnlFormDisplay=CP.addPanel();
		pnlEntry.add(pnlFormDisplay);
		pnlFormDisplay.setLayout(null);
		pnlFormDisplay.setBackground(ApplyColor.clrDataPanel);


		CP.addPanelInside(pnlEntry);
		pnlCodeDisplay=CP.addPanel();
		pnlEntry.add(pnlCodeDisplay);
		pnlCodeDisplay.setLayout(null);
		pnlCodeDisplay.setBackground(ApplyColor.clrDataPanel);

		Dimension sizeTemp = pnlCodeDisplay.getSize();
		txtCodeDisplay = new JTextArea();
		txtCodeDisplay.setBounds(5,5,sizeTemp.width-10,sizeTemp.height-10);
		pnlCodeDisplay.add(txtCodeDisplay);

		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
	   lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);


		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);

		/*lblCombo1 = new JLabel("                -------------------------  ");
		pnlCombo1.add(lblCombo1);

		cmbCombo1 = new JComboBox();
		cmbCombo1.addItem("No Record");
		pnlCombo1.add(cmbCombo1);*/

		/*btnApply = new JButton("Apply");
		btnApply.setBackground(ApplyColor.clrMenuHeadButton);
		pnlApply.add(btnApply);*/



		lblLogo = new JLabel("",JLabel.CENTER);
		lblLogo.setIcon(new ImageIcon("Images\\ImgLogo.jpg"));
		pnlLogo.add(lblLogo);

	 	 lblBottomLeftImage = new JLabel("",JLabel.CENTER);
		lblBottomLeftImage.setIcon(new ImageIcon("Images\\ImgButtonLeft.jpg"));
		pnlBottomLeft.add(lblBottomLeftImage);

		lblBottomRightImage = new JLabel("",JLabel.RIGHT);
		lblBottomRightImage.setIcon(new ImageIcon("Images\\ImgButtonRight.jpg"));
		pnlBottomRight.add(lblBottomRightImage);


		lblButtonPanelImage = new JLabel("",JLabel.RIGHT);
		lblButtonPanelImage.setIcon(new ImageIcon("Images\\ImgButtonPanelFinal.jpg"));
		pnlButton.add(lblButtonPanelImage);



       setDefaultOperation();


	}
	public void setDefaultOperation()
	{
		PanelState.disabledComponents(pnlSelectLeft);
		PanelState.disabledComponents(pnlFormDisplay);
		PanelState.hideComponents(pnlCodeDisplay);
	}
	public void UIAreaSetting(int rw,int rh)
	{
		Dimension ds=pnlFormDisplay.getParent().getSize();
		int pw = ds.width;
		int ph = ds.height;
		int x = (pw-rw)/2;
		int y = ((ph-rh)/2);

		pnlFormDisplay.setBounds(x,y,rw,rh);

	}


	public JPanel getEntryPanel()
	{
		return (pnlEntry);
	}
	public JPanel getFormDisplayPanel()
	{
		return (pnlFormDisplay);
	}
	public JPanel getCodeDisplayPanel()
	{
		return (pnlCodeDisplay);
	}
	public JTextArea getCodeDisplayTextArea()
	{
		return (txtCodeDisplay);
	}
	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}


	public JPanel getSelectLeftPanel()
	{
		return (pnlSelectLeft);
	}
	public JPanel getSelectRightPanel()
	{
		return (pnlSelectRight);
	}

	public JPanel getAddComponentPanel()
	{
		return(pnlAddComponent);
	}

	public JButton getAddComponentButton()
	{
		return(btnAddComponent);
	}

	public JPanel getViewComponentPanel()
	{
		return(pnlViewComponent);
	}

	public JButton getViewComponentButton()
	{
		return(btnViewComponent);
	}

	public JPanel getSelectObjectPanel()
	{
		return(pnlSelectObject);
	}

	public JLabel getSelectObjectLabel()
	{
		return(lblSelectObject);
	}

	public JComboBox getSelectObjectComboBox()
	{
		return(cmbSelectObject);
	}

	public JPanel getUpdateComponentPanel()
	{
		return(pnlUpdateComponent);
	}

	public JButton getUpdateComponentButton()
	{
		return(btnUpdateComponent);
	}


	public JPanel getDeleteComponentPanel()
	{
		return(pnlDeleteComponent);
	}

	public JButton getDeleteComponentButton()
	{
		return(btnDeleteComponent);
	}


	public JPanel getGoBackPanel()
	{
		return(pnlGoBack);
	}

	public JButton getGoBackButton()
	{
		return(btnGoBack);
	}



   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }

   public JPanel getSubDataEntryPanel()
   {
	   return (pnlPropertyChildPanel);
	}
	public JPanel getSubDataEntry2Panel()
	{

		return (pnlPropertyChild2Panel);
	}
	public JPanel getCreateComponentPanel()
	{
		return(pnlCreateComponent);
	}

	public JButton getCreateComponentButton()
	{
		return(btnCreateComponent);
	}

	public JPanel getButtonFirstPanel()
	{
		return (pnlButtonFirst);
	}
	public JButton getButtonFirstButton()
	{
		return (btnButtonFirst);
	}
	public JPanel getButtonSecondPanel()
	{
		return (pnlButtonSecond);
	}
	public JButton getButtonSecondButton()
	{
		return (btnButtonSecond);
	}
	public JPanel getButtonThirdPanel()
	{
return (pnlButtonThird);
	}
	public JButton getButtonThirdButton()
	{
		return (btnButtonThird);
	}
	public JPanel getButtonFourthPanel()
	{
		return (pnlButtonFourth);
	}
	public JButton getButtonFourthButton()
	{
		return (btnButtonFourth);
	}
	public JPanel getButtonFivePanel()
	{
		return (pnlButtonFive);
	}
	public JButton getButtonFiveButton()
	{
		return (btnButtonFive);
	}
	public JPanel getButtonSixPanel()
	{
		return (pnlButtonSix);
	}
	public JButton getButtonSixButton()
	{
		return (btnButtonSix);
	}
	public JPanel getButtonSevenPanel()
	{
		return (pnlButtonSeven);
	}
	public JButton getButtonSevenButton()
	{
		return (btnButtonSeven);
	}




}
