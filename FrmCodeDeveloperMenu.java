import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;


class FrmCodeDeveloperMenu extends JFrame implements ActionListener
{
	//int w = 3020;

	CodeMenuScreen CMS;


	JLabel lblProgramHeading;

	JPanel pnlMasters;
	JButton btnMasters;

	JPanel pnlMenuTitle;
	JLabel lblMenuTitle;

	JPanel pnlMenuHeads[];
	JButton btnMenuHeads[];
	JPanel pnlSubMenuItems[];
	JButton btnSubMenuItems[];



	FrmCodeDeveloperMenu()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);

		CMS = new CodeMenuScreen();
		add(CMS);

		lblProgramHeading = CMS.getProgrammeHeading();
		lblProgramHeading.setText("Code Devlopment Menu Programe");
		HtmlStyle.applyH1(lblProgramHeading);

		BlinkLabel bl = new BlinkLabel(lblProgramHeading,500);
		bl.start();



		String RequiredMenuHeads[]={
									"Masters Entry .... ",
									"Reports Entry ...",
									"Exit ..... "
									};

		String RequiredMenuItems[]={"Country Info... ",
									"State Info .... ",
									"District Info ...",
									"Taluka Info..... ",
									"Area Info....",
									"Project Info...",
									"Listener Info..."
									};


		CMS.addMenuHeads(RequiredMenuHeads);
		CMS.addMenuItems(RequiredMenuItems);

		pnlMenuTitle = CMS.getMenuTitlePanel();
		lblMenuTitle = CMS.getMenuTitleLabel();
		lblMenuTitle.setText("Code Developer Menu");
		HtmlStyle.applyH2(lblMenuTitle);

		PanelState.enabledComponents(pnlMenuTitle);

		pnlMenuHeads = CMS.getMenuHeadsPanel();
		btnMenuHeads  = CMS.getMenuHeadsButton();
		pnlSubMenuItems = CMS.getSubMenuItemsPanel();
		btnSubMenuItems = CMS.getSubMenuItemsButton();

		for(int i=0; i<btnMenuHeads.length;i++)
		{
			btnMenuHeads[i].addActionListener(this);
		}
		for(int i=0; i<btnSubMenuItems.length;i++)
		{
			btnSubMenuItems[i].addActionListener(this);
		}


			//pnlMastersFirstButton = CMS.getMenu1Panel();
			//btnMastersFirstButton = CMS.getFirstButtonMenu1();
			//btnMastersFirstButton.setLabel("Country Information.... ");
//			btnMastersFirstButton.addActionListener(this);
			//PanelState.enabledComponents(pnlMastersFirstButton);



		//MS.UIAreaSetting(1050,720);

		show();
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSubMenuItems[0])
		{
			FrmCountry A = new FrmCountry();
		}

	}

   public static void main(String args[])
   {
        FrmCodeDeveloperMenu A = new FrmCodeDeveloperMenu();
   }
}

