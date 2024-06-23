import java.sql.*;
import javax.swing.*;

class ClsProject
{
	private int  ProjectID ;
	private String ProjectName;
	private int XPos;
	private int YPos;
	private int Width;
	private int Height;


	void setProjectID(int value)
	{
		ProjectID = value;
	}
	int getProjectID()
	{
		return ProjectID;
	}

	void setProjectName(String value)
	{
		ProjectName = value;
	}
	String getProjectName()
	{
		return ProjectName;
	}

   void setXPos(int value)
	{
		XPos = value;
	}
	int getXPos()
	{
		return XPos;
	}

    void setYPos(int value)
	{
		YPos = value;
	}
	int getYPos()
	{
		return YPos;
	}

    void setWidth(int value)
	{
		Width = value;
	}
	int getWidth()
	{
		return Width;
	}

    void setHeight(int value)
	{
		Height = value;
	}
	int getHeight()
	{
		return Height;
	}

	static void addNewRecord(ClsProject temp)
	{
		DlsProject.addNewRecord(temp);
	}

	static void updateRecord(ClsProject temp)
	{
		DlsProject.updateRecord(temp);
	}

	static void deleteRecord(ClsProject temp)
	{
		DlsProject.deleteRecord(temp);
	}

	static int getProjectIDFromName(String mProjectName)
	{
		return(DlsProject.getProjectIDFromName(mProjectName));
	}

	static String getProjectNameFromID(int mProjectID)
	{
		return(DlsProject.getProjectNameFromID(mProjectID));
	}

	static int getAllRecordsCount()
	{
		return(DlsProject.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mTechnologyID)
	{
		return(DlsProject.getAllRecordsCount(mTechnologyID));
	}

	static String[] getAllProjectRecords()
	{
		return(DlsProject.getAllProjectRecords());
	}


	static ClsProject getProjectInformation(int mProjectID)
	{
		return(DlsProject.getProjectInformation(mProjectID));
	}

	static ClsProject[] getAllProjectInformation()
	{
		return(DlsProject.getAllProjectInformation());
	}

/*
	static ClsProject[] getAllProjectInformation(int mProjectID)
	{
		return(DlsProject.getAllProjectInformation(mProjectID));
	}
*/
	static void showProject(ClsProject temp)
	{
		System.out.println("Project ID              : ..........    "+temp.getProjectID());
		System.out.println("Project Name            : ..........    "+temp.getProjectName());
		System.out.println(" XPos                   : ..........    "+temp.getXPos());
		System.out.println("YPos                    : ..........    "+temp.getYPos());
		System.out.println("Width                   : ..........    "+temp.getWidth());
		System.out.println("Height                  : ..........    "+temp.getHeight());
	}



	static void addProjectRecords(JComboBox cmbProcess)
	{
		String Query = "select ProjectName from tblProject order by ProjectName";
		String data[]=getAllProjectRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Project ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	public static void main(String args[])
	{
	}
}
