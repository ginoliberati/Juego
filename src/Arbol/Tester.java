package Arbol;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Logica logi = new Logica();
		Scanner s = new Scanner(System.in);
		int res;
		String e, dif;
		
		System.out.println("1 - Si");
		System.out.println("0 - No");
		
		while (!logi.Gano()) {
			System.out.println(logi.getPregunta());
			res=s.nextInt();
			
			if (res==1) {
				logi.Si();
			}
			else {
				logi.No();
			}
			
			if (logi.Gano()) {
				System.out.println("Perdiste. Volver a jugar?");
				res=s.nextInt();
				
				if (res==1) {logi.reset();}
			}
			else if (logi.Perdio()) {
				System.out.println("Ganaste. Cual era el elemento?");
				e=s.nextLine();
				System.out.println("Cual es la diferencia entre ambos?");
				dif=s.nextLine();
				
				logi.Agregar(e, dif);
				
				System.out.println("Volver a jugar?");
				res=s.nextInt();
				
				if (res==1) {logi.reset();}
			}
		}
	}
}
