import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import ProjectSetting.*;

class FrmEvent extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblEventID;
	JLabel  lblEventName;
	JLabel  lblEventNameUpdate;
	JLabel  lblProjectHeading;
	JLabel  lblProgrammeHeading;

    JTextField txtEventID;
    JTextField txtEventName;

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

    JPanel pnlDataReport;
    ReportTool tool;
    int Rcols;
    Font F2;

    Border border1;

	ButtonState bst;
	ClsButtonManagement cbm;

	JPanel pnlEventUpdate;
	JLabel lblEventUpdate;
	JComboBox cmbEventUpdate;


	FrmEvent()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen();
		add(ES);



	    pnlEntry = ES.getEntryPanel();
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

        pnlDataReport=ES.getDataReportPanel();

        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();
        cmbEventUpdate = ES.getFirstComboBox();
        pnlEventUpdate = ES.getFirstComboPanel();
        lblEventUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        //lblProjectHeading=ES.getProjectHeading();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblEventUpdate.setText("Event ");
		//lblProjectHeading.setText(" NagarPalika Chopda ");
		lblProgrammeHeading.setText("Event Info ");

		//HtmlStyle.applyH1(lblProjectHeading);
		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblEventID = new JLabel("EventID");
       lblEventID.setBounds(10,y,150,h);
       lblEventID.setFont(F2);
       pnlData.add(lblEventID);

       txtEventID = new JTextField();
       //txtEventID.setBackground(Color.decode("#FFDAB9"));
       txtEventID.setBounds(160,y,100,h);
       txtEventID.setFont(F2);
       pnlData.add(txtEventID);

		y = y+h+gap;
       lblEventName = new JLabel("Event Name");
	   lblEventName.setBounds(10,y,150,h);
	   lblEventName.setFont(F2);
	   pnlData.add(lblEventName);

       txtEventName = new JTextField();
	   txtEventName.setBounds(160,y,250,h);
	   txtEventName.setFont(F2);
       pnlData.add(txtEventName);

        tool = new ReportTool(500,500);
		tool.setBounds(10,10,600,4400);
		tool.setBackground(null);
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

      // ES.setDefaultOperation();
       ES.UIAreaSetting(450,250);
       ES.ReportAreaSetting(700,550);

		initUI();
		createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);
		// setColumnsData();
		show();

	}

   public void initUI()
   {
       txtEventID.setText("0");
       txtEventName.setText(" ");
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
		cbm.manageFirstPanel(pnlEventUpdate);
		cbm.manageFirstLabel(lblEventUpdate);
		cbm.manageFirstCombo(cmbEventUpdate);
	}

    public void addEventRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsEvent.addEventRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
		    bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			txtEventName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsEvent temp = readUI();
           ClsEvent.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsEvent temp = readUI();
			ClsEvent.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");

			initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
           bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addEventRecords(cmbEventUpdate);


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
			ClsEvent temp = readUI();
			ClsEvent.deleteRecord(temp);
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
		  String mEventName = (String)cmbEventUpdate.getSelectedItem();
		   int mEventID = ClsEvent.getEventIDFromName(mEventName);
		  ClsEvent temp = ClsEvent.getEventInformation(mEventID);
		  writeUI(temp);
	   }
       else if(ae.getSource()==btnReport)
	   {

           bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
		  //createReport();
		   setColumnsData();

	   }



   }

   public void writeUI(ClsEvent temp)
   {
		txtEventID.setText(String.valueOf(temp.getEventID()));
		txtEventName.setText(temp.getEventName());
   }

   ClsEvent readUI()
   {

       ClsEvent temp = new ClsEvent();
	   temp.setEventID(Integer.parseInt(txtEventID.getText()));
	   temp.setEventName(txtEventName.getText());

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
		Rcols+=tool.addNewColumn("EventID");
		Rcols+=tool.addNewColumn("EventName");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("EventID",80);
		tool.setColumnWidth("EventName",280);
	}

	void setColumnsData()
    {

		tool.removeAllRows();

		ClsEvent Data[]=ClsEvent.getAllEventInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getEventName();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmEvent A = new FrmEvent();
   }


}