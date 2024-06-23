import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmListener extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblListenerID;
	JLabel  lblListenerName;
	JLabel  lblProgrammeHeading;

    JTextField txtListenerID;
    JTextField txtListenerName;

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

    JComboBox cmbListenerUpdate;
    JPanel pnlListenerUpdate;
    JLabel lblListenerUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmListener()
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
        pnlListenerUpdate = ES.getFirstComboPanel();
        cmbListenerUpdate = ES.getFirstComboBox();
        lblListenerUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblListenerUpdate.setText("Listener ");
		lblProgrammeHeading.setText("ListenerForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblListenerID = new JLabel("ListenerID");
       lblListenerID.setBounds(10,y,150,h);
       lblListenerID.setFont(F2);
       pnlData.add(lblListenerID);

       txtListenerID = new JTextField();
       //txtListenerID.setBackground(Color.decode("#FFDAB9"));
       txtListenerID.setBounds(160,y,100,h);
       txtListenerID.setFont(F2);
       pnlData.add(txtListenerID);

		y = y+h+gap;
       lblListenerName = new JLabel("Listener Name");
	   lblListenerName.setBounds(10,y,150,h);
	   lblListenerName.setFont(F2);
	   pnlData.add(lblListenerName);

       txtListenerName = new JTextField();
	   txtListenerName.setBounds(160,y,250,h);
	   txtListenerName.setFont(F2);
       pnlData.add(txtListenerName);

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
		cbm.manageFirstPanel(pnlListenerUpdate);
		cbm.manageFirstLabel(lblListenerUpdate);
		cbm.manageFirstCombo(cmbListenerUpdate);
	}


   public void initUI()
   {
       txtListenerID.setText("0");
       txtListenerName.setText(" ");
   }

    public void addListenerRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsListener.addListenerRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtListenerID.setText("0");
			txtListenerName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsListener temp = readUI();
           ClsListener.addNewRecord(temp);
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
           ClsListener temp = readUI();
           ClsListener.updateRecord(temp);
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
            addListenerRecords(cmbListenerUpdate);

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
           ClsListener temp = readUI();
           ClsListener.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbListenerUpdate)
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

			String mListenerName = (String)cmbListenerUpdate.getSelectedItem();
			int mListenerID = ClsListener.getListenerIDFromName(mListenerName);
			ClsListener temp = ClsListener.getListenerInformation(mListenerID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsListener temp)
   {
		txtListenerID.setText(String.valueOf(temp.getListenerID()));
		txtListenerName.setText(temp.getListenerName());
   }

   ClsListener readUI()
   {
	   ClsListener temp = new ClsListener();
	   temp.setListenerID(Integer.parseInt(txtListenerID.getText()));
	   temp.setListenerName(txtListenerName.getText());
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
		Rcols+=tool.addNewColumn("ListenerID");
		Rcols+=tool.addNewColumn("ListenerName");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("ListenerID",80);
		tool.setColumnWidth("ListenerName",400);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsListener Data[]=ClsListener.getAllListenerInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getListenerName();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmListener A = new FrmListener();
   }

}