package trabalhoTp;





/*Desenvolva uma classe de nome tabuleiro que conter� as regras do jogo, o controle de t�rmino do
jogo, quem venceu ou se o Jogo terminou sem vencedor.
 * � preciso que o tabuleiro permita a realiza��o de uma jogada em uma posi��o indicada. Esta jogada
deve roubar pe�as do jogador advers�rio a partir da quinta jogada.
 *As quatro primeiras jogadas devem ser feitas nas 4 pe�as centrais.
 * � interessante que o tabuleiro controle qual jogador deve realizar a pr�xima jogada
 *� interessante que o tabuleiro controle a quantidade de jogadas que j� foram realizadas.
 * */
public class Tabuleiro {
	
	private boolean tipoRetorno=false;
	// btn[lin][col].getEstado()  tirado do if
	public boolean procuraPecaVertical(int lin,int col,Peca btn[][],Estado player) {

		Estado oponente = player;
		//para inverter a cor para pintar os btn 
		
		
		tipoRetorno = false;
	
	
		for (int c = lin; c < btn.length-1; c++) {
			if(btn[lin+1][col].getEstado() == oponente || btn[lin+1][col].getEstado() == Estado.VAZIO )
				break;
			if(btn[lin+1][col].getEstado() != oponente)
				tipoRetorno = true;
			if(oponente == btn[c][col].getEstado())  {
				
				System.out.println("Achei");
				System.out.println(btn[c][col].getEstado()+"\n" + btn[c][col].getName());
				for (int j = c; j > lin; j--) {
					btn[j][col].setEstado(oponente);
				}
				tipoRetorno = true;
				break;
			}
		}
		//para conferir descendo programa
		for (int d = lin; d >0; d--) {
			if(btn[lin-1][col].getEstado() == oponente || btn[lin-1][col].getEstado() == Estado.VAZIO )
				break;
			if(btn[lin-1][col].getEstado() != oponente)
				tipoRetorno = true;
			if(oponente == btn[d][col].getEstado()) {
				
				System.out.println("Achei");
				System.out.println(btn[d][col].getEstado()+"\n" + btn[d][col].getName());
				for (int j1 = d; j1 < lin; j1++) {
					btn[j1][col].setEstado(oponente);
				}
				tipoRetorno = true;
				break;
			}
		}
		
		return tipoRetorno;

	}

	public boolean procuraPecaHorizonatal(int lin,int col,Peca btn[][],Estado player) {

		Estado oponente =player;
		//para inverter a cor para pintar os btn 
		tipoRetorno = false;
		for(int coluna = col;coluna < btn.length-1;coluna++) {
			if(btn[lin][col+1].getEstado() == Estado.VAZIO || btn[lin][col+1].getEstado() == oponente)
				break;
			if(btn[lin][col+1].getEstado() != oponente)
				tipoRetorno = true;
			if(oponente == btn[lin][coluna].getEstado()) {
				System.out.println("Achei");
				//System.out.println(lin  + "" + coluna);
				for(int j2 = coluna;j2>col;j2--) {
					System.out.println(btn[lin][j2].getName() + " voltando");
					btn[lin][j2].setEstado(oponente);
				}
				
				tipoRetorno = true;
				break;
			}
		}
		// fazendo a parte de voltar
		for(int coluna = col;coluna >0 ;coluna--) {
			if(btn[lin][col-1].getEstado() == Estado.VAZIO || btn[lin][col-1].getEstado() == oponente)
				break;
			if(btn[lin][col-1].getEstado() != oponente)
				tipoRetorno = true;
			if(oponente == btn[lin][coluna].getEstado()) {
				System.out.println("Achei");
				//System.out.println(lin  + "" + coluna);
				for(int j2 = coluna;j2<col;j2++) {
					System.out.println(btn[lin][j2].getName() + " voltando");
					btn[lin][j2].setEstado(oponente);
				
				}
			
				tipoRetorno = true;
				break;
				
			}
		
		}
		
		
		
		
		return tipoRetorno;

	}

	public boolean procuraPecaDiagonal(int lin,int col,Peca btn[][],Estado player) {
		
		tipoRetorno = false;
		
		
		
		int coluna=col;
		for(int diagonal = lin;coluna <= 7 || lin<=6;diagonal++,lin++,col++) {
			
			System.out.println(btn[lin][coluna].getName());
			coluna++;
			
			tipoRetorno=true;
		}
		
		
		return tipoRetorno;
	}




}


