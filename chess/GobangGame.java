package Chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		/*
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;*/
		
		String[][] board = chessboard.getBoard();
		//����ϵ�����ֱ�Ϊ��/������\������-������|��
		int factor[] = {1,1,1,-1,1,0,0,1};
		//��������
		int count; 
		int posX = 0, posY = 0;
		boolean isDecided = false;
		String ico;
		outer:
		//����ɨ��
		for (int x = 0; x < Chessboard.BOARD_SIZE; x++) {
			for (int y = 0; y < Chessboard.BOARD_SIZE; y++) {
				ico = board[x][y];
				if(ico == "ʮ"){
					continue;
				}
				for (int i = 0; i < factor.length; i+=2) {
					count = 0;
					//����factorָ���ķ���ɨ��
					for (int j = WIN_COUNT*-1; j < WIN_COUNT; j++) 
					{
						int curX = x + factor[i]*j, curY = y + factor[i+1]*j;
						if(curX>0 && curX<Chessboard.BOARD_SIZE && curY>0 && curY<Chessboard.BOARD_SIZE)
						{
							 if(board[curX][curY].equals(ico)){
								 count++;
							 }else{
								 count = 0;
							 }
							 //����3��
							 if (count == WIN_COUNT - 2)
							 {
								//��������
								posX = curX + factor[i];
								posY = curY + factor[i+1];
								if((posX>0 && posX<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "ʮ"){
									isDecided = true;
									break outer;
								}
								//��������
								posX = curX - factor[i]*3;
								posY = curY - factor[i+1]*3;
								if((posX>0 && posX<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "ʮ"){
									isDecided = true;
									break outer;
								}
							 }
							 //�жϲ�������������
							 if(count == WIN_COUNT - 2 && board[curX][curY]!="+" && board[curX+1][curY]!="+" && board[curX+3][curY]!="+")
							{
									posX = curX + factor[i]-2;
									posY = curY + factor[i+1]-2;
									
									if((posX>0 && posY<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "ʮ")
									{
										isDecided = true;
										break outer;
						            }
					        }
				
			         }
		       }
		}
	}
}
		if(!isDecided){
			do {
				posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
				posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			} while (board[posX][posY] != "ʮ");
		}
		
		int[] result = { posX, posY };
		return result;

        
		
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//�ж���Ϸ�Ƿ�Ӯ,���������жϣ���б���ж��Ƿ�������������������о��棬�޾ͼ١�
		//����posX��posY�����������ӵ�x��y���꣬ico�������µ��������ͣ�
		// ���Ӯ�ˣ�����true�����򷵻�false��isWon��������ÿ����������������ߡ����ԡ����壩���á�
        /*
		boolean way1 = way1(posX, posY, ico);
		if (way1)
		{
			return way1;
		}
		else
		{
			boolean way2 = way2(posX, posY, ico);
			if (way2)
			{
				return way2;
			}
			else
			{
				boolean way3 = way3(posX, posY, ico);
				if (way3)
				{
					return way3;
				}
				else
				{
					boolean way4 = way4(posX, posY, ico);
					if (way4)
					{
						return way4;
					}
					else
					{
						return false;
					}
				}

			}
		}
	}

	public boolean way1(int posX, int posY, String ico)
	{
		// ˮƽ
		boolean way1;
		int min_x1, max_x1;
		String str1 = "", subString = ico + ico + ico + ico + ico;
		if (posX - WIN_COUNT + 1 < 0)
		{
			min_x1 = 0;
		}
		else
		{
			min_x1 = posX - WIN_COUNT + 1;
		}
		if (posX + WIN_COUNT - 1 > 14)
		{
			max_x1 = 14;
		}
		else
		{
			max_x1 = posX + WIN_COUNT - 1;
		}
		String[][] chess = chessboard.getBoard();

		for (int i = min_x1; i <= max_x1; i++)
		{
			str1 += chess[posY][i];
		}
		way1 = str1.contains(subString);
		return way1;
	}

	public boolean way2(int posX, int posY, String ico)
	{
		// ��ֱ
		boolean way2;
		int min_y2, max_y2;
		String str1 = "", subString = ico + ico + ico + ico + ico;
		if (posY - WIN_COUNT + 1 < 0)
		{
			min_y2 = 0;
		}
		else
		{
			min_y2 = posY - WIN_COUNT + 1;
		}

		if (posY + WIN_COUNT - 1 > 14)
		{
			max_y2 = 14;
		}
		else
		{
			max_y2 = posY + WIN_COUNT - 1;
		}

		String[][] chess = chessboard.getBoard();

		for (int i = min_y2; i <= max_y2; i++)
		{
			str1 += chess[i][posX];
		}
		way2 = str1.contains(subString);
		return way2;
	}

	public boolean way3(int posX, int posY, String ico)
	{
		// ��б
		boolean way3;
		int min_x3, max_x3, min_y3, max_y3;
		String str = "", subString = ico + ico + ico + ico + ico;
		int x,y,i=1,n=1;
		max_x3=posX;
		min_x3=posX;
		max_y3=posY;
		min_y3=posY;
		while (i<5)
		{
			if (max_x3==14||max_y3==14)
			{
				break;
			}
			max_x3++;
			max_y3++;
			i++;
		}
		while (n<5)
		{
			if (min_x3==0||min_y3==0)
			{
				break;
			}
			min_x3--;
			min_y3--;
			n++;
		}
		x=min_x3;
		y=min_y3;
		while (true)
		{
			str += chessboard.getBoard()[y][x];
			
			if (x==max_x3)
			{
				break;
			}
			x++;
			y++;
		}
		way3 = str.contains(subString);
		return way3;
	}

	public boolean way4(int posX, int posY, String ico)
	{
		// ��б
		boolean way4;
		int min_x4, max_x4, min_y4, max_y4;
		String str = "", subString = ico + ico + ico + ico + ico;
		int x,y,i=1,n=1;
		max_x4=posX;
		min_x4=posX;
		max_y4=posY;
		min_y4=posY;
		while (i<5)
		{
			if (max_x4==14||min_y4==0)
			{
				break;
			}
			max_x4++;
			min_y4--;
			i++;
		}
		while (n<5)
		{
			if (min_x4==0||max_y4==14)
			{
				break;
			}
			min_x4--;
			max_y4++;
			n++;
		}
		x=max_x4;
		y=min_y4;
		while (true)
		{
			str += chessboard.getBoard()[y][x];
			
			if (x==min_x4)
			{
				break;
			}
			x--;
			y++;
		}
		way4 = str.contains(subString);
		return way4;
		*/
		
		String[][] board = chessboard.getBoard();
		//����ϵ�����ֱ�Ϊ��/������\������-������|��
		int factor[] = {1,1,1,-1,1,0,0,1};
		//��������
		int count; 
		for (int i = 0; i < factor.length; i+=2) {
			count = 0;
			//����factorָ���ķ���ɨ��
			for (int j = WIN_COUNT*-1; j < WIN_COUNT; j++) {
				int newX = posX + factor[i]*j, newY = posY + factor[i+1]*j;
				if(newX >= 0 && newX < Chessboard.BOARD_SIZE && 
						newY >= 0 && newY < Chessboard.BOARD_SIZE){
					 if(board[newX][newY].equals(ico)){
						 count++;
					 }else{
						 count = 0;
					 }
					 //����5��
					 if (count == WIN_COUNT){
						 return true;
					 }
				}
			}
		}
		return false;

	}


	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
