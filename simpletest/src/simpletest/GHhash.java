package simpletest;

public class GHhash {
	public static void main(String[] args) {
		double hash,lat,lon;
		lat = 51.131;//%2C12.414;
		lon = 48.224;//%2C3.867;
		hash = 7;
		 hash = 83 * hash + (int) (Double.doubleToLongBits( lat) ^ (Double.doubleToLongBits( lat) >>> 32));
	     hash = 83 * hash + (int) (Double.doubleToLongBits( lon) ^ (Double.doubleToLongBits( lon) >>> 32));
	     System.out.println(lat+"\n"+lon+"\n"+hash);
	}
}
