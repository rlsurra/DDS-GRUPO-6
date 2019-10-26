package ar.edu.utn.frba.dds.model.prenda;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.awt.*;

@Converter
public class ColorJpaConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getRed() + "|" +
                attribute.getGreen() + "|" +
                attribute.getBlue() + "|" +
                attribute.getAlpha();
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        String[] colors = dbData.split("|");
        try {
            return new Color(
                    Integer.parseInt(colors[0]),
                    Integer.parseInt(colors[1]),
                    Integer.parseInt(colors[2]),
                    Integer.parseInt(colors[3]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
