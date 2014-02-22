package it.ifoa.modena.psspianeti;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CompariAdapter extends ArrayAdapter<Compari> {

	public CompariAdapter(Context context, int resource, List<Compari> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		/* L'inflater serve a recuperare un layout definito nell'xml: è come
		 * creare un oggetto View a partire da un layuot che abbiamo costruito
		 * noi, non uno standard già fatto
		*/
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.row_list, null);
		
		/* recupero le view (quasi) come al solito: Infatti il metodo findViewById è quello
		 * dell'oggetto convertView (di generica classe View, ma che rappresenta il nostro
		 * layout di riga) che contiene le textView e imageView che vogliamo. Vanno solo
		 * 'oggettivizzate'
		*/
		TextView nameTextView = (TextView) convertView.findViewById(R.id.nametext);
		TextView contactTextView = (TextView) convertView.findViewById(R.id.contactText);
		ImageView contactImageView = (ImageView) convertView.findViewById(R.id.imageView1);
		
		
		/* recupero l'oggetto Compari in questione, in base alla sua posizione in lista*/
		Compari p = getItem(position);
		
		/*setto opportunamente l'immagine (la ImageView) e i campi (le due textView)
		 * di una riga con le informazioni contenute nell'oggetto p di classe Compari*/
		nameTextView.setText(p.getNome()+" "+p.getCognome());
		contactTextView.setText("Mail: "+p.getMail()+" e telefono: "+p.getTelefono());
		contactImageView.setImageResource(p.getRisorsa());
		
		return convertView;
	}

}

