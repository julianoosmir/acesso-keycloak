package tutorial.dto;

public interface HasMaskedField {

    default String removeMask(String field) {
        if (field == null) {
            return null;
        }
        return field.replaceAll("\\D", "");
    }

}
