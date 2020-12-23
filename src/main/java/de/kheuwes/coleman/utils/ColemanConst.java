package de.kheuwes.coleman.utils;

public class ColemanConst {
	public static final String CON_SOLAR = "jdbc:ucanaccess://W://Haus//Umbauten//Solaranlage2020//Solaranlage.accdb";
	public static final String CON_05 = "jdbc:ucanaccess://W://05//Finanzen//E05_Vereinsverwaltung.accdb";
	
	public static final String SQL_SOLAR_MONATLICH = "SELECT * FROM Monatlich WHERE datum >= CDate('%s') AND datum <= CDate('%s')";
	public static final String SQL_SOLAR_UNTERTAEGIG = "SELECT * FROM Untertaegig WHERE datum = CDate('%s')";
	
}
