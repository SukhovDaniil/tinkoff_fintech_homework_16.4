package petstore.api.services.PetStore;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class PetStoreService {

    private static final String BASE_URL = "https://petstore.swagger.io/";

    private static PetStore petStore;
    private static PetStoreService instance;

    private PetStoreService() {
    }

    public static PetStoreService getInstance() {
        if (instance == null) {
            instance = new PetStoreService();
        }
        return instance;
    }

    /**
     * @return Объект api-сервиса PetService.
     */
    public PetStore getService() {
        if (petStore == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            petStore = retrofit.create(PetStore.class);
        }
        return petStore;
    }
}
