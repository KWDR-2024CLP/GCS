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

        // ���� �г� (����)
        imageLabel = new JLabel();
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(imageLabel, BorderLayout.CENTER); // ���� �߰�
        leftPanel.setPreferredSize(new Dimension(750, 800));
        c.add(BorderLayout.WEST, leftPanel);

        // ������ �г� (�� �Ʒ��� ����)
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(750, 800));

        // ��� �г� (����)
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Color.LIGHT_GRAY);
        upperPanel.setPreferredSize(new Dimension(750, 400));

        JLabel droneLabel = new JLabel("��� ī�޶� ���� �����Դϴ�...", JLabel.CENTER); // �߾� ����
        droneLabel.setForeground(Color.BLACK); // ���� �� ����
        droneLabel.setFont(droneLabel.getFont().deriveFont(20.0f)); // ���� ũ�� ����
        upperPanel.add(droneLabel, BorderLayout.CENTER); // ��� �г� �߾ӿ� �߰�

        // �ϴ� �г� (��ĭ)
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.WHITE);
        lowerPanel.setPreferredSize(new Dimension(750, 400));

        // ������ �гο� �߰�
        rightPanel.add(upperPanel, BorderLayout.NORTH);
        rightPanel.add(lowerPanel, BorderLayout.SOUTH);

        c.add(BorderLayout.CENTER, rightPanel);

        // ���̹� ���� �ε�
        loadMap();

        frm.setVisible(true);
    }

    public void loadMap() {
        AddressVO vo = new AddressVO();
        vo.setX("128.467687"); // �⺻ �浵 (�б� ����)
        vo.setY("36.168547"); // �⺻ ���� (�б� ����)
        vo.setRoadAddress("NOW");
        vo.setJibunAddress("NOW");

        // ���� ǥ��
        new NaverMap(this).map_service(vo);
    }

    public static void main(String[] args) {
        new Project01_F().initGUI();
    }
}
