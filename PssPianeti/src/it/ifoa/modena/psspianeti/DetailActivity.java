package it.ifoa.modena.psspianeti;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.*;

public class DetailActivity extends Activity {

	ImageView immagine;
	TextView namelbl,surnamelbl,maillbl,phonelbl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		/*Istanzio i controlli di dettaglio (una immagine e quattro testi*/
		immagine=(ImageView)findViewById(R.id.detailImgView);
		namelbl=(TextView)findViewById(R.id.detailnameTV);
		surnamelbl=(TextView)findViewById(R.id.detailsurnameTV);
		maillbl=(TextView)findViewById(R.id.detailmailTV);
		phonelbl=(TextView)findViewById(R.id.detailphoneTV);
		/*recupero l'oggetto Compari passato nell'intent*/
		Intent i=getIntent();
		Compari c=(Compari) i.getParcelableExtra("persona");
		/*e setto i controlli*/
		//immagine.setImageResource(c.getRisorsa());
		namelbl.setText(c.getNome());
		surnamelbl.setText(c.getCognome());
		maillbl.setText(c.getMail());
		phonelbl.setText(c.getTelefono());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

}
