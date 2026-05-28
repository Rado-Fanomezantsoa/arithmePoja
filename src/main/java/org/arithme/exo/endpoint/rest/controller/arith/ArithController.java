package org.arithme.exo.endpoint.rest.controller.arith;

import org.arithme.exo.service.ArithService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class ArithController {

    private final ArithService arithService;

  @GetMapping("/add")
  public int add(int a, int b) {
    return arithService.add(a, b);
  }

  @GetMapping("/subtract")
  public int subtract(int a, int b) {
    return arithService.subtract(a, b);
  }
  
  @GetMapping("/divise")
  public int divise(int a, int b) {
      return arithService.divise(a, b);
  }
  

  @GetMapping("/multiply")
  public int multiply(int a, int b) {
      return arithService.multiply(a, b);
  }
  
}
