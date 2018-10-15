package trabalhoTp;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Reversi extends JFrame implements ActionListener {
	
	
	private Peca[][] botoes;
	private Estado player= Estado.PRETO; 
	
	public Reversi() {
		super("Reversi 1.2");
		
		getContentPane().setLayout(new GridLayout(8,8));//cria formato do layout
		
		botoes = new Peca[8][8];
		
		for(int lin=0;lin<botoes.length;lin++) {
			for(int col=0;col<botoes.length;col++) {
				
				botoes[lin][col] = new Peca();
				botoes[lin][col].setName("btn"+(lin)+(col));
				botoes[lin][col].setEstado(Estado.VAZIO);
				getContentPane().add(botoes[lin][col]);
				botoes[lin][col].addActionListener(this);
			}
			
		}
		botoes[3][3].setEstado(Estado.BRANCO);
		botoes[3][3].removeActionListener(this);
		
	    botoes[3][4].setEstado(Estado.PRETO);
	    botoes[3][4].removeActionListener(this);
	    
        botoes[4][3].setEstado(Estado.PRETO);
        botoes[4][3].removeActionListener(this);
        
        botoes[4][4].setEstado(Estado.BRANCO);
        botoes[4][4].removeActionListener(this);
		pack();
		setLocation((getWidth()+896)/2,(getHeight()/2));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		Peca btn = (Peca) e.getSource();
		//get position the button
		int linha = Integer.parseInt(btn.getName().substring(3, 4));
		int coluna = Integer.parseInt(btn.getName().substring(4, 5));
		
		
		Tabuleiro regras = new Tabuleiro();
		
		
		if(/*regras.procuraPecaVertical(linha, coluna, botoes,player)==true || regras.procuraPecaHorizonatal( linha, coluna,botoes,player)==true*/regras.procuraPecaDiagonal(linha, coluna,botoes,player)) {
		if(player == Estado.PRETO) {
			btn.setEstado(Estado.PRETO);
			player = Estado.BRANCO;
			btn.removeActionListener(this);
			getContentPane().repaint();
		}else {
			btn.setEstado(Estado.BRANCO);
			player=Estado.PRETO;			
			btn.removeActionListener(this);
			getContentPane().repaint();
		}
	}
		
	}
	public static void main(String[] args) {
		new Reversi();

	}
}

