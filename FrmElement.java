import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmElement extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen ES;

	JLabel lblElementID;
	JLabel  lblElementName;
	JLabel  lblElementDescription;
	JLabel  lblElementAbbrivation;
	JLabel  lblProgrammeHeading;

    JTextField txtElementID;
    JTextField txtElementName;
    JTextField txtElementDescription;
    JTextField txtElementAbbrivation;

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

    JComboBox cmbElementUpdate;
    JPanel pnlElementUpdate;
    JLabel lblElementUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmElement()
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
        pnlElementUpdate = ES.getFirstComboPanel();
        cmbElementUpdate = ES.getFirstComboBox();
        lblElementUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblElementUpdate.setText("Element ");
		lblProgrammeHeading.setText("ElementForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

       lblElementID = new JLabel("ElementID");
       lblElementID.setBounds(10,y,150,h);
       lblElementID.setFont(F2);
       pnlData.add(lblElementID);

       txtElementID = new JTextField();
       //txtElementID.setBackground(Color.decode("#FFDAB9"));
       txtElementID.setBounds(160,y,100,h);
       txtElementID.setFont(F2);
       pnlData.add(txtElementID);

		y = y+h+gap;
       lblElementName = new JLabel("Element Name");
	   lblElementName.setBounds(10,y,150,h);
	   lblElementName.setFont(F2);
	   pnlData.add(lblElementName);

       txtElementName = new JTextField();
	   txtElementName.setBounds(160,y,250,h);
	   txtElementName.setFont(F2);
       pnlData.add(txtElementName);

        y = y+h+gap;
       lblElementDescription = new JLabel("Element Description");
	   lblElementDescription.setBounds(10,y,150,h);
	   lblElementDescription.setFont(F2);
	   pnlData.add(lblElementDescription);

       txtElementDescription = new JTextField();
	   txtElementDescription.setBounds(160,y,250,h);
	   txtElementDescription.setFont(F2);
       pnlData.add(txtElementDescription);

		y = y+h+gap;
		lblElementAbbrivation = new JLabel("Element Abbrivation");
		lblElementAbbrivation.setBounds(10,y,150,h);
		lblElementAbbrivation.setFont(F2);
		pnlData.add(lblElementAbbrivation);

		txtElementAbbrivation = new JTextField();
		txtElementAbbrivation.setBounds(160,y,250,h);
		txtElementAbbrivation.setFont(F2);
		pnlData.add(txtElementAbbrivation);


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
		cbm.manageFirstPanel(pnlElementUpdate);
		cbm.manageFirstLabel(lblElementUpdate);
		cbm.manageFirstCombo(cmbElementUpdate);
	}


   public void initUI()
   {
       txtElementID.setText("0");
       txtElementName.setText(" ");
       txtElementDescription.setText(" ");
       txtElementAbbrivation.setText(" ");

   }

    public void addElementRecords(JComboBox cmbProcess)
      {

   	 //  cmbProcess.removeActionListener(this);


   	    ClsElement.addElementRecords(cmbProcess);

   	   //cmbProcess.addActionListener(this);

      }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtElementID.setText("0");
			txtElementName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsElement temp = readUI();
           ClsElement.addNewRecord(temp);
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
           ClsElement temp = readUI();
           ClsElement.updateRecord(temp);
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
            addElementRecords(cmbElementUpdate);

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
           ClsElement temp = readUI();
           ClsElement.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbElementUpdate)
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

			String mElementName = (String)cmbElementUpdate.getSelectedItem();
			int mElementID = ClsElement.getElementIDFromName(mElementName);
			ClsElement temp = ClsElement.getElementInformation(mElementID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsElement temp)
   {
		txtElementID.setText(String.valueOf(temp.getElementID()));
		txtElementName.setText(temp.getElementName());
	    txtElementDescription.setText(temp.getElementDescription());
		txtElementAbbrivation.setText(temp.getElementAbbrivation());



   }

   ClsElement readUI()
   {

	   ClsElement temp = new ClsElement();
	   temp.setElementID(Integer.parseInt(txtElementID.getText()));
	   temp.setElementName(txtElementName.getText());
	   temp.setElementDescription(txtElementDescription.getText());
	   temp.setElementAbbrivation(txtElementAbbrivation.getText());




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
		Rcols+=tool.addNewColumn("ElementID");
		Rcols+=tool.addNewColumn("ElementName");
		Rcols+=tool.addNewColumn("ElementDescription");
		Rcols+=tool.addNewColumn("ElementAbbrivation");

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
		tool.setColumnWidth("ElementID",80);
		tool.setColumnWidth("ElementName",180);
		tool.setColumnWidth("ElementDescription",180);
		tool.setColumnWidth("ElementAbbrivation",180);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsElement Data[]=ClsElement.getAllElementInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getElementName();
			Objectdata[2]=Data[i].getElementDescription();
			Objectdata[3]=Data[i].getElementAbbrivation();


			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmElement A = new FrmElement();
   }

}