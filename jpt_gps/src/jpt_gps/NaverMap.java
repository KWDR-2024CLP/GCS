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

    public NaverMap(Project01_F naverMap) {
        this.naverMap = naverMap;
    }

    public void map_service(AddressVO vo) {
        String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
        try {
            String pos = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");
            URL_STATICMAP += "center=" + vo.getX() + "," + vo.getY();
            URL_STATICMAP += "&level=16&w=750&h=800"; // 프레임 절반에 맞게 지도 크기 조정
            URL_STATICMAP += "&type=satellite"; // 위성지도
            URL_STATICMAP += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(vo.getRoadAddress(), "UTF-8");

            URL url = new URL(URL_STATICMAP);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
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
