//Name: Rohit Maharjan
//Roll no: 26
//Program to implement the CookieStore Methods (add, read, delete) cookies
package lab3;
import java.net.*; 
import java.util.List; 
public class CookieMethod {
	public static void main(String[] args) { 
        CookieManager cookieManager = new CookieManager(); 
        CookieStore cookieStore = cookieManager.getCookieStore(); 
        URI uri = URI.create("https://www.example.com"); 
        HttpCookie cookie1 = new HttpCookie("name1", "value1");         
        HttpCookie cookie2 = new HttpCookie("name2", "value2");         
        cookieStore.add(uri, cookie1);         
        cookieStore.add(uri, cookie2); 
        List<HttpCookie> cookies = cookieStore.get(uri); 
        System.out.println("Cookies for " + uri + ":");         
        for (HttpCookie cookie : cookies) { 
            System.out.println(cookie.getName() + "=" + cookie.getValue()); 
        }  
        List<HttpCookie> allCookies = cookieStore.getCookies();        
        System.out.println("All cookies:");         
        for (HttpCookie cookie : allCookies) { 
            System.out.println(cookie.getName() + "=" + cookie.getValue()); 
        } 
        List<URI> uris = cookieStore.getURIs(); 
        System.out.println("URIs:");        
        for (URI u : uris) {             
        	System.out.println(u); 
        } 
        boolean removed = cookieStore.remove(uri, cookie1);         
        System.out.println("Cookie removed: " + removed); 
        boolean removedAll = cookieStore.removeAll(); 
        System.out.println("All cookies removed: " + removedAll); 
    } 

}
