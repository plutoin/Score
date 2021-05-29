프로그램을 실행했을 때 가장 초기 화면에는 아무것도 뜨지 않게 했다. 맨 위에 학번, 이름, JAVA, Python, C++이라는 헤더를 넣어 정보를 입력하였을 때 구분이 될 수 있도록 하였다. 실행 창 상단에는 “성적 관리 프로그램”이라는 문자가 뜰 수 있도록 하였으며, 창 크기는 500*400으로 설정하였다.

JFrame frame = new JFrame("성적 관리 프로그램");
		setSize(500, 400);
		String header[] = {"학번","이름","JAVA","Python","C++"};
		String contents[][] = {};

DefaultTableModel이라는 개념을 사용하였는데, 이 클래스를 사용하면 테이블에 행 단위로 쓰거나 삭제하는 것이 용이해진다. JTable 객체 생성 시 리모컨 역할을 하는 것과 같다. DefaultTableModel 객체를 생성하며 JTable의 데이터를 옮겨 저장한다.

[code]
DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
[/code]

초기 화면이 뜬 후에는 정보를 입력해야 하는데, 그 입력을 위해 JTextField를 사용하여 구현하였다. JTextField() 괄호 안에는 칸 크기를 지정해 주었다. TextField에서 입력받은 데이터를 배열에다 저장하여 addRow() 메소드로 입력해 주었다.

	JTextField studentID = new JTextField(5);
		JTextField nameField = new JTextField(5);
		JTextField subject1 = new JTextField(3);
                    .
                    .
                    inputStr[3] = subject2.getText();
		inputStr[4] = subject3.getText();
		model.addRow(inputStr);

모든 정보 입력이 완료된 후에는 정보를 추가할 수 있어야 하기 때문에 그 역할을 하는 버튼 기능을 구현하였다. 추가와 삭제 기능을 할 수 있도록 하였으며, 구분이 쉽게 색깔을 지정하였다. ActionListener를 통해 버튼이 작동할 수 있도록 하였다. String 배열을 통해 각 칸에서 입력된 정보를 배열에다 저장할 수 있게 했다.
JTable 클래스의 메소드 중 getSelectedRow()가 있는데, 이를 사용해 행을 선택해 삭제할 수 있도록 하였다. 만약 선택된 행이 없을 경우에는 –1값을 넘겨 주도록 설정하였다.

JButton addBtn = new JButton("추가");
		addBtn.setBackground(Color.YELLOW);      // 버튼 색 지정
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[5];
				inputStr[0] = studentID.getText();
		.
                    .
                    .
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					return;
				}
				else
				{
					model.removeRow(table.getSelectedRow());
				}
			}


마지막으로 BorderLayout을 통해 레이아웃을 설정해 주었다. panel의 방향은 입력 창의 위치가 바뀌며, scrollpane은 정보를 띄우는 공간의 위치를 뜻한다.

		frame.add(scrollpane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);

