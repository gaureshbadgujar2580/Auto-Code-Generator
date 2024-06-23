import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmProjectEntry extends JFrame implements ActionListener
{
	ProjectSelectionPanel ES;
	int Buttoncount =4;

	int count;


	JPanel pnlData;
	JPanel pnlDataScroll;
	JPanel pnlDataOperation;
	JPanel pnlDataMenuLeft;
	JPanel pnlDataMenuRight;

	int vProjectID=0;
	ClsProject projref;

	JPanel pnlEntryPanel[];
	JButton btnEntryButton[];
//	String lblEntryButtonName[];

	JPanel pnlReportPanel[];
	JButton btnReportButton[];


	JButton btnNewProject ;
	JButton btnOpenProject;

JScrollPane scrollMenuLeft ;

	JLabel lblProgrameHeading;
	FrmProjectEntry()
	{


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		ES = new ProjectSelectionPanel();
		add(ES);
		Border bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		setLayout(null);
		pnlData = ES.getDataPanel();

		lblProgrameHeading = ES.getProgrammeHeading();

		lblProgrameHeading.setText("Project Entry ");
		HtmlStyle.applyH1(lblProgrameHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrameHeading,500);
		bl.start();



		pnlData.setLayout(null);
		int mDataPanelWidth = 1050;
		int mDataPanelHeight = 730;
		int mDataScrollPanelHeight=600;
		int mDataScrollPanelYValue=20;
		int mDatePanelXValue = 150;

		ES.UIAreaSetting(mDataPanelWidth,mDataPanelHeight);
		ES.setDataInnerPanels();
		pnlEntryPanel= new JPanel[Buttoncount];
		btnEntryButton = new JButton[Buttoncount];

		pnlReportPanel= new JPanel[Buttoncount];
		btnReportButton = new JButton[Buttoncount];



		pnlDataOperation = ES.getDataOperationPanel();


		btnNewProject = new JButton("New Project");
		pnlDataOperation.add(btnNewProject);


		btnOpenProject = new JButton("Open Project");
		pnlDataOperation.add(btnOpenProject);


		pnlDataMenuLeft = ES.getDataMenuLeftPanel();
		//pnlDataMenuLeft.setLayout(new GridLayout(7,1,5,5));

		pnlDataMenuRight = ES.getDataMenuRightPanel();
		//pnlDataMenuRight.setLayout(new GridLayout(7,1,5,5));
		pnlEntryPanel = ES.getAllEntryOptions();
		btnEntryButton = ES.getAllEntryButtons();

		pnlReportPanel = ES.getAllReportOptions();
		btnReportButton = ES.getAllReportButtons();





	    String lblEntryButtonName[] = {"Interface","Listener","Package","Elements"};
		String lblReportButtonName[] = {"Interface","Listener","Package","Elements"};
 		Buttoncount = lblEntryButtonName.length;

		for(int i=0;i<Buttoncount;i++)
		{
			PanelState.enabledComponents(pnlEntryPanel[i]);
			btnEntryButton[i].setLabel(lblEntryButtonName[i]);
			btnEntryButton[i].addActionListener(this);
		}


 		Buttoncount = lblReportButtonName.length;
		for(int i=0;i<Buttoncount;i++)
		{
			PanelState.enabledComponents(pnlReportPanel[i]);
			btnReportButton[i].setLabel(lblReportButtonName[i]);
			btnReportButton[i].addActionListener(this);
		}



		count = ClsProject.getAllRecordsCount();
        System.out.println(count);
        btnNewProject.addActionListener(this);
		btnOpenProject.addActionListener(this);

		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnEntryButton[0])
		{
			FrmInterface temp = new FrmInterface();
		}
		else if(ae.getSource()==btnEntryButton[1])
		{
			//	FrmListener temp = new FrmListener();

		}
		else if(ae.getSource()==btnEntryButton[2])
		{
			FrmPackage temp = new FrmPackage();

		}
		else if(ae.getSource()==btnEntryButton[3])
		{
			FrmElement temp = new FrmElement();
		}
		else if(ae.getSource()==btnReportButton[0])
		{
		RptInterface temp = new RptInterface();
		}
		else if(ae.getSource()==btnReportButton[1])
		{
			RptListener temp = new RptListener();

		}
		else if(ae.getSource()==btnReportButton[2])
		{
			RptPackage temp = new RptPackage();

		}
		else if(ae.getSource()==btnReportButton[3])
		{
			RptElement temp = new RptElement();
		}

		else if(ae.getSource()==btnOpenProject)
		{
			FrmProjectSelection temp = new FrmProjectSelection();

		}
		else if(ae.getSource()==btnNewProject)
		{
			FrmProject A = new FrmProject();
		}

	}
  public static void main(String args[])
   {
        FrmProjectEntry A = new FrmProjectEntry();

   }

}






package entryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import myUtility.PanelState;
import ProjectSetting.*;
import HtmlSetting.*;




