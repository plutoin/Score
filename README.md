## 🖥 PROJECT 소개

2019년 1학기 자바프로그래밍실습 강의 기말 텀 프로젝트 제작

> JAVA를 이용해 만들어진 프로그램을 구현해 보며 심화 학습을 하고자 프로젝트에 참여하게 되었다. JAVA를 사용하여 여러 프로그램을 만들 수 있는데, 그중에서도 학교에서 가장 사용이 많이 될 성적 관리 프로그램을 구현해 보았다. 학생의 학번, 이름, 과목별 성적을 입력한 후 추가 버튼을 누를 경우에 순차적으로 정보가 입력되도록 구현하였다.

🗓️ **작업기간** : 2019. 06.

👨‍💻 **투입인원** : 1명

📒 **주요업무** 

- 기획 및 설계
- 개발

🌱 **스킬 및 사용툴**

`Java` `Eclipse`

<br>

## 🖌️ INFO


1. 최초 실행 화면

![init](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d7e88bbf-388d-441d-9ee7-d476e3c04710/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210727%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210727T071250Z&X-Amz-Expires=86400&X-Amz-Signature=5cb254617bb87519be9f950bc025635f2c9644b32454851b5ca5480883edfa2f&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

2. 성적 입력 후 추가 버튼 눌렀을 때

![add](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e1c48b1b-74f7-44ba-9899-449cbbf7551a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210727%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210727T071423Z&X-Amz-Expires=86400&X-Amz-Signature=88beb873e526f9605546d0613e545d7784a8046f53cf1d8a8d09dcb0937056b0&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

3. 삭제 항목 선택 후 삭제 버튼 눌렀을 때

![delete](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8f1b903a-f726-4a9b-b7d8-29064ac17a14/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210727%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210727T071443Z&X-Amz-Expires=86400&X-Amz-Signature=6b9183aa042d15329005fcdac3f283741cd2b317d8048cd2d45420f512c685e5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

<br>

## ✔️ CODE

프로그램을 실행했을 때 가장 초기 화면에는 아무것도 뜨지 않게 했다. 맨 위에 학번, 이름, JAVA, Python, C++이라는 헤더를 넣어 정보를 입력하였을 때 구분이 될 수 있도록 하였다. 실행 창 상단에는 “성적 관리 프로그램”이라는 문자가 뜰 수 있도록 하였으며, 창 크기는 `500*400`으로 설정하였다.

	JFrame frame = new JFrame("성적 관리 프로그램");
		setSize(500, 400);
		String header[] = {"학번","이름","JAVA","Python","C++"};
		String contents[][] = {};

`DefaultTableModel`이라는 개념을 사용하였는데, 이 클래스를 사용하면 테이블에 행 단위로 쓰거나 삭제하는 것이 용이해진다. `JTable` 객체 생성 시 리모컨 역할을 하는 것과 같다. `DefaultTableModel` 객체를 생성하며 `JTable`의 데이터를 옮겨 저장한다.

	DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);

초기 화면이 뜬 후에는 정보를 입력해야 하는데, 그 입력을 위해 `JTextField`를 사용하여 구현하였다. `JTextField()` 괄호 안에는 칸 크기를 지정해 주었다. `TextField`에서 입력받은 데이터를 배열에다 저장하여 `addRow()` 메소드로 입력해 주었다.

	JTextField studentID = new JTextField(5);
		JTextField nameField = new JTextField(5);
		JTextField subject1 = new JTextField(3);
                    .
                    .
                    inputStr[3] = subject2.getText();
		inputStr[4] = subject3.getText();
		model.addRow(inputStr);

모든 정보 입력이 완료된 후에는 정보를 추가할 수 있어야 하기 때문에 그 역할을 하는 버튼 기능을 구현하였다. 추가와 삭제 기능을 할 수 있도록 하였으며, 구분이 쉽게 색깔을 지정하였다. `ActionListener`를 통해 버튼이 작동할 수 있도록 하였다. `String` 배열을 통해 각 칸에서 입력된 정보를 배열에다 저장할 수 있게 했다.
`JTable` 클래스의 메소드 중 `getSelectedRow()`가 있는데, 이를 사용해 행을 선택해 삭제할 수 있도록 하였다. 만약 선택된 행이 없을 경우에는 –1값을 넘겨 주도록 설정하였다.


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


마지막으로 `BorderLayout`을 통해 레이아웃을 설정해 주었다. `panel`의 방향은 입력 창의 위치가 바뀌며, `scrollpane`은 정보를 띄우는 공간의 위치를 뜻한다.

		frame.add(scrollpane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);

