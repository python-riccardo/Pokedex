public class Opzione{
	private String inserimento;
	private String descrizione;
	
	public Opzione(String inserimento, String descrizione){
		this.inserimento = inserimento;
		this.descrizione = descrizione;
	}
	public String getDescrizione(){
		return descrizione;
	}
	public String getInserimento(){
		return inserimento;
	}
}