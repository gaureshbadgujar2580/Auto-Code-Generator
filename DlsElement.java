import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsElement
{
	static void addNewRecord(ClsElement temp)
	{
		String Q = "insert into tblElement(ElementName,ElementDescription,ElementAbbrivation)values('"+temp.getElementName()+"','"+temp.getElementDescription()+"','"+temp.getElementAbbrivation()+"')";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsElement temp)
	{
		String Q = "update tblElement set ElementName='"+temp.getElementName()+"', ElementDescription='"+temp.getElementDescription()+"', ElementAbbrivation='"+temp.getElementAbbrivation()+"' where ElementID ="+String.valueOf(temp.getElementID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsElement temp)
	{
		String Q = "delete from tblElement  where ElementID="+temp.getElementID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getElementIDFromName(String mElementName)
	{
		String Q = "select ElementID from tblElement where ElementName='"+mElementName+"'";
		return(DBManager.getCode(Q));
	}


	static String getElementNameFromID(int mElementID)
	{
		String Q = "select ElementName from tblElement where ElementID="+String.valueOf(mElementID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblElement";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllElementRecords()
	{
		String Q="Select ElementName from tblElement";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsElement getElementInformation(int mElementID)
	{
		ClsElement temp = new ClsElement();
		String Q = "select * from tblElement where ElementID="+String.valueOf(mElementID);
		String values[]=DBManager.getFullRow(Q,4);
		temp.setElementID(Integer.parseInt(values[0]));
		temp.setElementName(values[1]);
		temp.setElementDescription(values[2]);
		temp.setElementAbbrivation(values[3]);

		return(temp);
	}


	static ClsElement[] getAllElementInformation()
	{
		int rec=getAllRecordsCount();
		ClsElement obj[]=new ClsElement[rec];
		String Query ="select * from tblElement";
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsElement();
			obj[i].setElementID(Integer.parseInt(values[i][0]));
			obj[i].setElementName(values[i][1]);
			obj[i].setElementDescription(values[i][2]);
			obj[i].setElementAbbrivation(values[i][3]);

		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

