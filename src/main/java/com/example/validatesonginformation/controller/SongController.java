package com.example.validatesonginformation.controller;

import com.example.validatesonginformation.model.Song;
import com.example.validatesonginformation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public String showList(ModelMap model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(ModelMap model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Successfully created song");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/update")
    public String showUpdateForm(@PathVariable Long id, ModelMap model) {
        Optional<Song> song = songService.findById(id);
        if (song.isPresent()) {
            model.addAttribute("song", song.get());
            return "update";
        }
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Successfully updated song");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Successfully deleted");
        return "redirect:/songs";
    }
}
