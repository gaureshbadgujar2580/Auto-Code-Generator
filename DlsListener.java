import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsListener
{
	static void addNewRecord(ClsListener temp)
	{
		String Q = "insert into tblListener(ListenerName)values('"+temp.getListenerName()+"')";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsListener temp)
	{
		String Q = "update tblListener set ListenerName='"+temp.getListenerName()+"' where ListenerID ="+String.valueOf(temp.getListenerID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsListener temp)
	{
		String Q = "delete from tblListener  where ListenerID="+temp.getListenerID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getListenerIDFromName(String mListenerName)
	{
		String Q = "select ListenerID from tblListener where ListenerName='"+mListenerName+"'";
		return(DBManager.getCode(Q));
	}


	static String getListenerNameFromID(int mListenerID)
	{
		String Q = "select ListenerName from tblListener where ListenerID="+String.valueOf(mListenerID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblListener";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllListenerRecords()
	{
		String Q="Select ListenerName from tblListener";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsListener getListenerInformation(int mListenerID)
	{
		ClsListener temp = new ClsListener();
		String Q = "select * from tblListener where ListenerID="+String.valueOf(mListenerID);
		String values[]=DBManager.getFullRow(Q,2);
		temp.setListenerID(Integer.parseInt(values[0]));
		temp.setListenerName(values[1]);
		return(temp);
	}


	static ClsListener[] getAllListenerInformation()
	{
		int rec=getAllRecordsCount();
		ClsListener obj[]=new ClsListener[rec];
		String Query ="select * from tblListener";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsListener();
			obj[i].setListenerID(Integer.parseInt(values[i][0]));
			obj[i].setListenerName(values[i][1]);
		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

