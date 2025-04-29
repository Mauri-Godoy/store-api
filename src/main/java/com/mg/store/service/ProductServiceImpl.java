package com.mg.store.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.store.dto.ProductDto;
import com.mg.store.entity.Product;
import com.mg.store.mapper.ProductMapper;
import com.mg.store.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

        @Autowired
        private ProductRepository productRepository;

        @Override
        public List<ProductDto> getAllProducts() {
                return productRepository.findAll().stream()
                                .map(product -> ProductMapper.INSTANCE.tDto(product))
                                .toList();
        }

        @Override
        public void insertProducts() {
                Product product1 = new Product(null, "Piedra Filosofal",
                                "Una piedra ancestral, fuente de sabiduría eterna y energía mística. Ideal para decoración zen o rituales secretos.",
                                1200.0, 5, "Artefactos Místicos",
                                "https://images.unsplash.com/photo-1531180488878-b785d2ce8f71");

                Product product2 = new Product(null, "Ladrillo Legendario",
                                "Antiguo ladrillo de una civilización perdida. Su textura única cuenta historias de un pasado glorioso.",
                                850.0, 8, "Reliquias",
                                "https://images.unsplash.com/photo-1707636497375-fa03615149b2?q=80&w=2067&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

                Product product3 = new Product(null, "Hoja de Roble Eterna",
                                "Hoja preservada que nunca se marchita, símbolo de fuerza y resiliencia. Perfecta para coleccionistas naturales.",
                                600.0, 12, "Coleccionables Naturales",
                                "https://images.unsplash.com/photo-1612443925214-a5b233dfc04f?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

                Product product4 = new Product(null, "Trozo de Madera Milenaria",
                                "Fragmento de un árbol milenario, impregnado de la sabiduría de siglos. Ideal para decorar espacios de meditación.",
                                980.0, 7, "Arte Natural",
                                "https://images.unsplash.com/photo-1739914520152-2a7d0c53fe7e?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

                Product product5 = new Product(null, "Botella de Aire Alpino",
                                "Aire puro de las montañas suizas, capturado en su máxima frescura. Revitaliza cuerpo y mente.",
                                750.0,
                                20, "Bienestar",
                                "https://images.unsplash.com/photo-1591704951890-0862b2e98acb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Ym90ZWxsYXxlbnwwfHwwfHx8MA%3D%3D");

                Product product6 = new Product(null, "Arena de Desierto Dorado",
                                "Granulado fino del desierto de Sahara, símbolo de eternidad y cambio constante.",
                                670.0, 15,
                                "Elementos Exóticos",
                                "https://images.unsplash.com/photo-1599671230521-82bcd563b7b9?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTE4fHxhcmVuYXxlbnwwfHwwfHx8MA%3D%3D");

                Product product7 = new Product(null, "Concha Marina Ancestral",
                                "Recolectada en costas olvidadas, esta concha representa la voz eterna del océano.",
                                890.0, 9,
                                "Tesoros del Mar",
                                "https://images.unsplash.com/photo-1714674119460-8b362f2f9840?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Y29uY2hhJTIwbWFyaW5hfGVufDB8fDB8fHww");

                Product product8 = new Product(null, "Hueso de Dragón",
                                "Un fósil de criatura legendaria, cargado de poder mitológico. Pieza infaltable en cualquier colección mística.",
                                2100.0, 3, "Bestiario",
                                "https://images.unsplash.com/photo-1557079795-846ac2fc4508?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fGh1ZXNvJTIwYW5pbWFsfGVufDB8fDB8fHww");

                Product product9 = new Product(null, "Fragmento de Meteorito",
                                "Pedazo auténtico de un meteorito que surcó los cielos hace millones de años. Energía cósmica concentrada.",
                                3200.0, 2, "Objetos Cósmicos",
                                "https://images.unsplash.com/photo-1691744749343-edab1346765a?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

                Product product10 = new Product(null, "Agua de Lluvia Sagrada",
                                "Agua recogida durante una tormenta en un antiguo templo. Se cree que otorga paz y bendiciones.",
                                540.0,
                                25, "Elixires",
                                "https://images.unsplash.com/photo-1616118132534-381148898bb4?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

                List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6,
                                product7,
                                product8, product9, product10);
                productRepository.saveAll(products);
        }

}
