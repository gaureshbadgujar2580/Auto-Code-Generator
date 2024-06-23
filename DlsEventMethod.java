import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

public class DlsEventMethod
{
	static void addNewRecord(ClsEventMethod temp)
	{
		String Query = "insert into tblEventMethod(EventMethodName,InterfaceID)values('"+temp.getEventMethodName()+"',"+temp.getInterfaceID()+")";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsEventMethod temp)
	{
		String Query = "update tblEventMethod set EventMethodName='"+temp.getEventMethodName()+"' , InterfaceID = "+temp.getInterfaceID()+" where EventMethodID ="+String.valueOf(temp.getEventMethodID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsEventMethod temp)
	{
		String Query = "delete from tblEventMethod  where EventMethodID="+temp.getEventMethodID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getEventMethodIDFromName(String mEventMethodName)
	{
		String Query = "select EventMethodID from tblEventMethod where EventMethodName='"+mEventMethodName+"'";
		return(DBManager.getCode(Query));
	}

	static String getEventMethodNameFromID(int mEventMethodID)
	{
		String Query = "select EventMethodName from tblEventMethod where EventMethodID="+String.valueOf(mEventMethodID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblEventMethod";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mInterfaceID)
	{
		String Query="Select Count(*) from tblEventMethod   where InterfaceID="+String.valueOf(mInterfaceID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllEventMethodRecords()
	{
		String Query="Select EventMethodName from tblEventMethod";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllEventMethodRecords(int mInterfaceID)
	{
		String Query="Select EventMethodName from tblEventMethod where InterfaceID="+String.valueOf(mInterfaceID);
		int rec=getAllRecordsCount(mInterfaceID);
		return(DBManager.getAllRecords(Query,rec));
	}



	static ClsEventMethod getEventMethodInformation(int mEventMethodID)
	{
		ClsEventMethod temp = new ClsEventMethod();
		String Query = "select * from tblEventMethod where EventMethodID="+String.valueOf(mEventMethodID);
		String values[]=DBManager.getFullRow(Query,3);
		temp.setEventMethodID(Integer.parseInt(values[0]));
		temp.setEventMethodName(values[1]);
		temp.setInterfaceID(Integer.parseInt(values[2]));
		return(temp);
	}

	static ClsEventMethod[] getAllEventMethodInformation()
	{
		int rec=getAllRecordsCount();
		ClsEventMethod obj[]=new ClsEventMethod[rec];
		String Query ="select * from tblEventMethod";
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsEventMethod();
			obj[i].setEventMethodID(Integer.parseInt(values[i][0]));
			obj[i].setEventMethodName(values[i][1]);
			obj[i].setInterfaceID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}


	static ClsEventMethod[] getAllEventMethodInformation(int mInterfaceID)
	{
		int rec=getAllRecordsCount(mInterfaceID);
		ClsEventMethod obj[]=new ClsEventMethod[rec];
		String Query ="select * from tblEventMethod  where InterfaceID="+String.valueOf(mInterfaceID);
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsEventMethod();
			obj[i].setEventMethodID(Integer.parseInt(values[i][0]));
			obj[i].setEventMethodName(values[i][1]);
			obj[i].setInterfaceID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}

	public static void main(String args[])
	{
		DlsEventMethod A = new DlsEventMethod();
		System.out.println(getEventMethodNameFromID(1));

	}

}

