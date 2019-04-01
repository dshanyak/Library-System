package com.project.library.service.entityServices;

import com.project.library.DAOs.ItemRepository;
import com.project.library.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    // autowire the ItemRepo
    private ItemRepository itemRepository;
    @Autowired
    public ItemServiceImpl(ItemRepository theItemRepository){itemRepository = theItemRepository;}

    @Override
    public Item findById(int itemId) {
        // Search for the Title based on username
        Optional<Item> result = itemRepository.findById(itemId);

        // In case the user isn't found, throw runtime exception
        Item theItem = null;
        if(result.isPresent()){
            theItem = result.get();
        }
        else {
            throw new RuntimeException("Did not find title id");
        }

        return theItem;
    }

    @Override
    public List<Item> findAll() {return itemRepository.findAll();}

    @Override
    public List<Item> findByTitleContainingIgnoreCase(String search) {
        return itemRepository.findByTitleContainingIgnoreCase(search);
    }

    @Override
    public List<Item> findByAuthorContainingIgnoreCase(String search) {
        return itemRepository.findByAuthorContainingIgnoreCase(search);
    }

    @Override
    public List<Item> findByGenreContainingIgnoreCase(String search) {
        return itemRepository.findByGenreContainingIgnoreCase(search);
    }
}