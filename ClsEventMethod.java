import java.sql.*;
import javax.swing.*;
import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class ClsEventMethod
{
	private int  EventMethodID ;
	private String EventMethodName;
	private int InterfaceID;

	void setEventMethodID(int value)
	{
		EventMethodID = value;
	}
	int getEventMethodID()
	{
		return EventMethodID;
	}

	void setEventMethodName(String value)
	{
		EventMethodName = value;
	}
	String getEventMethodName()
	{
		return EventMethodName;
	}

	void setInterfaceID(int value)
	{
		InterfaceID = value;
	}
	int getInterfaceID()
	{
		return InterfaceID;
	}

	static void addNewRecord(ClsEventMethod temp)
	{
		DlsEventMethod.addNewRecord(temp);
	}

	static void updateRecord(ClsEventMethod temp)
	{
		DlsEventMethod.updateRecord(temp);
	}

	static void deleteRecord(ClsEventMethod temp)
	{
		DlsEventMethod.deleteRecord(temp);
	}

	static int getEventMethodIDFromName(String mEventMethodName)
	{
		return(DlsEventMethod.getEventMethodIDFromName(mEventMethodName));
	}

	static String getEventMethodNameFromID(int mEventMethodID)
	{
		return(DlsEventMethod.getEventMethodNameFromID(mEventMethodID));
	}

	static int getAllRecordsCount()
	{
		return(DlsEventMethod.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mInterfaceID)
	{
		return(DlsEventMethod.getAllRecordsCount(mInterfaceID));
	}

	static String[] getAllEventMethodRecords()
	{
		return(DlsEventMethod.getAllEventMethodRecords());
	}

	static String[] getAllEventMethodRecords(int mInterfaceID)
	{
		return(DlsEventMethod.getAllEventMethodRecords(mInterfaceID));
	}

	static ClsEventMethod getEventMethodInformation(int mEventMethodID)
	{
		return(DlsEventMethod.getEventMethodInformation(mEventMethodID));
	}

	static ClsEventMethod[] getAllEventMethodInformation()
	{
		return(DlsEventMethod.getAllEventMethodInformation());
	}


	static ClsEventMethod[] getAllEventMethodInformation(int mEventMethodID)
	{
		return(DlsEventMethod.getAllEventMethodInformation(mEventMethodID));
	}





	static void showEventMethod(ClsEventMethod temp)
	{
		System.out.println("EventMethod ID             : ..........    "+temp.getEventMethodID());
		System.out.println("EventMethod Name           : ..........    "+temp.getEventMethodName());
		System.out.println("Interface Id           : ..........    "+temp.getInterfaceID());

	}

	static void addEventMethodRecords(JComboBox cmbProcess,int mInterfaceID)
	{
		String Query = "select EventMethodName from tblEventMethod where InterfaceID ="+String.valueOf(mInterfaceID);
		String data[]=getAllEventMethodRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select EventMethod ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	static void addEventMethodRecords(JComboBox cmbProcess)
	{
		String Query = "select EventMethodName from tblEventMethod order by EventMethodName";
		String data[]=getAllEventMethodRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select EventMethod ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	public static void main(String args[])
	{
		ClsEventMethod Data[]=ClsEventMethod.getAllEventMethodInformation(1);

		for(ClsEventMethod Item :Data)
		{
			ClsEventMethod.showEventMethod(Item);

		}

	}
}
