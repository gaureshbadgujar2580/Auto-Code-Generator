import java.sql.*;
import javax.swing.*;
import DBManage.*;

 public class DlsEventObject
{
	public static void addNewRecord(ClsEventObject temp)
	{
		String Query = "insert into tblEventObject(EventObjectName)values('"+temp.getEventObjectName()+"')";
		DBManager.addNewRecord(Query);
	}


	static void updateRecord(ClsEventObject temp)
	{
		String Query = " update tblEventObject set EventObjectName='"+temp.getEventObjectName()+"' where EventObjectID ="+String.valueOf(temp.getEventObjectID());
		DBManager.addNewRecord(Query);
	}

	static void deleteRecord(ClsEventObject temp)
	{
		String Query = "delete from tblEventObject  where EventObjectID="+temp.getEventObjectID();
		DBManager.addNewRecord(Query);
	}

	static int getEventObjectIDFromName(String mEventObjectName)
	{
		String Query = "select EventObjectID from tblEventObject where EventObjectName='"+mEventObjectName+"'";
		return(DBManager.getCode(Query));
	}


	static String getEventObjectNameFromID(int mEventObjectID)
	{
		String Query = "select EventObjectName from tblEventObject where EventObjectID="+String.valueOf(mEventObjectID);
		return(DBManager.getName(Query));
	}


	static ClsEventObject getEventObjectInformation(int mEventObjectID)
	{
		ClsEventObject temp = new ClsEventObject();

			String Query = "select * from tblEventObject where EventObjectID="+String.valueOf(mEventObjectID);
			String values[]=DBManager.getFullRow(Query,2);
			temp.setEventObjectID(Integer.parseInt(values[0]));
			temp.setEventObjectName(values[1]);

		return(temp);
	}

	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblEventObject";
		int Count = DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static String[] getAllEventObjectRecords()
	{
		String X ="Select EventObjectName from tblEventObject";
		int rec = getAllRecordsCount();
		return(DBManager.getAllRecords(X,rec));
	}

	static ClsEventObject[] getAllEventObjectInformation()
	{
		int rec=getAllRecordsCount();
		ClsEventObject obj[]=new ClsEventObject[rec];
		String Query="select * from tblEventObject";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);

		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsEventObject();
			obj[i].setEventObjectID(Integer.parseInt(values[i][0]));
			obj[i].setEventObjectName(values[i][1]);
		}
		return(obj);
	}
	public static void main(String args[])
	{
		ClsEventObject temp[]=getAllEventObjectInformation();
	}

}

