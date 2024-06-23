import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ClsArea
{
	private int AreaID;
	private String AreaName;
	private int TalukaID;
	private int VillageID;

	void setAreaID(int value)
	{
		AreaID=value;
	}
	int getAreaID()
	{
		return(AreaID);
	}

	void setAreaName(String value)
	{
		AreaName=value;
	}
	String getAreaName()
	{
		return(AreaName);
	}

	void setTalukaID(int value)
	{
		TalukaID=value;
	}
	int getTalukaID()
	{
		return(TalukaID);
	}

	void setVillageID(int value)
	{
		VillageID=value;
	}
	int getVillageID()
	{
		return(VillageID);
	}

	static void addNewRecords(ClsArea temp)
	{
		DlsArea.addNewRecords(temp);
	}

	static void deleteRecords(ClsArea temp)
	{
		DlsArea.deleteRecords(temp);
	}
	static void updateRecords(ClsArea temp)
	{
		DlsArea.updateRecords(temp);
	}

	static int getAreaIDFromName(String mAreaName)
	{
		return(DlsArea.getAreaIDFromName(mAreaName));
	}
	static ClsArea getAreaInformation(int mAreaID)
	{
		return(DlsArea.getAreaInformation(mAreaID));
	}

	static String getAreaNameFromID(int mAreaID)
	{
		return(DlsArea.getAreaNameFromID(mAreaID));

	}

	static void showTaluka(ClsArea temp)
	{
		System.out.println("Area ID             : ..........    "+temp.getAreaID());
		System.out.println("Area Name           : ..........    "+temp.getAreaName());
		System.out.println("Taluka Id           : ..........    "+temp.getTalukaID());

	}

	static void addAreaRecords(JComboBox cmbProcess , int mTalukaID)
	{
		String data[]=getAllAreaRecords(mTalukaID);

		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Area..");
		for(String item  :  data)
		{
			cmbProcess.addItem(item);
		}
	}

	static void addAreaRecordsTalukaWise(JComboBox cmbProcess, int mTalukaID)
	{
		String data[]=getAllAreaRecords(mTalukaID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Area..");
		for(String item  :  data)
		{
			cmbProcess.addItem(item);
		}
	}
	static void addAreaRecordsVillageWise(JComboBox cmbProcess , int mTalukaID, int mVillageID)
	{
		String data[]=getAllAreaRecords(mTalukaID,mVillageID);

		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Area..");
		for(String item  :  data)
		{
			cmbProcess.addItem(item);
		}

	}

	static void addAreaRecordsTalukaWise(JComboBox cmbProcess , int mTalukaID,int mVillageID)
	{

		String data[]=getAllAreaRecords(mTalukaID,mVillageID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Area..");
		for(String item  :  data)
		{
			cmbProcess.addItem(item);
		}

	}

	static ClsArea[] getAllAreaInformation()
	{
		return(DlsArea.getAllAreaInformation());
	}

	static ClsArea[] getAllAreaInformation(int mVillageID)
	{
		return(DlsArea.getAllAreaInformation(mVillageID));
	}

	static ClsArea[] getAllAreaInformation(int mTalukaID,int mVillageID)
	{
		return(DlsArea.getAllAreaInformation(mTalukaID,mVillageID));
	}
	static int getAllRecordsCount()
	{
		return(DlsArea.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mVillageID)
	{
		return(DlsArea.getAllRecordsCount(mVillageID));
	}

	static String[] getAllAreaRecords()
	{
		return(DlsArea.getAllAreaRecords());
	}

	static String[] getAllAreaRecords(int mTalukaID,int mVillageID)
	{
		return(DlsArea.getAllAreaRecords(mTalukaID,mVillageID));
	}

	static String[] getAllAreaRecords(int mAreaID)
	{
		return(DlsArea.getAllAreaRecords(mAreaID));
	}

	public static void main(String args[])
	{
		String data[]=getAllAreaRecords(4,13);
		for(String item : data)
		{
			System.out.println(item);
		}
	}
}

/**********************/

