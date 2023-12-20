package com.example.nunes_sports.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nunes_sports.dtos.ProdutoDTO;
import com.example.nunes_sports.services.ProdutoService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
public class ProdutoExceptionController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/insert")
    public ModelAndView insert(){

        ModelAndView mav = new ModelAndView("insert");
        mav.addObject("produto", new ProdutoDTO());

        return mav;
    }

    @PostMapping("/insert")
    public void submitInsert(@ModelAttribute("produto") ProdutoDTO produto,
                                                          BindingResult result,
                                                          ModelMap modelMap,
                                                          HttpServletResponse response,
                                                          RedirectAttributes redirectAttributes)throws IOException{

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um Erro");
        }else{
            produtoService.salvar(produto);
            redirectAttributes.addFlashAttribute("message", "Produto Inserido com Sucesso");
        }
        response.sendRedirect("/");
    }

    @GetMapping("/update")
    public ModelAndView update(Integer id){

        ModelAndView mav = new ModelAndView("update");
        mav.addObject("produto", produtoService.obtainById(id));

        return mav;
    }
    
    @PostMapping("/update")
    public void submitUpdate(@ModelAttribute("produto") ProdutoDTO produto,
                                                          BindingResult result,
                                                          ModelMap modelMap,
                                                          HttpServletResponse response,
                                                          RedirectAttributes redirectAttributes)throws IOException{

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um Erro");
        }else{
            produtoService.updateProduto(produto.getId(), produto);
            redirectAttributes.addFlashAttribute("message", "Produto Atualizado com Sucesso");
        }

        response.sendRedirect("/");
    }

    @GetMapping("/delete")
    public ModelAndView delete(Integer id){

        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("produto", produtoService.obtainById(id));

        return mav;
    }

    @PostMapping("/delete")
    public void submitDelete(@ModelAttribute("produto") ProdutoDTO produto,
                                                          BindingResult result,
                                                          ModelMap modelMap,
                                                          HttpServletResponse response,
                                                          RedirectAttributes redirectAttributes)throws IOException{

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Houve um Erro");
        }else{
            produtoService.deleteProdutoById(produto.getId());
            redirectAttributes.addFlashAttribute("message", "Produto Excluído com Sucesso");
        }
        
        response.sendRedirect("/");
    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listProdutos", produtoService.listAll());

        return mav;
    }

}