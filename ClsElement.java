import java.sql.*;
import javax.swing.*;
class ClsElement
{
	private int  ElementID ;
	private String ElementName;
	private String ElementDescription;
	private String ElementAbbrivation;


	void setElementID(int value)
	{
		ElementID = value;
	}
	int getElementID()
	{
		return ElementID;
	}

	void setElementName(String value)
	{
		ElementName = value;
	}
	String getElementName()
	{
		return (ClsElement.getSwingLabel(ElementName));
	}

	static String getSwingLabel(String mElementName)
	{
		if(mElementName.equalsIgnoreCase("JLabel"))
		{
			return("JLabel");
		}
		else if(mElementName.equalsIgnoreCase("JList"))
		{
			return("JList");
		}
		else if(mElementName.equalsIgnoreCase("JButton"))
		{
			return("JButton");
		}
		else
		{
			return(mElementName);
		}
	}



    void setElementDescription(String value)
	{
		ElementDescription = value;
	}
	String getElementDescription()
	{
		return ElementDescription;
	}

    void setElementAbbrivation(String value)
	{
		ElementAbbrivation = value;
	}
	String getElementAbbrivation()
	{
		return ElementAbbrivation;
	}

	static void addNewRecord(ClsElement temp)
	{
		DlsElement.addNewRecord(temp);
	}

	static void updateRecord(ClsElement temp)
	{
		DlsElement.updateRecord(temp);
	}

	static void deleteRecord(ClsElement temp)
	{
		DlsElement.deleteRecord(temp);
	}

	static int getElementIDFromName(String mElementName)
	{
		return(DlsElement.getElementIDFromName(mElementName));
	}
	static String getElementNameFromID(int mElementID)
	{
		return(ClsElement.getSwingLabel(DlsElement.getElementNameFromID(mElementID)));
	}
	static ClsElement getElementInformation(int mElementID)
	{
		return(DlsElement.getElementInformation(mElementID));
	}

	static void showElement(ClsElement temp)
	{
		System.out.println("Element ID             : ..........    "+temp.getElementID());
		System.out.println("Element Name           : ..........    "+temp.getElementName());
		System.out.println("Element Description           : ..........    "+temp.getElementDescription());
		System.out.println("Element Abbrivation           : ..........    "+temp.getElementAbbrivation());

	}

	static ClsElement[] getAllElementInformation()
	{
		return(DlsElement.getAllElementInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsElement.getAllRecordsCount());

	}

	static String[] getAllElementRecords()
	{
		return(DlsElement.getAllElementRecords());
	}

	static void addElementRecords(JComboBox cmbProcess)
	{
		String Query = "select ElementName from tblElement order by ElementName";
		String data[]=getAllElementRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Element...");
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
