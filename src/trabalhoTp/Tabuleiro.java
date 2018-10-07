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
	
	// btn[lin][col].getEstado()  tirado do if
	public void procuraPecaVertical(int lin,int col,Peca btn[][],Estado player) {
		
			 Estado oponente = player;
			//para inverter a cor para pintar os btn 
			
			 if(oponente == Estado.PRETO) {					
					oponente = Estado.BRANCO;
					
				}else {
					oponente=Estado.PRETO;			
					
			}
			 
			//comparacao com o parte de cima do tabuleiro
			for(int linha=lin-1;linha>=0;linha--) {
				if(btn[lin][col].getEstado() == btn[linha][col].getEstado() && (btn[linha][col].getEstado() != Estado.VAZIO)) {
					break;
					
				}else {
					if(btn[linha][col].getEstado() != Estado.VAZIO ) {
					System.out.println("positions find " + linha + " " + col);
					System.out.println(btn[linha][col].getEstado());
					System.out.println(linha + " " + col);
					System.out.println();
					//btn[linha][col].setEstado(oponente);
					}
				}
			}
			//comparacao com a parte de baixo do tabuleiro
			for(int linha=lin+1;linha<=7;linha++) {
				if(btn[lin][col].getEstado() == btn[linha][col].getEstado() && (btn[linha][col].getEstado() != Estado.VAZIO)) {
					break;
					
				}else {
					if(btn[linha][col].getEstado() != Estado.VAZIO ) {
					System.out.println("positions find " + linha + " " + col);
					System.out.println(btn[linha][col].getEstado());
					System.out.println(linha + " " + col);
					System.out.println();
					//btn[linha][col].setEstado(oponente);
					}
				}
			}
		}
	
	
	
	
		
	}


