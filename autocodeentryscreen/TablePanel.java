package autocodeentryscreen;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class TablePanel extends JPanel
{
		int ProjectNo;

		int height,width;
		JLabel lblImage,lblText;
		JPanel pnlTable,pnlText,pnlButton;
		JButton btnProjectName;

		public void setProjectNo(int value)
		{
			ProjectNo=value;
		}
		public int getProjectNo()
		{
			return(ProjectNo);
		}


		public TablePanel(int width,int height)
		{
			ProjectNo=0;
			setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			setBackground(new Color(65,99,124));
			setLayout(null);
			this.width=width;
			this.height=height;

		}

		public void  displayTablePanel()
		{
			//setBounds(2,2,width,height);
			int x=(width-110)/2;
			int y=10;
			int w=110;
			int h=110;
			int gap=20;
			pnlTable=new JPanel();
			pnlTable.setBackground(Color.yellow);
			pnlTable.setLayout(new GridLayout(1,1));
			pnlTable.setBounds(x,y,w,h);

			add(pnlTable);
			lblImage=new JLabel(new ImageIcon("Images\\JavaLogo.jpg"));
			//lblImage.setBounds(2,2,width-4,height-4);
			pnlTable.add(lblImage);

			y=y+h+gap;


/*			pnlText=new JPanel();
			pnlText.setBounds(2,120,width-4,30);
			pnlText.setLayout(new GridLayout(1,1,1,1));

			lblText=new JLabel("",JLabel.CENTER);
			pnlText.add(lblText);

//			btnWaiter=new JButton("0");
//			pnlText.add(btnWaiter);

			add(pnlText);

*/

			pnlButton=new JPanel();
			pnlButton.setLayout(new GridLayout(1,1,5,5));
			pnlButton.setBounds(4,y,width-8,40);

			btnProjectName=new JButton("ProjectName");
			pnlButton.add(btnProjectName);


			add(pnlButton);

			//pnlButton;





		}

		public static void hideAllPanels(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlText);
			PanelStateInternal.hideComponents(temp.pnlButton);

			PanelStateInternal.hideComponents(temp);
		}
		public static void showAllPanels(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlText);
			PanelStateInternal.showComponents(temp.pnlButton);
			PanelStateInternal.showComponents(temp);
		}
		public static void disableAllPanels(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlText);
			PanelStateInternal.disableComponents(temp.pnlButton);
			PanelStateInternal.disableComponents(temp);
		}
		public static void visibleAllPanels(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlText);
			PanelStateInternal.visibleComponents(temp.pnlButton);
			PanelStateInternal.visibleComponents(temp);
		}


		public static void hideTextPanel(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlText);
		}
		public static void showTextPanel(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlText);
		}
		public static void disableTextPanel(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlText);
		}
		public static void visibleTextPanel(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlText);
		}

		public static void hideButtonPanel(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlButton);
		}
		public static void showButtonPanel(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlButton);
		}
		public static void disableButtonPanel(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlButton);
		}
		public static void visibleButtonPanel(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlButton);
		}


		public JPanel getMenuButtonPanel()
		{
			return(pnlButton);
		}
		public JButton getProjectNameButton()
		{
			return(btnProjectName);
		}

		public JLabel getTableLabel()
		{
			return(lblText);
		}

//		public JButton getWaiterButton()
//		{
//			return(btnWaiter);
//		}


}




class PanelStateInternal
{
	static void showComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(true);
		}
	}
	static void hideComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(false);
		}
	}
	static void visibleComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
  		  c.setVisible(true);
		}
		temp.setVisible(true);
	}
	static void disableComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
    		 c.setVisible(false);
		}
		temp.setVisible(false);
	}

}









