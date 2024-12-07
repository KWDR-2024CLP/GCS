package jpt_gps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project01_F {
	JLabel imageLabel;

	public void initGUI() {

		// 그리드 표 이미지
		ImageIcon gridImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\grid.png");
		Image gridImage = gridImageIcon.getImage();
		Image sgridImage = gridImage.getScaledInstance(740, 280, Image.SCALE_SMOOTH);
		ImageIcon sgridImageIcon = new ImageIcon(sgridImage);

		// 왼쪽 화살표 이미지
		ImageIcon leftImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\left.png");
		Image leftImage = leftImageIcon.getImage();
		Image sleftImage = leftImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon sleftImageIcon = new ImageIcon(sleftImage);

		// 으른쪽 화살표 이미지
		ImageIcon rightImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\right.png");
		Image rightImage = rightImageIcon.getImage();
		Image srightImage = rightImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon srightImageIcon = new ImageIcon(srightImage);

		JFrame frm = new JFrame("Ground Control Station");
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

		JLabel droneLabel = new JLabel("The drone camera feed is coming soon...", JLabel.CENTER); // 중앙 정렬
		droneLabel.setForeground(Color.BLACK); // 글자 색 설정
		droneLabel.setFont(droneLabel.getFont().deriveFont(20.0f)); // 글자 크기 설정
		upperPanel.add(droneLabel, BorderLayout.CENTER); // 상단 패널 중앙에 추가

		// 하단 패널 (빈칸)
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(null);
		lowerPanel.setBackground(Color.WHITE);
		lowerPanel.setPreferredSize(new Dimension(750, 370));

		// 구분 문구 넣는 JLabel(target)
		JLabel targetJLabel = new JLabel("TARGET");
		targetJLabel.setBounds(45, 25, 150, 30);
		targetJLabel.setForeground(Color.BLACK);
		targetJLabel.setFont(new Font("Bauhaus", Font.BOLD, 25));
		lowerPanel.add(targetJLabel);

		// 구분 문구 넣는 JLabel(latitude)
		JLabel latitudeJLabel = new JLabel("LATITUDE");
		latitudeJLabel.setBounds(275, 25, 150, 30);
		latitudeJLabel.setForeground(Color.BLACK);
		latitudeJLabel.setFont(new Font("Bauhaus", Font.BOLD, 25));
		lowerPanel.add(latitudeJLabel);

		// 구분 문구 넣는 JLabel(longitude)
		JLabel longitudeJLabel = new JLabel("LONGITUDE");
		longitudeJLabel.setBounds(530, 25, 150, 30);
		longitudeJLabel.setForeground(Color.BLACK);
		longitudeJLabel.setFont(new Font("Bauhaus", Font.BOLD, 25));
		lowerPanel.add(longitudeJLabel);

		// target1 정보 넣는 JLabel(target1)
		JLabel target1JLabel = new JLabel("target1");
		target1JLabel.setBounds(60, 93, 150, 30);
		target1JLabel.setForeground(Color.BLACK);
		target1JLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target1JLabel);

		// target1 정보 넣는 JLabel(latitude)
		JLabel target1latJLabel = new JLabel("36.168509");
		target1latJLabel.setHorizontalAlignment(JLabel.CENTER);
		target1latJLabel.setBounds(260, 93, 150, 30);
		target1latJLabel.setForeground(Color.BLACK);
		target1latJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target1latJLabel);

		// target1 정보 넣는 JLabel(longitude)
		JLabel target1lngJLabel = new JLabel("128.467811");
		target1lngJLabel.setHorizontalAlignment(JLabel.CENTER);
		target1lngJLabel.setBounds(525, 93, 150, 30);
		target1lngJLabel.setForeground(Color.BLACK);
		target1lngJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target1lngJLabel);

		// target2 정보 넣는 JLabel(target2)
		JLabel target2JLabel = new JLabel("target2");
		target2JLabel.setBounds(60, 162, 150, 30);
		target2JLabel.setForeground(Color.BLACK);
		target2JLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target2JLabel);

		// target2 정보 넣는 JLabel(latitude)
		JLabel target2latJLabel = new JLabel("36.168198");
		target2latJLabel.setHorizontalAlignment(JLabel.CENTER);
		target2latJLabel.setBounds(260, 162, 150, 30);
		target2latJLabel.setForeground(Color.BLACK);
		target2latJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target2latJLabel);

		// target2 정보 넣는 JLabel(longitude)
		JLabel target2lngJLabel = new JLabel("128.467431");
		target2lngJLabel.setHorizontalAlignment(JLabel.CENTER);
		target2lngJLabel.setBounds(525, 162, 150, 30);
		target2lngJLabel.setForeground(Color.BLACK);
		target2lngJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target2lngJLabel);

		// target3 정보 넣는 JLabel(target3)
		JLabel target3JLabel = new JLabel("target3");
		target3JLabel.setBounds(60, 231, 150, 30);
		target3JLabel.setForeground(Color.BLACK);
		target3JLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target3JLabel);

		// target3 정보 넣는 JLabel(latitude)
		JLabel target3latJLabel = new JLabel("36.168878");
		target3latJLabel.setHorizontalAlignment(JLabel.CENTER);
		target3latJLabel.setBounds(260, 231, 150, 30);
		target3latJLabel.setForeground(Color.BLACK);
		target3latJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target3latJLabel);

		// target3 정보 넣는 JLabel(longitude)
		JLabel target3lngJLabel = new JLabel("128.467447");
		target3lngJLabel.setHorizontalAlignment(JLabel.CENTER);
		target3lngJLabel.setBounds(525, 231, 150, 30);
		target3lngJLabel.setForeground(Color.BLACK);
		target3lngJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target3lngJLabel);

		// 그리드 표 이미지 넣는 JLabel
		JLabel gridJLabel = new JLabel(sgridImageIcon);
		gridJLabel.setBounds(0, 5, sgridImageIcon.getIconWidth(), sgridImageIcon.getIconHeight());
		lowerPanel.add(gridJLabel);

		// 왼쪽 화살표 이미지 넣는 JLabel
		JLabel leftJLabel = new JLabel(sleftImageIcon);
		leftJLabel.setBounds(280, 305, sleftImageIcon.getIconWidth(), sleftImageIcon.getIconHeight());
		lowerPanel.add(leftJLabel);

		// 오른쪽 화살표 이미지 넣는 JLabel
		JLabel rightJLabel = new JLabel(srightImageIcon);
		rightJLabel.setBounds(410, 305, srightImageIcon.getIconWidth(), srightImageIcon.getIconHeight());
		lowerPanel.add(rightJLabel);

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
