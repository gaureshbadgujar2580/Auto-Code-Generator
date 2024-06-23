import java.sql.*;
import javax.swing.*;
class ClsPackage
{
	private int  PackageID ;
	private String PackageName;


	void setPackageID(int value)
	{
		PackageID = value;
	}
	int getPackageID()
	{
		return PackageID;
	}

	void setPackageName(String value)
	{
		PackageName = value;
	}
	String getPackageName()
	{
		return PackageName;
	}

	static void addNewRecord(ClsPackage temp)
	{
		DlsPackage.addNewRecord(temp);
	}

	static void updateRecord(ClsPackage temp)
	{
		DlsPackage.updateRecord(temp);
	}

	static void deleteRecord(ClsPackage temp)
	{
		DlsPackage.deleteRecord(temp);
	}

	static int getPackageIDFromName(String mPackageName)
	{
		return(DlsPackage.getPackageIDFromName(mPackageName));
	}
	static String getPackageNameFromID(int mPackageID)
	{
		return(DlsPackage.getPackageNameFromID(mPackageID));
	}
	static ClsPackage getPackageInformation(int mPackageID)
	{
		return(DlsPackage.getPackageInformation(mPackageID));
	}

	static void showPackage(ClsPackage temp)
	{
		System.out.println("Package ID             : ..........    "+temp.getPackageID());
		System.out.println("Package Name           : ..........    "+temp.getPackageName());
	}

	static ClsPackage[] getAllPackageInformation()
	{
		return(DlsPackage.getAllPackageInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsPackage.getAllRecordsCount());

	}

	static String[] getAllPackageRecords()
	{
		return(DlsPackage.getAllPackageRecords());
	}

	static void addPackageRecords(JComboBox cmbProcess)
	{
		String Query = "select PackageName from tblPackage order by PackageName";
		String data[]=getAllPackageRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Package...");
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
