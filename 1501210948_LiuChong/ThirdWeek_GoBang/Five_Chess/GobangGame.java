package Five_Chess;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GobangGame {
	// 定义达到赢条件的棋子数目
		private final int WIN_COUNT = 5;
		// 定义用户输入的X坐标
		private int posX = 0;   //[私有属性，共类调用]
		// 定义用户输入的X坐标
		private int posY = 0;   //[私有属性，共类调用]
		// 定义棋盘
		private Chessboard chessboard;   //[私有属性，共类调用]

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
			//权值数组置0
			int [][] Val_Chart=new int [Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE];
			for(int i=0;i<22;i++){
				for(int j=0;j<22;j++){
					Val_Chart[i][j]=0;
				}
			}
			// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
			while ((inputStr = br.readLine()) != null) {
				isOver = false;
				if (!isValid(inputStr)) {
					// 如果不合法，要求重新输入，再继续
					continue;
				}
				// 把对应的数组元素赋为"●"
				String chessman = Chessman.BLACK.getChessman();
				
				chessboard.setBoard(posX, posY, chessman,Val_Chart);
				// 判断用户是否赢了

				if (isWon(posX, posY, chessman,Val_Chart)) {
					isOver = true;

				} else {
					// 计算机随机选择位置坐标
					int[] computerPosArr = computerDo(Val_Chart);
					System.out.println(computerPosArr[0]);
					System.out.println(computerPosArr[1]);

					chessman = Chessman.WHITE.getChessman();
					chessboard.setBoard(computerPosArr[0], computerPosArr[1],
							chessman,Val_Chart);
					// 判断计算机是否赢了
					if (isWon(computerPosArr[0], computerPosArr[1], chessman,Val_Chart)) {
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

		public int[] computerDo(int Val_Chart[][]) {
			int max=0;
			String[][] board = chessboard.getBoard();
			for(int i=0;i<Chessboard.BOARD_SIZE-1;i++){
				for(int j=0;j<Chessboard.BOARD_SIZE-1;j++){
//					System.out.println("val:"+Val_Chart[i][j]);
//					System.out.println("i:"+i);
//					System.out.println("j:"+j);
//					if(i+1==Chessboard.BOARD_SIZE||j+1==Chessboard.BOARD_SIZE) continue;
					
						if(Val_Chart[i][j]>max){
							max=Val_Chart[i][j];
							System.out.println("i:"+i);
							System.out.println("j:"+j);
							if(board[i][j]=="十"){
								posX=i;
								posY=j;
								System.out.println("i:"+i);
								System.out.println("j:"+j);
							}
							else max=0;
						}
				}
			}
			System.out.println("max:"+max);
			
//			for(int i=0;i<22;i++){
//				for(int j=0;j<22;j++){
//					if(Val_Chart[i][j]==max)
//						 posX = i;
//					     posY = j;
//				}
//			}
			System.out.println("posx:"+posX);
			System.out.println("posy:"+posY);

	
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
		public boolean isWon(int posX, int posY, String ico,int Val_Chart[][]) {
			String[][] board=chessboard.getBoard();
			if(row(posX,posY,ico,board,Val_Chart)||
			   col(posX,posY,ico,board,Val_Chart)||
			  Left(posX,posY,ico,board,Val_Chart)||
			  Right(posX,posY,ico,board,Val_Chart))return true;
			return false;//若一直没true return false
		}
		public boolean row(int posX, int posY, String ico,String[][] board,int Val_Chart[][]){
			int row=0;
			int i=posY+1;
			int end1,end2;//[AI]//连成线的两个端点棋子位置
		//row_start
		//row_R
			if ( i <= Chessboard.BOARD_SIZE-1){					//否则溢出
				while(board[posX][i] == ico){
					row++;
					i++;
					if(i > Chessboard.BOARD_SIZE-1)break;		//否则溢出
				}
			}
			end2=i-1;//[AI]//因为while跳出前＋1
		//row_L
			i=posY-1;
			if(i >= 0 ){										//否则溢出
				while(board[posX][i] == ico){
					row++;
					i--;
					if(i<0)break;								//否则溢出
				}
			}
			//[AI]
			end1=i+1;//因为while跳出前－1
			//左端点左边
			if((end1-1) >= 0&&Val_Chart[posX][end1-1]<row+1){
				Val_Chart[posX][end1-1]=row+1;
			}
			else if((end1-1) >= 0&&Val_Chart[posX][end1-1]>row+1){
				Val_Chart[posX][end1-1]=Val_Chart[posX][end1-1]+row+1;
			}
			//右端点右边
			if((end2+1) <= Chessboard.BOARD_SIZE-1&&Val_Chart[posX][end2+1]<row+1){
				Val_Chart[posX][end2+1]=row+1;
			}
			else if((end2+1) <= Chessboard.BOARD_SIZE-1&&Val_Chart[posX][end2+1]>row+1){
				Val_Chart[posX][end2+1]=Val_Chart[posX][end2+1]+row+1;

			}
//			//[AI]
//			printVal_Chart(Val_Chart);
//			System.out.print(endi1+1+" ");
//			System.out.print(endi2+1+" ");
		//row_end  >＝4时横向win
			if(row>=4) return true;
//			System.out.print(row);
			return false;
		}
		public boolean col(int posX, int posY, String ico,String[][] board,int Val_Chart[][]){
			int i=0,col=0;   
			i=posX+1;
			int end1,end2;//[AI]连成线的两个端点棋子位置
		//col_start
//			String[][] board=chessboard.getBoard();
		//col_Down
			if ( i <= Chessboard.BOARD_SIZE-1){					//否则溢出
				while(board[i][posY] == ico){
					col++;
					i++;
					if(i > Chessboard.BOARD_SIZE-1)break;		//否则溢出
				}
			}
			end2=i-1;//[AI]//因为while跳出前＋1
		//col_Up
			i=posX-1;
			if(i >= 0 ){										//否则溢出
				while(board[i][posY] == ico){
					col++;
					i--;
					if(i<0)break;								//否则溢出
				}
			}
			//[AI]
			end1=i+1;//因为while跳出前－1
//			//上端点上边
			if((end1-1) >= 0&&Val_Chart[end1-1][posY]<col+1){
				Val_Chart[end1-1][posY]=col+1;
			}
			else if((end1-1) >= 0&&Val_Chart[end1-1][posY]>col+1){
				Val_Chart[end1-1][posY]=Val_Chart[end1-1][posY]+col+1;
			}
			//下端点下边
			if((end2+1) <= Chessboard.BOARD_SIZE-1&&Val_Chart[end2+1][posY]<col+1){
				Val_Chart[end2+1][posY]=col+1;
			}
			else if((end2+1) <= Chessboard.BOARD_SIZE-1&&Val_Chart[end2+1][posY]>col+1){
				Val_Chart[end2+1][posY]=Val_Chart[end2+1][posY]+col+1;
			}
			//[AI]
//			printVal_Chart(Val_Chart);
		//col_end  >＝4时纵向win

			if(col>=4) return true;
//			System.out.print(col);
			return false;
		}
		public boolean Left(int posX, int posY, String ico,String[][] board,int Val_Chart[][]){
		    int Left=0;
			int i=posX+1;
	        int j=posY+1;
			int endi1,endj1,endi2,endj2;//连成线的两个端点棋子位置

	      //Left_start			   
	      //Left_down
			if ( i <= Chessboard.BOARD_SIZE-1 &&j <= Chessboard.BOARD_SIZE-1){					//否则溢出
		 		while(board[i][j] == ico){
					Left++;
					i++;
					j++;
					if(i > Chessboard.BOARD_SIZE-1||j > Chessboard.BOARD_SIZE-1)break;		//否则溢出
				}
			}
		  //左倾斜下端点坐标
			endi2=i-1;
			endj2=j-1;
	   	  //Left_up
			i=posX-1;
			j=posY-1;
			if(i >= 0 && j >= 0 ){	//否则溢出
				while(board[i][j] == ico){
					Left++;
					i--;
					j--;
					if(i<0||j<0)break;								//否则溢出
				}
			}
		  //左倾斜上端点坐标
			endi1=i+1;
			endj1=j+1;
			//[AI]
			//左倾斜上端点左倾斜上方向
			if((endi1-1) >= 0&&(endj1-1) >= 0&&Val_Chart[endi1-1][endj1-1]<Left+1){
				Val_Chart[endi1-1][endj1-1]=Left+1;
			}
			else if((endi1-1) >= 0&&(endj1-1) >= 0&&Val_Chart[endi1-1][endj1-1]>Left+1){
				Val_Chart[endi1-1][endj1-1]=Val_Chart[endi1-1][endj1-1]+Left+1;
			}
			//左倾斜下端点左倾斜下方向
			if((endi2+1) <= Chessboard.BOARD_SIZE-1&&(endj2+1)<= Chessboard.BOARD_SIZE-1&&Val_Chart[endi2+1][endj2+1]<Left+1){
				Val_Chart[endi2+1][endj2+1]=Left+1;
			}
			else if((endi2+1) <= Chessboard.BOARD_SIZE-1&&(endj2+1)<= Chessboard.BOARD_SIZE-1&&Val_Chart[endi2+1][endj2+1]>Left+1){
				Val_Chart[endi2+1][endj2+1]=Val_Chart[endi2+1][endj2+1]+Left+1;
			}
			//[AI]
//			printVal_Chart(Val_Chart);

		  //Left_end  >＝4时右斜向win
			if(Left>=4) return true;
//			System.out.print(Left);
			return false;
		}
		public boolean Right(int posX, int posY, String ico,String[][] board,int Val_Chart[][]){
		//Right_start
			int Right=0;
		    int i=posX+1;
		    int j=posY-1;
			int endi1,endj1,endi2,endj2;//连成线的两个端点棋子位置
		//Right_down
			if(i >= 0 && j >= 0 && (i <= Chessboard.BOARD_SIZE-1 &&j <= Chessboard.BOARD_SIZE-1)){	//否则溢出
				while(board[i][j] == ico){
					Right++;
					i++;
					j--;
					if(i > Chessboard.BOARD_SIZE-1||j > Chessboard.BOARD_SIZE-1)break;		//否则溢出
				}
			}
		//右倾斜下端点坐标
			endi2=i-1;
			endj2=j+1;
		//Right_up
			i=posX-1;
			j=posY+1;
			if(i >= 0 && j >= 0 && (i <= Chessboard.BOARD_SIZE-1 &&j <= Chessboard.BOARD_SIZE-1)){	//否则溢出
				while(board[i][j] == ico){
					Right++;
					i--;
					j++;
					if(i<0||j<0)break;								//否则溢出
				}
			}
			//[AI]
		//右倾斜上端点坐标
			endi1=i+1;
			endj1=j-1;
			//右上端点右上方向
			if((endi1-1) >= 0&&(endj1+1) <= Chessboard.BOARD_SIZE-1&&Val_Chart[endi1-1][endj1+1]<Right+1){
				Val_Chart[endi1-1][endj1+1]=Right+1;
			}
			else if((endi1-1) >= 0&&(endj1+1)<= Chessboard.BOARD_SIZE-1&&Val_Chart[endi1-1][endj1+1]>Right+1){
				Val_Chart[endi1-1][endj1+1]=Val_Chart[endi1-1][endj1+1]+Right+1;
			}
		//右倾斜下端点坐标
			if((endi2+1) <= Chessboard.BOARD_SIZE-1&&(endj2-1) >= 0&&Val_Chart[endi2+1][endj2-1]<Right+1){
				Val_Chart[endi2+1][endj2-1]=Right+1;
			}
			else if((endi2+1) <= Chessboard.BOARD_SIZE-1&&(endj2-1) >= 0&&Val_Chart[endi2+1][endj2-1]>Right+1){
				Val_Chart[endi2+1][endj2-1]=Val_Chart[endi2+1][endj2-1]+Right+1;
			}
			//[AI]
			printVal_Chart(Val_Chart);

		//Right_end  >＝4时右斜向win
			if(Right>=4) return true;
//			System.out.print(Right);
			return false;
		}
		public void printVal_Chart(int Val_Chart[][]){
			for(int i=0;i<22;i++){
				for(int j=0;j<22;j++){
					System.out.print(Val_Chart[i][j]);
				}
				System.out.println();
			}
		}
		public static void main(String[] args) throws Exception {

			GobangGame gb = new GobangGame(new Chessboard());
			gb.start();
		}
}
