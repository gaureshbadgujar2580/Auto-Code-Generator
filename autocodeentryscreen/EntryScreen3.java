package AutoCodeentryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import ProjectSetting.*;
import HtmlSetting.*;



public class EntryScreen3 extends JPanel
{

	JPanel pnlLogo;
	JPanel pnlProjectHeading;
	JPanel pnlProgramHeading;
	JPanel pnlImage;
	JPanel pnlSelect;
	JPanel pnlEntry;
	JPanel pnlBottom;
	JPanel pnlApply;
	JPanel pnlImageSubPanel1;
	JPanel pnlImageSubPanel2;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlButton;
	JPanel pnlData;
	JPanel pnlDataReport;


	JPanel pnlNew;
	JPanel pnlSave;
	JPanel pnlView;
    JPanel pnlEdit;
	JPanel pnlUpdate;
    JPanel pnlDelete;
    JPanel pnlClose;
    JPanel pnlReport;

	JButton btnSave;
	JButton btnNew;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnEdit;
	JButton btnView;
	JButton btnClose;
	JButton btnReport;

	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;


	JButton btnApply;


	JPanel pnlCombo1;
	JLabel lblCombo1;
	JComboBox cmbCombo1;


	JPanel pnlCombo2;
	JLabel lblCombo2;
	JComboBox cmbCombo2;

	JPanel pnlCombo3;
	JLabel lblCombo3;
	JComboBox cmbCombo3;




	public EntryScreen3()
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

		CP.addPanelAtTop(pnlSelect,10);
		pnlCombo1=CP.addPanel();
		pnlSelect.add(pnlCombo1);
		pnlCombo1.setLayout(new GridLayout(2,1));
		//pnlCombo1.setBackground(clrpnlCombo1);

		CP.addPanelAfterFromTop(pnlSelect,pnlCombo1,10);
		pnlCombo2=CP.addPanel();
		pnlSelect.add(pnlCombo2);
		pnlCombo2.setLayout(new GridLayout(2,1));
		//pnlCombo2.setBackground(clrpnlCombo1);


		CP.addPanelAfterFromTop(pnlSelect,pnlCombo2,10);
		pnlCombo3=CP.addPanel();
		pnlSelect.add(pnlCombo3);
		pnlCombo3.setLayout(new GridLayout(2,1));
		//pnlCombo3.setBackground(clrpnlCombo1);


