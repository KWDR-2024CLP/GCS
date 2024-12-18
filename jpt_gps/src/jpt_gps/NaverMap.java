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
            // ���� URL �ʱ�ȭ (���� ��Ŀ�� ��� ������ �ʵ���)
            String baseURL = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
            String centerPos = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");

            // ���ο� ���� URL ����
            String url = baseURL + "center=" + vo.getX() + "," + vo.getY();
            url += "&level=17&w=750&h=800"; // ���� ũ��
            url += "&type=satellite"; // ���� ����

            // ���ο� ��Ŀ �߰�
            url += "&markers=type:t|size:mid|pos:" + centerPos + "|label:" + URLEncoder.encode(vo.getRoadAddress(), "UTF-8");

            // �ٸ� ��Ŀ ���� (�ʿ��� ��� �߰� ����)
            url += "&markers=type:d|color:blue|pos:128.467796+36.168197|label:Target1";
            url += "&markers=type:d|color:blue|pos:128.467714+36.168302|label:Target2";

            System.out.println("Request URL: " + url);

            // HTTP ��û
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

                // ���� ���ϸ����� �̹��� ���� ����
                String tempName = Long.valueOf(new Date().getTime()).toString();
                File file = new File(tempName + ".jpg");
                file.createNewFile();

                FileOutputStream out = new FileOutputStream(file);
                while ((read = is.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                is.close();
                out.close();

                // ���� �̹��� ����
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
