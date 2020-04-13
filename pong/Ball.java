class Ball{
	private int xPos = 0;
	private int yPos = 0;
	private int speed = 0;
	private int direction = 0;

	Ball(){
		this.xPos = 30;
		this.yPos = 6;
		this.speed = 1;
		this.direction = 1;
	}

	Ball(int x, int y, int s, int d){
		this.xPos = x;
		this.yPos = y;
		this.speed = s;
		this.direction = d;
	}	

	public int goalCheck(){
		if(this.xPos > 60)
			return 1;
		else if(this.xPos < 3)
			return 2;
		else
			return 0;
	}

	public int getX(){
		return this.xPos;
	}

	public int getY(){
		return this.yPos;
	}

	public int getDirection(){
		return this.direction;
	}

	public void resetPos(){
		this.xPos = 30;
		this.yPos = 6;
		this.speed = 1;
		this.direction = 1;
	}
	protected Ball moveBall(String collision){
		// Ball next = curr;

		if (collision.equals("Horizontal Collision")){
			switch (this.direction) {
				case 1:						// from 1 to 7
					this.xPos -= speed;
					this.yPos -= speed;
					this.direction = 7;
					break;
				case 2:						// from 2 to 8		
					this.yPos -= speed;	
					this.direction = 8;
					break;
				case 3:						// from 3 to 9
					this.xPos += speed;
					this.yPos -= speed;
					this.direction = 9;
					break;
				// case 4:						// from 4 to 6
					// this.xPos += speed;
					// break;
				// case 6:						// from 6 to 4
					// this.xPos -= speed;
					// break;
				case 7:						// from 7 to 1
					this.xPos -= speed;
					this.yPos += speed;
					this.direction = 1;
					break;
				case 8:						// from 8 to 2
					this.yPos += speed;
					this.direction = 2;
					break;
				case 9:						// from 9 to 3
					this.xPos += speed;
					this.yPos += speed;
					this.direction = 3;
				default:
					break;
			}
		}else if (collision.equals("Vertical Collision")){
			switch (this.direction) {
				case 1:						// from 1 to 3
					this.xPos += speed;
					this.yPos += speed;
					this.direction = 3;
					break;
				// case 2:						// from 2 to 3		
				// 	this.yPos -= speed;	
				// 	break;
				case 3:						// from 3 to 1
					this.xPos -= speed;
					this.yPos += speed;
					this.direction = 1;
					break;
				case 4:						// from 4 to 6
					this.xPos += speed;
					this.direction = 6;
					break;
				case 6:						// from 6 to 4
					this.xPos -= speed;
					this.direction = 4;
					break;
				case 7:						// from 7 to 1
					this.xPos -= speed;
					this.yPos += speed;
					this.direction = 1;
					break;
				// case 8:						// from 8 to 2
				// 	this.yPos += speed;
				// 	break;
				case 9:						// from 9 to 7
					this.xPos -= speed;
					this.yPos -= speed;
					this.direction = 7;
				default:
					break;
			}
		}else{
			switch (this.direction) {
				case 1:
					this.xPos -= speed;
					this.yPos += speed;
					break;
				case 2:
					this.yPos += speed;
					break;
				case 3:
					this.xPos += speed;
					this.yPos += speed;
					break;
				case 4:
					this.xPos -= speed;
					break;
				case 6:
					this.xPos += speed;
					break;
				case 7:
					this.xPos -= speed;
					this.yPos -= speed;
					break;
				case 8:
					this.yPos -= speed;
					break;
				case 9:
					this.xPos += speed;
					this.yPos -= speed;
				default:
					break;
			}
		}
			return this;
	}


}