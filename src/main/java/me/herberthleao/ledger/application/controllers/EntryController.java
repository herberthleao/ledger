package me.herberthleao.ledger.application.controllers;

import me.herberthleao.ledger.application.dto.EntryCreationData;
import me.herberthleao.ledger.application.services.EntryApplicationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/entries")
final class EntryController
{
    private EntryApplicationService service;

    public EntryController(EntryApplicationService service)
    {
        this.service = service;
    }

    @PostMapping
    public void createEntry(@Validated @RequestBody EntryCreationData entry)
    {
        this.service.registerEntry(entry);
    }
}
