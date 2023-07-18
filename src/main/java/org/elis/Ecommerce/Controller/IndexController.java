package org.elis.Ecommerce.Controller;

import org.elis.Ecommerce.Facade.ProdottoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import DtoRequest.ProdottoRequest;
import DtoResponse.ProdottoDTO;

import org.springframework.ui.Model;

@Controller
public class IndexController {
	@Autowired
	ProdottoFacade prodottoFacade;
	
	
	
	

	@GetMapping("/")
	public String Index() {
		
		return "index";
		
	}
	
	
	
    @GetMapping("/aggiornamento")
    public String aggiornamento() {
        return "aggiornamento";
    }

    @GetMapping("/ricerca")
    public String ricerca() {
        return "ricerca";
    }
    
  
    
    
  /*  @PostMapping("/addprodotto")
    public String aggiungiProdotto(@ModelAttribute("prodottoRequest") ProdottoRequest prodottoRequest, Model model) {
        ProdottoDTO prodottoDTO = prodottoFacade.aggiungiProdotto(prodottoRequest);
        model.addAttribute("prodottoDTO", prodottoDTO);
        return "index"; // Cambia la stringa con il nome del tuo template HTML di conferma
    }

    */
    
    @PostMapping("/addprodotto")
    public ResponseEntity<ProdottoDTO> aggiungiProdotto(@ModelAttribute("prodottoRequest") ProdottoRequest prodottoRequest, Model model) {
        ProdottoDTO prodottoDTO = prodottoFacade.aggiungiProdotto(prodottoRequest);
        model.addAttribute("prodottoDTO", prodottoDTO);

        // Puoi personalizzare lo status HTTP e le intestazioni secondo le tue esigenze
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");

        // Restituisci una ResponseEntity con lo status, le intestazioni e il corpo della risposta
        return ResponseEntity.ok()
                .headers(headers)
                .body(prodottoDTO);
    }
    
    @GetMapping("/add")
    public ModelAndView visualizzaFormAggiungiProdotto() {
        ModelAndView modelAndView = new ModelAndView("aggiungiprodotto");
        modelAndView.addObject("prodottoRequest", new ProdottoRequest());
        return modelAndView;
    }
    
    
    
  
    
    
   
	
}