		CP.addPanelAtBottom(pnlSelect,6);
		pnlApply=CP.addPanel();
		pnlSelect.add(pnlApply);
		pnlApply.setLayout(new GridLayout(1,1));
		//pnlApply.setBackground(clrpnlCombo1);

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
		pnlNew=CP.addPanel();
		pnlButton.add(pnlNew);
		pnlNew.setLayout(new GridLayout(1,1));
		pnlNew.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlNew,7,6,10);
		pnlSave=CP.addPanel();
		pnlButton.add(pnlSave);
		pnlSave.setLayout(new GridLayout(1,1));
		pnlSave.setBackground(Color.blue);


		CP.addPanelAfterFromLeft(pnlButton,pnlSave,7,6,10);
		pnlView=CP.addPanel();
		pnlButton.add(pnlView);
		pnlView.setLayout(new GridLayout(1,1));
		pnlView.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlView,7,6,10);
		pnlEdit=CP.addPanel();
		pnlButton.add(pnlEdit);
		pnlEdit.setLayout(new GridLayout(1,1));
		pnlEdit.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlEdit,7,6,10);
		pnlUpdate=CP.addPanel();
		pnlButton.add(pnlUpdate);
		pnlUpdate.setLayout(new GridLayout(1,1));
		pnlUpdate.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlUpdate,7,6,10);
		pnlDelete=CP.addPanel();
		pnlButton.add(pnlDelete);
		pnlDelete.setLayout(new GridLayout(1,1));
		pnlDelete.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlDelete,7,6,10);
		pnlClose=CP.addPanel();
		pnlButton.add(pnlClose);
		pnlClose.setLayout(new GridLayout(1,1));
		pnlClose.setBackground(Color.blue);

		CP.addPanelAfterFromLeft(pnlButton,pnlClose,7,6,10);
		pnlReport=CP.addPanel();
		pnlButton.add(pnlReport);
		pnlReport.setLayout(new GridLayout(1,1));
		pnlReport.setBackground(Color.blue);

		CP.addPanelAtLeft(pnlEntry,30);
		pnlData=CP.addPanel();
		pnlEntry.add(pnlData);
		pnlData.setLayout(null);
		pnlData.setBackground(ApplyColor.clrMenuTitlePanel);


		CP.addPanelAtLeft(pnlEntry,30);
		pnlDataReport=CP.addPanel();
		pnlEntry.add(pnlDataReport);
		pnlDataReport.setLayout(null);
		pnlDataReport.setBackground(ApplyColor.clrSubMenuFirstPanel);





		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
		lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);


		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);


		lblCombo1 = new JLabel("-------------------------");
		pnlCombo1.add(lblCombo1);

		cmbCombo1 = new JComboBox();
		cmbCombo1.addItem("No Record");
		pnlCombo1.add(cmbCombo1);


		lblCombo2 = new JLabel("-------------------------");
		pnlCombo2.add(lblCombo2);

		cmbCombo2 = new JComboBox();
		cmbCombo2.addItem("No Record");
		pnlCombo2.add(cmbCombo2);


		lblCombo3 = new JLabel("-------------------------");
		pnlCombo3.add(lblCombo3);

		cmbCombo3 = new JComboBox();

		cmbCombo3.addItem("No Record");
		pnlCombo3.add(cmbCombo3);




		btnApply = new JButton("Apply");
		btnApply.setBackground(ApplyColor.clrMenuHeadButton);
		pnlApply.add(btnApply);

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

		btnNew = new JButton("New");
		pnlNew.add(btnNew);

		btnSave =  new JButton("Save");
		pnlSave.add(btnSave);

		btnView = new JButton("View");
		pnlView.add(btnView);

		btnEdit = new JButton("Edit");
		pnlEdit.add(btnEdit);

		btnUpdate = new JButton("Update");
		pnlUpdate.add(btnUpdate);

		btnDelete = new JButton("Delete");
		pnlDelete.add(btnDelete);

		btnClose = new JButton("Close");
		pnlClose.add(btnClose);

		btnReport  =new JButton("Report");
		pnlReport.add(btnReport);







       setDefaultOperation();


	}
	public void setDefaultOperation()
	{
		PanelState.disabledComponents(pnlSelect);
		PanelState.disabledComponents(pnlData);
		PanelState.disabledComponents(pnlDataReport);

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

	public JPanel getDataPanel()
	{
		return (pnlData);
	}
	public JPanel getEntryPanel()
	{
		return(pnlEntry);
	}

	public JPanel getDataReportPanel()
	{
		return (pnlDataReport);
	}

	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}
	public JPanel getNewPanel()
	{
		return (pnlNew);
	}
	public JButton getNewButton()
	{
		return (btnNew);
	}
	public JPanel getSavePanel()
	{
		return (pnlSave);
	}
	public JButton getSaveButton()
	{
		return (btnSave);
	}
	public JPanel getViewPanel()
	{
		return (pnlView);
	}
	public JButton getViewButton()
	{
		return (btnView);
	}
	public JPanel getEditPanel()
	{
		return (pnlEdit);
	}
	public JButton getEditButton()
	{
		return (btnEdit);
	}
	public JPanel getUpdatePanel()
	{
		return (pnlUpdate);
	}
	public JButton getUpdateButton()
	{
		return (btnUpdate);
	}
	public JPanel getDeletePanel()
	{
		return (pnlDelete);
	}
	public JButton getDeleteButton()
	{
		return (btnDelete);
	}
	public JPanel getClosePanel()
	{
		return (pnlClose);
	}
	public JButton getCloseButton()
	{
		return (btnClose);
	}
	public JPanel getReportPanel()
	{
		return (pnlReport);
	}
	public JButton getReportButton()
	{
		return (btnReport);
	}
	public JPanel getFirstComboPanel()
	{
		return (pnlCombo1);
	}
	public JLabel getFirstComboLabel()
	{
		return (lblCombo1);
	}
	public JComboBox getFirstComboBox()
	{
		return (cmbCombo1);
	}

	public JPanel getSecondComboPanel()
	{
		return (pnlCombo2);
	}
	public JLabel getSecondComboLabel()
	{
		return (lblCombo2);
	}
	public JComboBox getSecondComboBox()
	{
		return (cmbCombo2);
	}


	public JPanel getThirdComboPanel()
	{
		return (pnlCombo3);
	}
	public JLabel getThirdComboLabel()
	{
		return (lblCombo3);
	}
	public JComboBox getThirdComboBox()
	{
		return (cmbCombo3);
	}


	public JPanel getApplyPanel()
	{
		return (pnlApply);
	}
	public JButton getApplyButton()
	{
		return (btnApply);
	}

   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }
}
