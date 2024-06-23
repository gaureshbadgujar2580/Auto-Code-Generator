import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsGUIEntry
{
	static void addNewRecord(ClsGUIEntry temp)
	{
		String Query = "insert into tblGUIEntry(ObjectName,ObjectText,XValue,YValue,Width,Height,ElementID,ProjectID,FRed,FGreen,FBlue,BRed,BGreen,BBlue)"+
								"values('"+temp.getObjectName()+"','"+
								temp.getObjectText()+"',"+
								temp.getXValue()+","+
								temp.getYValue()+","+
								temp.getWidth()+","+
								temp.getHeight()+","+
								temp.getElementID()+","+
								temp.getProjectID()+","+
								temp.getFRed()+","+
								temp.getFGreen()+","+
								temp.getFBlue()+","+
								temp.getBRed()+","+
								temp.getBGreen()+","+
								temp.getBBlue()+")";

		DBManager.addNewRecord(Query);
	}

	static void updateRecord(ClsGUIEntry temp)
	{
		String Query = "update tblGUIEntry set " +
						"ObjectName='"+temp.getObjectName()+"',"+
						"ObjectText='"+temp.getObjectText()+"',"+
						"XValue="+temp.getXValue()+","+
						"YValue="+temp.getYValue()+","+
						"Width="+temp.getWidth()+","+
						"Height="+temp.getHeight()+","+
						"ElementID="+temp.getElementID()+","+
						"ProjectID="+temp.getProjectID()+","+
						"FRed="+temp.getFRed()+","+
						"FGreen="+temp.getFGreen()+","+
						"FBlue="+temp.getFBlue()+","+
						"BRed="+temp.getBRed()+","+
						"BGreen="+temp.getBGreen()+","+
						"BBlue="+temp.getBBlue()+
						" where GUIEntryID ="+String.valueOf(temp.getGUIEntryID());

		DBManager.addNewRecord(Query);
	}

	static void deleteRecord(ClsGUIEntry temp)
	{
		String Query = "delete * from tblGUIEntry where GUIEntryID="+temp.getGUIEntryID();
		DBManager.addNewRecord(Query);
	}

	static int getGUIEntryIDFromName(String mObjectName)
	{
		String Query = "select GUIEntryID from tblGUIEntry where ObjectName='"+mObjectName+"'";
		return(DBManager.getCode(Query));
	}
	static int getGUIEntryIDFromName(String mObjectName,int mProjectID)
	{
		String Query = "select GUIEntryID from tblGUIEntry where ObjectName='"+mObjectName+"' and ProjectID="+String.valueOf(mProjectID);
		return(DBManager.getCode(Query));
	}

	static String getGUIEntryNameFromID(int mGUIEntryID)
	{
		String Query = "select ObjectName from tblGUIEntry where GUIEntryID="+String.valueOf(mGUIEntryID);
		return(DBManager.getName(Query));
	}

	static String getProjectNameFromID(int mProjectID)
	{
		String Query = "select ProjectName from tblProject where ProjectID="+String.valueOf(mProjectID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount(int mProjectID)
	{
		String Query="Select Count(*) from tblGUIEntry  where ProjectID="+String.valueOf(mProjectID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}
	static int getAllRecordsCount(String mObjectName,int mProjectID)
	{
		String Query="Select Count(*) from tblGUIEntry  where ObjectName = '"+mObjectName+"' and ProjectID="+String.valueOf(mProjectID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblGUIEntry";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static int getAllRecordsCount(int mProjectID,int mElementID)
	{
		String Query="Select Count(*) from tblGUIEntry  where ElementID="+String.valueOf(mElementID)+" and ProjectID="+String.valueOf(mElementID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static String[] getAllGUIEntryRecords()
	{
		String Query="Select ObjectName from tblGUIEntry";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllGUIEntryRecords(int mProjectID)
	{
		String Query="Select ObjectName from tblGUIEntry where ProjectID="+String.valueOf(mProjectID);
		int rec=getAllRecordsCount(mProjectID);
		return(DBManager.getAllRecords(Query,rec));
	}

	static String[] getAllGUIEntryRecords(int mProjectID,int mElementID)
	{
		String Query="Select ObjectName from tblGUIEntry where ElementID="+String.valueOf(mElementID)+" and ProjectID="+String.valueOf(mElementID);
		int rec=getAllRecordsCount(mProjectID,mElementID);
		return(DBManager.getAllRecords(Query,rec));
	}


	static ClsGUIEntry getGUIEntryInformation(int mGUIEntryID)
	{
		ClsGUIEntry temp = new ClsGUIEntry();
		String Query = "select * from tblGUIEntry where GUIEntryID="+String.valueOf(mGUIEntryID);
		String values[]=DBManager.getFullRow(Query,15);
		temp.setGUIEntryID(Integer.parseInt(values[0]));
		temp.setObjectName(values[1]);
		temp.setObjectText(values[2]);
		temp.setXValue(Integer.parseInt(values[3]));
		temp.setYValue(Integer.parseInt(values[4]));
		temp.setWidth(Integer.parseInt(values[5]));
		temp.setHeight(Integer.parseInt(values[6]));
		temp.setElementID(Integer.parseInt(values[7]));
		temp.setProjectID(Integer.parseInt(values[8]));
		temp.setFRed(Integer.parseInt(values[9]));
		temp.setFGreen(Integer.parseInt(values[10]));
		temp.setFBlue(Integer.parseInt(values[11]));
		temp.setBRed(Integer.parseInt(values[12]));
		temp.setBGreen(Integer.parseInt(values[13]));
		temp.setBBlue(Integer.parseInt(values[14]));

		return(temp);
	}

	static ClsGUIEntry[] getAllGUIEntryInformation()
	{
		int rec=getAllRecordsCount();
		ClsGUIEntry obj[]=new ClsGUIEntry[rec];
		String Query ="select * from tblGUIEntry";
		String values[][]=DBManager.getAllFullRow(Query,rec,15);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsGUIEntry();
			obj[i].setGUIEntryID(Integer.parseInt(values[i][0]));
			obj[i].setObjectName(values[i][1]);
			obj[i].setObjectText(values[i][2]);
			obj[i].setXValue(Integer.parseInt(values[i][3]));
			obj[i].setYValue(Integer.parseInt(values[i][4]));
			obj[i].setWidth(Integer.parseInt(values[i][5]));
			obj[i].setHeight(Integer.parseInt(values[i][6]));
			obj[i].setElementID(Integer.parseInt(values[i][7]));
			obj[i].setProjectID(Integer.parseInt(values[i][8]));
			obj[i].setFRed(Integer.parseInt(values[i][9]));
			obj[i].setFGreen(Integer.parseInt(values[i][10]));
			obj[i].setFBlue(Integer.parseInt(values[i][11]));
			obj[i].setBRed(Integer.parseInt(values[i][12]));
			obj[i].setBGreen(Integer.parseInt(values[i][13]));
			obj[i].setBBlue(Integer.parseInt(values[i][14]));
		}
		return(obj);
	}


	static ClsGUIEntry[] getAllGUIEntryInformation(int mProjectID)
	{
		int rec=getAllRecordsCount(mProjectID);
		ClsGUIEntry obj[]=new ClsGUIEntry[rec];
		String Query ="select * from tblGUIEntry  where ProjectID="+String.valueOf(mProjectID);
		String values[][]=DBManager.getAllFullRow(Query,rec,15);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsGUIEntry();
			obj[i].setGUIEntryID(Integer.parseInt(values[i][0]));
			obj[i].setObjectName(values[i][1]);
			obj[i].setObjectText(values[i][2]);
			obj[i].setXValue(Integer.parseInt(values[i][3]));
			obj[i].setYValue(Integer.parseInt(values[i][4]));
			obj[i].setWidth(Integer.parseInt(values[i][5]));
			obj[i].setHeight(Integer.parseInt(values[i][6]));
			obj[i].setElementID(Integer.parseInt(values[i][7]));
			obj[i].setProjectID(Integer.parseInt(values[i][8]));
			obj[i].setFRed(Integer.parseInt(values[i][9]));
			obj[i].setFGreen(Integer.parseInt(values[i][10]));
			obj[i].setFBlue(Integer.parseInt(values[i][11]));
			obj[i].setBRed(Integer.parseInt(values[i][12]));
			obj[i].setBGreen(Integer.parseInt(values[i][13]));
			obj[i].setBBlue(Integer.parseInt(values[i][14]));
		}
		return(obj);
	}

	static ClsGUIEntry[] getAllGUIEntryInformation(int mProjectID,int mElementID)
	{
		int rec=getAllRecordsCount(mProjectID,mElementID);
		ClsGUIEntry obj[]=new ClsGUIEntry[rec];
		String Query ="select * from tblGUIEntry  where ElementID="+String.valueOf(mElementID)+" and ProjectID="+String.valueOf(mProjectID);
		String values[][]=DBManager.getAllFullRow(Query,rec,15);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsGUIEntry();
			obj[i].setGUIEntryID(Integer.parseInt(values[i][0]));
			obj[i].setObjectName(values[i][1]);
			obj[i].setObjectText(values[i][2]);
			obj[i].setXValue(Integer.parseInt(values[i][3]));
			obj[i].setYValue(Integer.parseInt(values[i][4]));
			obj[i].setWidth(Integer.parseInt(values[i][5]));
			obj[i].setHeight(Integer.parseInt(values[i][6]));
			obj[i].setElementID(Integer.parseInt(values[i][7]));
			obj[i].setProjectID(Integer.parseInt(values[i][8]));
			obj[i].setFRed(Integer.parseInt(values[i][9]));
			obj[i].setFGreen(Integer.parseInt(values[i][10]));
			obj[i].setFBlue(Integer.parseInt(values[i][11]));
			obj[i].setBRed(Integer.parseInt(values[i][12]));
			obj[i].setBGreen(Integer.parseInt(values[i][13]));
			obj[i].setBBlue(Integer.parseInt(values[i][14]));
		}
		return(obj);
	}
	static boolean validateObjectName(String oName,int ProjectID)
	{
		boolean status=false;
		if(getAllRecordsCount(oName,ProjectID)>0)
		status=true;
		return(status);
	}


	public static void main(String args[])
	{

	}

}

