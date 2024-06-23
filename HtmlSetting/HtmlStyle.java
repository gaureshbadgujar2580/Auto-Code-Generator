package HtmlSetting;

import javax.swing.*;

public class HtmlStyle
{
	public static void applyH1(JLabel ref)
	{
		String msg=ref.getText();
		ref.setText("<html><h1>"+msg+"</h1></html>");

	}
	public static void applyH2(JLabel ref)
	{
		String msg=ref.getText();
		ref.setText("<html><h2>"+msg+"</h2></html>");

	}
	public static void applyH3(JLabel ref)
	{
		String msg=ref.getText();
		ref.setText("<html><h3>"+msg+"</h3></html>");

	}





}