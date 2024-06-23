import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import AutoCodereportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptElement extends JFrame implements ActionListener
{
	//int w = 3020;
	ReportScreen ES;

	JLabel  lblProgrammeHeading;


	JPanel pnlEntry;



    Font F2;

    Border border1;

    ReportTool tool;

    int Rcols;

	JPanel pnlDataReport;
	RptElement()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new ReportScreen();
		add(ES);



		pnlDataReport = ES.getDataReportPanel();
	    pnlEntry = ES.getEntryPanel();



        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Element Report..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,600,444);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);





		ES.ReportAreaSetting(900,520);


		createReport();
		setColumnsData();

		show();



	}

   public void actionPerformed(ActionEvent ae)
   {

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
        RptElement A = new RptElement();
   }

}