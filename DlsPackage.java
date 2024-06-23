import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsPackage
{
	static void addNewRecord(ClsPackage temp)
	{
		String Q = "insert into tblPackage(PackageName)values('"+temp.getPackageName()+"')";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsPackage temp)
	{
		String Q = "update tblPackage set PackageName='"+temp.getPackageName()+"' where PackageID ="+String.valueOf(temp.getPackageID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsPackage temp)
	{
		String Q = "delete from tblPackage  where PackageID="+temp.getPackageID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getPackageIDFromName(String mPackageName)
	{
		String Q = "select PackageID from tblPackage where PackageName='"+mPackageName+"'";
		return(DBManager.getCode(Q));
	}


	static String getPackageNameFromID(int mPackageID)
	{
		String Q = "select PackageName from tblPackage where PackageID="+String.valueOf(mPackageID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblPackage";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllPackageRecords()
	{
		String Q="Select PackageName from tblPackage";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsPackage getPackageInformation(int mPackageID)
	{
		ClsPackage temp = new ClsPackage();
		String Q = "select * from tblPackage where PackageID="+String.valueOf(mPackageID);
		String values[]=DBManager.getFullRow(Q,2);
		temp.setPackageID(Integer.parseInt(values[0]));
		temp.setPackageName(values[1]);
		return(temp);
	}


	static ClsPackage[] getAllPackageInformation()
	{
		int rec=getAllRecordsCount();
		ClsPackage obj[]=new ClsPackage[rec];
		String Query ="select * from tblPackage";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsPackage();
			obj[i].setPackageID(Integer.parseInt(values[i][0]));
			obj[i].setPackageName(values[i][1]);
		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

