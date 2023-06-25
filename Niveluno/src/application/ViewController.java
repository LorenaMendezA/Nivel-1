package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.Pane;

public class ViewController implements Initializable {
	private Label primeraCartaSeleccionada;
	private Label segundaCartaSeleccionada;
	private int num1,num2;
	private int puntaje;
	
    
	String mostrarOpe;
	@FXML
	private Pane pane1;
	@FXML
	private Label ope1;
	@FXML
	private Pane pane2;
	@FXML
	private Label ope2;
	@FXML
	private Pane pane3;
	@FXML
	private Label ope3;
	@FXML
	private Pane pane4;
	@FXML
	private Label result1;
	@FXML
	private Pane pane5;
	@FXML
	private Label result2;
	@FXML
	private Pane pane6;
	@FXML
	private Label result3;
	@FXML
	private Button boton;
	
	public void initialize(URL url, ResourceBundle rb) {
        mostrarOperacion();
        ocultarOperaciones();
        ocultarResultados();
        
        pane1.setOnMouseClicked(event -> mostrarValor(ope1));
        pane2.setOnMouseClicked(event -> mostrarValor(ope2));
        pane3.setOnMouseClicked(event -> mostrarValor(ope3));
        pane4.setOnMouseClicked(event -> mostrarValor(result1));
        pane5.setOnMouseClicked(event -> mostrarValor(result2));
        pane6.setOnMouseClicked(event -> mostrarValor(result3));
        
        puntaje = 0;
        actualizarTextoBoton();
        
    }
	
	private void mostrarValor(Label carta) {
	    carta.setVisible(true);
	    String valor = carta.getText();
	    System.out.println("Valor de la carta: " + valor);

	    if (primeraCartaSeleccionada == null) {
	        primeraCartaSeleccionada = carta;
	    } else if (segundaCartaSeleccionada == null) {
	        segundaCartaSeleccionada = carta;
	        compararCartasSeleccionadas();
	    }
	}
	
	private void compararCartasSeleccionadas() {
	    if (primeraCartaSeleccionada != null && segundaCartaSeleccionada != null) {
	        int valorOperacion = obtenerValorOperacion(primeraCartaSeleccionada);
	        int valorResultado = Integer.parseInt(segundaCartaSeleccionada.getText());
	        compararOperacionResultado(valorOperacion, valorResultado);

	        // Reiniciar las cartas seleccionadas
	        primeraCartaSeleccionada = null;
	        segundaCartaSeleccionada = null;
	    }
	}

	private int obtenerValorOperacion(Label carta) {
	    int valorOperacion = 0;
	    if (carta == ope1) {
	        String[] partes = carta.getText().split("\\+");
	        valorOperacion = Integer.parseInt(partes[0]) + Integer.parseInt(partes[1]);
	    } else if (carta == ope2) {
	        String[] partes = carta.getText().split("\\+");
	        valorOperacion = Integer.parseInt(partes[0]) + Integer.parseInt(partes[1]);
	    } else if (carta == ope3) {
	        String[] partes = carta.getText().split("\\+");
	        valorOperacion = Integer.parseInt(partes[0]) + Integer.parseInt(partes[1]);
	    }
	    return valorOperacion;
	}


	
	private void compararOperacionResultado(int operacion, int valorResultado) {
        if (operacion == valorResultado) {
            System.out.println("La operación y el resultado coinciden.");
            puntaje++; // Incrementa el puntaje en 1 por cada acierto
            System.out.println("Puntaje actual: " + puntaje);
            actualizarTextoBoton();
            // Realiza aquí la acción deseada cuando la operación y el resultado coinciden.
        } else {
            System.out.println("La operación y el resultado no coinciden.");
            // Realiza aquí la acción deseada cuando la operación y el resultado no coinciden.
        }
    }



	public void mostrarOperacion(){
		
		Random random = new Random();
		num1=random.nextInt(99)+1;
		num2=random.nextInt(99)+1;
		String mostrarOpe=num1+"+"+num2;
		ope1.setText(mostrarOpe);
		int resultado1 = num1+num2;
		
		//operacion carta 2
		num1=random.nextInt(99)+1;
		num2=random.nextInt(99)+1;
		String mostrarOpe2=num1+"+"+num2;
		ope2.setText(mostrarOpe2);
		int resultado2 = num1+num2;
		
		//operacion carta 3
		num1=random.nextInt(99)+1;
		num2=random.nextInt(99)+1;
		String mostrarOpe3=num1+"+"+num2;
		ope3.setText(mostrarOpe3);
		int resultado3 = num1+num2;
		
		//resultado en cartas de abajo
		int randomIndex = random.nextInt(3); 
	    switch (randomIndex) {
        case 0:
            result1.setText(String.valueOf(resultado1));
            result2.setText(String.valueOf(resultado2));
            result3.setText(String.valueOf(resultado3));
            break;
        case 1:
            result1.setText(String.valueOf(resultado2));
            result2.setText(String.valueOf(resultado3));
            result3.setText(String.valueOf(resultado1));
            break;
        case 2:
            result1.setText(String.valueOf(resultado3));
            result2.setText(String.valueOf(resultado1));
            result3.setText(String.valueOf(resultado2));
            break;
        default:
            break;
	    }
	}

	
	private void ocultarOperaciones() {
	    ope1.setVisible(false);
	    ope2.setVisible(false);
	    ope3.setVisible(false);
	}

	private void ocultarResultados() {
	    result1.setVisible(false);
	    result2.setVisible(false);
	    result3.setVisible(false);
	}
	
	private void actualizarTextoBoton() {
        boton.setText("Puntaje: " + puntaje);
    }	
	
	
	
		
	}


