package subastas;

public class Programa {

	public static void main(String[] args) {

		// PRUEBA DE PROGRAMA

		Usuario usuario1 = new Usuario("Juan", 100);
		Usuario usuario2 = new Usuario("Pedro", 150);
		Usuario usuario3 = new Usuario("Enrique", 300);
		
		Subasta subasta1 = new Subasta("Teléfono Móvil", usuario1);
		
		subasta1.pujar(usuario2, 100);
		
		System.out.println(subasta1);
		
		subasta1.pujar(usuario3, 50);

		System.out.println(subasta1);
		
		subasta1.ejecutar();
		subasta1.pujar(usuario3, 200);
		
		System.out.println(subasta1);
		
		System.out.println(usuario1);
		System.out.println(usuario2);
		System.out.println(usuario3);
		
		System.out.println(usuario1.getSubastasPropias());
		System.out.println(usuario2.getSubastasPropias());
		System.out.println(usuario3.getSubastasPropias());
	}

}
