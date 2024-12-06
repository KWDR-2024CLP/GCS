package jpt_gps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

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

        // 왼쪽 패널 (지도)
        imageLabel = new JLabel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(imageLabel, BorderLayout.CENTER); // 지도 추가
        leftPanel.setPreferredSize(new Dimension(750, 800));
        c.add(BorderLayout.WEST, leftPanel);

        // 오른쪽 패널 (위 아래로 나뉨)
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(750, 800));

        // 상단 패널 (문구)
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Color.LIGHT_GRAY);
        upperPanel.setPreferredSize(new Dimension(750, 400));

        JLabel droneLabel = new JLabel("드론 카메라 송출 예정입니다...", JLabel.CENTER); // 중앙 정렬
        droneLabel.setForeground(Color.BLACK); // 글자 색 설정
        droneLabel.setFont(droneLabel.getFont().deriveFont(20.0f)); // 글자 크기 설정
        upperPanel.add(droneLabel, BorderLayout.CENTER); // 상단 패널 중앙에 추가

        // 하단 패널 (빈칸)
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.WHITE);
        lowerPanel.setPreferredSize(new Dimension(750, 400));

        // 오른쪽 패널에 추가
        rightPanel.add(upperPanel, BorderLayout.NORTH);
        rightPanel.add(lowerPanel, BorderLayout.SOUTH);

        c.add(BorderLayout.CENTER, rightPanel);

        // 네이버 지도 로드
        loadMap();

        frm.setVisible(true);
    }

    public void loadMap() {
        AddressVO vo = new AddressVO();
        vo.setX("128.467687"); // 기본 경도 (학교 기준)
        vo.setY("36.168547"); // 기본 위도 (학교 기준)
        vo.setRoadAddress("NOW");
        vo.setJibunAddress("NOW");

        // 지도 표시
        new NaverMap(this).map_service(vo);
    }

    public static void main(String[] args) {
        new Project01_F().initGUI();
    }
}
