import java.sql.*;
import javax.swing.*;

class ClsTaluka
{
	private int  TalukaID ;
	private String TalukaName;
	private int DistrictID;

	void setTalukaID(int value)
	{
		TalukaID = value;
	}
	int getTalukaID()
	{
		return TalukaID;
	}

	void setTalukaName(String value)
	{
		TalukaName = value;
	}
	String getTalukaName()
	{
		return TalukaName;
	}

	void setDistrictID(int value)
	{
		DistrictID = value;
	}
	int getDistrictID()
	{
		return DistrictID;
	}

	static void addNewRecord(ClsTaluka temp)
	{
		DlsTaluka.addNewRecord(temp);
	}

	static void updateRecord(ClsTaluka temp)
	{
		DlsTaluka.updateRecord(temp);
	}

	static void deleteRecord(ClsTaluka temp)
	{
		DlsTaluka.deleteRecord(temp);
	}

	static int getTalukaIDFromName(String mTalukaName)
	{
		return(DlsTaluka.getTalukaIDFromName(mTalukaName));
	}

	static String getTalukaNameFromID(int mTalukaID)
	{
		return(DlsTaluka.getTalukaNameFromID(mTalukaID));
	}

	static int getAllRecordsCount()
	{
		return(DlsTaluka.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mDistrictID)
	{
		return(DlsTaluka.getAllRecordsCount(mDistrictID));
	}

	static String[] getAllTalukaRecords()
	{
		return(DlsTaluka.getAllTalukaRecords());
	}

	static String[] getAllTalukaRecords(int mTalukaID)
	{
		return(DlsTaluka.getAllTalukaRecords(mTalukaID));
	}

	static ClsTaluka getTalukaInformation(int mTalukaID)
	{
		return(DlsTaluka.getTalukaInformation(mTalukaID));
	}

	static ClsTaluka[] getAllTalukaInformation()
	{
		return(DlsTaluka.getAllTalukaInformation());
	}

	static ClsTaluka[] getAllTalukaInformation(int mDistrictID)
	{
		return(DlsTaluka.getAllTalukaInformation(mDistrictID));
	}

	static void showTaluka(ClsTaluka temp)
	{
		System.out.println("Taluka ID             : ..........    "+temp.getTalukaID());
		System.out.println("Taluka Name           : ..........    "+temp.getTalukaName());
		System.out.println("DistrictID Id           : ..........    "+temp.getDistrictID());

	}

	static void addTalukaRecords(JComboBox cmbProcess,int mDistrictID)
	{
		String Query = "select TalukaName from tblTaluka where DistrictID ="+String.valueOf(mDistrictID);
		String data[]=getAllTalukaRecords(mDistrictID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select TalukaID ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}
	public static void main(String args[])
	{

	}
}
