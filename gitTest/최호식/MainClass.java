package ��ȣ��;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MainClass extends JFrame implements ActionListener {

	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	JPanel jp1, jp2, jp3; // ȸ����ϻ�����ȸ, ������, ���
	JLabel jl1, jl2, jl3, jl4; // ȸ��id, �̸�, ��ȭ��ȣ, ����;
	JButton jb1, jb2, jb3, jb4; // ȸ�����, ȸ������, ��üȸ����ȸ, �����ܺ���
	JTextField jf1, jf2, jf3; // id, �̸�, ��ȭ��ȣ
	JTextArea ja; // ���â
	ButtonGroup bg; // üũ�ڽ��׷�
	JRadioButton rbn1, rbn2;

	MainClass() {
		super("���α׷��־��Ȱ����");
		jp1 = new JPanel();
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "ȸ�����, ����, ��ȸ"));
		Box hBox = Box.createHorizontalBox();
		hBox.add(jl1 = new JLabel("ȸ��ID : "));
		hBox.add(jf1 = new JTextField(10));
		hBox.add(jl2 = new JLabel("ȸ���̸� : "));
		hBox.add(jf2 = new JTextField(10));
		hBox.add(jl3 = new JLabel("��ȭ��ȣ : "));
		hBox.add(jf3 = new JTextField(15));
		hBox.add(jl4 = new JLabel("���� : "));
		bg = new ButtonGroup();
		bg.add(rbn1 = new JRadioButton("��"));
		bg.add(rbn2 = new JRadioButton("��"));
		hBox.add(rbn1);
		hBox.add(rbn2);
		jp1.add(hBox);
		Box hhBox = Box.createHorizontalBox();
		hhBox.add(jb1 = new JButton("ȸ�����"));
		hhBox.add(jb2 = new JButton("ȸ������"));
		hhBox.add(jb3 = new JButton("��üȸ����ȸ"));
		jp1.add(hhBox);

		jp2 = new JPanel();
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "������"));
		jp2.add(jb4 = new JButton("�����ܺ���"));

		jp3 = new JPanel();
		jp3.setBorder(new TitledBorder(new EtchedBorder(), "���"));
		jp3.add(ja = new JTextArea(7, 70));
		ja.setEditable(false);

		Box vBox = Box.createVerticalBox();
		vBox.add(jp1);
		vBox.add(jp2);
		vBox.add(jp3);
		add(vBox);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setSize(800, 400);
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mc.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb1) {
			int result = JOptionPane.showConfirmDialog(null, "ȸ���� ����Ͻðڽ��ϱ�?", "ȸ�����", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				String strGender = "";
				Enumeration<AbstractButton> enums = bg.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton) ab;
					if (jb.isSelected())
						strGender = jb.getText();
				}
				pt2.mapListadd(jf1.getText(), jf2.getText(), jf3.getText(), strGender);
				// ja.setText(jf1.getText()+ jf2.getText()+ jf3.getText()+ strGender);
			} else if (result == JOptionPane.CLOSED_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}

		if (e.getSource() == jb2) {
			int result = JOptionPane.showConfirmDialog(null, "ȸ���� �����Ͻðڽ��ϱ�?", "ȸ������", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());

			} else if (result == JOptionPane.CLOSED_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}

		if (e.getSource() == jb3) {
			String resultValue = "";
			String result = "ȸ��ID" + "\t" + "ȸ���̸�" + "\t" + "��ȭ��ȣ" + "\t" + "����" + "\n";
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				resultValue += pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n";
			}
			ja.setText(result + resultValue);
		}

		if (e.getSource() == jb4) {
			String str = JOptionPane.showInputDialog("����� ���ðڽ��ϱ�?");
			if (str.equals(str)) {
				ja.setText(str + "�� : " + "\n" + pt1.getGugudan(Integer.parseInt(str)));
			}
		}
	}
}