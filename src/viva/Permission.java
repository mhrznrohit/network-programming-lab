package viva;

import java.net.*;

public class Permission {
 public static void main(String[] args) {
	 try {
		 String url="www.dibyagyan.com";
				 HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
				 String[] methods={"POST","GET"};
				 for(String s:methods) {
					 conn.setRequestMethod(s);
					 int i= conn.getResponseCode();
					 if(i==200) {
						 System.out.println(s+"is accepted");
					 }
				
				 }
	 }
	 catch (Exception e) {
		// TODO: handle exception
	}
 }
}
