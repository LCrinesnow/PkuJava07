package Five_Chess;

public class Chessboard {

	// 定义一个二维数组来充当棋盘
	private String[][] board;
	// 定义棋盘的大小
	public static final int BOARD_SIZE = 22;
	private int lastX = -1, lastY = -1;//记录棋局中当前最后一步下棋的位置
	/**
	 * 初始化棋盘
	 * 
	 * @return void
	 */
	public void initBoard() {
		// 初始化棋盘数组
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// 把每个元素赋值为“十”，用于控制台输出棋盘
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "十";
			}
		}
	}
	
	public void test() {
		Object[][] array = new Object[10][10];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = new Object();
			}
		}
	}

	/**
	 * 在控制台输出棋盘的方法
	 */
	public void printBoard() {
		// 打印每个数组元素
		System.out.printf("    ");
		for (int i=1; i < BOARD_SIZE; i+=2)
		{
			System.out.printf("%02d ",i+1);// 第一行显示列号序列
		}
		System.out.println();
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.printf("%02d", i+1);		// 首列显示行号
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (i == lastX && j == lastY)
				{
					System.out.print("◎");		// 突出显示最后下棋位置的棋子
				}else
				{
				// 打印后不换行
				System.out.print(board[i][j]);
				}
			}
			// 每打印完一行数组元素就换行一次
			System.out.print("\n");
		}
		System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
	}

	/**
	 * 给棋盘位置赋值
	 * 
	 * @param posX
	 *            X坐标
	 * @param posY
	 *            Y坐标
	 * @param chessman
	 *            棋子
	 */
	public void setBoard(int posX, int posY, String chessman,int Val_Chart[][]) {
	
		lastX = posX;
		lastY = posY;
		
		this.board[posX][posY] = chessman;
		
		
		//权值数组赋值8个方向
		//为了不因为添子而改变累计的权值添加<1的限制条件＋边界溢出限制
//		System.out.print(Val_Chart[posX+1][posY]+" ");
//		System.out.print(Val_Chart[posX][posY+1]+" ");
//		System.out.print(Val_Chart[posX+1][posY+1]+" ");
//		System.out.print(Val_Chart[posX+1][posY-1]+" ");
//		System.out.print(Val_Chart[posX-1][posY+1]+" ");
//		System.out.print(Val_Chart[posX-1][posY]+" ");
//		System.out.print(Val_Chart[posX][posY-1]+" ");
//		System.out.print(Val_Chart[posX-1][posY-1]+" ");


		if(posX+1<= Chessboard.BOARD_SIZE-1&&(Val_Chart[posX+1][posY]==0)){System.out.println("cheng1");Val_Chart[posX+1][posY]=1;}
		if(posY+1<= Chessboard.BOARD_SIZE-1&&(Val_Chart[posX][posY+1]==0)){System.out.println("cheng2");Val_Chart[posX][posY+1]=1;}
		if(posX+1<= Chessboard.BOARD_SIZE-1&&posY+1<= Chessboard.BOARD_SIZE-1&&(Val_Chart[posX+1][posY+1]==0)){System.out.println("cheng3");Val_Chart[posX+1][posY+1]=1;}
		if(posX+1<= Chessboard.BOARD_SIZE-1&&posY-1>=0&&(Val_Chart[posX+1][posY-1]==0)){System.out.println("cheng4");Val_Chart[posX+1][posY-1]=1;}
		if(posY+1<= Chessboard.BOARD_SIZE-1&&posX-1>=0&&(Val_Chart[posX-1][posY+1]==0)){System.out.println("cheng5");Val_Chart[posX-1][posY+1]=1;}
		if(posX-1>=0&&(Val_Chart[posX-1][posY]==0)){System.out.println("cheng6");Val_Chart[posX-1][posY]=1;}
		if(posY-1>=0&&(Val_Chart[posX][posY-1]==0)){System.out.println("cheng7");Val_Chart[posX][posY-1]=1;}
		if(posX-1>=0&&posY-1>=0&&(Val_Chart[posX-1][posY-1]==0)){System.out.println("cheng8");Val_Chart[posX-1][posY-1]=1;}
		
		
	}

	/**
	 * 返回棋盘
	 * 
	 * @return 返回棋盘
	 */
	public String[][] getBoard() {
		return this.board;
	}
}

