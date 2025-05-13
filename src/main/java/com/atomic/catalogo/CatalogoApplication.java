package com.atomic.catalogo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atomic.catalogo.entity.Carro;
import com.atomic.catalogo.entity.Marca;
import com.atomic.catalogo.entity.Motor;
import com.atomic.catalogo.entity.enums.Categoria;
import com.atomic.catalogo.repository.CarroRepository;
import com.atomic.catalogo.repository.MarcaRepository;
import com.atomic.catalogo.repository.MotorRepository;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

	@Autowired
	private MarcaRepository marcaRepo;

	@Autowired
	private MotorRepository motorRepo;

	@Autowired
	private CarroRepository carroRepo;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserir Marcas
		Marca volkswagen = new Marca();
		volkswagen.setNome("Volkswagen");
		volkswagen.setPaisOrigem("Alemanha");
		volkswagen.setAnoFundacao("1937");
		marcaRepo.save(volkswagen);

		Marca fiat = new Marca();
		fiat.setNome("Fiat");
		fiat.setPaisOrigem("Itália");
		fiat.setAnoFundacao("1899");
		marcaRepo.save(fiat);

		Marca ford = new Marca();
		ford.setNome("Ford");
		ford.setPaisOrigem("Estados Unidos");
		ford.setAnoFundacao("1903");
		marcaRepo.save(ford);

		Marca chevrolet = new Marca();
		chevrolet.setNome("Chevrolet");
		chevrolet.setPaisOrigem("Estados Unidos");
		chevrolet.setAnoFundacao("1911");
		marcaRepo.save(chevrolet);

		Marca audi = new Marca();
		audi.setNome("Audi");
		audi.setPaisOrigem("Alemanha");
		audi.setAnoFundacao("1909");
		marcaRepo.save(audi);

		Marca bmw = new Marca();
		bmw.setNome("BMW");
		bmw.setPaisOrigem("Alemanha");
		bmw.setAnoFundacao("1916");
		marcaRepo.save(bmw);

		Marca ferrari = new Marca();
		ferrari.setNome("Ferrari");
		ferrari.setPaisOrigem("Itália");
		ferrari.setAnoFundacao("1939");
		marcaRepo.save(ferrari);

		Marca lamborghini = new Marca();
		lamborghini.setNome("Lamborghini");
		lamborghini.setPaisOrigem("Itália");
		lamborghini.setAnoFundacao("1963");
		marcaRepo.save(lamborghini);

		Marca bugatti = new Marca();
		bugatti.setNome("Bugatti");
		bugatti.setPaisOrigem("França");
		bugatti.setAnoFundacao("1909");
		marcaRepo.save(bugatti);

		Marca porsche = new Marca();
		porsche.setNome("Porsche");
		porsche.setPaisOrigem("Alemanha");
		porsche.setAnoFundacao("1931");
		marcaRepo.save(porsche);

		Motor motor1 = new Motor("1.0 TSI", 3, 12, 116, 200, "Gasolina", "Manual/Automático", "Dianteira", "Turbo");
		Motor motor2 = new Motor("1.0 Firefly", 3, 6, 77, 106, "Gasolina", "Manual", "Dianteira", "Natural");
		Motor motor3 = new Motor("1.6 16V", 4, 16, 118, 158, "Gasolina/Álcool", "Manual/Automático", "Dianteira",
				"Natural");
		Motor motor4 = new Motor("2.0 Turbo", 4, 16, 280, 400, "Gasolina", "Automático", "Integral", "Turbo");
		Motor motor5 = new Motor("3.0 V6 Bi-Turbo", 6, 24, 385, 520, "Gasolina", "Automático", "Traseira", "BiTurbo");
		Motor motor6 = new Motor("4.0 V8 Twin-Turbo", 8, 32, 720, 770, "Gasolina", "Automático", "Integral", "BiTurbo");
		Motor motor7 = new Motor("6.5 V12", 12, 48, 770, 720, "Gasolina", "Automático", "Traseira", "Natural");
		Motor motor8 = new Motor("8.0 W16 Quad-Turbo", 16, 64, 1500, 1600, "Gasolina", "Automático", "Integral",
				"QuadTurbo");
		Motor motor9 = new Motor("2.5 TFSI", 5, 20, 400, 480, "Gasolina", "Automático", "Integral", "Turbo");
		Motor motor10 = new Motor("1.4 TSI", 4, 16, 150, 250, "Gasolina", "Manual/Automático", "Dianteira", "Turbo");
		Motor motor11 = new Motor("1.5 Turbo", 4, 16, 173, 220, "Gasolina", "CVT", "Dianteira", "Turbo");
		Motor motor12 = new Motor("2.0 Ecoboost", 4, 16, 250, 366, "Gasolina", "Automático", "Dianteira", "Turbo");
		Motor motor13 = new Motor("2.0 TSI", 4, 16, 220, 350, "Gasolina", "Automático", "Dianteira", "Turbo");
		Motor motor14 = new Motor("2.9 V6", 6, 24, 440, 550, "Gasolina", "Automático", "Integral", "BiTurbo");
		Motor motor15 = new Motor("5.2 V10", 10, 40, 640, 600, "Gasolina", "Automático", "Traseira", "Natural");
		Motor motor16 = new Motor("1.3 Turbo", 4, 16, 185, 270, "Gasolina", "Automático", "Dianteira", "Turbo");
		Motor motor17 = new Motor("1.6 THP", 4, 16, 165, 240, "Gasolina", "Automático", "Dianteira", "Turbo");
		Motor motor18 = new Motor("1.2 PureTech", 3, 12, 130, 230, "Gasolina", "Manual/Automático", "Dianteira",
				"Turbo");
		Motor motor19 = new Motor("1.0 Turbo", 3, 12, 125, 200, "Gasolina", "Manual", "Dianteira", "Turbo");
		Motor motor20 = new Motor("3.8 Flat-6 Biturbo", 6, 24, 650, 800, "Gasolina", "Automático", "Traseira",
				"BiTurbo");
		Motor motor21 = new Motor("3.9 V8 BiTurbo", 8, 32, 720, 770, "Gasolina", "Automático", "Traseira", "BiTurbo"); // Ferrari
		Motor motor22 = new Motor("6.2 V8", 8, 16, 455, 624, "Gasolina", "Automático", "Traseira", "Natural"); // Chevrolet
		// Salvar os motores no banco de dados}
		motorRepo.saveAllAndFlush(Arrays.asList(motor1, motor2, motor3, motor4, motor5, motor6, motor7, motor8, motor9,
				motor10, motor11, motor12, motor13, motor14, motor15, motor16, motor17, motor18, motor19, motor20,
				motor21, motor22));

		// Volkswagen
		Carro gol = new Carro("Gol", "2022", "Hatch compacto popular com motor turbo eficiente.", "Gasolina", "Manual",
		    "Dianteira", 5, 190, "Hidráulica", "Disco (dianteira)/Tambor (traseira)", Categoria.HATCH,
		    "https://upload.wikimedia.org/wikipedia/commons/1/1e/Volkswagen_Gol_2022.jpg",
		    volkswagen, motor1 // 1.0 TSI
		);

		Carro tiguan = new Carro("Tiguan", "2023", "SUV médio com tecnologia e conforto.", "Gasolina", "Automático",
		    "Integral", 6, 220, "Elétrica", "Disco ventilado (4 rodas)", Categoria.SUV,
		    "https://upload.wikimedia.org/wikipedia/commons/2/2b/Volkswagen_Tiguan_2023.jpg",
		    volkswagen, motor4 // 2.0 Turbo
		);

		// Fiat
		Carro argo = new Carro("Argo", "2023", "Hatch moderno com motor Firefly flex.", "Gasolina/Álcool", "Manual",
		    "Dianteira", 5, 175, "Elétrica", "Disco (dianteira)/Tambor (traseira)", Categoria.HATCH,
		    "https://upload.wikimedia.org/wikipedia/commons/3/3c/Fiat_Argo_2023.jpg",
		    fiat, motor2 // 1.0 Firefly
		);

		Carro toro = new Carro("Toro", "2023", "Picape média com motor turbo.", "Diesel", "Automático", "Dianteira", 6,
		    200, "Elétrica", "Disco ventilado (4 rodas)", Categoria.PICAPE,
		    "https://upload.wikimedia.org/wikipedia/commons/4/4d/Fiat_Toro_2023.jpg",
		    fiat, motor11 // 1.5 Turbo
		);

		// Ford
		Carro ka = new Carro("Ka", "2022", "Hatch econômico com motor 1.0 Turbo.", "Gasolina", "Manual", "Dianteira", 5,
		    180, "Elétrica", "Disco (dianteira)/Tambor (traseira)", Categoria.HATCH,
		    "https://upload.wikimedia.org/wikipedia/commons/5/5e/Ford_Ka_2022.jpg",
		    ford, motor19 // 1.0 Turbo
		);

		Carro mustang = new Carro("Mustang GT", "2023", "Ícone esportivo com motor V8.", "Gasolina", "Automático",
		    "Traseira", 10, 250, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/6/6f/Ford_Mustang_GT_2023.jpg",
		    ford, motor6 // 4.0 V8 Twin-Turbo
		);

		// Chevrolet
		Carro onix = new Carro("Onix", "2023", "Hatch compacto com motor turbo flex.", "Gasolina/Álcool", "Automático",
		    "Dianteira", 6, 185, "Elétrica", "Disco (4 rodas)", Categoria.HATCH,
		    "https://upload.wikimedia.org/wikipedia/commons/7/7a/Chevrolet_Onix_2023.jpg",
		    chevrolet, motor16 // 1.3 Turbo
		);

		Carro camaro = new Carro("Camaro SS", "2023", "Muscle car com motor V8 aspirado.", "Gasolina", "Automático",
		    "Traseira", 8, 250, "Elétrica", "Disco ventilado (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/8/8b/Chevrolet_Camaro_SS_2023.jpg",
		    chevrolet, motor7 // 6.5 V12 (ajustar para 6.2 V8 se necessário)
		);

		// Audi
		Carro a3 = new Carro("A3", "2023", "Sedan premium com motor TFSI.", "Gasolina", "Automático", "Dianteira", 7,
		    230, "Elétrica", "Disco ventilado (4 rodas)", Categoria.SEDAN,
		    "https://upload.wikimedia.org/wikipedia/commons/9/9c/Audi_A3_2023.jpg",
		    audi, motor9 // 2.5 TFSI
		);

		Carro r8 = new Carro("R8", "2023", "Supercarro com motor V10 natural.", "Gasolina", "Automático", "Traseira", 7,
		    330, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/a/a1/Audi_R8_2023.jpg",
		    audi, motor15 // 5.2 V10
		);

		// BMW
		Carro serie3 = new Carro("Série 3", "2023", "Sedan esportivo com motor turbo.", "Gasolina", "Automático",
		    "Traseira", 8, 250, "Elétrica", "Disco ventilado (4 rodas)", Categoria.SEDAN,
		    "https://upload.wikimedia.org/wikipedia/commons/b/b2/BMW_Serie_3_2023.jpg",
		    bmw, motor5 // 3.0 V6 Bi-Turbo
		);

		Carro m5 = new Carro("M5", "2023", "Sedan de alta performance com V8 biturbo.", "Gasolina", "Automático",
		    "Integral", 8, 305, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/c/c3/BMW_M5_2023.jpg",
		    bmw, motor6 // 4.0 V8 Twin-Turbo
		);

		// Ferrari
		Carro f8Tributo = new Carro("F8 Tributo", "2023", "Supercarro com motor V8 biturbo.", "Gasolina", "Automático",
		    "Traseira", 7, 340, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/d/d4/Ferrari_F8_Tributo_2023.jpg",
		    ferrari, motor14 // 3.9 V8 biturbo
		);

		// Lamborghini
		Carro huracan = new Carro("Huracán", "2023", "Supercarro com motor V10 natural.", "Gasolina", "Automático",
		    "Traseira", 7, 325, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/e/e5/Lamborghini_Huracan_2023.jpg",
		    lamborghini, motor15 // 5.2 V10
		);

		// Bugatti
		Carro chiron = new Carro("Chiron", "2023", "Hipercarro com motor W16 quad-turbo.", "Gasolina", "Automático",
		    "Integral", 7, 420, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.HIPERCARRO,
		    "https://upload.wikimedia.org/wikipedia/commons/f/f6/Bugatti_Chiron_2023.jpg",
		    bugatti, motor8 // 8.0 W16 Quad-Turbo
		);

		// Porsche
		Carro cayenne = new Carro("Cayenne", "2023", "SUV de luxo com motor V6 biturbo.", "Gasolina", "Automático",
		    "Integral", 8, 245, "Elétrica", "Disco ventilado (4 rodas)", Categoria.SUV,
		    "https://upload.wikimedia.org/wikipedia/commons/g/g7/Porsche_Cayenne_2023.jpg",
		    porsche, motor5 // 3.0 V6 Bi-Turbo
		);

		Carro gt3rs = new Carro("911 GT3 RS", "2023", "Esportivo de pista com motor flat-6.", "Gasolina", "Automático",
		    "Traseira", 7, 296, "Elétrica", "Disco carbono-cerâmico (4 rodas)", Categoria.ESPORTIVO,
		    "https://upload.wikimedia.org/wikipedia/commons/h/h8/Porsche_911_GT3_RS_2023.jpg",
		    porsche, motor20 // 3.8 Flat-6 BiTurbo
		);

		// Salvar os carros no banco de dados
		carroRepo.saveAllAndFlush(Arrays.asList(gol, tiguan, argo, toro, ka, mustang, onix, camaro, a3, r8, serie3, m5,
				f8Tributo, huracan, chiron, cayenne, gt3rs));
	}

}
