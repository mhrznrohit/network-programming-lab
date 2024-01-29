package lab2;

import java.net.MalformedURLException;
import java.net.URL;

public class Virtual_protocal {
	public static void main(String[] args)  {
		protocolChecker("mailto");
	}
		
		static void protocolChecker(String Protocol){
	        try {
	            URL url = new URL(Protocol, "divyagyan.edu.np","");
	            System.out.println(Protocol+" is supported");
	        } catch (MalformedURLException e) {
	            System.out.println(Protocol+" is not supported");
	        }
	    	}
		}
