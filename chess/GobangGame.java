package Chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		/*
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;*/
		
		String[][] board = chessboard.getBoard();
		//方向系数，分别为“/”、“\”、“-”、“|”
		int factor[] = {1,1,1,-1,1,0,0,1};
		//连续计数
		int count; 
		int posX = 0, posY = 0;
		boolean isDecided = false;
		String ico;
		outer:
		//棋盘扫描
		for (int x = 0; x < Chessboard.BOARD_SIZE; x++) {
			for (int y = 0; y < Chessboard.BOARD_SIZE; y++) {
				ico = board[x][y];
				if(ico == "十"){
					continue;
				}
				for (int i = 0; i < factor.length; i+=2) {
					count = 0;
					//根据factor指定的方向扫描
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
							 //连够3子
							 if (count == WIN_COUNT - 2)
							 {
								//正向阻拦
								posX = curX + factor[i];
								posY = curY + factor[i+1];
								if((posX>0 && posX<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "十"){
									isDecided = true;
									break outer;
								}
								//反向阻拦
								posX = curX - factor[i]*3;
								posY = curY - factor[i+1]*3;
								if((posX>0 && posX<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "十"){
									isDecided = true;
									break outer;
								}
							 }
							 //判断不相连的三个子
							 if(count == WIN_COUNT - 2 && board[curX][curY]!="+" && board[curX+1][curY]!="+" && board[curX+3][curY]!="+")
							{
									posX = curX + factor[i]-2;
									posY = curY + factor[i+1]-2;
									
									if((posX>0 && posY<Chessboard.BOARD_SIZE && posY>0 && posY<Chessboard.BOARD_SIZE) && board[posX][posY] == "十")
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
			} while (board[posX][posY] != "十");
		}
		
		int[] result = { posX, posY };
		return result;

        
		
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		//判断游戏是否赢,横向纵向判断，再斜着判断是否有五子相连的情况，有就真，无就假。
		//参数posX与posY代表新下棋子的x与y坐标，ico代表新下的棋子类型，
		// 如果赢了，返回true，否则返回false。isWon方法会在每次下棋后（玩家下棋或者“电脑”下棋）调用。
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
		// 水平
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
		// 垂直
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
		// 左斜
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
		// 右斜
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
		//方向系数，分别为“/”、“\”、“-”、“|”
		int factor[] = {1,1,1,-1,1,0,0,1};
		//连续计数
		int count; 
		for (int i = 0; i < factor.length; i+=2) {
			count = 0;
			//根据factor指定的方向扫描
			for (int j = WIN_COUNT*-1; j < WIN_COUNT; j++) {
				int newX = posX + factor[i]*j, newY = posY + factor[i+1]*j;
				if(newX >= 0 && newX < Chessboard.BOARD_SIZE && 
						newY >= 0 && newY < Chessboard.BOARD_SIZE){
					 if(board[newX][newY].equals(ico)){
						 count++;
					 }else{
						 count = 0;
					 }
					 //连够5子
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
