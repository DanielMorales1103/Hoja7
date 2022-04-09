/*
 * Implementado de: 
 * 	2020 Luis Cabrera Benito
 *  Licenciado bajo la licencia MIT
 *  https://parzibyte.me/blog/2020/05/08/arbol-binario-java/
 */
public class Arbol {
	private Nodo raiz;

    public Arbol() {

    }
    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, String busqueda) {
        if (n == null) {
            return false;
        }
        String[] cambio = n.getDato().split(",");        
        if (cambio[0].trim().equals(busqueda.toLowerCase())) {
            return true;
        } else if (busqueda.toLowerCase().compareTo(cambio[0].trim()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }
    public String traductor(String palabra) {
    	return traductor(this.raiz,palabra);
    }
    private String traductor(Nodo n, String palabra) {
    	if (n == null) {
    		return "*"+palabra+"*";
    	}
    	String[] cambio = n.getDato().split(",");
    	if(cambio[0].trim().equals(palabra.toLowerCase())) {
    		return cambio[1].trim();
    	}else if(palabra.toLowerCase().compareTo(cambio[0].trim()) < 0) {
    		return traductor(n.getIzquierda(), palabra);
    	}else {
    		return traductor(n.getDerecha(),palabra);
    	}
    	
    }
    public void insertar(String dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }
    
    private void insertar(Nodo padre, String dato) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }
    
    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            n.imprimirDato();
            inorden(n.getDerecha());
        }
    }
   
    public void inorden() {
        this.inorden(this.raiz);
    }

    
}

