class Paddle{
	private int xPos = 0;
	private int yPos = 0;
	private int length = 5;
	private int FIELDHEIGHT = 16;

	
	Paddle(int port){
		if (port == 1){
			this.xPos = 4;
			this.yPos = 2;
		} else {
			this.xPos = 60;
			this.yPos = 6;
		}

	}


	public int getX(){
		return this.xPos;
	}

	public int getY(){
		return this.yPos;
	}

	public int getLength(){
		return this.length;
	}

	public void moveUp(){
		if(this.yPos != 0)
			this.yPos--;
	}

	public void moveDown(){
		if(this.yPos != FIELDHEIGHT-length)
			this.yPos++;
	}
	
}