class Scoreboard {
	int p1Score = 0;
	int p2Score = 0;
	int HEIGHT = 3;
	int LENGTH;

	Scoreboard(int length){
		LENGTH = length;
	
		drawBoard();
	}

	protected void drawBoard(){
		drawHorizBorder(LENGTH);
		drawScores(LENGTH);
		drawHorizBorder(LENGTH);
		System.out.println();
		// drawNumberLine(LENGTH);
	} 

	protected void drawHorizBorder(int length){
		int i = 0;
		while (i < length){
			System.out.print("*");
			i++;
		}
	}

	private void drawScores(int length){
		int i = 0;
		String p1 = "";
		String p2 = "";

	
		drawLine("Player 1", "", "Player 2", "");
		drawLine("", "", "", "");
		drawLine(p1.valueOf(p1Score), "", p2.valueOf(p2Score), "");
		drawLine("", "", "", "");
		System.out.println();
	}

	private void drawLine(String one, String two, String three, String four){
		System.out.printf("\n|%" + ((LENGTH - 2)/4) + "s", one);
		System.out.printf("%" + ((LENGTH - 2)/4) + "s", two);
		System.out.printf("%" + ((LENGTH - 2)/4) + "s", three);
		System.out.printf("%" + ((LENGTH - 2)/4) + "s\u0000\u0000|", four);
	}

	private void drawNumberLine(int length){
		System.out.println();
		for(int j=0; j < length; j++)
			System.out.print(j%10);
	}

	public void scoreUp(int port){
		if (port == 1)
			p1Score++;
		else
			p2Score++;
	}

	public int getScore(int port){
		if (port == 1)
			return p1Score;
		else
			return p2Score;
	}


}