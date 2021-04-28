package petstore.api.models;

import java.util.Objects;

public class Tag {
    private long id;
    private String name;

    public Tag() {
    }

    public Tag(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return ID тега.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id ID тега.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return Название тега.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Название тега.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Сравнение тегов.
     *
     * @param o Тег, с которым сравнивается текущий.
     * @return True - одинаковые, False - разные.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) o;
        return id == tag.id && Objects.equals(name, tag.name);
    }

    /**
     * @return Хеш-код тега.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
