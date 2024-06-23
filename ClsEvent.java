import java.sql.*;
import javax.swing.*;
class ClsEvent
{
	private int  EventID ;
	private String EventName;

	void setEventID(int value)
	{
		EventID = value;
	}
	int getEventID()
	{
		return EventID;
	}

	void setEventName(String value)
	{
		EventName = value;
	}
	String getEventName()
	{
		return EventName;
	}

	static void addNewRecord(ClsEvent temp)
	{
		DlsEvent.addNewRecord(temp);
	}

	static void updateRecord(ClsEvent temp)
	{
		DlsEvent.updateRecord(temp);
	}

	static void deleteRecord(ClsEvent temp)
	{
		DlsEvent.deleteRecord(temp);
	}

	static int getEventIDFromName(String mEventName)
	{
		return(DlsEvent.getEventIDFromName(mEventName));
	}
	static String getEventNameFromID(int mEventID)
	{
		return(DlsEvent.getEventNameFromID(mEventID));
	}
	static ClsEvent getEventInformation(int mEventID)
	{
		return(DlsEvent.getEventInformation(mEventID));
	}

	static void showEvent(ClsEvent temp)
	{
		System.out.println("Event ID             : ..........    "+temp.getEventID());
		System.out.println("Event Name           : ..........    "+temp.getEventName());
	}

	static ClsEvent[] getAllEventInformation()
	{
		return(DlsEvent.getAllEventInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsEvent.getAllRecordsCount());

	}

	static String[] getAllEventRecords()
	{
		return(DlsEvent.getAllEventRecords());
	}

	static void addEventRecords(JComboBox cmbProcess)
	{
		String Query = "select EventName from tblEvent order by EventName";
		String data[]=getAllEventRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Event...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void main(String args[])
	{
		System.out.println(getAllRecordsCount());
	}
}
