import java.io.File;
import java.util.*;
import java.io.FileWriter;

	
public class Principal {
	File archivo;
	FileWriter fw;
	static Scanner sw;
	public static void main(String[] args) {
		try {
			Scanner sr = new Scanner(System.in);
			System.out.println("Ingrese la ruta del archivo (incluya el nombre y la extención)");
			//String ruta = sr.nextLine();
			String ruta = "C:\\Users\\pc\\Documents\\uvg\\sem3\\algoritmos\\eclipse\\Hoja7\\diccionario.txt";
			File archivo = new File(ruta);
			ArrayList<String> palabras = new ArrayList<String>();
			if(!archivo.exists()) {
				System.out.println("Archivo no encontrado, varificar ruta");
			}else {
				sw = new Scanner(archivo, "UTF-8");
				while (sw.hasNextLine()) {
					palabras.add(sw.nextLine());}
				}
			sw.close();
			//Fin de lectura de archivos
			
			//llenar listas de ambos idiomas con traducción a español
			ArrayList<String> PalabrasIngles = new ArrayList<String>();
			ArrayList<String> PalabrasFrances = new ArrayList<String>();
			String ingles_español;
			String frances_español;
			for (int i =0;i<palabras.size();i++){
				String[] fila = palabras.get(i).split(",");
				ingles_español = fila[0].toLowerCase().trim()+","+fila[1].toLowerCase().trim();
				frances_español = fila[2].toLowerCase().trim()+","+fila[1].toLowerCase().trim();
				PalabrasIngles.add(ingles_español);
				PalabrasFrances.add(frances_español);
			}
			//fin de llenado de listas
			
			Arbol Ingles = new Arbol();
			Arbol Frances = new Arbol();
			
			for (int i = 0;i<PalabrasIngles.size();i++) {
				Ingles.insertar(PalabrasIngles.get(i));
				Frances.insertar(PalabrasFrances.get(i));				
			}
			//0Ingles.inorden();
			//System.out.println("");
			//Frances.inorden();
			System.out.println(Ingles.existe("town"));
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
