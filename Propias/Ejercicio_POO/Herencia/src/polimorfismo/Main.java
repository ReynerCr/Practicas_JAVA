package polimorfismo;

public class Main {

	public static void main(String[] args) {
		Vehiculo misVehiculos[] = new Vehiculo[4];

		misVehiculos[0] = new Vehiculo("SAU64W", "HYUNDAI", "ACCENT");
		misVehiculos[1] = new VehiculoTurismo("sadas", "fiat", "spark", 4);
		misVehiculos[2] = new VehiculoDeportivo("jhgjh", "toyota", "fome", 10);
		misVehiculos[3] = new VehiculoFurgoneta("asdsa", "chevrolet", "terios", 40);

		for (int i = 0; i < 4; i++) {
			System.out.println(misVehiculos[i].mostrarDatos() + "\n\n");
		}

	}

}
