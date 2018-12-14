package 최호식;

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
	JPanel jp1, jp2, jp3; // 회원등록삭제조회, 구구단, 결과
	JLabel jl1, jl2, jl3, jl4; // 회원id, 이름, 전화번호, 성별;
	JButton jb1, jb2, jb3, jb4; // 회원등록, 회원삭제, 전체회원조회, 구구단보기
	JTextField jf1, jf2, jf3; // id, 이름, 전화번호
	JTextArea ja; // 결과창
	ButtonGroup bg; // 체크박스그룹
	JRadioButton rbn1, rbn2;

	MainClass() {
		super("프로그래밍언어활용평가");
		jp1 = new JPanel();
		jp1.setBorder(new TitledBorder(new EtchedBorder(), "회원등록, 삭제, 조회"));
		Box hBox = Box.createHorizontalBox();
		hBox.add(jl1 = new JLabel("회원ID : "));
		hBox.add(jf1 = new JTextField(10));
		hBox.add(jl2 = new JLabel("회원이름 : "));
		hBox.add(jf2 = new JTextField(10));
		hBox.add(jl3 = new JLabel("전화번호 : "));
		hBox.add(jf3 = new JTextField(15));
		hBox.add(jl4 = new JLabel("성별 : "));
		bg = new ButtonGroup();
		bg.add(rbn1 = new JRadioButton("남"));
		bg.add(rbn2 = new JRadioButton("여"));
		hBox.add(rbn1);
		hBox.add(rbn2);
		jp1.add(hBox);
		Box hhBox = Box.createHorizontalBox();
		hhBox.add(jb1 = new JButton("회원등록"));
		hhBox.add(jb2 = new JButton("회원삭제"));
		hhBox.add(jb3 = new JButton("전체회원조회"));
		jp1.add(hhBox);

		jp2 = new JPanel();
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		jp2.add(jb4 = new JButton("구구단보기"));

		jp3 = new JPanel();
		jp3.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
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
			int result = JOptionPane.showConfirmDialog(null, "회원을 등록하시겠습니까?", "회원등록", JOptionPane.YES_NO_OPTION);
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
			int result = JOptionPane.showConfirmDialog(null, "회원을 삭제하시겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(jf1.getText());

			} else if (result == JOptionPane.CLOSED_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}

		if (e.getSource() == jb3) {
			String resultValue = "";
			String result = "회원ID" + "\t" + "회원이름" + "\t" + "전화번호" + "\t" + "성별" + "\n";
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				resultValue += pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n";
			}
			ja.setText(result + resultValue);
		}

		if (e.getSource() == jb4) {
			String str = JOptionPane.showInputDialog("몇단을 보시겠습니까?");
			if (str.equals(str)) {
				ja.setText(str + "단 : " + "\n" + pt1.getGugudan(Integer.parseInt(str)));
			}
		}
	}
}