public class ProjectSelectionPanel extends JPanel
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
	JPanel pnlDataScroll;

	JPanel pnlDataMenuLeft;
	JPanel pnlDataMenuRight;
	JPanel pnlDataOperation;

	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;
	JLabel lblImg;
	JLabel lblButtonPanelImage;

	int AvailabelOptions=9;

	JPanel pnlEntryOptions[];
	JButton btnEntryButtons[];

	JPanel pnlReportOptions[];
	JButton btnReportButtons[];

	JScrollPane pnlDataMenuLeftScrollPane;








	CreatePanel CP;


	public ProjectSelectionPanel()
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
		pnlSelect.setLayout(new GridLayout(1,1));
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
		pnlButton.setLayout(new GridLayout(1,1));
		pnlButton.setBackground(ApplyColor.clrButtonPanel);
		Dimension size = pnlBottom.getSize();





		CP.addPanelAtLeft(pnlEntry,30);
		pnlData=CP.addPanel();
		pnlEntry.add(pnlData);
		pnlData.setLayout(new BorderLayout());
		pnlData.setBackground(ApplyColor.clrDataPanel);




		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
	   lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);


		lblImg = new JLabel(new ImageIcon("Images\\JavaDeveloper.PNG"));
		pnlSelect.add(lblImg);

		lblButtonPanelImage = new JLabel(new ImageIcon("Images\\ImgButtonPanelFinal.JPG"));
		pnlButton.add(lblButtonPanelImage);

		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);


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
	public void setDefaultOperation()
	{

		//PanelState.disabledComponents(pnlData);
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


	public void setDataInnerPanels()
	{
		CP.addPanelAtBottom(pnlData,7);
		pnlDataOperation=CP.addPanel();
		pnlData.add(pnlDataOperation,BorderLayout.SOUTH);
		pnlDataOperation.setLayout(new GridLayout(1,2));

		CP.addPanelAtLeft(pnlData,10,63,10);
		pnlDataMenuLeft=CP.addPanel();
		pnlDataMenuLeft.setBackground(Color.yellow);
		pnlDataMenuLeft.setLayout(null);


		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int H = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

		pnlDataMenuLeftScrollPane = new JScrollPane(pnlDataMenuLeft,v,H);
		pnlDataMenuLeftScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlDataMenuLeftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		pnlDataMenuLeftScrollPane.setBackground(Color.PINK);
		pnlData.add(pnlDataMenuLeftScrollPane,BorderLayout.WEST);

//		pnlData.add(pnlDataMenuLeft,BorderLayout.WEST);

		pnlEntryOptions=new JPanel[AvailabelOptions];
		btnEntryButtons=new JButton[AvailabelOptions];

		CP.addPanelAtTop(pnlDataMenuLeft,6);
		pnlEntryOptions[0]=CP.addPanel();
		pnlEntryOptions[0].setBackground(Color.red);
		pnlEntryOptions[0].setLayout(null);
		pnlDataMenuLeft.add(pnlEntryOptions[0]);

		btnEntryButtons[0] = new JButton("Option....");
		CP.placeComponent(pnlEntryOptions[0],btnEntryButtons[0]);
		pnlEntryOptions[0].add(btnEntryButtons[0]);
		PanelState.disabledComponents(pnlEntryOptions[0]);
		JPanel temp = pnlEntryOptions[0];
		for(int i=1;i<AvailabelOptions;i++)
		{
			CP.addPanelAfterFromTop(pnlDataMenuLeft,temp,6);
			pnlEntryOptions[i]=CP.addPanel();
			pnlDataMenuLeft.add(pnlEntryOptions[i]);
			pnlEntryOptions[i].setBackground(Color.red);
			pnlEntryOptions[i].setLayout(null);

			btnEntryButtons[i] = new JButton("Option....");
			CP.placeComponent(pnlEntryOptions[i],btnEntryButtons[i]);
			pnlEntryOptions[i].add(btnEntryButtons[i]);
			PanelState.disabledComponents(pnlEntryOptions[i]);
			temp = pnlEntryOptions[i];

		}

		CP.addPanelAtRight(pnlData,10,63,10);
		pnlDataMenuRight=CP.addPanel();
		pnlData.add(pnlDataMenuRight,BorderLayout.EAST);
		pnlDataMenuRight.setLayout(null);


		pnlReportOptions=new JPanel[AvailabelOptions];
		btnReportButtons=new JButton[AvailabelOptions];

		CP.addPanelAtTop(pnlDataMenuRight,6);
		pnlReportOptions[0]=CP.addPanel();
		pnlReportOptions[0].setBackground(Color.red);
		pnlReportOptions[0].setLayout(null);
		pnlDataMenuRight.add(pnlReportOptions[0]);

		btnReportButtons[0] = new JButton("Reports....");
		CP.placeComponent(pnlReportOptions[0],btnReportButtons[0]);
		pnlReportOptions[0].add(btnReportButtons[0]);
		PanelState.disabledComponents(pnlReportOptions[0]);
		 temp = pnlReportOptions[0];
		for(int i=1;i<AvailabelOptions;i++)
		{
			CP.addPanelAfterFromTop(pnlDataMenuRight,temp,6);
			pnlReportOptions[i]=CP.addPanel();
			pnlDataMenuRight.add(pnlReportOptions[i]);
			pnlReportOptions[i].setBackground(Color.red);
			pnlReportOptions[i].setLayout(null);
			btnReportButtons[i] = new JButton("Reports....");
			CP.placeComponent(pnlReportOptions[i],btnReportButtons[i]);
			pnlReportOptions[i].add(btnReportButtons[i]);
			PanelState.disabledComponents(pnlReportOptions[i]);
			temp = pnlReportOptions[i];

		}


	}

	public JPanel getEntryPanel()
	{
		return (pnlEntry);
	}
	public JPanel getDataPanel()
	{
		return (pnlData);
	}
	public JPanel getDataOperationPanel()
	{
		return(pnlDataOperation);
	}

	public JPanel getDataMenuLeftPanel()
	{
		return(pnlDataMenuLeft);
	}
	public JPanel[] getAllEntryOptions()
	{
		return pnlEntryOptions;
	}
	public JPanel[] getAllReportOptions()
	{
		return pnlReportOptions;
	}
	public JButton[] getAllEntryButtons()
	{
		return btnEntryButtons;
	}
	public JButton[] getAllReportButtons()
	{
		return btnReportButtons;
	}
	public JPanel getDataMenuRightPanel()
	{
		return(pnlDataMenuRight);
	}
	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}

   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }





}
