import java.sql.*;
import javax.swing.*;

class ClsState
{
	private int  StateID ;
	private String StateName;
	private int CountryID;

	void setStateID(int value)
	{
		StateID = value;
	}
	int getStateID()
	{
		return StateID;
	}

	void setStateName(String value)
	{
		StateName = value;
	}
	String getStateName()
	{
		return StateName;
	}

	void setCountryID(int value)
	{
		CountryID = value;
	}
	int getCountryID()
	{
		return CountryID;
	}

	static void addNewRecord(ClsState temp)
	{
		DlsState.addNewRecord(temp);
	}

	static void updateRecord(ClsState temp)
	{
		DlsState.updateRecord(temp);
	}

	static void deleteRecord(ClsState temp)
	{
		DlsState.deleteRecord(temp);
	}

	static int getStateIDFromName(String mStateName)
	{
		return(DlsState.getStateIDFromName(mStateName));
	}

	static String getStateNameFromID(int mStateID)
	{
		return(DlsState.getStateNameFromID(mStateID));
	}

	static int getAllRecordsCount()
	{
		return(DlsState.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mCountryID)
	{
		return(DlsState.getAllRecordsCount(mCountryID));
	}

	static String[] getAllStateRecords()
	{
		return(DlsState.getAllStateRecords());
	}

	static String[] getAllStateRecords(int mCountryID)
	{
		return(DlsState.getAllStateRecords(mCountryID));
	}

	static ClsState getStateInformation(int mStateID)
	{
		return(DlsState.getStateInformation(mStateID));
	}

	static ClsState[] getAllStateInformation()
	{
		return(DlsState.getAllStateInformation());
	}


	static ClsState[] getAllStateInformation(int mStateID)
	{
		return(DlsState.getAllStateInformation(mStateID));
	}





	static void showState(ClsState temp)
	{
		System.out.println("State ID             : ..........    "+temp.getStateID());
		System.out.println("State Name           : ..........    "+temp.getStateName());
		System.out.println("Country Id           : ..........    "+temp.getCountryID());

	}

	static void addStateRecords(JComboBox cmbProcess,int mCountryID)
	{
		String Query = "select StateName from tblState where CountryID ="+String.valueOf(mCountryID);
		String data[]=getAllStateRecords(mCountryID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select State ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	static void addStateRecords(JComboBox cmbProcess)
	{
		String Query = "select StateName from tblState order by StateName";
		String data[]=getAllStateRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select State ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	public static void main(String args[])
	{
		ClsState Data[]=ClsState.getAllStateInformation(1);

		for(ClsState Item :Data)
		{
			ClsState.showState(Item);

		}

	}
}
