package main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import clases.Cliente;
import clases.Colores;
import clases.CuentaCLP;
import clases.Transaccion;

public class Main implements Colores{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String rut;
		String nombre;
		String apellido;
		boolean validarRut = false;
		boolean validarNombre = false;
		boolean validarApellido = false;
			
		System.out.println("\t--------------------ALKE WALLET--------------------");
		System.out.print("\n\tTe damos la bienvenida a nuestra billetera virtual\n"
				+ "\tPor favor ingresa tus datos:\n");
		
		do {
			System.out.print("\tRut: ");
			rut = sc.next();
			
			if(rut.length() == 12 && rut.charAt(2) == '.' && rut.charAt(6) == '.' && rut.charAt(10) == '-') {
				validarRut = true;
				
				do {
					System.out.print("\tNombre (ej. pepito): ");
					nombre = sc.next();
					
					if(nombre.length() >= 2) {
						validarNombre = true;
						
						do {
							System.out.print("\tApellido (ej. briones): ");
							apellido = sc.next();
							
							if(apellido.length() >= 2) {
								validarApellido = true;
								
								String nombreCompleto = nombre + " "+ apellido;	
							
								/*
								 * Definimos el numero de cuenta de manera aleatoria
								 * */
								int max = 100000; 
						        int min = 1;
						        int range = max - min + 1;
								
						        int randomAccount = (int)(Math.random() * range) + min;
						        
						        CuentaCLP cuenta = new CuentaCLP(randomAccount, 0);
								Cliente cliente = new Cliente(rut, nombreCompleto, cuenta);
								
								int opcionMenuPrincipal = 0;
								int opcionSubMenu = 0;
								
								while(opcionMenuPrincipal !=5) {
									System.out.println("\n\t------------------------MENU------------------------");
									System.out.println("");
									System.out.println("\tBienvenidx "+cliente.getNombreCompleto()+"!");
									System.out.println("");
									System.out.println("\t1. Administración de fondos.");
									System.out.println("\t2. Conversor de moneda.");
									System.out.println("\t3. Ultimos movimientos.");
									System.out.println("\t4. Ver información de la cuenta.");
									System.out.println("\t5. Salir");
									System.out.print("\tPor favor, escoge alguna de las opciones: ");
									
									try{
										opcionMenuPrincipal = sc.nextInt();
										sc.nextLine();
									}catch(InputMismatchException e) {
										System.out.println("\t"+ROJO+"Por favor, ingrese un número válido."+RESET);
										sc.nextLine();
										continue;
										
									}
					
									switch(opcionMenuPrincipal) {
										case 1: 
											
											do {
												System.out.println("\n\t-----ADMINISTRACIÓN DE FONDOS-----");
												System.out.println("");
												System.out.println("\t1. Saldo disponible.");
												System.out.println("\t2. Realizar deposito.");
												System.out.println("\t3. Realizar retiro");
												System.out.println("\t4. Volver al menú principal");
												System.out.print("\tPor favor, escoge alguna de las opciones:  ");
												
												try{
													opcionSubMenu = sc.nextInt();
													sc.nextLine();
												}catch(InputMismatchException e) {
													System.out.println("\t"+ROJO+"Por favor, ingrese un número válido."+RESET);
													sc.nextLine();
													continue;
													
												}

												switch(opcionSubMenu) {
													case 1:
														System.out.println("\n\tTu saldo disponible es: "+VERDE+cliente.getCuenta().getSimbolo()+cliente.getCuenta().getSaldoActual()+RESET);
														
														esperarParaContinuar(sc);
														
														break;
													case 2:
														System.out.print("\n\tPor favor ingrese saldo a depositar: ");
														double montoDeposito;
														try {
															montoDeposito = sc.nextDouble();
															sc.nextLine();
														}catch(InputMismatchException e) {
															System.out.println("\t"+ROJO+"Debes ingresar un número válido."+RESET);
															sc.nextLine();
															continue;
														}
														
														cliente.getCuenta().depositar(montoDeposito);
														esperarParaContinuar(sc);
														
														break;
													case 3:
														System.out.print("\n\tPor favor ingrese saldo a retirar: ");
														double montoRetiro;
														try {
															montoRetiro = sc.nextDouble();
															sc.nextLine();
														}catch(InputMismatchException e) {
															System.out.println("\t"+ROJO+"Debes ingresar un número válido."+RESET);
															sc.nextLine();
															continue;
														}
														
														cliente.getCuenta().retirar(montoRetiro);
														esperarParaContinuar(sc);
													
														break;
													case 4:
														break;
													default:
														System.out.println("\t"+ROJO+"Solo se aceptan numeros entre 1 y 4"+RESET);
												}
											}while(opcionSubMenu != 4);
											
											break;
										case 2:
											System.out.println("\n\t-----CONVERSOR DE MONEDA-----");
											System.out.println("\n\tTipo de moneda actual de su cuenta: "+cliente.getCuenta().getSimbolo());
											System.out.println("\t1. CLP");
											System.out.println("\t2. USD");
											System.out.print("\tPor favor, escoja el tipo de cambio que desea: ");
											int opcion3 = sc.nextInt();
											
											cliente.seleccionarMoneda(opcion3);
											esperarParaContinuar(sc);
											
											break;
										case 3: 
											System.out.println("\n\t-----ULTIMOS MOVIMIENTOS DE LA CUENTA-----");
											List <Transaccion> transacciones = cliente.getCuenta().getTransacciones();
											
											for(Transaccion t : transacciones) {
												System.out.println(t);
											}
											esperarParaContinuar(sc);
											
											break;
											
										case 4:
											System.out.println("\n\t-----INFORMACIÓN DE LA CUENTA-----");
											System.out.println(cliente.toString()); 
											
											esperarParaContinuar(sc);
											
											break;
											
										case 5:
											break;
										default:
											System.out.println("\t"+ROJO+"Solo numeros entre 1 y 5"+RESET);
									}
									
								}
									        
							}else {
								System.out.println("\t"+ROJO+"El largo del apellido debe ser mayor a 2."+RESET);
							}
							
						}while(!validarApellido);
								
					}else {
						System.out.println("\t"+ROJO+"El largo del nombre debe ser mayor a 2."+RESET);
					}
					
				}while(!validarNombre);
					
			}else {
				System.out.println("\t"+ROJO+"Formato de rut incorrecto, por favor pruebe con el formato: 11.111.111-1."+RESET);
			}
		}while(!validarRut);
		
		sc.close();

	}
	
	public static void esperarParaContinuar(Scanner scanner) {
        System.out.println("\tPresiona Enter para continuar...");
        scanner.nextLine();  
    }


}
