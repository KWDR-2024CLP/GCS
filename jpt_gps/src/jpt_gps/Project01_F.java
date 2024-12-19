package jpt_gps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Project01_F {

	static JFrame frm;
	JLabel imageLabel;
	// 기본 지도 좌표를 저장하는 객체
	AddressVO vo = new AddressVO();

	JLabel target1latJLabel;
	JLabel target1lngJLabel;

	public void initGUI() {

		// 그리드 표 이미지
		ImageIcon gridImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\grid.png");
		Image gridImage = gridImageIcon.getImage();
		Image sgridImage = gridImage.getScaledInstance(740, 280, Image.SCALE_SMOOTH);
		ImageIcon sgridImageIcon = new ImageIcon(sgridImage);

		// 그리드 표 이미지(첫번째 줄 선택)
		ImageIcon grid1ImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\grid1.png");
		Image grid1Image = grid1ImageIcon.getImage();
		Image sgrid1Image = grid1Image.getScaledInstance(740, 280, Image.SCALE_SMOOTH);
		ImageIcon sgrid1ImageIcon = new ImageIcon(sgrid1Image);

		// 그리드 표 이미지(두번째 줄 선택)
		ImageIcon grid2ImageIcon = new ImageIcon("D:\\COLLEGE\\3학년 2학기\\CLP\\grid2.png");
		Image grid2Image = grid2ImageIcon.getImage();
		Image sgrid2Image = grid2Image.getScaledInstance(740, 280, Image.SCALE_SMOOTH);
		ImageIcon sgrid2ImageIcon = new ImageIcon(sgrid2Image);

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

		// 기본 프레임
		frm = new JFrame("Ground Control Station");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(1500, 800);

		// 지도 기본 좌표 설정
		vo.setX("128.468000"); // 경도
		vo.setY("36.168280"); // 위도
		vo.setRoadAddress("NOW");
		vo.setJibunAddress("NOW");

		frm.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("up");
					double latitude = Double.parseDouble(vo.getY());
					latitude += 0.0001;
					vo.setY(String.format("%.6f", latitude)); // 소수점 6자리 포맷

					// 지도 업데이트
					System.out.println("Updated Longitude: " + vo.getY());
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("down");
					double latitude = Double.parseDouble(vo.getY());
					latitude -= 0.0001;
					vo.setY(String.format("%.6f", latitude)); // 소수점 6자리 포맷

					// 지도 업데이트
					System.out.println("Updated Longitude: " + vo.getY());
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("left");
					double longitude = Double.parseDouble(vo.getX());
					longitude -= 0.0001;
					vo.setX(String.format("%.6f", longitude)); // 소수점 6자리 포맷

					// 지도 업데이트
					System.out.println("Updated Longitude: " + vo.getX());
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("right");
					double longitude = Double.parseDouble(vo.getX());
					longitude += 0.0001;
					vo.setX(String.format("%.6f", longitude)); // 소수점 6자리 포맷

					// 지도 업데이트
					System.out.println("Updated Longitude: " + vo.getX());
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					String target1lat = target1latJLabel.getText();
					double target1LAT = Double.parseDouble(target1lat) + 0.0001;
					String starget1lat = String.valueOf(target1LAT);
					target1latJLabel.setText(starget1lat);

					NaverMap.target1Y += 0.0001;
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					String target1lat = target1latJLabel.getText();
					double target1LAT = Double.parseDouble(target1lat) - 0.0001;
					String starget1lat = String.valueOf(target1LAT);
					target1latJLabel.setText(starget1lat);

					NaverMap.target1Y -= 0.0001;
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					String target1lng = target1lngJLabel.getText();
					double target1LNG = Double.parseDouble(target1lng) - 0.0001;
					String starget1lng = String.valueOf(target1LNG);
					target1lngJLabel.setText(starget1lng);

					NaverMap.target1X -= 0.0001;
					loadMap();
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {
					String target1lng = target1lngJLabel.getText();
					double target1LNG = Double.parseDouble(target1lng) + 0.0001;
					String starget1lng = String.valueOf(target1LNG);
					target1lngJLabel.setText(starget1lng);

					NaverMap.target1X += 0.0001;
					loadMap();
				}
			}
		});

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
		target1latJLabel = new JLabel("36.168197");
		target1latJLabel.setHorizontalAlignment(JLabel.CENTER);
		target1latJLabel.setBounds(260, 93, 150, 30);
		target1latJLabel.setForeground(Color.BLACK);
		target1latJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target1latJLabel);

		// target1 정보 넣는 JLabel(longitude)
		target1lngJLabel = new JLabel("128.467796");
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
		JLabel target2latJLabel = new JLabel("36.168302");
		target2latJLabel.setHorizontalAlignment(JLabel.CENTER);
		target2latJLabel.setBounds(260, 162, 150, 30);
		target2latJLabel.setForeground(Color.BLACK);
		target2latJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target2latJLabel);

		// target2 정보 넣는 JLabel(longitude)
		JLabel target2lngJLabel = new JLabel("128.467714");
		target2lngJLabel.setHorizontalAlignment(JLabel.CENTER);
		target2lngJLabel.setBounds(525, 162, 150, 30);
		target2lngJLabel.setForeground(Color.BLACK);
		target2lngJLabel.setFont(new Font("Bauhaus", Font.BOLD, 23));
		lowerPanel.add(target2lngJLabel);

		// 그리드 표 이미지 넣는 JLabel
		JLabel gridJLabel = new JLabel(sgridImageIcon);
		gridJLabel.setBounds(0, 5, sgridImageIcon.getIconWidth(), sgridImageIcon.getIconHeight());
		lowerPanel.add(gridJLabel);

		// target1 클릭 시 변하는 기능
		JLabel row1JLabel = new JLabel("===============");
		row1JLabel.setHorizontalAlignment(JLabel.CENTER);
		row1JLabel.setBounds(20, 93, 700, 40);
		row1JLabel.setForeground(Color.white);
		row1JLabel.setFont(new Font("Bauhaus", Font.BOLD, 70));
		lowerPanel.add(row1JLabel);
		row1JLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				gridJLabel.setIcon(sgrid1ImageIcon);

				int result = JOptionPane.showConfirmDialog(null, "Do you want to track Target1?",
						"Tracking Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE // 물음표 아이콘 제거
				);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Tracking Target1 started.", "Info", JOptionPane.PLAIN_MESSAGE);
					// 추적 시작 로직 추가 가능
					target2JLabel.setVisible(false);
					target2latJLabel.setVisible(false);
					target2lngJLabel.setVisible(false);
					// repair
					loadMap();
					removeTarget2();
				} else {
					JOptionPane.showMessageDialog(null, "Tracking cancelled.", "Info", JOptionPane.PLAIN_MESSAGE);
					gridJLabel.setIcon(sgridImageIcon);
				}
			}
		});

		// target2 클릭 시 변하는 기능
		JLabel row2JLabel = new JLabel("===============");
		row2JLabel.setHorizontalAlignment(JLabel.CENTER);
		row2JLabel.setBounds(20, 162, 700, 40);
		row2JLabel.setForeground(Color.white);
		row2JLabel.setFont(new Font("Bauhaus", Font.BOLD, 70));
		lowerPanel.add(row2JLabel);
		row2JLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				gridJLabel.setIcon(sgrid2ImageIcon);

				int result = JOptionPane.showConfirmDialog(null, "Do you want to track Target2?",
						"Tracking Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE // 물음표 아이콘 제거
				);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Tracking Target2 started.", "Info", JOptionPane.PLAIN_MESSAGE);
					// 추적 시작 로직 추가 가능
					target1JLabel.setVisible(false);
					target1latJLabel.setVisible(false);
					target1lngJLabel.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Tracking cancelled.", "Info", JOptionPane.PLAIN_MESSAGE);
					gridJLabel.setIcon(sgridImageIcon);
				}
			}
		});

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
		// 지도 표시
		new NaverMap(this).map_service(vo);
	}

	public void removeTarget2() {
		NaverMap.removeMarker("target2");
		loadMap();
	}

	public static void main(String[] args) {
		new Project01_F().initGUI();
	}
}
