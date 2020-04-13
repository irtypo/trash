/**
* Ping Pong Game 
* @Author Anthony Iorio
* @Version 0.1
* @Date 2020 03 12
**/
import java.util.*;
import java.io.*;

class Pong{

	static int LENGTH = 64;
	static int HEIGHT = 16;
	static String str = "";


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Paddle p1 = new Paddle(1);
		Paddle p2 = new Paddle(2);
		Ball ball = new Ball();
		Scoreboard scoreBoard = new Scoreboard(LENGTH);
		Field currentFrame = new Field(LENGTH, HEIGHT, p1, p2, ball);
		String input = "";
		Boolean play = true;
		String goal = "0";


	
		while(scoreBoard.getScore(1) < 8 && scoreBoard.getScore(2) < 8){
			play = true;


			while (play){
				try{

					TimerTask task = new TimerTask(){
						public void run(){
							if(str.equals("")){
								System.out.print("\tno input");
								str = "";
							}
						}
					};

					Timer timer = new Timer();
					timer.schedule(task, 2000);
					str = sc.nextLine();

					// System.out.println("input a string");
					// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					// str = in.readLine();
				
					timer.cancel();
					System.out.println("you input: " + str);

				} catch(Exception e){
					System.out.println(e);
				}

				input = str;
				switch(input){
					case "w":
						p1.moveUp();
						break;
					case "s":
						p1.moveDown();
						break;
					case "o":
						p2.moveUp();
						break;
					case "l":
						p2.moveDown();
						break;
					default:
						break;
				}
				

				switch(ball.goalCheck()){
					case 1:					// p1 scored
						scoreBoard.scoreUp(1);
						play = false;
						goal = "PLAYER 1";
						break;
					case 2:					// p2 scored
						scoreBoard.scoreUp(2);
						play = false;
						goal = "PLAYER 2";
						break;
					default:				// no goal
						break;
				}

				currentFrame.update(LENGTH, HEIGHT, p1, p2, ball);
			}
			ball.resetPos();
			System.out.println("\n\t------ G O A L ------\t------ " + goal + " ------");
			scoreBoard.drawBoard();
		}



	}






}