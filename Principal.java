import java.io.File;
import java.util.*;
import java.io.FileWriter;
/*
    Programador Daniel Esteban Morales Urizar
    Programa que traduce fraces en Ingles a Español y de Frances a Español por medio de un diccionario utilizando árboles binarios
    Finalización 08/04/2022
*/
	
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
			Controlador diccionario = new Controlador();
			diccionario.crear_arboles(palabras);
			
			String menu="1. In-order de ingles\n2. In-order de frances\n3. Agregar palabra\n4. Eliminar palabra\n5. Traducir texto\n6. Salir";
			
			boolean cicloprincipal=true;
			while(cicloprincipal) {
				System.out.println(menu);
				int opcion = sr.nextInt();
				sr.nextLine();
				switch(opcion) {
				case 1:
					diccionario.InOrderIngles();
					break;
				case 2:
					diccionario.InOrderFrances();
					break;
				case 3:
					//agregar palabra
					System.out.println("Ingrese palabra nueva: (Ingles,espanol,frances)");
					String palabra = sr.nextLine();
					
					String[]traducciones = palabra.split(",");
					System.out.println(palabra);
					if(traducciones.length==3) {
						diccionario.agregarpalabras(traducciones);
					}else {
						System.out.println("Formato Incorrecto");
					}
					break;
				case 4:
					//eliminar palabra
					break;
				case 5:
					//traducir texto
					System.out.println("Ingrese la ruta del archivo (incluya el nombre y la extención)");
					//String ruta2 = sr.nextLine();
					String ruta2 = "C:\\Users\\pc\\Documents\\uvg\\sem3\\algoritmos\\eclipse\\Hoja7\\texto.txt";
					File archivo2 = new File(ruta2);
					ArrayList<String> texto = new ArrayList<String>();
					if(!archivo2.exists()) {
						System.out.println("Archivo no encontrado, varificar ruta");
					}else {
						sw = new Scanner(archivo2, "UTF-8");
						while (sw.hasNextLine()) {
							texto.add(sw.nextLine());}
						}
					sw.close();	
					System.out.println(diccionario.traducir(texto));
					
					break;
				case 6:
					cicloprincipal = false;
					break;
				default:
					System.out.println("Ingrese un numero valido");
					break;
				}
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
