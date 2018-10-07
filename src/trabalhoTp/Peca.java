package trabalhoTp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Peca extends JButton{
	
	private static int tamanho = 64;
	private Estado estado;
	
	public Peca(){
		super();//construtor da classe base
		estado = Estado.VAZIO;// enum estado na posicao vazio
	}
	
	
	//metodos
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(tamanho,tamanho);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//não preenchemos botoes vazios;
		if(estado != Estado.VAZIO) {
			if(estado == Estado.BRANCO)
				g2d.setColor(Color.WHITE);
			else if(estado == Estado.PRETO)
				g2d.setColor(Color.BLACK);
			g2d.fillOval(6,6,getWidth()-12,getHeight()-12);
		}
		//pintamnos a borda da peça independente do estado;
		g2d.setColor(Color.GRAY);
		g2d.drawOval(6,6,getWidth()-12,getHeight()-12);
		
	}
	//get e set
	public void setEstado(Estado e) {
		this.estado = e;
	}
	public Estado getEstado() {
		return this.estado;
	}
	
	
}
