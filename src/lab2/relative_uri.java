//Name: Rohit Maharjan
//Roll: 26
//4.	Program for resolving relative URI
package lab2;
import java.net.URI;
import java.net.URISyntaxException;

public class relative_uri {
	public static void main(String[] args) {
		
		try {
		String uribase="https://www.google.com/";
		String urirelative="languages/../java";
		URI uriBase = new URI(uribase);
		
		@SuppressWarnings("unused")
		URI uri = URI.create(uribase);
		System.out.println("Base Uri="+ uriBase.toString());
		 URI uriRelative = new URI(urirelative);
		 System.out.println("Relative URI="+ uriRelative.toString());
		 
		 URI uriResolved = uriBase.resolve(uriRelative);
		 System.out.println("Resolved URI="+ uriResolved.toString());
		}
		catch (URISyntaxException ex) {
	            System.out.println("Error");
	        }
		}
	}

