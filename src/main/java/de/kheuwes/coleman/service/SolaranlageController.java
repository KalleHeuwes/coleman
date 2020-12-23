package de.kheuwes.coleman.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.kheuwes.coleman.model.SolarMonatlich;

@RestController
@RequestMapping("/api/solaranlage")
public class SolaranlageController {
    
    @GetMapping("/monatliche")
    public List<SolarMonatlich> findAlle(Model model) {
    	List<SolarMonatlich> solarMonatliche = SolaranlageService.getSolarMonatlich(null, null);
    	model.addAttribute("solarMonatliche", solarMonatliche);
        return solarMonatliche;
    }
}
