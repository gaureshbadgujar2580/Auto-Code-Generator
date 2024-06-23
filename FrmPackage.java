import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmPackage extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblPackageID;
	JLabel  lblPackageName;
	JLabel  lblProgrammeHeading;

    JTextField txtPackageID;
    JTextField txtPackageName;

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

    JComboBox cmbPackageUpdate;
    JPanel pnlPackageUpdate;
    JLabel lblPackageUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmPackage()
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
        pnlPackageUpdate = ES.getFirstComboPanel();
        cmbPackageUpdate = ES.getFirstComboBox();
        lblPackageUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblPackageUpdate.setText("Package ");
		lblProgrammeHeading.setText("PackageForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblPackageID = new JLabel("PackageID");
       lblPackageID.setBounds(10,y,150,h);
       lblPackageID.setFont(F2);
       pnlData.add(lblPackageID);

       txtPackageID = new JTextField();
       //txtPackageID.setBackground(Color.decode("#FFDAB9"));
       txtPackageID.setBounds(160,y,100,h);
       txtPackageID.setFont(F2);
       pnlData.add(txtPackageID);

		y = y+h+gap;
       lblPackageName = new JLabel("Package Name");
	   lblPackageName.setBounds(10,y,150,h);
	   lblPackageName.setFont(F2);
	   pnlData.add(lblPackageName);

       txtPackageName = new JTextField();
	   txtPackageName.setBounds(160,y,250,h);
	   txtPackageName.setFont(F2);
       pnlData.add(txtPackageName);




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


		//createReport();
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
		cbm.manageFirstPanel(pnlPackageUpdate);
		cbm.manageFirstLabel(lblPackageUpdate);
		cbm.manageFirstCombo(cmbPackageUpdate);
	}


   public void initUI()
   {
       txtPackageID.setText("0");
       txtPackageName.setText(" ");

   }

    public void addPackageRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsPackage.addPackageRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtPackageID.setText("0");
			txtPackageName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsPackage temp = readUI();
           ClsPackage.addNewRecord(temp);
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
           ClsPackage temp = readUI();
           ClsPackage.updateRecord(temp);
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
            addPackageRecords(cmbPackageUpdate);

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
           ClsPackage temp = readUI();
           ClsPackage.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbPackageUpdate)
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
			createReport();
			setColumnsData();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mPackageName = (String)cmbPackageUpdate.getSelectedItem();
			int mPackageID = ClsPackage.getPackageIDFromName(mPackageName);
			ClsPackage temp = ClsPackage.getPackageInformation(mPackageID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsPackage temp)
   {
		txtPackageID.setText(String.valueOf(temp.getPackageID()));
		txtPackageName.setText(temp.getPackageName());



   }

   ClsPackage readUI()
   {

	   ClsPackage temp = new ClsPackage();
	   temp.setPackageID(Integer.parseInt(txtPackageID.getText()));
	   temp.setPackageName(txtPackageName.getText());



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
		Rcols+=tool.addNewColumn("PackageID");
		Rcols+=tool.addNewColumn("PackageName");
		Rcols+=tool.addNewColumn("PackageDescription");
		Rcols+=tool.addNewColumn("PackageAbbrivation");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("PackageID",80);
		tool.setColumnWidth("PackageName",180);
		tool.setColumnWidth("PackageDescription",180);
		tool.setColumnWidth("PackageAbbrivation",180);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsPackage Data[]=ClsPackage.getAllPackageInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getPackageName();



			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmPackage A = new FrmPackage();
   }

}