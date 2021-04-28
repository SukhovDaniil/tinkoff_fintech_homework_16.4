package petstore.api.services.PetStore;

import petstore.api.models.Pet;
import petstore.api.models.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface PetStore {
    @POST("/v2/pet")
    Call<Pet> addPet(@Body Pet pet);

    @GET("/v2/pet/{petId}")
    Call<Pet> findPetBuId(@Path("petId") long petId);

    @PUT("/v2/pet")
    Call<Pet> updatePet(@Body Pet pet);

    @DELETE("/v2/pet/{petId}")
    Call<ResponseBody> deletePet(@Path("petId") long petId);
}
