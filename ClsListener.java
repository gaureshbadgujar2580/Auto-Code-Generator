import java.sql.*;
import javax.swing.*;
class ClsListener
{
	private int  ListenerID ;
	private String ListenerName;

	void setListenerID(int value)
	{
		ListenerID = value;
	}
	int getListenerID()
	{
		return ListenerID;
	}

	void setListenerName(String value)
	{
		ListenerName = value;
	}
	String getListenerName()
	{
		return ListenerName;
	}

	static void addNewRecord(ClsListener temp)
	{
		DlsListener.addNewRecord(temp);
	}

	static void updateRecord(ClsListener temp)
	{
		DlsListener.updateRecord(temp);
	}

	static void deleteRecord(ClsListener temp)
	{
		DlsListener.deleteRecord(temp);
	}

	static int getListenerIDFromName(String mListenerName)
	{
		return(DlsListener.getListenerIDFromName(mListenerName));
	}
	static String getListenerNameFromID(int mListenerID)
	{
		return(DlsListener.getListenerNameFromID(mListenerID));
	}
	static ClsListener getListenerInformation(int mListenerID)
	{
		return(DlsListener.getListenerInformation(mListenerID));
	}

	static void showListener(ClsListener temp)
	{
		System.out.println("Listener ID             : ..........    "+temp.getListenerID());
		System.out.println("Listener Name           : ..........    "+temp.getListenerName());
	}

	static ClsListener[] getAllListenerInformation()
	{
		return(DlsListener.getAllListenerInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsListener.getAllRecordsCount());

	}

	static String[] getAllListenerRecords()
	{
		return(DlsListener.getAllListenerRecords());
	}

	static void addListenerRecords(JComboBox cmbProcess)
	{
		String Query = "select ListenerName from tblListener order by ListenerName";
		String data[]=getAllListenerRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Listener...");
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
