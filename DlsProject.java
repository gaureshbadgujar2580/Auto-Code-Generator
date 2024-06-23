
import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsProject
{
	static void addNewRecord(ClsProject temp)
	{
		String Query = "insert into tblProject(ProjectName,XPos,YPos,Width,Height) values ('"+temp.getProjectName()+"',"+temp.getXPos()+","+temp.getYPos()+","+temp.getWidth()+","+temp.getHeight()+")";
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsProject temp)
	{
		String Query = "update tblProject set ProjectName='"+temp.getProjectName()+"', XPos = "+temp.getXPos()+" , YPos = "+temp.getYPos()+" , Width = "+temp.getWidth()+" , Height = "+temp.getHeight()+" where ProjectID ="+String.valueOf(temp.getProjectID());
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsProject temp)
	{
		String Query = "delete * from tblProject  where ProjectID="+temp.getProjectID();
		DBManager.addNewRecord(Query);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getProjectIDFromName(String mProjectName)
	{
		String Query = "select ProjectID from tblProject where ProjectName='"+mProjectName+"'";
		return(DBManager.getCode(Query));
	}

	static String getProjectNameFromID(int mProjectID)
	{
		String Query = "select ProjectName from tblProject where ProjectID="+String.valueOf(mProjectID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblProject";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mTechnologyID)
	{
		String Query="Select Count(*) from tblProject   where TechnologyID="+String.valueOf(mTechnologyID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllProjectRecords()
	{
		String Query="Select ProjectName from tblProject";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}

	static ClsProject getProjectInformation(int mProjectID)
	{
		ClsProject temp = new ClsProject();
		String Query = "select * from tblProject where ProjectID="+String.valueOf(mProjectID);
		String values[]=DBManager.getFullRow(Query,6);
		temp.setProjectID(Integer.parseInt(values[0]));
		temp.setProjectName(values[1]);
		temp.setXPos(Integer.parseInt(values[2]));
		temp.setYPos(Integer.parseInt(values[3]));
		temp.setWidth(Integer.parseInt(values[4]));
		temp.setHeight(Integer.parseInt(values[5]));

		return(temp);
	}

	static ClsProject[] getAllProjectInformation()
	{
		int rec=getAllRecordsCount();
		ClsProject obj[]=new ClsProject[rec];
		String Query ="select * from tblProject";
		String values[][]=DBManager.getAllFullRow(Query,rec,6);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsProject();
			obj[i].setProjectID(Integer.parseInt(values[i][0]));
			obj[i].setProjectName(values[i][1]);
			obj[i].setXPos(Integer.parseInt(values[i][2]));
			obj[i].setYPos(Integer.parseInt(values[i][3]));
			obj[i].setWidth(Integer.parseInt(values[i][4]));
			obj[i].setHeight(Integer.parseInt(values[i][5]));

		}
		return(obj);
	}


	public static void main(String args[])
	{
		String prj[] = getAllProjectRecords();

		for(String ar:prj){
	   System.out.println(ar);
        }
	}

}

