package petstore.api.models;

import java.util.Objects;

public class Category {
    private long id;
    private String name;

    public Category() {
    }

    public Category(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return ID категории.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id ID категории.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return Название категории.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Название категории.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Сравнение категорий.
     *
     * @param o Категория, с которой сравнивается текущая.
     * @return True - одинаковые, False - разные.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name);
    }

    /**
     * @return Хэш-код категории.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
