import java.sql.*;
import javax.swing.*;

class ClsEventObject
{
	private int  EventObjectID ;
	private String EventObjectName;

	void setEventObjectID(int value)
	{
		EventObjectID = value;
	}
	int getEventObjectID()
	{
		return EventObjectID;
	}

	void setEventObjectName(String value)
	{
		EventObjectName = value;
	}
	String getEventObjectName()
	{
		return EventObjectName;
	}

	static void addNewRecord(ClsEventObject temp)
	{
		DlsEventObject.addNewRecord(temp);
	}

	static void updateRecord(ClsEventObject temp)
	{
		DlsEventObject.updateRecord(temp);
	}

	static void deleteRecord(ClsEventObject temp)
	{
		DlsEventObject.deleteRecord(temp);
	}

	static int getEventObjectIDFromName(String mEventObjectName)
	{
		return(DlsEventObject.getEventObjectIDFromName(mEventObjectName));
	}
	static String getEventObjectNameFromID(int mEventObjectID)
	{
		return(DlsEventObject.getEventObjectNameFromID(mEventObjectID));
	}
	static ClsEventObject getEventObjectInformation(int mEventObjectID)
	{
		return(DlsEventObject.getEventObjectInformation(mEventObjectID));
	}

	static void showEventObject(ClsEventObject temp)
	{
		System.out.println("EventObject ID             : ..........    "+temp.getEventObjectID());
		System.out.println("EventObject Name           : ..........    "+temp.getEventObjectName());
	}

	static ClsEventObject[] getAllEventObjectInformation()
	{
		return(DlsEventObject.getAllEventObjectInformation());
	}

	static int getAllRecordsCount()
	{
		return(DlsEventObject.getAllRecordsCount());
	}

	static String[] getAllEventObjectRecords()
	{
		return(DlsEventObject.getAllEventObjectRecords());
	}


	static void addEventObjectRecords(JComboBox cmbProcess)
	{
		String Query = "select EventObjectName from tblEventObject order by EventObjectName";
		String data[]=getAllEventObjectRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select EventObject...");
		for(String item : data)
		{
				cmbProcess.addItem(item);
		}
	}
}
