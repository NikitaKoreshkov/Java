package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Создание нового Item
    public Item createItem(Item item) {
        return itemRepository.save(item);  // Сохраняем элемент в базе данных
    }

    // Получение всех Items
    public List<Item> getAllItems() {
        return itemRepository.findAll();  // Получаем все элементы из базы данных
    }

    // Получение Item по ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);  // Получаем элемент по его ID
    }

    // Обновление Item
    public Item updateItem(Long id, Item itemDetails) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            return itemRepository.save(item);  // Обновляем и сохраняем в базу данных
        }
        return null;
    }

    // Удаление Item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);  // Удаляем элемент из базы данных по его ID
    }
}
