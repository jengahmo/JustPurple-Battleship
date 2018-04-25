package bship;

public class Controls {
	public static int stringToInt(String str){
		int y = 0;
		str = str.toUpperCase();
		switch (str){
		case "A": y = 1;
		break;
		case "B": y = 2;
		break;
		case "C": y = 3;
		break;
		case "D": y = 4;
		break;
		case "E": y = 5;
		break;
		case "F": y = 6;
		break;
		case "G": y = 7;
		break;
		case "H": y = 8;
		break;
		case "I": y = 9;
		break;
		case "J": y = 10;
		break;
		default : 
			System.out.println("Error, invalid entry, try again");
		}
		return y;
	}
	
	public static int dirToInt(String str){
		int dir = 0;
		str = str.toUpperCase();
		switch (str){
		case "0": dir = 0;
		break;
		case "U": dir = 0;
		break;
		case "1": dir = 1;
		break;
		case "R": dir = 1;
		break;
		case "2": dir = 2;
		break;
		case "D": dir = 2;
		break;
		case "3": dir = 3;
		break;
		case "L": dir = 3;
		break;
		
		default : 
			System.out.println("Error, invalid entry, try again");
		}
		return dir;
	}
	
	public static int xToInt(String xstr){
		int y = 0;
		switch (xstr){
		case "1": y = 1;
		break;
		case "2": y = 2;
		break;
		case "3": y = 3;
		break;
		case "4": y = 4;
		break;
		case "5": y = 5;
		break;
		case "6": y = 6;
		break;
		case "7": y = 7;
		break;
		case "8": y = 8;
		break;
		case "9": y = 9;
		break;
		case "10": y = 10;
		break;
		default : 
			System.out.println("Error, invalid entry, try again");
		}
		return y;
	}
	
	
	public static boolean AIcoordCheck(int coord){
		if (coord < 1 || coord > 10){
			return false;
		}
		else return true;
		
	}
	public static boolean YcoordCheck(String coord){
		int y = stringToInt(coord);
		if (y == 0){
			return false;
		}
		else return true;
		
	}
	public static boolean XcoordCheck(String coord){
		int x = xToInt(coord);
		if (x == 0){
			return false;
		}
		else return true;
		
	}
	
	public static boolean overlapCheck(int x, int y, int slen, int dir, String[][] grid){
		y = y+1;
		x = x+1;
		int check = 0;
		if (dir == 0){
			for (int i = 0; i < slen; i++){
				if (grid[y-i][x] != "."){
					check++;
				}
				
			}
			if (check != 0){
				System.out.println("Error, overlap occuring, starting piece placement over");
				return false;
			}
			else return true;
		}
		if (dir == 1){
			for (int i = 0; i < slen; i++){
				if (grid[y][x+i] != "."){
					check++;
				}
				
			}
			if (check != 0){
				System.out.println("Error, overlap occuring, starting piece placement over");
				return false;
			}
			else return true;
		}
		if (dir == 2){
			for (int i = 0; i < slen; i++){
				if (grid[y+i][x] != "."){
					check++;
				}
			}
			if (check != 0){
				System.out.println("Error, overlap occuring, starting piece placement over");
				return false;
			}
			else return true;
		}
		if (dir == 3){
			for (int i = 0; i < slen; i++){
				if (grid[y][x-i] != "."){
					check++;
				}
			}
			if (check != 0){
				System.out.println("Error, overlap occuring, starting piece placement over");
				return false;
			}
			else return true;
		}
		System.out.println("Error, overlap occuring, starting piece placement over");
		return false;
	}
	
	
	public static boolean AIoverlapCheck(int x, int y, int slen, int dir, String[][] grid){
		y = y+1;
		x = x+1;
		int check = 0;
		if (dir == 0){
			for (int i = 0; i < slen; i++){
				if (grid[y-i][x] != "."){
					check++;
				}
			}
			if (check != 0){
				return false;
			}
			else return true;
		}
		if (dir == 1){
			for (int i = 0; i < slen; i++){
				if (grid[y][x+i] != "."){
					check++;
				}	
			}
			if (check != 0){
				return false;
			}
			else return true;
		}
		if (dir == 2){
			for (int i = 0; i < slen; i++){
				if (grid[y+i][x] != "."){
					check++;
				}
			}
			if (check != 0){
				return false;
			}
			else return true;
		}
		if (dir == 3){
			for (int i = 0; i < slen; i++){
				if (grid[y][x-i] != "."){
					check++;
				}
			}
			if (check != 0){
				return false;
			}
			else return true;
		}
		return false;
	}
	public static boolean placeCheck(int x, String y, int slen, int dir){
		int yin = stringToInt(y);
		x = x+1;
		if (dir == 0 && yin <= (slen)){
			System.out.println("Error, entry out of bounds, try again");
			return false;
		}
		if (dir == 1 && x >= (11 - slen)){
			System.out.println("Error, entry out of bounds, try again");
			return false;
		}
		if (dir == 2 && yin >= (11-slen)){
			System.out.println("Error, entry out of bounds, try again");
			return false;
		}
		if (dir == 3 && x <= (slen)){
			System.out.println("Error, entry out of bounds, try again");
			return false;
		}
		else return true;
		
	}
	public static boolean AIplaceCheck(int x, int y, int slen, int dir){
		y = y+1;
		x = x+1;
		if (dir == 0 && y <= (slen)){
			return false;
		}
		if (dir == 1 && x >= (11 - slen)){
			return false;
		}
		if (dir == 2 && y >= (11-slen)){
			return false;
		}
		if (dir == 3 && x <= (slen)){
			return false;
		}
		else return true;
		
	}
	
	
	
	
}
