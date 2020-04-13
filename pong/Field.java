class Field {
	int LENGTH;
	int HEIGHT;
	Paddle P1;
	Paddle P2;
	Ball BALL;


	Field(int length, int height, Paddle paddle1, Paddle paddle2, Ball ball){
		this.LENGTH = length;
		this.HEIGHT = height;
		this.P1 = paddle1;
		this.P2 = paddle2;
		this.BALL = ball; 


		drawLine(LENGTH, HEIGHT, P1, P2, BALL);
	}


	private void drawLine(int length, int height, Paddle paddle1, Paddle paddle2, Ball ball){
		int count1 = 0;	
		int count2 = 0;	
		int countB = 0;	
		
		drawHorizBorder(length);
		for(int i = 0; i < height; i++){
			System.out.print("\n#");												// draw left goal
			for(int j = 1; j < (length - 1); j++){
				if(j == paddle1.getX() && i == (paddle1.getY() + count1)) {			// draw p1 paddle
					System.out.print("|");
					if(count1 < paddle1.getLength()-1)
						count1++;
				}else if(j == paddle2.getX() && i == (paddle2.getY() + count2)) {	// draw p2 paddle
					System.out.print("|");
					if(count2 < paddle2.getLength()-1)
						count2++;
				}else if((j == ball.getX() + countB) && i == ball.getY() ){			// draw ball
					// System.out.print(":");
					
					if(countB < 1){
						System.out.print("[");
						countB++;
					}else
						System.out.print("]");

				}else
					System.out.print("\u0000");										// draw blank space
			}
			System.out.print("#");													// draw right goal
		}
		System.out.println();
		drawHorizBorder(length);
	}	//-- end drawLine

	public void update(int length, int height, Paddle paddle1, Paddle paddle2, Ball ball){
		// drawLine(length, height, paddle1, paddle2, ball);
		
		drawLine(length, height, paddle1, paddle2, ball);
		if (collisionCheck().equals("Horizontal")){
			BALL.moveBall("Horizontal Collision");
			// System.out.println("H COLLISION: " + ball.getDirection());
		}
		else if (collisionCheck() == "Vertical"){
			BALL.moveBall("Vertical Collision");
			// System.out.println("V COLLISION: " + ball.getDirection());
		} else
			BALL.moveBall("");


		// System.out.println(BALL.getX());
	}



	public String collisionCheck(){
		if(BALL.getX() == 4){									// vertical left (p1)
			if (P1.getY() == BALL.getY()) 
				return "Vertical";
			else if ((P1.getY() + 1) == BALL.getY()) 
				return "Vertical";
			else if ((P1.getY() + 2) == BALL.getY()) 
				return "Vertical";
			else if ((P1.getY() + 3) == BALL.getY()) 
				return "Vertical";
			else if ((P1.getY() + 4) == BALL.getY()) 
				return "Vertical";
			else
				return "";
		
		}else if(BALL.getX() == 60){							// verttical right (p2)
			if (P2.getY() == BALL.getY()) 
				return "Vertical";
			else if ((P2.getY() + 1) == BALL.getY()) 
				return "Vertical";
			else if ((P2.getY() + 2) == BALL.getY()) 
				return "Vertical";
			else if ((P2.getY() + 3) == BALL.getY()) 
				return "Vertical";
			else if ((P2.getY() + 4) == BALL.getY()) 
				return "Vertical";
			else
				return "";
		
		}else if(BALL.getY() <= 0){								// horizonal top
			return "Horizontal";
		}else if(BALL.getY() > 14){							// horizontal bottom
			return "Horizontal";
		} else
			return "";
	}

	protected void drawHorizBorder(int length){
		int i = 0;
		while (i < length){
			System.out.print("*");
			i++;
		}
	}

}