/*
package BackUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class TablePanel extends JPanel
{
		int TableStatus;
		int TableNo;
		int CustomerNo;
		int WaiterNo;

		int height,width;
		JLabel lblImage,lblText;
		JPanel pnlTable,pnlText,pnlButton;
		JButton btnProjectName;

		//,btnWaiter;


		public boolean isSlotEmpty()
		{
			if(TableStatus==0)
				return(true);
			else
				return(false);
		}

		public void fillSlot()
		{
			TableStatus=1;
		}

		public void emptySlot()
		{
			TableStatus=0;
			TableNo=0;
			CustomerNo=0;
			WaiterNo=0;
		}

		void setSlotNo(int value)
		{
			TableNo=value;
		}
		int getSlotNo()
		{
			return(TableNo);
		}
		public void setCustomerNo(int value)
		{
			CustomerNo=value;
		}
		public int getCustomerNo()
		{
			return(CustomerNo);
		}
		public void setWaiterNo(int value)
		{
			WaiterNo=value;
		}
		public int getWaiterNo()
		{
			return(WaiterNo);
		}


		public TablePanel(int width,int height)
		{
			TableStatus=0;
			TableNo=0;
			CustomerNo=0;
			WaiterNo=0;

			setLayout(null);


			this.width=width;
			this.height=height;

		}

		public void  displayTablePanel()
		{
			//setBounds(2,2,width,height);
			int x=(width-110)/2;
			pnlTable=new JPanel();
			pnlTable.setBounds(x,5,110,110);

			add(pnlTable);
			lblImage=new JLabel(new ImageIcon("backUI\\Logo.png"));
			lblImage.setBounds(2,2,width-4,height-4);
			pnlTable.add(lblImage);

			pnlText=new JPanel();
			pnlText.setBounds(2,120,width-4,30);
			pnlText.setLayout(new GridLayout(1,2,1,1));

			lblText=new JLabel("",JLabel.CENTER);
			pnlText.add(lblText);

//			btnWaiter=new JButton("0");
//			pnlText.add(btnWaiter);

			add(pnlText);



			pnlButton=new JPanel();
			pnlButton.setLayout(new GridLayout(1,2,5,5));
			pnlButton.setBounds(2,155,width-4,40);

			btnProjectName=new JButton("ProjectName");
			pnlButton.add(btnProjectName);


			add(pnlButton);

			//pnlButton;





		}

		public static void hideAllPanels(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlText);
			PanelStateInternal.hideComponents(temp.pnlButton);

			PanelStateInternal.hideComponents(temp);
		}
		public static void showAllPanels(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlText);
			PanelStateInternal.showComponents(temp.pnlButton);
			PanelStateInternal.showComponents(temp);
		}
		public static void disableAllPanels(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlText);
			PanelStateInternal.disableComponents(temp.pnlButton);
			PanelStateInternal.disableComponents(temp);
		}
		public static void visibleAllPanels(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlText);
			PanelStateInternal.visibleComponents(temp.pnlButton);
			PanelStateInternal.visibleComponents(temp);
		}


		public static void hideTextPanel(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlText);
		}
		public static void showTextPanel(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlText);
		}
		public static void disableTextPanel(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlText);
		}
		public static void visibleTextPanel(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlText);
		}

		public static void hideButtonPanel(TablePanel temp)
		{
			PanelStateInternal.hideComponents(temp.pnlButton);
		}
		public static void showButtonPanel(TablePanel temp)
		{
			PanelStateInternal.showComponents(temp.pnlButton);
		}
		public static void disableButtonPanel(TablePanel temp)
		{
			PanelStateInternal.disableComponents(temp.pnlButton);
		}
		public static void visibleButtonPanel(TablePanel temp)
		{
			PanelStateInternal.visibleComponents(temp.pnlButton);
		}


		public JPanel getMenuButtonPanel()
		{
			return(pnlButton);
		}
		public JButton getProjectNameButton()
		{
			return(btnProjectName);
		}

		public JLabel getTableLabel()
		{
			return(lblText);
		}

//		public JButton getWaiterButton()
//		{
//			return(btnWaiter);
//		}


}




class PanelState
{
	static void showComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(true);
		}
	}
	static void hideComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			c.setEnabled(false);
		}
	}
	static void visibleComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
  		  c.setVisible(true);
		}
		temp.setVisible(true);
	}
	static void disableComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
        {
    		 c.setVisible(false);
		}
		temp.setVisible(false);
	}

}

*/