import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import reportscreen.*;


class FrmEventMethod extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen2 ES;

	JLabel lblEventMethodID;
	JLabel  lblEventMethodName;
	JLabel  lblInterfaceID;
	JLabel  lblEventMethodNameUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtEventMethodID;
    JTextField txtEventMethodName;

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

	JPanel pnlEventMethodUpdate;
    JComboBox cmbEventMethodUpdate;
	JLabel lblEventMethodUpdate;

    JPanel pnlInterfaceUpdate;
    JComboBox cmbInterfaceUpdate;
	JLabel lblInterfaceUpdate;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement2 cbm;

    int Rcols;

	JPanel pnlDataReport;

	JComboBox cmbInterfaceID;
    int vInterfaceID = 0;

	FrmEventMethod()
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
        pnlInterfaceUpdate = ES.getFirstComboPanel();
        cmbInterfaceUpdate = ES.getFirstComboBox();
        lblInterfaceUpdate = ES.getFirstComboLabel();
		lblInterfaceUpdate.setText("Interface...");
        pnlEventMethodUpdate = ES.getSecondComboPanel();
        cmbEventMethodUpdate = ES.getSecondComboBox();
        lblEventMethodUpdate = ES.getSecondComboLabel();
		lblEventMethodUpdate.setText("EventMethod...");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("EventMethod Form ");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblEventMethodID = new JLabel("EventMethodID");
		lblEventMethodID.setBounds(10,y,150,h);
		lblEventMethodID.setFont(F2);
		pnlData.add(lblEventMethodID);

		txtEventMethodID = new JTextField();
		txtEventMethodID.setBounds(160,y,100,h);
		txtEventMethodID.setFont(F2);
		pnlData.add(txtEventMethodID);

		y = y+h+gap;

		lblEventMethodName = new JLabel("EventMethod Name");
		lblEventMethodName.setBounds(10,y,150,h);
		lblEventMethodName.setFont(F2);
		pnlData.add(lblEventMethodName);

		txtEventMethodName = new JTextField();
		txtEventMethodName.setBounds(160,y,250,h);
		txtEventMethodName.setFont(F2);
		pnlData.add(txtEventMethodName);

		y = y+h+gap;

		lblInterfaceID = new JLabel("InterfaceID");
		lblInterfaceID.setBounds(10,y,150,h);
		lblInterfaceID.setFont(F2);
		pnlData.add(lblInterfaceID);

		cmbInterfaceID = new JComboBox();
		cmbInterfaceID.setBounds(160,y,200,h);
		cmbInterfaceID.setFont(F2);
		pnlData.add(cmbInterfaceID);

        tool=new ReportTool(100,100);
		tool.setBounds(10,10,600,444);
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
		ES.UIAreaSetting(450,250);
        ES.ReportAreaSetting(700,550);

		addInterfaceRecords(cmbInterfaceID);

		//PanelEventMethod.enabledComponents(pnlNew);
		//PanelEventMethod.disabledComponents(pnlData);
		//PanelEventMethod.enabledComponents(pnlView);
		//createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement2();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

        createReport();


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
		cbm.manageFirstPanel(pnlInterfaceUpdate);
		cbm.manageFirstLabel(lblInterfaceUpdate);
		cbm.manageFirstCombo(cmbInterfaceUpdate);
		cbm.manageSecondPanel(pnlEventMethodUpdate);
		cbm.manageSecondLabel(lblEventMethodUpdate);
		cbm.manageSecondCombo(cmbEventMethodUpdate);
	}

	public void initUI()
	{
		txtEventMethodID.setText("0");
		txtEventMethodName.setText("");
	}
	public void addInterfaceRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsInterface.addInterfaceRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
	public void addEventMethodRecords(JComboBox cmbProcess,int mInterfaceID)
	{
		cmbProcess.removeActionListener(this);
		ClsEventMethod.addEventMethodRecords(cmbProcess,mInterfaceID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			//PanelEventMethod.enabledComponents(pnlData);
			//PanelEventMethod.disabledComponents(pnlNew);
           // PanelEventMethod.disabledComponents(pnlView);
           // PanelEventMethod.enabledComponents(pnlSave);
           // PanelEventMethod.enabledComponents(pnlClose);
            txtEventMethodID.setText("0");
			txtEventMethodName.requestFocus();
		}
		else if(ae.getSource()==cmbInterfaceID)
		{
			String mInterfaceName = (String)cmbInterfaceID.getSelectedItem();
			vInterfaceID = ClsInterface.getInterfaceIDFromName(mInterfaceName);

		}
		else if(ae.getSource()==btnSave)
		{

			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsEventMethod temp = readUI();
			ClsEventMethod.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsEventMethod temp = readUI();
			ClsEventMethod.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();
		}
		else if(ae.getSource()==btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addInterfaceRecords(cmbInterfaceUpdate);

		}
		else if(ae.getSource()==cmbInterfaceUpdate)
		{
			String mInterfaceName = (String)cmbInterfaceUpdate.getSelectedItem();
			int mInterfaceID = ClsInterface.getInterfaceIDFromName(mInterfaceName);
			addEventMethodRecords(cmbEventMethodUpdate,mInterfaceID);
			PanelState.enabledComponents(pnlEventMethodUpdate);
		}
		else if(ae.getSource()==cmbEventMethodUpdate)
		{
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
			txtEventMethodName.requestFocus();
			txtEventMethodName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsEventMethod temp = readUI();
			ClsEventMethod.deleteRecord(temp);
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

			String mEventMethodName = (String)cmbEventMethodUpdate.getSelectedItem();
			int mEventMethodID = ClsEventMethod.getEventMethodIDFromName(mEventMethodName);
			ClsEventMethod temp = ClsEventMethod.getEventMethodInformation(mEventMethodID);
			writeUI(temp);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
            createReport();
            setColumnsData();
		}
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
		Rcols+=tool.addNewColumn("EventID");
		Rcols+=tool.addNewColumn("EventName");
		Rcols+=tool.addNewColumn("InterfaceID");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("EventID",80);
		tool.setColumnWidth("EventName",400);
		tool.setColumnWidth("InterfaceID",80);
	}

    void setColumnsData()
	{

		tool.removeAllRows();

		ClsEventMethod Data[]=ClsEventMethod.getAllEventMethodInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getEventMethodName();
			Objectdata[2]=Data[i].getInterfaceID();

			tool.addNewRow(Objectdata);
		}
	}

	public void writeUI(ClsEventMethod temp)
	{
		txtEventMethodID.setText(String.valueOf(temp.getEventMethodID()));
		txtEventMethodName.setText(temp.getEventMethodName());
		int mInterfaceID=temp.getInterfaceID();
		String mInterfaceName = ClsInterface.getInterfaceNameFromID(mInterfaceID);
		cmbInterfaceID.setSelectedItem(mInterfaceName);
	}

	ClsEventMethod readUI()
	{
		ClsEventMethod temp = new ClsEventMethod();
		temp.setEventMethodID(Integer.parseInt(txtEventMethodID.getText()));
		temp.setEventMethodName(txtEventMethodName.getText());
		temp.setInterfaceID(vInterfaceID);
		return(temp);
	}

	public static void main(String args[])
	{
		FrmEventMethod A = new FrmEventMethod();
	}
}