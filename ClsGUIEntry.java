import java.sql.*;
import javax.swing.*;

class ClsGUIEntry
{
	private int  GUIEntryID ;
	private String ObjectName;
	private String ObjectText;
	private int XValue;
	private int YValue;
	private int Width;
	private int Height;
	private int ElementID;
	private int ProjectID;
	private int FRed;
	private int FGreen;
	private int FBlue;
	private int BRed;
	private int BGreen;
	private int BBlue;

	public void setGUIEntryID(int value)
	{
		GUIEntryID = value;
	}
	public int getGUIEntryID()
	{
		return GUIEntryID;
	}

	public void setObjectName(String value)
	{
		ObjectName = value;
	}
	public String getObjectName()
	{
		return ObjectName;
	}

	public void setObjectText(String value)
	{
		ObjectText = value;
	}
	public String getObjectText()
	{
		return ObjectText;
	}

	public void setXValue(int value)
	{
		XValue = value;
	}
	public int getXValue()
	{
		return XValue;
	}

	public void setYValue(int value)
	{
		YValue = value;
	}
	public int getYValue()
	{
		return YValue;
	}

	public void setWidth(int value)
	{
		Width = value;
	}
	public int getWidth()
	{
		return Width;
	}

	public void setHeight(int value)
	{
		Height = value;
	}
	public int getHeight()
	{
		return Height;
	}

	public void setElementID(int value)
	{
		ElementID = value;
	}
	public int getElementID()
	{
		return ElementID;
	}

	public void setProjectID(int value)
	{
		ProjectID = value;
	}
	public int getProjectID()
	{
		return ProjectID;
	}

	public void setFRed(int value)
	{
		FRed = value;
	}
	public int getFRed()
	{
		return FRed;
	}

	public void setFGreen(int value)
	{
		FGreen = value;
	}
	public int getFGreen()
	{
		return FGreen;
	}

	public void setFBlue(int value)
	{
		FBlue = value;
	}
	public int getFBlue()
	{
		return FBlue;
	}

	public void setBRed(int value)
	{
		BRed = value;
	}
	public int getBRed()
	{
		return BRed;
	}

	public void setBGreen(int value)
	{
		BGreen = value;
	}
	public int getBGreen()
	{
		return BGreen;
	}

	public void setBBlue(int value)
	{
		BBlue = value;
	}
	public int getBBlue()
	{
		return BBlue;
	}



	static void addNewRecord(ClsGUIEntry temp)
	{
		DlsGUIEntry.addNewRecord(temp);
	}

	static void updateRecord(ClsGUIEntry temp)
	{
		DlsGUIEntry.updateRecord(temp);
	}

	static void deleteRecord(ClsGUIEntry temp)
	{
		DlsGUIEntry.deleteRecord(temp);
	}

	static int getGUIEntryIDFromName(String mObjectName)
	{
		return(DlsGUIEntry.getGUIEntryIDFromName(mObjectName));
	}
	static int getGUIEntryIDFromName(String mObjectName,int mProjectID)
	{
		return(DlsGUIEntry.getGUIEntryIDFromName(mObjectName,mProjectID));
	}

	static String getGUIEntryNameFromID(int mGUIEntryID)
	{
		return(DlsGUIEntry.getGUIEntryNameFromID(mGUIEntryID));
	}


	static int getAllRecordsCount()
	{
		return(DlsGUIEntry.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mProjectID)
	{
		return(DlsGUIEntry.getAllRecordsCount(mProjectID));
	}


	static int getAllRecordsCount(int mProjectID,int mElementID)
	{
		return(DlsGUIEntry.getAllRecordsCount(mProjectID,mElementID));
	}
	static boolean validateObjectName(String oName,int ProjectID)
	{
		return(DlsGUIEntry.validateObjectName(oName,ProjectID));
	}

	static String[] getAllGUIEntryRecords()
	{
		return(DlsGUIEntry.getAllGUIEntryRecords());
	}

	static String[] getAllGUIEntryRecords(int mProjectID)
	{
		return(DlsGUIEntry.getAllGUIEntryRecords(mProjectID));
	}


    static String[] getAllGUIEntryRecords(int mProjectID,int mElementID)
	{
		return(DlsGUIEntry.getAllGUIEntryRecords(mProjectID,mElementID));
	}

	static ClsGUIEntry getGUIEntryInformation(int mGUIEntryID)
	{
		return(DlsGUIEntry.getGUIEntryInformation(mGUIEntryID));
	}

	static ClsGUIEntry[] getAllGUIEntryInformation()
	{
		return(DlsGUIEntry.getAllGUIEntryInformation());
	}


	static ClsGUIEntry[] getAllGUIEntryInformation(int mProjectID)
	{
		return(DlsGUIEntry.getAllGUIEntryInformation(mProjectID));
	}

    static ClsGUIEntry[] getAllGUIEntryInformation(int mProjectID,int mElementID)
	{
		return(DlsGUIEntry.getAllGUIEntryInformation(mProjectID,mElementID));
	}




	static void showGUIEntry(ClsGUIEntry temp)
	{
		System.out.println("GUIEntry ID             : ..........    "+temp.getGUIEntryID());
		System.out.println("Object Name           : ..........    "+temp.getObjectName());
		System.out.println("Object Text          : ..........    "+temp.getObjectText());
		System.out.println("X Value                 : ..........    "+temp.getXValue());
		System.out.println("Y Value           : ..........    "+temp.getYValue());
		System.out.println("width           : ..........    "+temp.getWidth());
		System.out.println("Height          : ..........    "+temp.getHeight());
        System.out.println("Element ID             : ..........    "+temp.getElementID());
		System.out.println("Project  ID            : ..........    "+temp.getProjectID());
		System.out.println("FRead           : ..........    "+temp.getFRed());
		System.out.println("FGreen           : ..........    "+temp.getFGreen());
		System.out.println("FBlue           : ..........    "+temp.getFBlue());
		System.out.println("BRed           : ..........    "+temp.getBRed());
		System.out.println("BGreen           : ..........    "+temp.getBGreen());
		System.out.println("BBlue           : ..........    "+temp.getBBlue());



	}

	static void addGUIEntryRecords(JComboBox cmbProcess,int mProjectID)
	{
		String Query = "select ObjectName from tblGUIEntry where ProjectID ="+String.valueOf(mProjectID);
		String data[]=getAllGUIEntryRecords(mProjectID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select GUIEntryID ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	static void addGUIEntryRecords(JComboBox cmbProcess,int mProjectID,int mElementID)
	{
		String data[]=getAllGUIEntryRecords(mProjectID,mElementID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select GUIEntryID ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void main(String args[])
	{
		String data[]=getAllGUIEntryRecords(1,1);
		for(String item : data)
		{
			System.out.println(item);
		}

		//addGUIEntryRecords(cmbProcess,1,1);

	}
}
