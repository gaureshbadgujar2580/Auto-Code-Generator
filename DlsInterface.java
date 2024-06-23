import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsInterface
{
	static void addNewRecord(ClsInterface temp)
	{
		String Query = "insert into tblInterface(InterfaceName)values('"+temp.getInterfaceName()+"')";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsInterface temp)
	{
		String Query = "update tblInterface set InterfaceName='"+temp.getInterfaceName()+"' where InterfaceID ="+String.valueOf(temp.getInterfaceID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsInterface temp)
	{
		String Query = "delete from tblInterface  where InterfaceID="+temp.getInterfaceID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getInterfaceIDFromName(String mInterfaceName)
	{
		String Query = "select InterfaceID from tblInterface where InterfaceName='"+mInterfaceName+"'";
		return(DBManager.getCode(Query));
	}


	static String getInterfaceNameFromID(int mInterfaceID)
	{
		String Query = "select InterfaceName from tblInterface where InterfaceID="+String.valueOf(mInterfaceID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblInterface";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllInterfaceRecords()
	{
		String Query="Select InterfaceName from tblInterface";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}



	static ClsInterface getInterfaceInformation(int mInterfaceID)
	{
		ClsInterface temp = new ClsInterface();
		String Query = "select * from tblInterface where InterfaceID="+String.valueOf(mInterfaceID);
		String values[]=DBManager.getFullRow(Query,2);
		temp.setInterfaceID(Integer.parseInt(values[0]));
		temp.setInterfaceName(values[1]);
		return(temp);
	}


	static ClsInterface[] getAllInterfaceInformation()
	{
		int rec=getAllRecordsCount();
		ClsInterface obj[]=new ClsInterface[rec];
		String Query ="select * from tblInterface";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsInterface();
			obj[i].setInterfaceID(Integer.parseInt(values[i][0]));
			obj[i].setInterfaceName(values[i][1]);
		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

