import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmProjectSelection extends JFrame implements ActionListener
{
	ProjectSelectionPanel ES;
	int count;
	JButton btnProjectName[] ;

	TablePanel t[];

	JPanel pnlData;
	JPanel pnlDataScroll;
	int vProjectID=0;
	ClsProject projref;

	JLabel lblProgrameHeading;
	FrmProjectSelection()
	{


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		ES = new ProjectSelectionPanel();
		add(ES);
		Border bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		setLayout(null);
		pnlData = ES.getDataPanel();
		lblProgrameHeading = ES.getProgrammeHeading();

		lblProgrameHeading.setText("Project Selection Program ");
		HtmlStyle.applyH1(lblProgrameHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrameHeading,500);
		bl.start();

		pnlData.setLayout(null);
		int mDataPanelWidth = 900;
		int mDataPanelHeight = 500;
		int mDataScrollPanelHeight=225;
		int mDataScrollPanelYValue=(mDataPanelHeight-mDataScrollPanelHeight)/2;
		ES.UIAreaSetting(mDataPanelWidth,mDataPanelHeight);

		pnlDataScroll = new JPanel();
		pnlDataScroll.setLayout(null);//new GridLayout(1,count));


		JScrollPane scrollablePanel = new JScrollPane(pnlDataScroll);
		scrollablePanel.setLayout(new ScrollPaneLayout());

		scrollablePanel.setBounds(10,mDataScrollPanelYValue,mDataPanelWidth-10,mDataScrollPanelHeight);


        scrollablePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollablePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



		pnlData.add(scrollablePanel);

		count = ClsProject.getAllRecordsCount();
        System.out.println(count);
		ClsProject [] ref = ClsProject.getAllProjectInformation();
		t = new TablePanel[count];
		btnProjectName = new JButton[count];

		int tw=200;
		int th=190;
		int tx=10;
		int tgap=10;
		for(int i=0;i<count;i++)
		{
			t[i] = new TablePanel(tw,th);
			pnlDataScroll.add(t[i]);
			t[i].setBounds(tx,10,tw,th);
			tx=tx+tw+tgap;
			t[i].displayTablePanel();
			t[i].setBorder(bd);
			btnProjectName[i] = t[i].getProjectNameButton();
			btnProjectName[i].setText(ref[i].getProjectName());
			btnProjectName[i].addActionListener(this);

		}

		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		for(int i=0;i<count;i++)
		{
	    	if(ae.getSource()==btnProjectName[i])
			{
				String x=ae.getActionCommand();
				vProjectID=ClsProject.getProjectIDFromName(x);
				JOptionPane.showMessageDialog(null,"code=="+vProjectID);
				projref=ClsProject.getProjectInformation(vProjectID);
				JOptionPane.showMessageDialog(null,"project name..."+projref.getProjectName());
				//lblApplication.setText(projref.getApplicationName());
				//lblTechnology.setText(projref.getTechnologyName());
				FrmCodeDeveloper a=new FrmCodeDeveloper(projref);
			}
		}

	}
  public static void main(String args[])
   {
        FrmProjectSelection A = new FrmProjectSelection();

   }

}