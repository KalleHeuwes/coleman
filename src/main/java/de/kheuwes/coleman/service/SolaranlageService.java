package de.kheuwes.coleman.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.kheuwes.coleman.model.SolarMonatlich;
import de.kheuwes.coleman.model.SolarUntertaegig;
import de.kheuwes.coleman.utils.ColemanConst;
import de.kheuwes.coleman.utils.Utils;

public class SolaranlageService {
	public static List<SolarMonatlich> getSolarMonatlich(String datumVon, String datumBis){
		List<SolarMonatlich> ret = new ArrayList<>();
		SolarMonatlich sm = null;
		String lDatumVon = (datumVon == null ? "1900-01-01" : datumVon);
		String lDatumBis = (datumBis == null ? "2999-12-31" : datumBis);
		Utils.log(String.format("Hole monatliche Daten %s - %s ...", lDatumVon, lDatumBis));
		
		try {
			JdbcConnection solarConnection = new JdbcConnection(ColemanConst.CON_SOLAR);
			
			ResultSet result = solarConnection.getResultset(String.format(ColemanConst.SQL_SOLAR_MONATLICH, lDatumVon, lDatumBis));
			 
			while (result.next()) {
				if(result.getDouble("gesamtverbrauch") != 0.0) {
			    	sm = new SolarMonatlich(result.getDate("datum").toLocalDate(), result.getDouble("gesamtverbrauch")
			    			, result.getDouble("eigenversorgung"), result.getDouble("netzbezug")
			    			, result.getDouble("pverzeugung"), result.getDouble("netzeinspeisung")
			    			, result.getDouble("eigenverbrauch"));
			    	ret.add(sm);
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public static List<SolarUntertaegig> getSolarUntertaegig(String datum){
		List<SolarUntertaegig> ret = new ArrayList<>();
		SolarUntertaegig su = null;
		String lDatum = (datum == null ? "1900-01-01" : datum);
		
		try {
			JdbcConnection solarConnection = new JdbcConnection(ColemanConst.CON_SOLAR);
			ResultSet result = solarConnection.getResultset(String.format(ColemanConst.SQL_SOLAR_UNTERTAEGIG, lDatum));
             
            while (result.next()) {
            	su = new SolarUntertaegig(result.getDate("datum").toLocalDate(), result.getString("uhrzeit")
            			, result.getDouble("eigenversorgung"), result.getDouble("netzbezug")
            			, result.getDouble("gesamtverbrauch")
            			, result.getDouble("netzeinspeisung")
            			, result.getDouble("eigenverbrauch"), result.getDouble("pverzeugung"));
            	ret.add(su);            	
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return ret;
	}
}
