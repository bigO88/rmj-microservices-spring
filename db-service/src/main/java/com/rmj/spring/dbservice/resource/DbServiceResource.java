package com.rmj.spring.dbservice.resource;


import com.rmj.spring.dbservice.model.Quote;
import com.rmj.spring.dbservice.model.Quotes;
import com.rmj.spring.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")

public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable final String username){

       return getQuotesByUserName(username);

    }

    private List<String> getQuotesByUserName(@PathVariable String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username){
        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotes.stream().forEach(quote ->  quotesRepository.delete(quote));
        return getQuotesByUserName(username);
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes ){

        quotes.getQuotes().stream().map(quote->new Quote(quotes.getUserName(),quote)).forEach(quote -> quotesRepository.save(quote));
       return getQuotesByUserName(quotes.getUserName());

    }


}
