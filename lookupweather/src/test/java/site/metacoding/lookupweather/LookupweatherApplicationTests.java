package site.metacoding.lookupweather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LookupweatherApplicationTests {

	@Test
	public void contextLoads() {
		try {
			URL url = new URL(
					"http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=090tbpV1s%2F%2F2YJxMEkGWsGycvC6GQRKrIXFNzkv44vZejXWfuwu0yzNcVUOUEnn5QgU9fXb9yuJfArubBmvWpg%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID=1%22");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "utf-8"));

			String responseJson = br.readLine();
			Gson gson = new Gson();
			DownloadDto downloadDto = gson.fromJson(responseJson, DownloadDto.class);

			System.out.println("totalCount : " + downloadDto.getResponse().getBody().getTotalCount());

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
