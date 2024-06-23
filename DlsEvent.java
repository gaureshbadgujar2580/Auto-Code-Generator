import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsEvent
{
	static void addNewRecord(ClsEvent temp)
	{
		String Query = "insert into tblEvent(EventName)values('"+temp.getEventName()+"')";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsEvent temp)
	{
		String Query = "update tblEvent set EventName='"+temp.getEventName()+"' where EventID ="+String.valueOf(temp.getEventID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsEvent temp)
	{
		String Query = "delete from tblEvent  where EventID="+temp.getEventID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getEventIDFromName(String mEventName)
	{
		String Query = "select EventID from tblEvent where EventName='"+mEventName+"'";
		return(DBManager.getCode(Query));
	}


	static String getEventNameFromID(int mEventID)
	{
		String Query = "select EventName from tblEvent where EventID="+String.valueOf(mEventID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblEvent";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllEventRecords()
	{
		String Query="Select EventName from tblEvent";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}



	static ClsEvent getEventInformation(int mEventID)
	{
		ClsEvent temp = new ClsEvent();
		String Query = "select * from tblEvent where EventID="+String.valueOf(mEventID);
		String values[]=DBManager.getFullRow(Query,2);
		temp.setEventID(Integer.parseInt(values[0]));
		temp.setEventName(values[1]);
		return(temp);
	}


	static ClsEvent[] getAllEventInformation()
	{
		int rec=getAllRecordsCount();
		ClsEvent obj[]=new ClsEvent[rec];
		String Query ="select * from tblEvent";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsEvent();
			obj[i].setEventID(Integer.parseInt(values[i][0]));
			obj[i].setEventName(values[i][1]);
		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

