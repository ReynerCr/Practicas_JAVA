package archivos;

import java.io.Serializable;

public class Auto implements Serializable  {
		String marca, duenho;
		int anho;
		
		public Auto () {
			marca = "";
			duenho = "";
			anho = 0;
		}
		
		public Auto (String marca, String duenho, int anho) {
			this.marca = new String (marca);
			this.duenho = new String (duenho);
			this.anho = anho;
		}

		@Override
		public String toString() {
			return "Auto [marca=" + marca + ", duenho=" + duenho + ", anho=" + anho + "]";
		}
}
