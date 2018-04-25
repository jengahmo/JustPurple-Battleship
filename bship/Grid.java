package bship;

public class Grid {
	public static void PopulateGrid(String[][] grid){
		grid[0] = new String[]{" "," ","1","2","3","4","5","6","7","8","9","10"};
		grid[1] = new String[]{" "," "," "," "," "," "," "," "," "," "," "," ",};
		grid[2] = new String[]{"A"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[3] = new String[]{"B"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[4] = new String[]{"C"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[5] = new String[]{"D"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[6] = new String[]{"E"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[7] = new String[]{"F"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[8] = new String[]{"G"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[9] = new String[]{"H"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[10] = new String[]{"I"," ",".",".",".",".",".",".",".",".",".",".",};
		grid[11] = new String[]{"J"," ",".",".",".",".",".",".",".",".",".",".",};
	}

	public static void showGrid(String[][] grid) {
		for (int i = 0; i <grid.length; i++){
			for (int j=0; j < grid.length; j++){
				System.out.print(grid[i][j] + " ");
				
			}
			System.out.println();
		}
	}
}
	

