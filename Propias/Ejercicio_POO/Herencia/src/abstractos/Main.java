package abstractos;

public class Main {

	public static void main(String[] args) {
		Planta planta = new Planta();
		planta.alimentarse();

		AnimalCarnivoro animalCarnivoro = new AnimalCarnivoro();
		animalCarnivoro.alimentarse();

		AnimalHerbivoro animalHerbivoro = new AnimalHerbivoro();
		animalHerbivoro.alimentarse();

	}

}
