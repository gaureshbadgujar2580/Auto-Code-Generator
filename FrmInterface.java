import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import ProjectSetting.*;

class FrmInterface extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblInterfaceID;
	JLabel  lblInterfaceName;
	JLabel  lblInterfaceNameUpdate;
	JLabel  lblProjectHeading;
	JLabel  lblProgrammeHeading;

    JTextField txtInterfaceID;
    JTextField txtInterfaceName;

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

	JPanel pnlInterfaceUpdate;
	JLabel lblInterfaceUpdate;
	JComboBox cmbInterfaceUpdate;

	FrmInterface()
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
        pnlInterfaceUpdate = ES.getFirstComboPanel();
        cmbInterfaceUpdate = ES.getFirstComboBox();
        lblInterfaceUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        //lblProjectHeading=ES.getProjectHeading();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblInterfaceUpdate.setText("Interface ");
		//lblProjectHeading.setText(" NagarPalika Chopda ");
		lblProgrammeHeading.setText("Interface Info ");

		//HtmlStyle.applyH1(lblProjectHeading);
		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblInterfaceID = new JLabel("InterfaceID");
       lblInterfaceID.setBounds(10,y,150,h);
       lblInterfaceID.setFont(F2);
       pnlData.add(lblInterfaceID);

       txtInterfaceID = new JTextField();
       //txtInterfaceID.setBackground(Color.decode("#FFDAB9"));
       txtInterfaceID.setBounds(160,y,100,h);
       txtInterfaceID.setFont(F2);
       pnlData.add(txtInterfaceID);

		y = y+h+gap;
       lblInterfaceName = new JLabel("Interface Name");
	   lblInterfaceName.setBounds(10,y,150,h);
	   lblInterfaceName.setFont(F2);
	   pnlData.add(lblInterfaceName);

       txtInterfaceName = new JTextField();
	   txtInterfaceName.setBounds(160,y,250,h);
	   txtInterfaceName.setFont(F2);
       pnlData.add(txtInterfaceName);

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

     //  ES.setDefaultOperation();
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
	}

   public void initUI()
   {
       txtInterfaceID.setText("0");
       txtInterfaceName.setText(" ");
   }

    public void addInterfaceRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsInterface.addInterfaceRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			initUI();
			 bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			txtInterfaceName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsInterface temp = readUI();
			ClsInterface.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");

			initUI();
	  }
	   else if(ae.getSource()==btnUpdate)
	   {
			ClsInterface temp = readUI();
			ClsInterface.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");

			initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
 			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addInterfaceRecords(cmbInterfaceUpdate);
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
			ClsInterface temp = readUI();
			ClsInterface.deleteRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");

			initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
            bst.setButtonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			initUI();
	   }
	   else if(ae.getSource()==btnApply)
	   {
 			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);
		  String mInterfaceName = (String)cmbInterfaceUpdate.getSelectedItem();
		   int mInterfaceID = ClsInterface.getInterfaceIDFromName(mInterfaceName);
		  ClsInterface temp = ClsInterface.getInterfaceInformation(mInterfaceID);
		  writeUI(temp);
	   }
       else if(ae.getSource()==btnReport)
	   {
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();

	   }



   }

   public void writeUI(ClsInterface temp)
   {
		txtInterfaceID.setText(String.valueOf(temp.getInterfaceID()));
		txtInterfaceName.setText(temp.getInterfaceName());
   }

   ClsInterface readUI()
   {

       ClsInterface temp = new ClsInterface();
	   temp.setInterfaceID(Integer.parseInt(txtInterfaceID.getText()));
	   temp.setInterfaceName(txtInterfaceName.getText());

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
		Rcols+=tool.addNewColumn("InterfaceID");
		Rcols+=tool.addNewColumn("InterfaceName");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("InterfaceID",80);
		tool.setColumnWidth("InterfaceName",280);
	}

	void setColumnsData()
    {

		tool.removeAllRows();

		ClsInterface Data[]=ClsInterface.getAllInterfaceInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getInterfaceName();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmInterface A = new FrmInterface();
   }


}