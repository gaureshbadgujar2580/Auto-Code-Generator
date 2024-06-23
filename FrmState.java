import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;



class FrmState extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen2 ES;

	JLabel lblStateID;
	JLabel  lblStateName;
	JLabel  lblCountryID;
	JLabel  lblStateNameUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtStateID;
    JTextField txtStateName;

	JPanel  pnlData;
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
	JPanel  pnlSelect;
	JPanel  pnlEntry;


    Font F2;

    Border border1;

	JPanel pnlStateUpdate;
    JComboBox cmbStateUpdate;
	JLabel lblStateUpdate;

    JPanel pnlCountryUpdate;
    JComboBox cmbCountryUpdate;
	JLabel lblCountryUpdate;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement2 cbm;

	int Rcols;
	JPanel pnlDataReport;

	JComboBox cmbCountryID;
    int vCountryID = 0;

	FrmState()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen2();
		add(ES);

		pnlDataReport = ES.getDataReportPanel();
	    pnlData = ES.getDataPanel();
	    pnlNew = ES.getNewPanel();
	    pnlSave = ES.getSavePanel();
	    pnlView = ES.getViewPanel();
		pnlEdit = ES.getEditPanel();
		pnlUpdate = ES.getUpdatePanel();
		pnlDelete = ES.getDeletePanel();
		pnlClose = ES.getClosePanel();
		pnlReport = ES.getReportPanel();
		pnlApply = ES.getApplyPanel();
		pnlSelect = ES.getSelectPanel();
		pnlEntry = ES.getEntryPanel();

        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();
        pnlCountryUpdate = ES.getFirstComboPanel();
        cmbCountryUpdate = ES.getFirstComboBox();
        lblCountryUpdate = ES.getFirstComboLabel();
		lblCountryUpdate.setText("Country...");
        pnlStateUpdate = ES.getSecondComboPanel();
        cmbStateUpdate = ES.getSecondComboBox();
        lblStateUpdate = ES.getSecondComboLabel();
		lblStateUpdate.setText("State...");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("State Form ");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblStateID = new JLabel("StateID");
		lblStateID.setBounds(10,y,150,h);
		lblStateID.setFont(F2);
		pnlData.add(lblStateID);

		txtStateID = new JTextField();
		txtStateID.setBounds(160,y,100,h);
		txtStateID.setFont(F2);
		pnlData.add(txtStateID);

		y = y+h+gap;

		lblStateName = new JLabel("State Name");
		lblStateName.setBounds(10,y,150,h);
		lblStateName.setFont(F2);
		pnlData.add(lblStateName);

		txtStateName = new JTextField();
		txtStateName.setBounds(160,y,250,h);
		txtStateName.setFont(F2);
		pnlData.add(txtStateName);

		y = y+h+gap;

		lblCountryID = new JLabel("CountryID");
		lblCountryID.setBounds(10,y,150,h);
		lblCountryID.setFont(F2);
		pnlData.add(lblCountryID);

		cmbCountryID = new JComboBox();
		cmbCountryID.setBounds(160,y,200,h);
		cmbCountryID.setFont(F2);
		pnlData.add(cmbCountryID);


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,550,444);
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

		ES.setDefaultOperation();
		ES.UIAreaSetting(450,250);


		addCountryRecords(cmbCountryID);

		//PanelState.enabledComponents(pnlNew);
		//PanelState.disabledComponents(pnlData);
		//PanelState.enabledComponents(pnlView);
		createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement2();
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
		cbm.manageFirstPanel(pnlCountryUpdate);
		cbm.manageFirstLabel(lblCountryUpdate);
		cbm.manageFirstCombo(cmbCountryUpdate);
		cbm.manageSecondPanel(pnlStateUpdate);
		cbm.manageSecondLabel(lblStateUpdate);
		cbm.manageSecondCombo(cmbStateUpdate);
	}

	public void initUI()
	{
		txtStateID.setText("0");
		txtStateName.setText("");
	}
	public void addCountryRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsCountry.addCountryRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
	public void addStateRecords(JComboBox cmbProcess,int mCountryID)
	{
		cmbProcess.removeActionListener(this);
		ClsState.addStateRecords(cmbProcess,mCountryID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			//PanelState.enabledComponents(pnlData);
			//PanelState.disabledComponents(pnlNew);
           // PanelState.disabledComponents(pnlView);
           // PanelState.enabledComponents(pnlSave);
           // PanelState.enabledComponents(pnlClose);
            txtStateID.setText("0");
			txtStateName.requestFocus();
		}
		else if(ae.getSource()==cmbCountryID)
		{
			String mCountryName = (String)cmbCountryID.getSelectedItem();
			vCountryID = ClsCountry.getCountryIDFromName(mCountryName);

		}
		else if(ae.getSource()==btnSave)
		{

			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsState temp = readUI();
			ClsState.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		//	PanelState.disabledComponents(pnlData);
		//	PanelState.disabledComponents(pnlSave);
		//	PanelState.disabledComponents(pnlClose);
			//PanelState.enabledComponents(pnlNew);
		//	PanelState.enabledComponents(pnlView);
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsState temp = readUI();
			ClsState.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();
			//PanelState.disabledComponents(pnlUpdate);
			//PanelState.disabledComponents(pnlData);
			//PanelState.enabledComponents(pnlNew);
			//PanelState.enabledComponents(pnlView);
		}
		else if(ae.getSource()==btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addCountryRecords(cmbCountryUpdate);

		}
		else if(ae.getSource()==cmbCountryUpdate)
		{
			String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
			int mCountryID = ClsCountry.getCountryIDFromName(mCountryName);
			JOptionPane.showMessageDialog(null,mCountryID);
			addStateRecords(cmbStateUpdate,mCountryID);
			PanelState.enabledComponents(pnlStateUpdate);
		}
		else if(ae.getSource()==cmbStateUpdate)
		{
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
			txtStateName.requestFocus();
			txtStateName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsState temp = readUI();
			ClsState.deleteRecord(temp);
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

			String mStateName = (String)cmbStateUpdate.getSelectedItem();
			int mStateID = ClsState.getStateIDFromName(mStateName);
			ClsState temp = ClsState.getStateInformation(mStateID);
			writeUI(temp);
			PanelState.disabledComponents(pnlSelect);
			PanelState.enabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlDelete);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			//PanelState.hideComponents(pnlData);
			//PanelState.visibleComponents(pnlDataReport);
			//createReport();
			setColumnsData();
		}
   }

	public void writeUI(ClsState temp)
	{
		txtStateID.setText(String.valueOf(temp.getStateID()));
		txtStateName.setText(temp.getStateName());
		int mCountryID=temp.getCountryID();
		String mCountryName = ClsCountry.getCountryNameFromID(mCountryID);
		cmbCountryID.setSelectedItem(mCountryName);
	}

	ClsState readUI()
	{
		ClsState temp = new ClsState();
		temp.setStateID(Integer.parseInt(txtStateID.getText()));
		temp.setStateName(txtStateName.getText());
		temp.setCountryID(vCountryID);
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
		Rcols+=tool.addNewColumn("StateID");
		Rcols+=tool.addNewColumn("StateName");
		Rcols+=tool.addNewColumn("CountryID");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("StateID",80);
		tool.setColumnWidth("StateName",100);
		tool.setColumnWidth("CountryID",50);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsState Data[]=ClsState.getAllStateInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getStateName();
			Objectdata[2]=Data[i].getCountryID();

			tool.addNewRow(Objectdata);
		}
	}


	public static void main(String args[])
	{
		FrmState A = new FrmState();
	}
}