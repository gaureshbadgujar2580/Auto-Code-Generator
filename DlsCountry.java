import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsCountry
{
	static void addNewRecord(ClsCountry temp)
	{
		String Q = "insert into tblCountry(CountryName)values('"+temp.getCountryName()+"')";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsCountry temp)
	{
		String Q = "update tblCountry set CountryName='"+temp.getCountryName()+"' where CountryID ="+String.valueOf(temp.getCountryID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsCountry temp)
	{
		String Q = "delete from tblCountry  where CountryID="+temp.getCountryID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getCountryIDFromName(String mCountryName)
	{
		String Q = "select CountryID from tblCountry where CountryName='"+mCountryName+"'";
		return(DBManager.getCode(Q));
	}


	static String getCountryNameFromID(int mCountryID)
	{
		String Q = "select CountryName from tblCountry where CountryID="+String.valueOf(mCountryID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblCountry";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllCountryRecords()
	{
		String Q="Select CountryName from tblCountry";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsCountry getCountryInformation(int mCountryID)
	{
		ClsCountry temp = new ClsCountry();
		String Q = "select * from tblCountry where CountryID="+String.valueOf(mCountryID);
		String values[]=DBManager.getFullRow(Q,2);
		temp.setCountryID(Integer.parseInt(values[0]));
		temp.setCountryName(values[1]);
		return(temp);
	}


	static ClsCountry[] getAllCountryInformation()
	{
		int rec=getAllRecordsCount();
		ClsCountry obj[]=new ClsCountry[rec];
		String Query ="select * from tblCountry";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsCountry();
			obj[i].setCountryID(Integer.parseInt(values[i][0]));
			obj[i].setCountryName(values[i][1]);
		}
		return(obj);
	}


	public static void main(String args[])
	{
	}

}

