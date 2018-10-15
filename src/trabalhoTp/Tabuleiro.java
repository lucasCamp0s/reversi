package trabalhoTp;





/*Desenvolva uma classe de nome tabuleiro que conterá as regras do jogo, o controle de término do
jogo, quem venceu ou se o Jogo terminou sem vencedor.
 * É preciso que o tabuleiro permita a realização de uma jogada em uma posição indicada. Esta jogada
deve roubar peças do jogador adversário a partir da quinta jogada.
 *As quatro primeiras jogadas devem ser feitas nas 4 peças centrais.
 * É interessante que o tabuleiro controle qual jogador deve realizar a próxima jogada
 *É interessante que o tabuleiro controle a quantidade de jogadas que já foram realizadas.
 * */
public class Tabuleiro {
	
	private boolean tipoRetorno=false;
	// btn[lin][col].getEstado()  tirado do if
	public boolean procuraPecaVertical(int lin,int col,Peca btn[][],Estado player) {

		Estado oponente = player;
		//para inverter a cor para pintar os btn 
		
		
		tipoRetorno = false;
		for(int desce = 0; desce <=6;desce++) {
			if(lin == 7) {
				if(btn[lin][col].getEstado() == oponente || btn[lin][col].getEstado() == Estado.VAZIO)
					break;
			}
			if(btn[lin+1][col].getEstado() == oponente || btn[lin+1][col].getEstado() == Estado.VAZIO)
				break;
			if(btn[desce][col].getEstado() != Estado.VAZIO) {
				//btn[desce][col].setEstado(oponente);
			//System.out.println(btn[desce][col].getName());
			tipoRetorno = true;
			}
		
		}
		for(int sobe=6;sobe>=1;sobe--) {
			if(lin==0)
				lin=1;
			if(btn[lin-1][col].getEstado() == oponente || btn[lin-1][col].getEstado() == Estado.VAZIO)
				break;
			if(btn[sobe][col].getEstado() != Estado.VAZIO) {
				//System.out.println(btn[sobe][col].getName());
				//btn[sobe][col].setEstado(oponente);
				tipoRetorno = true;
			}
		}
		
		return tipoRetorno;

	}

	public boolean procuraPecaHorizonatal(int lin,int col,Peca btn[][],Estado player) {

		Estado oponente = player;
		//para inverter a cor para pintar os btn 
		
		
		tipoRetorno = false;
		for(int esquerda=0;esquerda <=6;esquerda++) {
			if(col==7)
				if(btn[lin][col].getEstado() == oponente || btn[lin][col].getEstado() == Estado.VAZIO)
					break;
			if(btn[lin][col+1].getEstado() == Estado.VAZIO || btn[lin][col+1].getEstado() == oponente)
				break;
			else {
				if(btn[lin][esquerda].getEstado() != Estado.VAZIO) {
				System.out.println(btn[lin][esquerda].getName());
				//btn[lin][esquerda].setEstado(oponente);
			tipoRetorno = true;
				}
			}
		}
		
		for(int direita=6;direita>=1;direita--){
			if(col==0) {
				if(btn[lin][col+1].getEstado() == oponente || btn[lin][col+1].getEstado() == Estado.VAZIO)
					break;
				else {
					col=1;
				}
			}
			if(btn[lin][col-1].getEstado() == Estado.VAZIO || btn[lin][col-1].getEstado() == oponente)  {
				break;
			}else {
				if(btn[lin][direita].getEstado() != Estado.VAZIO) {
				System.out.println(btn[lin][direita].getName());
				//btn[lin][direita].setEstado(oponente);
				tipoRetorno = true;
				}
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


