import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;


class FrmDistrict extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen3 ES;

	JLabel  lblDistrictID;
	JLabel  lblDistrictName;
	JLabel  lblCountryID;
	JLabel  lblStateID;
	JLabel  lblDistrictNameUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtDistrictID;
    JTextField txtDistrictName;

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

 	JPanel pnlDistrictUpdate;
    JComboBox cmbDistrictUpdate;
	JLabel lblDistrictUpdate;



	JComboBox cmbCountryID;
	JComboBox cmbStateID;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement3 cbm;

	int Rcols;
	JPanel pnlDataReport;

   int vStateID =  0;
   int vCountryID = 0;
	FrmDistrict()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen3();
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
        pnlDistrictUpdate = ES.getThirdComboPanel();
	    cmbDistrictUpdate = ES.getThirdComboBox();
	    lblDistrictUpdate = ES.getThirdComboLabel();
		lblDistrictUpdate.setText("District");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("District Form.. ");


		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblDistrictID = new JLabel("DistrictID");
		lblDistrictID.setBounds(10,y,150,h);
		lblDistrictID.setFont(F2);
		pnlData.add(lblDistrictID);

		txtDistrictID = new JTextField();
		txtDistrictID.setBounds(160,y,100,h);
		txtDistrictID.setFont(F2);
		pnlData.add(txtDistrictID);

		y = y+h+gap;

		lblDistrictName = new JLabel("District Name");
		lblDistrictName.setBounds(10,y,150,h);
		lblDistrictName.setFont(F2);
		pnlData.add(lblDistrictName);

		txtDistrictName = new JTextField();
		txtDistrictName.setBounds(160,y,250,h);
		txtDistrictName.setFont(F2);
		pnlData.add(txtDistrictName);

		y = y+h+gap;

		lblCountryID = new JLabel("CountryID");
		lblCountryID.setBounds(10,y,150,h);
		lblCountryID.setFont(F2);
		pnlData.add(lblCountryID);

		cmbCountryID = new JComboBox();
		cmbCountryID.setBounds(160,y,200,h);
		cmbCountryID.setFont(F2);
		pnlData.add(cmbCountryID);

		y = y+h+gap;


		lblStateID = new JLabel("StateID");
		lblStateID.setBounds(10,y,150,h);
		lblStateID.setFont(F2);
		pnlData.add(lblStateID);

		cmbStateID = new JComboBox();
		cmbStateID.setBounds(160,y,200,h);
		cmbStateID.setFont(F2);
		pnlData.add(cmbStateID);

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

		bst = new ButtonState();
		cbm = new ClsButtonManagement3();
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
	}



	public void initUI()
	{
		txtDistrictID.setText("0");
		txtDistrictName.setText("");
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
	public void addDistrictRecords(JComboBox cmbProcess,int mStateID)
	{
		cmbProcess.removeActionListener(this);
		ClsDistrict.addDistrictRecords(cmbProcess,mStateID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

			/*PanelState.enabledComponents(pnlData);
			PanelState.disabledComponents(pnlNew);
			PanelState.disabledComponents(pnlView);
			PanelState.enabledComponents(pnlSave);
			PanelState.enabledComponents(pnlClose);*/

			txtDistrictID.setText("0");
			txtDistrictName.requestFocus();
		}
		else if(ae.getSource()==cmbCountryID)
		{
			String mCountryName = (String)cmbCountryID.getSelectedItem();
			int mCountryID = ClsCountry.getCountryIDFromName(mCountryName);
			addStateRecords(cmbStateID,mCountryID);

		}
		else if(ae.getSource()==cmbStateID)
		{
			String mStateName = (String)cmbStateID.getSelectedItem();
			vStateID = ClsState.getStateIDFromName(mStateName);
		}
		else if(ae.getSource()==btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);

			ClsDistrict temp = readUI();
			ClsDistrict.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();

		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);

			ClsDistrict temp = readUI();
			ClsDistrict.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();

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
			vCountryID = mCountryID;
			PanelState.enabledComponents(pnlStateUpdate);
		}
		else if(ae.getSource()==cmbStateUpdate)
		{

			String mStateName = (String)cmbStateUpdate.getSelectedItem();
			int mStateID = ClsState.getStateIDFromName(mStateName);
			JOptionPane.showMessageDialog(null,mStateName);
			JOptionPane.showMessageDialog(null,String.valueOf(mStateID));

			addDistrictRecords(cmbDistrictUpdate,mStateID);
			PanelState.enabledComponents(pnlDistrictUpdate);
			PanelState.enabledComponents(pnlApply);

		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);

			txtDistrictName.requestFocus();
			txtDistrictName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsDistrict temp = readUI();
			ClsDistrict.deleteRecord(temp);
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

			String mDistrictName = (String)cmbDistrictUpdate.getSelectedItem();
			int mDistrictID = ClsDistrict.getDistrictIDFromName(mDistrictName);
			ClsDistrict temp = ClsDistrict.getDistrictInformation(mDistrictID);
			writeUI(temp);

		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			//PanelState.hideComponents(pnlData);
			//PanelState.visibleComponents(pnlDataReport);
			createReport();
			setColumnsData();
		}
   }

	public void writeUI(ClsDistrict temp)
	{
		txtDistrictID.setText(String.valueOf(temp.getDistrictID()));
		txtDistrictName.setText(temp.getDistrictName());

		int mStateID=temp.getStateID();
		String mCountryName = ClsCountry.getCountryNameFromID(vCountryID);
		cmbCountryID.setSelectedItem(mCountryName);
		addStateRecords(cmbStateUpdate,mStateID);
		String mStateName =	ClsState.getStateNameFromID(mStateID);
		cmbStateID.setSelectedItem(mStateName);



	}

	ClsDistrict readUI()
	{
		ClsDistrict temp = new ClsDistrict();
		temp.setDistrictID(Integer.parseInt(txtDistrictID.getText()));
		temp.setDistrictName(txtDistrictName.getText());
		temp.setStateID(vStateID);
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
			Rcols+=tool.addNewColumn("DistrictID");
			Rcols+=tool.addNewColumn("DistrictName");
			Rcols+=tool.addNewColumn("StateID");
			//Rcols+=tool.addNewColumn("CountryID");

		}
		void setColumnsAlignment()
		{
			tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
			tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
			tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
			//tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		}
		void setColumnsWidth()
		{
			tool.setColumnWidth("DistrictID",40);
			tool.setColumnWidth("DistrictName",50);
			tool.setColumnWidth("StateID",60);
			//tool.setColumnWidth("CountryID",60);
		}

		void setColumnsData()
		{

			tool.removeAllRows();

			ClsDistrict Data[]=ClsDistrict.getAllDistrictInformation();

			for(int i=0;i<Data.length;i++)
			{
				Object Objectdata[]=new Object[Rcols];

				Objectdata[0]=i+1;
				Objectdata[1]=Data[i].getDistrictName();
				Objectdata[2]=Data[i].getStateID();
				//Objectdata[3]=Data[i].getCountryID();

				tool.addNewRow(Objectdata);
			}
	}

	public static void main(String args[])
	{
		FrmDistrict A = new FrmDistrict();
	}
}