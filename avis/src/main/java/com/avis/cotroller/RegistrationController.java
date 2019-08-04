package com.avis.cotroller;

import com.avis.domain.SellerDto;
import com.avis.service.SellerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RegistrationController {

  private final SellerService sellerService;

    public RegistrationController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

  @RequestMapping(value = "/newSeller", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
          MediaType.APPLICATION_FORM_URLENCODED_VALUE})
  public boolean createSeller(@RequestBody SellerDto sellerDto) {
    return sellerService.addNewSeller(sellerDto);
  }
}





