import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import ProjectSetting.*;


class FrmArea extends JFrame implements ActionListener
{
	//int w = 3020;
	EntryScreen6 ES;

	JLabel  lblAreaID;
	JLabel  lblAreaName;
	JLabel lblTalukaID;
	JLabel lblCountryID;
	JLabel lblStateID;
	JLabel lblDistrictID;
	JLabel lblVillageID;

	JLabel lblCountryUpdate;
	JLabel lblStateUpdate;
	JLabel lblDistrictUpdate;
	JLabel lblTalukaUpdate;
	JLabel lblVillageUpdate;

	JLabel  lblProjectHeading;
	JLabel  lblProgrammeHeading;

    JTextField txtAreaID;
    JTextField txtAreaName;

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


	JComboBox cmbCountryID;
	JComboBox cmbStateID;
	JComboBox cmbDistrictID;
	JComboBox cmbTalukaID;
	JComboBox cmbVillageID;

	JComboBox cmbCountryUpdate;
	JComboBox cmbStateUpdate;
	JComboBox cmbDistrictUpdate;
	JComboBox cmbTalukaUpdate;
	JComboBox cmbVillageUpdate;
    Border border1;

	JPanel pnlCountryUpdate;
	JPanel pnlStateUpdate;
	JPanel pnlDistrictUpdate;
	JPanel pnlTalukaUpdate;
	JPanel pnlVillageUpdate;

	JPanel pnlDataReport;
	JPanel pnlAreaUpdate;
	JLabel lblAreaUpdate;
    JComboBox cmbAreaUpdate;

    JCheckBox chbIdentifier;


 	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement6 cbm;

	int Rcols;


	int vTalukaID=0;
	int vVillageID=0;
	int vTalukaIDUpdate=0;
	FrmArea()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new EntryScreen6();
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

		pnlTalukaUpdate = ES.getFourthComboPanel();
		cmbTalukaUpdate = ES.getFourthComboBox();
		lblTalukaUpdate = ES.getFourthComboLabel();
		lblTalukaUpdate.setText("Taluka");

		pnlVillageUpdate = ES.getFiveComboPanel();
		cmbVillageUpdate = ES.getFiveComboBox();
		lblVillageUpdate = ES.getFiveComboLabel();
		lblVillageUpdate.setText("Village");

		pnlAreaUpdate = ES.getSixComboPanel();
		cmbAreaUpdate = ES.getSixComboBox();
		lblAreaUpdate = ES.getSixComboLabel();
		lblAreaUpdate.setText("Area");



        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("Area Form ");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblAreaID = new JLabel("AreaID");
		lblAreaID.setBounds(10,y,150,h);
		lblAreaID.setFont(F2);
		pnlData.add(lblAreaID);

		txtAreaID = new JTextField();
		//txtAreaID.setBackground(Color.decode("#FFDAB9"));
		txtAreaID.setBounds(160,y,100,h);
		txtAreaID.setFont(F2);
		pnlData.add(txtAreaID);

		y = y+h+gap;
		lblAreaName = new JLabel("Area Name");
		lblAreaName.setBounds(10,y,160,h);
		lblAreaName.setFont(F2);
		pnlData.add(lblAreaName);

		txtAreaName = new JTextField();
		txtAreaName.setBounds(160,y,250,h);
		txtAreaName.setFont(F2);
		pnlData.add(txtAreaName);

		y = y+h+gap;

		lblCountryID= new JLabel("Country...");
		lblCountryID.setBounds(10,y,150,h);
		lblCountryID.setFont(F2);
		pnlData.add(lblCountryID);

		lblStateID= new JLabel("State...");
		lblStateID.setBounds(170,y,150,h);
		lblStateID.setFont(F2);
		pnlData.add(lblStateID);

		lblDistrictID= new JLabel("District...");
		lblDistrictID.setBounds(330,y,150,h);
		lblDistrictID.setFont(F2);
		pnlData.add(lblDistrictID);

		lblTalukaID= new JLabel("Taluka...");
		lblTalukaID.setBounds(480,y,150,h);
		lblTalukaID.setFont(F2);
		pnlData.add(lblTalukaID);


		y = y+h+gap;

		cmbCountryID = new JComboBox();
		cmbCountryID.setBounds(10,y,150,h);
		cmbCountryID.setFont(F2);
		pnlData.add(cmbCountryID);

		cmbStateID = new JComboBox();
		cmbStateID.setBounds(170,y,140,h);
		cmbStateID.setFont(F2);
		pnlData.add(cmbStateID);

		cmbDistrictID = new JComboBox();
		cmbDistrictID.setBounds(330,y,140,h);
		cmbDistrictID.setFont(F2);
		pnlData.add(cmbDistrictID);

		cmbTalukaID = new JComboBox();
		cmbTalukaID.setBounds(480,y,140,h);
		cmbTalukaID.setFont(F2);
		pnlData.add(cmbTalukaID);

		 y = y+h+gap;
		chbIdentifier = new JCheckBox("This Area is Belong in Village ........!");
		chbIdentifier.setBounds(10,y,400,30);
		chbIdentifier.setFont(F2);
		chbIdentifier.setBackground(ApplyColor.clrMenuTitlePanel);

