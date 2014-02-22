package it.ifoa.modena.psspianeti;




import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Attività che gestisce la schermata con la lista di contatti. Inizializza un array
 * di contatti (cioè di oggetti Compari), istanzia l'Adapter customizzato per questi 
 * contatti (CompariAdapter) passandogli anche il layout del singolo item (row_list), 
 * e passa tale adapter alla nostra ListView. 
 */
public class ListActivity extends Activity {
	//La ListView: verrà istanziata nell'onCreate
	ListView listaCompari;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		/**
		 * Istanzio la listView 
		 */
		listaCompari =(ListView) findViewById(R.id.listView1);
		
		
		/**
		 * Creo una lista di compari
		 */
		ArrayList<Compari> compariList = new ArrayList<Compari>();
		
		/*e aggiungo alla lista dei compari creati sul momento: si noti che non 
		 * viene specificato un riferimento ad una foto. Ne verrà presa una di default
		 * (vedi implementazione di Compari, costante statica IMG)*/
		
		compariList.add(new Compari()); //Balotelli!
		compariList.add(new Compari("Stefano","Miari", "stemiari@libero.it", "3470364996"));
		compariList.add(new Compari("Paolo","Calanca", "calancapaolo@gmail.com", "3331441157"));
		compariList.add(new Compari("Sawzar","Rashid", "sosrique@gmail.com", "3897997336"));
		
		
		/**
		 * Istanzio l'adapter e lo  associo al contesto(cioè questa attività, this) 
		 * al layout di riga (row_list) ed alla lista di compari già riempita (comparilist)
		 */
		CompariAdapter adapter = new CompariAdapter(this, R.layout.row_list, compariList);
		
		/*L'adapter lo ficco dentro alla listView (listaCompari)*/
		listaCompari.setAdapter(adapter);
		
		/*ed associo un listener alla listView che risponda al click su un item*/
		listaCompari.setOnItemClickListener(new OnItemClickListener() {

			@Override
			/**
			 * C'è stato un click su un item?
			 */
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				/*recupero il compare cliccato*/
				Compari p = (Compari) parent.getItemAtPosition(position);
				
				/*ora si potrebbe richiamare un'altra activity per la visualizzazione 
				 * delle informazioni di dettaglio */
				
				/*
				Intent i = new Intent(ListActivity.this, Compari.class);
				i.putExtra("name", p.getName());
				i.putExtra("imageID", p.getImageResource());
				startActivity(i);
		*/
		
		
	}});}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
