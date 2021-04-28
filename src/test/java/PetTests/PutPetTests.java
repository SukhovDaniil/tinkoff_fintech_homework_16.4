package PetTests;

import org.junit.jupiter.api.*;
import petstore.api.models.Category;
import petstore.api.models.Pet;
import petstore.api.models.ResponseBody;
import petstore.api.models.Tag;
import petstore.api.services.PetStore.PetStore;
import petstore.api.services.PetStore.PetStoreService;
import retrofit2.Response;

import java.io.IOException;

public class PutPetTests {
    private long petId = 2020;
    private Pet pet;

    @BeforeEach
    public void beforeEach() throws IOException {
        this.pet = new Pet.Builder(this.petId, "Акакий")
                .withCategory(new Category(500, "Пингвины"))
                .withTag(new Tag(78, "Севрер"))
                .withPhoto("https://images.app.goo.gl/2auPnNoV5qDvz6Wv6")
                .setStatus("enable")
                .build();

        PetStore petStore = PetStoreService.getInstance().getService();

        Response<Pet> postResponse = petStore.addPet(pet).execute();
    }

    @Test
    @DisplayName("PUT /pet: code 200")
    public void happyTest() throws IOException {
        PetStore petStore = PetStoreService.getInstance().getService();

        this.pet.setName("Евпатий");

        Response<Pet> putResponse = petStore.updatePet(pet).execute();
        Assertions.assertEquals(200, putResponse.code());
        Assertions.assertEquals(this.pet, putResponse.body());
    }

    @Test
    @DisplayName("PUT /pet: code 404")
    public void notFoundTest() throws IOException {
        PetStore petStore = PetStoreService.getInstance().getService();

        Response<ResponseBody> deleteResponse = petStore.deletePet(this.petId).execute();

        Response<Pet> putResponse = petStore.updatePet(pet).execute();
        Assertions.assertEquals(404, putResponse.code());
    }
}
