package simpletest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;


public class Test01 {
	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			URL obj = new URL("https://graphhopper.com/api/1/route?point=36.9466090%2C126.8294800&point=37.212968%2C129.038200&vehicle=car&locale=kr&key=3f9a2705-322e-4466-9738-1f4c52a55765");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			line = in.readLine();
			System.out.println(line);
			int k=line.indexOf("\"points\"");
			System.out.println(k);
			int m=line.indexOf("\"snapped_waypoints\"");
			System.out.println(m);
			String points = line.substring(k+10,m-2);
			System.out.println(points);
			System.out.println(points.indexOf("PcDLcBFwA"));
			
			//PointList pl = decodePolyline(points,10,true);
			int l = line.indexOf("\"info\"");
			String points2 = line.substring(m+21, l-4);
			System.out.println(points2);
			PointList pl = decodePolyline(points2,10,false);

			System.out.println(pl.getSize());
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	public static PointList decodePolyline(String encoded, int initCap, boolean is3D) {
        PointList poly = new PointList(initCap, is3D);
        int index = 0;
        int len = encoded.length();
        int lat = 0, lng = 0, ele = 0;
        while (index < len) {
            // latitude
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int deltaLatitude = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += deltaLatitude;

            // longitute
            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int deltaLongitude = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += deltaLongitude;

            if (is3D) {
                // elevation
                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int deltaElevation = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                ele += deltaElevation;
                poly.add((double) lat / 1e5, (double) lng / 1e5, (double) ele / 100);
            } else {
                poly.add((double) lat / 1e5, (double) lng / 1e5);
            }
        }
        return poly;
    }

}
