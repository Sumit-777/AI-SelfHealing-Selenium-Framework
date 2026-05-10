package utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AIEngine {

	public static String getHealingXpath(String failedXpath, String outerHTML) {

		String response = "";

		String healedXpath = "";

		try {

			String apiKey = ConfigReader.readConfig("grokapikey");

			String apiUrl = ConfigReader.readConfig("grokurl");

			URL url = new URL(apiUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");

			conn.setRequestProperty("Authorization", "Bearer " + apiKey);

			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);
			outerHTML = outerHTML.replace("\n", " ")
					.replace("\r", " ")
					.replace("\t", " ")
					.replace("\"", "'");

			String prompt = "You are a selenium xpath healing engine. "
					+ "Failed xpath is: " + failedXpath
					+ ". HTML is: " + outerHTML
					+ ". Return ONLY one valid xpath. No explanation.";

			String jsonInput = "{"
					+ "\"model\":\"grok-3-mini\","
					+ "\"messages\":["
					+ "{\"role\":\"user\",\"content\":\"" + prompt.replace("\"", "\\\"") + "\"}"
					+ "]"
					+ "}";

			OutputStream os = conn.getOutputStream();

			os.write(jsonInput.getBytes());

			os.flush();

			os.close();

			BufferedReader br;

			if (conn.getResponseCode() >= 400) {

				br = new BufferedReader(
						new InputStreamReader(conn.getErrorStream()));

			} else {

				br = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			}

			String line;

			StringBuilder result = new StringBuilder();

			while ((line = br.readLine()) != null) {

				result.append(line);
			}

			br.close();

			response = result.toString();

			if (response.contains("\"content\":")) {

				String temp = response.split("\"content\":")[1];

				temp = temp.substring(temp.indexOf("\"") + 1);

				healedXpath = temp.substring(0, temp.indexOf("\""))
						.replace("\\n", "")
						.replace("\\\"", "\"")
						.trim();
			}
			System.out.println("Full AI Response: " + response);

			System.out.println("Healed XPath: " + healedXpath);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return healedXpath;
	}
}