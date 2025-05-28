import java.util.HashMap;
import java.util.Vector;

public abstract class Pokemon {
	protected int id;
    protected String nome;
	protected String tipo;
	protected int salute;
	protected int livello;
	protected boolean ko;
	protected HashMap<String, Attacco> mappaAttacchi = new HashMap<>();
	protected Vector<Attacco> listaAttacchi = new Vector<Attacco>();

	//Costruttore
	public Pokemon(int id, String nome, String tipo, int salute,int livello){
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.salute = salute;
		this.livello = livello;
		this.ko = false;
	}

	public void aggiungiAttacco(Attacco a) {
    	mappaAttacchi.put(a.getNome(), a);
	}

	//Metodo attacca
	/*
	* Il metodo attacca infligge danno ad un Pokemon
	* @param String attacco
	* @param Pokemon p
	*/
	public void attacca(String attacco,Pokemon p){
		if (mappaAttacchi.containsKey(attacco)) {
			p.setSalute(p.getSalute() - mappaAttacchi.get(attacco).getDanno());
			if(p.getSalute() <= 0){
				p.setKO();
			}
		}
		else{
			System.out.println(nome + " non conosce questa mossa!");
		}
	}

	public void aumentaLivello(int c);

	//Metodi Getter
	public int getID(){
		return id;
	}
	public String getNome(){
		return nome;
	}
	public String getTipo(){
		return tipo;
	}
	public int getSalute(){
		return salute;
	}

	public boolean isKO(){
		return ko;
	}

	//Metodi Setter
	public void setSalute(int salute){
		this.salute = salute;
	}

	public void setKO(){
		ko = true;
		System.out.println(nome + " è andato KO!");
	}
    @Override
	public String toString(){
		return "ID = " + id +
				"\nNome = " + nome  +
				"\nTipo = " + tipo +
			   "\nSalute = " + salute +
			   "\nLivello = " + livello +
			   "\nKO = " + ko +
			   "\nAttacchi disponibili: " + mappaAttacchi.keySet();
}