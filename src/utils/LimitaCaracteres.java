package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitaCaracteres extends PlainDocument{

	
	public enum TipoEntrada {
		NUMEROINTEIRO, NUMERODECIMAL, HORARIO
	};
	
	private TipoEntrada tpEntrada;
	private int qtCaracteres;
	
	public LimitaCaracteres(int qtCaracteres, TipoEntrada tpEntrada) {
		super();
		this.qtCaracteres = qtCaracteres;
		this.tpEntrada = tpEntrada;
	}

	@Override
	public void insertString(int offs, String string, AttributeSet a) throws BadLocationException {
		if(string == null || getLength() == qtCaracteres) {
			return;
		}
		
		int totalCarac = getLength() + string.length();
		
		
		//filtro caracteres
		String regex = "";
		switch(tpEntrada) {
			case NUMEROINTEIRO:
				regex = "[^0-9]";
				break;
			
			case NUMERODECIMAL:
				regex = "[^0-9,.]";
				break;
				
			case HORARIO: 
				regex = "[^0-9]";
				break;
		}
		
		//substituindo
		string = string.replaceAll(regex, "");
		if(totalCarac <= qtCaracteres) {
			super.insertString(offs, string, a);		
		}else {
			String nova = string.substring(0, qtCaracteres);
			super.insertString(offs, nova, a);	
		}
		
	}
	
	
	
}
