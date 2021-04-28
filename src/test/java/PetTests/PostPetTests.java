package PetTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.api.models.Category;
import petstore.api.models.Pet;
import petstore.api.models.Tag;
import petstore.api.services.PetStore.PetStore;
import petstore.api.services.PetStore.PetStoreService;
import retrofit2.Response;

import java.io.IOException;

public class PostPetTests {
    @Test
    @DisplayName("POST /pet: code 200")
    public void happyTest() throws IOException {
        Pet pet = new Pet.Builder(100500, "Акакий")
                .withCategory(new Category(500, "Пингвины"))
                .withTag(new Tag(78, "Севрер"))
                .withPhoto("https://images.app.goo.gl/2auPnNoV5qDvz6Wv6")
                .setStatus("enable")
                .build();

        PetStore petStore = PetStoreService.getInstance().getService();

        Response<Pet> response = petStore.addPet(pet).execute();

        Assertions.assertEquals(200, response.code());
        Assertions.assertEquals(pet, response.body());
    }
}
