package simpletest2;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class UTFtest {
	public static void main(String[] args){
		String str = null;
		String str2 = null;
		try {
			str = URLEncoder.encode("Dro\\U00dfkau","UTF-8");
			str2 = URLDecoder.decode("Dro\\U00dfkau","UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
