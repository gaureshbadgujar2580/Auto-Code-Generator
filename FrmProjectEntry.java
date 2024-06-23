import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import autocodeentryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmProjectEntry extends JFrame implements ActionListener
{
	ProjectSelectionPanel ES;
	int Buttoncount =4;

	int count;


	JPanel pnlData;
	JPanel pnlDataScroll;


	JButton btnNewProject ;
	JButton btnOpenProject;

	JPanel pnlButtonOptions;
	JPanel pnlMD;

	JLabel lblMD;


	JLabel lblProgrameHeading;
	FrmProjectEntry()
	{


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		ES = new ProjectSelectionPanel();
		add(ES);
		Border bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		setLayout(null);
		pnlData = ES.getDataPanel();

		lblProgrameHeading = ES.getProgrammeHeading();

		lblProgrameHeading.setText("Project Entry ");
		HtmlStyle.applyH1(lblProgrameHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrameHeading,500);
		bl.start();



		pnlData.setLayout(null);
		int mDataPanelWidth = 1050;
		int mDataPanelHeight = 730;
		int mDataScrollPanelHeight=600;
		int mDataScrollPanelYValue=20;
		int mDatePanelXValue = 150;


		ES.UIAreaSetting(mDataPanelWidth,mDataPanelHeight);

		pnlMD= new JPanel();
		pnlMD.setBounds(10,10,1025,600);
		pnlMD.setBackground(Color.gray);
		pnlMD.setLayout(new GridLayout(1,1));

		lblMD = new JLabel(new ImageIcon("Images\\MD.jpg"));
		pnlMD.add(lblMD);
		Scrollbar scrollB1 = new Scrollbar(Scrollbar.HORIZONTAL, 10, 40, 0, 100);
		Scrollbar scrollB2 = new Scrollbar(Scrollbar.VERTICAL, 10, 60, 0, 100);


		pnlButtonOptions = new JPanel();
		pnlButtonOptions.setBounds(10,620,1025,100);
		pnlButtonOptions.setLayout(new GridLayout(1,2));

		btnNewProject = new JButton("CREATE NEW PROJECT ...");
		btnNewProject.setBackground(new Color(255,128,64));
		pnlButtonOptions.add(btnNewProject);


		btnOpenProject = new JButton("OPEN eXISTING PROJECT...");
		btnOpenProject.setBackground(new Color(255,128,64));
		btnOpenProject.setBackground(new Color(255,128,64));
		pnlButtonOptions.add(btnOpenProject);

		pnlData.add(pnlMD);
		pnlData.add(pnlButtonOptions);

       btnNewProject.addActionListener(this);
		btnOpenProject.addActionListener(this);

		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNewProject)
		{
			FrmProject  A = new FrmProject();
		}
		else if(ae.getSource()==btnOpenProject)
		{
			FrmProjectSelection A = new FrmProjectSelection();
		}
	}
  public static void main(String args[])
   {
        FrmProjectEntry A = new FrmProjectEntry();

   }

}