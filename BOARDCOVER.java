import java.util.Scanner;

public class BOARDCOVER {
	
	static int h,w;
	static int count;
	
	public static void main(String args[])
	{
	
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			
			int[][] board = new int[20][20];
			int num = 0;
			String s;
			char c;
			
			h = sc.nextInt();
			w = sc.nextInt();
			
			for(int j = 0; j < h; j++)
			{
				s = sc.next();
				for(int k = 0; k < w; k++)
				{
					c = s.charAt(k);
					if(c == '.') 
					{
						board[j][k] = 0;
						num++;
					}
					else board[j][k] = 1;
				}
			}
			count = 0;
			B_cover(board,num);
			System.out.println(count);
		}
	}
	
	public static void B_cover(int[][] board, int num)
	{
		int i = 0, j = 0;
		
		if(num == 0)
		{
			count++;
			return;
		}
		
		for(i = 0; i < h; i++)
		{
			for(j = 0; j < w; j++)
			{
				if(board[i][j] == 0) break;
			}
			if(j != w) break;
		}
				
		if(i+1 < h && j-1 >= 0)
		{
			if(board[i+1][j] == 0 && board[i+1][j-1] == 0)
			{
				board[i][j] = 1;
				board[i+1][j] = 1;
				board[i+1][j-1] = 1;
				B_cover(board, num-3);
				board[i][j] = 0;
				board[i+1][j] = 0;
				board[i+1][j-1] = 0;
			}
		}
		
		if(i+1 < h && j+1 < w)
		{
			if(board[i+1][j] == 0 && board[i+1][j+1] == 0)
			{
				board[i][j] = 1;
				board[i+1][j] = 1;
				board[i+1][j+1] = 1;
				B_cover(board, num-3);
				board[i][j] = 0;
				board[i+1][j] = 0;
				board[i+1][j+1] = 0;
			}
			
			if(board[i][j+1]== 0 && board[i+1][j+1] == 0)
			{
				board[i][j] = 1;
				board[i][j+1] = 1;
				board[i+1][j+1] = 1;
				B_cover(board, num-3);
				board[i][j] = 0;
				board[i][j+1] = 0;
				board[i+1][j+1] = 0;
			}
			
			if(board[i+1][j] == 0 && board[i][j+1] == 0)
			{
				board[i][j] = 1;
				board[i+1][j] = 1;
				board[i][j+1] = 1;
				B_cover(board, num-3);
				board[i][j] = 0;
				board[i+1][j] = 0;
				board[i][j+1] = 0;
			}
		}
	}
}
