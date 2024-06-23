import java.sql.*;
import javax.swing.*;

class ClsDistrict
{
	private int  DistrictID ;
	private String DistrictName;
	private int StateID;

	public void setDistrictID(int value)
	{
		DistrictID = value;
	}
	public int getDistrictID()
	{
		return DistrictID;
	}

	public void setDistrictName(String value)
	{
		DistrictName = value;
	}
	public String getDistrictName()
	{
		return DistrictName;
	}

	public void setStateID(int value)
	{
		StateID = value;
	}
	public int getStateID()
	{
		return StateID;
	}

	static void addNewRecord(ClsDistrict temp)
	{
		DlsDistrict.addNewRecord(temp);
	}

	static void updateRecord(ClsDistrict temp)
	{
		DlsDistrict.updateRecord(temp);
	}

	static void deleteRecord(ClsDistrict temp)
	{
		DlsDistrict.deleteRecord(temp);
	}

	static int getDistrictIDFromName(String mDistrictName)
	{
		return(DlsDistrict.getDistrictIDFromName(mDistrictName));
	}

	static String getDistrictNameFromID(int mDistrictID)
	{
		return(DlsDistrict.getDistrictNameFromID(mDistrictID));
	}

	static int getAllRecordsCount()
	{
		return(DlsDistrict.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mStateID)
	{
		return(DlsDistrict.getAllRecordsCount(mStateID));
	}

	static String[] getAllDistrictRecords()
	{
		return(DlsDistrict.getAllDistrictRecords());
	}

	static String[] getAllDistrictRecords(int mStateID)
	{
		return(DlsDistrict.getAllDistrictRecords(mStateID));
	}

	static ClsDistrict getDistrictInformation(int mDistrictID)
	{
		return(DlsDistrict.getDistrictInformation(mDistrictID));
	}

	static ClsDistrict[] getAllDistrictInformation()
	{
		return(DlsDistrict.getAllDistrictInformation());
	}


	static ClsDistrict[] getAllDistrictInformation(int mStateID)
	{
		return(DlsDistrict.getAllDistrictInformation(mStateID));
	}





	static void showDistrict(ClsDistrict temp)
	{
		System.out.println("District ID             : ..........    "+temp.getDistrictID());
		System.out.println("District Name           : ..........    "+temp.getDistrictName());
		System.out.println("StateID Id           : ..........    "+temp.getStateID());

	}

	static void addDistrictRecords(JComboBox cmbProcess,int mStateID)
	{
		String Query = "select DistrictName from tblDistrict where StateID ="+String.valueOf(mStateID);
		String data[]=getAllDistrictRecords(mStateID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select DistrictID ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void main(String args[])
	{

	}
}
