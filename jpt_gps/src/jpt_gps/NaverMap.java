package jpt_gps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.swing.ImageIcon;

public class NaverMap {
    Project01_F naverMap;
    static  String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

    public NaverMap(Project01_F naverMap) {
        this.naverMap = naverMap;
    }

    public void map_service(AddressVO vo) {
        try {
            // 기존 URL 초기화 (기존 마커가 계속 쌓이지 않도록)
            String baseURL = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
            String centerPos = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");

            // 새로운 지도 URL 구성
            String url = baseURL + "center=" + vo.getX() + "," + vo.getY();
            url += "&level=17&w=750&h=800"; // 지도 크기
            url += "&type=satellite"; // 위성 지도

            // 새로운 마커 추가
            url += "&markers=type:t|size:mid|pos:" + centerPos + "|label:" + URLEncoder.encode(vo.getRoadAddress(), "UTF-8");

            // 다른 마커 예시 (필요한 경우 추가 가능)
            url += "&markers=type:d|color:blue|pos:128.467796+36.168197|label:Target1";
            url += "&markers=type:d|color:blue|pos:128.467714+36.168302|label:Target2";

            System.out.println("Request URL: " + url);

            // HTTP 요청
            URL requestUrl = new URL(url);
            HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "lkz9hgrqqf");
            con.setRequestProperty("X-NCP-APIGW-API-KEY", "KYtmPqGmc5aHXSZRlsM8S4qfCYdiXrhYG0xXCuWc");

            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                InputStream is = con.getInputStream();
                byte[] bytes = new byte[1024];
                int read;

                // 랜덤 파일명으로 이미지 파일 생성
                String tempName = Long.valueOf(new Date().getTime()).toString();
                File file = new File(tempName + ".jpg");
                file.createNewFile();

                FileOutputStream out = new FileOutputStream(file);
                while ((read = is.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                is.close();
                out.close();

                // 지도 이미지 설정
                ImageIcon img = new ImageIcon(file.getName());
                naverMap.imageLabel.setIcon(img);
            } else {
                System.out.println("HTTP Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
