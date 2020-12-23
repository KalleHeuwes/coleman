package de.kheuwes.coleman.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolarUntertaegig {
	private LocalDate datum = null;
	private String uhrzeit = "";
	private double eigenversorgung = 0;
	private double netzbezug = 0;
	private double gesamtverbrauch = 0;
	private double netzeinspeisung = 0;
	private double eigenverbrauch = 0;
	private double pverzeugung = 0;
}
