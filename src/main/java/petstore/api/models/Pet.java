package petstore.api.models;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    /**
     * @return ID питомца.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id ID питомца.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return Категория питомца.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category Категория питомца.
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * @return Имя питомца.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Имя питомца.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return Массив Url фотографий.
     */
    public String[] getPhotoUrls() {
        return photoUrls;
    }

    /**
     * @param photoUrls Массив Url фотографий.
     */
    public void setPhotoUrls(final String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    /**
     * @return Массив тегов.
     */
    public Tag[] getTags() {
        return tags;
    }

    /**
     * @param tags Массив тегов.
     */
    public void setTags(final Tag[] tags) {
        this.tags = tags;
    }

    /**
     * @return Статус питомца.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status Статус питомца.
     */
    public void setStatus(final String status) {
        this.status = status;
    }


    public static class Builder {
        private long id;
        private Category category;
        private String name;
        private String[] photoUrls;
        private Tag[] tags;
        private String status;

        public Builder(final long id, final String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * @param category Категория питомца.
         * @return Builder.
         */
        public Builder withCategory(final Category category) {
            this.category = category;
            return this;
        }

        /**
         * @param tag Тег питомца.
         * @return Builder.
         */
        public Builder withTag(final Tag tag) {
            this.tags = new Tag[]{tag};
            return this;
        }

        /**
         * @param tags Массив тегов питомца.
         * @return Builder.
         */
        public Builder withTags(final Tag[] tags) {
            this.tags = tags;
            return this;
        }

        /**
         * @param photoUrl Url фото питомца.
         * @return Builder.
         */
        public Builder withPhoto(final String photoUrl) {
            this.photoUrls = new String[]{photoUrl};
            return this;
        }

        /**
         * @param photoUrls Массив Url'ов питомца.
         * @return Builder.
         */
        public Builder withPhotos(final String[] photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        /**
         * @param status Статус питомца.
         * @return Builder.
         */
        public Builder setStatus(final String status) {
            this.status = status;
            return this;
        }

        /**
         * @return Pet.
         */
        public Pet build() {
            Pet pet = new Pet();

            pet.setId(this.id);
            pet.setName(this.name);
            pet.setCategory(this.category);
            pet.setStatus(this.status);
            pet.setTags(this.tags);
            pet.setPhotoUrls(this.photoUrls);

            return pet;
        }
    }


    /**
     * Сравнение питомцев.
     *
     * @param o Питомец, с которым сравнивается текущий.
     * @return True - одинаковые, False - разные.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return id == pet.id && category.equals(pet.category) && name.equals(pet.name) && Arrays.equals(photoUrls, pet.photoUrls) && Arrays.equals(tags, pet.tags) && status.equals(pet.status);
    }

    /**
     * @return Хеш-код.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(id, category, name, status);
        result = 31 * result + Arrays.hashCode(photoUrls);
        result = 31 * result + Arrays.hashCode(tags);
        return result;
    }
}
