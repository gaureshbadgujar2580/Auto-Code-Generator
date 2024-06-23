import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import AutoCodereportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmProject extends JFrame implements ActionListener
{
	//int w = 3020;
    EntryScreen ES;


	JLabel  lblProjectID;
	JLabel  lblProjectName;
	JLabel  lblXPos;
	JLabel  lblYPos;
	JLabel  lblWidth;
	JLabel  lblHeight;


	JLabel  lblProjectNameUpdate;
	JLabel  lblProjectHeading;
	JLabel  lblProgrammeHeading;

    JTextField txtProjectID;
    JTextField txtProjectName;
	JTextField  txtXPos;
	JTextField  txtYPos;
	JTextField  txtWidth;
	JTextField  txtHeight;

	JPanel pnlData;
	JPanel pnlSelect;
	JButton btnNew;
	JButton btnSave;
	JButton btnView;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnEdit;
	JButton btnReport;
	JButton btnClose;


	JButton btnApply;

	JPanel  pnlNew;
	JPanel	pnlSave;
	JPanel	pnlView;
	JPanel	pnlUpdate;
	JPanel  pnlDelete;
	JPanel	pnlEdit;
	JPanel	pnlReport;
	JPanel	pnlClose;
	JPanel  pnlApply;
	JPanel pnlEntry;

    JComboBox cmbProjectUpdate;
	JPanel pnlProjectUpdate;
	JLabel lblProjectUpdate;

    ReportTool tool;
	ButtonState bst;
	ClsButtonManagement cbm;
	int Rcols;

	JPanel pnlDataReport;


    Font F2;

    Border border1;


	FrmProject()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen();
		add(ES);




		pnlData = ES.getDataPanel();
		pnlSelect = ES.getSelectPanel();
		pnlNew = ES.getNewPanel();
		pnlSave = ES.getSavePanel();
		pnlView = ES.getViewPanel();
		pnlEdit = ES.getEditPanel();
		pnlUpdate = ES.getUpdatePanel();
		pnlDelete = ES.getDeletePanel();
		pnlClose = ES.getClosePanel();
		pnlReport = ES.getReportPanel();
		pnlApply = ES.getApplyPanel();
		pnlDataReport = ES.getDataReportPanel();
		pnlEntry = ES.getEntryPanel();

		btnNew = ES.getNewButton();
		btnSave = ES.getSaveButton();
		btnUpdate = ES.getUpdateButton();
		btnView = ES.getViewButton();
		btnEdit = ES.getEditButton();
		btnDelete = ES.getDeleteButton();
		btnClose = ES.getCloseButton();
		btnReport = ES.getReportButton();

		pnlProjectUpdate = ES.getFirstComboPanel();
		cmbProjectUpdate = ES.getFirstComboBox();
		lblProjectUpdate = ES.getFirstComboLabel();
		lblProjectUpdate.setText("Select Project...");


		btnApply = ES.getApplyButton();
//		lblProjectHeading=ES.getProjectHeading();
		lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("New Project Information...");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblProjectID = new JLabel("ProjectID");
		lblProjectID.setBounds(10,y,150,h);
		lblProjectID.setFont(F2);
		pnlData.add(lblProjectID);

		txtProjectID = new JTextField();
		//txtProjectID.setBackground(Color.decode("#FFDAB9"));
		txtProjectID.setBounds(160,y,100,h);
		txtProjectID.setFont(F2);
		pnlData.add(txtProjectID);

		y = y+h+gap;
		lblProjectName = new JLabel("Project Name");
		lblProjectName.setBounds(10,y,150,h);
		lblProjectName.setFont(F2);
		pnlData.add(lblProjectName);

		txtProjectName = new JTextField();
		txtProjectName.setBounds(160,y,250,h);
		txtProjectName.setFont(F2);
		pnlData.add(txtProjectName);

		y = y+h+gap;

		lblXPos = new JLabel("XPos");
		lblXPos.setBounds(10,y,150,h);
		lblXPos.setFont(F2);
		pnlData.add(lblXPos);

		txtXPos = new JTextField();
		txtXPos.setBounds(160,y,100,h);
		txtXPos.setFont(F2);
		pnlData.add(txtXPos);

		y = y+h+gap;
		lblYPos = new JLabel("YPos");
		lblYPos.setBounds(10,y,150,h);
		lblYPos.setFont(F2);
		pnlData.add(lblYPos);

		txtYPos = new JTextField();
		txtYPos.setBounds(160,y,100,h);
		txtYPos.setFont(F2);
		pnlData.add(txtYPos);

		y = y+h+gap;
		lblWidth = new JLabel("Width");
		lblWidth.setBounds(10,y,150,h);
		lblWidth.setFont(F2);
		pnlData.add(lblWidth);

		txtWidth = new JTextField();
		txtWidth.setBounds(160,y,100,h);
		txtWidth.setFont(F2);
		pnlData.add(txtWidth);

		y = y+h+gap;
		lblHeight = new JLabel("Height");
		lblHeight.setBounds(10,y,150,h);
		lblHeight.setFont(F2);
		pnlData.add(lblHeight);

		txtHeight = new JTextField();
		txtHeight.setBounds(160,y,100,h);
		txtHeight.setFont(F2);
		pnlData.add(txtHeight);

		tool=new ReportTool(800,400);
		tool.setBounds(10,10,900,500);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);

		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnView.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);
		btnApply.addActionListener(this);
		btnReport.addActionListener(this);


		//ES.setDefaultOperation();
		ES.UIAreaSetting(450,400);
        ES.ReportAreaSetting(1000,600);

		createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

		show();

	}

	void automateButtons()
	{
		cbm.manageDataPanel(pnlData);
		cbm.manageEntryPanel(pnlEntry);
		cbm.manageDataReportPanel(pnlDataReport);
		cbm.manageNewPanel(pnlNew);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlClose);
		cbm.manageReportPanel(pnlReport);
		cbm.manageApplyPanel(pnlApply);
		cbm.manageFirstPanel(pnlProjectUpdate);
		cbm.manageFirstLabel(lblProjectUpdate);
		cbm.manageFirstCombo(cmbProjectUpdate);
	}

	public void initUI()
	{
	   txtProjectID.setText("0");
	   txtProjectName.setText("");
	   txtXPos.setText("0");
	   txtYPos.setText("0");
	   txtWidth.setText("0");
	   txtHeight.setText("0");

	}


	public void addProjectRecords(JComboBox cmbProcess)
	{
	   cmbProcess.removeActionListener(this);
	   ClsProject.addProjectRecords(cmbProcess);
	   cmbProcess.addActionListener(this);
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

			txtProjectID.setText("0");
			txtProjectName.requestFocus();
		}
		else if(ae.getSource()==btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);

			ClsProject temp = readUI();
			ClsProject.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			ClsProject temp = readUI();
			ClsProject.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();
		}
		else if(ae.getSource()==btnView)
		{

			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addProjectRecords(cmbProjectUpdate);
			PanelState.enabledComponents(pnlProjectUpdate);
		}
		else if(ae.getSource()==cmbProjectUpdate)
		{
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);

			txtProjectName.requestFocus();
			txtProjectName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsProject temp = readUI();
			ClsProject.deleteRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
			initUI();
		}
		else if(ae.getSource()==btnClose)
		{
			bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);

			initUI();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mProjectName = (String)cmbProjectUpdate.getSelectedItem();
			int mProjectID = ClsProject.getProjectIDFromName(mProjectName);
			ClsProject temp = ClsProject.getProjectInformation(mProjectID);
			writeUI(temp);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();
		}
	}


	public void writeUI(ClsProject temp)
	{
		txtProjectID.setText(String.valueOf(temp.getProjectID()));
		txtProjectName.setText(temp.getProjectName());
		txtXPos.setText(String.valueOf(temp.getXPos()));
		txtYPos.setText(String.valueOf(temp.getYPos()));
		txtWidth.setText(String.valueOf(temp.getWidth()));
		txtHeight.setText(String.valueOf(temp.getHeight()));
	}

	ClsProject readUI()
	{
		ClsProject temp = new ClsProject();
		temp.setProjectID(Integer.parseInt(txtProjectID.getText()));
		temp.setProjectName(txtProjectName.getText());
		temp.setXPos(Integer.parseInt(txtXPos.getText()));
		temp.setYPos(Integer.parseInt(txtYPos.getText()));
		temp.setWidth(Integer.parseInt(txtWidth.getText()));
		temp.setHeight(Integer.parseInt(txtHeight.getText()));
		return(temp);
	}

	void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
	}
	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("ProjectID");
		Rcols+=tool.addNewColumn("ProjectName");
		Rcols+=tool.addNewColumn("XPos");
		Rcols+=tool.addNewColumn("YPos");
		Rcols+=tool.addNewColumn("Width");
		Rcols+=tool.addNewColumn("Height");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("ProjectID",100);
		tool.setColumnWidth("ProjectName",200);
		tool.setColumnWidth("XPos",100);
		tool.setColumnWidth("YPos",100);
		tool.setColumnWidth("Width",100);
		tool.setColumnWidth("Height",100);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsProject Data[]=ClsProject.getAllProjectInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getProjectName();
			Objectdata[2]=Data[i].getXPos();
			Objectdata[3]=Data[i].getYPos();
			Objectdata[4]=Data[i].getWidth();
			Objectdata[5]=Data[i].getHeight();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmProject A = new FrmProject();
   }

}