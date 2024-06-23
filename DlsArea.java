import java.sql.*;
import javax.swing.*;
import DBManage.*;

class DlsArea
{
	static void addNewRecords(ClsArea temp)
	{
			String Query=" insert into tblArea(AreaName,TalukaID,VillageID) values('"+temp.getAreaName()+"',"+String.valueOf(temp.getTalukaID())+","+String.valueOf(temp.getVillageID())+")";
			DBManager.addNewRecord(Query);
			JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}
	static void deleteRecords(ClsArea temp)
	{
			String Query = "delete * from tblArea where AreaID="+temp.getAreaID();
			DBManager.addNewRecord(Query);
			JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static void updateRecords(ClsArea temp)
	{
		String SQ = " ' ";
		String Comma = ",";

					String Query = "update tblArea set "+
					"AreaName="+SQ+temp.getAreaName()+SQ+Comma+
					"TalukaID="+String.valueOf(temp.getTalukaID())+Comma+
					"VillageID="+String.valueOf(temp.getVillageID())+
					" where AreaID ="+String.valueOf(temp.getAreaID());
					System.out.println(Query);
	    			DBManager.addNewRecord(Query);
					JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}
	static int getAreaIDFromName(String mAreaName)
	{
			String Query=" select AreaID from tblArea where AreaName='" + mAreaName + "'";
			return(DBManager.getCode(Query));
	}

	static String getAreaNameFromID(int mAreaID)
		{
				String Query=" select AreaName from tblArea where  AreaID="+String.valueOf(mAreaID) ;
				return(DBManager.getName(Query));
	}


	static String getTalukaNameFromID(int mTalukaID)
	{
		String Query = "select TalukaName from tblTaluka where TalukaID="+String.valueOf(mTalukaID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblArea";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mTalukaID,int mVillageID)
	{
		String Query="Select Count(*) from tblArea  where TalukaID="+String.valueOf(mTalukaID)+" and VillageID = "+String.valueOf(mVillageID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mTalukaID)
	{
		String Query="Select Count(*) from tblArea   where TalukaID="+String.valueOf(mTalukaID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllAreaRecords()
	{
		String Query="Select AreaName from tblArea";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllAreaRecords(int mTalukaID,int mVillageID)
	{
		String Query="Select AreaName from tblArea where TalukaID="+String.valueOf(mTalukaID)+" and VillageID = "+String.valueOf(mVillageID);
		int rec=getAllRecordsCount(mTalukaID,mVillageID);
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllAreaRecords(int mTalukaID)
	{
		String Query="Select AreaName from tblArea where TalukaID="+String.valueOf(mTalukaID);
		int rec=getAllRecordsCount(mTalukaID);
		return(DBManager.getAllRecords(Query,rec));
	}

	static ClsArea[] getAllAreaInformation(int mTalukaID)
	{
		int rec=getAllRecordsCount(mTalukaID);
		ClsArea obj[]=new ClsArea[rec];
		String Query ="select * from tblArea  where TalukaID="+String.valueOf(mTalukaID);
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsArea();
			obj[i].setAreaID(Integer.parseInt(values[i][0]));
			obj[i].setAreaName(values[i][1]);
			obj[i].setTalukaID(Integer.parseInt(values[i][2]));
			obj[i].setVillageID(Integer.parseInt(values[i][3]));
		}
		return(obj);
	}


	static ClsArea[] getAllAreaInformation(int mTalukaID,int mVillageID)
	{
		int rec=getAllRecordsCount(mTalukaID,mVillageID);
		ClsArea obj[]=new ClsArea[rec];
		String Query ="select * from tblArea  where TalukaID="+String.valueOf(mTalukaID)+" and VillageID= "+String.valueOf(mVillageID);
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsArea();
			obj[i].setAreaID(Integer.parseInt(values[i][0]));
			obj[i].setAreaName(values[i][1]);
			obj[i].setTalukaID(Integer.parseInt(values[i][2]));
			obj[i].setVillageID(Integer.parseInt(values[i][3]));
		}
		return(obj);
	}

	static ClsArea[] getAllAreaInformation()
	{
		int rec=getAllRecordsCount();
		ClsArea obj[]=new ClsArea[rec];
		String Query ="select * from tblArea";
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsArea();
			obj[i].setAreaID(Integer.parseInt(values[i][0]));
			obj[i].setAreaName(values[i][1]);
			obj[i].setTalukaID(Integer.parseInt(values[i][2]));
			obj[i].setVillageID(Integer.parseInt(values[i][3]));
		}
		return(obj);
	}

	static ClsArea getAreaInformation(int mAreaID)
	{
			ClsArea temp = new ClsArea();
			String Query = "select * from tblArea where AreaID="+String.valueOf(mAreaID);
			String values[]=DBManager.getFullRow(Query,4);
			temp.setAreaID(Integer.parseInt(values[0]));
			temp.setAreaName(values[1]);
			temp.setTalukaID(Integer.parseInt(values[2]));
			temp.setVillageID(Integer.parseInt(values[3]));
			return(temp);
	}
	public static void main(String args[])
	{
		DlsArea A = new DlsArea();
		System.out.println(getAllRecordsCount(1));

	}
}

/********************/