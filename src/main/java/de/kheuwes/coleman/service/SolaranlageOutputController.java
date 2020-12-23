package de.kheuwes.coleman.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.kheuwes.coleman.model.SolarMonatlich;
import de.kheuwes.coleman.model.SolarUntertaegig;

@Controller
@RequestMapping("/api/solaranlage")
public class SolaranlageOutputController {

    @GetMapping("/monatlich")
    public String findAll(Model model, @RequestParam(name = "datumVon") String datumVon, @RequestParam(name = "datumBis") String datumBis) {
    	List<SolarMonatlich> solarMonatliche = SolaranlageService.getSolarMonatlich(datumVon, datumBis);
    	model.addAttribute("solarMonatliche", solarMonatliche);
    	model.addAttribute("datumvon", datumVon);
    	model.addAttribute("datumbis", datumBis);
        return "solarm";
    }
    
    @GetMapping("/untertaegig")
    public String findAllUntertaegig(Model model, @RequestParam(name = "datum") String datum) {
    	List<SolarUntertaegig> solarUntertaegige = SolaranlageService.getSolarUntertaegig(datum);
    	model.addAttribute("solarUntertaegige", solarUntertaegige);
        return "solaru";
    }

}
