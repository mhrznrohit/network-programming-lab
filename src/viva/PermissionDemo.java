package viva;

import java.net.*;

public class PermissionDemo {
 public static void main(String[] args) {
	 try {
		 String url="https://www.divyagyan.edu.np";
				 HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
				 String[] methods={"GET","POST","HEAD"};
				 for(String s:methods) {
					 
					 try{
						 conn.setRequestMethod(s);
						 System.out.println(s+" is accepted");
						 
					 }catch (Exception e) {
						 System.out.println(s+" is not accepted");
					}
					 
				
				 }
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
 }
}
