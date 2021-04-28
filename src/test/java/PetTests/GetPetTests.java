package PetTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

public class GetPetTests {
    private static long petId = 34;
    private static Pet pet;

    @BeforeAll
    public static void beforeAll() throws IOException {
        pet = new Pet.Builder(petId, "Tuzik")
                .withPhoto("photoUrl")
                .withTag(new Tag(1, "No tag"))
                .withCategory(new Category(123, "Panda"))
                .setStatus("enable")
                .build();

        PetStore petStore = PetStoreService.getInstance().getService();

        Response<Pet> postResponse = petStore.addPet(pet).execute();
    }
    @Test
    @DisplayName("GET /pet/{petId}: code 200")
    public void happyTest() throws IOException {
        PetStore petStore = PetStoreService.getInstance().getService();

        Response<Pet> getResponse = petStore.findPetBuId(petId).execute();
        Assertions.assertEquals(200, getResponse.code());
        Assertions.assertEquals(pet, getResponse.body());

    }

    @Test
    @DisplayName("GET /pet/{petId}: code 404")
    public void noFoundTest() throws IOException {
        PetStore petStore = PetStoreService.getInstance().getService();

        Response<ResponseBody> deleteResponse = petStore.deletePet(petId).execute();

        Response<Pet> getResponse = petStore.findPetBuId(petId).execute();
        Assertions.assertEquals(404, getResponse.code());

    }
}
