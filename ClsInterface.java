import java.sql.*;
import javax.swing.*;
class ClsInterface
{
	private int  InterfaceID ;
	private String InterfaceName;

	void setInterfaceID(int value)
	{
		InterfaceID = value;
	}
	int getInterfaceID()
	{
		return InterfaceID;
	}

	void setInterfaceName(String value)
	{
		InterfaceName = value;
	}
	String getInterfaceName()
	{
		return InterfaceName;
	}

	static void addNewRecord(ClsInterface temp)
	{
		DlsInterface.addNewRecord(temp);
	}

	static void updateRecord(ClsInterface temp)
	{
		DlsInterface.updateRecord(temp);
	}

	static void deleteRecord(ClsInterface temp)
	{
		DlsInterface.deleteRecord(temp);
	}

	static int getInterfaceIDFromName(String mInterfaceName)
	{
		return(DlsInterface.getInterfaceIDFromName(mInterfaceName));
	}
	static String getInterfaceNameFromID(int mInterfaceID)
	{
		return(DlsInterface.getInterfaceNameFromID(mInterfaceID));
	}
	static ClsInterface getInterfaceInformation(int mInterfaceID)
	{
		return(DlsInterface.getInterfaceInformation(mInterfaceID));
	}

	static void showInterface(ClsInterface temp)
	{
		System.out.println("Interface ID             : ..........    "+temp.getInterfaceID());
		System.out.println("Interface Name           : ..........    "+temp.getInterfaceName());
	}

	static ClsInterface[] getAllInterfaceInformation()
	{
		return(DlsInterface.getAllInterfaceInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsInterface.getAllRecordsCount());

	}

	static String[] getAllInterfaceRecords()
	{
		return(DlsInterface.getAllInterfaceRecords());
	}

	static void addInterfaceRecords(JComboBox cmbProcess)
	{
		String Query = "select InterfaceName from tblInterface order by InterfaceName";
		String data[]=getAllInterfaceRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Interface...");
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
