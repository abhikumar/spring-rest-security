package com.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSms {

	public static void main(String[] args) {
		sendOtp("4658758", "https://img2.smartprix.com/deals/9999o4xxx5f/f-1.jpg", "9953220801");
	}

	public static boolean sendOtp(String otp, String link, String dest) {
		String inputLine = "";
		String responseMessage = "";
		String url = createSmsUrl(otp, link, dest);
		boolean sendMessage = false;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			connection.disconnect();
			responseMessage = response.toString();
			// print result
			System.out.println(response.toString());
			if (200 == responseCode && !responseMessage.contains("Invalid")) {
				sendMessage = true;
			}
		} catch (Exception e) {
			System.out.println("Exception in sending message" + e);

		}
		return sendMessage;
	}

	private static String createSmsUrl(String otp, String link, String dest) {
		StringBuilder url = new StringBuilder("http://www.unicel.in/SendSMS/sendmsg.php");
		url.append("?uname=" + "davsb");
		url.append("&pass=" + "123456789");
		url.append("&send=" + "DLDAVS");
		url.append("&dest=91" + dest);
		url.append("&msg=" + createOtpMessage(otp, link));
		return url.toString();
	}

	private static String createOtpMessage(String otp, String link) {
		//return "Dear Parents, "+"Download_app_from:" + link + "\\nOTP:" + otp+" DLDAVMS, Shalimar Bagh, Delhi ";
	
	return "Dear%20Parents\\n,%20Message%20\\nof%20\\nsmssssss"; 
	}

}
