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

        // ������ �г�(����)
        imageLabel = new JLabel();
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(imageLabel, BorderLayout.CENTER);
        c.add(BorderLayout.EAST, rightPanel);

        // ���� �г�(��ĭ)
        JPanel leftPanel = new JPanel();
        c.add(BorderLayout.CENTER, leftPanel);

        // ���̹� ���� �ε�
        loadMap();

        frm.setVisible(true);
    }

    public void loadMap() {
        AddressVO vo = new AddressVO();
        vo.setX("128.467687"); // �⺻ �浵 (�б� ����)
        vo.setY("36.168547"); // �⺻ ���� (�б� ����)
        vo.setRoadAddress("���� ��ġ");
        vo.setJibunAddress("���� ��ġ");

        // ���� ǥ��
        new NaverMap(this).map_service(vo);
    }

    public static void main(String[] args) {
        new Project01_F().initGUI();
    }
}