		pnlData.add(chbIdentifier);

		y =y+h+gap;

		lblVillageID= new JLabel("Village...");
		lblVillageID.setBounds(25,y,150,h);
		lblVillageID.setFont(F2);
		pnlData.add(lblVillageID);

		cmbVillageID = new JComboBox();
		cmbVillageID.setBounds(25,y+h+gap,140,h);
		cmbVillageID.setFont(F2);
		pnlData.add(cmbVillageID);


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,930,600);
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
		chbIdentifier.addActionListener(this);


		ES.setDefaultOperation();
		ES.UIAreaSetting(700,350);


		addCountryRecords(cmbCountryID);

		bst = new ButtonState();
		cbm = new ClsButtonManagement6();

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
		txtAreaID.setText("0");
		txtAreaName.setText("");
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

	public void addTalukaRecords(JComboBox cmbProcess,int mDistrictID)
	{
			cmbProcess.removeActionListener(this);
    		ClsTaluka.addTalukaRecords(cmbProcess,mDistrictID);
			cmbProcess.addActionListener(this);
	}

	public void addVillageRecords(JComboBox cmbProcess,int mTalukaID)
	{
			cmbProcess.removeActionListener(this);
			ClsVillage.addVillageRecords(cmbProcess,mTalukaID);
			cmbProcess.addActionListener(this);
	}

	public void addAreaRecordsVillageWise(JComboBox cmbProcess,int mTalukaID,int mVillageID)
    {
		cmbProcess.removeActionListener(this);
 	    ClsArea.addAreaRecordsVillageWise(cmbProcess,mTalukaID,mVillageID);
	    cmbProcess.addActionListener(this);
    }
    static void addAreaRecordsTalukaWise(JComboBox cmbProcess ,int mTalukaID,int mVillageID)
    {
		//cmbProcess.removeActionListener(this);
		ClsArea.addAreaRecordsTalukaWise(cmbProcess,mTalukaID,mVillageID);
	  	//cmbProcess.addActionListener(this);

	}
   public void writeUI(ClsArea temp)
   {
		txtAreaID.setText(String.valueOf(temp.getAreaID()));
		txtAreaName.setText(temp.getAreaName());
//		addTalukaRecords(cmbTalukaID);
		//int mVillageID=temp.getVillageID();
	  	 int mTalukaID=temp.getTalukaID();




		ClsTaluka temp4 = ClsTaluka.getTalukaInformation(mTalukaID);

		ClsDistrict temp1 = ClsDistrict.getDistrictInformation(temp4.getDistrictID());

		ClsState temp2 = ClsState.getStateInformation(temp1.getStateID());


	   ClsCountry temp3 = ClsCountry.getCountryInformation(temp2.getCountryID());


		//String mCountryName = ClsCountry.getCountryNameFromID(vCountryID);
		cmbCountryID.setSelectedItem(temp3.getCountryName());
		//addStateRecords(cmbStateUpdate,vCountryID);
		//String mStateName =	ClsState.getStateNameFromID(vStateID);
		cmbStateID.setSelectedItem(temp2.getStateName());
		//addDistrictRecords(cmbDistrictUpdate,vCountryID);
		//String mDistrictName =	ClsDistrict.getDistrictNameFromID(vDistrictID);
		cmbDistrictID.setSelectedItem(temp1.getDistrictName());
		cmbTalukaID.setSelectedItem(temp4.getTalukaName());

			/*if(mVillageID!=0)
			{
				chbIdentifier.setSelected(true);
				addVillageRecords(cmbVillageID, mTalukaID);
				cmbVillageID.setSelectedItem(temp5.getVillageName());
			}
*/




	}

   ClsArea readUI()
   {

	   ClsArea temp = new ClsArea();
	   temp.setAreaID(Integer.parseInt(txtAreaID.getText()));
	   temp.setAreaName(txtAreaName.getText());
	   temp.setTalukaID(vTalukaID);
	   if(chbIdentifier.isSelected())
	   {
		   	   temp.setVillageID(vVillageID);
		}

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
	 			Rcols+=tool.addNewColumn("AreaID");
	 			Rcols+=tool.addNewColumn("AreaName");
	 			Rcols+=tool.addNewColumn("TalukaID");
	 			Rcols+=tool.addNewColumn("VillageID");

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
	 			tool.setColumnWidth("AreaID",40);
	 			tool.setColumnWidth("AreaName",50);
	 			tool.setColumnWidth("TalukaID",60);
	 			tool.setColumnWidth("VillageID",60);
	 		}

	 		void setColumnsData()
	 		{

	 				tool.removeAllRows();

	 				ClsArea Data[]=ClsArea.getAllAreaInformation();

	 				for(int i=0;i<Data.length;i++)
	 				{
	 					Object Objectdata[]=new Object[Rcols];

	 					Objectdata[0]=i+1;
	 					Objectdata[1]=Data[i].getAreaName();
	 					Objectdata[2]=Data[i].getTalukaID();
	 					Objectdata[3]=Data[i].getVillageID();

	 					tool.addNewRow(Objectdata);
	 				}
		}

   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

            txtAreaID.setText("0");
            txtAreaName.requestFocus();

           // addTalukaRecords(cmbTalukaID);
	   }
	   else if(ae.getSource()==btnSave)
	   {
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
            ClsArea temp = readUI();
            ClsArea.addNewRecords(temp);
            JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	        initUI();

	  }
	   else if(ae.getSource()==btnUpdate)
	   {
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
            ClsArea temp = readUI();
            ClsArea.updateRecords(temp);
            JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
            initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);

		    addCountryRecords(cmbCountryUpdate);
	   }

	   else if(ae.getSource()==btnEdit)
	   {
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
            txtAreaName.requestFocus();
            txtAreaName.selectAll();
	   }
	   else if(ae.getSource()==btnDelete)
	   {
			bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

            ClsArea temp = readUI();
            ClsArea.deleteRecords(temp);
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
			String mAreaName = (String)cmbAreaUpdate.getSelectedItem();
			int mAreaID = ClsArea.getAreaIDFromName(mAreaName);
			 ClsArea temp = ClsArea.getAreaInformation(mAreaID);
			writeUI(temp);


			PanelState.disabledComponents(pnlSelect);
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
		   int mStateID = ClsState.getStateIDFromName(mStateName);
		   addDistrictRecords(cmbDistrictID,mStateID);

	   }

	  else if(ae.getSource()==cmbDistrictID)
	   {
		   String mDistrictame = (String)cmbDistrictID.getSelectedItem();
		   int mDistrictID = ClsDistrict.getDistrictIDFromName(mDistrictame);
		   JOptionPane.showMessageDialog(null,mDistrictID);
		   addTalukaRecords(cmbTalukaID,mDistrictID);

	   }

	    else if(ae.getSource()==cmbTalukaID)
	   {
		   String mTalukaName = (String)cmbTalukaID.getSelectedItem();
		   vTalukaID = ClsTaluka.getTalukaIDFromName(mTalukaName);


	   }

	    else if(ae.getSource()==cmbVillageID)
	   {
		   String mVillageName = (String)cmbVillageID.getSelectedItem();
		   vVillageID = ClsVillage.getVillageIDFromName(mVillageName);

	   }

	   else if(ae.getSource()==cmbCountryUpdate)
	   {
		   String mCountryName = (String)cmbCountryUpdate.getSelectedItem();
		   int mCountryID = ClsCountry.getCountryIDFromName(mCountryName);
		   addStateRecords(cmbStateUpdate,mCountryID);

		   PanelState.enabledComponents(pnlStateUpdate);

	  }
		else if(ae.getSource()==cmbStateUpdate)
		{
			String mStateName = (String)cmbStateUpdate.getSelectedItem();
			int mStateID = ClsState.getStateIDFromName(mStateName);
			addDistrictRecords(cmbDistrictUpdate,mStateID);

			PanelState.enabledComponents(pnlDistrictUpdate);
			PanelState.enabledComponents(pnlApply);

		}

		else if(ae.getSource()==cmbDistrictUpdate)
		{
			String mDistrictName = (String)cmbDistrictUpdate.getSelectedItem();
			int mDistrictID = ClsDistrict.getDistrictIDFromName(mDistrictName);
			addTalukaRecords(cmbTalukaUpdate,mDistrictID);

			PanelState.enabledComponents(pnlTalukaUpdate);
			PanelState.enabledComponents(pnlApply);
		}

		else if(ae.getSource()==cmbTalukaUpdate)
		{
			String mTalukaName = (String)cmbTalukaUpdate.getSelectedItem();
			int mTalukaID = ClsTaluka.getTalukaIDFromName(mTalukaName);
			addAreaRecordsTalukaWise(cmbAreaUpdate,mTalukaID,0);
			vTalukaIDUpdate = mTalukaID;
			addVillageRecords(cmbVillageUpdate,mTalukaID);
			PanelState.enabledComponents(pnlVillageUpdate);
			PanelState.enabledComponents(pnlAreaUpdate);


		}

		else if(ae.getSource()==cmbVillageUpdate)
		{
			String mVillageName = (String)cmbVillageUpdate.getSelectedItem();
			int mVillageID = ClsVillage.getVillageIDFromName(mVillageName);
			JOptionPane.showMessageDialog(null,mVillageID);

			addAreaRecordsVillageWise(cmbAreaUpdate,vTalukaIDUpdate,mVillageID);


		}

	   else if(ae.getSource()==cmbAreaUpdate)
	   {
		    PanelState.enabledComponents(pnlApply);
			String mAreaName =(String)cmbAreaUpdate.getSelectedItem();
			int mAreaID = ClsArea.getAreaIDFromName(mAreaName);
			//JOptionPane.showMessageDialog(this,mAreaID);
			PanelState.enabledComponents(pnlEdit);
			PanelState.enabledComponents(pnlDelete);
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
		else if (ae.getSource()==chbIdentifier)
		{

			addVillageRecords(cmbVillageID,vTalukaID);

		}






}


   public static void main(String args[])
   {
        FrmArea A = new FrmArea();
   }

}