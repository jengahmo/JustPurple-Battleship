package bship;

import java.util.Random;
import java.util.Scanner;

public class Player {
	private int counter;
	private String[][] grid = new String[12][];
	private int x;
	private int y;
	private int dir;
	
	Player(){
		Grid.PopulateGrid(grid);
		counter = 17;
		x = 1;
		y = 1;
		dir = 0;
	}

	public int getDir() {
		return dir;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
		if (grid[y][x] != "." && grid[y][x] != "X" && grid[y][x] != "-"){
			grid[y][x]= "X";
			p.setGrid(grid);
			p.counter--;
			System.out.println("Hit");
		}
		if (grid[y][x] == "."){
			grid[y][x] ="-";
			p.setGrid(grid);
			System.out.println("Miss");
		}
	}
	
	public  void Shoot(int x, int y, String[][] grid, String[][] viewer, Player p){
		y = y+1;
		x = x+1;
		if (grid[y][x] != "." && grid[y][x] != "X" && grid[y][x] != "-"){
			grid[y][x]= "X";
			viewer[y][x] = "X";
			p.setGrid(grid);
			p.counter--;
		}
		if (grid[y][x] == "."){
			grid[y][x] ="-";
			viewer[y][x] = "-";
			p.setGrid(grid);
		}
	}
	
	public int getCounter() {
		return counter;
	}

	
	public boolean loop( String[][] masterpgrid, boolean ovCheck, Scanner input, int ship, String name){
		boolean check = false;
		String strDir = "";
		String xstr = "";
		String y = "";
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your " + name + ": ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		this.x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your " + name + ": ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		this.y = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your " + name + " "
				+ "(0/u = up, 1/r = right, 2/d = down, 3/L = left): ");
			strDir = input.next();
			this.dir = Controls.dirToInt(strDir);
			check = Controls.placeCheck(this.x, y, ship, this.dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(this.x, this.y, ship, this.dir, masterpgrid);
		return ovCheck;
		
	}
	
	public boolean AILoop(boolean ovCheck, String[][] masteraigrid, Random rand, int ship){
		boolean check = false;
		while (check == false){
			this.x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			this.y = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(this.y);
		}
		check = false;
		while (check == false){
			this.dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(this.x, this.y, ship, this.dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(this.x, this.y, ship, this.dir, masteraigrid);
		return ovCheck;
	}

	public String[][] getGrid() {
		return grid;
	}

	public void setGrid(String[][] grid) {
		this.grid = grid;
	}
	
	
}
