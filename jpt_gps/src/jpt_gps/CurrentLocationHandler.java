package jpt_gps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class CurrentLocationHandler implements ActionListener {
    Project01_F naverMap;

    public CurrentLocationHandler(Project01_F naverMap) {
        this.naverMap = naverMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String apiUrl = "http://ip-api.com/json";
        AddressVO vo = new AddressVO();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            String latitude = jsonResponse.getString("lat");
            String longitude = jsonResponse.getString("lon");

            // VO에 현재 위치 저장
            vo.setX(longitude);
            vo.setY(latitude);
            vo.setRoadAddress("현재 위치 (IP 기반)");
            vo.setJibunAddress("IP 기반 위치");

            // 네이버 지도 표시
            new NaverMap(naverMap).map_service(vo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
