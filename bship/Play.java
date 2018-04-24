package bship;

import java.util.Random;
import java.util.Scanner;

public class Play {
	public static void main(String[] args){
		Player p1 = new Player();
		Player ai = new Player();
		String[][] masterpgrid = new String[12][];
		String[][] masteraigrid= new String[12][];
		Grid.PopulateGrid(masterpgrid);
		Grid.PopulateGrid(masteraigrid);
		String[][] viewergrid = new String[12][];
		Grid.PopulateGrid(viewergrid);
		System.out.println("Welcome to miniBattleShip.");
		Scanner input = new Scanner(System.in);
		String xstr = "";
		int x = 0;
		int yint = 0;
		String y = "";
		int dir = 0;
		boolean check = false;
		boolean ovCheck = false;
		
		//player1 setup
		Grid.showGrid(p1.getGrid());
		System.out.println(p1.getCounter());
		//cruiser
		while (ovCheck == false){
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your Cruiser: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your Cruiser: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		yint = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your Cruiser "
				+ "(0 = up, 1 = right, 2 = down, 3 = left): ");
			dir = input.nextInt();
			check = Controls.placeCheck(x, y, 2, dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(x, yint, 2, dir, masterpgrid);
		}
		p1.Place(x, yint, "c", 2, dir, p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//sub
		while (ovCheck == false){
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your Sub: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your Sub: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		yint = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your Sub "
				+ "(0 = up, 1 = right, 2 = down, 3 = left): ");
			dir = input.nextInt();
			check = Controls.placeCheck(x, y, 3, dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(x, yint, 3, dir, masterpgrid);
		}
		p1.Place(x, yint, "s", 3, dir, p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		
		//destroyer
		while (ovCheck == false){
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your Destroyer: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your Destroyer: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		yint = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your Destroyer "
				+ "(0 = up, 1 = right, 2 = down, 3 = left): ");
			dir = input.nextInt();
			check = Controls.placeCheck(x, y, 3, dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(x, yint, 3, dir, masterpgrid);
		}
		p1.Place(x, yint, "d", 3, dir, p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//battleship
		while (ovCheck == false){
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your Battleship: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your Battleship: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		yint = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your Battleship "
				+ "(0 = up, 1 = right, 2 = down, 3 = left): ");
			dir = input.nextInt();
			check = Controls.placeCheck(x, y, 4, dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(x, yint, 4, dir, masterpgrid);
		}
		
		p1.Place(x, yint, "b", 4, dir, p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		
		//aircraft carrier
		while (ovCheck == false){
		while (check == false){
			System.out.println("Player 1, enter the x coordinate of your Aircraft Carrier: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
		x = Controls.xToInt(xstr);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the y coordinate of your Aircraft Carrier: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
		}
		yint = Controls.stringToInt(y);
		check = false;
		while (check == false){
			System.out.println("Player 1, enter the direction of your Aircraft Carrier "
				+ "(0 = up, 1 = right, 2 = down, 3 = left): ");
			dir = input.nextInt();
			check = Controls.placeCheck(x, y, 5, dir);
		}
		check = false;
		ovCheck = Controls.overlapCheck(x, yint, 5, dir, masterpgrid);
		}
		p1.Place(x, yint, "a", 5, dir, p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//AI setup
		//cruiser
		Random rand = new Random();
		while (ovCheck == false){
		while (check == false){
			x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			yint = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(yint);
		}
		check = false;
		while (check == false){
			dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(x, yint, 2, dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(x, yint, 2, dir, masteraigrid);
		}
		ai.Place(x, yint, "c", 2, dir, ai, masteraigrid);
		ovCheck = false;
		
		//sub
		while (ovCheck == false){
		while (check == false){
			x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			yint = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(yint);
		}
		check = false;
		while (check == false){
			dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(x, yint, 3, dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(x, yint, 3, dir, masteraigrid);
		}
		ovCheck = false;
		ai.Place(x, yint, "s", 3, dir, ai, masteraigrid);
		
		//destroyer
		while (ovCheck == false){
		while (check == false){
			x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			yint = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(yint);
		}
		check = false;
		while (check == false){
			dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(x, yint, 3, dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(x, yint, 3, dir, masteraigrid);
		}
		ovCheck = false;
		ai.Place(x, yint, "d", 3, dir, ai, masteraigrid);
		
		
		//battleship
		while (ovCheck == false){
		while (check == false){
			x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			yint = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(yint);
		}
		check = false;
		while (check == false){
			dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(x, yint, 4, dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(x, yint, 4, dir, masteraigrid);
		}
		ovCheck = false;
		ai.Place(x, yint, "b", 4, dir, ai, masteraigrid);
		
		//aircraft carrier
		while (ovCheck == false){
		while (check == false){
			x = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(x);
		}
		check = false;
		while (check == false){
			yint = rand.nextInt(9) + 1;
			check = Controls.AIcoordCheck(yint);
		}
		check = false;
		while (check == false){
			dir = rand.nextInt(3);
			check = Controls.AIplaceCheck(x, yint, 5, dir);
		}
		check = false;
		ovCheck = Controls.AIoverlapCheck(x, yint, 5, dir, masteraigrid);
		}
		ai.Place(x, yint, "a", 5, dir, ai, masteraigrid);
		
		while (p1.getCounter() != 0 && ai.getCounter() != 0){
			System.out.println("Enemy Radar");
			Grid.showGrid(viewergrid);
			System.out.println("Your Radar");
			Grid.showGrid(p1.getGrid());
			System.out.println("Your ship spaces left " + p1.getCounter());
			System.out.println("Enemy ship spaces left " + ai.getCounter());
			
			check = false;
			while (check == false){
			System.out.println("Player , enter target x coordinate: ");
			xstr = input.next();
			check = Controls.XcoordCheck(xstr);
		}
			x = Controls.xToInt(xstr);
			check = false;
			while (check == false){
			System.out.println("Player, enter target y coordinate: ");
			y = input.next();
			check = Controls.YcoordCheck(y);
			}
			yint = Controls.stringToInt(y);
			p1.Shoot(x, yint, masteraigrid, viewergrid, ai);
			check = false;
			while (check == false){
				x = rand.nextInt(9) + 1;
				check = Controls.AIcoordCheck(x);
			}
			
			check = false;
			while (check == false){
				yint = rand.nextInt(9) + 1;
				check = Controls.AIcoordCheck(yint);
			}
			ai.Shoot(x, yint, masterpgrid, p1);
			
		}
		if (p1.getCounter() == 0){
			System.out.println("You lose");
		}
		else System.out.println("You win");
	}
}
