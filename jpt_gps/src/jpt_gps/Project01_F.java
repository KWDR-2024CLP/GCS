package jpt_gps;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project01_F {
    JLabel imageLabel;

    public void initGUI() {
        JFrame frm = new JFrame("Map View");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(1500, 800);

        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());

        // 오른쪽 패널(지도)
        imageLabel = new JLabel();
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(imageLabel, BorderLayout.CENTER);
        c.add(BorderLayout.EAST, rightPanel);

        // 왼쪽 패널(빈칸)
        JPanel leftPanel = new JPanel();
        c.add(BorderLayout.CENTER, leftPanel);

        // 네이버 지도 로드
        loadMap();

        frm.setVisible(true);
    }

    public void loadMap() {
        AddressVO vo = new AddressVO();
        vo.setX("128.467687"); // 기본 경도 (학교 기준)
        vo.setY("36.168547"); // 기본 위도 (학교 기준)
        vo.setRoadAddress("현재 위치");
        vo.setJibunAddress("현재 위치");

        // 지도 표시
        new NaverMap(this).map_service(vo);
    }

    public static void main(String[] args) {
        new Project01_F().initGUI();
    }
}
