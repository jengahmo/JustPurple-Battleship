package bship;

public class Grid {
	public static void PopulateGrid(String[][] grid){
		grid[0] = new String[]{" "," ","1","2","3","4","5","6","7","8","9","10"};
		grid[1] = new String[]{" "," "," "," "," "," "," "," "," "," "," "," ",};
		grid[2] = new String[]{"A"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[3] = new String[]{"B"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[4] = new String[]{"C"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[5] = new String[]{"D"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[6] = new String[]{"E"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[7] = new String[]{"F"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[8] = new String[]{"G"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[9] = new String[]{"H"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[10] = new String[]{"I"," ","o","o","o","o","o","o","o","o","o","o",};
		grid[11] = new String[]{"J"," ","o","o","o","o","o","o","o","o","o","o",};
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
	

