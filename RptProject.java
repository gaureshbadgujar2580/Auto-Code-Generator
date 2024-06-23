import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import AutoCodereportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptProject extends JFrame implements ActionListener
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
	RptProject()
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
		lblProgrammeHeading.setText("Package Report..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

        Dimension Size = pnlDataReport.getSize();

		tool=new ReportTool(500,500);
		tool.setBounds(10,10,Size.width-20,Size.height-20);
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
		Rcols+=tool.addNewColumn("ProjectID");
		Rcols+=tool.addNewColumn("ProjectName");
		Rcols+=tool.addNewColumn("XPosition");
		Rcols+=tool.addNewColumn("YPosition");
		Rcols+=tool.addNewColumn("Width");
		Rcols+=tool.addNewColumn("Height");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("ProjectID",100);
		tool.setColumnWidth("ProjectName",200);
		tool.setColumnWidth("XPosition",150);
		tool.setColumnWidth("YPosition",150);
		tool.setColumnWidth("Width",150);
		tool.setColumnWidth("Height",150);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsProject Data[]=ClsProject.getAllProjectInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getProjectName();
			Objectdata[2]=Data[i].getXPos();
			Objectdata[3]=Data[i].getYPos();
			Objectdata[4]=Data[i].getWidth();
			Objectdata[5]=Data[i].getHeight();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        RptProject A = new RptProject();
   }

}