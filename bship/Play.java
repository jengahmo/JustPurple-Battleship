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
			ovCheck = p1.loop(masterpgrid, ovCheck, input, 2, "Cruiser");
		}
		p1.Place(p1.getX(), p1.getY(), "c", 2, p1.getDir(), p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//sub
		while (ovCheck == false){
			ovCheck = p1.loop(masterpgrid, ovCheck, input, 3, "Sub");
		}
		p1.Place(p1.getX(), p1.getY(), "s", 3, p1.getDir(), p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		
		//destroyer
		while (ovCheck == false){
			ovCheck = p1.loop(masterpgrid, ovCheck, input, 3, "Destroyer");
		}
		p1.Place(p1.getX(), p1.getY(), "d", 3, p1.getDir(), p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//battleship
		while (ovCheck == false){
			ovCheck = p1.loop(masterpgrid, ovCheck, input, 4, "Battleship");
		}
		p1.Place(p1.getX(), p1.getY(), "b", 4, p1.getDir(), p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		
		//aircraft carrier
		while (ovCheck == false){
			ovCheck = p1.loop(masterpgrid, ovCheck, input, 5, "Aircraft Carrier");
		}
		p1.Place(p1.getX(), p1.getY(), "a", 5, p1.getDir(), p1, masterpgrid);
		Grid.showGrid(p1.getGrid());
		ovCheck = false;
		//AI setup
		//cruiser
		Random rand = new Random();
		while (ovCheck == false){
			ovCheck = ai.AILoop(ovCheck, masteraigrid, rand, 2);
		}
		ai.Place(ai.getX(), ai.getY(), "c", 2, ai.getDir(), ai, masteraigrid);
		ovCheck = false;
		
		//sub
		while (ovCheck == false){
			ovCheck = ai.AILoop(ovCheck, masteraigrid, rand, 3);
		}
		ai.Place(ai.getX(), ai.getY(), "s", 3, ai.getDir(), ai, masteraigrid);
		ovCheck = false;
		
		//destroyer
		while (ovCheck == false){
			ovCheck = ai.AILoop(ovCheck, masteraigrid, rand, 3);
		}
		ai.Place(ai.getX(), ai.getY(), "d", 3, ai.getDir(), ai, masteraigrid);
		ovCheck = false;
		
		//battleship
		while (ovCheck == false){
			ovCheck = ai.AILoop(ovCheck, masteraigrid, rand, 4);
		}
		ai.Place(ai.getX(), ai.getY(), "b", 4, ai.getDir(), ai, masteraigrid);
		ovCheck = false;
		
		//aircraft carrier
		while (ovCheck == false){
			ovCheck = ai.AILoop(ovCheck, masteraigrid, rand, 5);
		}
		ai.Place(ai.getX(), ai.getY(), "a", 5, ai.getDir(), ai, masteraigrid);
		
		
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
