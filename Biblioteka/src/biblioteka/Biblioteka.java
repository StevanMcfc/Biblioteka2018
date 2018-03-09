package biblioteka;

import java.util.LinkedList;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {

	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		
	if (knjiga == null && knjige.contains(knjiga)) throw new RuntimeException("Knjiga vec postoji");	
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
	if (knjiga == null && !knjige.contains(knjiga)) throw new RuntimeException("Knjiga ne postoji");	
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(String naslov, Autor autor, String isbn, String izdavac) {
		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		
		if(naslov==null) throw new RuntimeException("Morate uneti naslov");
		
		for(int i = 0; i<knjige.size() ; i++) {
			if(knjige.get(i).getNaslov().contains(naslov))
				novaLista.add(knjige.get(i));
		}
		
		return novaLista;
	}

}