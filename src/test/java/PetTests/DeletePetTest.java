package PetTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petstore.api.models.Category;
import petstore.api.models.Pet;
import petstore.api.models.ResponseBody;
import petstore.api.models.Tag;
import petstore.api.services.PetStore.PetStore;
import petstore.api.services.PetStore.PetStoreService;
import retrofit2.Response;

import java.io.IOException;

public class DeletePetTest {
    private long petId = 2020;

    @BeforeEach
    public void beforeEach() throws IOException {
        Pet pet = new Pet.Builder(this.petId, "Акакий")
                .withCategory(new Category(500, "Пингвины"))
                .withTag(new Tag(78, "Севрер"))
                .withPhoto("https://images.app.goo.gl/2auPnNoV5qDvz6Wv6")
                .setStatus("enable")
                .build();

        PetStore petStore = PetStoreService.getInstance().getService();

        Response<Pet> postResponse = petStore.addPet(pet).execute();
    }

    @Test
    @DisplayName("DELETE /pet/{petId}: code 200")
    public void happyTest() throws IOException {
        ResponseBody expectedDeleteResponse = new ResponseBody();
        expectedDeleteResponse.setCode(200);
        expectedDeleteResponse.setType("unknown");
        expectedDeleteResponse.setMessage(this.petId + "");

        PetStore petStore = PetStoreService.getInstance().getService();

        Response<ResponseBody> deleteResponse = petStore.deletePet(this.petId).execute();
        Assertions.assertEquals(200, deleteResponse.code());
        Assertions.assertEquals(expectedDeleteResponse, deleteResponse.body());
    }

    @Test
    @DisplayName("DELETE /pet/{petId}: code 404")
    public void notFoundTest() throws IOException {
        PetStore petStore = PetStoreService.getInstance().getService();

        Response<ResponseBody> preDeleteResponse = petStore.deletePet(this.petId).execute();

        Response<ResponseBody> deleteResponse = petStore.deletePet(this.petId).execute();
        Assertions.assertEquals(404, deleteResponse.code());
    }
}
