package it.ifoa.modena.psspianeti;


import android.os.Parcel;
import android.os.Parcelable;


/**
 * Oggetto che mi rappresenta i dati di una persona, un contatto.
 * @author Sawzar
 *
 */
public class Compari implements Parcelable {
	/*Costante di classe (cio� statica che mi rappresenta la imageView di default 
	 * nel caso non venga specificata un'immagine diversa tramite un id nel costruttore*/
	private static final int IMG=R.drawable.unknown_m;
	
	//variabili di istanza
	private String nome,cognome,mail,telefono;
	private int risorsa;
	
	
	/**
	 * Costruttore vuoto: richiama il secondo costruttore dandogli l'id della 
	 * imageView di default (cio� personaggio ignoto..)
	 */
	Compari(){
		this(Compari.IMG);
	}
	
	/**
	 * Costruttore con solo id dell'immagine: ritorna mario balotelli con
	 * la foto prescelta 
	 * @param id
	 */
	Compari(int id){
		this("Mario","Balotelli","Mario.Balo@forzaMilan.it","1234567890",id);
	}
	
	/**
	 * Costruttore generico: istanzia una persona , ma l'immagine � quella
	 * di default (Compari.IMG)
	 * @param nome
	 * @param cognome
	 * @param mail
	 * @param telefono
	 */
	Compari(String nome,String cognome, String mail,String telefono){
		this(nome,cognome,mail,telefono,Compari.IMG);
	}
	
	/**
	 * Costruttore pi� generale: viene specificato ogni singolo parametro
	 * del contatto
	 * @param nome
	 * @param cognome
	 * @param mail
	 * @param telefono
	 * @param id
	 */
	Compari(String nome,String cognome, String mail,String telefono,int id){
		this.nome=nome;
		this.cognome=cognome;
		this.mail=mail;
		this.telefono=telefono;
		this.risorsa=id;
	}

	
	/*
	 * Metodi getter e setter per gli attributi della classe
	 */
	
	
	
	public int getRisorsa() {
		return risorsa;
	}

	public void setRisorsa(int risorsa) {
		this.risorsa = risorsa;
	}

	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getMail() {
		return mail;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flag) {
		// TODO Auto-generated method stub
		out.writeString(nome);
		out.writeString(cognome);
		out.writeString(mail);
		out.writeString(telefono);
		out.writeInt(risorsa);
		
	}
	
	public static final Parcelable.Creator<Compari> CREATOR = new Parcelable.Creator<Compari>() {
		public Compari createFromParcel(Parcel in) {
			return new Compari(in);
		}

		public Compari[] newArray(int size) {
			return new Compari[size];
		}
	};

	private Compari(Parcel in) {
		// leggo gli attributi
		nome = in.readString();
		cognome=in.readString();
		mail=in.readString();
		telefono=in.readString();
		risorsa = in.readInt();
	}

}
