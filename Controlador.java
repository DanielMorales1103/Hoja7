import java.util.ArrayList;

public class Controlador {
    Arbol Ingles = new Arbol();
	Arbol Frances = new Arbol();
	ArrayList<String> PalabrasIngles = new ArrayList<String>();
	ArrayList<String> PalabrasFrances = new ArrayList<String>();
	public void crear_arboles(ArrayList<String> palabras) {		
		String ingles_español;
		String frances_español;
		for (int i =0;i<palabras.size();i++){
			String[] fila = palabras.get(i).split(",");
			ingles_español = fila[0].toLowerCase().trim()+","+fila[1].toLowerCase().trim();
			frances_español = fila[2].toLowerCase().trim()+","+fila[1].toLowerCase().trim();
			PalabrasIngles.add(ingles_español);
			PalabrasFrances.add(frances_español);
		}		
		for (int i = 0;i<PalabrasIngles.size();i++) {
			Ingles.insertar(PalabrasIngles.get(i));
			Frances.insertar(PalabrasFrances.get(i));				
		}
	}
	public void InOrderIngles() {
		Ingles.inorden();
	}
	public void InOrderFrances() {
		Frances.inorden();
	}
	public void agregarpalabras(String[] palabras) {
		String ingles_español = palabras[0].toLowerCase().trim()+","+palabras[1].toLowerCase().trim();
		String frances_español = palabras[2].toLowerCase().trim()+","+palabras[1].toLowerCase().trim();
		Ingles.insertar(ingles_español);
		Frances.insertar(frances_español);
	}
	public String traducir(ArrayList<String> texto) {
		String texto_traducido="No entro";
		for (int i = 0;i<texto.size();i++) {
			String[] frase = texto.get(i).split(" ");
			//detectar idioma
			boolean Es_ingles = false;
			boolean Es_frances = false;
			for (int j = 0; j<frase.length;j++) {
				String palabra = frase[j].trim();
				if(Ingles.existe(palabra)) {
					Es_ingles = true;
				}else if (Frances.existe(palabra)) {
					Es_frances=true;
				}
			}
			//Fin de detectar idioma
			if(Es_ingles) {
				texto_traducido="Es ingles";
			}else if(Es_frances) {
				texto_traducido="Es frances";
			}else {
				texto_traducido="No es Ingles y tampoco Frances";
			}
			
		}
		return texto_traducido;
	}
}
