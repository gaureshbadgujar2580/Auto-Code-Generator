import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsState
{
	static void addNewRecord(ClsState temp)
	{
		String Query = "insert into tblState(StateName,CountryID)values('"+temp.getStateName()+"',"+temp.getCountryID()+")";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsState temp)
	{
		String Query = "update tblState set StateName='"+temp.getStateName()+"' , CountryID = "+temp.getCountryID()+" where StateID ="+String.valueOf(temp.getStateID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsState temp)
	{
		String Query = "delete from tblState  where StateID="+temp.getStateID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getStateIDFromName(String mStateName)
	{
		String Query = "select StateID from tblState where StateName='"+mStateName+"'";
		return(DBManager.getCode(Query));
	}

	static String getStateNameFromID(int mStateID)
	{
		String Query = "select StateName from tblState where StateID="+String.valueOf(mStateID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblState";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mCountryID)
	{
		String Query="Select Count(*) from tblState   where CountryID="+String.valueOf(mCountryID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllStateRecords()
	{
		String Query="Select StateName from tblState";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllStateRecords(int mCountryID)
	{
		String Query="Select StateName from tblState where CountryID="+String.valueOf(mCountryID);
		int rec=getAllRecordsCount(mCountryID);
		return(DBManager.getAllRecords(Query,rec));
	}



	static ClsState getStateInformation(int mStateID)
	{
		ClsState temp = new ClsState();
		String Query = "select * from tblState where StateID="+String.valueOf(mStateID);
		String values[]=DBManager.getFullRow(Query,3);
		temp.setStateID(Integer.parseInt(values[0]));
		temp.setStateName(values[1]);
		temp.setCountryID(Integer.parseInt(values[2]));
		return(temp);
	}

	static ClsState[] getAllStateInformation()
	{
		int rec=getAllRecordsCount();
		ClsState obj[]=new ClsState[rec];
		String Query ="select * from tblState";
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsState();
			obj[i].setStateID(Integer.parseInt(values[i][0]));
			obj[i].setStateName(values[i][1]);
			obj[i].setCountryID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}


	static ClsState[] getAllStateInformation(int mCountryID)
	{
		int rec=getAllRecordsCount(mCountryID);
		ClsState obj[]=new ClsState[rec];
		String Query ="select * from tblState  where CountryID="+String.valueOf(mCountryID);
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsState();
			obj[i].setStateID(Integer.parseInt(values[i][0]));
			obj[i].setStateName(values[i][1]);
			obj[i].setCountryID(Integer.parseInt(values[i][2]));
		}
		return(obj);
	}

	public static void main(String args[])
	{
	}

}

