import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsDistrict
{
	static void addNewRecord(ClsDistrict temp)
	{
		String Query = "insert into tblDistrict(DistrictName,StateID) values('"+temp.getDistrictName()+"',"+temp.getStateID()+")";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsDistrict temp)
	{
		String Query = "update tblDistrict set DistrictName='"+temp.getDistrictName()+"' , StateID="+temp.getStateID()+" where DistrictID="+String.valueOf(temp.getDistrictID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsDistrict temp)
	{
		String Query = "delete from tblDistrict where DistrictID="+temp.getDistrictID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}


	static int getDistrictIDFromName(String mDistrictName)
	{
		String Query = "select DistrictID from tblDistrict where DistrictName='"+mDistrictName+"'";
		return(DBManager.getCode(Query));
	}

	static String getDistrictNameFromID(int mDistrictID)
	{
		String Query = "select DistrictName from tblDistrict where DistrictID="+String.valueOf(mDistrictID);
		return(DBManager.getName(Query));
	}

	static String getStateNameFromID(int mStateID)
	{
		String Query = "select StateName from tblState where StateID="+String.valueOf(mStateID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblDistrict";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mStateID)
	{
		String Query="Select Count(*) from tblDistrict   where StateID="+String.valueOf(mStateID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllDistrictRecords()
	{
		String Query="Select DistrictName from tblDistrict";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllDistrictRecords(int mStateID)
	{
		String Query="Select DistrictName from tblDistrict where StateID="+String.valueOf(mStateID);
		int rec=getAllRecordsCount(mStateID);
		return(DBManager.getAllRecords(Query,rec));
	}


	static ClsDistrict getDistrictInformation(int mDistrictID)
	{
		ClsDistrict temp = new ClsDistrict();
		String Query = "select * from tblDistrict where DistrictID="+String.valueOf(mDistrictID);
		String values[]=DBManager.getFullRow(Query,3);
		temp.setDistrictID(Integer.parseInt(values[0]));
		temp.setDistrictName(values[1]);
		temp.setStateID(Integer.parseInt(values[2]));
		return(temp);
	}

	static ClsDistrict[] getAllDistrictInformation()
	{
		int rec=getAllRecordsCount();
		ClsDistrict obj[]=new ClsDistrict[rec];
		String Query ="select * from tblDistrict";
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsDistrict();
			obj[i].setDistrictID(Integer.parseInt(values[i][0]));
			obj[i].setDistrictName(values[i][1]);
			obj[i].setStateID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}


	static ClsDistrict[] getAllDistrictInformation(int mStateID)
	{
		int rec=getAllRecordsCount(mStateID);
		ClsDistrict obj[]=new ClsDistrict[rec];
		String Query ="select * from tblDistrict  where StateID="+String.valueOf(mStateID);
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsDistrict();
			obj[i].setDistrictID(Integer.parseInt(values[i][0]));
			obj[i].setDistrictName(values[i][1]);
			obj[i].setStateID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}


	public static void main(String args[])
	{
              String nm[] = getAllDistrictRecords();
           System.out.println(nm);

	}

}

