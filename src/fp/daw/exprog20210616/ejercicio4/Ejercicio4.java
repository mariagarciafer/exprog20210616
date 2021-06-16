package fp.daw.exprog20210616.ejercicio4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ejercicio4 {

		public static void intercalar(Queue<Integer> q) {
			if (q.size() % 2 == 1)
				throw new IllegalArgumentException();
			if (q.size() <= 2)
				return;
			Queue<Integer> aux = new LinkedList<Integer>();
			int n = q.size() / 2;
			for (int i=0; i<n; i++)
				aux.offer(q.poll());
			while (!aux.isEmpty()) {
				q.offer(aux.poll());
				q.offer(q.poll());
			}
		}
	
		public static void main(String[] args) {
			Queue<Integer> q = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
			intercalar(q);
			System.out.println(q);
		}
}
