import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmEventObject extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblEventObjectID;
	JLabel  lblEventObjectName;
	JLabel  lblProgrammeHeading;

    JTextField txtEventObjectID;
    JTextField txtEventObjectName;

	JPanel pnlEntry;
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


    Font F2;

    Border border1;

    JComboBox cmbEventObjectUpdate;
    JPanel pnlEventObjectUpdate;
    JLabel lblEventObjectUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmEventObject()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen();
		add(ES);



		pnlDataReport = ES.getDataReportPanel();
	    pnlData = ES.getDataPanel();
	    pnlEntry = ES.getEntryPanel();
	    pnlNew = ES.getNewPanel();
	    pnlSave = ES.getSavePanel();
	    pnlView = ES.getViewPanel();
		pnlEdit = ES.getEditPanel();
		pnlUpdate = ES.getUpdatePanel();
		pnlDelete = ES.getDeletePanel();
		pnlClose = ES.getClosePanel();
		pnlReport = ES.getReportPanel();
		pnlApply = ES.getApplyPanel();

        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();
        pnlEventObjectUpdate = ES.getFirstComboPanel();
        cmbEventObjectUpdate = ES.getFirstComboBox();
        lblEventObjectUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblEventObjectUpdate.setText("EventObject ");
		lblProgrammeHeading.setText("EventObjectForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblEventObjectID = new JLabel("EventObjectID");
       lblEventObjectID.setBounds(10,y,250,h);
       lblEventObjectID.setFont(F2);
       pnlData.add(lblEventObjectID);

       txtEventObjectID = new JTextField();
       //txtEventObjectID.setBackground(Color.decode("#FFDAB9"));
       txtEventObjectID.setBounds(200,y,100,h);
       txtEventObjectID.setFont(F2);
       pnlData.add(txtEventObjectID);

		y = y+h+gap;
       lblEventObjectName = new JLabel("EventObject Name");
	   lblEventObjectName.setBounds(10,y,250,h);
	   lblEventObjectName.setFont(F2);
	   pnlData.add(lblEventObjectName);

       txtEventObjectName = new JTextField();
	   txtEventObjectName.setBounds(200,y,250,h);
	   txtEventObjectName.setFont(F2);
       pnlData.add(txtEventObjectName);

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
       ES.UIAreaSetting(550,250);
       ES.ReportAreaSetting(700,550);


//		PanelState.hideComponents(pnlDataReport);
//		PanelState.hideComponents(pnlData);
		//PanelState.visibleComponents(pnlDataReport);
		createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);



		//setColumnsData();
//		PanelState.enabledComponents(pnlReport);



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
		cbm.manageFirstPanel(pnlEventObjectUpdate);
		cbm.manageFirstLabel(lblEventObjectUpdate);
		cbm.manageFirstCombo(cmbEventObjectUpdate);
	}


   public void initUI()
   {
       txtEventObjectID.setText("0");
       txtEventObjectName.setText(" ");
   }

    public void addEventObjectRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsEventObject.addEventObjectRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtEventObjectID.setText("0");
			txtEventObjectName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsEventObject temp = readUI();
           ClsEventObject.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();

	    // PanelState.enabledComponents(pnlNew);
	    // PanelState.enabledComponents(pnlView);
	    // PanelState.enabledComponents(pnlClose);



	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
           ClsEventObject temp = readUI();
           ClsEventObject.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
			//PanelState.enabledComponents(pnlNew);
			//PanelState.enabledComponents(pnlView);
			//PanelState.enabledComponents(pnlClose);
			//PanelState.disabledComponents(pnlUpdate);



	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            addEventObjectRecords(cmbEventObjectUpdate);

	   }
	   else if(ae.getSource()==btnEdit)
	   {
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
	   }
	   else if(ae.getSource()==btnDelete)
	   {
		   bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
           ClsEventObject temp = readUI();
           ClsEventObject.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbEventObjectUpdate)
	   	{
			PanelState.enabledComponents(pnlApply);
	              initUI();
	   }

		else if(ae.getSource()==btnReport)
		{
		   bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
//			PanelState.hideComponents(pnlData);
//			PanelState.visibleComponents(pnlDataReport);
			//createReport();
			setColumnsData();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mEventObjectName = (String)cmbEventObjectUpdate.getSelectedItem();
			int mEventObjectID = ClsEventObject.getEventObjectIDFromName(mEventObjectName);
			ClsEventObject temp = ClsEventObject.getEventObjectInformation(mEventObjectID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsEventObject temp)
   {
		txtEventObjectID.setText(String.valueOf(temp.getEventObjectID()));
		txtEventObjectName.setText(temp.getEventObjectName());


   }

   ClsEventObject readUI()
   {

	   ClsEventObject temp = new ClsEventObject();
	   temp.setEventObjectID(Integer.parseInt(txtEventObjectID.getText()));
	   temp.setEventObjectName(txtEventObjectName.getText());



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
		Rcols+=tool.addNewColumn("EventObjectID");
		Rcols+=tool.addNewColumn("EventObjectName");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("EventObjectID",80);
		tool.setColumnWidth("EventObjectName",400);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsEventObject Data[]=ClsEventObject.getAllEventObjectInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getEventObjectName();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmEventObject A = new FrmEventObject();
   }

}