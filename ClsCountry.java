import java.sql.*;
import javax.swing.*;
class ClsCountry
{
	private int  CountryID ;
	private String CountryName;

	void setCountryID(int value)
	{
		CountryID = value;
	}
	int getCountryID()
	{
		return CountryID;
	}

	void setCountryName(String value)
	{
		CountryName = value;
	}
	String getCountryName()
	{
		return CountryName;
	}

	static void addNewRecord(ClsCountry temp)
	{
		DlsCountry.addNewRecord(temp);
	}

	static void updateRecord(ClsCountry temp)
	{
		DlsCountry.updateRecord(temp);
	}

	static void deleteRecord(ClsCountry temp)
	{
		DlsCountry.deleteRecord(temp);
	}

	static int getCountryIDFromName(String mCountryName)
	{
		return(DlsCountry.getCountryIDFromName(mCountryName));
	}
	static String getCountryNameFromID(int mCountryID)
	{
		return(DlsCountry.getCountryNameFromID(mCountryID));
	}
	static ClsCountry getCountryInformation(int mCountryID)
	{
		return(DlsCountry.getCountryInformation(mCountryID));
	}

	static void showCountry(ClsCountry temp)
	{
		System.out.println("Country ID             : ..........    "+temp.getCountryID());
		System.out.println("Country Name           : ..........    "+temp.getCountryName());
	}

	static ClsCountry[] getAllCountryInformation()
	{
		return(DlsCountry.getAllCountryInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsCountry.getAllRecordsCount());
	}

	static String[] getAllCountryRecords()
	{
		return(DlsCountry.getAllCountryRecords());
	}

	static void addCountryRecords(JComboBox cmbProcess)
	{
		String Query = "select CountryName from tblCountry order by CountryName";
		String data[]=getAllCountryRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Country...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}
	public static void main(String args[])
	{
	//	System.out.println(getCountryNameFromTalukaID(4));
	}
}
