package cn.coding.com.exchangerates.controller;

import cn.coding.com.exchangerates.model.ExchangeRate;
import cn.coding.com.exchangerates.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/exchange-rates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/list")
    public String showExchangeRateList(Model model) {
        List<ExchangeRate> rateList = exchangeRateService.exchangeRates();
        model.addAttribute("rateList", rateList);
        return "/exchange_rate/exchange-rate-list";
    }

    @GetMapping("/new")
    public String showNewRate(Model model) {
        model.addAttribute("rate", new ExchangeRate());
        model.addAttribute("pageTitle", "Add New Rate");
        return "/exchange_rate/add-exchange-rate";
    }

    @PostMapping("/save")
    public String saveExchangeRate(ExchangeRate rate, RedirectAttributes redirectAttributes) {
        exchangeRateService.save(rate);
        redirectAttributes.addFlashAttribute("message", "New Rate Add Successfully!");
        return "redirect:/exchange-rates/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable ("id") Long id, Model model, RedirectAttributes redirect) {
        try {
            ExchangeRate rate = exchangeRateService.getById(id);
            model.addAttribute("rate", rate);
            model.addAttribute("pageTitle", "Edit Rate (ID: " + id + ")");
            redirect.addFlashAttribute("message", "ExchangeRate is Updated.");
            return "exchange_rate/add-exchange-rate";
        } catch (Exception exc) {
            redirect.addFlashAttribute("message", exc.getMessage());
            return "redirect:/exchange-rates/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRate(@PathVariable("id") Long id, RedirectAttributes redirect) {
        try {
            exchangeRateService.deleteById(id);
            redirect.addFlashAttribute("message", "ExchangeRate with ID " + id + "has been Deleted!");
        } catch (Exception exc) {
            redirect.addFlashAttribute("message", exc.getMessage());
        }
        return "redirect:/exchange-rates/list";
    }
}
