package jpt_gps;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Project01_F {
    JTextField address;
    JLabel resAddress, resX, resY, jibunAddress;
    JLabel imageLabel;
    JButton btnCurrentLocation;

    public void initGUI() {
        JFrame frm = new JFrame("Map View"); // 프레임 생성
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 X 클릭 시 종료.
        Container c = frm.getContentPane(); // JFrame 안쪽 영역.

        imageLabel = new JLabel("지도보기"); // JFrame 안쪽 영역 상단에 들어갈 지도보기
        JPanel pan = new JPanel();
        JLabel addressLbl = new JLabel("주소입력"); // JFrame 안쪽 영역 상단에 들어갈 주소입력
        address = new JTextField(50);
        JButton btn = new JButton("주소로 찾기"); // JFrame 안쪽 영역에 들어갈 클릭 버튼
        btnCurrentLocation = new JButton("현재 위치"); // 현재 위치 버튼

        pan.add(addressLbl);
        pan.add(address);
        pan.add(btn);
        pan.add(btnCurrentLocation);

        btn.addActionListener(new NaverMap(this)); // 주소 입력 핸들러
        btnCurrentLocation.addActionListener(new CurrentLocationHandler(this)); // 현재 위치 핸들러

        JPanel pan1 = new JPanel();
        pan1.setLayout(new GridLayout(4, 1)); // 지도 하단 그리드 4행 1열로 생성.
        resAddress = new JLabel("도로명"); // 그리드 1행에 들어갈 도로명
        jibunAddress = new JLabel("지번주소"); // 그리드 2행에 들어갈 지번주소
        resX = new JLabel("경도"); // 그리드 3행에 들어갈 경도
        resY = new JLabel("위도"); // 그리드 4행에 들어갈 위도
        pan1.add(resAddress);
        pan1.add(jibunAddress);
        pan1.add(resX);
        pan1.add(resY);

        c.add(BorderLayout.NORTH, pan); // 상단 pan 세팅
        c.add(BorderLayout.CENTER, imageLabel); // 센터 imageLabel 세팅
        c.add(BorderLayout.SOUTH, pan1); // 하단 pan1 세팅

        frm.setSize(800, 660);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Project01_F().initGUI();
    }
}
