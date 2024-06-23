import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import DBReport.*;
class FrmDisplayCode extends JFrame implements ActionListener
{
	CodePanel EP;

	JButton btnDisplay;
	JLabel lblProjectName;
	JTextArea txtCodeArea;

	JPanel pnlFirst;
	JPanel pnlCodeArea;


	ClsProject temp1;
	FrmDisplayCode(ClsProject temp1)
	{
		this.temp1=temp1;
		setLayout(null);
		EP=new CodePanel();
		add(EP);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();

		pnlFirst = EP.getFirstPanel();
		pnlCodeArea	=EP.getUIPanel();


		btnDisplay=EP.getFirstButton();
		btnDisplay.setText("Display Code");

		lblProjectName=EP.getProgramHeadingLabel();
		lblProjectName.setText(temp1.getProjectName()+".java");
		HtmlStyle.applyH2(lblProjectName);

		btnDisplay.addActionListener(this);

		pnlCodeArea.setLayout(new BorderLayout());
		txtCodeArea=new JTextArea();
		pnlCodeArea.add(txtCodeArea,BorderLayout.CENTER);
		PanelState.visibleComponents(pnlCodeArea);



		setSize(d.width,d.height);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnDisplay)
		{
			txtCodeArea.setText("");
    		try
    		{
				String filename=temp1.getProjectName()+".java";
				FileInputStream fis = new FileInputStream(filename);
				int b;
				while  ((b=fis.read()) != -1)
					txtCodeArea.append(String.valueOf((char)b));
				fis.close();
			}
			catch(FileNotFoundException e)
			{
				JOptionPane.showMessageDialog(this,"File Not Found ...... ");
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this,"Something Going Wrong ...... ");
			}
		}

	}

	public static void main(String args[])
	{
		ClsProject temp=ClsProject.getProjectInformation(1);
	    FrmDisplayCode obj=new FrmDisplayCode(temp);

	}

}