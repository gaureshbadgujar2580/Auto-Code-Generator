import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
//import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmCodeDeveloper extends JFrame implements ActionListener
{
	CodePanelProperties ES;


	JLabel  lblObjectName;
	JLabel  lblObjectText;
	JLabel  lblXValue;
	JLabel  lblYValue;
	JLabel  lblWidth;
	JLabel  lblHeight;
	JLabel  lblElementID;

	JLabel  lblRed;
	JLabel  lblGreen;
	JLabel  lblBlue;
	JLabel  lblObjectNameUpdate;
	JLabel  lblProgrammeHeading;
	JLabel lblPositionComp;
	JLabel lblSetCompColor;


    JTextField txtObjectName;
    JTextField txtObjectText;
    JTextField txtXValue;
    JTextField txtYValue;
    JTextField txtWidth;
    JTextField txtHeight;
    JTextField txtFRed;
    JTextField txtFGreen;
    JTextField txtFBlue;
    JTextField txtBRed;
    JTextField txtBGreen;
    JTextField txtBBlue;

	JPanel  pnlFormDisplay;
	JPanel  pnlCodeDisplay;
	JTextArea txtCodeDisplay;
	JButton btnNew;
	JButton btnSave;
	JButton btnView;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnEdit;
	JButton btnReport;
	JButton btnClose;
	JButton btnApply;
	JButton btnForeColor;
	JButton btnBackColor;
	//JButton btnCreateComp;
	JButton btnCreateUI;
	JPanel pnlCreateUI;


	JPanel  pnlNew;
	JPanel	pnlSave;
	JPanel	pnlView;
	JPanel	pnlUpdate;
	JPanel  pnlDelete;
	JPanel	pnlEdit;
	JPanel	pnlReport;
	JPanel	pnlClose;
	JPanel  pnlApply;
	JPanel  pnlEntry;
	JPanel pnlBack;
	JPanel pnlFore;
	JPanel pnlPropertyChildPanel;
	JPanel pnlPropertyChild2Panel;

	JPanel  pnlSelect;

	JPanel pnlSelectLeft;

	JPanel pnlSelectRight;

	JPanel pnlCreateComponent;
	JButton btnCreateComponent;

	JPanel pnlDisplayCode;
	JButton btnDisplayCode;

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

	JPanel pnlGenrate;
	JButton btnGenrate;

	JPanel pnlExecuteCode;
	JButton btnExecuteCode;

	JPanel pnlGoBack;
	JButton btnGoBack;

	JPanel pnlCloseDisplay;
	JButton btnCloseDisplay;

    Font F2;

    Border border1;

	JPanel pnlProjectUpdate;
    JComboBox cmbProjectUpdate;
	JLabel lblProjectUpdate;

    JPanel pnlElementUpdate;
    JComboBox cmbElementUpdate;
	JLabel lblElementUpdate;

 	JPanel pnlGUIEntryUpdate;
    JComboBox cmbGUIEntryUpdate;
	JLabel lblGUIEntryUpdate;



	JComboBox cmbElementID;


   int vProjectID =  0;
   int vElementID = 0;
   int vProjectIDUpdate =  0;
   int vElementIDUpdate = 0;
   int vGUIEntryID=0;
	String oName="";

	Color clrFore=Color.black;
	Color clrBack=Color.white;


	ClsProject ObjProject;


	FrmCodeDeveloper(ClsProject ObjProject)
	{
		this.ObjProject=ObjProject;
		vProjectID = ObjProject.getProjectID();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,16);


		setSize(screenSize.width,screenSize.height);
		ES = new CodePanelProperties();
		//es = new ReportScreen3();
		add(ES);

		//pnlFormDisplayReport = ES.getDataReportPanel();

		pnlPropertyChildPanel = ES.getSubDataEntryPanel();
		pnlPropertyChild2Panel = ES.getSubDataEntry2Panel();
		pnlSelectRight = ES.getSelectRightPanel();
  		pnlSelectLeft = ES.getSelectLeftPanel();
   	    pnlFormDisplay = ES.getFormDisplayPanel();
   	    pnlCodeDisplay = ES.getCodeDisplayPanel();
   	    txtCodeDisplay = ES.getCodeDisplayTextArea();
		pnlSelect = ES.getSelectPanel();
		pnlEntry = ES.getEntryPanel();
		btnCreateUI = ES.getButtonFirstButton();
		pnlCreateUI = ES.getButtonFirstPanel();
		pnlAddComponent=ES.getAddComponentPanel();
		btnAddComponent=ES.getAddComponentButton();
		pnlViewComponent=ES.getViewComponentPanel();
		btnViewComponent=ES.getViewComponentButton();
		pnlCreateComponent = ES.getCreateComponentPanel();
		btnCreateComponent = ES.getCreateComponentButton();
		pnlDisplayCode = ES.getButtonFivePanel();
		btnDisplayCode = ES.getButtonFiveButton();
		pnlSelectObject=ES.getSelectObjectPanel();
		lblSelectObject=ES.getSelectObjectLabel();
		cmbSelectObject=ES.getSelectObjectComboBox();
		lblSelectObject.setText("Select Object...");
		pnlUpdateComponent=ES.getUpdateComponentPanel();
		btnUpdateComponent=ES.getUpdateComponentButton();
		pnlDeleteComponent=ES.getDeleteComponentPanel();
		btnDeleteComponent=ES.getDeleteComponentButton();
		pnlGoBack=ES.getGoBackPanel();
		btnGoBack=ES.getGoBackButton();
		pnlGenrate=ES.getButtonSixPanel();
		btnGenrate=ES.getButtonSixButton();
		pnlExecuteCode=ES.getButtonSevenPanel();
		btnExecuteCode=ES.getButtonSevenButton();
		pnlCloseDisplay=ES.getButtonFourthPanel();
		btnCloseDisplay=ES.getButtonFourthButton();

		btnCreateComponent.addActionListener(this);
		btnDisplayCode.addActionListener(this);
		btnViewComponent.addActionListener(this);
		btnUpdateComponent.addActionListener(this);
		btnDeleteComponent.addActionListener(this);
		btnGoBack.addActionListener(this);
		btnGenrate.addActionListener(this);
		btnCloseDisplay.addActionListener(this);
		btnExecuteCode.addActionListener(this);


        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("Design Your UI With Simple Manner.. ");


		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 10;
		int h = 30;
		int gap = 5;

		lblElementID = new JLabel("Component ");
		lblElementID.setBounds(10,y,150,h);
		lblElementID.setFont(F2);
		pnlPropertyChildPanel.add(lblElementID);

		cmbElementID = new JComboBox();
		cmbElementID.setBounds(180,y,250,h);
		cmbElementID.setFont(F2);
		pnlPropertyChildPanel.add(cmbElementID);

		y = y+h+gap;

		lblObjectName = new JLabel("Object Name");
		lblObjectName.setBounds(10,y,150,h);
		lblObjectName.setFont(F2);
		pnlPropertyChildPanel.add(lblObjectName);

		txtObjectName = new JTextField();
		txtObjectName.setBounds(180,y,250,h);
		txtObjectName.setFont(F2);
		pnlPropertyChildPanel.add(txtObjectName);

        y = y+h+gap;

		lblObjectText = new JLabel("Displayed Text");
		lblObjectText.setBounds(10,y,150,h);
		lblObjectText.setFont(F2);
		pnlPropertyChildPanel.add(lblObjectText);

		txtObjectText = new JTextField();
		txtObjectText.setBounds(180,y,250,h);
		txtObjectText.setFont(F2);
		pnlPropertyChildPanel.add(txtObjectText);

        y = y+h+gap;

        lblPositionComp = new JLabel("Positioning Component...");
        lblPositionComp.setBounds(10,y,250,h);
		lblPositionComp.setFont(F2);
		pnlPropertyChildPanel.add(lblPositionComp);

		y = y+h+gap;

		lblXValue = new JLabel("X-Pos:");
		lblXValue.setBounds(10,y,150,h);
		lblXValue.setFont(F2);
		pnlPropertyChildPanel.add(lblXValue);

		txtXValue = new JTextField();
		txtXValue.setBounds(110,y,90,h);
		txtXValue.setFont(F2);
		pnlPropertyChildPanel.add(txtXValue);
		txtXValue.addKeyListener(new OnlyNumbers());

		lblYValue = new JLabel("Y-Pos:");
		lblYValue.setBounds(240,y,80,h);
		lblYValue.setFont(F2);
		pnlPropertyChildPanel.add(lblYValue);

		txtYValue = new JTextField();
		txtYValue.setBounds(340,y,90,h);
		txtYValue.setFont(F2);
		pnlPropertyChildPanel.add(txtYValue);
		txtYValue.addKeyListener(new OnlyNumbers());

        y = y+h+gap;

		lblWidth = new JLabel("Width:");
		lblWidth.setBounds(10,y,150,h);
		lblWidth.setFont(F2);
		pnlPropertyChildPanel.add(lblWidth);

		txtWidth = new JTextField();
		txtWidth.setBounds(110,y,90,h);
		txtWidth.setFont(F2);
		pnlPropertyChildPanel.add(txtWidth);
		txtWidth.addKeyListener(new OnlyNumbers());

		lblHeight = new JLabel("Height:");
		lblHeight.setBounds(240,y,80,h);
		lblHeight.setFont(F2);
		pnlPropertyChildPanel.add(lblHeight);

		txtHeight = new JTextField();
		txtHeight.setBounds(340,y,90,h);
		txtHeight.setFont(F2);
		pnlPropertyChildPanel.add(txtHeight);
		txtHeight.addKeyListener(new OnlyNumbers());

		y = y+h+gap;

		lblSetCompColor = new JLabel("Set Components Color...");
		lblSetCompColor.setBounds(10,y,250,h);
		lblSetCompColor.setFont(F2);
		pnlPropertyChildPanel.add(lblSetCompColor);

		y = y+h+gap;

		lblRed = new JLabel("Red");
		lblRed.setBounds(230,y,60,h);
		lblRed.setFont(F2);
		pnlPropertyChildPanel.add(lblRed);

		lblGreen = new JLabel("Green");
		lblGreen.setBounds(300,y,60,h);
		lblGreen.setFont(F2);
		pnlPropertyChildPanel.add(lblGreen);

		lblBlue = new JLabel("Blue");
		lblBlue.setBounds(370,y,60,h);
		lblBlue.setFont(F2);
		pnlPropertyChildPanel.add(lblBlue);

		y = y+h+gap;

		btnForeColor = new JButton("Fore-Color");
		btnForeColor.setBounds(10,y,120,h);
		btnForeColor.setFont(F2);
		pnlPropertyChildPanel.add(btnForeColor);

		btnForeColor.addActionListener(this);

		pnlFore = new JPanel();
		pnlFore.setBounds(150,y,60,h);
		pnlFore.setBackground(Color.black);
		pnlPropertyChildPanel.add(pnlFore);

		txtFRed = new JTextField();
		txtFRed.setBounds(230,y,60,h);
		txtFRed.setFont(F2);
		pnlPropertyChildPanel.add(txtFRed);
		txtFRed.addFocusListener(new NumberLimit(255));

		txtFGreen = new JTextField();
		txtFGreen.setBounds(300,y,60,h);
		txtFGreen.setFont(F2);
		pnlPropertyChildPanel.add(txtFGreen);
		txtFGreen.addFocusListener(new NumberLimit(255));

		txtFBlue = new JTextField();
		txtFBlue.setBounds(370,y,60,h);
		txtFBlue.setFont(F2);
		pnlPropertyChildPanel.add(txtFBlue);
		txtFBlue.addFocusListener(new NumberLimit(255));


		y = y+h+gap;

		btnBackColor = new JButton("Back-Color");
		btnBackColor.setBounds(10,y,120,h);
		btnBackColor.setFont(F2);
		pnlPropertyChildPanel.add(btnBackColor);

		btnBackColor.addActionListener(this);
		pnlBack = new JPanel();
		pnlBack.setBounds(150,y,60,h);
		pnlBack.setBackground(Color.white);
		pnlPropertyChildPanel.add(pnlBack);

		txtBRed = new JTextField();
		txtBRed.setBounds(230,y,60,h);
		txtBRed.setFont(F2);
		pnlPropertyChildPanel.add(txtBRed);
		txtBRed.addFocusListener(new NumberLimit(255));

		txtBGreen = new JTextField();
		txtBGreen.setBounds(300,y,60,h);
		txtBGreen.setFont(F2);
		pnlPropertyChildPanel.add(txtBGreen);
		txtBGreen.addFocusListener(new NumberLimit(255));

		txtBBlue = new JTextField();
		txtBBlue.setBounds(370,y,60,h);
		txtBBlue.setFont(F2);
		pnlPropertyChildPanel.add(txtBBlue);
		txtBBlue.addFocusListener(new NumberLimit(255));

		y = y+h+gap;

		ES.UIAreaSetting(700,500);

		addElementRecords(cmbElementID);


		PanelState.disabledComponents(pnlPropertyChildPanel);
		PanelState.disabledComponents(pnlPropertyChild2Panel);
		PanelState.disabledComponents(pnlSelectRight);
		PanelState.enabledComponents(pnlCreateUI);
		PanelState.enabledComponents(pnlGenrate);
		//PanelState.disabledComponents(pnlFormDisplay);
		PanelState.disabledComponents(pnlEntry);
		PanelState.disabledComponents(pnlExecuteCode);
		//PanelState.disabledComponents();



		btnCreateUI.addActionListener(this);
		btnAddComponent.addActionListener(this);

		show();
	}


	void showGUI()
	{
		pnlFormDisplay.removeAll();
		pnlFormDisplay.revalidate();
		pnlFormDisplay.repaint();

		ClsGUIEntry temps[] = ClsGUIEntry.getAllGUIEntryInformation(vProjectID);
		for(ClsGUIEntry temp:temps)
		{
			String objName=ClsElement.getElementNameFromID(temp.getElementID());
			if(objName.equalsIgnoreCase("JLabel"))
			{
				pnlFormDisplay.add(getNewLabel(temp));
			}
			else if(objName.equalsIgnoreCase("JTextField"))
			{
				pnlFormDisplay.add(getNewTextField(temp));
			}
			else if(objName.equalsIgnoreCase("JCheckBox"))
			{
				pnlFormDisplay.add(getNewCheckBox(temp));
			}
			else if(objName.equalsIgnoreCase("JRadioButton"))
			{
				pnlFormDisplay.add(getNewRadioButton(temp));
			}
			else if(objName.equalsIgnoreCase("JButton"))
			{
				pnlFormDisplay.add(getNewButton(temp));
			}
		}
	}

	JLabel getNewLabel(ClsGUIEntry A)
	{
		JLabel L1 = new JLabel(A.getObjectText());
		L1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		L1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		L1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		L1.setOpaque(true);
		return(L1);
	}
	JTextField getNewTextField(ClsGUIEntry A)
	{
		JTextField T1 = new JTextField(A.getObjectText());
		T1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		T1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		T1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		T1.setOpaque(true);
		return(T1);
	}

	JCheckBox getNewCheckBox(ClsGUIEntry A)
	{
		JCheckBox C1 = new JCheckBox(A.getObjectText());
		C1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		C1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		C1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		C1.setOpaque(true);
		return(C1);
	}


	JRadioButton getNewRadioButton(ClsGUIEntry A)
	{
		JRadioButton R1 = new JRadioButton(A.getObjectText());
		R1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		R1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		R1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		R1.setOpaque(true);
		return(R1);
	}


	JButton getNewButton(ClsGUIEntry A)
	{
		JButton B1 = new JButton(A.getObjectText());
		B1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		B1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		B1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		B1.setOpaque(true);
		return(B1);
	}


	JComboBox getNewComboBox(ClsGUIEntry A)
	{
		JComboBox Cmb1 = new JComboBox();
		Cmb1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		Cmb1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		Cmb1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		Cmb1.setOpaque(true);
		return(Cmb1);
	}

	JList getNewList(ClsGUIEntry A)
	{
		JList L1 = new JList();
		L1.setBounds(A.getXValue(),A.getYValue(),A.getWidth(),A.getHeight());
		L1.setForeground(new Color(A.getFRed(),A.getFGreen(),A.getFBlue()));
		L1.setBackground(new Color(A.getBRed(),A.getBGreen(),A.getBBlue()));
		L1.setOpaque(true);
		return(L1);
	}


	public void initUI()
	{
		cmbElementID.setSelectedIndex(0);
		txtObjectName.setText("");
		txtObjectText.setText("");
		txtXValue.setText("0");
		txtYValue.setText("0");
		txtWidth.setText("0");
		txtHeight.setText("0");
		txtFRed.setText("0");
		txtFGreen.setText("0");
		txtFBlue.setText("0");
		txtBRed.setText("0");
		txtBGreen.setText("0");
		txtBBlue.setText("0");
		pnlFore.setBackground(new Color(0,0,0));
		pnlBack.setBackground(new Color(0,0,0));
	}

	public void writeUI(ClsGUIEntry temp)
	{
		vElementID = temp.getElementID();
		ClsElement temp2 = ClsElement.getElementInformation(vElementID);
		cmbElementID.setSelectedItem(temp2.getElementName());

		txtObjectName.setText(temp.getObjectName());
		txtObjectText.setText(temp.getObjectText());
		txtXValue.setText(String.valueOf(temp.getXValue()));
		txtYValue.setText(String.valueOf(temp.getYValue()));
		txtWidth.setText(String.valueOf(temp.getWidth()));
		txtHeight.setText(String.valueOf(temp.getHeight()));

		vProjectID=temp.getProjectID();
		ClsProject ObjProject = ClsProject.getProjectInformation(vProjectID);



		txtFRed.setText(String.valueOf(temp.getFRed()));
		txtFGreen.setText(String.valueOf(temp.getFGreen()));
		txtFBlue.setText(String.valueOf(temp.getFBlue()));
		txtBRed.setText(String.valueOf(temp.getBRed()));
		txtBGreen.setText(String.valueOf(temp.getBGreen()));
		txtBBlue.setText(String.valueOf(temp.getBBlue()));

		pnlFore.setBackground(new Color(temp.getFRed(),temp.getFGreen(),temp.getFBlue()));
		pnlBack.setBackground(new Color(temp.getBRed(),temp.getBGreen(),temp.getBBlue()));
	}

	ClsGUIEntry readUI()
	{
		ClsGUIEntry temp = new ClsGUIEntry();

		temp.setGUIEntryID(vGUIEntryID);
		temp.setObjectName(txtObjectName.getText());
		temp.setObjectText(txtObjectText.getText());
		temp.setXValue(Integer.parseInt(txtXValue.getText()));
		temp.setYValue(Integer.parseInt(txtYValue.getText()));
		temp.setWidth(Integer.parseInt(txtWidth.getText()));
		temp.setHeight(Integer.parseInt(txtHeight.getText()));
		temp.setElementID(vElementID);
		temp.setProjectID(vProjectID);
		temp.setFRed(Integer.parseInt(txtFRed.getText()));
		temp.setFGreen(Integer.parseInt(txtFGreen.getText()));
		temp.setFBlue(Integer.parseInt(txtFBlue.getText()));
		temp.setBRed(Integer.parseInt(txtBRed.getText()));
		temp.setBGreen(Integer.parseInt(txtBGreen.getText()));
		temp.setBBlue(Integer.parseInt(txtBBlue.getText()));
		return(temp);
	}

	public void addElementRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsElement.addElementRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
	/*public void addProjectRecords(JComboBox cmbProcess,int mElementID)
	{
		cmbProcess.removeActionListener(this);
		ClsProject.addProjectRecords(cmbProcess,mElementID);
		cmbProcess.addActionListener(this);
	}*/
	public void addGUIEntryRecords(JComboBox cmbProcess,int mProjectID,int mElementID)
	{
		cmbProcess.removeActionListener(this);
		ClsGUIEntry.addGUIEntryRecords(cmbProcess,mProjectID,mElementID);
		cmbProcess.addActionListener(this);
	}

	public void addGUIEntryRecords(JComboBox cmbProcess,int mProjectID)
	{
		cmbProcess.removeActionListener(this);
		ClsGUIEntry.addGUIEntryRecords(cmbProcess,mProjectID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnCreateUI)
		{
			PanelState.enabledComponents(pnlAddComponent);
			PanelState.enabledComponents(pnlViewComponent);
			showGUI();
		}
		else if(ae.getSource()==btnAddComponent)
		{
			PanelState.enabledComponents(pnlPropertyChildPanel);
			PanelState.enabledComponents(pnlPropertyChild2Panel);
		}
		else if(ae.getSource()==btnCreateComponent)
		{
			 if(cmbElementID.getSelectedIndex()<=0)
			 {
				JOptionPane.showMessageDialog(null,"Please select any Element...");
				cmbElementID.requestFocus();
			 }
			 else if((txtObjectName.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Object Name should not be blank...");
				txtObjectName.requestFocus();
			 }
             else if((txtObjectText.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Object Text should not be blank...");
				txtObjectText.requestFocus();
			 }
             else if((txtXValue.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Please Specify X Position...");
				txtXValue.requestFocus();
			 }
             else if((txtYValue.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Please Specify Y Position...");
				txtYValue.requestFocus();
			 }
             else if((txtWidth.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Please Specify Width Position...");
				txtWidth.requestFocus();
			 }
             else if((txtHeight.getText()).equals(""))
			 {
				JOptionPane.showMessageDialog(null,"Please Specify Height Position...");
				txtHeight.requestFocus();
			 }
			 else
			 {
				ClsGUIEntry A = readUI();
			   	ClsGUIEntry.showGUIEntry(A);
			   	ClsGUIEntry.addNewRecord(A);
			   	initUI();
				PanelState.disabledComponents(pnlPropertyChildPanel);
				PanelState.disabledComponents(pnlPropertyChild2Panel);
				PanelState.enabledComponents(pnlViewComponent);
			   	showGUI();
			}

		}

		else if(ae.getSource()==cmbElementID)
		{
				if(cmbElementID.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"Please select proper Element...");
				}
				else
				{
					String mElementName=(String)cmbElementID.getSelectedItem();
					vElementID=ClsElement.getElementIDFromName(mElementName);
					ClsElement temp=ClsElement.getElementInformation(vElementID);
					int tEle=ClsGUIEntry.getAllRecordsCount(vProjectID,vElementID);
					tEle++;
					String oName="";
					oName=temp.getElementAbbrivation()+String.valueOf(tEle);
					if(ClsGUIEntry.validateObjectName(oName,vProjectID))
					{
						tEle=0;
						while(ClsGUIEntry.validateObjectName(oName,vProjectID))
						{
							tEle++;
							oName=temp.getElementAbbrivation()+String.valueOf(tEle);
						}
					}
					txtObjectName.setText(oName);
					txtObjectText.requestFocus();
				}
		}
		else if(ae.getSource()==btnForeColor)
		{
				Color initialcolor=clrFore;
				clrFore=JColorChooser.showDialog(this,"Select a color",initialcolor);
				int rf=clrFore.getRed();
				int gf=clrFore.getGreen();
				int bf=clrFore.getBlue();
				txtFRed.setText(String.valueOf(rf));
				txtFGreen.setText(String.valueOf(gf));
				txtFBlue.setText(String.valueOf(bf));
				pnlFore.setBackground(clrFore);
		}
		else if(ae.getSource()==btnBackColor)
		{
				Color initialcolor=clrBack;
				clrBack=JColorChooser.showDialog(this,"Select a color",initialcolor);
				int rb=clrBack.getRed();
				int gb=clrBack.getGreen();
				int bb=clrBack.getBlue();
				txtBRed.setText(String.valueOf(rb));
				txtBGreen.setText(String.valueOf(gb));
				txtBBlue.setText(String.valueOf(bb));
				pnlBack.setBackground(clrBack);
		}
		else if(ae.getSource()==btnViewComponent)
		{
			PanelState.disabledComponents(pnlAddComponent);
			PanelState.disabledComponents(pnlViewComponent);
			PanelState.enabledComponents(pnlSelectObject);
			addGUIEntryRecords(cmbSelectObject,vProjectID);
		}
		else if(ae.getSource()==cmbSelectObject)
		{
			 if(cmbSelectObject.getSelectedIndex()<=0)
			 {
				JOptionPane.showMessageDialog(null,"Please select any Object ...");
				cmbElementID.requestFocus();
			 }
			 else
			 {

				vGUIEntryID=ClsGUIEntry.getGUIEntryIDFromName((String )cmbSelectObject.getSelectedItem(),vProjectID);

				ClsGUIEntry temp=ClsGUIEntry.getGUIEntryInformation(vGUIEntryID);
				writeUI(temp);

				PanelState.enabledComponents(pnlUpdateComponent);
				PanelState.enabledComponents(pnlDeleteComponent);
				PanelState.enabledComponents(pnlGoBack);
				PanelState.enabledComponents(pnlPropertyChildPanel);
				PanelState.disabledComponents(pnlAddComponent);
				PanelState.disabledComponents(pnlViewComponent);

			 }

		}
		else if(ae.getSource()==btnUpdateComponent)
		{
			if(validateGUI())
			{
				ClsGUIEntry ref=readUI();
				//ClsGUIEntry.showGUIEntry(ref);
				ClsGUIEntry.updateRecord(ref);
				showGUI();
			}
		}
		else if(ae.getSource()==btnDeleteComponent)
		{
			if(validateGUI())
			{
				ClsGUIEntry ref=readUI();
				//ClsGUIEntry.showGUIEntry(ref);
				ClsGUIEntry.deleteRecord(ref);
				showGUI();
				initUI();
				PanelState.disabledComponents(pnlUpdateComponent);
				PanelState.disabledComponents(pnlDeleteComponent);
				PanelState.disabledComponents(pnlGoBack);
				PanelState.disabledComponents(pnlPropertyChildPanel);
			}
		}
		else if(ae.getSource()==btnGoBack)
		{
			PanelState.disabledComponents(pnlUpdateComponent);
			PanelState.disabledComponents(pnlDeleteComponent);
			PanelState.disabledComponents(pnlPropertyChildPanel);
			PanelState.enabledComponents(pnlAddComponent);
			PanelState.enabledComponents(pnlViewComponent);
			PanelState.disabledComponents(pnlGoBack);
			PanelState.disabledComponents(pnlSelectObject);
			initUI();
		}
		else if(ae.getSource()==btnGenrate)
		{
			writeResult(ObjProject.getProjectName()+".java");
		//	FrmDisplayCode obj1=new FrmDisplayCode(ObjProject);
			PanelState.disabledComponents(pnlCreateUI);
			PanelState.disabledComponents(pnlGenrate);
			PanelState.enabledComponents(pnlDisplayCode);
			PanelState.enabledComponents(pnlExecuteCode);



		}
		else if(ae.getSource()==btnDisplayCode)
		{
			PanelState.hideComponents(pnlFormDisplay);
			PanelState.visibleComponents(pnlCodeDisplay);
			 PanelState.enabledComponents(pnlCloseDisplay);
			 PanelState.enabledComponents(pnlExecuteCode);
			 PanelState.enabledComponents(pnlDisplayCode);
			 PanelState.enabledComponents(pnlGenrate);


			txtCodeDisplay.setText("");
    		try
    		{
				String filename=ObjProject.getProjectName()+".java";
				FileInputStream fis = new FileInputStream(filename);
				int b;
				while  ((b=fis.read()) != -1)
					txtCodeDisplay.append(String.valueOf((char)b));
				fis.close();
			}
			catch(FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(this,"File Not Found ...... ");
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this,"Something Going Wrong ...... ");
			}

		}
		else if(ae.getSource()==btnCloseDisplay)
		{
		    PanelState.disabledComponents(pnlDisplayCode);
		    PanelState.disabledComponents(pnlCloseDisplay);
        	PanelState.disabledComponents(pnlExecuteCode);
			PanelState.enabledComponents(pnlCreateUI);
			PanelState.enabledComponents(pnlGenrate);

		}

		else if(ae.getSource()==btnExecuteCode)
  		{
			System.out.println("one");
						System.out.println("two :=  "+ObjProject.getProjectName());


			try
			{
		    	Class currentClass = Class.forName(ObjProject.getProjectName());
		    	currentClass.newInstance();

			}
			catch(ClassNotFoundException e)
			{

			}
			catch(InstantiationException e)
			{
			}
			catch(IllegalAccessException e)
			{

			}
		}
		/*else if(ae.getSource()==cmbProjectUpdate)
		{

			String mProjectName = (String)cmbProjectUpdate.getSelectedItem();
			vProjectIDUpdate = ClsProject.getProjectIDFromName(mProjectName);

			addGUIEntryRecords(cmbGUIEntryUpdate,vProjectIDUpdate,vElementIDUpdate);
			//addGUIEntryRecords(cmbGUIEntryUpdate,mProjectID);
			PanelState.enabledComponents(pnlGUIEntryUpdate);
			//PanelProject.enabledComponents(pnlApply);

		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);

			txtObjectName.requestFocus();
			txtObjectName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsGUIEntry temp = readUI();
			ClsGUIEntry.deleteRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
			initUI();
		}
		else if(ae.getSource()==btnClose)
		{
			 bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
			initUI();
		}
		/*else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mObjectName = (String)cmbGUIEntryUpdate.getSelectedItem();
			int mGUIEntryID = ClsGUIEntry.getGUIEntryIDFromName(mObjectName);
			ClsGUIEntry temp = ClsGUIEntry.getGUIEntryInformation(mGUIEntryID);
			writeUI(temp);

		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			//PanelProject.hideComponents(pnlFormDisplay);
			//PanelProject.visibleComponents(pnlFormDisplayReport);
			//createReport();
			//setColumnsData();
		}*/
   }



	boolean validateGUI()
	{
		boolean status=false;
		if((txtObjectName.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Object Name should not be blank...");
			txtObjectName.requestFocus();
		}
		else if((txtObjectText.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Object Text should not be blank...");
			txtObjectText.requestFocus();
		}
		else if((txtXValue.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Specify X Position...");
			txtXValue.requestFocus();
		}
		else if((txtYValue.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Specify Y Position...");
			txtYValue.requestFocus();
		}
		else if((txtWidth.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Specify Width Position...");
			txtWidth.requestFocus();
		}
		else if((txtHeight.getText()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Specify Height Position...");
			txtHeight.requestFocus();
		}
		else
		{
			status=true;
		}
		return(status);
	}

/*	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
	}
	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("GUIEntryID");
		Rcols+=tool.addNewColumn("ObjectName");
		Rcols+=tool.addNewColumn("ObjectText");
		Rcols+=tool.addNewColumn("XValue");
		Rcols+=tool.addNewColumn("YValue");
		Rcols+=tool.addNewColumn("Width");
		Rcols+=tool.addNewColumn("Height");
		Rcols+=tool.addNewColumn("ElementID");
		Rcols+=tool.addNewColumn("ProjectID");
		Rcols+=tool.addNewColumn("FRed");
		Rcols+=tool.addNewColumn("FGreen");
		Rcols+=tool.addNewColumn("FBlue");
		Rcols+=tool.addNewColumn("BRed");
		Rcols+=tool.addNewColumn("BGreen");
		Rcols+=tool.addNewColumn("BBlue");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(7,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(8,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(9,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(10,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(11,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(12,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(13,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(14,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("GUIEntryID",30);
		tool.setColumnWidth("ObjectName",80);
		tool.setColumnWidth("ObjectText",80);
		tool.setColumnWidth("XValue",40);
		tool.setColumnWidth("YValue",40);
		tool.setColumnWidth("Width",40);
		tool.setColumnWidth("Height",40);
		tool.setColumnWidth("ElementID",40);
		tool.setColumnWidth("ProjectID",40);
		tool.setColumnWidth("FRed",40);
		tool.setColumnWidth("FGreen",40);
		tool.setColumnWidth("FBlue",40);
		tool.setColumnWidth("BRed",40);
		tool.setColumnWidth("BGreen",40);
		tool.setColumnWidth("BBlue",40);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsGUIEntry Data[]=ClsGUIEntry.getAllGUIEntryInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getObjectName();
			Objectdata[2]=Data[i].getObjectText();
			Objectdata[3]=Data[i].getXValue();
			Objectdata[4]=Data[i].getYValue();
			Objectdata[5]=Data[i].getWidth();
			Objectdata[6]=Data[i].getHeight();
			Objectdata[7]=Data[i].getElementID();
			Objectdata[8]=Data[i].getProjectID();
			Objectdata[9]=Data[i].getFRed();
			Objectdata[10]=Data[i].getFGreen();
			Objectdata[11]=Data[i].getFBlue();
			Objectdata[12]=Data[i].getBRed();
			Objectdata[13]=Data[i].getBGreen();
			Objectdata[14]=Data[i].getBBlue();

			tool.addNewRow(Objectdata);
		}
	}*/

	public void writeResult(String writeFileName)
    {
		//String text="import java.awt.*";
		String text="";
        try
        {
        	FileWriter fileWriter = new FileWriter(writeFileName);
        	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        	String Pkgs[]=ClsPackage.getAllPackageRecords();

        	for(String X:Pkgs)
        	{

				 text="import "+X+".*;";

       			 bufferedWriter.write(text);
        		 bufferedWriter.newLine();
	        // Always close files.
			}

			text="public class "+ObjProject.getProjectName()+" extends JFrame";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text="{";
			bufferedWriter.write(text);
			bufferedWriter.newLine();


			//Create Referances

        	ClsGUIEntry GUIdata[]=ClsGUIEntry.getAllGUIEntryInformation(ObjProject.getProjectID());

			for(ClsGUIEntry SingleEle:GUIdata)
			{
					String EleName =ClsElement.getElementNameFromID(SingleEle.getElementID());

					text=getIndents(1);
					bufferedWriter.write(text);
					text=EleName +" "+SingleEle.getObjectName()+";";
					bufferedWriter.write(text);
					bufferedWriter.newLine();
			}

			text=getIndents(1);
			bufferedWriter.write(text);


			//Add Constructor
			text=ObjProject.getProjectName()+"()";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(1);
			bufferedWriter.write(text);

			text="{";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

				//Object Instantiation
				text=getIndents(2);
				bufferedWriter.write(text);

				text="setLayout(null);";
				bufferedWriter.write(text);
				bufferedWriter.newLine();
				for(ClsGUIEntry SingleEle:GUIdata)
				{
					String EleName =ClsElement.getElementNameFromID(SingleEle.getElementID());

					text=getIndents(2);
					bufferedWriter.write(text);

					if((EleName.equals("JComboBox")) || (EleName.equals("JList")))
						text=SingleEle.getObjectName()+" = new " + EleName +"();";
					else
						text=SingleEle.getObjectName()+" = new " + EleName +"(\""+SingleEle.getObjectText()+"\");";
					bufferedWriter.write(text);
					bufferedWriter.newLine();
					text=getIndents(2);
					bufferedWriter.write(text);
					text=SingleEle.getObjectName()+".setBounds(" +
													String.valueOf(SingleEle.getXValue())+","+
													String.valueOf(SingleEle.getYValue())+","+
													String.valueOf(SingleEle.getWidth())+","+
													String.valueOf(SingleEle.getHeight())+
													");";
					bufferedWriter.write(text);
					bufferedWriter.newLine();
					text=getIndents(2);
					bufferedWriter.write(text);
					text="add("+SingleEle.getObjectName()+");";
					bufferedWriter.write(text);
					bufferedWriter.newLine();

					text=getIndents(2);
					bufferedWriter.write(text);
					text=SingleEle.getObjectName()+".setForeground(new Color("+
													String.valueOf(SingleEle.getFRed())+","+
													String.valueOf(SingleEle.getFGreen())+","+
													String.valueOf(SingleEle.getFBlue())+
													"));";
					bufferedWriter.write(text);
					bufferedWriter.newLine();

					text=getIndents(2);
					bufferedWriter.write(text);
					text=SingleEle.getObjectName()+".setBackground(new Color("+
													String.valueOf(SingleEle.getBRed())+","+
													String.valueOf(SingleEle.getBGreen())+","+
													String.valueOf(SingleEle.getBBlue())+
													"));";
					bufferedWriter.write(text);
					bufferedWriter.newLine();


				}



			text=getIndents(1);
			bufferedWriter.write(text);

			text="}";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			//Add Mainn Method
			text=getIndents(1);
			bufferedWriter.write(text);

			text="public static void main(String args[])";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(1);
			bufferedWriter.write(text);

			text="{";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(2);
			bufferedWriter.write(text);

			String objName=getObjectName();
			text=ObjProject.getProjectName()+ objName +" =new "+ObjProject.getProjectName()+"();";
			bufferedWriter.write(text);
			bufferedWriter.newLine();



			text=getIndents(2);
			bufferedWriter.write(text);

			text=objName +".setLocation("+String.valueOf(ObjProject.getXPos())+","+String.valueOf(ObjProject.getYPos())+");";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(2);
			bufferedWriter.write(text);

			text=objName +".setSize("+String.valueOf(ObjProject.getWidth())+","+String.valueOf(ObjProject.getHeight())+");";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(2);
			bufferedWriter.write(text);

			text=objName +".setTitle(\""+ObjProject.getProjectName()+".java\");";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text=getIndents(2);
			bufferedWriter.write(text);

			text=objName +".setVisible(true);";
			bufferedWriter.write(text);
			bufferedWriter.newLine();


			text=getIndents(1);
			bufferedWriter.write(text);

			text="}";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			text="}";
			bufferedWriter.write(text);
			bufferedWriter.newLine();

        	bufferedWriter.close();

        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ writeFileName + "'");}
    }

    String getIndents(int no)
    {
		String str="";
		for(int i=1;i<=no;i++)
		{
			str=str+"    ";
		}
		return(str);
	}
	String getObjectName()
	{
		String str="";
		str=" obj"+ObjProject.getProjectName();
		return(str);
	}
    public void writetofile()
    {
		String yourstring="Hello\n";
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter( "Gopal.txt"));
		    for(int c=1;c<=10;c++)
		    {
		    	writer.write( yourstring);
			}
		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}

	}

	public static void main(String args[])
	{
		ClsProject temp = ClsProject.getProjectInformation(1);
		FrmCodeDeveloper A = new FrmCodeDeveloper(temp);
	}
}