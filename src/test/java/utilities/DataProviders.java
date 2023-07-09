package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\"+"Opencart_LoginData.xlsx";
		
		ExcelUtility xlUtility=new ExcelUtility(path);
		
		int total_rows=xlUtility.getRowCount("Sheet1");      //6(not including index no 0)
		int total_cols=xlUtility.getCellCount("Sheet1", 1);  //3
		//System.out.println(total_rows); //5
		//System.out.println(total_cols); //3
		
		String loginData[][]= new String[total_rows][total_cols]; //[5][3] 
		
		//Starting the index from 1 to ignore the header part
		for(int r=1;r<=total_rows;r++)
		{
			for (int c=0;c<total_cols;c++)
			{
				loginData[r-1][c]=xlUtility.getCellData("Sheet1", r, c);
				//System.out.println(loginData+" ");
			}
		}
		return loginData;  //this returns 2D Array
		
	}
	
}
