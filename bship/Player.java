package bship;

public class Player {
	private int counter;
	private String[][] grid = new String[12][];
	
	Player(){
		Grid.PopulateGrid(grid);
		counter = 17;
	}

	public void Place(int x, int y, String ship, int slen, int dir, Player p, String[][] grid){
		y = y+1;
		x = x+1;
		if (dir == 0){
			for (int i = 0; i < slen; i++){
				grid[y-i][x] = ship;
				p.setGrid(grid);
			}
		}
		if (dir == 1){
			for (int i = 0; i < slen; i++){
				grid[y][x+i] = ship;
				p.setGrid(grid);
			}
		}
		if (dir == 2){
			for (int i = 0; i < slen; i++){
				grid[y + i][x]= ship;
				p.setGrid(grid);
			}
		}
		if (dir == 3){
			for (int i = 0; i < slen; i++){
				grid[y][x-i] = ship;
				p.setGrid(grid);
			}
		}
	}
	
	public void Shoot(int x, int y, String[][] grid, Player p){
		y = y+1;
		x = x+1;
		if (grid[y][x] != "o" && grid[y][x] != "X" && grid[y][x] != "-"){
			grid[y][x]= "X";
			p.setGrid(grid);
			p.counter--;
			System.out.println("Hit");
		}
		if (grid[y][x] == "o"){
			grid[y][x] ="-";
			p.setGrid(grid);
			System.out.println("Miss");
		}
	}
	
	public  void Shoot(int x, int y, String[][] grid, String[][] viewer, Player p){
		y = y+1;
		x = x+1;
		if (grid[y][x] != "o" && grid[y][x] != "X" && grid[y][x] != "-"){
			grid[y][x]= "X";
			viewer[y][x] = "X";
			p.setGrid(grid);
			p.counter--;
		}
		if (grid[y][x] == "o"){
			grid[y][x] ="-";
			viewer[y][x] = "-";
			p.setGrid(grid);
		}
	}
	
	public int getCounter() {
		return counter;
	}

	

	
	

	public String[][] getGrid() {
		return grid;
	}

	public void setGrid(String[][] grid) {
		this.grid = grid;
	}
	
	
}
